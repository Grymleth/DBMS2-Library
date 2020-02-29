
import Custom.LibUser;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author raito
 */
public class SQLCore extends SQLDriver {
    
    public static void insertUser(LibUser person){
        String statement = String.format("call add_user('%s','%s','%s','%s','%s','%c')", 
                person.loginid, 
                person.fName, 
                person.lName, 
                person.password, 
                person.address,
                person.librarian);
        System.out.println(statement);
        
        try(Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                CallableStatement query = con.prepareCall(statement);
                ){
            query.execute();
        }catch(SQLException ex){
            
            System.out.println(USER + " " + PASS);
            System.out.println(ex.getLocalizedMessage());
            return;
        }
        
        System.out.println("SQL Success");
    }
    
    public static void authenticateUser(LibUser person){
        String statement = String.format("call authenticate_user('%s','%s')", 
                person.loginid,
                person.password);
        System.out.println(statement);
        
        try(Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                CallableStatement query = con.prepareCall(statement);
                ){
            query.execute();
        }catch(SQLException ex){
            
            System.out.println(USER + " " + PASS);
            System.out.println(ex.getLocalizedMessage());
            return;
        }
        
        System.out.println("SQL Success");
    }
}
