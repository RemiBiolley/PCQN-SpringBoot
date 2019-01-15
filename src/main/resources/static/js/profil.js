function changeAvatar(){
    jQuery(document).ready(function(){
        var avatar = $("input[id='changeAvatar']").val();
        if(avatar){
            alert(avatar);
            $.ajax({
                type: "POST",
                url: "/changeAvatar",
                data: {avatar: avatar},
                success: function(){
                    alert("Avatar changé avec succès !");
                    window.location.reload();
                }

            });

        }
        else{
            alert("Pardon ?")
        }
    })
}

function changePassword(){
    jQuery(document).ready(function(){
        var password = $("input[id='password']").val();
        var passwordConfirm = $("input[id='passwordConfirm']").val();
        if(password==passwordConfirm){
            var conf = confirm("Tu veux vraiment changer ?");
            if(conf==true){
                $.ajax({
                    type: "POST",
                    url: "/changePassword",
                    data: {password: password},
                    success: function(){
                        alert("Mdp changé avec succès !");
                        window.location.reload();
                    }

                });
            }
        }
        else{
            alert("Les mots de passe doivent avoir la même valeur");
        }
    })
}

$("input[name='modifInfos']").on("click", function(){
    $(this).next().toggle();
    if($(this).val()=="Modifier les infos"){
        $(this).val("Cacher les informations");
    }
    else{
        $(this).val("Modifier les infos");
    }
});

$("input[name='modifPersonalInfos']").on("click", function(){
    $(this).next().toggle();
    if($(this).val()=="Modifier tes infos persos"){
        $(this).val("Cacher les informations");
    }
    else{
        $(this).val("Modifier tes infos persos");
    }
});

function changeName(){
    jQuery(document).ready(function(){
        var firstName = $("input[id='firstName']").val();
        var lastName = $("input[id='lastName']").val();
        if(firstName && lastName){
            var conf = confirm("tu t'appelles vraiment " + firstName + " " + lastName +" ? (tu ne pourras plus changer)");
            if(conf==true){
                $.ajax({
                    type: "POST",
                    url: "/changeName",
                    data: {firstName: firstName, lastName: lastName},
                    success: function(){
                        alert("Bienvenue à toi " + firstName + " !");
                        window.location.reload();
                    }

                });
            }
        }
        else{
            alert("On a besoin de ton nom complet Billy D:");
        }
    })
}

function changeTel(){
    jQuery(document).ready(function(){
        var tel = $("input[id='tel']").val();
        var intRegex = /[0-9 -()+]{10}$/;
        if(tel && intRegex.test(tel)) {
            var conf = confirm("C'est bien ton numéro ? " + tel);
            if (conf == true) {
                $.ajax({
                    type: "POST",
                    url: "/changeTel",
                    data: {tel: tel},
                    success: function () {
                        alert("Enregistré !");
                        window.location.reload();
                    }

                });
            }
        }
        else{
            alert("La valeur entrée n'est pas correcte");
        }
    })
}

function changeFavoriteGame(){
    jQuery(document).ready(function(){
        var game = $("input[id='favoriteGame']").val();
        var availableGames = $("input[type='hidden']").val();
        if(game){
            if(availableGames.includes(game)) {
                $.ajax({
                    type: "POST",
                    url: "/changeFavoriteGame",
                    data: {game: game},
                    success: function () {
                        alert("Enregistré !");
                        window.location.reload();
                    }

                });
            }
            else{
                alert("Jeu non disponible");
            }
        }
        else{
            alert("Aucune valeur rentrée");
        }
    })
}