--------------------------------------------------------
--  DDL for Type TCOACH
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."TCOACH" AS OBJECT (
NumC number,
NomC varchar(30),
PrenomC TListePrenom,
DateN date
);
