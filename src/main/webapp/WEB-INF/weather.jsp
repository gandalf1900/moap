<html>
<head>
    <script src="../script/jquery-2.1.4.min.js"></script>
    <script src="../script/weather.js"></script>
</head>

Weather

    <div>
        <input id="city" type="text" value="oslo"/>
    </div>

    <div>
        <input id="button4" type="button" value="Hent" onclick="getWeatherWithAjax();"/>
    </div>

    <p></p>

    <div id="weatherResponse" style="height: 80px; width:500px; background-color: beige">

    </div>

</html>