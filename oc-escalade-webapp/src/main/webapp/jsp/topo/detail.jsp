<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <s:if test="!#session.user">
        <%@include file="../_include/head.jsp"%>
    </s:if>
</head>

<body>
<section>
    <s:if test="!#session.user">
        <%@include file="../_include/header.jsp"%>
    </s:if>
    <s:else>
        <%@include file="../_include/user_menu.jsp"%>
    </s:else>

    <div class="container" style="margin-top: 1%; border-style: solid; border-color: #DCDCDC; border-width: 2px;
border-radius: 10px; box-shadow: 6px 6px 14px #DCDCDC">

        <s:iterator value="topo">

            <div class="row">
                <div class="col-md-12" style="margin-top: 10px; margin-bottom: 10px; text-align: center">
                    <h2>Detail du topos d'éscalades : <s:property value="nom"/></h2>
                    <hr width="90%" color="#DCDCDC">
                </div>
            </div>

            <div class="row justify-content-center">

                <c:forEach var="photo" items="${photoList}">
                    <c:if test="${id == photo.topo_id}">
                        <img src="<c:out value="${photo.url_image}"/>" style="width: 400px; height: 400px"
                             alt="<c:out value="${photo.nom}"/>" class="rounded float-left">
                    </c:if>
                </c:forEach>

                <div class="col-md-10" style="margin-top: 1%">
                    <p>Date d'upload : <s:property value="date_upload"/></p>
                    <p>Desciption : <s:property value="description"/></p>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <hr width="90%" color="#DCDCDC">
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <h3 style="text-align: center">Reservation topo</h3>
                    <hr width="80%" color="#DCDCDC">
                    <p style="text-align: center">Pour réserver le topo cliquez sur "Demande de réservation", et remplissez le formulaire !</p>
                    <s:if test="%{resaTopoList.isEmpty()}">
                        <p style="text-align: center">Ce topo n'a pas encore de réservations !</p>
                    </s:if>
                    <s:else>
                        <p style="text-align: center">Attention, ce topo est déjà réservé pour les dates suivantes : </p>
                        <s:iterator value="resaTopoList">
                            <p style="text-align: center">Début de la réservation : <s:property value="date_debut"/> / Fin de la réservation : <s:property value="date_fin"/></p>
                        </s:iterator>
                    </s:else>
                </div>
            </div>

            <div class="row justify-content-center">

                <div class="col-md-3">
                    <s:a action="topo_list">
                        <button type="button" class="btn btn-outline-primary" style="width: 100%">Retour</button>
                    </s:a>
                </div>
                <s:if test="%{!#session.user.id.equals(compte_id) && #session.user}">
                    <div class="col-md-3">
                        <s:a action="resa_topo">
                            <s:param name="topo_id" value="id"/>
                            <button type="button" class="btn btn-outline-primary" style="width: 100%">Demmande de réservation</button>
                        </s:a>
                    </div>
                </s:if>
                <s:if test="!#session.user">
                    <div class="col-md-3">
                        <button type="button" data-toggle="modal" data-target="#reservation"
                                class="btn btn-outline-primary" style="width: 100%">Demmande de réservation</button>
                    </div>
                </s:if>
            </div>
        </s:iterator>

        <div class="row">
            <div class="col-md-12">
                <hr width="80%" color="#DCDCDC">
            </div>
        </div>
    </div>
</section>

<section>
    <div class="container" style="margin-top: 1%; border-style: solid; border-color: #DCDCDC; border-width: 2px;
border-radius: 10px; box-shadow: 6px 6px 14px #DCDCDC">

        <div class="row">
            <div class="col-md-12">
                <h4 style="text-align: center">Commentaires</h4>
                <hr width="80%" color="#DCDCDC">
            </div>
        </div>

        <s:iterator value="topo">
            <div class="row justify-content-center">
                <div class="col-md-10">

                    <s:if test="%{topo.commentaires.isEmpty()}">
                        <p style="text-align: center">Ce topo d'éscalade n'a pas encore de commentaires !</p>
                    </s:if>
                    <s:else>
                        <s:iterator value="commentaires">
                            <div class="alert alert-info" role="alert" style="padding: 1%; margin-top: 1%">
                                <c:forEach var="compte" items="${applicantListAccount}">
                                    <c:if test="${compte.id == compte_id}">

                                        <p>Commentaire poster par : <c:out value="${compte.nom}"/></p>
                                    </c:if>
                                </c:forEach>
                                <p><s:property value="commentaire"/></p>
                            </div>
                        </s:iterator>
                    </s:else>

                </div>
            </div>
        </s:iterator>

        <hr width="100%" color="#DCDCDC">
        <div class="row">
            <div class="col-md-12">
                <h4 style="text-align: center">Laissez un commentaire</h4>
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-md-10">
                <s:form action="topo_commentaire">
                    <div class="form-group">
                        <label for="textareaDescriptionSite">Commentaire</label>
                        <textarea name="commentaire.commentaire" id="textareaDescriptionSite" rows="5" class="form-control"></textarea>
                    </div>

                    <s:if test="#session.user">
                        <div class="col-md-3">
                            <button type="submit" class="btn btn-outline-primary" style="width: 100%">Envoyez</button>
                        </div>
                    </s:if>
                    <s:if test="!#session.user">
                        <div class="col-md-3">
                            <button type="button" data-toggle="modal" data-target="#commentaire"
                                    class="btn btn-outline-primary" style="width: 100%">Envoyez</button>
                        </div>
                    </s:if>
                </s:form>
            </div>
        </div>

    </div>

    <!-- Modal connexion -->
    <div class="modal fade" id="reservation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Réservation topo</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>Attention vous devez posséder un compte pour réserver un topo !</p>
                    <p style="text-align: center">
                        <s:a action="login">
                            <label for="connexion">Déjà inscrit ? </label>
                            <button id="connexion" type="button" class="btn btn-primary">Connexion</button>
                        </s:a>
                    </p>
                    <p style="text-align: center">
                        <s:a action="creerCompte">
                            <label for="creer_compte">Nouvel utilisateur : </label>
                            <button id="creer_compte" type="button" class="btn btn-primary">Créer un compte</button>
                        </s:a>
                    </p>
                </div>
                <div class="modal-footer">
                    <p style="text-align: center">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Annulez</button>
                    </p>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal commentaire -->
    <div class="modal fade" id="commentaire" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Commentaire site</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>Attention vous devez posséder un compte pour laisser un commentaire !</p>
                    <p style="text-align: center">
                        <s:a action="login">
                            <label for="connexion">Déjà inscrit ? </label>
                            <button id="connexion" type="button" class="btn btn-primary">Connexion</button>
                        </s:a>
                    </p>
                    <p style="text-align: center">
                        <s:a action="creerCompte">
                            <label for="creer_compte">Nouvel utilisateur : </label>
                            <button id="creer_compte" type="button" class="btn btn-primary">Créer un compte</button>
                        </s:a>
                    </p>
                </div>
                <div class="modal-footer">
                    <p style="text-align: center">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Annulez</button>
                    </p>
                </div>
            </div>
        </div>
    </div>

</section>

<footer>
    <%@include file="../_include/footer.jsp"%>
    <s:if test="!#session.user">
        <%@include file="../_include/scripts.jsp"%>
    </s:if>
</footer>

</body>
</html>
