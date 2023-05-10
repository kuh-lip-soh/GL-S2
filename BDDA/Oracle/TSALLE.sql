--------------------------------------------------------
--  DDL for Type TSALLE
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."TSALLE" AS Object(
NumS number,
Titre varchar(255),
DirS ref TCoach,
Coachs EnsCoachs,
Seances EnsSeances
);
