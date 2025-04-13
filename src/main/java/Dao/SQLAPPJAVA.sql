create database AppJava_Maven
go 
use AppJava_Maven 
go
create table UserAccount

(
UserId int  IDENTITY(1,1) primary key , 
UserName varchar(20) unique NOT NULL , 
UserPassword varchar(20) , 
UserGmail varchar(50 ) ,
UserAvatar VARBINARY(MAX) 
) 

Create table Products

(
ProductId int IDENTITY(1,1) primary key , 
ProductName varchar(30) unique not null , 
ProductPrice float ,
ProductQuantity int  ,
ProductColor varchar(15) ,
ProductImage VARBINARY(MAX) 
)




select * from UserAccount

select * from Products 


INSERT INTO UserAccount (UserName, UserPassword, UserGmail)
VALUES ('admin', '1234567', 'admin@gmail.com')

INSERT INTO Products (ProductName, ProductPrice, ProductQuantity , ProductColor)
VALUES ('vien', 5000, 400 , 'Green')


update UserAccount set UserName='vien' ,UserPassword='12345678' ,UserGmail='@gmail.com' where UserName ='vien'


delete From UserAccount where UserName='admin'