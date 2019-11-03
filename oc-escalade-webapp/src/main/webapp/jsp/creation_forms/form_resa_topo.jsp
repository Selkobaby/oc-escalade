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

        <s:iterator value="topo">
        <div class="row">
            <div class="col-md-12" style="text-align: center; margin-top: 1%">
                <h3>Formulaire de réservaton du topo : <s:property value="nom"/> </h3>
            </div>
        </div>
        </s:iterator>

        <div class="row">
            <div class="col-md-12">
                <hr width="90%" color="#DCDCDC">
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-md-9">
                <s:form action="resa_topo">
                    <div class="form-group">
                    <h5 style="text-align: center">Dates de réservations</h5>
                    <p>
                        Entrer la date à laquelle vous désirez entrer en possession du topo et,
                        à laquelle vous vous engager à rendre le topo,
                        pour qu'il soit de nouveau disponible pour les autres utilisateur !
                    </p>
                            <p><s:property value="%{dateDuJour}"/></p>
                        <div class="row justify-content-center">
                        <div class="col-md-4">
                            <label>Début de réservation : </label>
                            <input name="resaTopo.date_debut" type="date" style="width: 100%">
                        </div>
                        <div class="col-md-4">
                            <label>Fin de réservation : </label>
                            <input name="resaTopo.date_fin" type="date" style="width: 100%">
                        </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-12">
                            <hr width="100%" color="#DCDCDC">
                        </div>
                    </div>

                    <div class="form-group">
                        <h5 style="text-align: center">Message</h5>
                        <p>
                            Envoyez un message au propriétaire du topo afin de vous organiser avec lui,
                            pour récupérer le topo dans les meilleurs délais !
                        </p>
                        <label for="textareaMessage">Message</label>
                        <textarea name="messagerie.message" id="textareaMessage" cols="40" rows="5" class="form-control"
                                  style="width: 100%"></textarea>
                    </div>

                    <div class="row justify-content-center">
                        <div class="col-md-5">
                            <button name="resaTopo.statut" value="demande en cours" class="btn btn-primary" type="submit" style="width: 100%">Envoyez</button>
                        </div>
                        <div class="col-md-5">
                            <!-- Button trigger modal -->
                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#cancelResa" style="width: 100%">Annuler</button>
                        </div>
                    </div>
                </s:form>
            </div>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="cancelResa" tabindex="-1" role="dialog" aria-labelledby="resaModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Annulation de réservation</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Attention, vous êtes sur le point d'annuler votre réservation de topo !
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary"
                            data-dismiss="modal">Annulez</button>
                    <s:a action="topo_list">
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
