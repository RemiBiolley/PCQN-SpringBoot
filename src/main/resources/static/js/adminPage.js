$("input[name='buttonMomentGame']").on("click", function(){

    var removedGameName = $(this).prev().prev().prev().text();
    var newGameName = $(this).prev().val();
    var availableGames = $("input[class='availableGamesHidden']").val();
    var momentGames = $("input[class='momentGamesHidden']").val();

    if(removedGameName && newGameName){
        if(availableGames.includes(newGameName)){
            if(!momentGames.includes(newGameName)){
                $.ajax({
                    type: "POST",
                    url: "/changeMomentGame",
                    data: {removedGameName: removedGameName, newGameName: newGameName},
                    success: function(){
                        window.location.reload();
                    }

                });
            }
            else{
                alert("Ce jeu est déjà défini comme jeu du moment.")
            }
        }
        else{
            alert("Le jeu rentré est invalide");
        }
    }
    else{
        alert("Il y a eu un problème");
    }
});

$("input[name='promoteUser']").on("click", function(){
    alert($(this).val());
    var promotedUserName = $(this).parent().siblings(".userName").eq(0).text();
    alert(promotedUserName)
    if(promotedUserName){
        $.ajax({
            type: "POST",
            url: "/promote",
            data: {promotedUserName: promotedUserName},
            success: function(){
                window.location.reload();
            }
        });
    }
    else{
        alert("Il y a eu un problème");
    }
});

$("input[name='removeUser']").on("click", function(){
    var removedUserName = $(this).parent().siblings(".userName").eq(0).text();
    alert(removedUserName);
    if(removedUserName){
        var conf = confirm("Voulez-vous vraiment supprimer cet utilisateur ? (" + removedUserName + ")");
        if(conf){
            $.ajax({
                type: "POST",
                url: "/removeUser",
                data: {removedUserName: removedUserName},
                success: function(){
                    window.location.reload();
                }
            });
        }
        else{
            alert("L'utilisateur n'a pas été effacé");
        }
    }
    else{
        alert("Il y a eu un problème");
    }
});