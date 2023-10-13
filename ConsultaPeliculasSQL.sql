create table peliculas (
pel_id int primary key not null auto_increment  ,
pel_titulo varchar(255) not null,
pel_url varchar(255),
pel_imagen varchar(255),
gen_id int not null,
constraint fk_peliculas_generos foreign key(gen_id) references generos(gen_id)

);

ALTER TABLE peliculas ADD COLUMN pel_imagen VARCHAR(255);

ALTER TABLE peliculas ADD COLUMN titulo VARCHAR(255);

ALTER TABLE peliculas ADD COLUMN pel_titulo VARCHAR(255);


CREATE table generos(
gen_id int primary key not null auto_increment,
gen_nombre varchar (50)
);


SELECT peliculas.titulo AS pelicula, generos.nombre AS genero
FROM peliculas
JOIN generos ON peliculas.genero_id = generos.id
WHERE peliculas.titulo = 'dog patrol';

insert into peliculas(pel_titulo, pel_url,pel_imagen, gen_id) values ('tonto y re tonto', 'https//pelispedia.com','t&t.jpg',3); 

insert into generos(gen_nombre) values('infantil');

select * from  peliculas where gen_id = 3;
select * from generos where gen_id = 1;


select * 
from peliculas p 
inner join generos g on p.gen_id = g.gen_id
where g.gen_id =  7;

select p.pel_titulo as 'titulos', g.gen_nombre as 'genero'
from peliculas p 
inner join generos g on p.gen_id = g.gen_id;


select p.*, g.gen_nombre as 'genero'
from peliculas p 
inner join generos g on p.gen_id = g.gen_id