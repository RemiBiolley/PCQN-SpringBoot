function addComment(){
    jQuery(document).ready(function(){
        var commentContent = $("input[id='myComment']").eq(0).val();
        var user = $("input[name='user']").val();
        var gameId = $("input[type='hidden']").val();
        if(commentContent){
            if(user!=""){
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
                var conf = confirm("Il faut être connecté pour pouvoir commenter. Être redirigé vers la page de connexion ?");
                if(conf) {
                    window.location.href = "/connection";
                }
            }
        }
        else{
            alert("Pardon ?")
        }
    })
}

$("input[name='displayResponse']").on("click", function(){
    $(this).parent().siblings(".responseBlockWrite").eq(0).css('display','block');
    $(this).toggle();
});

$("input[name='addResponse']").on("click", function(){
    var respondedCommentId = $(this).parent('div').siblings($("input[name='commentId']")).eq(0).val();
    var responseContent = $(this).siblings('input').eq(0).val();
    var gameId = $("input[type='hidden']").val();
    if(responseContent){
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

$("input[name='showHideResponses']").on("click",function(){
    if($(this).val()=="Afficher les réponses"){
        $(this).parent().prev().prev().css("display", "block");
        $(this).val("Cacher les réponses");
    }
    else{
        $(this).parent().prev().prev().css("display", "none");
        $(this).val("Afficher les réponses");
    }
})

$("input[class='showHideComments']").on("click",function(){
    $("div[class='commentBlock']").slice(0, parseInt($(this).attr("name"), 10)).css("display", "block");

    if($("input[name='commentsNumb']").val()<=parseInt($(this).attr("name"),10)){
        $(this).css("display", "none");
    }
    else {
        $(this).attr("name", parseInt($(this).attr("name"),10) + 2);
    }
})

$(function () {
    jQuery(document).ready(function() {
        if ($("input[name='commentsNumb']").val() <= 4) {
            $("input[class='showHideComments']").css("display", "none");
        }
    })
});

$("input[name='eraseComment']").on("click", function(){
    var commentId = $(this).parent().siblings($("input[name='commentId']")).eq(0).val();
    if(commentId){
        $.ajax({
            type: "POST",
            url: "/eraseComment",
            data: {commentId: commentId},
            success: function(){
                window.location.reload();
            }

        });
    }
    else{
        alert("ma que ?");
    }
})




