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
public class MyBookView {
    private ArrayList<MyBook> bookList;
    private final int userId;
    
    public MyBookView(int userId){
        this.userId = userId;
    }
    
    public void fill(){
        bookList = SQLCore.getMyBookView(userId);
    }
    
    public ArrayList<MyBook> getBookList(){
        return this.bookList;
    }
    
    public MyBook getBook(int index){
        return bookList.get(index);
    }
    
    public static MyBook findBookByIsbn(ArrayList<MyBook> list, String isbn){
        for(MyBook item: list){
            if(item.getIsbn().equals(isbn)){
                return item;
            }
        }
        
        return null;
    }
    
    public static MyBook findBookById(ArrayList<MyBook> list, int id){
        for(MyBook item: list){
            if(item.getId() == id){
                return item;
            }
        }
        
        return null;
    }
    
    public void printBooks(){
        
        for(MyBook item: bookList){
            System.out.println(item.toString());
        }
    }
    
    private int size(){
        return bookList.size();
    }
    
    public static void main(String[] args) {
        MyBookView lib = new MyBookView(3);
        
        lib.fill();
        lib.printBooks();
    }
}
