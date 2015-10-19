package no.frodo.moap.service.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface EchoServiceWS {

    @WebMethod
    public String echo(String input);
}
