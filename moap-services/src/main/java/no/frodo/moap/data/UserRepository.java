package no.frodo.moap.data;

import no.frodo.moap.domain.User;

public interface UserRepository {

    public User findByNameAndPassword(String name, String password);

}
