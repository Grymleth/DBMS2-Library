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
public class MyBook {
    private int bookId;
    private String title;
    private ArrayList<String> authors;
    private String isbn;
    private int year;
    private int copyNo;
    private Date date;
    private String status;
    
    public MyBook(int bookId, String title, String author, String isbn, int year, int copyNo, Date date, String status){
        this.bookId = bookId;
        this.title = title;
        this.authors = new ArrayList<>();
        this.authors.add(author);
        this.isbn = isbn;
        this.year = year;
        this.copyNo = copyNo;
        this.date = date;
        this.status = status;
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
        
        return String.format("'%s','%s','%s',%d,%s,%s",
                title,
                authorList,
                isbn,
                copyNo,
                date.toString(),
                status);
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
       
        arr[0] = title;
        arr[1] = authorList;
        arr[2] = isbn;
        arr[3] = Integer.toString(year);
        arr[4] = Integer.toString(copyNo);
        arr[5] = date.toString();
        arr[6] = status;
        
        return arr;
    }
    
    public int getId(){
        return bookId;
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
    
    public int getCopyNo(){
        return copyNo;
    }
    
    public void setCopyNo(int copyNo){
        this.copyNo = copyNo;
    }
    
    public Date getDate(){
        return this.date;
    }
    
    public void setDate(Date date){
        this.date = date;
    }
    
    public String getStatus(){
        return this.status;
    }
    
    public void setStatus(String status){
        this.status = status;
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
