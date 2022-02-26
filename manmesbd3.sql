create database Manimes;
use Manimes;

create table manga(
Cod_manga varchar(11) unique not null primary key,
nome_manga varchar(256) not null,
nome_autor  varchar(256) not null,
datapub int not null ,
distribuidora varchar(256) not null
);
insert into manga(Cod_manga,nome_manga,nome_autor,datapub,distribuidora)
values(700,'naruto', 'masashi_kishimoto', 1999, 'shounen_jump');
select*from manga;
insert into manga(Cod_manga,nome_manga,nome_autor,datapub,distribuidora)
values(890,'dragon_ball', 'Akira_toryama', 1984, 'shounen_jump');
insert into manga(Cod_manga,nome_manga,nome_autor,datapub,distribuidora)
values(10,'bleach', 'Kubo_Tite', 2001, 'shounen_jump');
insert into manga(Cod_manga,nome_manga,nome_autor,datapub,distribuidora)
values(389,'fma', 'Hiromu Arakawa', 2001, 'square_enix');
insert into manga(Cod_manga,nome_manga,nome_autor,datapub,distribuidora)
values(12,'One_piece', 'Eiichiro_Oda', 1997, 'shounen_jump');
update manga set Cod_manga= '800' where Cod_manga='700';
delete from manga where Cod_manga='800';
select*from manga;
describe manga;

create table anime(
Cod_anime varchar(256) unique not null primary key,
nome_anime varchar(256) not null,
genero varchar(256) not null,
n_episodios int not null
);
insert into anime(Cod_anime,nome_anime,genero,n_episodios)
values(700,'naruto','shounen', 750);
select*from anime;
update anime set Cod_anime= '800' where Cod_anime='700';
insert into anime(Cod_anime,nome_anime,genero,n_episodios)
values(890,'dragon_ball','shounen', 800);
delete from anime where cod_anime='700';
select*from anime;
 insert into anime (Cod_anime, n_episodios,nome_anime,genero) 
 values (10, 200, 'bleach','shounen');
 select*from anime;
  insert into anime (Cod_anime, n_episodios,nome_anime,genero) 
  values(12,1000,'one_piece','shounen');
  select*from anime;
  describe anime;

create table plataforma(
Cod_plataforma varchar(256) unique not null primary key,
nome_plataforma varchar(256) not null,
n_animes int not null,
n_assinantes int not null
);
insert into plataforma(Cod_plataforma,nome_plataforma,n_animes,n_assinantes)
values(1000,'netflix',70,10000);
select*from plataforma;
insert into plataforma(Cod_plataforma,nome_plataforma,n_animes,n_assinantes)
values(1234,'crunchyroll',200,3000);
insert into plataforma(Cod_plataforma,nome_plataforma,n_animes,n_assinantes)
values(2002,'funimation',120,1500);
insert into plataforma(Cod_plataforma,nome_plataforma,n_animes,n_assinantes)
values(2000,'hbo_Max',7,8000);
insert into plataforma(Cod_plataforma,nome_plataforma,n_animes,n_assinantes)
values(3000,'animax',400,800);
select*from plataforma;
describe plataforma;
select plat.Cod_plataforma, plat.nome_plataforma,plat.n_animes, plat.n_assinantes, ani.Cod_anime, ani.nome_anime, ani.genero, ani.n_episodios from plataforma plat
inner join distribuição dis on dis.cod_plataforma=plat.Cod_plataforma
inner join anime ani on dis.cod_anime= ani.Cod_anime where plat.Cod_plataforma;
select plat.Cod_plataforma, plat.nome_plataforma,plat.n_animes, plat.n_assinantes, ani.Cod_anime, ani.nome_anime, ani.genero, ani.n_episodios from plataforma plat 
left join distribuição dis on dis.cod_plataforma=plat.Cod_plataforma
left join anime ani on dis.cod_anime= ani.Cod_anime where plat.Cod_plataforma=1000;

create table distribuição(
cod_distribuição varchar(256) unique not null primary key,
cod_anime varchar(256),
cod_plataforma varchar(256),
constraint cod_anime_fk FOREIGN KEY (cod_anime) REFERENCES anime(Cod_anime),
constraint cod_plataforma_fk FOREIGN KEY (cod_plataforma) REFERENCES plataforma(Cod_plataforma)
);
insert into distribuição(cod_distribuição,Cod_plataforma,cod_anime)
values(11,'1234',10);
insert into distribuição(cod_distribuição,Cod_plataforma,cod_anime)
values(10,'1000',800);
insert into distribuição(cod_distribuição,Cod_plataforma,cod_anime)
values(12,'1234',10);
insert into distribuição(cod_distribuição,Cod_plataforma,cod_anime)
values(13,'2002',11);
insert into distribuição(cod_distribuição,Cod_plataforma,cod_anime)
values(14,'1000',389);
update distribuição set cod_anime= '12' where cod_distribuição='12';
select*from distribuição;
describe distribuição;
SELECT * 
FROM distribuição, anime
join anime on distribuição.cod_anime =anime.Cod_anime; 
select*from distribuição;
SELECT * 
FROM distribuição
join plataforma on distribuição.cod_plataforma =plataforma.Cod_plataforma; 


create table supervisão(
cod_supervisão varchar(256) unique not null primary key,
cod_plataforma varchar(256) ,
cod_sistema varchar(256),
constraint cod_sistema_fk FOREIGN KEY (cod_sistema) REFERENCES sistema(cod_sistema),
constraint cod_plataformasv_fk FOREIGN KEY (cod_plataforma) REFERENCES plataforma(Cod_plataforma) 
);
insert into supervisão(cod_supervisão,cod_plataforma,cod_sistema)
values(11,'1000',90);
insert into supervisão(cod_supervisão,Cod_plataforma,cod_sistema)
values(12,'1234',80);
insert into supervisão(cod_supervisão,Cod_plataforma,cod_sistema)
values(13,'2002',70);
insert into supervisão(cod_supervisão,Cod_plataforma,cod_sistema)
values(14,'2000',60);
insert into supervisão(cod_supervisão,Cod_plataforma,cod_sistema)
values(15,'3000',50);
insert into supervisão(cod_supervisão,Cod_plataforma,cod_sistema)
values(16,'3000',60);
select*from supervisão;
describe supervisão;
SELECT * 
FROM supervisão
join sistema on supervisão.cod_sistema=sistema.Cod_sistema; 
SELECT * 
FROM supervisão
join plataforma on supervisão.cod_plataforma=plataforma.Cod_plataforma ; 
select*from sistema sis
left join supervisão sv on sv.cod_sistema=sis.Cod_sistema
left join plataforma plat on sv.cod_plataforma= plat.Cod_plataforma;
select*from sistema sis
inner join supervisão sv on sv.cod_sistema=sis.Cod_sistema
inner join plataforma plat on sv.cod_plataforma= plat.Cod_plataforma where sis.Cod_sistema= 60;


create table sistema(
cod_sistema varchar(256) unique not null primary key,
nome_adm varchar(256) not null
);
insert into sistema(cod_sistema,nome_adm)
values(90,'reitor');
select*from sistema;
insert into sistema(cod_sistema,nome_adm)
values(80,'lucas');
insert into sistema(cod_sistema,nome_adm)
values(70,'pedro');
insert into sistema(cod_sistema,nome_adm)
values(60,'anderson');
insert into sistema(cod_sistema,nome_adm)
values(50,'vinicius');
insert into sistema(cod_sistema,nome_adm)
values(100,'vinicius');
select*from sistema;
describe sistema;

create view dis_plat_ani
as select anime.nome_anime as Anime,
distribuição.cod_anime as codigo_anime
from anime
inner join distribuição
on anime.Cod_anime  = distribuição.cod_anime;

select Anime,  codigo_anime
from dis_plat_ani 
order by anime;
 
create view sup_plat
as select plataforma.nome_plataforma as Plataforma,
supervisão.Cod_plataforma as codigo_plataforma
from plataforma
inner join supervisão
on plataforma.cod_plataforma  = supervisão.Cod_plataforma;

select Plataforma,  codigo_plataforma
from sup_plat 
order by plataforma;

#----------------------- 1 procedure ---------------------
delimiter $$
create procedure update_nome_anime(
	#parametros que a procedure vai receber
    nomeAnime char(40)
)
begin
	update anime set nome_anime = nomeAnime
	where Cod_anime = 12;
    select * from anime where Cod_anime = 12;
    
end $$
delimiter ; 

DROP PROCEDURE update_nome_anime;  

call update_nome_anime('ONE_PIECE');

select * from anime;
describe anime;
#----------------------- 1 procedure ---------------------
#--------------- Triggers ----------------------------
create table preço_plat(
Codigoplataforma int auto_increment ,
nome_plataforma varchar(45),
preco_assinatura float,
desconto float,
preço_com_desconto float,
primary key (Codigoplataforma)
);
create trigger plat_desconto before insert 
on preço_plat
for each row set
New.desconto = (New.preco_assinatura * 0.10);
insert into preço_plat(nome_plataforma, preco_assinatura)
values ('Netflix', 24.90), ('hbo_max', 25);
select * from preço_plat;
#--------------- Triggers ----------------------------
#--------------- Funcion ----------------------------
DELIMITER $$
create function plat_com_desconto (
nome_plataforma varchar(45),
preco_assinatura float,
desconto float
)returns float
begin
	return preco_assinatura - desconto;
end; $$
DELIMITER ;
select plat_com_desconto (24.90, 2.49) as 'preço com desconto' ;
SET GLOBAL log_bin_trust_function_creators = 1;
drop function plat_com_desconto;
#--------------- Funcion ----------------------------