<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dojo Game</title>
</head>
<body>
<c:forEach items="${resultGames}" var="game">
    <h1>Partida ${game.id}</h1>
    <table style="border: 1px solid;">
        <thead>
        <tr style="border: 1px solid;">
            <th style="border: 1px solid;">Nome do Jogador</th>
            <th style="border: 1px solid;">Matou</th>
            <th style="border: 1px solid;">Morreu</th>
            <th style="border: 1px solid;">total de mortes do jogo</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${game.players}" var="player">
            <tr style="border: 1px solid;">
                <td style="border: 1px solid;">${player.name}</td>
                <td style="border: 1px solid;">${player.kills}</td>
                <td style="border: 1px solid;">${player.dies}</td>
                <td style="border: 1px solid;"></td>
            </tr>
        </c:forEach>
        <tr style="border: 1px solid;">
            <td style="border: 1px solid;"></td>
            <td style="border: 1px solid;"></td>
            <td style="border: 1px solid;"></td>
            <td style="border: 1px solid;">${game.totalKills}</td>
        </tr>
        </tbody>
    </table>
</c:forEach>
</body>
</html>
