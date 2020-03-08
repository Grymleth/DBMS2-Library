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
public class BookCopyView {
    ArrayList<BookCopy> bookList;
    
    public void fill(String isbn){
        bookList = SQLCore.getBookCopies(isbn);
    }
    
    public ArrayList<BookCopy> getCopyList(){
        return this.bookList;
    }
    
    public BookCopy getCopy(int index){
        return bookList.get(index);
    }
    
    public void printBooks(){
        for(BookCopy item: bookList){
            System.out.println(item);
        }
    }
}
