--------------------------------------------------------
--  File created - Thursday-March-05-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table BOOK_AUTHOR
--------------------------------------------------------

  CREATE TABLE "DBMS2"."BOOK_AUTHOR" 
   (	"AUTHOR_ID" NUMBER(6,0), 
	"BOOK_ISBN" VARCHAR2(15 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into DBMS2.BOOK_AUTHOR
SET DEFINE OFF;
Insert into DBMS2.BOOK_AUTHOR (AUTHOR_ID,BOOK_ISBN) values (4,'1234567');
Insert into DBMS2.BOOK_AUTHOR (AUTHOR_ID,BOOK_ISBN) values (1,'1234567');
Insert into DBMS2.BOOK_AUTHOR (AUTHOR_ID,BOOK_ISBN) values (2,'0000001');
Insert into DBMS2.BOOK_AUTHOR (AUTHOR_ID,BOOK_ISBN) values (3,'0000002');
--------------------------------------------------------
--  Constraints for Table BOOK_AUTHOR
--------------------------------------------------------

  ALTER TABLE "DBMS2"."BOOK_AUTHOR" MODIFY ("AUTHOR_ID" NOT NULL ENABLE);
 
  ALTER TABLE "DBMS2"."BOOK_AUTHOR" MODIFY ("BOOK_ISBN" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table BOOK_AUTHOR
--------------------------------------------------------

  ALTER TABLE "DBMS2"."BOOK_AUTHOR" ADD CONSTRAINT "BOOK_AUTHOR_AUTHOR_FK" FOREIGN KEY ("AUTHOR_ID")
	  REFERENCES "DBMS2"."AUTHORS" ("AUTHOR_ID") ENABLE;
