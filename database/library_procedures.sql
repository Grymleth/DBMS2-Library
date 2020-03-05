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
        librarian
    ) VALUES (
        user_seq.NEXTVAL,
        p_loginid,
        p_fname,
        p_lname,
        p_loginpass,
        p_address,
        p_lib
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
    p_bookid   books.book_id%TYPE
) IS

    v_copyno books.isbn%TYPE;
    CURSOR c_book IS
    SELECT
        copy_no
    FROM
        books
    WHERE
        book_id = p_bookid
        AND status = 'On Shelf';

BEGIN
    OPEN c_book;
    FETCH c_book INTO v_copyno;
    INSERT INTO book_transactions (
        transaction_no,
        user_id,
        book_id,
        transaction_date
    ) VALUES (
        book_transaction_seq.NEXTVAL,
        p_userid,
        p_bookid,
        sysdate
    );
    
    UPDATE books 
    SET status = 'On Loan'
    WHERE book_id = p_bookid AND copy_no = v_copyno;

END borrow_book;
    
/

CREATE OR REPLACE PROCEDURE return_book (
    p_userid     library_users.user_id%TYPE,
    p_bookid   books.book_id%TYPE
) IS

    v_copyno books.isbn%TYPE;
    CURSOR c_book IS
    SELECT
        copy_no
    FROM
        books
    WHERE
        book_id = p_bookid
        AND status = 'On Shelf';

BEGIN
    OPEN c_book;
    FETCH c_book INTO v_copyno;
    INSERT INTO book_transactions (
        transaction_no,
        user_id,
        book_id,
        transaction_date
    ) VALUES (
        book_transaction_seq.NEXTVAL,
        p_userid,
        p_bookid,
        sysdate
    );
    
    UPDATE books 
    SET status = 'On Loan'
    WHERE book_id = p_bookid AND copy_no = v_copyno;

END return_book;