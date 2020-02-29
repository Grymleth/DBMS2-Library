/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Custom;

/**
 *
 * @author aevan
 */
public class LibUser {
    public String loginid;
    public String password;
    public String fName;
    public String lName;
    public String address;
    public char librarian;
    
    public LibUser(String loginid,String password,String fName,String lName,String address, char librarian){
        this.loginid = loginid;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.librarian = librarian;
    }
}
