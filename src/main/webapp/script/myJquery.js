//Test with jquery
$(document).ready(function(){
    $("#button2").click(function(){
        doXMLHttpRequest()
    });
});

$(document).ready(function() {

    //id selector
    $("#button3").click(function(){
        alert("you clicked me");
    });

    //class selector
    $(".pp").click(function(){
        $(this).fadeOut();
    });

    //element selector
    $("p").click(function(){
        $(this).hide();
    });

    //this will hide all elements
    //$("*").click(function(){
    //    $(this).hide();
    //});

    $("input").focus(function(){
            $(this).css("background-color", "#cccccc");
    });
    $("input").blur(function(){
        $(this).css("background-color", "#ffffff");
    });

    $("button.continue").html( "Next Step..." )

    $.ajax({
        url: "http://api.openweathermap.org/data/2.5/weather?q=London,uk",
        data: {
            zipcode: 97201
        },
        success: function( data ) {
            $( "#weather-temp" ).html( "<strong>" + data + "</strong> degrees" );
        }
    });

});


$(function() {
    console.log( "document ready" );
});

$( window ).load(function() {
    console.log( "window loaded" );
});


