/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customclass;

import java.util.Iterator;

/**
 *
 * @author aevan
 */
public class BookCopy {
    private int copyNo;
    private String status;
    
    public BookCopy(int copyNo, String status){
        this.copyNo = copyNo;
        this.status = status;
    }
    
    public int getCopyNo(){
        return this.copyNo;
    }
    
    public String getStatus(){
        return this.status;
    }
    
    @Override
    public String toString(){
        
        return String.format("%d,'%s'",
                copyNo,
                status);
    }
    
    public String[] toRow(){
        String[] arr = new String[2];
        arr[0] = Integer.toString(copyNo);
        arr[1] = status;
        
        return arr;
    }
}
