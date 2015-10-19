package no.frodo.moap.service;

import no.frodo.moap.data.UserRepository;
import no.frodo.moap.data.WeatherRepository;
import no.frodo.moap.domain.User;
import no.frodo.moap.domain.Weather;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Logger;

@Stateless
public class UserService implements Serializable {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private UserRepository userRepository;

    public boolean validate(String userName, String password) {

        User user = null;

        try {
            user = userRepository.findByNameAndPassword(userName, password);
        } catch (NoResultException e) {
            System.out.printf(e.getMessage());
        }

        return user != null;
    }
}