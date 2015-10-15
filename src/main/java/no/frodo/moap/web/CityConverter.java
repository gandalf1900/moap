package no.frodo.moap.web;

import no.frodo.moap.data.CityRepository;
import no.frodo.moap.domain.City;
import no.frodo.moap.service.CityRegistrationService;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.commons.lang.StringUtils;

@FacesConverter(value = "cityConverter")
public class CityConverter implements Converter {


    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        City city = (City) value;
        return city.getName();
    }
}
