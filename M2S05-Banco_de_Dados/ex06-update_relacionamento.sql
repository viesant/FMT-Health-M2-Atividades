-- [M205] Ex 6 - DML update de relacionamentos
-- Crie comandos “update” para o relacionar os dados já existentes das tabelas.


UPDATE CONSULTA
SET ID_NUTRICIONISTA = 4,
    ID_PACIENTE = 3
WHERE ID < 5;


SELECT
	*
FROM
	CONSULTA;