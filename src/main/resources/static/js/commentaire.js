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

$("input[name='displayResponse']").on("click", function(){
    $(this).next().css('display','block');
    $(this).toggle();
});

$("input[name='addResponse']").on("click", function(){
    var respondedCommentId = $(this).parent('div').siblings($("input[name='invisible']")).eq(0).val();
    var responseContent = $(this).siblings('input').eq(0).val();
    var gameId = $("input[type='hidden']").val();
    if(responseContent){
        alert(responseContent);
        $.ajax({
            type: "POST",
            url: "/response",
            data: {respondedCommentId: respondedCommentId, responseContent: responseContent, gameId: gameId},
            success: function(){
                window.location.reload();
            }

        });

    }
})




