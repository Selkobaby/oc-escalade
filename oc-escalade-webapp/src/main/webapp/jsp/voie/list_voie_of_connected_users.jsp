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
                <h2>Mes Voies d'éscalades</h2>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12" style="text-align: center; margin-top: 1%">
                <p> <s:actionmessage/></p>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <hr width="80%" color="#DCDCDC">
            </div>
        </div>

        <s:iterator value="listVoies">
            <div class="row justify-content-center">
                <div class="col-md-9" style="margin-top: 1%">
                    <ul>
                        <div>
                            <h4>Nom de la voie : <s:property value="nom"/></h4>
                            <p>Dscription : <s:property value="description"/></p>
                            <s:iterator value="listSecteurs">
                                <s:if test="%{id == secteur_id}">
                                    <p>Nom du secteur de la voie : <s:property value="nom"/></p>
                                </s:if>
                            </s:iterator>
                            <table class="table table-bordered">
                                <thead>
                                <tr class="table-primary">
                                    <th style="text-align: center" scope="col">Type de voie</th>
                                    <th style="text-align: center" scope="col">Cotation</th>
                                    <th style="text-align: center" scope="col">Hauteur</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td style="text-align: center"><s:property value="type_voie"/></td>
                                    <td style="text-align: center"><s:property value="cotation"/></td>
                                    <td style="text-align: center"><s:property value="hauteur"/> mètre</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </ul>
                </div>
            </div>

            <div class="row justify-content-end">
                <div class="col-md-6">

                    <s:a  action="longueur_by_voie">
                        <s:param name="voie.id" value="id"/>
                        <button type="button" class="btn btn-outline-primary">Afficher les longueurs</button>
                    </s:a>

                    <s:a  action="modified_voie">
                        <s:param name="voie_id" value="id"/>
                        <button type="button" class="btn btn-outline-primary">Modifier</button>
                    </s:a>

                    <s:a action="del_voie" onclick="javascript:return confirm('Confirmez la suppression du site!');">
                        <s:param name="voie.id" value="id"/>
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
