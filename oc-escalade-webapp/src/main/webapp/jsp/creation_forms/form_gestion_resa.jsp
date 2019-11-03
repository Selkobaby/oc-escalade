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
                <h2>Gestion des réservations</h2>
            </div>
        </div>

        <div>
            <p><s:actionerror/></p>
        </div>

        <div class="row">
            <div class="col-md-12">
                <hr width="80%" color="#DCDCDC">
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-md-9" style="border-style: solid; border-color: #DCDCDC; border-width: 2px; border-radius: 10px;
                 margin-top: 1%; margin-top: 1%">

                <h4 style="text-align: center">Demande de réservations</h4>

                <s:if test="%{!applicantResaTopoList.isEmpty()}">

                    <s:iterator value="applicantResaTopoList">

                        <div class="alert alert-info" role="alert">
                            <div class="col-md-12">
                                <p>
                                    <c:forEach var="compte" items="${applicantListAccount}">
                                        <c:if test="${compte.id == compte_id}">
                                            Nom du l'emprunteur : <c:out value="${compte.nom}"/>
                                            <c:out value="${compte.prenom}"/>
                                        </c:if>
                                    </c:forEach>
                                </p>
                                <s:iterator value="topoList">
                                    <p>Nom du topo : <s:property value="nom"/></p>
                                </s:iterator>

                                <p>Etat de la demande : <s:property value="statut"/></p>

                                <p>Date de début <s:property value="date_debut"/> / Date de fin : <s:property value="date_fin"/></p>

                                <s:if test="%{statut == 'annuler'}">
                                    <p>La demande émise pour réserver votre topo a été annulée, vérifiez vos messages
                                        pour en connaitre la raison !</p>
                                    <p>Pour rendre de nouveau libre le topo vous devez supprimer la réservation en cours.</p>
                                </s:if>
                            </div>

                            <div class="row">
                                <div class="col-md-3">
                                    <s:a action="message_resa_topo">
                                        <button type="button" class="btn btn-success">Voir le(s) message(s)</button>
                                    </s:a>
                                </div>

                                <s:if test="%{!statut.equals('rendu') && !statut.equals('refuser')
                                && !statut.equals('accepter') && !statut.equals('annuler')}">
                                    <div class="col-md-2">
                                        <s:a action="accept_resa_topo">
                                            <s:param name="resaTopo.id" value="id"/>
                                            <button type="button" class="btn btn-success">Accepter</button>
                                        </s:a>
                                    </div>
                                </s:if>
                                <s:if test="%{!statut.equals('rendu') && !statut.equals('refuser')
                                && !statut.equals('demande en cours') && !statut.equals('annuler')}">
                                    <div class="col-md-2">
                                        <s:a action="refuse_ou_rendu_resa_topo">
                                            <s:param name="resaTopo.id" value="id"/>
                                            <s:param name="statutResa">rendu</s:param>
                                            <button type="button" class="btn btn-primary">Rendu</button>
                                        </s:a>
                                    </div>
                                </s:if>
                                <s:if test="%{!statut.equals('rendu') && !statut.equals('accepter')
                                && !statut.equals('refuser') && !statut.equals('annuler')}">
                                    <div class="col-md-2">
                                        <s:a action="refuse_ou_rendu_resa_topo">
                                            <s:param name="resaTopo.id" value="id"/>
                                            <s:param name="statutResa">refuser</s:param>
                                            <button type="button" class="btn btn-danger">Refuser</button>
                                        </s:a>
                                    </div>
                                </s:if>

                                <s:if test="%{!statut.equals('accepter') && !statut.equals('demande en cours')}">
                                    <div class="col-md-2">
                                        <s:a action="del_resa_topo">
                                            <s:param name="resaTopo.id" value="id"/>
                                            <button type="button" class="btn btn-danger">Supprimer</button>
                                        </s:a>
                                    </div>
                                </s:if>
                            </div>
                        </div>
                    </s:iterator>
                </s:if>
                <s:if test="%{applicantResaTopoList.isEmpty()}">
                    <div class="row">
                        <div class="col-md-12">
                            <hr width="80%" color="#DCDCDC">
                        </div>
                    </div>

                    <div col-md-12>
                        <p style="text-align: center">Vous n'avez reçu aucune réservation pour le moment ! </p>
                    </div>

                    <div class="row">
                        <div class="col-md-12">
                            <hr width="80%" color="#DCDCDC">
                        </div>
                    </div>
                </s:if>
            </div>
        </div>



        <div class="row">
            <div class="col-md-12">
                <hr width="80%" color="#DCDCDC">
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-md-9" style="border-style: solid; border-color: #DCDCDC; border-width: 2px; border-radius: 10px;
                 margin-top: 1%; margin-top: 1%; margin-top: 1%">

                <h4 style="text-align: center">Mes demandes de réservations</h4>

                <s:if test="%{!myResaTopoListRequests.isEmpty()}">

                    <s:iterator value="myResaTopoListRequests">
                        <div class="alert alert-info" role="alert">
                            <div class="col-md-12">
                                <p>
                                    <c:forEach var="compte" items="${ownerListAccount}">
                                        <c:if test="${proprietaire_topo == compte.id}">
                                            Nom du propriètaire : <c:out value="${compte.nom}"/>
                                            <c:out value="${compte.prenom}"/>
                                        </c:if>
                                    </c:forEach>
                                </p>

                                <s:iterator value="topoList">
                                <p>Nom du topo : <s:property value="nom"/>
                                    </s:iterator>
                                <p>Etat de la demande : <s:property value="statut"/> </p>

                                <p>Date de début   <s:property value="date_debut"/> / Date de fin : <s:property value="date_fin"/></p>
                            </div>
                            <div class="row justify-content-center">
                                <div class="col-md-3">
                                    <s:a  action="my_message_resa_topo" class="btn btn-success" role="button">
                                        Voir le(s) message(s)
                                    </s:a>
                                </div>

                                <s:if test="%{!statut.equals('refuser') && !statut.equals('annuler')}">
                                    <div class="col-md-3">
                                        <s:a action="annuler_resa_topo" class="btn btn-danger" role="button">
                                            <s:param name="resaTopo.id" value="id"/>
                                            Annuler
                                        </s:a>
                                    </div>
                                </s:if>
                                <s:if test="%{statut == 'refuser'}">
                                    <div class="col-md-3">
                                        <s:a action="del_resa_topo" class="btn btn-danger" role="button">
                                            <s:param name="resaTopo.id" value="id"/>
                                            Supprimer
                                        </s:a>
                                    </div>
                                </s:if>
                            </div>
                        </div>
                    </s:iterator>
                </s:if>
                <s:if test="%{myResaTopoListRequests.isEmpty()}">
                    <div class="row">
                        <div class="col-md-12">
                            <hr width="80%" color="#DCDCDC">
                        </div>
                    </div>

                    <div col-md-12>
                        <p style="text-align: center">Vous n'avez fais aucune réservation pour le moment ! </p>
                        <p style="text-align: center">N'hésitez pas à consulter les topos mis en ligne par notre communauté !</p>
                    </div>

                    <div class="row">
                        <div class="col-md-12">
                            <hr width="80%" color="#DCDCDC">
                        </div>
                    </div>
                </s:if>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <hr width="80%" color="#DCDCDC">
            </div>
        </div>
    </div>

</section>

<footer>
    <%@include file="../_include/footer.jsp"%>
</footer>

</body>
</html>
