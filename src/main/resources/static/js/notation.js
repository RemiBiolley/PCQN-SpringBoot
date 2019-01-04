function applyNote(){
    jQuery(document).ready(function(){
        var value = $("input[name='rating']:checked").val();
        var gameId = $("input[type='hidden']").val();
        if(value){
            alert(value);
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