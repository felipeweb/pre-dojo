<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dojo Game</title>
</head>
<body>
<h1>Dojo game</h1>

<form method="post" enctype="multipart/form-data" action="/lerLog">
    <legend>Log Game</legend>
    <fieldset>
        <div>
            <label for="log">Log file</label>
            <input type="file" name="log" id="log">
        </div>
        <div>
            <button type="submit">Enviar</button>
        </div>
    </fieldset>
</form>
</body>
</html>
