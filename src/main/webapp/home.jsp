<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>CardGame</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        /* Remove the navbar's default margin-bottom and rounded borders */
        .navbar {
            background-color: #006699;
            margin-bottom: 0;
            border-radius: 0;
        }
        /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
        .row.content {height: 450px}
        /* Set gray background color and 100% height */
        .sidenav {
            padding-top: 20px;
            height: 100%;
        }
        /* Set black background color, white text and some padding */
        footer {
            background-color: #006699;
            color: white;
            padding: 15px;
        }
        /* On small screens, set height to 'auto' for sidenav and grid */
        @media screen and (max-width: 767px) {
            .sidenav {
                height: auto;
                padding: 15px;
            }
            .row.content {height:auto;}
        }
    </style>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Logo</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><h4 style="color:white">Card Game</h4></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
            </ul>
        </div>
    </div>
</nav>
<div class="container-fluid text-left">
    <div class="row content">
        <div class="col-sm-1">
        </div>
        <div class="col-sm-11 text-left" id="mainDiv">
            <h4>Cards Show:</h4>
            Click <a class="btn btn-sm btn-primary" href="/mvc/cards/drawcard">New Deck</a> for new deck of cards.
            <div>
                <c:if test="${cardDeck!=null}">
                    <h4>Deck details</h4>
                    <div class="row">
                        <div class="col-sm-4">
                            <ul>
                                <li>Deck ID: <c:out value="${cardDeck.deck_id}"/></li>
                                <li>Remaining Cards: <c:out value="${cardDeck.remaining}"/></li>
                            </ul>
                        </div>
                        <div class="col-sm-4">
                            <a class="btn btn-sm btn-primary" href="/mvc/cards/drawcard?deck_id=<c:out value="${cardDeck.deck_id}"/>"" >New Deck</a>
                        </div>
                    </div>

                </c:if>
            </div>
            <div>
                <ul>
                <c:forEach items="${cardDeck.cards}" var="aCard">
                    <li><img src="<c:out value="${aCard.image}"/>" style="width:50px"/></li>
                </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>
<footer class="container-fluid text-center">
    <p>Welcome To Cards</p>
</footer>

</body>
</html>