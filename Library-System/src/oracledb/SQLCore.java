package oracledb;
import customclass.BookCopy;
import customclass.LibAuthor;
import customclass.SearchBook;
import customclass.SearchBookView;
import gui.LoginFrame;
import customclass.LibUser;
import customclass.MyBook;
import customclass.MyBookView;
import customclass.PendingLoan;
import customclass.PendingLoanView;
import customclass.Shelf;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
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
        String statement = String.format("call add_user('%s','%s','%s','%s','%s','%c')", 
                person.loginid, 
                person.fName, 
                person.lName, 
                password, 
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
        
        String statement = "SELECT b.title, a.author_name, b.isbn, b.year_published, b.copy_no, b.status, b.shelf_id "
                + "FROM books b, authors a, book_author ba "
                + "WHERE b.isbn = ba.book_isbn AND a.author_id = ba.author_id ORDER BY isbn";
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
                                          res.getInt("year_published"),
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
    
    public static ArrayList<MyBook> getMyBookView(int userId){
        ArrayList<MyBook> bookList = new ArrayList<>();
        String author;
        MyBook bookObj = null;
        String statement = "SELECT b.book_id, b.title, a.author_name, b.isbn, b.year_published, b.copy_no, bt.transaction_date, b.status "
                + "FROM books b, authors a, book_transactions bt, book_author ba, library_users u "
                + "WHERE b.isbn = ba.book_isbn AND a.author_id = ba.author_id "
                + "AND b.book_id = bt.book_id AND u.user_id = bt.user_id "
                + "AND u.user_id = ?";
        
        try (Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                PreparedStatement query = con.prepareStatement(statement);) {
            query.setInt(1, userId);
            ResultSet res = query.executeQuery();
            
            res.next();
            bookObj = new MyBook(res.getInt("book_id"),
                                res.getString("title"),
                                res.getString("author_name"),
                                res.getString("isbn"),
                                res.getInt("year_published"),
                                res.getInt("copy_no"),
                                res.getDate("transaction_date"),
                                res.getString("status"));
            bookList.add(bookObj);
            
            while(res.next()){
                bookObj = MyBookView.findBookById(bookList, res.getInt("book_id"));
                if(bookObj != null){
                    author = bookObj.findAuthor(res.getString("author_name"));
                    if(author.equals("~")){
                        bookObj.addAuthor(res.getString("author_name"));
                    }
                }
                else{
                    bookObj = new MyBook(res.getInt("book_id"),
                                     res.getString("title"),
                                     res.getString("author_name"),
                                     res.getString("isbn"),
                                     res.getInt("year_published"),
                                     res.getInt("copy_no"),
                                     res.getDate("transaction_date"),
                                     res.getString("status"));
                    bookList.add(bookObj);
                }
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
            System.out.println("Error getMyBookView");
            return null;
        }
        
        System.out.println("Success getMyBookView");
        return bookList;
    }
    
    public static ArrayList<LibUser> getUserView(){
        ArrayList<LibUser> userList = new ArrayList<>();
        String statement = "SELECT user_id, login_id, first_name, last_name, login_password, "
                + "address, librarian, unpaid_fines "
                + "FROM library_users ORDER BY user_id";
        LibUser userObj;
        
        try (Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                PreparedStatement query = con.prepareStatement(statement);) {
            
            ResultSet res = query.executeQuery();
            while(res.next()){
                userObj = new LibUser(res.getInt("user_id"),
                                      res.getString("login_id"),
                                      res.getString("first_name"),
                                      res.getString("last_name"),
                                      res.getString("address"),
                                      res.getString("librarian").charAt(0),
                                      res.getInt("unpaid_fines"));
                
                userList.add(userObj);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
            System.out.println("Error getUserView");
            return null;
        }
        
        System.out.println("Success getUserView");
        return userList;
    }
    
    
    
    public static ArrayList<PendingLoan> getPendingLoanView(){
        ArrayList<PendingLoan> pendingList = new ArrayList<>();
        String author;
        PendingLoan pendingObj = null;
        String statement = "SELECT bt.transaction_no, u.first_name || ' ' || u.last_name as full_name, b.title, a.author_name, b.isbn, b.copy_no, bt.transaction_date "
                + "FROM books b, library_users u, authors a, book_transactions bt, book_author ba "
                + "WHERE bt.user_id = u.user_id AND bt.book_id = b.book_id AND ba.book_isbn = b.isbn AND ba.author_id = a.author_id AND b.status = 'On Hold'";
        
        try (Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                PreparedStatement query = con.prepareStatement(statement);) {
            ResultSet res = query.executeQuery();
            
            res.next();
            pendingObj = new PendingLoan(res.getInt("transaction_no"),
                                         res.getString("full_name"),
                                         res.getString("title"),
                                         res.getString("author_name"),
                                         res.getString("isbn"),
                                         res.getInt("copy_no"),
                                         res.getDate("transaction_date"));
            pendingList.add(pendingObj);
            while(res.next()){
                pendingObj = PendingLoanView.findPendingByNo(pendingList, res.getInt("transaction_no"));
                if(pendingObj != null){
                    author = pendingObj.findAuthor(res.getString("author_name"));
                    if(author.equals("~")){
                        pendingObj.addAuthor(res.getString("author_name"));
                    }
                }
                else{
                    pendingObj = new PendingLoan(res.getInt("transaction_no"),
                                         res.getString("full_name"),
                                         res.getString("title"),
                                         res.getString("author_name"),
                                         res.getString("isbn"),
                                         res.getInt("copy_no"),
                                         res.getDate("transaction_date"));
                    pendingList.add(pendingObj);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
            System.out.println("Error pendingView");
            return null;
        }
        
        System.out.println("Success pendingView");
        return pendingList;
    }
    
    public static ArrayList<LibAuthor> getAuthors(String isbn){
        ArrayList<LibAuthor> authorList = new ArrayList<>();
        String statement = "SELECT a.author_id, a.author_name "
                + "FROM authors a, book_author ba "
                + "WHERE a.author_id = ba.author_id AND ba.book_isbn = ? ORDER BY author_id";
        LibAuthor authorObj;
        
        try (Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                PreparedStatement query = con.prepareStatement(statement);) {
            query.setString(1, isbn);
            ResultSet res = query.executeQuery();
            while(res.next()){
                authorObj = new LibAuthor(res.getInt("author_id"), res.getString("author_name"));
                authorList.add(authorObj);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
            System.out.println("Error getAuthorView");
            return null;
        }
        
        System.out.println("Success getAuthorView");
        return authorList;
    }
    
    public static ArrayList<BookCopy> getBookCopies(String isbn){
        ArrayList<BookCopy> bookList = new ArrayList<>();
        String statement = "SELECT copy_no, status FROM books WHERE isbn = ?";
        BookCopy copyObj;
        
        try (Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                PreparedStatement query = con.prepareStatement(statement);) {
            query.setString(1, isbn);
            ResultSet res = query.executeQuery();
            while(res.next()){
                copyObj = new BookCopy(res.getInt("copy_no"), res.getString("status"));
                bookList.add(copyObj);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
            System.out.println("Error getCopyList");
            return null;
        }
        
        System.out.println("Success getCopyList");
        return bookList;
    }
    
    public static ArrayList<Shelf> getShelves(){
        ArrayList<Shelf> shelfList = new ArrayList<>();
        String statement = "SELECT shelf_id, capacity FROM shelves";
        Shelf shelfObj;
        
        try (Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                PreparedStatement query = con.prepareStatement(statement);) {
            ResultSet res = query.executeQuery();
            while(res.next()){
                shelfObj = new Shelf(res.getInt("shelf_id"), res.getInt("capacity"));
                shelfList.add(shelfObj);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
            System.out.println("Error getShelves");
            return null;
        }
        
        System.out.println("Success getShelves");
        return shelfList;
    }
    
    public static void borrowBook(LibUser user, SearchBook book){
        String statement = "{call borrow_book(?,?)}"; 
        try(Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                CallableStatement query = con.prepareCall(statement);
                ){
            System.out.println();
            query.setInt(1, user.userId);
            query.setString(2, book.getIsbn());
            query.execute();
            
        }catch(SQLException ex){
            System.out.println(ex.getLocalizedMessage());
            System.out.println("Error borrowBook");
            return;
        }
        
        System.out.println("Success borrowBook");
    }
    
    public static void returnBook(LibUser user, MyBook book){
        String statement = "{call return_book(?,?,?)}"; 
        try(Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                CallableStatement query = con.prepareCall(statement);
                ){
            query.setInt(1, user.userId);
            query.setString(2, book.getIsbn());
            query.setInt(3, book.getCopyNo());
            query.execute();
            
        }catch(SQLException ex){
            System.out.println(ex.getLocalizedMessage());
            System.out.println("Error return Book");
            return;
        }
        
        System.out.println("Success return book");
    }
    
    public static void deleteUser(int userId){
        String statement = "{call delete_user(?)}";
        
        try(Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                CallableStatement query = con.prepareCall(statement);
                ){
            query.setInt(1,userId);
            query.execute();
        }catch(SQLException ex){
            System.out.println("Error deleting user");
            return;
        }
        
        System.out.println("Success deleting user");
    }
    
    public static void editUser(String[] details){
        String statement = "{call edit_user(?,?,?,?,?,?)}";
        
        try(Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                CallableStatement query = con.prepareCall(statement);
                ){
            query.setInt(1,Integer.parseInt(details[0]));
            query.setString(2,details[1]);
            query.setString(3,details[2]);
            query.setString(4,details[3]);
            query.setString(5,details[4]);  
            query.setString(6,details[5]);
            query.execute();
        }catch(SQLException ex){
            System.out.println("Error editing user");
            return;
        }
        
        System.out.println("Success editing user");
    }
    
    public static void acceptLoan(int transactionNo){
        String statement = "{call accept_loan(?)}";
        
        try(Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                CallableStatement query = con.prepareCall(statement);
                ){
            query.setInt(1,transactionNo);
            query.execute();
        }catch(SQLException ex){
            System.out.println("Error accepting laon");
            return;
        }
        
        System.out.println("Success accept laon");
    }
    
    public static void addBook(SearchBook book){
        String statement = "{call add_book(?,?,?,?)}";
        
        try(Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                CallableStatement query = con.prepareCall(statement);
                ){
            query.setString(1,book.getIsbn());
            query.setString(2, book.getTitle());
            query.setInt(3, book.getYear());
            query.setInt(4, book.getShelfId());
            query.execute();
        }catch(SQLException ex){
            System.out.println("Error adding book");
            return;
        }
        
        System.out.println("Success adding book");
    }
    
    public static void deleteBook(String isbn){
        String statement = "{call delete_book(?)}";
        
        try(Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                CallableStatement query = con.prepareCall(statement);
                ){
            query.setString(1,isbn);
            query.execute();
        }catch(SQLException ex){
            System.out.println("Error Deleting book");
            return;
        }
        
        System.out.println("Success deleting book");
    }
    
    public static void addBookAuthor(String authorName, String isbn){
        String statement = "{call add_book_author(?,?)}";
        
        try(Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                CallableStatement query = con.prepareCall(statement);
                ){
            query.setString(1,authorName);
            query.setString(2, isbn);
            query.execute();
        }catch(SQLException ex){
            System.out.println("Error addBookAuthor");
            return;
        }
        
        System.out.println("Success addBookAuthor");
    }
    
    public static void deleteBookAuthor(int authorId, String isbn){
        String statement = "{call delete_book_author(?,?)}";
        
        try(Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                CallableStatement query = con.prepareCall(statement);
                ){
            query.setInt(1,authorId);
            query.setString(2, isbn);
            query.execute();
        }catch(SQLException ex){
            System.out.println("Error deleteBookAuthor");
            return;
        }
        
        System.out.println("Success dleteBookAuthor");
    }
    
    public static void editBook(String isbn, String[] details){
        String statement = "{call edit_book(?, ?,?,?,?)}";
        
        try(Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                CallableStatement query = con.prepareCall(statement);
                ){
            query.setString(1, isbn);
            query.setString(2,details[0]);
            query.setString(3,details[1]);
            query.setInt(4,Integer.parseInt(details[2]));
            query.setInt(5,Integer.parseInt(details[3]));
            query.execute();
        }catch(SQLException ex){
            System.out.println("Error editing book");
            return;
        }
        
        System.out.println("Success editing book");
    }

    public static void deleteCopy(String isbn, int copyNo) {
        String statement = "call delete_copy(?,?)";
        
        try(Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                CallableStatement query = con.prepareCall(statement);
                ){
            query.setString(1, isbn);
            query.setInt(2,copyNo);
            query.execute();
        }catch(SQLException ex){
            System.out.println("Error deleting copy");
            return;
        }
        
        System.out.println("Success editing copy");
    }
    
    public static void editAuthor(int authorId, String name){
        String statement = "call edit_author(?,?)";
        
        try(Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                CallableStatement query = con.prepareCall(statement);
                ){
            query.setInt(2, authorId);
            query.setString(1,name);
            query.execute();
        }catch(SQLException ex){
            System.out.println(ex.getLocalizedMessage());
            System.out.println("Error editingAuthor ");
            return;
        }
        
        System.out.println("Success editingAuthor");
    }
    
    public static int getShelfContains(int shelfId){
        String statement = "{?=call get_shelf_contains(?)}";
        
        try(Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                CallableStatement query = con.prepareCall(statement);
                ){
            query.registerOutParameter(1, Types.NUMERIC);
            query.setInt(2,shelfId);
            query.execute();
            return query.getInt(1);
        }catch(SQLException ex){
            System.out.println(ex.getLocalizedMessage());
            System.out.println("Error getShelfContains ");
            return 0;
        }
    }
    
    public static void addShelf(int capacity){
        String statement = "call add_shelf(?)";
        
        try(Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                CallableStatement query = con.prepareCall(statement);
                ){
            query.setInt(1,capacity);
            query.execute();
        }catch(SQLException ex){
            System.out.println(ex.getLocalizedMessage());
            System.out.println("Error addShelf ");
            return;
        }
        
        System.out.println("Success addShelf");
    }
    
    public static void deleteShelf(int shelfId){
        String statement = "call delete_shelf(?)";
        
        try(Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                CallableStatement query = con.prepareCall(statement);
                ){
            query.setInt(1,shelfId);
            query.execute();
        }catch(SQLException ex){
            System.out.println(ex.getLocalizedMessage());
            System.out.println("Error deleteShelf ");
            return;
        }
        System.out.println("Success deleteShelf");
    }
    
    public static void editShelf(int shelfId, int newCapacity){
        String statement = "call edit_shelf(?,?)";
        
        try(Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                CallableStatement query = con.prepareCall(statement);
                ){
            query.setInt(1,shelfId);
            query.setInt(2, newCapacity);
            query.execute();
        }catch(SQLException ex){
            System.out.println(ex.getLocalizedMessage());
            System.out.println("Error editShelf ");
            return;
        }
        System.out.println("Success editShelf");
    }
    
    public static boolean isbnExists(String isbn){
        String statement = "{?=call isbn_exists(?)}";
        
        try(Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                CallableStatement query = con.prepareCall(statement);
                ){
            query.registerOutParameter(1, Types.NUMERIC);
            query.setString(2,isbn);
            query.execute();
            
            if(query.getInt(1) == 1){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getLocalizedMessage());
            System.out.println("Error isbnExists ");
            return false;
        }
        
        return false;
    }
    
    public static int computeFine(int userId, Date borrowed){
        String statement = "{?=call compute_fine(?)}";
        int fine;
        try(Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                CallableStatement query = con.prepareCall(statement);
                ){
            query.registerOutParameter(1, Types.NUMERIC);
            query.setDate(2,borrowed);
            query.execute();
            fine = query.getInt(1);
            System.out.println("fine at query: "+fine);
        }catch(SQLException ex){
            System.out.println(ex.getLocalizedMessage());
            System.out.println("Error computeFine ");
            return 0;
        }
        System.out.println("success computeFine");
        
        statement = "{call add_fine(?,?)}";
        try(Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                CallableStatement query = con.prepareCall(statement);
                ){
            query.setInt(1, userId);
            query.setInt(2, fine); 
            System.out.println("User id: "+userId);
            System.out.println("fine: "+ fine);
            
            query.execute();
        
        }catch(SQLException ex){
            System.out.println(ex.getLocalizedMessage());
            System.out.println("Error insert fine ");
            return 0;
        }
        System.out.println("success insert fine");
        
        if(fine < 0){
            return 0;
        }
        
        return fine;
    }
    
    public static void payFine(int userId){
        String statement = "SELECT unpaid_fines FROM library_users WHERE user_id = ?";
        int fine = 0;
        try(Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                PreparedStatement query = con.prepareStatement(statement);
                ){
            query.setInt(1, userId);
            
            ResultSet res = query.executeQuery();
            
            while(res.next()){
                fine = res.getInt("unpaid_fines");
            }
            
            System.out.println("fine:"+fine);
             
        }catch(SQLException ex){
            System.out.println(ex.getLocalizedMessage());
            System.out.println("Error query fine ");
            return;
        }
        System.out.println("success query fine");
        statement = "{call add_fine(?,?)}";
        
        try(Connection con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
                CallableStatement query = con.prepareCall(statement);
                ){
            query.setInt(1, userId);
            query.setInt(2, -fine);
           
            query.execute();
        }catch(SQLException ex){
            System.out.println(ex.getLocalizedMessage());
            System.out.println("Error pay fine ");
            return;
        }
        
        System.out.println("success pay fine");
    }
    
}
    
