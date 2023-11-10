DROP TABLE IF EXISTS pelicula;
DROP table IF EXISTS salas;


CREATE TABLE pelicula (
  codigo int NOT NULL AUTO_INCREMENT,
  nombre varchar(250) DEFAULT NULL,
  calificacion_Edad int DEFAULT NULL,
  PRIMARY KEY (codigo)
);

CREATE TABLE salas (
  codigo int NOT NULL AUTO_INCREMENT,
  nombre varchar(250) DEFAULT NULL,
  pelicula int DEFAULT NULL,
  PRIMARY KEY (codigo),
  FOREIGN KEY (pelicula) REFERENCES pelicula (codigo)
);


insert into pelicula (nombre, calificacion_Edad)values('Buscando a Nemo', 3);
insert into pelicula (nombre, calificacion_Edad)values('Investigacion', 3);
insert into pelicula (nombre, calificacion_Edad)values('La Ruta al Dorado', 7);
insert into pelicula (nombre, calificacion_Edad)values('Ready Player One', 13);
insert into pelicula (nombre, calificacion_Edad)values('Deadpool', 18);

insert into salas (nombre, pelicula) values ('Sala 1',1);
insert into salas (nombre, pelicula) values ('Sala 2',2);
insert into salas (nombre, pelicula) values ('Sala 3',3);
insert into salas (nombre, pelicula) values ('Sala 4',4);
insert into salas (nombre, pelicula) values ('Sala 5',5);