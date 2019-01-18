function submitSub() {
    jQuery(document).ready(function(){
        var email = $("input[id='emailSub']").val();
        var password = $("input[id='passwordSub']").val();
        var passwordV = $("input[id='passwordVerif']").val();
        var userName = $("input[id='usernameSub']").val();

        if(email && password && passwordV && userName){
            $.ajax({
                type: "POST",
                url: "/inscription",
                data: {email: email, password: password, passwordV: passwordV, userName: userName},
                success: function(result){
                    if(result==="mail"){
                        $('.fail').html("");
                        $('#emailFailed').html("L'adresse mail saisie est déjà utilisée ou ne correspond pas à nos critères");
                    }
                    else if(result==="password"){
                        $('.fail').html("");
                        $('#passwordFailed').html("Le mot de passe n'a pas été confirmé correctement");
                    }
                    else if(result==="userName") {
                        $('.fail').html("");
                        $('#userNameFailed').html("Nom d'utilisateur déjà utilisé ou trop long");
                    }
                    else if(result==="done"){
                        alert("hahah");
                        window.location.href="/profil";
                    }
                }

            });

        }
        else{
            alert("Tous les champs doivent être remplis");
        }
    })
}

function submitCon() {
    jQuery(document).ready(function(){
        var email = $("input[id='emailConnect']").val();
        var password = $("input[id='passwordConnect']").val();

        if(email && password){
            $.ajax({
                type: "POST",
                url: "/connection",
                data: {email: email, password: password},
                success: function(result){
                    if(result==="fail"){
                        $('.fail').html("");
                        $('#connectFailed').html("Les informations saisies sont incorrectes");
                    }
                    else{
                        window.location.href="/profil";
                    }
                }

            });

        }
        else{
            alert("Tous les champs doivent être remplis");
        }
    })
}