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
public class SearchBookView {
    private ArrayList<SearchBook> bookList;
    
    private int size;
    
    public void fill(){
        bookList = SQLCore.getSearchBookView();
    }
    
    public ArrayList<SearchBook> getBookList(){
        return this.bookList;
    }
    
    public SearchBook getBook(int index){
        return bookList.get(index);
    }
    
    public static SearchBook findIsbn(ArrayList<SearchBook> list, String isbn){
        for(SearchBook item: list){
            if(item.getIsbn().equals(isbn)){
                return item;
            }
        }
        
        return null;
    }
    
    public void printBooks(){
        
        for(SearchBook item: bookList){
            System.out.println(item.toString());
        }
    }
    
    public static void main(String[] args) {
        SearchBookView lib = new SearchBookView();
        
        lib.fill();
        lib.printBooks();
    }
}
