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
        <s:iterator value="secteur">
            <div class="row">
                <div class="col-md-12" style="margin-top: 10px; margin-bottom: 10px; text-align: center">
                    <h4>Détail du secteur : <s:property value="nom"/></h4>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12" style="margin-top: 10px; margin-bottom: 10px; text-align: center">
                    <p>Description : <s:property value="description"/></p>
                </div>
            </div>

            <hr width="100%" color="#DCDCDC">

            <div class="row">
                <div class="col-md-12" style="margin-top: 10px; margin-bottom: 10px; text-align: center">
                    <h4>Voie(s) d'éscalade(s)</h4>
                </div>
            </div>

            <s:iterator value="listVoies">
                <div class="row">
                    <div class="col-md-8">
                        <div class="well well-md">
                            <h6><s:property value="nom"/></h6>
                            <p><s:property value="description"/> </p>
                        </div>
                    </div>

                    <div class="col-md-4 offset-md-9">
                        <s:a action="voie_detail" class="btn btn-outline-info" role="button">
                            <s:param value="id" name="voie_id"/>
                            Détail de la voie
                        </s:a>
                    </div>
                </div>

                <hr width="100%" color="#DCDCDC">
            </s:iterator>

        </s:iterator>
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
