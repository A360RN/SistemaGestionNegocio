SELECT * FROM sunshine_andina_db.tsa_perfil;

/* TSA_PERFIL */

INSERT INTO sunshine_andina_db.TSA_PERFIL(CODIGO_PERFIL, DESC_PERFIL) VALUES ("CLI", "CLIENTE");
INSERT INTO sunshine_andina_db.TSA_PERFIL(CODIGO_PERFIL, DESC_PERFIL) VALUES ("DIS", "DISTRIBUIDOR");
INSERT INTO sunshine_andina_db.TSA_PERFIL(CODIGO_PERFIL, DESC_PERFIL) VALUES ("VEN", "ENCARGADO DE VENTAS");
INSERT INTO sunshine_andina_db.TSA_PERFIL(CODIGO_PERFIL, DESC_PERFIL) VALUES ("INV", "ENCARGADO DE INVENTARIOS");
INSERT INTO sunshine_andina_db.TSA_PERFIL(CODIGO_PERFIL, DESC_PERFIL) VALUES ("ADM", "ENCARGADO DE ADMINISTRACION");

/* TSA_USUARIO */

INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario, pass_usuario, fecha_registro, estado_usuario) values ("usuario_cli", null, null, 1);
INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario, pass_usuario, fecha_registro, estado_usuario) values ("usuario_dis", null, null, 1);
INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario, pass_usuario, fecha_registro, estado_usuario) values ("usuario_ven", null, null, 1);
INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario, pass_usuario, fecha_registro, estado_usuario) values ("usuario_inv", null, null, 1);
INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario, pass_usuario, fecha_registro, estado_usuario) values ("usuario_adm", null, null, 1);

/* TSA_USUARIO_PEFIL*/

INSERT INTO sunshine_andina_db.tsa_usuario_perfil values (1,1);
INSERT INTO sunshine_andina_db.tsa_usuario_perfil values (2,2);
INSERT INTO sunshine_andina_db.tsa_usuario_perfil values (3,3);
INSERT INTO sunshine_andina_db.tsa_usuario_perfil values (4,4);
INSERT INTO sunshine_andina_db.tsa_usuario_perfil values (5,5);

/* TSA_CLIENTE */
INSERT INTO sunshine_andina_db.tsa_cliente(id_usuario, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, tel_celular, tel_fijo, direccion, email, dni)
values (1, "JEFFERSON", "AGUSTIN", "FARFAN", "GUADALUPE", "999988882", "4421211", "AV. SEPARADORA INDUSTRIAL 1258 ATE", "JEFFERSON.FARFAN@GMAIL.COM", 78794547);

INSERT INTO sunshine_andina_db.tsa_cliente(id_usuario, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, tel_celular, tel_fijo, direccion, email, dni)
values (2, "JOSE", "PAOLO", "GUERRERO", "GONZALES", "999988889", "4421210", "AV. CONQUISTADORES 208 SAN ISIDRO", "PAOLO.GUERRERO@GMAIL.COM", 78794546);

/* TSA_EMPLEADO */

INSERT INTO sunshine_andina_db.tsa_empleado (id_usuario, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, tel_celular, tel_fijo, email, ruc)
values (3, "SIMON", null, "BOLIVAR", "BOLIVAR", "987654321", "4879653", "SIMON.BOLIVAR@GMAIL.COM", 10787946431);

INSERT INTO sunshine_andina_db.tsa_empleado (id_usuario, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, tel_celular, tel_fijo, email, ruc)
values (4, "JUAN", null, "BOLIVAR", "COLON", "987654321", "4879654", "JUAN.BOLIVAR@GMAIL.COM", 10787946432);

INSERT INTO sunshine_andina_db.tsa_empleado (id_usuario, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, tel_celular, tel_fijo, email, ruc)
values (5, "JOSE", null, "PIZARRO", "BOLIVAR", "987654321", "4879655", "JOSE.BOLIVAR@GMAIL.COM", 10787946433);

/*TSA_PEDIDO */
INSERT INTO `sunshine_andina_db`.`tsa_pedido` (`id_cliente`, `estado_pedido`, `precio_acumulado_pedido`, `puntos_acumulado_pedido`) VALUES ('2', 'PAGADO', '10', '30');
INSERT INTO `sunshine_andina_db`.`tsa_pedido` (`id_cliente`, `estado_pedido`, `precio_acumulado_pedido`, `puntos_acumulado_pedido`) VALUES ('1', 'CANCELADO', '15', '20');