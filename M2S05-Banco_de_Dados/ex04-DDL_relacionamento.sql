-- [M205] Ex 4 - DDL (relacionamento)
-- Crie DDL para o relacionamento entre as tabelas:
-- Uma paciente contará com várias consultas(1:n);
-- Uma nutricionista contará com várias consultas(1:n).
ALTER TABLE CONSULTA
ADD CONSTRAINT CONSULTA_ID_PACIENTE_FKEY FOREIGN KEY (ID_PACIENTE) REFERENCES PACIENTE (ID),
ADD CONSTRAINT CONSULTA_ID_NUTRICIONISTA_FKEY FOREIGN KEY (ID_NUTRICIONISTA) REFERENCES NUTRICIONISTA (ID);