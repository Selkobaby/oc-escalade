<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

</head>
<body>

<%@include file="../_include/user_menu.jsp"%>

<section>

    <div class="container" style="margin-top: 1%; border-style: solid; border-color: #DCDCDC; border-width: 2px;
         border-radius: 10px; box-shadow: 6px 6px 14px #DCDCDC">

        <div class="row">

            <div class="col-md-12" style="margin-top: 1%">
                <h5>Ajouter un relai!</h5>
                <p>Entrez les longueurs et le relais correspondants à la voie : <s:property value="#session.voie.nom"/></p>
            </div>

            <s:if test="#session.listLongueur">
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
            </s:if>
        </div>

        <div class="row">
            <div class="col-md-12">
                <hr width="95%" color="#DCDCDC">
            </div>
        </div>

        <s:form action="new_longueur">
        <div class="row justify-content-center" style="margin-top: 1%">

            <div class="col-md-3">
                <label for="inputHauteurLongueur">Hauteur de la longueur N° <s:property value="#session.initNumLongueur"/></label>
                <input name="hauteur" id="inputHauteurLongueur" type="number" step="0.10" class="form-control"
                       style="width: 100%" required="true" autofocus>
            </div>

            <div class="col-md-3">
                <label for="selectCotationLongueur">Cotation de la longueur</label>
                <select name="longueur.cotation" id="selectCotationLongueur" required="true" class="form-control"
                        style="width: 100%">
                    <c:forEach var="cotation" items="${cotations}">
                        <option><c:out value="${cotation}"/></option>
                    </c:forEach>
                </select>
            </div>

            <div class="col-md-4">
                <label for="radiosRelai">Relai</label>
                <fieldset class="form-group" id="radiosRelai">
                    <div class="form-check form-check-inline">
                        <input name="longueur.num_relai" id="relaiOui" value=1 class="form-check-input" type="radio">
                        <label class="form-check-label" for="relaiOui">
                            Oui il y a un relai !
                        </label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input name="longueur.num_relai" id="relaiNon" value=0 class="form-check-input" type="radio">
                        <label class="form-check-label" for="relaiNon">
                            Non il n'y a pas de relai !
                        </label>
                    </div>
                    <small id="relaiHelp" class="form-text text-muted">
                        Indiquez s'il y a un relai à la fin de cette longueur !
                    </small>
                </fieldset>
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-md-5">
                <button class="btn btn-primary" type="submit" style="width: 100%">Validez</button>
            </div>
            <div class="col-md-5">
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#cancelCreate"
                        style="width: 100%">Annuler</button>
            </div>
        </div>
        </s:form>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="cancelCreate" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Annulez la création de la longueur</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Confirmez l'annulation !
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary"
                            data-dismiss="modal">Annulez</button>
                    <s:a  action="longueur_by_voie">
                        <s:param name="voie.id" value="%{voie.id}"/>
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
