-- [M205] EX 07 - DML Update e Delete
-- Crie comando de “update” e “delete” de dados para cada tabela citada anteriormente e,
-- adicione a um arquivo separado do projeto.
-- UPDATE:
UPDATE NUTRICIONISTA
SET
	NOME = 'Genovaldo',
	CRN = '321321'
WHERE
	ID = 2;

UPDATE PACIENTE
SET
	CPF = '11122233344',
	EMAIL = 'aaa@mail.com'
WHERE
	ID = 3;

UPDATE CONSULTA
SET
	OBSERVACOES = 'lalalalala'
WHERE
	ID = 1;

-- DELETE:
DELETE FROM CONSULTA
WHERE
	CONSULTA.ID_NUTRICIONISTA = 3
	AND CONSULTA.ID_PACIENTE = 2;

DELETE FROM PACIENTE
WHERE
	ID = 2;

DELETE FROM NUTRICIONISTA
WHERE
	ID > 2;