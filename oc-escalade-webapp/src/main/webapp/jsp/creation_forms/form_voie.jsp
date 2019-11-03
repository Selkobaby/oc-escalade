<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

</head>
<body>
<section>
    <%@include file="../_include/user_menu.jsp"%>

    <div class="container" style="border-style: solid; border-color: #DCDCDC; border-width: 2px; border-radius: 10px;
        margin-top: 1%; box-shadow: 6px 6px 14px #DCDCDC">

        <div class="row">
            <div class="col-md-12" style="text-align: center; margin-top: 1%">
                <h5>Création d'une nouvelle Voie !</h5>
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-md-10">
                <s:form action="new_voie">
                    <div class="form-group">

                            <label for="selectSite" requiredLabel="true">Sélectionnez un secteur</label>
                            <select id="selectSite" name="secteur.nom" required="true" class="form-control">
                                <s:iterator value="listSecteurs">
                                    <option><s:property value="nom"/></option>
                                </s:iterator>
                            </select>


                        <label for="inputNomVoie">Nom de la voie</label>
                        <input name="voie.nom" id="inputNomVoie" type="text" class="form-control"
                               style="width: 100%" requiredLabel="true" required="true" autofocus>

                        <div class="row align-justify">
                            <div class="col-md-4">
                                <label for="selectTypeVoie">Type de la voie</label>
                                <select name="voie.type_voie" id="selectTypeVoie" required="true" class="form-control">
                                    <c:forEach var="type" items="${listTypesVoie}">
                                        <option><c:out value="${type}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-md-4">
                                <label for="selectCotationVoie">Cotation de la voie</label>
                                <select name="voie.cotation" id="selectCotationVoie" required="true" class="form-control">
                                    <c:forEach var="cotation" items="${cotations}">
                                        <option><c:out value="${cotation}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-md-4">
                                <label for="inputHauteurVoie">Hauteur de la voie</label>
                                <input name="hauteur" id="inputHauteurVoie" type="number" step="0.10"
                                       class="form-control" required="true">
                            </div>
                        </div>

                        <label for="textareaDescriptionVoie">Description du secteur</label>
                        <textarea name="voie.description" id="textareaDescriptionVoie" cols="40" rows="5"
                                  class="form-control" style="width: 100%"></textarea>
                    </div>

                    <div class="row justify-content-center">
                        <div class="col-md-5">
                            <button class="btn btn-primary" type="submit" style="width: 100%">Validez</button>
                        </div>
                        <div class="col-md-5">
                            <!-- Button trigger modal -->
                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#voieModal" style="width: 100%">Annuler</button>
                        </div>
                    </div>
                </s:form>
            </div>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="voieModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Annulez la création d'une nouvelle voie</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Confirmez l'annulation !
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
</section>

<footer>
    <%@include file="../_include/footer.jsp"%>
</footer>

</body>
</html>
