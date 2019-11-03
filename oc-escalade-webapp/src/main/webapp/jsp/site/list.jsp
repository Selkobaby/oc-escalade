<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <h2>Sites d'éscalades</h2>
                <hr width="90%" color="#DCDCDC">
            </div>
        </div>

        <s:iterator value="listSites">
            <div class="row">
                <div class="col-md-9" style="margin-top: 5px">
                    <ul>
                        <div class="well well-md">
                            <h4>Nom du site : <s:property value="nom"/></h4>
                            <p>Dscription : <s:property value="description"/></p>
                        </div>
                    </ul>
                </div>
            </div>

            <div class="row">
                <div class="col-md-10"></div>
                <div class="col-md-2">
                    <s:a  action="site_detail" class="btn btn-outline-info" role="button">
                        <s:param name="site_id" value="id"/>
                        Voir détail
                    </s:a>
                </div>
            </div>
            <hr width="100%" color="#DCDCDC">
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
