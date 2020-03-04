package oracledb;
import customclass.SearchBook;
import customclass.SearchBookView;
import gui.LoginFrame;
import customclass.LibUser;
import customclass.MyBook;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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
    
    public static void insertUser(LibUser person, String password){
        String statement = String.format("call add_user('%s','%s','%s','%s','%s','%c'   )", 
                person.loginid, 
                person.fName, 
                person.lName, 
                password, 
                person.address,
                person.librarian,
                person.fines);
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
    
    public static LibUser authenticateUser(String username, String pass){
        String statement = "{?=call authenticate_user(?,?,?)}"; 
        String[] details;
        int id;
        try(Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                CallableStatement query = con.prepareCall(statement);
                ){
            query.registerOutParameter(1, Types.NUMERIC);
            query.setString(2, username);
            query.setString(3, pass);
            query.registerOutParameter(4, Types.NUMERIC);
            query.execute();
            
            System.out.println("USER LEVEL IS: "+ query.getInt(1));
            System.out.println("USER ID IS "+ (id = query.getInt(4)));
        }catch(SQLException ex){
            System.out.println(USER + " " + PASS);
            System.out.println(ex.getLocalizedMessage());
            return null;
        }
        
        details = getUser(id);
        
        if(details == null){
            return null;
        }
        
        for(String item: details){
            System.out.println(item);
        }
        LibUser user = new LibUser(Integer.parseInt(details[0]), details[1], details[2], details[3], details[4], details[5].charAt(0), Integer.parseInt(details[6]));
        LoginFrame.printUser(user);
        
        return user;
    }
    
    public static String[] getUser(int userId){
        String arr[] = new String[7];
        String statement = "SELECT user_id, login_id, first_name, last_name, address, librarian, unpaid_fines FROM library_users WHERE user_id='"
                + userId + "'";
        try (Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                PreparedStatement query = con.prepareStatement(statement);) {
            ResultSet res = query.executeQuery();
            while (res.next()) {
                System.out.println("whatwhatwhat!!!!");
                arr[0] = res.getString("user_Id");
                arr[1] = res.getString("login_id");
                arr[2] = res.getString("first_name");
                arr[3] = res.getString("last_name");
                arr[4] = res.getString("address");
                arr[5] = res.getString("librarian");
                arr[6] = res.getString("unpaid_fines");
                return arr;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public static ArrayList<SearchBook> getSearchBookView(){
        ArrayList<SearchBook> bookList = new ArrayList<>();
        
        String statement = "SELECT b.title, a.author_name, b.isbn, b.copy_no, b.status, b.shelf_id "
                + "FROM books b, authors a, book_author ba "
                + "WHERE b.isbn = ba.book_isbn AND a.author_id = ba.author_id";
        String isbn;
        SearchBook bookObj;
        String author;
        try (Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                PreparedStatement query = con.prepareStatement(statement);) {
            ResultSet res = query.executeQuery();
            while (res.next()) {
                isbn = res.getString("isbn");
                bookObj = SearchBookView.findIsbn(bookList, isbn);
                if(bookObj == null){
                    bookObj = new SearchBook(res.getString("title"),
                                          res.getString("author_name"),
                                          isbn,
                                          res.getInt("shelf_id"));
                    bookList.add(bookObj);
                }
                else{
                    author = bookObj.findAuthor(res.getString("author_name"));
                    if(author.equals("~")){
                        bookObj.addAuthor(res.getString("author_name"));
                        continue;
                    }
                    else{
                        bookObj.addCopies(1);
                    }
                }
                
                switch(res.getString("status")){
                    case "On Shelf":{
                        bookObj.addOnShelf(1);
                        break;
                    }
                    case "On Loan":{
                        bookObj.addOnLoan(1);
                        break;
                    }
                    case "On Hold":{
                        bookObj.addOnHold(1);
                        break;
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return bookList;
    }
    
    public static void borrowBook(LibUser user, SearchBook book){
        String statement = "{call borrow_book(?,?)}"; 
        try(Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                CallableStatement query = con.prepareCall(statement);
                ){
            query.setInt(1, user.userId);
            query.setString(2, book.getIsbn());
            query.execute();
            
        }catch(SQLException ex){
            System.out.println(USER + " " + PASS);
            System.out.println(ex.getLocalizedMessage());
        }
    }
    
    public static ArrayList<MyBook> getMyBookView(int userId){
        ArrayList<MyBook> bookList = new ArrayList<>();
        String author;
        MyBook bookObj = null;
        String statement = "SELECT b.title, a.author_name, b.isbn, b.copy_no, bt.transaction_date, b.status "
                + "FROM books b, authors a, book_transactions bt, book_author ba, library_users u "
                + "WHERE b.isbn = ba.book_isbn AND a.author_id = ba.author_id "
                + "AND b.book_id = bt.book_id AND u.user_id = bt.user_id "
                + "AND u.user_id = ?";
        
        try (Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                PreparedStatement query = con.prepareStatement(statement);) {
            query.setInt(1, userId);
            ResultSet res = query.executeQuery();
            
            res.next();
            bookObj = new MyBook(res.getString("title"),
                                     res.getString("author_name"),
                                     res.getString("isbn"),
                                     res.getInt("copy_no"),
                                     res.getDate("transaction_date"),
                                     res.getString("status"));
            do{
                author = bookObj.findAuthor(res.getString("author_name"));
                
                if(author.equals("~")){
                    bookObj.addAuthor(res.getString("author_name"));
                }
                else{
                    bookObj = new MyBook(res.getString("title"),
                                     res.getString("author_name"),
                                     res.getString("isbn"),
                                     res.getInt("copy_no"),
                                     res.getDate("transaction_date"),
                                     res.getString("status"));
                    bookList.add(bookObj);
                }
            }
            while(res.next());
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return bookList;
    }
}
    
