/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Entity.Person;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Edison Parra
 */
public class PersonDao {

    /**
     * @param p The person object that will be updated
     * @param em EntityManager object to make the operation
     */
    public void updatePass(Person p, EntityManager em) {
        em.merge(p);
    }

    public List<Person> searchByUsername(String username, EntityManager em) {
        Query q = em.createNamedQuery("Person.findByUserName");
        q.setParameter("userName", username);
        List<Person> person = new ArrayList<Person>();
        person.add((Person) q.getSingleResult());
        return person;
    }

   /**
     * @param p The person object that will be created
     * @param em EntityManager object to make the operation
     */
    public void create(Person p, EntityManager em) {
        em.persist(p);
    }

    /**
     * @param p The person object that will be deleted
     * @param em EntityManager object to make the operation
     */
    public void delete(Person p, EntityManager em) {
        em.remove(em.merge(p));
    }
}
