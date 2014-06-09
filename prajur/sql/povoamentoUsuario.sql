INSERT INTO Perfil (codigo, nome, naturalidade, cpf, rg, orgaoEmissor, profissao) VALUES (1, 'Administrador', 'Brasileiro', '000.000.000-00', '000.000.000.000', 'SSP-PB', 'Administrador');
INSERT INTO usuario (codigo, user_ativo, user_login, user_senha, perfil) VALUES (nextval('usuario_sec'), true, 'admin', 'admin', 1);
INSERT INTO usuario_permissao (usuario, permissao) VALUES (1, 'ROLE_ADMINISTRADOR');
INSERT INTO usuario_permissao (usuario, permissao) VALUES (1, 'ROLE_USUARIO');

select nextval('usuario_sec');

SELECT * from usuario_sec;

