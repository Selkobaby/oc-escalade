<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>

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

    <div class="container" style="margin-top: 1%; border-style: solid; border-color: #DCDCDC; border-width: 2px;
border-radius: 10px; box-shadow: 6px 6px 14px #DCDCDC">

        <div class="row">
            <div class="col-md-12" style="margin-top: 10px; margin-bottom: 10px; text-align: center">
                <h4>Détail du site : <s:property value="site.nom"/></h4>
                <hr width="100%" color="#DCDCDC">
            </div>
        </div>

        <div class="row">
            <div class="col-md-10">
                <div class="well well-md">
                    <p>Région : <s:property value="site.region"/></p>
                    <p>Description : <s:property value="site.description"/></p>
                </div>
            </div>
        </div>
        <hr width="100%" color="#DCDCDC">

        <div class="row">
            <div class="col-md-12">
                <h4>Secteurs</h4>
            </div>
        </div>

        <s:iterator value="site.listSecteurs">
            <div class="row">
                <div class="col-md-10">
                    <div class="well well-md">
                        <h6>Nom du secteur : <s:property value="nom"/></h6>
                        <p>Description : <s:property value="description"/></p>
                    </div>
                </div>
                <div class="col-md-5 offset-md-9">
                    <s:a action="secteur_detail" class="btn btn-outline-info" role="button">
                        <s:param value="id" name="secteur.id"/>
                        Détail du secteur
                    </s:a>
                </div>
            </div>
            <hr width="100%" color="#DCDCDC">
        </s:iterator>
    </div>
    <div class="container" style="margin-top: 1%; border-style: solid; border-color: #DCDCDC; border-width: 2px;
border-radius: 10px; box-shadow: 6px 6px 14px #DCDCDC">
        <div class="row">
            <div class="col-md-12">
                <h4 style="text-align: center">Commentaires</h4>
            </div>
        </div>

        <s:if test="%{site.commentaires.isEmpty()}">
            <p style="text-align: center">Ce site n'a pas encore de commentaires !</p>
        </s:if>
        <s:else>
            <s:iterator value="site.commentaires">
                <div class="row justify-content-center">
                    <div class="col-md-10">
                        <div class="alert alert-info" role="alert" style="padding: 1%; margin-top: 1%">
                            <p><s:property value="commentaire"/></p>
                        </div>
                    </div>
                </div>
            </s:iterator>
        </s:else>

        <hr width="100%" color="#DCDCDC">
        <div class="row">
            <div class="col-md-12">
                <h4 style="text-align: center">Laissez un commentaire</h4>
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-md-10">
                <s:form action="site_commentaire">
                    <div class="form-group">
                        <label for="textareaDescriptionSite">Commentaire</label>
                        <textarea name="commentaire.commentaire" id="textareaDescriptionSite" rows="5" class="form-control"></textarea>
                    </div>

                    <s:if test="#session.user">
                        <div class="col-md-3">
                            <button type="submit" class="btn btn-outline-primary" style="width: 100%">Envoyez</button>
                        </div>
                    </s:if>
                    <s:if test="!#session.user">
                        <div class="col-md-3">
                            <button type="button" data-toggle="modal" data-target="#commentaire"
                                    class="btn btn-outline-primary" style="width: 100%">Envoyez</button>
                        </div>
                    </s:if>
                </s:form>
            </div>
        </div>

    </div>

    <!-- Modal -->
    <div class="modal fade" id="commentaire" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Commentaire site</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>Attention vous devez posséder un compte pour laisser un commentaire !</p>
                    <p style="text-align: center">
                        <s:a action="login">
                            <label for="connexion">Déjà inscrit ? </label>
                            <button id="connexion" type="button" class="btn btn-primary">Connexion</button>
                        </s:a>
                    </p>
                    <p style="text-align: center">
                        <s:a action="creerCompte">
                            <label for="creer_compte">Nouvel utilisateur : </label>
                            <button id="creer_compte" type="button" class="btn btn-primary">Créer un compte</button>
                        </s:a>
                    </p>
                </div>
                <div class="modal-footer">
                    <p style="text-align: center">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Annulez</button>
                    </p>
                </div>
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
