/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customclass;

/**
 *
 * @author aevan
 */
public class LibUser {
    public int userId;
    public String loginid;
    public String fName;
    public String lName;
    public String address;
    public char librarian;
    public int fines;
    
    public LibUser(int userId,String loginid, String fName,String lName,String address, char librarian){
        this.userId = userId;
        this.loginid = loginid;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.librarian = librarian;
        fines = 0;
    }
    
    public LibUser(String loginid, String fName,String lName,String address, char librarian){
        this(0,loginid, fName, lName, address, librarian);
        fines = 0;
    }
    
    public LibUser(int userId, String loginid, String fName,String lName,String address, char librarian, int fines){
        this(userId, loginid, fName, lName, address, librarian);
        this.fines = fines;
    }
    
    @Override
    public String toString(){
        return String.format("%d,%s,%s,%s,%s,%c,%d",
                userId,
                loginid,
                fName,
                lName,
                address,
                librarian,
                fines);
    }
    
    public String[] toRow(){
        String[] arr = new String[6];
        
        arr[0] = loginid;
        arr[1] = fName;
        arr[2] = lName;
        arr[3] = address;
        arr[4] = Character.toString(librarian);
        arr[5] = Integer.toString(fines);
        
        return arr;
    }
}
