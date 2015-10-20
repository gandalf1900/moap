package no.frodo.moap.service.rs;

import no.frodo.moap.domain.City;
import no.frodo.moap.persistence.CityRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/moap")
@RequestScoped
public class MoapCityRestService {

    @Inject
    private CityRepository cityRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<City> listAllCities() {
        return cityRepository.findAllCitiesOrderedByName();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public City lookupCityById(@PathParam("id") long id) {
        City city = cityRepository.findById(id) ;
        if (city == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return city;
    }
}
