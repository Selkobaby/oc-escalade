<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<body>

<section>
    <%@include file="../_include/user_menu.jsp"%>

    <div class="container" style="border-style: solid; border-color: #DCDCDC; border-width: 2px; border-radius: 10px;
        margin-top: 1%; box-shadow: 6px 6px 14px #DCDCDC">

        <div class="row">
            <div class="col-md-12" style="text-align: center; margin-top: 1%">
                <h4>Création d'un nouveau SECTEUR</h4>
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-md-10">
                <s:form action="new_secteur">

                <div class="form-group">
                    <label for="selectSite" requiredLabel="true">Sélectionnez un site d'escalade</label>
                    <select id="selectSite" name="siteNomRegion" required="true" class="form-control">
                        <s:iterator value="listSites">
                            <option><s:property value="nom"/> - <s:property value="region"/></option>
                    </s:iterator>
                    </select>
                </div>

                <div class="form-group">
                    <label for="inputNomSecteur" requiredLabel="true">Nom du Secteur</label>
                    <input id="inputNomSecteur" name="secteur.nom" class="form-control" required="true"/>
                </div>

                <div class="form-group">
                    <label for="textareaDescriptionSecteur">Description du secteur</label>
                    <textarea name="secteur.description" id="textareaDescriptionSecteur" rows="5" class="form-control"
                              style="width: 100%"></textarea>
                </div>
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-md-5">
                <button class="btn btn-primary" type="submit" style="width: 100%">Validez</button>
            </div>
            <div class="col-md-5">
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#secteurModal"
                        style="width: 100%">Annuler</button>
            </div>
        </div>
        </s:form>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="secteurModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Annulez la création d'un nouveau secteur</h5>
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
