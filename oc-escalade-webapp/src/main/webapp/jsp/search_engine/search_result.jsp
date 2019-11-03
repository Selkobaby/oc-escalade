<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>

<head>
    <s:if test="!#session.user">
        <%@include file="../_include/head.jsp"%>
    </s:if>
</head>

<body>
<section>
    <s:if test="!#session.user">
        <%@include file="../_include/header.jsp"%>
    </s:if>
    <s:else>
        <%@include file="../_include/user_menu.jsp"%>
    </s:else>

    <div class="container" style="border-style: solid; border-color: #DCDCDC; border-width: 2px; border-radius: 10px;
        margin-top: 1%; box-shadow: 6px 6px 14px #DCDCDC">

        <div class="row">
            <div class="col-md-12" style="margin-top: 10px; margin-bottom: 10px; text-align: center">
                <h2>Résultat de votre recherche !</h2>
                <hr width="100%" color="#DCDCDC">
                <s:if test="hasActionMessages()">
                    <h4 style="text-align: center">Désolé ! Aucun site ne correspond à votre recherche :
                        <s:property value="motCleRecherche"/> !</h4>
                </s:if>
            </div>
        </div>

        <s:if test="%{!listSites.isEmpty()}">

            <div class="row">
                <div class="col-md-12">
                    <h3 style="text-align: center">Site(s)</h3>
                    <hr width="90%" color="#DCDCDC">
                </div>
            </div>

            <s:iterator value="listSites">
                <div class="row">
                    <div class="col-md-9">
                        <h6>Nom : <s:property value="nom"/></h6>
                        <p>Région : <s:property value="region"/></p>
                        <p>Description : <s:property value="description"/></p>
                    </div>
                    <div class="col-md-3 align-self-center">
                        <s:a  action="site_detail" class="btn btn-outline-info" role="button">
                            <s:param name="site_id" value="id"/>
                            Voir détail
                        </s:a>
                    </div>
                </div>
                <hr width="80%" color="#DCDCDC">
            </s:iterator>
        </s:if>

        <s:if test="%{!listSecteurs.isEmpty()}">

            <div class="row">
                <div class="col-md-12">
                    <h3 style="text-align: center">Secteur(s)</h3>
                    <hr width="90%" color="#DCDCDC">
                </div>
            </div>

            <s:iterator value="listSecteurs">
                <div class="row">
                    <div class="col-md-9">
                        <h5>Nom : <s:property value="nom"/></h5>
                        <p>Description : <s:property value="description"/></p>
                        <s:iterator value="secteursRefSite">
                            <s:if test="%{site_id.equals(id)}">
                                <p>Nom du site auquel le secteur apartien : <s:property value="nom"/></p>
                            </s:if>
                        </s:iterator>
                    </div>
                    <div class="col-md-3 align-self-center">
                        <s:a  action="site_detail" class="btn btn-outline-info" role="button">
                            <s:param name="site_id" value="site_id"/>
                            Voir détail du site
                        </s:a>
                        <p></p>
                        <s:a  action="secteur_detail" class="btn btn-outline-info" role="button">
                            <s:param name="secteur.id" value="id"/>
                            Voir détail du secteur
                        </s:a>
                    </div>
                </div>
                <hr width="80%" color="#DCDCDC">
            </s:iterator>
        </s:if>

        <s:if test="%{!listVoies.isEmpty()}">

            <div class="row">
                <div class="col-md-12">
                    <h3 style="text-align: center">Voie(s)</h3>
                    <hr width="90%" color="#DCDCDC">
                </div>
            </div>

            <s:iterator value="listVoies">
                <div class="row">
                    <div class="col-md-9">
                        <h5>Nom : <s:property value="nom"/></h5>
                        <p>Description : <s:property value="description"/></p>
                        <p>Type de voie : <s:property value="type_voie"/></p>
                        <p>Cotation : <s:property value="cotation"/> </p>
                    </div>
                    <div class="col-md-3 align-self-center">
                        <s:a action="voie_detail" class="btn btn-outline-info" role="button">
                            <s:param value="id" name="voie_id"/>
                            Détail de la voie
                        </s:a>
                    </div>
                </div>

                <s:iterator value="voiesRefSecteur">
                    <div class="row">
                        <div class="col-md-9">
                            <s:if test="%{secteur_id.equals(id)}">
                                <p>Nom du secteur auquel apartien la voie : <s:property value="nom"/></p>
                            </s:if>
                        </div>
                        <div class="col-md-3 align-self-center">
                            <s:a  action="site_detail" class="btn btn-outline-info" role="button">
                                <s:param name="site_id" value="site_id"/>
                                Voir détail du site
                            </s:a>
                        </div>
                    </div>
                </s:iterator>

                <s:iterator value="voiesRefSecteur">
                    <s:iterator value="voiesRefSecteurRefSite">
                        <div class="row">
                            <div class="col-md-9">
                                <s:if test="%{site_id.equals(id)}">
                                    <p>Nom du site auquel apartien la voie : <s:property value="nom"/> </p>
                                </s:if>
                            </div>
                            <div class="col-md-3 align-self-center">
                                <s:a  action="secteur_detail" class="btn btn-outline-info" role="button">
                                    <s:param name="secteur.id" value="id"/>
                                    Voir détail du secteur
                                </s:a>
                            </div>
                        </div>
                    </s:iterator>
                </s:iterator>
                <hr width="80%" color="#DCDCDC">
            </s:iterator>
        </s:if>

        <div class="row">
            <div class="col-md-12">
                <hr width="90%" color="#DCDCDC">
            </div>
        </div>
    </div>
</section>
<footer>
    <%@include file="../_include/footer.jsp"%>
    <s:if test="!#session.user">
        <%@include file="../_include/scripts.jsp"%>
    </s:if>
</footer>

</body>

</html>
