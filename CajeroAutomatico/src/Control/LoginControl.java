/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.PersonDao;
import Entity.Actual_User;
import Entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;

/**
 *
 * @author Edison Parra
 * @since Versión 1, Abril 2
 */
public class LoginControl {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CajeroAutomaticoPU");

    /**
     *
     * @param name Username given by the user to login
     * @param password Password given by the user to login
     * @return true o false if the login was done successfully
     * @throws Exception
     */
    public boolean login(String name, final String password) throws Exception {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        final String username = name.toLowerCase();
        try {
            PersonDao personDao = new PersonDao();
            List<Person> people = personDao.searchByUsername(username, em);
            Person person = people.get(0);
            if (verifyPassword(person, password)) {
                /** Initializes the Actual_User instance  */
                Actual_User acUser = Actual_User.getInstance();
                acUser.setInstance(person.getName(), person.getUserName(), person.getId(), person.getBalance());
                return true;
            } else {
                return false;
            }
        } catch (NoResultException exp) {
            return false;
        } catch (NonUniqueResultException exp) {
            throw exp;
        } catch (Exception exp) {
            throw exp;
        } finally {
            em.close();
        }
    }

    private boolean verifyPassword(final Person person, final String password) {
        return person.getPassword().equals(password);
    }

    public void Logout() {
        Actual_User acuser = Actual_User.getInstance();
        acuser.setNull();
    }

}
