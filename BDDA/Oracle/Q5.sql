--------------------------------------------------------
--  DDL for Trigger Q5
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "SYSTEM"."Q5" 
AFTER INSERT or UPDATE on SEANCES
DECLARE n NUMBER;
BEGIN
SELECT count(distinct seances.numc) INTO n from SEANCES,SALLE
where seances.nums=salle.nums;
UPDATE SALLE
SET nbcoachs=n
where salle.nums=seances.nums;
END;
ALTER TRIGGER "SYSTEM"."Q5" ENABLE
