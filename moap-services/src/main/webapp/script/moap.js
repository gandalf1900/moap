function doXMLHttpRequest() {
    var url = "http://localhost:8080/moap/isalive/message/test";
    var client = new XMLHttpRequest();
    client.open("GET", url, false);
    client.setRequestHeader("Content-Type", "text/plain");
    client.send("test");

    if (client.status == 200)
        alert("The request succeeded!\n\nThe response representation was:\n\n" + client.responseText)
    else
        alert("The request did not succeed!\n\nThe response status was: " + client.status + " " + client.statusText + ".");
}

function testRestWithJavascript() {
    doXMLHttpRequest()
}


