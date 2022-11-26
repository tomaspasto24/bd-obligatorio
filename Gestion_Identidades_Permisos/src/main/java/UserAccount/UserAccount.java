/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserAccount;

/**
 *
 * @author TomasUcu
 */
public class UserAccount {

    public static UserAccount instance;

    public static UserAccount getInstance() {
        if (instance == null) {
            instance = new UserAccount();
        }
        return instance;
    }

    private int userId;

    public void setUserId(int id) {
        this.userId = id;
    }
    
    public int getUserId(){
        return this.userId;
    }
    
    
}