
CREATE TABLE authors (
    author_id    NUMBER(6) NOT NULL,
    author_name  VARCHAR2(64) NOT NULL,
    
    CONSTRAINT author_pk PRIMARY KEY(author_id)
);


CREATE TABLE books (
    book_id         NUMBER(6) NOT NULL,
    isbn            VARCHAR2(15) NOT NULL,
    copy_no         NUMBER NOT NULL,
    title           VARCHAR2(64) NOT NULL,
    year_published  DATE NOT NULL,
    status          VARCHAR2(128),
    shelf_id  NUMBER(6) NOT NULL,
    
    CONSTRAINT book_pk PRIMARY KEY(book_id),
    CONSTRAINT book_shelf_fk FOREIGN KEY(shelf_id)
        REFERENCES shelves(shelf_id)
);

CREATE TABLE book_author (
    author_id  NUMBER(6) NOT NULL,
    book_isbn         VARCHAR2(15) NOT NULL,
    
    CONSTRAINT author_fk FOREIGN KEY(author_id)
        REFERENCES authors(author_id),
    CONSTRAINT book_fk FOREIGN KEY(book_isbn)
        REFERENCES books(book_isbn)
);

CREATE TABLE book_transactions (
    transaction_no   NUMBER(6) NOT NULL,
    user_id  NUMBER(6) NOT NULL,
    book_id NUMBER(6) NOT NULL,
    transaction_date        DATE
    
    CONSTRAINT book_transaction_pk PRIMARY KEY (transaction_no),
    CONSTRAINT book_transaction_user_fk (user_id)
        REFERENCES library_users_fk(user_id),
    CONSTRAINT book_transaction_book_fk(book_id)
        REFERENCES books(book_id)
);

CREATE TABLE library_users (
    user_id    NUMBER(6) NOT NULL,
    login_id VARCHAR2(32) NOT NULL,
    first_name  VARCHAR2(64) NOT NULL,
    last_name   VARCHAR2(64) NOT NULL,
    login_password    VARCHAR2(128) NOT NULL,
    address     VARCHAR2(128) NOT NULL,
    librarian CHAR(1),
    unpaid_fines  NUMBER
    
    CONSTRAINT user_pk PRIMARY KEY(user_id),
    CONSTRAINT user_check CHECK (librarian IN ('Y','N'))
);

CREATE TABLE shelves (
    shelf_id  NUMBER(6) NOT NULL,
    capacity  NUMBER NOT NULL
    
    CONSTRAINT shelf_pk PRIMARY KEY(shelf_id)
);
