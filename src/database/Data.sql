 CREATE TABLE RENTEMP
    (EMP_NO       CHAR(5)      NOT NULL,
     FNAME        VARCHAR(15)  NOT NULL,
     LNAME        VARCHAR(15)  NOT NULL,
     ADDRESS      VARCHAR(30),
     SEX          CHAR,
     SALARY       DECIMAL(10,2),
     EMP_TYPE     VARCHAR(15)  NOT NULL,
     DNO          INT          NOT NULL,
     NIC          CHAR(10)     NOT NULL,
    PRIMARY KEY(EMP_NO));


 INSERT INTO RENTEMP VALUES('0001','UMAIR','RAMZAN','22,KANDY ROAD,AKURANA','M','30000','DRIVER',2,'954321568V');
 INSERT INTO RENTEMP VALUES('0002','ROSHEN','PERERA','31,NAWALA,MATALE','M','28000','RECEPTIONIST',1,'896452347V');
 INSERT INTO RENTEMP VALUES('0003','RUKSHAN','NIZAR','113,COURTS ROAD,MAWANELLA','M','55000','ADMIN',3,'950312335V');
 INSERT INTO RENTEMP VALUES('0004','KAUSHALYA','SENEVIRATHNA','54/2,DS ROAD,KANDY','F','53000','ADMIN',3,'910294432V');
 INSERT INTO RENTEMP VALUES('0005','CHAMODA','GUNAWARDANA','73,MAIN STREET,KANDY','F','33000','DRIVER',2,'863421765V');
 INSERT INTO RENTEMP VALUES('0006','SHAMRAN','ZAHIR','234,7TH AVENUE,AKURANA','M','30000','RECEPTIONIST',1,'934675216V');
 INSERT INTO RENTEMP VALUES('0007','ANGELO','SILVA','314,COLOMBO ROAD,KANDY','M','32000','RECEPTIONIST',1,'826954301V');
 INSERT INTO RENTEMP VALUES('0008','PAVITHRA','RANASINGHE','45,COLOMBO ROAD,KANDY','F','44000','ADMIN',3,'875430854V');
 INSERT INTO RENTEMP VALUES('0009','RAMEESH','KHAN','24,KATUGASTOTA,KANDY','M','32500','DRIVER',2,'908763286V');


CREATE TABLE CARS
(CAR_ID           CHAR(4)     NOT NULL,
 MODEL            VARCHAR(15) NOT NULL,
 COLOUR           VARCHAR(10),
 SEATS            INT         NOT NULL,
 AVAILABILITY     VARCHAR(15)     NOT NULL,
 PRIMARY KEY(CAR_ID));


INSERT INTO CARS VALUES('0100','MARUTI ALTO K10','BLACK',4,'NOT AVAILABLE');
INSERT INTO CARS VALUES('0101','RENAULT KWID','WHITE',4,'AVAILABLE');
INSERT INTO CARS VALUES('0102','HYUNDAI EON','RED',4,'NOT AVAILABLE');
INSERT INTO CARS VALUES('0103','MARUTI ALTO K10','WHITE',4,'AVAILABLE');
INSERT INTO CARS VALUES('0104','TATA NANO','WHITE',3,'NOT AVAILABLE');
INSERT INTO CARS VALUES('0105','SUZUKI SWIFT','WHITE',4,'AVAILABLE');
INSERT INTO CARS VALUES('0106','HONDA HYBRID','BLUE',4,'AVAILABLE');
INSERT INTO CARS VALUES('0107','TOYOTA PREMIO','PURPLE',4,'NOT AVAILABLE');
INSERT INTO CARS VALUES('0108','SUZUKI WAGON R','WHITE',5,'AVAILABLE');



 CREATE TABLE USERS
   (USER_NO     CHAR(5)     NOT NULL,
    USERNAME    VARCHAR(15) NOT NULL,
    PASSWORD    VARCHAR(15) NOT NULL,
    PRIMARY KEY(USERNAME));

 ALTER TABLE USERS


INSERT INTO USERS VALUES('0001','UMAIR123','UMAIR123456');
INSERT INTO USERS VALUES('0002','ROSHPERERA','ROSHPPP1');
INSERT INTO USERS VALUES('0003','RKN566','RUKSHANNIZAR');
INSERT INTO USERS VALUES('0004','KAUSHI23','125KAUSHALYA');
INSERT INTO USERS VALUES('0005','IMCHAMODA','CHAMODA6789');
INSERT INTO USERS VALUES('0006','SHAM4321','SHAMRANZAHIR98');
INSERT INTO USERS VALUES('0007','ANGELO543','ANGSIL51');
INSERT INTO USERS VALUES('0008','PAVI008','1678PAVI');
INSERT INTO USERS VALUES('0009','RAMIYA','KHAN006');


CREATE TABLE Hired(
  ClientName VARCHAR(20),
  ContactNo  VARCHAR(20),
  HireDate    DATE NOT NULL ,
  ReturnDate  DATE NOT NULL ,
  DriverID    VARCHAR(5),
  CarID       VARCHAR(5) NOT NULL ,
  PRIMARY KEY (CarID,HireDate),
  FOREIGN KEY (DriverID) REFERENCES rentemp(EMP_NO),
  FOREIGN KEY (CarID) REFERENCES cars(CAR_ID)
);
