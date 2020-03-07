    CREATE OR REPLACE PROCEDURE add_user (
    p_loginid     library_users.login_id%TYPE,
    p_fname       library_users.first_name%TYPE,
    p_lname       library_users.last_name%TYPE,
    p_loginpass   library_users.login_password%TYPE,
    p_address     library_users.address%TYPE,
    p_lib         library_users.librarian%TYPE
) AS
BEGIN   
    INSERT INTO library_users (
        user_id,
        login_id,
        first_name,
        last_name,
        login_password,
        address,
        librarian,
        unpaid_fines
    ) VALUES (
        user_seq.NEXTVAL,
        p_loginid,
        p_fname,
        p_lname,
        p_loginpass,
        p_address,
        p_lib,
        0
    );

END add_user;

/

CREATE OR REPLACE FUNCTION authenticate_user(
    p_loginid IN library_users.login_id%type,
    p_pass IN library_users.login_password%type,
    p_uid OUT library_users.user_id%type
)
RETURN NUMBER
IS
    v_librarian library_users.librarian%type;
BEGIN
    SELECT library_users.user_id, library_users.librarian INTO p_uid, v_librarian
    FROM library_users
    WHERE library_users.login_id = p_loginid AND p_pass = library_users.login_password;
    
    IF v_librarian = 'N' THEN
        RETURN 0;
    ELSE
        RETURN 1;
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN -1;
END authenticate_user;

/

CREATE OR REPLACE FUNCTION next_copy_no(
    p_isbn books.isbn%type
) RETURN NUMBER
IS
prev_copy_no NUMBER := 1;
CURSOR c_book
    IS SELECT copy_no FROM books
    WHERE isbn = p_isbn;
BEGIN
    FOR r_book in c_book
    LOOP
        prev_copy_no := r_book.copy_no;
    END LOOP;
    
    RETURN prev_copy_no + 1;
END next_copy_no;    

/

CREATE OR REPLACE PROCEDURE add_book (
    p_isbn      books.isbn%TYPE,
    p_title     books.title%TYPE,
    p_year      books.year_published%TYPE,
    p_shelfid   books.shelf_id%TYPE
) IS
BEGIN
    INSERT INTO books (
        book_id,
        isbn,
        copy_no,
        title,
        year_published,
        status,
        shelf_id
    ) VALUES (
        book_seq.NEXTVAL,
        p_isbn,
        next_copy_no(p_isbn),
        p_title,
        p_year,
        'On Shelf',
        p_shelfid
    );

END add_book;

/
CREATE OR REPLACE PROCEDURE add_author (
    p_name authors.author_name%TYPE
) AS
BEGIN
    INSERT INTO authors (
        author_id,
        author_name
    ) VALUES (
        author_seq.NEXTVAL,
        p_name
    );

END add_author;

/

CREATE OR REPLACE PROCEDURE add_book_author(
    p_authorid authors.author_id%type,
    p_bookisbn books.isbn%type)
IS
BEGIN 
    INSERT INTO book_author(author_id, book_isbn) VALUES(p_authorid, p_bookisbn);
END add_book_author;

/

CREATE OR REPLACE PROCEDURE borrow_book (
    p_userid     library_users.user_id%TYPE,
    p_isbn     books.isbn%TYPE
) IS
    v_bookid books.book_id%TYPE;
    CURSOR c_book IS
    SELECT
        book_id
    FROM
        books
    WHERE
        isbn = p_isbn
        AND status = 'On Shelf';

BEGIN
    OPEN c_book;
    FETCH c_book INTO v_bookid;
    INSERT INTO book_transactions (
        transaction_no,
        user_id,
        book_id,
        transaction_date
    ) VALUES (
        book_transaction_seq.NEXTVAL,
        p_userid,
        v_bookid,
        SYSDATE
    );
    
    UPDATE books 
    SET status = 'On Hold'
    WHERE book_id = v_bookid;

END borrow_book;
    
/

CREATE OR REPLACE PROCEDURE return_book (
    p_userid     library_users.user_id%TYPE,
    p_isbn  books.isbn%TYPE,
    p_copyno books.copy_no%type
) IS
    v_bookid books.book_id%type;
BEGIN
    SELECT book_id INTO v_bookid
    FROM books
    WHERE isbn = p_isbn AND copy_no = p_copyno;
    
    DELETE FROM book_transactions
    WHERE book_id = v_bookid;
    
    UPDATE books 
    SET status = 'On Shelf'
    WHERE book_id = v_bookid;

END return_book;

/

CREATE OR REPLACE PROCEDURE delete_user (
    p_userid library_users.user_id%TYPE
) AS
BEGIN
    DELETE FROM library_users
    WHERE
        user_id = p_userid;

END delete_user;

/

CREATE OR REPLACE PROCEDURE edit_user (
    p_userid     library_users.user_id%TYPE,
    p_fname      library_users.first_name%TYPE,
    p_lname      library_users.last_name%TYPE,
    p_address    library_users.address%TYPE,
    p_loginid    library_users.login_id%TYPE,
    p_librarian library_users.librarian%TYPE
) IS 
BEGIN 
    UPDATE library_users
    SET
        first_name = p_fname,
        last_name = p_lname,
        address = p_address,
        login_id = p_loginid,
        librarian = p_librarian
    WHERE
        user_id = p_userid; 
END edit_user;

/

CREATE OR REPLACE PROCEDURE accept_loan(
    p_transno book_transactions.transaction_no%type)
IS
    v_bookid books.book_id%type;
BEGIN
    SELECT book_id INTO v_bookid FROM book_transactions
    WHERE transaction_no = p_transno;
    
    UPDATE books 
    SET status = 'On Loan'
    WHERE book_id = v_bookid;
END;