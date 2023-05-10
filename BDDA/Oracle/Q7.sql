--------------------------------------------------------
--  DDL for Trigger Q7
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "SYSTEM"."Q7" 
BEFORE UPDATE ON SALLE
FOR EACH ROW
DECLARE n NUMBER;
BEGIN
SELECT numc into n from seances,salle
where seances.numc=salle.dirs and seances.nums=salle.nums;
if n!=null
then
RAISE_APPLICATION_ERROR(-20200,'Ce coach dirige cette salle');
end if;
END;
ALTER TRIGGER "SYSTEM"."Q7" ENABLE
