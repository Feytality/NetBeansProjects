<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="index.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" 
              integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <title>Delicious Bookmarks Service</title>
    </head>
    <body>
        <div class="container">
            <h1>Get the most popular bookmarks:</h1>
            <ul id="popular"></ul>
            <div class="row">
                <div class="col-md-3 col-md-offset-2">
                    <button class="form-control" id="getPopular" class="btn btn-default"> Get Popular Bookmarks </button>
                </div>
            </div>

            <h1> Get the most recent bookmarks:</h1>
            <ul id="recent"></ul>
            <div class="row">
                <div class="col-md-3 col-md-offset-2">
                    <button class="form-control" id="getRecent" class="btn btn-default"> Get Recent Bookmarks </button>
                </div>
            </div>

            <h1> Get bookmarks by user:</h1>
            <ul id="user"></ul>
            <div class="row">
                <div class="col-md-3">
                    <input class="form-control" id="setUser" class="btn btn-default"  placeholder="Ex: serviceavenir"/>
                </div>
                <div class="col-md-3">
                    <button class="form-control" id="getUser" class="btn btn-default"> Get User Bookmarks </button>
                </div>
            </div>

    </body> 
</html>
