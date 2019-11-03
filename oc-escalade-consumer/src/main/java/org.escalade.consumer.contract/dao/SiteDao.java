package org.escalade.consumer.contract.dao;

import org.escalade.model.bean.Compte;
import org.escalade.model.bean.Site;

import java.util.List;

public interface SiteDao {

        List<Site> sites();

        void addSite(Site site, Compte compte);

        Site site(Integer site_id);

        void delSite(Integer id);

        void upSite(Site site);

        List<Site> sitesByAdvancedSearchDao(String regionSelect, String typeVoieSelect, String cotationVoieSelect);

        List<Site> siteBySimpleSearchDao(String motCleRecherche);

        List<Site> searchSiteBySectorDao(Integer site_id);

        List<Site> listSitesByAccountDao(Compte compte);

        Site recoversSiteWorkflowDao(Site site, Compte compte);

}
