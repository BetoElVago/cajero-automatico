/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Controlador.Operacion;
import Dao.PersonDao;
import Entity.Actual_User;
import Entity.Person;
import Modelo.Numero;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Laarguelless
 */
public class TransactionControl {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CajeroAutomaticoPU");
    private Operacion operation;
    private PersonDao personDao;

    public TransactionControl() {
        operation = new Operacion();
        personDao = new PersonDao();
    }

    public int Consignment() {
        Actual_User user = Actual_User.getInstance();
        double amount = user.getBalanceOnChange();
        /**
         * El monto dado no está entre los límites dados en la lógica de negocio
         */
        if (!validateConsignment(amount)) {
            return -1;
        }

        Numero balance = new Numero();
        balance.setValor(user.getBalance());

        Numero consign = new Numero();
        consign.setValor(amount);


        double nextAmount = operation.sumar(balance, consign).getValor();

        user.setBalance(nextAmount);

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            Person person = personDao.searchByUsername(user.getUsername(), em).get(0);
            person.setBalance(user.getBalance());
            personDao.updatePass(person, em);
            em.getTransaction().commit();
            return 0;
        } catch (Exception e) {
            return -2;
        } finally {
            em.close();
        }
    }

    public int retirement() {
        Actual_User user = Actual_User.getInstance();
        /**
         * El retiro no está dentro de los límites establecidos.
         */
        double amount = user.getBalanceOnChange();
        if (!validateRetiement(amount)) {
            return -1;
        }

        Numero balance = new Numero();
        balance.setValor(user.getBalance());

        Numero retirment = new Numero();
        retirment.setValor(amount);

        double nextBalance = operation.restar(balance, retirment).getValor();
        /**
         * La cantidad que se quiere retirar es mayor que la cantidad que el
         * cliente posee en su cuenta.
         */
        if (nextBalance < 0) {
            return -2;
        }
        user.setBalance(nextBalance);
        user.setBalanceOnChange(0);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Person person = personDao.searchByUsername(user.getUsername(), em).get(0);
            person.setBalance(user.getBalance());

            personDao.updatePass(person, em);
            em.getTransaction().commit();
            return 0;
        } catch (Exception ex) {
            return -3;
        } finally {
            em.close();
        }
    }

    private boolean validateConsignment(double amount) {
        if (amount % 10000 != 0 || amount > 1000000 || amount < 0) {
            return false;
        }
        return true;
    }

    private boolean validateRetiement(double amount) {
        if (amount < 10000 || amount > 400000) {
            return false;
        }
        return true;
    }

    public int Consignment(Person user, Double amount) {
        /**
         * El monto dado no está entre los límites dados en la lógica de negocio
         */
        if (!validateConsignment(amount)) {
            return -1;
        }

        Numero balance = new Numero();
        balance.setValor(user.getBalance());

        Numero consign = new Numero();
        consign.setValor(amount);
        
        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            Person person = personDao.searchByUsername(user.getUserName(), em).get(0);
            person.setBalance(user.getBalance());
            personDao.updatePass(person, em);
            em.getTransaction().commit();
            return 0;
        } catch (Exception e) {
            return -2;
        } finally {
            em.close();
        }
    }

    public double getBalance(String username) {
        EntityManager em = emf.createEntityManager();
        Person user = personDao.searchByUsername(username, em).get(0);
        return user.getBalance();
    }
}
