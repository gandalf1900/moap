
//$(document).ready(function() {
//
//    $.ajax({
//        url: "http://api.openweathermap.org/data/2.5/weather?q=London,uk",
//        success: function( data ) {
//
//        }
//    });
//
//});

function getWeather() {
    var url = "http://api.openweathermap.org/data/2.5/weather?";

    var city = document.getElementById("city").value

    var elem = document.getElementById("city");

    var query = "q=Oslo"
    url = url.concat(query);
    var client = new XMLHttpRequest();
    client.open("GET", url, true);
    client.setRequestHeader("Content-Type", "text/plain");


    if (client.status == 200)
        alert("The request succeeded!\n\nThe response representation was:\n\n" + client.responseText)
    else
        alert("The request did not succeed!\n\nThe response status was: " + client.status + " " + client.statusText + ".");
}

function getWeatherWithAjax() {
    var ss = "http://api.openweathermap.org/data/2.5/weather?q=";
    var city = document.getElementById("weatherForm:city").value
    var data =  $('#city').html

    ss = ss.concat(city)

    $.ajax({
        url: ss,
        data: data,
        success: function( data ) {
            $('#weatherResponse').html(data.name);
        }
    });

}

$(function() {
    console.log( "document ready" );
});

$( window ).load(function() {
    console.log( "window loaded" );
});


