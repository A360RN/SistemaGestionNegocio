SELECT * FROM sunshine_andina_db.tsa_perfil;

/* TSA_POLITICA */
INSERT INTO `sunshine_andina_db`.`tsa_politicas` (`desc_politica`, `min_puntos_ind`, `max_puntos_ind`, `min_puntos_grupal`, `max_puntos_grupal`, `porcentaje_descuento`) VALUES ('COMISION_1', '80', '160', '400', '800', '0.05');
INSERT INTO `sunshine_andina_db`.`tsa_politicas` (`desc_politica`, `min_puntos_ind`, `max_puntos_ind`, `min_puntos_grupal`, `max_puntos_grupal`, `porcentaje_descuento`) VALUES ('COMISION_2', '160', '240', '800', '1200', '0.10');
INSERT INTO `sunshine_andina_db`.`tsa_politicas` (`desc_politica`, `min_puntos_ind`, `max_puntos_ind`, `min_puntos_grupal`, `max_puntos_grupal`, `porcentaje_descuento`) VALUES ('COMISION_3', '240', '320', '1200', '1600', '0.15');
INSERT INTO `sunshine_andina_db`.`tsa_politicas` (`desc_politica`, `min_puntos_ind`, `max_puntos_ind`, `min_puntos_grupal`, `max_puntos_grupal`, `porcentaje_descuento`) VALUES ('COMISION_4', '320', '10000000', '1600', '1000000000', '0.20');

/* TSA_PERFIL */

INSERT INTO sunshine_andina_db.TSA_PERFIL(CODIGO_PERFIL, DESC_PERFIL) VALUES ("CLI", "CLIENTE");
INSERT INTO sunshine_andina_db.TSA_PERFIL(CODIGO_PERFIL, DESC_PERFIL) VALUES ("DIS", "DISTRIBUIDOR");
INSERT INTO sunshine_andina_db.TSA_PERFIL(CODIGO_PERFIL, DESC_PERFIL) VALUES ("VEN", "ENCARGADO DE VENTAS");
INSERT INTO sunshine_andina_db.TSA_PERFIL(CODIGO_PERFIL, DESC_PERFIL) VALUES ("INV", "ENCARGADO DE INVENTARIOS");
INSERT INTO sunshine_andina_db.TSA_PERFIL(CODIGO_PERFIL, DESC_PERFIL) VALUES ("ADM", "ENCARGADO DE ADMINISTRACION");

/* TSA_USUARIO */

INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('usuario_cli',NULL,NULL,1);
INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('usuario_dis',NULL,NULL,1);
INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('usuario_ven',NULL,NULL,1);
INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('usuario_inv',NULL,NULL,1);
INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('usuario_adm',NULL,NULL,1);
INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('usuario_adm2','80128c3bcdcc153abd3d10487c028b79cbcbb210667f58f1702c428d61056360','2017-11-19',1);
INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('jose.diaz',NULL,NULL,1);
INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('maria.torres',NULL,NULL,1);
INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('melissa.loza',NULL,NULL,1);
INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('diego.torres',NULL,NULL,1);
INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('juan.torres',NULL,NULL,1);
INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('eduardo.loza',NULL,NULL,1);
INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('miguel.loza',NULL,NULL,1);

/* TSA_USUARIO_PEFIL*/

INSERT INTO sunshine_andina_db.tsa_usuario_perfil values (1,1);
INSERT INTO sunshine_andina_db.tsa_usuario_perfil values (2,2);
INSERT INTO sunshine_andina_db.tsa_usuario_perfil values (3,3);
INSERT INTO sunshine_andina_db.tsa_usuario_perfil values (4,4);
INSERT INTO sunshine_andina_db.tsa_usuario_perfil values (5,5);
INSERT INTO sunshine_andina_db.tsa_usuario_perfil(id_perfil,id_usuario) VALUES (2,7);
INSERT INTO sunshine_andina_db.tsa_usuario_perfil(id_perfil,id_usuario) VALUES (2,8);
INSERT INTO sunshine_andina_db.tsa_usuario_perfil(id_perfil,id_usuario) VALUES (2,9);
INSERT INTO sunshine_andina_db.tsa_usuario_perfil(id_perfil,id_usuario) VALUES (2,10);
INSERT INTO sunshine_andina_db.tsa_usuario_perfil(id_perfil,id_usuario) VALUES (2,11);
INSERT INTO sunshine_andina_db.tsa_usuario_perfil(id_perfil,id_usuario) VALUES (2,12);
INSERT INTO sunshine_andina_db.tsa_usuario_perfil(id_perfil,id_usuario) VALUES (2,13);

/* TSA_CLIENTE */
INSERT INTO sunshine_andina_db.tsa_cliente(id_usuario,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,tel_celular,tel_fijo,direccion,email,dni) VALUES (1,'JEFFERSON','AGUSTIN','FARFAN','GUADALUPE',999988880,4421210,'AV. SEPARADORA INDUSTRIAL 1258 ATE','JEFFERSON.FARFAN@GMAIL.COM',78794547);
INSERT INTO sunshine_andina_db.tsa_cliente(id_usuario,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,tel_celular,tel_fijo,direccion,email,dni) VALUES (2,'JOSE','PAOLO','GUERRERO','GONZALES',999988889,4421210,'AV. CONQUISTADORES 208 SAN ISIDRO','PAOLO.GUERRERO@GMAIL.COM',78794546);
INSERT INTO sunshine_andina_db.tsa_cliente(id_usuario,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,tel_celular,tel_fijo,direccion,email,dni) VALUES (7,'JOSE',NULL,'DIAZ',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO sunshine_andina_db.tsa_cliente(id_usuario,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,tel_celular,tel_fijo,direccion,email,dni) VALUES (8,'MARIA',NULL,'TORRES',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO sunshine_andina_db.tsa_cliente(id_usuario,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,tel_celular,tel_fijo,direccion,email,dni) VALUES (9,'MELISSA',NULL,'LOZA',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO sunshine_andina_db.tsa_cliente(id_usuario,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,tel_celular,tel_fijo,direccion,email,dni) VALUES (10,'DIEGO',NULL,'TORRES',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO sunshine_andina_db.tsa_cliente(id_usuario,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,tel_celular,tel_fijo,direccion,email,dni) VALUES (11,'JUAN',NULL,'TORRES',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO sunshine_andina_db.tsa_cliente(id_usuario,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,tel_celular,tel_fijo,direccion,email,dni) VALUES (12,'EDUARDO',NULL,'LOZA',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO sunshine_andina_db.tsa_cliente(id_usuario,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,tel_celular,tel_fijo,direccion,email,dni) VALUES (13,'MIGUEL',NULL,'LOZA',NULL,NULL,NULL,NULL,NULL,NULL);


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

/* TSA_TIPO_LIDER */
INSERT INTO `sunshine_andina_db`.`tsa_tipo_lider` (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('NO_LIDER', '0', '0', '0');
INSERT INTO `sunshine_andina_db`.`tsa_tipo_lider` (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('NINGUNO', '0', '0', '0');
INSERT INTO `sunshine_andina_db`.`tsa_tipo_lider` (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('BRONCE', '1', '2', '0.05');
INSERT INTO `sunshine_andina_db`.`tsa_tipo_lider` (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('COBRE', '3', '4', '0.06');
INSERT INTO `sunshine_andina_db`.`tsa_tipo_lider` (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('PLATA', '5', '6', '0.07');
INSERT INTO `sunshine_andina_db`.`tsa_tipo_lider` (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('ESMERALDA', '7', '8', '0.08');
INSERT INTO `sunshine_andina_db`.`tsa_tipo_lider` (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('ORO', '9', '10', '0.09');
INSERT INTO `sunshine_andina_db`.`tsa_tipo_lider` (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('RUBÍ', '11', '12', '0.10');
INSERT INTO `sunshine_andina_db`.`tsa_tipo_lider` (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('ZAFIRO', '13', '14', '0.11');
INSERT INTO `sunshine_andina_db`.`tsa_tipo_lider` (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('PLATINO', '15', '16', '0.12');
INSERT INTO `sunshine_andina_db`.`tsa_tipo_lider` (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('DIAMANTE', '17', '30', '0.13');

/* TSA_DISTRIBUIDOR */
INSERT INTO sunshine_andina_db.tsa_distribuidor(desc_tipo_lider,lideres_min,lideres_max,porcentaje) VALUES ('3',3,0,2-000001);
INSERT INTO sunshine_andina_db.tsa_distribuidor(desc_tipo_lider,lideres_min,lideres_max,porcentaje) VALUES ('4',2,1,2-000002);
INSERT INTO sunshine_andina_db.tsa_distribuidor(desc_tipo_lider,lideres_min,lideres_max,porcentaje) VALUES ('5',2,1,2-000003);
INSERT INTO sunshine_andina_db.tsa_distribuidor(desc_tipo_lider,lideres_min,lideres_max,porcentaje) VALUES ('6',1,2,2-000004);
INSERT INTO sunshine_andina_db.tsa_distribuidor(desc_tipo_lider,lideres_min,lideres_max,porcentaje) VALUES ('7',1,2,2-000005);
INSERT INTO sunshine_andina_db.tsa_distribuidor(desc_tipo_lider,lideres_min,lideres_max,porcentaje) VALUES ('8',1,3,2-000006);
INSERT INTO sunshine_andina_db.tsa_distribuidor(desc_tipo_lider,lideres_min,lideres_max,porcentaje) VALUES ('9',1,3,2-000007);

/* TSA_HISTORICO_DISTRIBUIDOR*/
INSERT INTO `sunshine_andina_db`.`tsa_historico_distribuidor` (`id_distribuidor`, `puntos_individual`, `puntos_grupal`, `ventas_soles_ind`, `ventas_soles_grupal`, `mes_historico`, `anio_historico`) VALUES ('1', '1000', '2640', '5000', '13200', '11', '2017');
INSERT INTO `sunshine_andina_db`.`tsa_historico_distribuidor` (`id_distribuidor`, `puntos_individual`, `puntos_grupal`, `ventas_soles_ind`, `ventas_soles_grupal`, `mes_historico`, `anio_historico`) VALUES ('2', '1000', '400', '5000', '2000', '11', '2017');
INSERT INTO `sunshine_andina_db`.`tsa_historico_distribuidor` (`id_distribuidor`, `puntos_individual`, `puntos_grupal`, `ventas_soles_ind`, `ventas_soles_grupal`, `mes_historico`, `anio_historico`) VALUES ('3', '1000', '240', '5000', '1200', '11', '2017');
INSERT INTO `sunshine_andina_db`.`tsa_historico_distribuidor` (`id_distribuidor`, `puntos_individual`, `puntos_grupal`, `ventas_soles_ind`, `ventas_soles_grupal`, `mes_historico`, `anio_historico`) VALUES ('4', '240', '0', '1200', '0', '11', '2017');
INSERT INTO `sunshine_andina_db`.`tsa_historico_distribuidor` (`id_distribuidor`, `puntos_individual`, `puntos_grupal`, `ventas_soles_ind`, `ventas_soles_grupal`, `mes_historico`, `anio_historico`) VALUES ('5', '160', '0', '800', '0', '11', '2017');
INSERT INTO `sunshine_andina_db`.`tsa_historico_distribuidor` (`id_distribuidor`, `puntos_individual`, `puntos_grupal`, `ventas_soles_ind`, `ventas_soles_grupal`, `mes_historico`, `anio_historico`) VALUES ('6', '160', '0', '800', '0', '11', '2017');
INSERT INTO `sunshine_andina_db`.`tsa_historico_distribuidor` (`id_distribuidor`, `puntos_individual`, `puntos_grupal`, `ventas_soles_ind`, `ventas_soles_grupal`, `mes_historico`, `anio_historico`) VALUES ('7', '80', '0', '400', '0', '11', '2017');

/* TSA_COMISION */
INSERT INTO `sunshine_andina_db`.`tsa_comision` (`id_distribuidor`, `monto_comision`, `mes_comision`, `anio_comision`) VALUES ('1', '1660', '11', '2017');
INSERT INTO `sunshine_andina_db`.`tsa_comision` (`id_distribuidor`, `monto_comision`, `mes_comision`, `anio_comision`) VALUES ('2', '1050', '11', '2017');
INSERT INTO `sunshine_andina_db`.`tsa_comision` (`id_distribuidor`, `monto_comision`, `mes_comision`, `anio_comision`) VALUES ('3', '930', '11', '2017');

