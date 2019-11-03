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
                <h2>Modification d'un Topo !</h2>
            </div>
        </div>

        <div class="row justify-content-center">

            <s:if test="#session.photo">
            <img src="<s:property value="#session.photo.url_image"/>" style="width: 200px; height: 200px"
                 alt="<s:property value="#session.photo.nom"/>" class="rounded float-left">
            </s:if>

            <div class="col-md-10">

                <s:form action="modified_topo" method="post" enctype="multipart/form-data">

                    <div class="form-group">
                        <label for="inputNomTopo">Entrez le nom du topo</label>
                        <input id="inputNomTopo" name="modifiedTopo.nom" type="text" value="<s:property value="#session.topo.nom"/>"
                               class="form-control" required="true">
                    </div>

                    <hr width="100%" color="#DCDCDC">

                    <label for="fileTopo">Choisissez une photo de topo ou modifiez la photo existante !</label>
                    <div class="form-group">
                        <input type="file" name="upload" id="fileTopo" accept="image/jpeg" style="display: inline-block; align-items: center"/>
                    </div>

                    <s:if test="hasActionErrors()">
                        <p style="color: red">Attention la photoDao est trop volumineuse, 10 Mo maxi !</p>
                    </s:if>

                    <hr width="100%" color="#DCDCDC">

                    <div class="form-group">
                        <label for="textareaDescriptionSite">Description du site</label>
                        <textarea name="modifiedTopo.description" id="textareaDescriptionSite" rows="5"
                                  class="form-control"><s:property value="#session.topo.description"/></textarea>
                    </div>

                    <div class="row justify-content-center">
                        <div class="col-md-5">
                            <button type="submit" class="btn btn-primary" style="width: 100%">Validez</button>
                        </div>
                        <div class="col-md-5">
                            <!-- Button trigger modal -->
                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#cancelTopo"
                                    style="width: 100%">Annuler</button>
                        </div>
                    </div>
                </s:form>
            </div>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="cancelTopo" tabindex="-1" role="dialog" aria-labelledby="modyfTopoModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Annulez la modification du topo</h5>
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
                    <s:a action="topo_by_account">
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
