 TestProject installation guide
1. Open command prompt and cd to folder , where you want to locate project.
2. git clone https://github.com/Furaw/Task.git
3. Run your IDE (preferable IntelliJIDEA) and resolve dependencies.
4. Set up mysql.
5.Create new connection
Connection Name = AndrushaConnection
Connection Method = Standart (TCP/IP)
Hostname = 127.0.0.1
Port = 3306
Username = root
Password = 1223
6.Connect via it.
7.Run mysql query 
DROP DATABASE IF EXISTS market;
create database market;
use market;
 
CREATE TABLE Categories (
    CategoryID INT auto_increment,
    key(CategoryId),
    CategoryName CHAR(20) PRIMARY KEY
);

CREATE TABLE InventoryList
(
    ProductID INT auto_increment,
    key(ProductID),
     ProductName VARCHAR(50),
   CategoryName char(254),
  
     FOREIGN KEY (CategoryName) REFERENCES Categories(CategoryName)
);
INSERT INTO  Categories (CategoryName)
values ("meat");

INSERT INTO  Categories (CategoryName)
values ("fish");

INSERT INTO  Categories (CategoryName)
values ("bread");
 INSERT INTO InventoryList (CategoryName,ProductName)
 values ("meat","Pork");
 
 INSERT INTO InventoryList (CategoryName,ProductName)
 values ("meat","Beef");
 
 INSERT INTO InventoryList (CategoryName,ProductName)
 values ("meat","Goat");
 
 INSERT INTO InventoryList (CategoryName,ProductName)
 values ("meat","Chicken ");
 INSERT INTO InventoryList (CategoryName,ProductName)
 values ("fish","Salmon");
 INSERT INTO InventoryList (CategoryName,ProductName)
 values ("fish","Carp");
 INSERT INTO InventoryList (CategoryName,ProductName)
 values ("fish","Catfish");
  INSERT INTO InventoryList (CategoryName,ProductName)
 values ("fish","Goldfish");
 INSERT INTO InventoryList (CategoryName,ProductName)
 values ("bread","Focaccia");
 INSERT INTO InventoryList (CategoryName,ProductName)
 values ("bread","Multigrain");
 INSERT INTO InventoryList (CategoryName,ProductName)
 values ("bread","Brioche");
 INSERT INTO InventoryList (CategoryName,ProductName)
 values ("bread"," Whole-Wheat");
select * from  InventoryList ;
8.Move back to Idea and run Application class.
9. Go to browser and paste this urls
http://localhost:8080/      			Default url
http://localhost:8080/greeting			Greeting Page
http://localhost:8080/category			Check all categories
http://localhost:8080/inventory  		Check first 10 inventories
http://localhost:8080/inventories		Check all inventories
http://localhost:8080/v2/api-docs		Swagger docs
http://localhost:8080/swagger-ui.html		SwaggerUI