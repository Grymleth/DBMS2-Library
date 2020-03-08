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
public class LibAuthorView {
    private ArrayList<LibAuthor> authorList;
    
    public void fill(String isbn){
        authorList = SQLCore.getAuthors(isbn);
    }
    
    public ArrayList<LibAuthor> getAuthorList(){
        return this.authorList;
    }
    
    public LibAuthor getAuthor(int index){
        return authorList.get(index);
    }
    
    public static LibAuthor findAuthorById(ArrayList<LibAuthor> list, int id){
        for(LibAuthor item: list){
            if(item.getId() == id){
                return item;
            }
        }
        
        return null;
    }
    
    public static LibAuthor findAuthorByName(ArrayList<LibAuthor> list, String name){
        for(LibAuthor item: list){
            if(item.getName().equals(name)){
                return item;
            }
        }
        
        return null;
    }
    
    public void printAuthors(){
        for(LibAuthor item: authorList){
            System.out.println(item.toString());
        }
    }
    
    private int size(){
        return authorList.size();
    }
    
    public static void main(String[] args) {
        LibAuthorView lib = new LibAuthorView();
        
        lib.fill("1234567");
        lib.printAuthors();
    }
}
