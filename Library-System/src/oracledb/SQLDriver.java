package oracledb;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author raito
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDriver {
    /*
    This class determines which SQL server to connect to 
    Also determines the User and password in order to use the database
    */
    protected final static String CONNECTION_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    protected final static String USER = "dbms2";
    protected final static String PASS = "password1";
    
    protected SQLDriver(){
        try(Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);){
        }catch(SQLException ex){
            System.out.println(ex.getLocalizedMessage());
        }
    }
   
}
