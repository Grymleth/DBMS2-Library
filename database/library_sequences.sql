CREATE SEQUENCE author_seq
    START WITH 0
    MINVALUE 0
    INCREMENT BY 1;
    
CREATE SEQUENCE USER_SEQ 
    START WITH 0
    INCREMENT BY 1 
    MINVALUE 0;

CREATE SEQUENCE book_transaction_seq
    START WITH 0
    INCREMENT BY 1 
    MINVALUE 0;
    
CREATE SEQUENCE book_seq
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0;
    
    
DROP SEQUENCE author_seq;
DROP SEQUENCE user_seq;
drop sequence book_transaction_seq;
drop sequence book_seq;