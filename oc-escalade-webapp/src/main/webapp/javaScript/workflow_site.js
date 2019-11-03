/* ==================================================== */
/* ===== Script de la jsp formulaire_site_complet ===== */
/* ==================================================== */

configPage();

function configPage() {

    var configSelectForm = $('#configSelectForm').text();

    switch (configSelectForm) {

        case 'formSite':
            $('#navSite').attr('class', 'nav-link active');
            $('#navSecteur').attr('class', 'nav-link disabled');
            $('#navVoie').attr('class', 'nav-link disabled');
            $('#navLongueur').attr('class', 'nav-link disabled');

            $('#configSelectForm').hide();
            $('#formSite').show();
            $('#formSecteur').hide();
            $('#formVoie').hide();
            $('#formLongueur').hide();
            break;
        case 'formSecteur':
            $('#navSite').attr('class', 'nav-link');
            $('#navSecteur').attr('class', 'nav-link active');
            $('#navVoie').attr('class', 'nav-link disabled');
            $('#navLongueur').attr('class', 'nav-link disabled');

            $('#configSelectForm').hide();
            $('#formSite').hide();
            $('#formSecteur').show();
            $('#formVoie').hide();
            $('#formLongueur').hide();
            break;
        case 'formVoie':
            $('#navSite').attr('class', 'nav-link');
            $('#navSecteur').attr('class', 'nav-link');
            $('#navVoie').attr('class', 'nav-link active');
            $('#navLongueur').attr('class', 'nav-link disabled');

            $('#configSelectForm').hide();
            $('#formSite').hide();
            $('#formSecteur').hide();
            $('#formVoie').show();
            $('#formLongueur').hide();
            break;
        case 'formLongueur' :
            $('#navSite').attr('class', 'nav-link');
            $('#navSecteur').attr('class', 'nav-link');
            $('#navVoie').attr('class', 'nav-link');
            $('#navLongueur').attr('class', 'nav-link active');

            $('#configSelectForm').hide();
            $('#formSite').hide();
            $('#formSecteur').hide();
            $('#formVoie').hide();
            $('#formLongueur').show();
            $('#validatedWorkflow').removeAttr('style');
            break;
    }
}

/* ============================================================ */
/* == Gestion des événements sur le navigateur de formulaire == */
/* ============================================================ */

    /* ==== Nav Site ==== */
    $('#navSite').click(function () {

       var navSecteur = $('#navSecteur').attr('class');
       var navVoie = $('#navVoie').attr('class');
       var navLongueur = $('#navLongueur').attr('class');

        $('#navSite').attr('class', 'nav-link active');

        if(navSecteur ==  "nav-link active" || navSecteur ==  "nav-link"){
            $('#navSecteur').attr('class', 'nav-link');
        } else {
            $('#navSecteur').attr('class', 'nav-link disabled');
        }

        if(navVoie ==  "nav-link active" || navVoie ==  "nav-link"){
            $('#navVoie').attr('class', 'nav-link');
        } else {
            $('#navVoie').attr('class', 'nav-link disabled');
        }

        if(navLongueur ==  "nav-link active" || navLongueur ==  "nav-link"){
            $('#navLongueur').attr('class', 'nav-link');
        } else {
            $('#navLongueur').attr('class', 'nav-link disabled');
        }

        $('#configSelectForm').hide();
        $('#formSite').show();
        $('#formSecteur').hide();
        $('#formVoie').hide();
        $('#formLongueur').hide();
    });

    /* ==== Nav Secteur ==== */
    $('#navSecteur').click(function () {

        var navSite = $('#navSite').attr('class');
        var navVoie = $('#navVoie').attr('class');
        var navLongueur = $('#navLongueur').attr('class');

        $('#navSecteur').attr('class', 'nav-link active');

        if(navSite ==  "nav-link active" || navSite ==  "nav-link"){
            $('#navSite').attr('class', 'nav-link');
        } else {
            $('#navSite').attr('class', 'nav-link disabled');
        }

        if(navVoie ==  "nav-link active" || navVoie ==  "nav-link"){
            $('#navVoie').attr('class', 'nav-link');
        } else {
            $('#navVoie').attr('class', 'nav-link disabled');
        }

        if(navLongueur ==  "nav-link active" || navLongueur ==  "nav-link"){
            $('#navLongueur').attr('class', 'nav-link');
        } else {
            $('#navLongueur').attr('class', 'nav-link disabled');
        }

        $('#configSelectForm').hide();
        $('#formSite').hide();
        $('#formSecteur').show();
        $('#formVoie').hide();
        $('#formLongueur').hide();
    });

    /* ==== Nav Voie ==== */
    $('#navVoie').click(function () {

        var navSite = $('#navSite').attr('class');
        var navSecteur = $('#navSecteur').attr('class');
        var navLongueur = $('#navLongueur').attr('class');

        $('#navVoie').attr('class', 'nav-link active');

        if(navSite ==  "nav-link active" || navSite ==  "nav-link"){
            $('#navSite').attr('class', 'nav-link');
        } else {
            $('#navSite').attr('class', 'nav-link disabled');
        }

        if(navSecteur ==  "nav-link active" || navSecteur ==  "nav-link"){
            $('#navSecteur').attr('class', 'nav-link');
        } else {
            $('#navSecteur').attr('class', 'nav-link disabled');
        }

        if(navLongueur ==  "nav-link active" || navLongueur ==  "nav-link"){
            $('#navLongueur').attr('class', 'nav-link');
        } else {
            $('#navLongueur').attr('class', 'nav-link disabled');
        }

        $('#configSelectForm').hide();
        $('#formSite').hide();
        $('#formSecteur').hide();
        $('#formVoie').show();
        $('#formLongueur').hide();
    });

    /* ==== Nav Longueur & Relai ==== */
    $('#navLongueur').click(function () {

        var navSite = $('#navSite').attr('class');
        var navSecteur = $('#navSecteur').attr('class');
        var navVoie = $('#navVoie').attr('class');

        $('#navLongueur').attr('class', 'nav-link active');

        if(navSite ==  "nav-link active" || navSite ==  "nav-link"){
            $('#navSite').attr('class', 'nav-link');
        } else {
            $('#navSite').attr('class', 'nav-link disabled');
        }

        if(navSecteur ==  "nav-link active" || navSecteur ==  "nav-link"){
            $('#navSecteur').attr('class', 'nav-link');
        } else {
            $('#navSecteur').attr('class', 'nav-link disabled');
        }

        if(navVoie ==  "nav-link active" || navVoie ==  "nav-link"){
            $('#navVoie').attr('class', 'nav-link');
        } else {
            $('#navVoie').attr('class', 'nav-link disabled');
        }

        $('#configSelectForm').hide();
        $('#formSite').hide();
        $('#formSecteur').hide();
        $('#formVoie').hide();
        $('#formLongueur').show();
    });


            /* ======================== */
            /* ==== Gestion du CSS ==== */
            /* ======================== */

    $(function () {
        $('#navForm').css('margin-top', '2%');
        $('div[id*="formulaire"][class="row"]').css('margin-top', '2%');
        $(':button:not(#valRecherche, #addLongueur)').attr('style', style="width: 100%");
    });


/* ========================================================== */
/* == Gestion de l'événements ajouer une nouvelle longueur == */
/* ========================================================== */

    /* ===== Validez le formulaire ===== */
    $('#validateForm').click(function () {
        $('#validateForm').attr('value', longueursRelais);
    });

    /* ===== Modifier une longueeur ===== */
    $('#buttonSelectLongueurModif').click(function () {
        $('#formGroupLongueur').hide();
        $('#selectLongueurModif').collapse('show');

    });

    $('#buttonValidateSelectLongueur').click(function () {
        $('#modifiedLongueur').collapse('show');
        var numRelai = $('#selectLongueur').val();

       $('#displayNumLongueurModif').text(numRelai);
       $('#numLongueurModif').val(numRelai);
       $('#selectLongueurModif').collapse('hide');

    });

    $('#cancelSelect, #cancelModif').click(function () {
        $('#selectLongueurModif').collapse('hide');
        $('#modifiedLongueur').collapse('hide');
        $('#formLongueur').show();
    });










