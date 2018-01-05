SELECT D.DriverID,CONCAT(E.FNAME,' ',E.LNAME) AS Name,D.LicenceNo,D.Contact,D.Availability
FROM Driver D, rentemp E
WHERE D.DriverID=E.EMP_NO;

SELECT r.CarID AS CarID,c.MODEL AS Model,r.ClientID AS ClientID,CONCAT(cl.FName,' ',cl.LName) AS Name, r.approval as Approval
FROM cars c,rented_out r,client cl
WHERE c.CAR_ID=r.CarID AND r.ClientID=cl.NIC;

UPDATE `rented_out`
SET `approval` = 'Approved'
WHERE `rented_out`.`ClientID` = '952413147v' AND `rented_out`.`RentDate` = '2018-01-11' AND `rented_out`.`CarID` = '0103';

INSERT INTO `cars` (`CAR_ID`, `MODEL`, `COLOUR`, `SEATS`, `AVAILABILITY`, `MILEAGE`, `BasicPrice`, `PlateNo`)
VALUES ('023', 'XYZ', 'Blue', '5', 'Available', '23256', '50000', 'BV 12345');

INSERT INTO `licence` (`No`, `Expire`, `Type`, `Owner`, `CopyFilePath`) VALUES ('5664656', '2018-01-27', 'DriverTable', 'D001', 'path2');


INSERT INTO `client` (`NIC`, `FName`, `LName`, `Address`, `Contact`)
 VALUES ('952413452v', 'First Name', 'Last Name', '194/4,Bulugohattenna Road Akurana.', '0777655458');


INSERT INTO `rentemp` (`EMP_NO`, `FNAME`, `LNAME`, `ADDRESS`, `SEX`, `EMP_TYPE`, `DNO`, `NIC`)
VALUES ('R100', 'MyNmae', 'yourName', '194/fjsafhkj,gsdag', 'M', 'RECEPTIONIST', '', '45689755');

INSERT INTO `driver` (`DriverID`, `LicenceNo`, `Contact`, `Availability`)
 VALUES ('D455', '456785', '077769854', 'Available');

UPDATE `cars` SET `AVAILABILITY` = 'AVAILABLE' WHERE `cars`.`CAR_ID` = '0100';