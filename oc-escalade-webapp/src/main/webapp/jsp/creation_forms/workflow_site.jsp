<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
    <%@include file="../_include/head.jsp"%>
</head>

<body>

<%@include file="../_include/user_menu.jsp"%>

<div id="configSelectForm"><s:property value="configSelectForm"/></div>

<div class="container" style="border-style: solid; border-color: #DCDCDC; border-width: 2px; border-radius: 10px;
        margin-top: 1%; box-shadow: 6px 6px 14px #DCDCDC">

    <div class="col-md-12" style="text-align: center; margin-top: 2%">
        <h4>Création d'un nouveau listSites d'éscalades</h4>
    </div>

    <%-- =============================== --%>
    <%-- ==== Formulaire navigation ==== --%>
    <%-- =============================== --%>

    <div class="row">
        <div id="navForm" class="col-md-12">
            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a id="navSite" class="nav-link" href="#">Site</a>
                </li>
                <li class="nav-item">
                    <a id="navSecteur"  class="nav-link" href="#">Secteur</a>
                </li>
                <li class="nav-item">
                    <a id="navVoie" class="nav-link" href="#">Voie</a>
                </li>
                <li class="nav-item">
                    <a id="navLongueur" class="nav-link" href="#">Longueurs & Relais</a>
                </li>
            </ul>
        </div>
    </div>

    <%-- ========================= --%>
    <%-- ==== Formulaire Site ==== --%>
    <%-- ========================= --%>

    <div class="row" id="formSite">

        <div class="col-md-12" style="margin-top: 1%">
            <h5>Création d'un nouveau listSites d'éscalades</h5>
        </div>

        <div class="col-md-12">
            <s:form name="complete_creation_climbing_site">
                <div class="form-group">
                    <label for="inputNomSite">Nom du site</label>
                    <input name="site.nom" value="<s:property value="#session.site.nom"/>" id="inputNomSite" type="text"
                           class="form-control" style="width: 100%" required="true" autofocus>
                </div>
                <div class="form-group">
                    <label for="selectRegionSite">Région</label>
                    <select name="site.region" id="selectRegionSite" required="true" class="form-control" style="width: 100%">
                        <s:if test="#session.site">
                            <option selected="selected"><s:property value="#session.site.region"/></option>
                        </s:if>
                        <c:forEach var="region" items="${listRegions}">
                            <option><c:out value="${region}"/></option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="textareaDescriptionSite">Description du site</label>
                    <textarea name="site.description" id="textareaDescriptionSite" rows="5" class="form-control"
                              style="width: 100%"><s:property value="#session.site.description"/></textarea>
                </div>

                <div class="row justify-content">
                    <div class="col-md-6">
                        <select name="configSelectForm" required="true" class="form-control" checked style="display: none">
                            <option>formSite</option>
                        </select>
                        <button id="siteNextStep" class="btn btn-primary" type="submit">Suivant</button>
                    </div>
                    <!-- Button trigger modal -->
                    <div class="col-md-6">
                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#annuler">
                            Annuler
                        </button>
                    </div>
                </div>
            </s:form>

        </div>
    </div>


    <%-- ============================== --%>
    <%-- ===== Formulaire secteur ===== --%>
    <%-- ============================== --%>

    <div class="row" id="formSecteur">

        <div class="col-md-12" style="margin-top: 1%">
            <h5>Création d'un nouveau secteur</h5>
        </div>

        <div class="col-md-12">
            <s:form action="complete_creation_climbing_secteur">
                <div class="form-group">

                    <label for="inputNomSecteur">Nom du secteur</label>
                    <input name="secteur.nom" value="<s:property value="#session.secteur.nom"/>"  id="inputNomSecteur"
                           type="text" class="form-control" style="width: 100%" requiredLabel="true" required="true" autofocus>

                    <label for="textareaDescriptionSecteur">Description du secteur</label>
                    <textarea name="secteur.description" id="textareaDescriptionSecteur" cols="40" rows="5"
                              class="form-control" style="width: 100%"><s:property value="#session.secteur.description"/></textarea>
                </div>

                <div class="row justify-content-end">
                    <div class="col-md-6">
                        <select name="configSelectForm" required="true" class="form-control" checked style="display: none">
                            <option>formSecteur</option>
                        </select>
                        <button id="secteurNextStep" class="btn btn-primary" type="submit">Suivant</button>
                    </div>
                    <!-- Button trigger modal -->
                    <div class="col-md-6">
                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#annuler">
                            Annuler
                        </button>
                    </div>
                </div>

            </s:form>
        </div>
    </div>

    <%-- =============================== --%>
    <%-- ======= Formulaire voie ======= --%>
    <%-- =============================== --%>

    <div class="row" id="formVoie">

        <div class="col-md-12" style="margin-top: 1%">
            <h5>Création d'une nouvelle Voie !</h5>
        </div>

        <div class="col-md-12">
            <s:form action="complete_creation_climbing_voie">
                <div class="form-group">

                    <label for="inputNomVoie">Nom de la voie</label>
                    <input name="voie.nom" id="inputNomVoie" value="<s:property value="#session.voie.nom"/>"
                           type="text" class="form-control" style="width: 100%" requiredLabel="true" required="true" autofocus>

                    <div class="row align-justify">
                        <div class="col-md-4">
                            <label for="selectTypeVoie">Type de la voie</label>
                            <select name="voie.type_voie" id="selectTypeVoie" required="true" class="form-control">
                                <s:if test="#session.voie">
                                    <option selected="selected"><s:property value="#session.voie.type_voie"/></option>
                                </s:if>
                                <c:forEach var="type" items="${listTypesVoie}">
                                    <option><c:out value="${type}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-4">
                            <label for="selectCotationVoie">Cotation de la voie</label>
                            <select name="voie.cotation" id="selectCotationVoie" required="true" class="form-control">
                                <s:if test="#session.voie">
                                    <option selected="selected"><s:property value="#session.voie.cotation"/></option>
                                </s:if>
                                <c:forEach var="cotation" items="${cotations}">
                                    <option><c:out value="${cotation}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-4">
                            <label for="inputHauteurVoie">Hauteur de la voie</label>
                            <input name="hauteur" id="inputHauteurVoie" value="<s:property value="#session.voie.hauteur"/>"
                                   type="number" step="0.10" class="form-control" required="true">
                        </div>
                    </div>

                    <label for="textareaDescriptionVoie">Description du secteur</label>
                    <textarea name="voie.description" id="textareaDescriptionVoie" cols="40" rows="5" class="form-control"
                              style="width: 100%"><s:property value="#session.voie.description"/></textarea>
                </div>

                <div class="row justify-content-end">
                    <div class="col-md-6">
                        <select name="configSelectForm" required="true" class="form-control" checked style="display: none">
                            <option>formVoie</option>
                        </select>
                        <button id="voieNextStep" class="btn btn-primary" type="submit">Suivant</button>
                    </div>
                    <!-- Button trigger modal -->
                    <div class="col-md-6">
                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#annuler">
                            Annuler
                        </button>
                    </div>
                </div>
            </s:form>

        </div>
    </div>

    <%-- ============================================== --%>
    <%-- ======= Formulaire Longueurs et relais ======= --%>
    <%-- ============================================== --%>
    <div class="row" id="formLongueur">

        <div class="col-md-12" style="margin-top: 1%">
            <h5>Création des longueurs et des relais !</h5>
            <p>Entrez les longueurs et le relais correspondants à la voie : <s:property value="#session.voie.nom"/></p>
        </div>

        <s:if test="#session.listLongueurs">
            <div class="col-md-12">
                <table class="table table">
                    <thead>
                    <tr>
                        <th scope="col">Longueur</th>
                        <th scope="col">Hauteur</th>
                        <th scope="col">Cotation</th>
                        <th scope="col">Relai</th>
                    </tr>
                    </thead>
                    <s:iterator value="longueursRelais">
                        <tbody>
                        <tr>
                            <th id="thNumLongueur" scope="row">N° <s:property value="num_longueur"/></th>
                            <td id="tdHauteur"><s:property value="hauteur"/> Mètre(s)</td>
                            <td td="tdCotation"><s:property value="cotation"/></td>
                            <s:if test="%{num_relai == 0}">
                                <td id="tdNumRelai">Pas de relai</td>
                            </s:if>
                            <s:else>
                                <td id="tdNumRelai">N° <s:property value="num_relai"/></td>
                            </s:else>
                        </tr>
                        </tbody>
                    </s:iterator>
                </table>
            </div>

            <div class="col-md-12" id="divSelectLongueur">
                <div class="d-flex justify-content-center">
                    <button class="btn btn-secondary" data-toggle="collapse" href="#selectLongueurModif" aria-expanded="false"
                            aria-controls="collapseExample" id="buttonSelectLongueurModif" role="button">Cliquez ici pour modifier une longueur</button>
                </div>
            </div>

            <hr width="90%" color="#DCDCDC">
        </s:if>

        <div class="col-md-12" id="formGroupLongueur">
            <s:form action="complete_creation_climbing_longueur">
                <div class="form-group">

                    <div class="row align-justify">
                        <div class="col-md-3">
                            <label for="inputHauteurLongueur">Hauteur de la longueur N° <s:property value="#session.initNumLongueur"/></label>
                            <input name="hauteur" id="inputHauteurLongueur" type="number" step="0.10" class="form-control"
                                   style="width: 100%" required="true" autofocus>
                        </div>
                        <div class="col-md-3">
                            <label for="selectCotationLongueur">Cotation de la longueur</label>
                            <select name="longueur.cotation" id="selectCotationLongueur" required="true" class="form-control"
                                    style="width: 100%">
                                <c:forEach var="cotation" items="${cotations}">
                                    <option><c:out value="${cotation}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-5">
                            <label for="radiosRelaiModif">Relai</label>
                            <fieldset class="form-group" id="radiosRelaiModif">
                                <div class="form-check form-check-inline">
                                    <input name="longueur.num_relai" id="relaiOui" value=1 class="form-check-input" type="radio">
                                    <label class="form-check-label" for="relaiOui">
                                        Oui il y a un relai !
                                    </label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input name="longueur.num_relai" id="relaiNon" value=0 class="form-check-input" type="radio">
                                    <label class="form-check-label" for="relaiNon">
                                        Non il n'y a pas de relai !
                                    </label>
                                </div>
                                <small id="relaiHelp" class="form-text text-muted">
                                    Indiquez s'il y a un relai à la fin de cette longueur !
                                </small>
                            </fieldset>
                        </div>
                        <div class="row align-items-center">
                            <div class="col-md-2" style="margin-right: -1%">
                                <select name="configSelectForm" required="true" class="form-control" checked style="display: none">
                                    <option>formLongueur</option>
                                </select>
                                <button id="addLongueur" class="btn btn-primary" type="submit">Ajouter</button>
                            </div>
                        </div>
                    </div>
                </div>
            </s:form>

            <s:form action="validation_Form">
                <div class="row justify-content-end">

                    <div class="col-md-6">
                        <button id="validateForm" class="btn btn-success" type="submit">Validez</button>
                    </div>

                    <!-- Button trigger modal -->
                    <div class="col-md-6">
                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#annuler">
                        Annuler
                        </button>
                    </div>
                </div>
            </s:form>

        </div>
    </div>

    <!-- collapse select longueur -->
    <div class="collapse" id="selectLongueurModif">
        <div class="card card-body">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-5">
                        <label for="selectLongueur">Sélectionnez la longueur que vous voulez modifier</label>
                        <select id="selectLongueur" required="true" class="form-control" style="width: 100%">
                            <c:forEach var="numLongueur" items="${longueursRelais}">
                                <option><c:out value="${numLongueur.num_longueur}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-2" style="margin-top: 3%">
                        <button class="btn btn-success" data-toggle="collapse" href="#modifiedLongueur" aria-expanded="false"
                                aria-controls="collapseExample" id="buttonValidateSelectLongueur" role="button">Validez
                        </button>
                    </div>
                    <div class="col-md-2" style="margin-top: 3%">
                        <button id="cancelSelect" class="btn btn-danger" >Annuler</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- collapse modifier longueur -->
    <div class="collapse" id="modifiedLongueur">
        <div class="card card-body">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <s:form action="modified_Longueur_workflow">
                            <div id="formGroupLongueurModif" class="form-group">

                                <div class="row align-justify align-items-center">
                                    <div class="col-md-3">
                                        <label for="inputHauteurLongueur">Hauteur de la longueur N° <span id="displayNumLongueurModif"></span></label>
                                        <select name="longueur.num_longueur" required="true" class="form-control" checked style="display: none">
                                            <option id="numLongueurModif"></option>
                                        </select>
                                        <input name="hauteur" id="inputHauteurLongueurModif" type="number" step="0.10"
                                               class="form-control" style="width: 100%" required="true" autofocus>
                                    </div>
                                    <div class="col-md-3">
                                        <label for="selectCotationLongueur">Cotation de la longueur</label>
                                        <select name="longueur.cotation" id="selectCotationLongueurModif" required="true"
                                                class="form-control" style="width: 100%">
                                            <c:forEach var="cotation" items="${cotations}">
                                                <option><c:out value="${cotation}"/></option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col-md-4">
                                        <label for="radiosRelaiModif">Relai</label>
                                        <fieldset class="form-group" id="relaiRadiosModif">
                                            <div class="form-check form-check-inline">
                                                <input name="longueur.num_relai" id="relaiOuiModif" value=1
                                                       class="form-check-input" type="radio">
                                                <label class="form-check-label" for="relaiOui">
                                                    Oui
                                                </label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <input name="longueur.num_relai" id="relaiNonModif" value=0
                                                       class="form-check-input" type="radio">
                                                <label class="form-check-label" for="relaiNon">
                                                    Non
                                                </label>
                                            </div>
                                            <small id="relaiHelpModif" class="form-text text-muted">
                                                Indiquez s'il y a un relai à la fin de cette longueur !
                                            </small>
                                        </fieldset>
                                    </div>
                                    <div class="col-md-2">
                                        <button id="validateModifLongueur" class="btn btn-primary" type="submit">Validez</button>
                                        <p></p>
                                        <button id="cancelModif" class="btn btn-danger" >Annuler</button>
                                    </div>
                                </div>
                            </div>
                        </s:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="annuler" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Quitter le formulaire !</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Confirmez l'annulation de la création d'un nouveau site !
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary"
                        data-dismiss="modal">Annulez</button>
                <s:a action="management_menu">
                    <button type="button" class="btn btn-primary">Confirmez</button>
                </s:a>
            </div>
        </div>
    </div>
</div>

<footer>
    <%@include file="../_include/footer.jsp"%>
    <script src="javaScript/workflow_site.js"></script>
</footer>



</body>

</html>
