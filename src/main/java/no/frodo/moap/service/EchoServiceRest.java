package no.frodo.moap.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/message")
public class EchoServiceRest  {
    @GET
    @Path("/{param}")
    public Response printMessage(@PathParam("param") String msg) {
        String result = "Hello " + msg + ", rest service is alive";
        return Response.status(200).entity(result).build();
    }
}
