package no.frodo.moap.service.ws;

import javax.inject.Inject;
import javax.jws.WebService;
import java.util.logging.Logger;

@WebService(endpointInterface = "no.frodo.moap.service.ws.EchoServiceWS")
public class EchoServiceImpl implements EchoServiceWS {

    @Inject
    private Logger log;

    @Override
    public String echo(String input) {
        log.info("echo : " + input);
        return input;
    }
}
