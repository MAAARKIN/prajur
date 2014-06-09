INSERT INTO Perfil (codigo, nome, nacionalidade, cpf, rg, orgaoEmissor, profissao) VALUES (1, 'Administrador', 'Brasileiro', '000.000.000-00', '000.000.000.000', 'SSP-PB', 'Administrador');
INSERT INTO usuario (codigo, user_ativo, user_login, user_senha, contato, endereco, perfil) VALUES (1, true, 'admin', 'admin', null, null, 1);
INSERT INTO usuario_permissao (usuario, permissao) VALUES (1, 'ROLE_ADMINISTRADOR');
INSERT INTO usuario_permissao (usuario, permissao) VALUES (1, 'ROLE_USUARIO');
