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

        <s:if test="%{resaTopo.statut == 'demande en cours'}">
            <div class="row justify-content-center">
                <div class="col-md-9" style="margin-top: 1%">
                    <h2 style="text-align: center">Confirmation de la réservation du topo <s:property value="%{topo.nom}"/></h2>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <hr width="80%" color="#DCDCDC">
                </div>
            </div>

            <div class="row justify-content-center">
                <div class="row justify-content-center">
                    <p style="text-align: center">Votre réservation a bien été pris en compte et a été envoyer ce-jour au propriétaire du topo !</p>
                    <p style="text-align: center">Le temps de réponse et en moyenne de 24 heures !</p>
                    <p style="text-align: center">Vous pouvez consulter et gérer vos demandes dans la partie "réservation topo".</p>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="row justify-content-center">
                    <s:a action="gestion_resa" class="btn btn-success" role="button">
                        Gérer mes réservations
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
            <div class="row justify-content-center">
                <div class="col-md-9" style="margin-top: 1%">
                    <h2 style="text-align: center">Réservation supprimer</h2>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <hr width="80%" color="#DCDCDC">
                </div>
            </div>

            <div class="row justify-content-center">
                <s:if test="%{resaTopo.statut == 'annuler'}">
                <div class="col-md-9" style="margin-top: 1%">
                    <p style="text-align: center">La réservation du topo <s:property value="%{topo.nom}"/>,
                        réservé par <s:property value="%{compte.prenom}"/> <s:property value="%{compte.prenom}"/> a bien été supprimer !</p>
                </div>
                </s:if>
                <s:else>
                    <div class="col-md-9" style="margin-top: 1%">
                        <p style="text-align: center">Votre réservation du topo <s:property value="%{topo.nom}"/>, a bien été supprimer !</p>
                    </div>
                </s:else>
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
