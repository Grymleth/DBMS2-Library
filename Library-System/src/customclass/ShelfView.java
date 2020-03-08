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
public class ShelfView {
    ArrayList<Shelf> shelfList;
    
    public void fill(){
        shelfList = SQLCore.getShelves();
    }
    
    public ArrayList<Shelf> getShelves(){
        return this.shelfList;
    }
    
    public Shelf getShelf(int index){
        return shelfList.get(index);
    }
    
    public Object[] getIdArray(){
        Object[] x = new Object[shelfList.size()];
        for(int i=0;i<shelfList.size();i++){
            x[i] = shelfList.get(i).getId();
        }
        
        return x;
    }
    
    public Shelf findShelfById(int shelfId){
        for(Shelf item: shelfList){
            if(item.getId() == shelfId){
                return item;
            }
        }
        
        return null;
    }
    
    public void printShelves(){
        for(Shelf item: shelfList){
            System.out.println(item);
        }
    }
    
    public static void main(String[] args) {
        ShelfView lib = new ShelfView();
        
        lib.fill();
        lib.printShelves();
    }
}
