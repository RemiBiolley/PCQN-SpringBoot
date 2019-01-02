function applyNote(){
    jQuery(document).ready(function(){
        var value = $("input[name='rating']:checked").val();
        var gameId = $("input[type='hidden']").val();
        if(value){
            alert(value);
            $.ajax({
                type: "POST",
                url: "/note",
                data: {note: value, gameId: game.id},
                success: function(result){
                    alert('Ca a marché');
                }

            });

        }
        else{
            alert("Pardon ?")
        }
    })
}