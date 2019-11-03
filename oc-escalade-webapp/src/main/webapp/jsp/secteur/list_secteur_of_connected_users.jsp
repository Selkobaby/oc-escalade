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
            <div class="col-md-12" style="text-align: center;  margin-top: 1%">
                <h2>Mes Secteurs</h2>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <hr width="80%" color="#DCDCDC">
            </div>
        </div>

        <s:iterator value="listSecteurs">
            <div class="row justify-content-center">
                <div class="col-md-9" style="margin-top: 1%">
                    <ul>
                        <div class="well well-md">
                            <h4>Nom du secteur : <s:property value="nom"/></h4>
                            <s:iterator value="listSites">
                                <s:if test="%{id == site_id}">
                                    <p>Nom du site auquel appartient le secteur : <s:property value="nom"/></p>
                                </s:if>
                            </s:iterator>
                            <p>Dscription : <s:property value="description"/></p>
                        </div>
                    </ul>
                </div>
            </div>

            <div class="row justify-content-end">
                <div class="col-md-4">
                    <s:a  action="modified_secteur">
                        <s:param name="secteur_id" value="id"/>
                        <button type="button" class="btn btn-outline-primary">Modifier</button>
                    </s:a>

                    <s:a action="del_Secteur" onclick="javascript:return confirm('Confirmez la suppression du site!');">
                        <s:param name="secteur.id" value="id"/>
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

<footer
<%@include file="../_include/footer.jsp"%>
</footer>

</body>
</html>
