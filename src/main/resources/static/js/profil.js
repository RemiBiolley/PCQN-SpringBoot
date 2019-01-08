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