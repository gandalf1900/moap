package no.frodo.moap.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class EchoServiceWS {

    @WebMethod
    public String echo(String input) {
        return null;
    }
}
