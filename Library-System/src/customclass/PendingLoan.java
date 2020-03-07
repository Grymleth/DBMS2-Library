/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customclass;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author aevan
 */
public class PendingLoan {
    private int transactionNo;
    private String fullName;
    private String title;
    private ArrayList<String> authors;
    private String isbn;
    private int copyNo;
    private Date date;
    
    public PendingLoan(int transactionNo, String fullName, String title, 
            String author, String isbn, int copyNo, Date date){
        authors = new ArrayList<>();
        this.transactionNo = transactionNo;
        this.fullName = fullName;
        this.title = title;
        this.authors.add(author);
        this.isbn = isbn;
        this.copyNo = copyNo;
        this.date = date;
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
        
        return String.format("%d, %s, %s, %s, %s, %d, %s",
                transactionNo,
                fullName,
                title,
                authorList,
                isbn,
                copyNo,
                date.toString());
    }
    
    public String[] toRow(){
        String[] arr = new String[7];
        String authorList = "";
        
        Iterator iter = authors.iterator();
        while(iter.hasNext()){
            authorList += iter.next();
            if(iter.hasNext()){
                authorList += ", ";
            }
        }
        arr[0] = Integer.toString(transactionNo);
        arr[1] = fullName;
        arr[2] = title;
        arr[3] = authorList;
        arr[4] = isbn;
        arr[5] = Integer.toString(copyNo);
        arr[6] = date.toString();
        
        return arr;
    }
    
    public int getTransactionNo(){
        return this.transactionNo;
    }
    
    public String getFullName(){
        return this.fullName;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public ArrayList<String> getAuthors(){
        return this.authors;
    }
    
    public void addAuthor(String author){
        authors.add(author);
    }
    
    public String getIsbn(){
        return this.isbn;
    }
    
    public int getCopyNo(){
        return this.copyNo;
    }
    
    public Date getDate(){
        return this.date;
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
