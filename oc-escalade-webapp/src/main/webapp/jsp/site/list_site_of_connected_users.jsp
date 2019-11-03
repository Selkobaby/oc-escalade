<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>

<body>
<section>
    <%@include file="../_include/user_menu.jsp"%>

    <div class="container" style="margin-top: 1%; border-style: solid; border-color: #DCDCDC; border-width: 2px;
     border-radius: 10px; box-shadow: 6px 6px 14px #DCDCDC">
        <div class="row">
            <div class="col-md-12" style="text-align: center; margin-top: 1%">
                <h2>Mes Sites d'éscalades</h2>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <hr width="80%" color="#DCDCDC">
            </div>
        </div>

        <s:iterator value="listSites">
            <div class="row justify-content-center">
                <div class="col-md-9" style="margin-top: 1%">
                    <ul>
                        <div class="well well-md">
                            <h4>Nom du site : <s:property value="nom"/></h4>
                            <p>Région : <s:property value="region"/></p>
                            <p>Dscription : <s:property value="description"/></p>
                        </div>
                    </ul>
                </div>
            </div>

            <div class="row justify-content-end">
                <div class="col-md-4">
                    <s:a action="modified_site">
                        <s:param name="site_id" value="id"/>
                        <button type="button" class="btn btn-outline-primary">Modifier</button>
                    </s:a>

                    <s:a action="del_site" onclick="javascript:return confirm('Confirmez la suppression du site!');">
                        <s:param name="site_id" value="id"/>
                        <button type="button" class="btn btn-outline-danger">Supprimer</button>
                    </s:a>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <hr width="95%" color="#DCDCDC">
                </div>
            </div>

        </s:iterator>
    </div>
</section>

<footer>
    <%@include file="../_include/footer.jsp"%>
</footer>

</body>
</html>
