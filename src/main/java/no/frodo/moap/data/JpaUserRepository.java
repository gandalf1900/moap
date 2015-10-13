package no.frodo.moap.data;


import no.frodo.moap.domain.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import java.util.List;

public class JpaUserRepository implements UserRepository
{

    @Inject
    private EntityManager em;

    @Override
    public User findByNameAndPassword(String userName, String password) {

        User myUser = null;

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<User> criteria = cb.createQuery(User.class);
            Root<User> user = criteria.from(User.class);
            criteria.select(user).where(cb.equal(user.get("userName"), userName));
            final TypedQuery<User> query = em.createQuery(criteria);
            myUser = query.getSingleResult();

            System.out.println(myUser);


        } catch (Exception e) {
            System.out.println(e);
        }

        return myUser;
    }

}
