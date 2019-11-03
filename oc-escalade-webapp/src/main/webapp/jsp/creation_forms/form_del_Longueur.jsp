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
                <h2>Supprimez une longueur !</h2>
                <p>Longueurs et relais correspondants à la voie : <s:property value="#session.voie.nom"/></p>
            </div>
        </div>

        <s:if test="#session.listLongueur">
            <div class="row">
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
                        <s:iterator value="listLongueur">
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
            </div>
        </s:if>
    </div>

    <div class="container" style="margin-top: 1%; border-style: solid; border-color: #DCDCDC; border-width: 2px;
     border-radius: 10px; box-shadow: 6px 6px 14px #DCDCDC">

        <s:form action="del_longueur">
            <div class="row justify-content-center" style="margin-top: 1%">
                <div class="col-md-10">
                    <label for="selectLongueur" style="text-align: center">Sélectionnez la longueur que vous voulez supprimer</label>
                    <select name="longueur.num_longueur" id="selectLongueur" required="true" class="form-control" style="width: 100%">
                        <c:forEach var="numLongueur" items="${listLongueur}">
                            <option><c:out value="${numLongueur.num_longueur}"/></option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="row justify-content-center" style="margin-top: 1%">
                <div class="col-md-5">
                    <button class="btn btn-success" aria-expanded="false" style="width: 100%">Validez</button>
                </div>
                <div class="col-md-5">
                    <button class="btn btn-danger" aria-expanded="false" style="width: 100%">Annuler</button>
                </div>
            </div>
        </s:form>
    </div>

</section>

<footer>
    <%@include file="../_include/footer.jsp"%>
</footer>

</body>
</html>
