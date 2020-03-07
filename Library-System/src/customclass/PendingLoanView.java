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
public class PendingLoanView {
    ArrayList<PendingLoan> pendingList;
    
    public void fill(){
        pendingList = SQLCore.getPendingLoanView();
    }
    
    public ArrayList<PendingLoan> getPendingList(){
        return this.pendingList;
    }
    
    public PendingLoan getPending(int index){
        return pendingList.get(index);
    }
    
    
    public static PendingLoan findPendingByNo(ArrayList<PendingLoan> list, int transactionNo){
        for(PendingLoan item: list){
            if(item.getTransactionNo() == transactionNo){
                return item;
            }
        }
        
        return null;
    }
    
    public void printPending(){
        for(PendingLoan item: pendingList){
            System.out.println(item.toString());
        }
    }
    
    public int size(){
        return pendingList.size();
    }
    
    public static void main(String[] args) {
        PendingLoanView lib = new PendingLoanView();
        
        lib.fill();
        lib.printPending();
    }
}
