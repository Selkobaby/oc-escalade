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
                <h2>Longueurs de la voie : <s:property value="%{voie.nom}"/></h2>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <hr width="80%" color="#DCDCDC">
            </div>
        </div>

        <s:if test="%{!listLongueur.isEmpty()}">
            <div class="row justify-content-center">
                <div class="col-md-10" style="margin-top: 1%">
                    <table class="table table-bordered">
                        <thead>
                        <tr class="table-primary">
                            <th style="text-align: center" scope="col">Longueur</th>
                            <th style="text-align: center" scope="col">Hauteur</th>
                            <th style="text-align: center" scope="col">Cotation</th>
                            <th style="text-align: center" scope="col">Relai</th>
                        </tr>
                        </thead>
                        <s:iterator value="listLongueur">
                            <tbody>
                            <tr>
                                <td style="text-align: center" scope="row">N° <s:property value="num_longueur"/></td>
                                <td style="text-align: center"><s:property value="hauteur"/> Mètre(s)</td>
                                <td style="text-align: center"><s:property value="cotation"/></td>
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

            <div class="row justify-content-end">
                <div class="col-md-5">

                    <s:a  action="voies_by_account">
                        <button type="button" class="btn btn-outline-primary">Retour</button>
                    </s:a>

                    <s:a  action="new_longueur">
                        <s:param name="voie.id" value="%{voie.id}"/>
                        <button type="button" class="btn btn-outline-primary">Ajouter</button>
                    </s:a>

                    <s:a  action="modified_longueur">
                        <s:param name="" value=""/>
                        <button type="button" class="btn btn-outline-primary">Modifier</button>
                    </s:a>

                    <s:a action="del_longueur">
                        <s:param name="voie.id" value="%{voie.id}"/>
                        <button type="button" class="btn btn-outline-danger">Supprimer un relai</button>
                    </s:a>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <hr width="80%" color="#DCDCDC">
                </div>
            </div>
        </s:if>
        <s:else>
            <div class="row">
                <div class="col-md-12" style="text-align: center">
                    <p>Cette voie n'a pas encore de longueurs !</p>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <hr width="80%" color="#DCDCDC">
                </div>
            </div>

            <div class="row justify-content-center">

                <div class="col-md-5">
                    <s:a  action="voies_by_account">
                        <button type="button" style="width: 100%" class="btn btn-outline-secondary">Retour</button>
                    </s:a>
                </div>
                <div class="col-md-5" >
                    <s:a  action="new_longueur">
                        <s:param name="voie.id" value="%{voie.id}"/>
                        <button type="button" style="width: 100%" class="btn btn-success">Ajouter</button>
                    </s:a>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <hr width="80%" color="#DCDCDC">
                </div>
            </div>
        </s:else>
    </div>
</section>

<footer>
    <%@include file="../_include/footer.jsp"%>
</footer>

</body>
</html>
