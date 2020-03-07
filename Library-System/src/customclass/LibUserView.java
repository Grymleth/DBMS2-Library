/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customclass;

import java.util.ArrayList;
import oracledb.SQLCore;

/**
 *
 * @author aevan
 */
public class LibUserView {
    ArrayList<LibUser> userList;
    
    
    public void fill(){
        userList = SQLCore.getUserView();
    }
    
    public static LibUser findUserByLoginId(ArrayList<LibUser> list, String loginid){
        for(LibUser item: list){
            if(item.loginid.equals(loginid)){
                return item;
            }
        }
        return null;
    }
    
    public ArrayList<LibUser> getUserList(){
        return this.userList;
    }
    
    public LibUser getUser(int index){
        return userList.get(index);
    }
}
