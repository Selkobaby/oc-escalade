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

        <s:iterator value="voie">

            <div class="row">
                <div class="col-md-12" style="margin-top: 10px; margin-bottom: 10px; text-align: center">
                    <h4>Detail de la listVoies : <s:property value="nom"/></h4>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <p>Description : <s:property value="description"/></p>
                    <p>La difficulté moyenne de la voie et de <s:property value="cotation"/>, cette voie est "<s:property value="type_voie"/>".</p>
                </div>
            </div>

            <hr width="50%" color="#DCDCDC">

            <div class="row">
                <div class="col-md-12" style="margin-top: 10px; margin-bottom: 10px; text-align: center">
                    <h4>Longueur(s) & Relai(s)</h4>
                </div>
            </div>

            <s:if test="%{voie.longueursRelais.isEmpty()}">
                <p style="text-align: center">Aucune données concernant les longueures et les relais de cette voie n'ont encore été communiquer !</p>
            </s:if>
            <s:else>
                <s:iterator value="voie.longueursRelais">
                    <div class="row">
                        <div class="col-md-12">

                            <p>La longueur N° <s:property value="num_longueur"/> est d'une hauteur de <s:property value="hauteur"/>
                                <s:if test="%{num_relai != 0}">
                                mètres pour atteindre le relai N° <s:property value="num_relai"/></p>
                            </s:if>
                            <s:else>
                                mètres pour enfin atteindre le sommet !
                            </s:else>
                            <p>La difficultée de la longueur est de <s:property value="cotation"/>.</p>

                        </div>
                    </div>
                </s:iterator>
            </s:else>

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
