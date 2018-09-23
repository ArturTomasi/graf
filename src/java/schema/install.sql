/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Artur Tomasi
 * Created: Sep 16, 2018
 */

drop database if exists graf;

create database graf;

use graf;

create table core_roles
(
    id int not null auto_increment,
    role varchar(60) not null, 
    name varchar(160) not null,
    primary key (id)
);

create table core_users
(
    id int not null auto_increment,
    login varchar(60) not null,
    password varchar(60) not null, 
    profile int not null,
    name varchar(160) not null, 
    primary key(id)
);

create table core_user_roles
(
    ref_user int not null,
    ref_role int not null,
    primary key( ref_user, ref_role ),
    foreign key fk_user_roles_user (ref_user) references core_users (id),
    foreign key fk_user_roles_role (ref_role) references core_roles (id)
);

insert into core_roles ( id, role, name ) values ( -1, 'manager-gui', 'Tomcat Manager GUI' );
insert into core_roles ( id, role, name ) values ( -2, 'manager-script', 'Tomcat Manager Script' );
insert into core_roles ( id, role, name ) values ( 1, 'administrator', 'Administrador' );
insert into core_roles ( id, role, name ) values ( 2, 'operator', 'Operador' );

-- password: admin
insert into core_users ( id, login, password, name, profile ) values ( -1, 'tomcat', '21232f297a57a5a743894a0e4a801fc3', 'Tomcat Administrator', 1 );
insert into core_users ( id, login, password, name, profile ) values ( 1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'Administrador do Sistema', 1 );

insert into core_users ( id, login, password, name, profile ) values ( 2, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'Gerson', 1 );

insert into core_user_roles values ( -1, -1 );
insert into core_user_roles values ( -1, -2 );

insert into core_user_roles values ( 1, 1 );
insert into core_user_roles values ( 1, -1 );
insert into core_user_roles values ( 1, -2 );

insert into core_user_roles values ( 2, 1 );
insert into core_user_roles values ( 2, -1 );
insert into core_user_roles values ( 2, -2 );