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
                <h2>Messagerie</h2>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <hr width="80%" color="#DCDCDC">
            </div>
        </div>

        <div class="row">
            <div class="col-md-12" style="text-align: center; margin-top: 1%">
                <h4>Réservation du topo : </h4>
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-md-9" style="border-style: solid; border-color: #DCDCDC; border-width: 2px; border-radius: 10px;
                 margin-top: 1%; margin-top: 1%">

                <s:iterator value="applicantResaTopoList">
                <s:iterator value="messagerieList">
                    <div class="alert alert-info" role="alert" style="padding: 1%; margin-top: 1%">
                        <p>
                            <s:property value="date_message"/>
                            <s:if test="%{compte_id == #session.user.id}">
                                <s:property value="#session.user.prenom"/>
                                <s:property value="#session.user.nom"/>
                            </s:if>
                            <c:forEach var="compte" items="${applicantListAccount}">
                                <c:if test="${compte_id == compte.id}">
                                    <c:out value="${compte.nom}"/>
                                    <c:out value="${compte.prenom}"/>
                                </c:if>
                            </c:forEach>
                        </p>
                        <p><s:property value="message"/></p>
                    </div>
                </s:iterator>
            </div>
        </div>

        <s:form action="message_resa_topo">
            <div class="row justify-content-center" style="margin-top: 1%">
                <div class="col-md-9">

                    <div class="form-group">
                        <label for="textareaMessage">Nouveau message</label>
                        <textarea name="messagerie.message" id="textareaMessage" cols="40" rows="5" class="form-control"
                                  style="width: 100%"></textarea>
                    </div>

                    <div class="row justify-content-center">
                        <div class="col-md-5">
                            <button name="messagerie.resa_topo_id" value="<s:property value="id"/>"  class="btn btn-primary" type="submit" style="width: 100%">Envoyez</button>
                        </div>
                        <div class="col-md-5">
                            <!-- Button trigger modal -->
                            <button type="button" class="btn btn-danger" data-toggle="modal"
                                    data-target="#cancelMessage" style="width: 100%">Annuler</button>
                        </div>
                    </div>
                </div>
            </div>
        </s:form>
        </s:iterator>

        <div class="row">
            <div class="col-md-12">
                <hr width="80%" color="#DCDCDC">
            </div>
        </div>

    </div>

    <!-- Modal -->
    <div class="modal fade" id="cancelMessage" tabindex="-1" role="dialog" aria-labelledby="resaModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Annulation le message</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Attention, vous êtes sur le point d'annuler l'envoi de votre message !
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary"
                            data-dismiss="modal">Annulez</button>
                    <s:a action="gestion_resa">
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
