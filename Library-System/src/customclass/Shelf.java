/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customclass;

import java.util.Iterator;
import oracledb.SQLCore;

/**
 *
 * @author aevan
 */
public class Shelf {
    private int shelfId;
    private int contains;
    private int capacity;
    
    public Shelf(int shelfId, int capacity){
        this.shelfId = shelfId;
        this.capacity = capacity;
        this.contains = SQLCore.getShelfContains(shelfId);
    }
    
    public int getId(){
        return this.shelfId;
    }
    
    public int getCapacity(){
        return this.capacity;
    }
    
    public int getContains(){
        return this.contains;
    }
    
    @Override
    public String toString(){
        
        return String.format("%d,%d,%d",
                shelfId,
                capacity,
                contains);
    }
    
    public String[] toRow(){
        String[] arr = new String[3];
        arr[0] = Integer.toString(shelfId);
        arr[1] = Integer.toString(capacity);
        arr[2] = Integer.toString(contains);
        
        return arr;
    }
}
