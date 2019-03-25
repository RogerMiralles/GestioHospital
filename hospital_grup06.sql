DROP DATABASE IF EXISTS hospital_grup06;
CREATE DATABASE hospital_grup06;
CREATE USER IF NOT EXISTS admin_hospital_grup06 IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON hospital_grup06.* TO admin_hospital_grup06 WITH GRANT OPTION;
CREATE USER IF NOT EXISTS usuario_hospital_grup06 IDENTIFIED BY 'usuari';
GRANT SELECT ON hospital_grup06.* TO usuario_hospital_grup06;

USE hospital_grup06;

CREATE TABLE METGES (
	numEmpleat INT UNIQUE NOT NULL,
	nifMetge CHAR(9),
	nomMetge VARCHAR(10),
	cognom1Metge VARCHAR(40),
    cognom2Metge VARCHAR(40),
    numSegSoc INT UNIQUE NOT NULL,
    telefon INT UNIQUE NOT NULL,
    salariMensual INT,
    codiCompte CHAR(4),
    ciutat VARCHAR(20),
    codiPostal INT,
    carrer VARCHAR(20),
    numero INT,
    planta VARCHAR(10),
    porta VARCHAR(10),
    PRIMARY KEY(nifMetge)
);

CREATE TABLE PACIENTS (
	nifPacient CHAR(9),
    nomPacient VARCHAR(10),
	cognom1Pacient VARCHAR(40),
    cognom2Pacient VARCHAR(40),
    numSegSoc CHAR(12) UNIQUE NOT NULL,
    telefon INT UNIQUE NOT NULL,
    ciutat VARCHAR(20),
    codiPostal INT,
    carrer VARCHAR(20),
    numero INT,
    planta VARCHAR(10),
    porta VARCHAR(10),
    PRIMARY KEY(nifPacient)
);

CREATE TABLE MALALTIES(
	codiMalaltia INT,
    nomMalaltia VARCHAR(20),
    causaBaixa CHAR(2),
    tractament VARCHAR(30),
    duracio INT,
    PRIMARY KEY(codiMalaltia)
);

CREATE TABLE HISTORIALS(
	codiHistorial INT,
    nomPacient VARCHAR(10),
    PRIMARY KEY(codiHistorial)
);

CREATE TABLE VISITES(
	codiVisita INT,
	fecha DATETIME,
    codiMalaltia INT,
    dniMetge CHAR(9),
    dniPacient CHAR(9),
    PRIMARY KEY(codiVisita),
	FOREIGN KEY (codiMalaltia) REFERENCES MALALTIES(codiMalaltia),
    FOREIGN KEY (dniMetge) REFERENCES METGES(nifMetge),
    FOREIGN KEY (dniPacient) REFERENCES PACIENTS(nifPacient)
);
