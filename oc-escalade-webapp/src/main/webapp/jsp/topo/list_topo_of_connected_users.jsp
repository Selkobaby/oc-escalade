<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

</head>
<body>
<section>
    <%@include file="../_include/user_menu.jsp"%>

    <div class="container" style="margin-top: 1%; border-style: solid; border-color: #DCDCDC; border-width: 2px;
     border-radius: 10px; box-shadow: 6px 6px 14px #DCDCDC">
        <div class="row">
            <div class="col-md-12" style="text-align: center; margin-top: 1%">
                <h2>Mes Topos d'escalades</h2>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <hr width="80%" color="#DCDCDC">
            </div>
        </div>

        <s:iterator value="topos">
            <div class="row justify-content-center">

                <c:forEach var="photo" items="${photoList}">
                    <c:if test="${id == photo.topo_id}">
                        <img src="<c:out value="${photo.url_image}"/>" style="width: 200px; height: 200px"
                             alt="<c:out value="${photo.nom}"/>" class="rounded float-left">
                    </c:if>
                </c:forEach>

                <div class="col-md-9" style="margin-top: 1%">
                    <ul>
                        <div class="well well-md">
                            <h4>Nom du Topo : <s:property value="nom"/></h4>
                            <p>Date d'upload : <s:property value="date_upload"/></p>
                            <p>Description : <s:property value="description"/></p>
                            <c:forEach var="commentaire" items="${commentaireList}">
                                <c:if test="${commentaire.topo_id == id}">
                                    <p><c:out value="${commentaire.commentaire}"/></p>
                                </c:if>
                            </c:forEach>

                        </div>
                    </ul>
                </div>
            </div>

            <div class="row justify-content-end">
                <div class="col-md-3">
                    <s:a  action="modified_topo">
                        <s:param name="topo_id" value="id"/>
                        <button type="button" class="btn btn-outline-primary">Modifier</button>
                    </s:a>

                    <s:a action="del_Topo" onclick="javascript:return confirm('Confirmez la suppression du topo!');">
                        <s:param name="topo_id" value="id"/>
                        <button type="button" class="btn btn-outline-danger">Supprimer</button>
                    </s:a>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <hr width="95%" color="#DCDCDC">
                </div>
            </div>

        </s:iterator>
    </div>
</section>

<footer>
    <%@include file="../_include/footer.jsp"%>
</footer>

</body>
</html>
