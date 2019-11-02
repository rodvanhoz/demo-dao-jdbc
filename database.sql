CREATE TABLE department (
  Id int IDENTITY(1, 1) PRIMARY KEY,
  Name varchar(60) DEFAULT NULL,
)

CREATE TABLE seller (
  Id int IDENTITY(1, 1) PRIMARY KEY,
  Name varchar(60) NOT NULL,
  Email varchar(100) NOT NULL,
  BirthDate datetime NOT NULL,
  BaseSalary decimal(16, 2) NOT NULL,
  DepartmentId int NOT NULL,
  FOREIGN KEY (DepartmentId) REFERENCES department (id)
)

INSERT INTO department (Name) VALUES 
  ('Computers'),
  ('Electronics'),
  ('Fashion'),
  ('Books')

INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES 
  ('Bob Brown','bob@gmail.com','1998-21-04 00:00:00',1000,1),
  ('Maria Green','maria@gmail.com','1979-31-12 00:00:00',3500,2),
  ('Alex Grey','alex@gmail.com','1988-15-01 00:00:00',2200,1),
  ('Martha Red','martha@gmail.com','1993-30-11 00:00:00',3000,4),
  ('Donald Blue','donald@gmail.com','2000-09-01 00:00:00',4000,3),
  ('Alex Pink','bob@gmail.com','1997-04-03 00:00:00',3000,2)
  
  
  
  SELECT *
    FROM seller 