--------------------------------------------------------
--  DDL for Table COACH
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."COACH" 
   (	"NUMC" NUMBER, 
	"NOMC" VARCHAR2(20), 
	"PRENOMC" VARCHAR2(20), 
	"REVENUTOT" NUMBER, 
	"ETAT" VARCHAR2(20)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SYSTEM"
