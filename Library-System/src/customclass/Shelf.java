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
public class Shelf {
    private int shelfId;
    private int capacity;
    
    public Shelf(int shelfId, int capacity){
        this.shelfId = shelfId;
        this.capacity = capacity;
    }
    
    public int getId(){
        return this.shelfId;
    }
    
    public int getCapacity(){
        return this.capacity;
    }
    
    @Override
    public String toString(){
        
        return String.format("%d,%d",
                shelfId,
                capacity);
    }
    
    public String[] toRow(){
        String[] arr = new String[2];
        arr[0] = Integer.toString(shelfId);
        arr[1] = Integer.toString(capacity);
        
        return arr;
    }
}
