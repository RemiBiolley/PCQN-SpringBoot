function applyNote(){
    jQuery(document).ready(function(){
        var value = $("input[name='rating']:checked").val();
        var gameId = $("input[name='gameId']").val();
        if(value && gameId){
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
            alert("Pardon ?")
        }
    })
}