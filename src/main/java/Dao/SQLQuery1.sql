create database USERLOGIN 
go 
use USERLOGIN 
go
create table account(
IdUser int  IDENTITY(1,1) primary key , 
UserName varchar(20) unique NOT NULL , 
PasswordUser varchar(20) , 
GmailUser varchar(50 ) ,
 AvatarUser VARBINARY(MAX) 
) 
select * from account
INSERT INTO account (UserName, PasswordUser, GmailUser)
VALUES ('vien', '1234567', '@gmail.com')