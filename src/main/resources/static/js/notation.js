function applyNote(){
    jQuery(document).ready(function(){
        var value = $("input[name='rating']:checked").val();
        var user = $("input[name='user']").val();
        var gameId = $("input[name='gameId']").val();
        if(value && gameId){
            if(user!=""){
                alert(value);
                alert(gameId);
                $.ajax({
                    type: "POST",
                    url: "/note",
                    data: {note: value, gameId: gameId},
                    success: function(){
                        window.location.reload();
                    }

                });
            }
            else{
                var conf = confirm("Il faut être connecté pour pouvoir donner une note. Être redirigé vers la page de connexion ?");
                if(conf){
                    window.location.href="/connection";
                }
            }
        }
        else{
            alert("Une erreur s'est produite")
        }
    })
}