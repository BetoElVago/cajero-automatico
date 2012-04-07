/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import Dao.PersonDao;
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
 */
public class PersonControl {
    
   private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CajeroAutomaticoPU");

    /**
     *
     *
     * @param person
     * @return true or false
     */
    public int createUser(Person person) {
        int result = verifyInfo(person);
        if (result != 0) {
            return result;
        }
        EntityManager em = emf.createEntityManager();
        PersonDao personDao = new PersonDao();
        em.getTransaction().begin();
        try {
            personDao.create(person, em);
            em.getTransaction().commit();
            return 0;
        } catch (NoResultException ex) {
            return -4;
        } catch (NonUniqueResultException ex) {
            return -4;
        } finally {
            em.close();
        }
    }

    public int verifyInfo(final Person person) {
        try {
            if (!verifyUsernameLength(person.getUserName())) {
                return -1;
            }
            if (!verifyPasswordLength(person.getPassword())) {
                return -2;
            }
             if (existsUsername(person.getUserName())) {
                return -3;
            }
            if (!verifyDocumentLength(person.getDocument())) {
                return -4;
            }
            return 0;
        } catch (Exception ex) {
            return -5;
        }
    }

    /**
     *
     * @param username
     * @return true if the username length is correct. false otherwise
     */
    public boolean verifyUsernameLength(final String username) {
        return (username.matches(".{5,20}"));
    }

    /**
     *
     * @param password
     * @return true if the password length is correct. false otherwise
     */
    public boolean verifyPasswordLength(final String password) {
        return (password.matches(".{5,30}"));
    }

    /**
     *
     * @param username the Username
     * @return true if the username exists in the data base. False otherwise
     */
    public boolean existsUsername(final String username) {
        PersonDao personDao = new PersonDao();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            List<Person> persons = personDao.searchByUsername(username, em);
            if (!persons.isEmpty()) {
                return true;
            } else {
                return  false;
            }
        } catch (NoResultException ex) {
            return false;
        } catch (NonUniqueResultException ex) {
            return false;
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param document
     * @return true if the username length is correct. false otherwise
     */
    public boolean verifyDocumentLength(final String document) {
        return (document.matches(".{7,12}"));
    }

    public int updatePass(String username, String newPass) {
        if(!verifyPasswordLength(newPass)){
            return -1;
        }
        EntityManager em = emf.createEntityManager();
        try {
            PersonDao personDao = new PersonDao();
            List<Person> persons = personDao.searchByUsername(username, em);
            Person person = persons.get(0);
            person.setPassword(newPass);
            em.getTransaction().begin();
            personDao.updatePass(person, em);
            em.getTransaction().commit();
            return 0;
        } catch (NoResultException ex) {
            return -2;
        } catch (NonUniqueResultException ex) {
            return -2;
        } finally {
            em.close();
        }
    }

    public boolean delete(String username) {
        EntityManager em = emf.createEntityManager();
        PersonDao personDao = new PersonDao();
        em.getTransaction().begin();
        try {
            List<Person> persons = personDao.searchByUsername(username, em);
            personDao.delete(persons.get(0), em);
            em.getTransaction().commit();
            return true;
        } catch (NoResultException ex) {
            return false;
        } catch (NonUniqueResultException ex) {
            return false;
        } finally {
            em.close();
        }
    }

}
