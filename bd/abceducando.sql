drop database abceducando2;

create database abceducando2;

use abceducando2;

create table Usuario(
UsuarioId int not null auto_increment,
UsuarioLogin varchar(70) not null,
UsuarioPassword varchar(20) not null,
DatosNumeroId varchar(30) not null,
primary key(UsuarioId));

create table Rol(
RolId int not null auto_increment,
RolTipo varchar(50) not null,
primary key(RolId));

create table UsuarioRol(
UsuarioId int not null,
RolId int not null);

create table DatosPersonales(
DatosNombres varchar(50) not null,
DatosApellidos varchar(50) not null,
DatosTipoId varchar(30) not null,
DatosNumeroId varchar(30) not null,
DatosTelefono varchar(30) not null,
DatosEmail varchar(70) not null,
DatosFechaNac varchar(30) not null,
primary key(DatosNumeroId));

create table Administrativo(
AdministrativoId int not null auto_increment,
DatosNumeroId varchar(30) not null,
primary key(AdministrativoId));

create table Docente(
DocenteId int not null auto_increment,
FechaIngreso varchar(30) not null,
FechaSalida varchar(30) not null,
DatosNumeroId varchar(30) not null,
primary key(DocenteId));

create table Acudiente(
AcudienteId int not null auto_increment,
DatosNumeroId varchar(30) not null,
primary key(AcudienteId));

create table Estudiante(
EstudianteId int not null auto_increment,
DatosNumeroId varchar(30) not null,
AcudienteId int not null,
primary key(EstudianteId));

create table ActividadCargada(
ActividadCargadaId int not null auto_increment,
ActividadCargadaNombre varchar(100) not null,
ActividadCargadaDescripcion varchar(500) not null,
Actcaraarchivo blob not null,
DocenteId int not null,
primary key(ActividadCargadaId));

create table Materia(
MateriaId int not null auto_increment,
MateriaNombre varchar(50) not null,
DocenteId int not null,
primary key(MateriaId));
 
create table Nota(
NotaId int not null auto_increment,
NotaValor varchar(10) not null,
EstudianteId int not null,
DocenteId int not null,
MateriaId int not null,
Actividadentregadaid int not null,
primary key(NotaId));

create table Reporte(
ReporteId int not null auto_increment,
ReportePromedio varchar(10) not null,
NotaId int not null,
primary key(ReporteId));

create table ActividadEntregada(
ActividadEntregadaId int not null auto_increment,
ActividadEntregadaNombre varchar(100) not null,
ActividadEntregadaDescripcion varchar(500) not null,
ActividadEntregadaArchivo blob not null,
ActividadEntregadaEstado varchar(30) not null,
EstudianteId int not null,
primary key(ActividadEntregadaId));

create table Matricula(
MatriculaId int not null auto_increment,
MatriculaEstado varchar(30) not null,
EstudianteId int not null,
primary key(MatriculaId));

create table MateriaEstudiante(
MateriaId int not null,
EstudianteId int not null);

alter table UsuarioRol add constraint fk_relationship_1 foreign key (UsuarioId)
references Usuario(UsuarioId) on delete restrict on update restrict;

alter table UsuarioRol add constraint fk_relationship_2 foreign key (RolId)
references Rol(RolId) on delete restrict on update restrict;

alter table Usuario add constraint fk_relationship_3 foreign key (DatosNumeroId)
references DatosPersonales(DatosNumeroId) on delete restrict on update restrict;

alter table Administrativo add constraint fk_relationship_4 foreign key (DatosNumeroId)
references DatosPersonales(DatosNumeroId) on delete restrict on update restrict;

alter table Docente add constraint fk_relationship_5 foreign key (DatosNumeroId)
references DatosPersonales(DatosNumeroId) on delete restrict on update restrict;

alter table Estudiante add constraint fk_relationship_6 foreign key (DatosNumeroId)
references DatosPersonales(DatosNumeroId) on delete restrict on update restrict;

alter table Estudiante add constraint fk_relationship_7 foreign key (AcudienteId)
references Acudiente(AcudienteId) on delete restrict on update restrict;

alter table Materia add constraint fk_relationship_8 foreign key (DocenteId)
references Docente(DocenteId) on delete restrict on update restrict;

alter table MateriaEstudiante add constraint fk_relationship_9 foreign key (MateriaId)
references Materia(MateriaId) on delete restrict on update restrict;

alter table MateriaEstudiante add constraint fk_relationship_10 foreign key (EstudianteId)
references Estudiante(EstudianteId) on delete restrict on update restrict;

alter table ActividadCargada add constraint fk_relationship_11 foreign key (DocenteId)
references Docente(DocenteId) on delete restrict on update restrict;

alter table Nota add constraint fk_relationship_12 foreign key (EstudianteId)
references Estudiante(EstudianteId) on delete restrict on update restrict;

alter table Nota add constraint fk_relationship_13 foreign key (DocenteId)
references Docente(DocenteId) on delete restrict on update restrict;

alter table Nota add constraint fk_relationship_14 foreign key (MateriaId)
references Materia(MateriaId) on delete restrict on update restrict;

alter table Reporte add constraint fk_relationship_15 foreign key (NotaId)
references Nota(NotaId) on delete restrict on update restrict;

alter table ActividadEntregada add constraint fk_relationship_16 foreign key (EstudianteId)
references Estudiante(EstudianteId) on delete restrict on update restrict;

alter table nota add constraint fk_relationship_17 foreign key (Actividadentregadaid)
references actividadentregada(Actividadentregadaid) on delete restrict on update restrict;

alter table Acudiente add constraint fk_relationship_18 foreign key (DatosNumeroId)
references DatosPersonales(DatosNumeroId) on delete restrict on update restrict;

alter table Matricula add constraint fk_relationship_19 foreign key (EstudianteId)
references Estudiante(EstudianteId) on delete restrict on update restrict;