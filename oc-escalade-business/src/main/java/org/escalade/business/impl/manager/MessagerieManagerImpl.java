package org.escalade.business.impl.manager;

import org.escalade.business.contract.manager.MessagerieManager;
import org.escalade.business.impl.AbstractManagerImpl;
import org.escalade.model.bean.Compte;
import org.escalade.model.bean.Messagerie;


public class MessagerieManagerImpl extends AbstractManagerImpl implements MessagerieManager {

    public void addMessage (Messagerie message, Compte compte){

        /**@see org.escalade.consumer.contact.impl.dao.MessagerieImpl#addMessage(Messagerie, Compte)*/
        getDaoFactory().getMessagerieDao().addMessage(message, compte);

    }

}
