create database AppJava_Maven

go 
use AppJava_Maven 
go

CREATE TABLE UserAccount
(

UserId INT IDENTITY(1,1) PRIMARY KEY , 
UserName VARCHAR(20) UNIQUE NOT NULL , 
UserPassword VARCHAR(20) , 
UserGmail VARCHAR(50 ) ,
UserAvatar VARBINARY(MAX) 

) 



CREATE TABLE Products
(

ProductId INT IDENTITY(1,1) PRIMARY KEY , 
ProductName VARCHAR(30) UNIQUE not null , 
ProductSize int,
ProductQuantity INT  ,
ProductPrice money ,
ProductColor VARCHAR(15) ,
ProductImage VARBINARY(MAX) 

)



CREATE TABLE Bill
(
    BillId INT IDENTITY(1,1) PRIMARY KEY,
    UserId INT NOT NULL,
    ProductId INT NOT NULL,
    BillDate DATETIME DEFAULT GETDATE(),
    Size FLOAT,
    Quantity INT,
    Price MONEY,
    TotalAmount AS (Quantity * Price) PERSISTED,
    
    CONSTRAINT FK_Bill_User FOREIGN KEY (UserId) REFERENCES UserAccount(UserId),
    CONSTRAINT FK_Bill_Product FOREIGN KEY (ProductId) REFERENCES Products(ProductId)
)






CREATE TABLE BillDetail 
(

BillDetailId INT IDENTITY(1,1) PRIMARY KEY ,
BillId INT FOREIGN KEY REFERENCES Bill(BillId),
ProductId INT FOREIGN KEY REFERENCES Products(ProductId), 
Quantity INT, 
Price FLOAT

)



select * from UserAccount

select * from Products 

select * from Bill

select * from BillDetail



INSERT INTO UserAccount (UserName, UserPassword, UserGmail)
VALUES ('admin', 'admin', 'admin@gmail.com')

INSERT INTO Products (ProductName, ProductPrice, ProductQuantity , ProductColor, ProductSize)
VALUES ('Nike', 5000, 400 , 'Green', 40)

INSERT INTO Bill (UserId , ProductId , BillDate , Size , Quantity  , Price )
VALUES (22, 9, '2025-05-01' , 40, 12 , 5000)

UPDATE Products SET ProductImage =  WHERE ProductName = Adias


UPDATE Products
SET ProductImage = (
    SELECT * FROM OPENROWSET(BULK N'D:\Image\BackgroundVideoDesktop.mp4', SINGLE_BLOB) AS ImageData
)


update UserAccount set UserName='vien' ,UserPassword='12345678' ,UserGmail='@gmail.com' where UserName ='vien'

delete from Bill
delete from UserAccount
delete From UserAccount 



