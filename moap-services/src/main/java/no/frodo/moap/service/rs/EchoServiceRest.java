package no.frodo.moap.service.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/isalive/message")
public class EchoServiceRest  {
    @GET
    @Path("/{param}")
    @Produces("application/json")
    public Response printMessage(@PathParam("param") String msg) {
        String result = "Hello " + msg + ", rest service is alive";
        return Response.status(200).entity(result).build();
    }
}
