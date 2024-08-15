INSERT INTO perfil (id, nome) VALUES (1, 'ADMIN')
ON CONFLICT (id) DO NOTHING;

INSERT INTO perfil (id, nome) VALUES (2, 'NUTRICIONISTA')
ON CONFLICT (id) DO NOTHING;

INSERT INTO perfil (id, nome) VALUES (3, 'PACIENTE')
ON CONFLICT (id) DO NOTHING;

select * from perfil;