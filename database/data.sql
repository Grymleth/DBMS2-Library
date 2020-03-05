Insert into LIBRARY_USERS (USER_ID,LOGIN_ID,FIRST_NAME,LAST_NAME,LOGIN_PASSWORD,ADDRESS,LIBRARIAN,UNPAID_FINES) values (user_seq.nextval,'bob','Robert','California','890','Las Vegas, Nevada','Y',0);
Insert into LIBRARY_USERS (USER_ID,LOGIN_ID,FIRST_NAME,LAST_NAME,LOGIN_PASSWORD,ADDRESS,LIBRARIAN,UNPAID_FINES) values (user_seq.nextval,'orhtej','Ed Jethro','Pacaño','edjethro','Bulacan','N',0);
Insert into LIBRARY_USERS (USER_ID,LOGIN_ID,FIRST_NAME,LAST_NAME,LOGIN_PASSWORD,ADDRESS,LIBRARIAN,UNPAID_FINES) values (user_seq.nextval,'aevan','Aevan','Candelaria','samgyup','Sampaloc, Manila','Y',0);
Insert into LIBRARY_USERS (USER_ID,LOGIN_ID,FIRST_NAME,LAST_NAME,LOGIN_PASSWORD,ADDRESS,LIBRARIAN,UNPAID_FINES) values (user_seq.nextval,'andrei','Andrei','Ofrecio','123','Tarlac, Tarlac','N',0);

Insert into LIBRARY_USERS (USER_ID,LOGIN_ID,FIRST_NAME,LAST_NAME,LOGIN_PASSWORD,ADDRESS,LIBRARIAN,UNPAID_FINES) values (user_seq.nextval,'dtam','Daniel','Tam','boris','Bicol','N',0);
Insert into LIBRARY_USERS (USER_ID,LOGIN_ID,FIRST_NAME,LAST_NAME,LOGIN_PASSWORD,ADDRESS,LIBRARIAN,UNPAID_FINES) values (user_seq.nextval,'johndenver','John','Denver','rockymountainhigh','West Virginia','N',0);
Insert into LIBRARY_USERS (USER_ID,LOGIN_ID,FIRST_NAME,LAST_NAME,LOGIN_PASSWORD,ADDRESS,LIBRARIAN,UNPAID_FINES) values (user_seq.nextval,'trexone','Rex','Ronquillo','123','Puso mo','N',0);
Insert into LIBRARY_USERS (USER_ID,LOGIN_ID,FIRST_NAME,LAST_NAME,LOGIN_PASSWORD,ADDRESS,LIBRARIAN,UNPAID_FINES) values (user_seq.nextval,'rovic','Rovic','Tabucol','hello','Manila','N',0);
Insert into LIBRARY_USERS (USER_ID,LOGIN_ID,FIRST_NAME,LAST_NAME,LOGIN_PASSWORD,ADDRESS,LIBRARIAN,UNPAID_FINES) values (user_seq.nextval,'rovic','Rovic','Tabucol','hello','Manila','N',0);

Insert into AUTHORS (AUTHOR_ID,AUTHOR_NAME) values (author_seq.nextval,'Aevan Candelaria');
Insert into AUTHORS (AUTHOR_ID,AUTHOR_NAME) values (author_seq.nextval,'Herman Cowell');
Insert into AUTHORS (AUTHOR_ID,AUTHOR_NAME) values (author_seq.nextval,'Steven Stranger');
Insert into AUTHORS (AUTHOR_ID,AUTHOR_NAME) values (author_seq.nextval,'Fernad Corbin');

Insert into SHELVES (SHELF_ID,CAPACITY) values (1,100);
Insert into SHELVES (SHELF_ID,CAPACITY) values (2,100);
Insert into SHELVES (SHELF_ID,CAPACITY) values (3,100);
Insert into SHELVES (SHELF_ID,CAPACITY) values (4,100);
Insert into SHELVES (SHELF_ID,CAPACITY) values (5,100);

Insert into BOOKS (ISBN,COPY_NO,TITLE,YEAR_PUBLISHED,STATUS,SHELF_ID,BOOK_ID) values ('0000001',1,'Alawanatics 101','2020','On Loan',1,book_seq.nextval);
Insert into BOOKS (ISBN,COPY_NO,TITLE,YEAR_PUBLISHED,STATUS,SHELF_ID,BOOK_ID) values ('0000002',1,'Dormammu Bargains','2017','On Shelf',1,book_seq.nextval);
Insert into BOOKS (ISBN,COPY_NO,TITLE,YEAR_PUBLISHED,STATUS,SHELF_ID,BOOK_ID) values ('0000002',2,'Dormammu Bargains','2017','On Shelf',1,book_seq.nextval);
Insert into BOOKS (ISBN,COPY_NO,TITLE,YEAR_PUBLISHED,STATUS,SHELF_ID,BOOK_ID) values ('1234567',1,'To Kill A Bird','1999','On Loan',1,book_seq.nextval);

Insert into BOOK_AUTHOR (AUTHOR_ID,BOOK_ISBN) values (4,'1234567');
Insert into BOOK_AUTHOR (AUTHOR_ID,BOOK_ISBN) values (1,'1234567');
Insert into BOOK_AUTHOR (AUTHOR_ID,BOOK_ISBN) values (2,'0000001');
Insert into BOOK_AUTHOR (AUTHOR_ID,BOOK_ISBN) values (3,'0000002');

Insert into BOOK_TRANSACTIONS (TRANSACTION_NO,USER_ID,TRANSACTION_DATE,BOOK_ID) values (book_transaction_seq.NEXTVAL,1,to_date('03/04/2020','MM/DD/RRRR'),1);
Insert into BOOK_TRANSACTIONS (TRANSACTION_NO,USER_ID,TRANSACTION_DATE,BOOK_ID) values (book_transaction_seq.NEXTVAL,2,to_date('03/04/2020','MM/DD/RRRR'),4);

