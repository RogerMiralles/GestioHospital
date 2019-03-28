DROP DATABASE IF EXISTS hospital_grup06;
CREATE DATABASE hospital_grup06;
CREATE USER IF NOT EXISTS admin_hospital_grup06 IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON hospital_grup06.* TO admin_hospital_grup06 WITH GRANT OPTION;
CREATE USER IF NOT EXISTS usuario_hospital_grup06 IDENTIFIED BY 'usuari';
GRANT SELECT, INSERT ON hospital_grup06.* TO usuario_hospital_grup06;
SET GLOBAL log_bin_trust_function_creators = 1;

USE hospital_grup06;

CREATE TABLE METGES (
    numEmpleat INT UNIQUE NOT NULL,
    nifMetge CHAR(9),
    nomMetge VARCHAR(10),
    cognom1Metge VARCHAR(40),
    cognom2Metge VARCHAR(40),
    numSegSoc CHAR(12) UNIQUE NOT NULL,
    telefon CHAR(9) UNIQUE NOT NULL,
    salariMensual INT,
    codiCompte CHAR(4),
    ciutat VARCHAR(20),
    codiPostal BIGINT,
    carrer VARCHAR(20),
    numero INT,
    planta VARCHAR(10),
    porta VARCHAR(10),
    PRIMARY KEY(nifMetge)
);

CREATE TABLE PACIENTS (
    nifPacient CHAR(9),
    codiHistorial INT UNIQUE NOT NULL,
    nomPacient VARCHAR(10),
    cognom1Pacient VARCHAR(40),
    cognom2Pacient VARCHAR(40),
    numSegSoc CHAR(12) UNIQUE NOT NULL,
    telefon CHAR(9) UNIQUE NOT NULL,
    ciutat VARCHAR(20),
    codiPostal BIGINT,
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

CREATE TABLE VISITES(
    codiVisita INT auto_increment,
    fecha DATETIME,
    codiMalaltia INT,
    dniMetge CHAR(9),
    dniPacient CHAR(9),
    PRIMARY KEY(codiVisita),
	FOREIGN KEY (codiMalaltia) REFERENCES MALALTIES(codiMalaltia),
    FOREIGN KEY (dniMetge) REFERENCES METGES(nifMetge),
    FOREIGN KEY (dniPacient) REFERENCES PACIENTS(nifPacient)
);

# FUNCION PARA ACTUALIZAR PACIENTES (DNI NO ACTUALIZABLE)

DROP FUNCTION IF EXISTS actualizaPacient;
DELIMITER // 
CREATE FUNCTION actualizaPacient(newNifPacient CHAR(9), newNomPacient VARCHAR(10), 
    newCognom1Pacient VARCHAR(40), newCognom2Pacient VARCHAR(40), newNumSegSoc CHAR(12), newTelefon INT,
    newCiutat VARCHAR(20), newCodiPostal INT, newCarrer VARCHAR(20),
    newNumero INT, newPlanta VARCHAR(10), newPorta VARCHAR(10)) RETURNS BOOL

BEGIN 
    UPDATE hospital_grup06.PACIENTS SET 
        nomPacient = newNomPacient,
        cognom1Pacient = newCognom1Pacient,
        cognom2Pacient = newCognom2Pacient,
        numSegSoc = newNumSegSoc,
        telefon = newTelefon,
        ciutat = newCiutat,
        codiPostal = newCodiPostal,
        carrer = newCarrer,
        numero = newNumero,
        planta = newPlanta,
        porta = newPorta
    WHERE NifPacient = newNifPacient;
    RETURN TRUE;
END;
// 
DELIMITER ;

GRANT EXECUTE ON FUNCTION hospital_grup06.actualizaPacient TO usuario_hospital_grup06;

# FUNCION PARA ACTUALIZAR METGES (DNI NO ACTUALIZABLE)

DROP FUNCTION IF EXISTS actualizaMetge;
DELIMITER // 
CREATE FUNCTION actualizaMetge(newNumEmpleat INT, newNifMetge CHAR(9), newNomMetge VARCHAR(10), 
    newCognom1Metge VARCHAR(40), newCognom2Metge VARCHAR(40), newNumSegSoc CHAR(12), newTelefon INT,
    newSalariMensual INT, newCodiCompte CHAR(4), newCiutat VARCHAR(20), newCodiPostal INT, newCarrer VARCHAR(20),
    newNumero INT, newPlanta VARCHAR(10), newPorta VARCHAR(10)) RETURNS BOOL

BEGIN 
    UPDATE hospital_grup06.METGES SET 
        numEmpleat = newNumEmpleat,
        nomMetge = newNomMetge,
        cognom1Metge = newCognom1Metge,
        cognom2Metge = newCognom2Metge,
        numSegSoc = newNumSegSoc,
        telefon = newTelefon,
        salariMensual = newSalariMensual,
        codiCompte = newCodiCompte,
        ciutat = newCiutat,
        codiPostal = newCodiPostal,
        carrer = newCarrer,
        numero = newNumero,
        planta = newPlanta,
        porta = newPorta
    WHERE nifMetge = newNifMetge;
    RETURN TRUE;
END;
// 
DELIMITER ;

GRANT EXECUTE ON FUNCTION hospital_grup06.actualizaMetge TO usuario_hospital_grup06;

# FUNCION PARA ACTUALIZAR MALALTIA

DROP FUNCTION IF EXISTS actualizaMalaltia;
DELIMITER // 
CREATE FUNCTION actualizaMalaltia(newCodiMalaltia INT, newNomMalaltia VARCHAR(20),
    newCausaBaixa CHAR(2), newTractament VARCHAR(30), newDuracio INT) RETURNS BOOL

BEGIN 
    UPDATE hospital_grup06.MALALTIES SET 
        nomMalaltia = newNomMalaltia,
        causaBaixa = newCausaBaixa,
        tractament = newTractament, 
        duracio = newDuracio
    WHERE codiMalaltia = newCodiMalaltia;
    RETURN TRUE;
END;
// 
DELIMITER ;

GRANT EXECUTE ON FUNCTION hospital_grup06.actualizaMalaltia TO usuario_hospital_grup06;

# DADES INICIALS
INSERT INTO METGES (nomMetge, cognom1Metge, cognom2Metge, numSegSoc, nifMetge, telefon, ciutat, codiPostal, carrer, numero, planta, porta, numEmpleat, salariMensual, codiCompte)VALUES 
	("Gregory","House","Smith","396120465841","48181321R", "937564023","Barcelona",8001,"Plaça Catalunya",78,"Quarta","Segona",11,3000,"ES35"),
	("Margarita","Robles","Rojas","257896321461","78941245R","654789123","Terrassa",8226,"Pablo Picaso",45,"Segona","Primera",12,2500,"ES97"),
	("Jose","Segura","Iglesias","157894523691","78523458D","678521478","Terrassa",8221,"Plaça Doctor Robert",5,"S/N","S/N",13,2000,"ES52");


INSERT INTO PACIENTS (nifPacient, codiHistorial, numSegSoc, nomPacient, cognom1Pacient, cognom2Pacient, telefon, ciutat, codiPostal, carrer, numero, planta, porta) VALUES
	("45990250W", 1, "281234567840","Juan","Martín","Pascual","666555444","Terrassa",8226,"Pablo Picaso",45,"Segona","Primera"),
	("45872365S", 2, "012345678939","Maria","Garcia","Luque","961247845","Barcelona",8001,"Plaça Catalunya",78,"Quarta","Segona");


INSERT INTO MALALTIES (codiMalaltia, nomMalaltia, causaBaixa, tractament, duracio) VALUES
	(1,"Resfriado","No","Jarabe para la tos",5),
	(2,"Conjuntivitis","Si","Colirio",7),
	(3,"Laringitis","No","Antibiotico",10),
	(4,"Test","Si","TestTrac",1);

INSERT INTO VISITES (fecha, codiVisita, codiMalaltia, dniMetge, dniPacient) VALUES 
	('2007/12/03 10:15:30', 1, 1, "48181321R", "45990250W"),
	("2015-05-15 10:15:30", 2, 3, "78523458D", "45990250W"),
	("2018-02-23 10:15:30", 3, 2, "78941245R", "45872365S"),
	("2012-10-02 10:15:30", 4, 1, "48181321R", "45872365S"),
	("2019-02-07 10:24:30", 5, 1, "78941245R", "45990250W");