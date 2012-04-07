/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import View.Principal;
import java.util.List;

/**
 *
 * @author Edison Parra
 */
public class Actual_User {
    private static Actual_User instance;
    private String username;
    private Principal principal;
    private long id;
    private double balance;
    private double balanceOnChange;
    

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    private Actual_User(){
    }

    public static synchronized Actual_User getInstance(){
	if(instance == null)
		instance = new Actual_User();
	return instance;
    }

    public void setInstance(String n, String un, long id, double balance){
        instance.username = un;
        instance.id = id;
        instance.balance = balance;
    }

    public void setNull(){
        instance = null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalanceOnChange() {
        return balanceOnChange;
    }

    public void setBalanceOnChange(double balanceOnChange) {
        this.balanceOnChange = balanceOnChange;
    }

}
