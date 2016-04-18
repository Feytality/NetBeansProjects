$(document).ready( function() {
    $("#getPopular").click(function(event) {
        event.preventDefault();
        $("#popular").html("");
        getPopularBookmarkList();
    });
    
    $("#getRecent").click(function(event) {
        event.preventDefault();
        $("#recent").html("");
        getRecentBookmarkList();
    });

    $("#getUser").click(function(event) {
        event.preventDefault();
        userId = $("#setUser").val();
        if(userId !== "") {
            $("#user").html("");
            getUserBookmarkList(userId);
        } else {
            alert("Please enter a user ID!");
        }
    });
});

function getPopularBookmarkList() {
    $.ajax({
        type: "GET",
        dataType: "jsonp",
        url: "http://feeds.delicious.com/v2/json/popular",
        callback: "makeItDelicious"
    });
}

function makeItDelicious(bookmarks){
    if(bookmarks.length > 1) {
        $.each(bookmarks, function(index, bookmark) {
            $("#popular").append("<li> <a href='" + bookmark.u + "'>"+ bookmark.d + "</li>");
        });
    } else {
        alert("There are no popular bookmarks!");
    }
}

function getRecentBookmarkList() {
     $.ajax({
        type: "GET",
        url: "http://feeds.delicious.com/v2/json/recent",
        success: function(bookmarks) {
            if(bookmarks.length > 1) {
            $.each(bookmarks, function(index, bookmark) {
                $("#recent").append("<li> <a href='" + bookmark.u + "'>"+ bookmark.d + "</li>");
            });
            } else {
                alert("There are no recent bookmarks!");
            }
        }
    });
}

function getUserBookmarkList(userId) {
    $.ajax({
        type: "GET",
        url: "http://feeds.delicious.com/v2/json/" + userId,
        success: function(bookmarks) {
            if(bookmarks.length > 1) {
                $.each(bookmarks, function(index, bookmark) {
                    $("#user").append("<li> <a href='" + bookmark.u + "'>"+ bookmark.d + "</li>");
                });
            } else {
                alert("User with ID \"" + userId + "\" does not exist.");
            }
        },
        error: function() { 
            alert("User with ID \"" + userId + "\" does not exist.");
        }  
    });
}