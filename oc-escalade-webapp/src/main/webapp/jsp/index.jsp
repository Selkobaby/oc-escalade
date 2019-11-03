<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <s:if test="!#session.user">
        <%@include file="_include/head.jsp"%>
    </s:if>
</head>

<body>
<section>
    <s:if test="!#session.user">
        <%@include file="_include/header.jsp"%>
    </s:if>
    <s:else>
        <%@include file="_include/user_menu.jsp"%>
    </s:else>

    <div class="container" style="border-style: solid; border-color: #DCDCDC; border-width: 2px; border-radius: 10px;
        margin-top: 1%; box-shadow: 6px 6px 14px #DCDCDC">
        <div class="row">
            <div class="col-md-12">
                <div id="carouselExampleControls" class="carousel slide" data-ride="carousel" style="margin-top: 1%; margin-bottom: 1%">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img class="d-block w-100" src="imgs/photo_escalade_1.jpg" width="800px" height="600px" alt="First slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="imgs/photo_escalade_2.jpg" width="800px" height="600px" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="imgs/photo_escalade_3.jpg" width="800px" height="600px" alt="Third slide">
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>

        </div>
    </div>

    <footer>
        <%@include file="../jsp/_include/footer.jsp"%>
        <s:if test="!#session.user">
            <%@include file="_include/scripts.jsp"%>
        </s:if>
    </footer>

</body>

</html>
