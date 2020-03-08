CREATE SEQUENCE author_seq
    START WITH 1
    MINVALUE 0
    INCREMENT BY 1;
    
CREATE SEQUENCE USER_SEQ 
    START WITH 1
    INCREMENT BY 1 
    MINVALUE 0;

CREATE SEQUENCE book_transaction_seq
    START WITH 1
    INCREMENT BY 1 
    MINVALUE 0;
    
CREATE SEQUENCE book_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0;
    
CREATE SEQUENCE shelf_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0;
    
DROP sequence author_seq;

DROP sequence user_Seq;

DROP sequence book_Transaction_Seq;

drop sequence book_Seq;

drop sequence shelf_seq;