function addComment(){
    jQuery(document).ready(function(){
        var commentContent = $("input[id='myComment']").val();
        var gameId = $("input[type='hidden']").val();
        if(commentContent){
            alert(commentContent);
            $.ajax({
                type: "POST",
                url: "/comment",
                data: {commentContent: commentContent, gameId: gameId},
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