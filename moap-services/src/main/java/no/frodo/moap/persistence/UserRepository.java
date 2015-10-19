package no.frodo.moap.persistence;

import no.frodo.moap.domain.User;

public interface UserRepository {

    public User findByNameAndPassword(String name, String password);

}
