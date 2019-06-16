create table doc (
    id_doc integer primary key,
    description varchar(100)
);

--GERACAO DE MASSA DE DADOS
DO $$
BEGIN
    for i in 1..1000 loop
        insert into doc values(i, 'description ' || i);
    end loop;
    COMMIT;
END; $$
