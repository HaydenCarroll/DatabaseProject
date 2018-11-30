USE master;
GO
IF  DB_ID('ToolShop') IS NOT NULL
    DROP DATABASE ToolShop;
GO
CREATE DATABASE ToolShop;
GO
USE ToolShop;
-- create the tables for the database
CREATE TABLE Categories (
  CategoryID        INT            PRIMARY KEY   IDENTITY,
  CategoryName      VARCHAR(255)   NOT NULL      UNIQUE
);
CREATE TABLE Products (
  ProductID         INT            PRIMARY KEY   IDENTITY,
  CategoryID        INT            REFERENCES Categories (CategoryID), 
  ProductCode       VARCHAR(10)    NOT NULL      UNIQUE,
  ProductName       VARCHAR(255)   NOT NULL,
  Description       TEXT           NOT NULL,
  ListPrice         MONEY          NOT NULL,
 );
CREATE TABLE Customers (
  CustomerID           INT            PRIMARY KEY   IDENTITY,
  EmailAddress         VARCHAR(255)   NOT NULL      UNIQUE,
  Password             VARCHAR(60)    NOT NULL,
  FirstName            VARCHAR(60)    NOT NULL,
  LastName             VARCHAR(60)    NOT NULL,
  ShippingAddressID    INT                          DEFAULT NULL,
  BillingAddressID     INT                          DEFAULT NULL
);
CREATE TABLE Addresses (
  AddressID          INT            PRIMARY KEY   IDENTITY,
  CustomerID         INT            REFERENCES Customers (CustomerID),
  Line1              VARCHAR(60)    NOT NULL,
  Line2              VARCHAR(60)                  DEFAULT NULL,
  City               VARCHAR(40)    NOT NULL,
  State              VARCHAR(2)     NOT NULL,
  ZipCode            VARCHAR(10)    NOT NULL,
  Phone              VARCHAR(12)    NOT NULL,
  Disabled           INT            NOT NULL      DEFAULT 0
);
CREATE TABLE Orders (
  OrderID           INT            PRIMARY KEY  IDENTITY,
  CustomerID        INT            REFERENCES Customers (CustomerID),
  OrderDate         DATETIME       NOT NULL,
  ShipAmount        MONEY          NOT NULL,
  TaxAmount         MONEY          NOT NULL,
  ShipDate          DATETIME                    DEFAULT NULL,
  ShipAddressID     INT            NOT NULL,
  CardType          VARCHAR(50)    NOT NULL,
  CardNumber        CHAR(16)       NOT NULL,
  CardExpires       CHAR(7)        NOT NULL,
  BillingAddressID  INT            NOT NULL    
);
CREATE TABLE OrderItems (
  ItemID             INT            PRIMARY KEY  IDENTITY,
  OrderID            INT            REFERENCES Orders (OrderID),
  ProductID          INT            REFERENCES Products (ProductID),
  ItemPrice          MONEY  NOT NULL,
  Quantity           INT            NOT NULL    
);
CREATE TABLE Employees(
 EmpID    INT    PRIMARY KEY IDENTITY,
 FName    VARCHAR(50)  NOT NULL,
 LName    VARCHAR(50)  NOT NULL,
 Pay    MONEY   NOT NULL,
 Postion   TEXT   NULL,
 HireDate   DATE   NOT NULL,
 PhoneNum   CHAR(16)  NULL,
 AddressLine  VARCHAR(50)  NOT NULL,
 City    VARCHAR(50)  NOT NULL,
 State    VARCHAR(50)  NOT NULL
 );
 CREATE TABLE Store(
 StoreID   INT    PRIMARY KEY IDENTITY,
 StoreAddress  VARCHAR(60) NOT NULL,
 NumberOfEmployees INT    NULL,
 Manager   VARCHAR(50)
 );
-- Insert data into the tables
SET IDENTITY_INSERT Categories ON;
INSERT INTO Categories (CategoryID, CategoryName) VALUES
(1, 'Hammers'),
(2, 'Screwdrivers'),
(3, 'Blades'), 
(4, 'Wrenches');

SET IDENTITY_INSERT Categories OFF;
SET IDENTITY_INSERT Products ON;
INSERT INTO Products (ProductID, CategoryID, ProductCode, ProductName, Description, ListPrice) VALUES
(1, 1, 'sham', 'Small Hammer', '5 oz, rubber, wodden handle', '14.00'),
(2, 2, 'multiTool', 'MulitHeadScredriver', 'Has both phills and flat head attachments in 3 varying sizes', '37.00'),
(3, 3, 'exblade', '13 inch OutDoor Blade', 'Stanless Stell, 6 inch handle, doube edge', '55.00'),
(4, 2, '7scr', '7 inch Phills Screwdriver', '7 inch long Screwdriver, stanless stell, plastic handle', '10.99'),
(5, 1, 'Lham', 'Large Hammer', 'Stanless steal head and handle, handle covered in ruber', '16.99'),
(6, 3, 'inblade', '3 inch Boxer Cutter', 'Stanless steal, plastic handle, green color', '5.99'),
(7, 4, 'metricwren', '7 Head Mteric Wrench', '7 head wrench, in varying size all in metric', '25.99');
SET IDENTITY_INSERT Products OFF;
SET IDENTITY_INSERT Customers ON;
INSERT INTO Customers (CustomerID, EmailAddress, Password, FirstName, LastName, ShippingAddressID, BillingAddressID) VALUES
(1, 'allan.sherwood@yahoo.com', 'c44321e51ec184a2f739318639cec426de774451', 'Allan', 'Sherwood', 1, 2),
(2, 'barryz@gmail.com', 'd9e03c0b34c57d034edda004ec8bae5d53667e36', 'Barry', 'Zimmer', 3, 3),
(3, 'christineb@solarone.com', '13ef4f968693bda97a898ece497da087b182808e', 'Christine', 'Brown', 4, 4),
(4, 'david.goldstein@hotmail.com', '2a367cbb171d78d293f40fd7d1defb31e3fb1728', 'David', 'Goldstein', 5, 6),
(5, 'erinv@gmail.com', '2e203dd22e39e3a8930e7641fe074fec2b18b102', 'Erin', 'Valentino', 7, 7),
(6, 'frankwilson@sbcglobal.net', 'b13773cfee62f832cacb618b257feec972f30b13', 'Frank Lee', 'Wilson', 8, 8),
(7, 'gary_hernandez@yahoo.com', 'e931eea39d638c0324c0065c40e2c0acc91ceca9', 'Gary', 'Hernandez', 9, 10);
SET IDENTITY_INSERT Customers OFF;
SET IDENTITY_INSERT Addresses ON;
INSERT INTO Addresses (AddressID, CustomerID, Line1, Line2, City, State, ZipCode, Phone, Disabled) VALUES
(1, 1, '100 East Ridgewood Ave.', '', 'Paramus', 'NJ', '07652', '201-653-4472', 0),
(2, 1, '21 Rosewood Rd.', '', 'Woodcliff Lake', 'NJ', '07677', '201-653-4472', 0),
(3, 2, '16285 Wendell St.', '', 'Omaha', 'NE', '68135', '402-896-2576', 0),
(4, 3, '19270 NW Cornell Rd.', '', 'Beaverton', 'OR', '97006', '503-654-1291', 0),
(5, 4, '186 Vermont St.', 'Apt. 2', 'San Francisco', 'CA', '94110', '415-292-6651', 0),
(6, 4, '1374 46th Ave.', '', 'San Francisco', 'CA', '94129', '415-292-6651', 0),
(7, 5, '6982 Palm Ave.', '', 'Fresno', 'CA', '93711', '559-431-2398', 0),
(8, 6, '23 Mountain View St.', '', 'Denver', 'CO', '80208', '303-912-3852', 0),
(9, 7, '7361 N. 41st St.', 'Apt. B', 'New York', 'NY', '10012', '212-335-2093', 0),
(10, 7, '3829 Broadway Ave.', 'Suite 2', 'New York', 'NY', '10012', '212-239-1208', 0);
/*(11, 8, '2381 Buena Vista St.', '', 'Los Angeles', 'CA', '90023', '213-772-5033', 0),
(12, 8, '291 W. Hollywood Blvd.', '', 'Los Angeles', 'CA', '90024', '213-391-2938', 0);*/
SET IDENTITY_INSERT Addresses OFF;
SET IDENTITY_INSERT Orders ON;
INSERT INTO Orders (OrderID, CustomerID, OrderDate, ShipAmount, TaxAmount, ShipDate, ShipAddressID, CardType, CardNumber, CardExpires, BillingAddressID) VALUES
(1, 1, '2018-03-28 09:40:28.000', 25.00, 1.72, '2018-03-31 09:41:11.000', 1, 'Visa', '4111111111111111', '04/2018', 2), 
(2, 2, '2016-03-28 11:23:20.000', 35.35, 2.18, '2016-03-31 11:24:03.000', 3, 'Visa', '4012888888881881', '08/2020', 3), 
(3, 1, '2016-03-29 09:44:58.000', 60.98, 1.38, '2016-04-01 09:45:41.000', 1, 'Visa', '4111111111111111', '06/2020', 2), 
(4, 3, '2016-03-30 15:22:31.000', 7.00, 1.72, '2016-04-02 15:23:14.000', 4, 'American Express', '3782822463100005', '02/2017', 4), 
(5, 4, '2016-03-31 05:43:11.000', 8.65, 1.72, '2016-04-03 05:43:54.000', 5, 'Visa', '4111111111111111', '09/2019', 6), 
(6, 5, '2016-03-31 18:37:22.000', 18.98, 1.22, '2016-04-03 18:38:05.000', 7, 'Discover', '6011111111111117', '04/2020', 7), 
(7, 6, '2016-04-01 23:11:12.000', 16.36, 00.35, '2016-04-04 23:11:55.000', 8, 'MasterCard', '5555555555554444', '12/2018', 8), 
(8, 7, '2016-04-02 11:26:38.000', 6.36, 00.35, '2016-04-05 11:27:21.000', 9, 'Visa', '4012888888881881', '04/2017', 10), 
(9, 4, '2016-04-03 12:22:31.000', 38.63, 2.18, '2016-04-06 12:23:14.000', 5, 'Visa', '4111111111111111', '01/2020', 6);

SET IDENTITY_INSERT Orders OFF;
SET IDENTITY_INSERT OrderItems ON;
INSERT INTO OrderItems (ItemID, OrderID, ProductID, ItemPrice, Quantity) VALUES
(1, 1, 2, '37.00', 1),
(2, 2, 6, '5.99', 1),
(3, 3, 1, '14.00', 1),
(4, 3, 7, '25.99', 1),
(5, 4, 4, '21.98', 2);
SET IDENTITY_INSERT OrderItems OFF;
SET IDENTITY_INSERT Employees ON
INSERT INTO Employees (EmpID, FName, LName, Pay, Postion, HireDate, PhoneNum, AddressLine, City, State) VALUES
(1,  'Allan',  'Sherwood','7.25', 'sales person', '1992-08-11', '(405)250-5905','639 Main St', 'Savannah', 'Ga' ),
(2,  'Barry', 'Zimmer','7.25','sales person','1994-08-02','(509)209-5853','735 Crawford Dr', 'Savannah', 'Ga'),

/************ the errors are from here down**********/

(3,  'Christine', 'Brown','8.25','sales person','1995-05-06','(252)344-7179','747 Leonis Blvd', 'Savannah', 'Ga'),
(4,  'David', 'Goldstein','8.25','sales person','1996-11-06','(609)600-8184','3 Mcauley Dr','Savannah', 'Ga'),
(5,  'Erin', 'Valentino','7.25','maintenance','1998-05-25','(201)472-6528','4 Iwaena St', 'Savannah', 'Ga'),
(6,  'Frank Lee', 'Wilson','8.25','sales person','1998-09-29','(343)267-3269','70099 E North Ave', 'Savannah', 'Ga'),
(7, 'Gary', 'Hernandez','15.75','manager','1999-10-03','(570)713-7807','2026 N Plankinton Ave #3', 'Savannah', 'Ga'),
(8, 'Heather', 'Esway','7.25','sales person','2004-02-27','(573)586-3406','64 Lakeview Ave', 'Jessup', 'Ga'),
(9,  'James', 'Butt','7.25','sales person','2009-05-04','(620)669-3105','772 W River Dr', 'Jessup', 'Ga'),
(10, 'Josephine', 'Darakjy','7.25','sales person','2009-07-18','(502)350-5231', '70295 Pioneer Ct','Jessup', 'Ga'),
(11, 'Art', 'Venere','8.25','sales person','2009-09-29','(414)964-9721', '64 Newman Springs Rd E','Jessup', 'Ga'),
(12, 'Lenna', 'Paprocki','8.25','sales person','2010-03-08','(559)217-7720',  '3829 Ventura Blvd','Jessup', 'Ga'),
(13, 'Donette', 'Foller','7.25','maintenance','2016-12-17','(610)308-8322','64 Newman Springs Rd E','Jessup', 'Ga'),
(14, 'Simona', 'Morasca','15.75','manager','2018-09-03','(219)921-7971', '3732 Sherman Ave','Jessup', 'Ga');
SET IDENTITY_INSERT Employees OFF;
SET IDENTITY_INSERT Store ON
INSERT INTO Store ( StoreID, StoreAddress, NumberOfEmployees, Manager) VALUES
(1, '70 Euclid Ave #722 Savannah, Ga 11716', '8', 'Gary Hernandez'),
(2, '4 Kohler Memorial Dr Jessup, Ga 11230','7','Simona Morasca');
SET IDENTITY_INSERT Store OFF
