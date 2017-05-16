DROP TABLE IF EXISTS ambiente;
CREATE TABLE ambiente (
  idambiente int(11) NOT NULL AUTO_INCREMENT,
  humedad int(11) DEFAULT NULL,
  presion double DEFAULT NULL,
  indiceUV int(11) DEFAULT NULL,
  visibilidad double DEFAULT NULL,
  PRIMARY KEY (idambiente)
);

DROP TABLE IF EXISTS astronomia;
CREATE TABLE astronomia (
  idastronomia int(11) NOT NULL AUTO_INCREMENT,
  amanecer tinytext,
  atardecer tinytext,
  PRIMARY KEY (idastronomia)
);

DROP TABLE IF EXISTS climadia;
CREATE TABLE climadia (
  codigo int(11) NOT NULL,
  fecha date DEFAULT NULL,
  dia tinytext,
  minima int(11) DEFAULT NULL,
  maxima int(11) DEFAULT NULL,
  descripcion tinytext,
  PRIMARY KEY (codigo)
);

DROP TABLE IF EXISTS climadia_consulta;
CREATE TABLE climadia_consulta (
  idConsulta int(11) NOT NULL,
  idClimaDia int(11) NOT NULL,
  PRIMARY KEY (idConsulta,idClimaDia),
  KEY climaDia_idx (idClimaDia),
  CONSTRAINT climaDia FOREIGN KEY (idClimaDia) REFERENCES climadia (codigo) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT consulta FOREIGN KEY (idConsulta) REFERENCES consulta (idconsulta) ON DELETE NO ACTION ON UPDATE NO ACTION
);

DROP TABLE IF EXISTS condicion;
CREATE TABLE condicion (
  idcondicion int(11) NOT NULL AUTO_INCREMENT,
  codigo int(11) DEFAULT NULL,
  temperatura int(11) DEFAULT NULL,
  dia date DEFAULT NULL,
  descripcion text,
  idUbicacion int(11) DEFAULT NULL,
  idAmbiente int(11) DEFAULT NULL,
  idAstronomia int(11) DEFAULT NULL,
  idViento int(11) DEFAULT NULL,
  PRIMARY KEY (idcondicion),
  KEY viento_idx (idViento),
  KEY ambiente_idx (idAmbiente),
  KEY astronomia_idx (idAstronomia),
  CONSTRAINT ambiente FOREIGN KEY (idAmbiente) REFERENCES ambiente (idambiente) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT astronomia FOREIGN KEY (idAstronomia) REFERENCES astronomia (idastronomia) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT viento FOREIGN KEY (idViento) REFERENCES viento (idviento) ON DELETE NO ACTION ON UPDATE NO ACTION
);

DROP TABLE IF EXISTS consulta;
CREATE TABLE consulta (
  idconsulta int(11) NOT NULL AUTO_INCREMENT,
  fechaConsulta date DEFAULT NULL,
  latitud double DEFAULT NULL,
  longitud double DEFAULT NULL,
  idCondicion int(11) DEFAULT NULL,
  PRIMARY KEY (idconsulta),
  KEY condicion_idx (idCondicion),
  CONSTRAINT condicion FOREIGN KEY (idCondicion) REFERENCES condicion (idcondicion) ON DELETE NO ACTION ON UPDATE NO ACTION
);

DROP TABLE IF EXISTS ubicacion;
CREATE TABLE ubicacion (
  idUbicacion int(11) NOT NULL AUTO_INCREMENT,
  ciudad tinytext NOT NULL,
  pais tinytext,
  region tinytext,
  PRIMARY KEY (idUbicacion)
);

DROP TABLE IF EXISTS viento;
CREATE TABLE viento (
  idviento int(11) NOT NULL AUTO_INCREMENT,
  temperatura int(11) DEFAULT NULL,
  velocidad int(11) DEFAULT NULL,
  direccion int(11) DEFAULT NULL,
  PRIMARY KEY (idviento)
);
