------------------------------------------------------------
-- Filename:    graf.sql
-- 
-- Description: Implementation of the graf class.
-- 
-- URL:         $URL$
-- 
-- Revision:    $Revision$ / $Date$
-- 
-- Changed by:  $Author$
-- 
-- Author:      (your full name)
-- EMail:       (your email address)
-- Internet:    www.interact.com.br
-- 
-- Copyright © 1999-2018 by Interact Solutions Ltda.
-- Rua Carlos Fett Filho, 47/301
-- 95.900.000, LAJEADO, RS
-- BRAZIL
-- 
-- The copyright to the computer program(s) herein
-- is the property of Interact Solutions Ltda., Brazil.
-- The program(s) may be used and/or copied only with
-- the written permission of Interact Solutions Ltda.
-- or in accordance with the terms and conditions
-- stipulated in the agreement/contract under which
-- the program(s) have been supplied.
------------------------------------------------------------

drop database if exists performance;

create database performance;

use performance;

create table per_1
(
    text_1 text,
    text_2 text,
    text_3 text,
    text_4 text,
    text_5 text,
    img_01 LONGBLOB,
    img_02 LONGBLOB,
    img_03 LONGBLOB,
    img_04 LONGBLOB,
    img_05 LONGBLOB
);

create table per_2
(
    text_1 text,
    text_2 text,
    text_3 text,
    text_4 text,
    text_5 text,
    img_01 LONGBLOB,
    img_02 LONGBLOB,
    img_03 LONGBLOB,
    img_04 LONGBLOB,
    img_05 LONGBLOB
);

drop procedure if exists doWhile;
delimiter //  
create procedure doWhile( in qntd int )
begin
    declare i int default 0;

    while ( i < qntd ) do

        insert into per_1 values ( MD5(RAND()), MD5(RAND()), MD5(RAND()), MD5(RAND()), MD5(RAND()), null, null, null, null, null );
        insert into per_2 values ( MD5(RAND()), MD5(RAND()), MD5(RAND()), MD5(RAND()), MD5(RAND()), null, null, null, null, null );

        set i = i+1;

    end while;
end;//
