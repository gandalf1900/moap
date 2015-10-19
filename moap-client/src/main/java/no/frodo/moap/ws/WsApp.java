package no.frodo.moap.ws;

import moap.frodo.no.generated.EchoServiceWS;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceRef;
import java.net.MalformedURLException;
import java.net.URL;

public class WsApp {

    @WebServiceRef(wsdlLocation="http://localhost:8080/moap/EchoServiceWS?wsdl")
    static EchoServiceWS service;

    public static void main(String[] args) {
        try {
            WsApp client = new WsApp();
            client.doTest(args);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void doTest(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/moap/EchoServiceImpl?wsdl");
        QName qname = new QName("http://ws.service.moap.frodo.no/", "EchoServiceImplService");
        Service service = Service.create(url, qname);
        EchoServiceWS echoService = service.getPort(EchoServiceWS.class);
        String echo = echoService.echo("frodo");
        System.out.println(echo);
    }
}
