<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
    <%@include file="../_include/head.jsp"%>
</head>
<body>

<header>
    <%@include file="header.jsp"%>
</header>

<div class="container" style="margin-top: 1%">
    <div class="row">
        <div class="col-md-12" style="border-style: solid; border-color: #DCDCDC; border-width: 2px;
             border-radius: 10px; box-shadow: 6px 6px 14px #DCDCDC">
            <ul class="nav nav-tabs">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
                       role="button" aria-haspopup="true" aria-expanded="false">MES SITES</a>
                    <div class="dropdown-menu">
                        <s:a action="complete_creation_climbing_site" class="dropdown-item">
                            Créer un nouveau Site d'escalade complet
                        </s:a>
                        <s:a action="new_site" class="dropdown-item">Créer un nouveau Site d'escalade</s:a>
                        <s:a action="sites_by_account" class="dropdown-item">Afficher mes Sites d'éscalades !</s:a>
                    </div>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
                       role="button" aria-haspopup="true" aria-expanded="false">MES SECTEURS</a>
                    <div class="dropdown-menu">
                        <s:a action="new_secteur" class="dropdown-item">Créer un nouveau Secteurs</s:a>
                        <s:a action="secteur_by_account" class="dropdown-item"> Afficher mes Secteurs !</s:a>
                    </div>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
                       role="button" aria-haspopup="true" aria-expanded="false">MES VOIES</a>
                    <div class="dropdown-menu">
                        <s:a action="new_voie" class="dropdown-item">Créer un nouvelle Voie</s:a>
                        <s:a action="voies_by_account" class="dropdown-item"> Afficher mes Voies !</s:a>
                    </div>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
                       role="button" aria-haspopup="true" aria-expanded="false">MES TOPOS</a>
                    <div class="dropdown-menu">
                        <s:a action="new_topo" class="dropdown-item">Créer un topo</s:a>
                        <s:a action="topo_by_account" class="dropdown-item">Afficher mes topos</s:a>
                    </div>
                </li>

                <li class="nav-item">
                    <s:a action="gestion_resa" class="nav-link" role="button" aria-expanded="false">RESERVATION TOPO</s:a>
                </li>

            </ul>
        </div>
    </div>
</div>


<%@include file="../_include/scripts.jsp"%>


</body>

</html>
