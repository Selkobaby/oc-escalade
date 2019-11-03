<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<body>

<%@include file="../_include/user_menu.jsp"%>

<section>
    <div class="container" style="border-style: solid; border-color: #DCDCDC; border-width: 2px; border-radius: 10px;
        margin-top: 1%; box-shadow: 6px 6px 14px #DCDCDC">

        <div class="row">
            <div class="col-md-12" style="text-align: center; margin-top: 1%">
                <h2>Modifier un site</h2>
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-md-10">
                <s:form name="modifier_site">
                <div class="form-group">
                    <label for="inputNomSite" requiredLabel="true">Nom du Site</label>
                    <input id="inputNomSite" name="modifiedSite.nom" value="<s:property value="%{site.nom}"/>" class="form-control" required="true"/>
                </div>
                <div class="form-group">
                    <label for="selectRegion" requiredLabel="true">Régions</label>
                    <select id="selectRegion" name="modifiedSite.region" required="true" class="form-control">
                        <s:if test="%{!site.region.empty}">
                            <option selected="selected"><s:property value="%{site.region}"/></option>
                        </s:if>
                        <c:forEach var="region" items="${listRegions}">
                            <option><c:out value="${region}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="textareaDescriptionSite">Description du site</label>
                    <textarea name="modifiedSite.description" id="textareaDescriptionSite" rows="5" class="form-control"
                              style="width: 100%"><s:property value="%{site.description}"/></textarea>
                </div>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-md-5">
                <button class="btn btn-primary" type="submit" style="width: 100%">Validez</button>
            </div>
            <div class="col-md-5">
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#siteModal" style="width: 100%">Annuler</button>
            </div>
        </div>
        </s:form>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="siteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Annulez la création d'un nouveau site</h5>
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
                    <s:a action="sites_by_account">
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
