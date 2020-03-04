/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customclass;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author aevan
 */
public class SearchBook {
    private String title;
    private ArrayList<String> authors;
    private String isbn;
    private int copies;
    private int onShelf;
    private int onLoan;
    private int onHold;
    private int shelfid;
    
    public SearchBook(String title, String author, String isbn, int shelfid){
        this.title = title;
        this.authors = new ArrayList<>();
        this.authors.add(author);
        this.isbn = isbn;
        this.copies = 1;
        this.onShelf = 0;
        this.onLoan = 0;
        this.onHold = 0;
        this.shelfid = shelfid;
    }
    
    @Override
    public String toString(){
        String authorList = "";
        Iterator iter = authors.iterator();
        while(iter.hasNext()){
            authorList += iter.next();
            if(iter.hasNext()){
                authorList += ", ";
            }
        }
        
        return String.format("'%s','%s','%s',%d,%d,%d,%d,%d",
                title,
                authorList,
                isbn,
                copies,
                onShelf,
                onLoan,
                onHold,
                shelfid);
    }
    
    public String[] toRow(){
        String[] arr = new String[8];
        String authorList = "";
        
        Iterator iter = authors.iterator();
        while(iter.hasNext()){
            authorList += iter.next();
            if(iter.hasNext()){
                authorList += ", ";
            }
        }
       
        arr[0] = title;
        arr[1] = authorList;
        arr[2] = isbn;
        arr[3] = Integer.toString(copies);
        arr[4] = Integer.toString(shelfid);
        arr[5] = Integer.toString(onShelf);
        arr[6] = Integer.toString(onLoan);
        arr[7] = Integer.toString(onHold);
        
        return arr;
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public ArrayList<String> getAuthor(){
        return authors;
    }
    
    public void addAuthor(String author){
        authors.add(author);
    }
    
    public String getIsbn(){
        return isbn;
    }
    
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    
    public int getCopies(){
        return copies;
    }
    
    public void setCopies(int copies){
        this.copies = copies;
    }
    
    public void addCopies(int x){
        setCopies(copies + x);
    }
    
    public int getOnShelf(){
        return this.onShelf;
    }
    
    public void setOnShelf(int onShelf){
        this.onShelf = onShelf;
    }
    
    public void addOnShelf(int x){
        setOnShelf(onShelf + x);
    }
    
    public int getOnLoan(){
       return this.onLoan;
    }
    
    public void setOnLoan(int onLoan){
        this.onLoan = onLoan;
    }
    
    public void addOnLoan(int x){
        setOnLoan(onLoan + x);
    }
    
    public int getOnHold(){
        return this.onHold;
    }
    
    public void setOnHold(int onHold){
        this.onHold = onHold;
    }
    
    public void addOnHold(int x){
        setOnHold(onHold + x);
    }
    
    public String findAuthor(String author){
        for(String item: authors){
            if(item.equals(author)){
                return item;
            }
        }
        return "~";
    }
}
