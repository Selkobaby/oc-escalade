<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

        <div class="col-md-12" style="text-align: center; margin-top: 2%">
            <h1>Formulaire de recherche !</h1>
        </div>

        <div class="row">
            <div class="col-md-12" style="margin-top: 1%">

                <s:form action="advanced_research">

                    <div class="form-group">
                        <label for="selectRegionResearch">Région</label>
                        <select name="regionSelect" id="selectRegionResearch" required="true" class="form-control" style="width: 100%">
                            <c:forEach var="region" items="${listRegions}">
                                <option><c:out value="${region}"/></option>
                            </c:forEach>
                        </select>

                        <label for="selectTypeVoieResearch">Type de la voie</label>
                        <select name="typeVoieSelect" id="selectTypeVoieResearch" required="true" class="form-control">
                            <c:forEach var="type" items="${listTypesVoie}">
                                <option><c:out value="${type}"/></option>
                            </c:forEach>
                        </select>

                        <label for="selectCotationVoieResearch">Cotation de la voie</label>
                        <select name="cotationVoieSelect" id="selectCotationVoieResearch" required="true" class="form-control">
                            <c:forEach var="cotation" items="${listCotations}">
                                <option><c:out value="${cotation}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="row justify-content-center">
                        <div class="col-md-5">
                            <button id="validateFormResearch" class="btn btn-success" type="submit" style="width: 100%">Validez</button>
                        </div>
                    </div>
                </s:form>
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
