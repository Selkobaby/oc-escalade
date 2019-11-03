package org.escalade.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.escalade.business.contract.ManagerFactory;
import org.escalade.business.impl.manager.PhotoManagerImpl;
import org.escalade.business.impl.manager.TopoManagerImpl;
import org.escalade.model.bean.Commentaire;
import org.escalade.model.bean.Compte;
import org.escalade.model.bean.Photo;
import org.escalade.model.bean.ResaTopo;
import org.escalade.model.bean.Topo;


import javax.inject.Inject;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TopoAction extends ActionSupport implements SessionAware {

    private static final long serialVersionUID = 1L;

    private Integer TAILLE_TAMPON = 10240;
    private String CHEMIN_FICHIERS = "E:/PARCOURS DÉVELOPPEUR D'APPLICATION JAVA/PROJET 6 - CREEZ UN SITE COMMUNAUTAIRE AUTOUR DE L’ESCALADE/OC-PROJET-6-SITE-WEB-ESCALADE/oc_escalade_application/escalade-webapp/src/main/webapp/imgs/";

    // =============== Attributs ===============
    private Integer topo_id;
    private Date date_upload;
    private File file;
    private String contentType;
    private String filename;
    private Commentaire commentaire;


    // ----- Eléments en sortie -----
    private List<Topo> topos;
    private Topo topo;
    private Photo photo;
    private List<Photo> photoList;
    private List<Commentaire> commentaireList;
    private Topo modifiedTopo;
    private List<Compte> compteList;
    private List<ResaTopo> resaTopoList;

    // ----- Eléments Struts
    private Map<String, Object> session;

    @Inject
    private ManagerFactory managerFactory;

    // ============ Getters/Setters ============

    public Integer getTopo_id() {
        return topo_id;
    }

    public void setTopo_id(Integer topo_id) {
        this.topo_id = topo_id;
    }

    public Date getDate_upload() {
        return date_upload;
    }

    public void setDate_upload(Date date_upload) {
        this.date_upload = date_upload;
    }

    public void setUpload(File file) {
        this.file = file;
    }

    public void setUploadContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setUploadFileName(String filename) {
        this.filename = filename;
    }

    public List<Topo> getTopos() {
        return topos;
    }

    public void setTopos(List<Topo> topos) {
        this.topos = topos;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public List<Photo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }

    public List<Commentaire> getCommentaireList() {
        return commentaireList;
    }

    public void setCommentaireList(List<Commentaire> commentaireList) {
        this.commentaireList = commentaireList;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Topo getModifiedTopo() {
        return modifiedTopo;
    }

    public void setModifiedTopo(Topo modifiedTopo) {
        this.modifiedTopo = modifiedTopo;
    }

    public List<Compte> getCompteList() {
        return compteList;
    }

    public void setCompteList(List<Compte> compteList) {
        this.compteList = compteList;
    }

    public List<ResaTopo> getResaTopoList() {
        return resaTopoList;
    }

    public void setResaTopoList(List<ResaTopo> resaTopoList) {
        this.resaTopoList = resaTopoList;
    }

    public Commentaire getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(Commentaire commentaire) {
        this.commentaire = commentaire;
    }

    // =============== Méthodes ================

    /**
     * Action listant les {@link Topo}
     * @return success
     */
    public String doList(){

        String vResult = null;

        try{

            /**@see TopoManagerImpl#topos() */
            topos = managerFactory.getTopoManager().topos();

            /**@see PhotoManagerImpl#listPhotosByTopos(List) */
            photoList = managerFactory.getPhotoManager().listPhotosByTopos(topos);

            vResult = ActionSupport.SUCCESS;

        } catch (Exception pEX){

        }

        return vResult;
    }

    /**
     * Action affichant les détails d'un {@Topo}
     * @return success / error
     */
    public String doDetail(){

        String vResult = null;

            try {

                topo = (Topo) this.session.get("topo");

                /**@see TopoManagerImpl#topo(Integer) */
                topo = managerFactory.getTopoManager().topo(topo_id);
                this.session.put("topo", topo);

                /**@see org.escalade.business.impl.manager.ResaTopoManagerImpl#resaTopos(Integer)*/
                resaTopoList = managerFactory.getResaTopoManager().resaTopos(topo.getId());

                /**@see org.escalade.business.impl.manager.CompteManagerImpl#compteByCommentaires(List) */
                compteList = managerFactory.getCompteManager().compteByCommentaires(topo.getCommentaires());

                /**@see PhotoManagerImpl#listPhotosOneTopo(Integer)*/
                photoList = managerFactory.getPhotoManager().listPhotosOneTopo(topo.getId());

                vResult = ActionSupport.SUCCESS;

            } catch (Exception pEX) {
                this.addActionError("Topo non trouvé. ID = " + topo_id);
            }


        return vResult;
    }

    /**
     * Action pour aouter un topo
     * @return
     */
    public String newTopo() throws IOException  {

        String vResult = ActionSupport.INPUT;

        String nomPhoto = filename;
        String url_image = "imgs/" + filename;

        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            dateFormat.format(date);
            topo.setDate_upload(date);

            topo.setStatut("libre");


            /**@see org.escalade.business.impl.manager.TopoManagerImpl#addTopo(Topo, Compte)*/
            managerFactory.getTopoManager().addTopo(topo, (Compte) this.session.get("user"));

            if (nomPhoto != null) {

                /**@see org.escalade.business.impl.manager.TopoManagerImpl#recoversTopoForId(Compte, Topo)*/
                topo = managerFactory.getTopoManager().recoversTopoForId((Compte) this.session.get("user"), topo);

                nomPhoto = topo.getNom();

                /**@see PhotoManagerImpl#addPhoto(Topo, String, String)*/
                managerFactory.getPhotoManager().addPhoto(topo, nomPhoto, url_image);

                BufferedInputStream entree = null;
                BufferedOutputStream sortie = null;

                try {

                    entree = new BufferedInputStream(new FileInputStream((file)));
                    sortie = new BufferedOutputStream(new FileOutputStream(new File(CHEMIN_FICHIERS + filename)), TAILLE_TAMPON);

                    byte[] tampon = new byte[TAILLE_TAMPON];
                    int longueur;

                    while ((longueur = entree.read(tampon)) > 0) {
                        sortie.write(tampon, 0, longueur);
                    }

                } finally {
                    try {
                        sortie.close();
                    } catch (IOException ignore) {
                    }
                    try {
                        entree.close();
                    } catch (IOException ignore) {
                    }
                }

            }

            vResult = ActionSupport.SUCCESS;

        } catch(NullPointerException pEX){

        }

        return vResult;
    }

    public String topoByAccount(){
        String vResult = null;

        try {

            /**@see org.escalade.business.impl.manager.TopoManagerImpl#topoByAccount(Compte)*/
           topos =  managerFactory.getTopoManager().topoByAccount((Compte) this.session.get("user"));

           /**@see org.escalade.business.impl.manager.CommentaireManagerImpl#commentairesByTopo(List)*/
           commentaireList = managerFactory.getCommentaireManager().commentairesByTopo(topos);

           /**@see PhotoManagerImpl#listPhotosByTopos(List) */
            photoList = managerFactory.getPhotoManager().listPhotosByTopos(topos);

            vResult = ActionSupport.SUCCESS;

        } catch (Exception pEX){
            this.addActionError("Une erreur s'est produite, veuillez réessayer plus tard!");
        }

        return vResult;
    }

    public String delTopo(){
        String vResult = null;

        try {

            /**@see PhotoManagerImpl#photo(Integer)*/
            photoList = managerFactory.getPhotoManager().listPhotosOneTopo(topo_id);

            /**@see org.escalade.business.impl.manager.TopoManagerImpl#delTopo(Integer)*/
            managerFactory.getTopoManager().delTopo(topo_id);

            /**@see PhotoManagerImpl#delPhotoTopo(Integer)*/
            managerFactory.getPhotoManager().delPhotoTopo(topo_id);

            vResult = ActionSupport.SUCCESS;

        } catch (Exception pEX){
            this.addActionError("Une erreur s'est produite, veuillez réessayer plus tard!");
        }

        return vResult;
    }

    public String upTopo(){

        String vResult = ActionSupport.INPUT;

        String nomPhoto = filename;

        try{

            topo = (Topo) this.session.get("topo");

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            dateFormat.format(date);
            modifiedTopo.setDate_upload(date);

            topo_id = topo.getId();
            modifiedTopo.setId(topo_id);
            modifiedTopo.setStatut(topo.getStatut());


            /**@see org.escalade.business.impl.manager.TopoManagerImpl#upTopo(Topo) */
            managerFactory.getTopoManager().upTopo(modifiedTopo);

            if (nomPhoto != null) {

                photo = (Photo) this.session.get("photo");

                if (photo == null){

                    String url_image = "imgs/" + filename;
                    nomPhoto = modifiedTopo.getNom();

                    /**@see PhotoManagerImpl#addPhoto(Topo, String, String)*/
                    managerFactory.getPhotoManager().addPhoto(topo, nomPhoto, url_image);

                } else {
                    photo.setNom(modifiedTopo.getNom());
                    photo.setUrl_image("imgs/" + filename);

                    /**@see PhotoManagerImpl#upPhoto(Photo) */
                    managerFactory.getPhotoManager().upPhoto(photo);
                }

                BufferedInputStream entree = null;
                BufferedOutputStream sortie = null;

                try {

                    entree = new BufferedInputStream(new FileInputStream((file)));
                    sortie = new BufferedOutputStream(new FileOutputStream(new File(CHEMIN_FICHIERS + filename)), TAILLE_TAMPON);

                    byte[] tampon = new byte[TAILLE_TAMPON];
                    int longueur;

                    while ((longueur = entree.read(tampon)) > 0) {
                        sortie.write(tampon, 0, longueur);
                    }

                } finally {
                    try {
                        sortie.close();
                    } catch (IOException ignore) {
                    }
                    try {
                        entree.close();
                    } catch (IOException ignore) {
                    }
                }

            }

            vResult = ActionSupport.SUCCESS;

        } catch (Exception pEX){

            /**@see org.escalade.business.impl.manager.TopoManagerImpl#topo(Integer)*/
            topo = managerFactory.getTopoManager().topo(topo_id);
            this.session.put("topo", topo);

            try {
                /**@see PhotoManagerImpl#photoByTopo(Topo)*/
                photo = managerFactory.getPhotoManager().photoByTopo(topo);
                this.session.put("photo", photo);

            } catch (Exception pIndexOutOfBoundsException){

            }

        }

        return vResult;
    }

    public String topoCommentaire(){

        String vResult = null;

        try {

            topo = (Topo) this.session.get("topo");
            commentaire.setTopo_id(topo.getId());

            /**@see org.escalade.business.impl.manager.CommentaireManagerImpl#addCommentaireTopo(Commentaire, Compte)*/
            managerFactory.getCommentaireManager().addCommentaireTopo(commentaire, (Compte) this.session.get("user"));

            /**@see TopoManagerImpl#topo(Integer) */
            topo = managerFactory.getTopoManager().topo(topo.getId());

            /**@see org.escalade.business.impl.manager.ResaTopoManagerImpl#resaTopos(Integer)*/
            resaTopoList = managerFactory.getResaTopoManager().resaTopos(topo.getId());

            /**@see org.escalade.business.impl.manager.CompteManagerImpl#compteByCommentaires(List) */
            compteList = managerFactory.getCompteManager().compteByCommentaires(topo.getCommentaires());

            /**@see PhotoManagerImpl#listPhotosOneTopo(Integer)*/
            photoList = managerFactory.getPhotoManager().listPhotosOneTopo(topo.getId());

            vResult = ActionSupport.SUCCESS;

        } catch (Exception pEX){
            this.addActionError("Une erreur s'est produite, veuillez réessayer plus tard!");
        }

        return vResult;
    }

    // ======================== Session =========================
    @Override
    public void setSession(Map<String, Object> pSession) {

        this.session = pSession;
    }
}
