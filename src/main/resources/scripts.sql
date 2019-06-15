create table doc (
    id_doc integer primary key,
    descricao varchar(100)
);

--GERACAO DE MASSA DE DADOS
DO $$
BEGIN
    for i in 1..1000 loop
        insert into doc values(i, 'descricao ' || i);
    end loop;
    COMMIT;
END; $$
