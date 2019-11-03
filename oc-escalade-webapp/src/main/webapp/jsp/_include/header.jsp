<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<div class="container" style="border-style: solid; border-color: #DCDCDC; border-width: 2px;
     border-radius: 10px; margin-top: 10px; box-shadow: 6px 6px 14px #DCDCDC">
    <div class="row align-items-center" style="height: 10%">

        <div class="col-md-3">
           <img src="imgs/oc_escalade.png"/>
        </div>

        <div class="col-md-7 justify-content-start">
            <s:form action="barre_de_recherche" class="nav navbar-form" style="">
                <div class="col-md-10">
                    <input type="search" name="motCleRecherche" class="form-control"
                           placeholder="Rechercher un site d'escalade" required="true"/>
                </div>
                <div class="col-md-1" >
                    <button id="valRecherche" type="submit" style="margin-left: 4px" class="btn btn-primary btn-md">Validez</button>
                </div>
            </s:form>
        </div>

        <div class="col-md-2">
            <div class="dropdown">
                <button type="button" class="btn btn-primary dropdown-toggle"
                        data-toggle="dropdown">Mon compte</button>
                <ul class="dropdown-menu">
                    <s:if test="!#session.user">
                        <li><s:a action="login">Connexion</s:a></li>
                        <li><s:a action="creerCompte">Creer mon compte</s:a></li>
                    </s:if>
                    <s:else>
                        <li><s:a action="management_menu">Gestion Sites</s:a></li>
                        <li><s:a action="modifier_compte_utilisateur">Mes infos perso</s:a></li>
                        <li><s:a action="logout">Déconnexion</s:a></li>
                    </s:else>
                </ul>
            </div>
        </div>
    </div>

    <div class="row justify-content-between align-items-center" style="height: 10%">

        <div class="col-md-6">
            <ul class="nav nav-pills" style="margin-bottom: 8px; margin-left: 5px">
                <li class="nav-link"><s:a action="index" style="color: black; font-weight:bold" >Accueil</s:a></li>
                <li class="nav-link"><s:a action="site_list" style="color: black; font-weight:bold">Liste des Sites</s:a></li>
                <li class="nav-link"><s:a action="topo_list" style="color: black; font-weight:bold">Liste des topos</s:a></li>
                <li class="nav-link"><s:a action="advanced_research" style="color: black; font-weight:bold">Recherche</s:a> </li>
            </ul>
        </div>

        <div class="col-md-4">
            <h5>
                <s:if test="!#session.user">
                    Utilisateur :
                    <s:property value="!#session.user.prenom"/>
                    <s:property value="!#session.user.nom"/><br/>
                </s:if>
            </h5>
        </div>
    </div>
</div>






