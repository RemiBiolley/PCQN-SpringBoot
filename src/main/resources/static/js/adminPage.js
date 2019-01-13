$("input[name='buttonMomentGame']").on("click", function(){

    var removedGameName = $(this).prev().prev().prev().text();
    var newGameName = $(this).prev().val();
    var availableGames = $("input[type='hidden']").val();
    if(removedGameName && newGameName){
        alert(newGameName);
        if(availableGames.includes(newGameName)){
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
            alert("Le jeu rentré est invalide");
        }
    }
    else{
        alert("Il y a eu un problème");
    }
});