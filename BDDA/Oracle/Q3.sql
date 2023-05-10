--------------------------------------------------------
--  DDL for Trigger Q3
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "SYSTEM"."Q3" 
AFTER INSERT OR UPDATE ON SEANCES 
FOR EACH ROW 
BEGIN
IF INSERTING THEN UPDATE SEANCES 
SET DURÉE_PRÉVUE=EXTRACT(HOUR from HEURE_FIN-heure_debut)+EXTRACT(MINUTE from HEURE_FIN-heure_debut)+EXTRACT(SECOND from HEURE_FIN-heure_debut),"DURÉE_RÉELLE"="DURÉE_PRÉVUE";
end if;
IF UPDATING THEN UPDATE SEANCES
SET DURÉE_PRÉVUE=EXTRACT(HOUR from :new.HEURE_FIN-heure_debut)+EXTRACT(MINUTE from :new.HEURE_FIN-heure_debut)+EXTRACT(SECOND from :new.HEURE_FIN-heure_debut)
where :new.HEURE_FIN!=:old.heure_fin;
end if;
END;
ALTER TRIGGER "SYSTEM"."Q3" ENABLE
