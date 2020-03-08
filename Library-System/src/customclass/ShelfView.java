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
    
    public ArrayList<Shelf> getCopyList(){
        return this.shelfList;
    }
    
    public Shelf getShelf(int index){
        return shelfList.get(index);
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
