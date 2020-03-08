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
public class LibAuthor {
    private final int authorId;
    private final String name;
    
    public LibAuthor(int authorId, String name){
        this.authorId = authorId;
        this.name = name;
    }
    
    public int getId(){
        return this.authorId;
    }
    
    public String getName(){
        return this.name;
    }
    
    @Override
    public String toString(){
        return String.format("%d,'%s'",
                authorId,
                name);
    }
    
    public String[] toRow(){
        String[] arr = new String[2];
        
        arr[0] = Integer.toString(authorId);
        arr[1] = name;
        
        return arr;
    }
}
