--------------------------------------------------------
--  File created - Thursday-March-05-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table BOOK_TRANSACTIONS
--------------------------------------------------------

  CREATE TABLE "DBMS2"."BOOK_TRANSACTIONS" 
   (	"TRANSACTION_NO" NUMBER(6,0), 
	"USER_ID" NUMBER(6,0), 
	"TRANSACTION_DATE" DATE, 
	"BOOK_ID" NUMBER(6,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into DBMS2.BOOK_TRANSACTIONS
SET DEFINE OFF;
Insert into DBMS2.BOOK_TRANSACTIONS (TRANSACTION_NO,USER_ID,TRANSACTION_DATE,BOOK_ID) values (3,1,to_date('03/04/2020','MM/DD/RRRR'),1);
Insert into DBMS2.BOOK_TRANSACTIONS (TRANSACTION_NO,USER_ID,TRANSACTION_DATE,BOOK_ID) values (4,2,to_date('03/04/2020','MM/DD/RRRR'),4);
--------------------------------------------------------
--  DDL for Index BOOK_TRANSACTION_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "DBMS2"."BOOK_TRANSACTION_PK" ON "DBMS2"."BOOK_TRANSACTIONS" ("TRANSACTION_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table BOOK_TRANSACTIONS
--------------------------------------------------------

  ALTER TABLE "DBMS2"."BOOK_TRANSACTIONS" ADD CONSTRAINT "BOOK_TRANSACTION_PK" PRIMARY KEY ("TRANSACTION_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "DBMS2"."BOOK_TRANSACTIONS" MODIFY ("TRANSACTION_NO" NOT NULL ENABLE);
 
  ALTER TABLE "DBMS2"."BOOK_TRANSACTIONS" MODIFY ("USER_ID" NOT NULL ENABLE);
 
  ALTER TABLE "DBMS2"."BOOK_TRANSACTIONS" MODIFY ("BOOK_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table BOOK_TRANSACTIONS
--------------------------------------------------------

  ALTER TABLE "DBMS2"."BOOK_TRANSACTIONS" ADD CONSTRAINT "BOOK_TRANSACTIONS_BOOK_FK" FOREIGN KEY ("BOOK_ID")
	  REFERENCES "DBMS2"."BOOKS" ("BOOK_ID") ENABLE;
 
  ALTER TABLE "DBMS2"."BOOK_TRANSACTIONS" ADD CONSTRAINT "BOOK_TRANSACTION_PATRON_FK" FOREIGN KEY ("USER_ID")
	  REFERENCES "DBMS2"."LIBRARY_USERS" ("USER_ID") ENABLE;
