<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../_include/head.jsp"%>
</head>
<body>
<%@include file="/jsp/_include/header.jsp"%>

<div class="container" style="margin-top: 2%; border-style: solid; border-color: #DCDCDC; border-width: 2px;
     border-radius: 10px; box-shadow: 6px 6px 14px #DCDCDC">
    <div class="row justify-content-md-center">
        <div class="col-md-8">
            <h4 style="text-align: center">Se connecter</h4>

            <div>
                <p><s:actionmessage style="list-style-type: none"/></p>
                <p><s:actionerror/></p>
            </div>

            <s:form action="login">
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input name="login" type="email" class="form-control" id="exampleInputEmail1"
                           aria-describedby="emailHelp" placeholder="Enter email" autofocus>
                </div>

                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input name="password" type="password" class="form-control"
                           id="exampleInputPassword1" placeholder="Password">
                </div>

                <button type="submit" class="btn btn-primary">Connexion</button>
            </s:form>

        </div>
    </div>
</div>

<footer>
    <%@include file="../_include/footer.jsp"%>
    <%@include file="../_include/scripts.jsp"%>
</footer>

</body>
</html>
