update LesSalles s
set s.seances = EnsSeances(TSeance(null,null,null,null))
where s.nums=1;

insert into table(select seances from lessalles s where s.nums=1) values(TSeance(1, (select ref(c) from LesCoachs c where numc=1), null,null));