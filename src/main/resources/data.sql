--delete from category;
delete from Item;
delete from User;
delete from Address;
delete from orders;

insert into User(id,name,phone,email) values(201,'Anuj','9799301038','maxanuj24@gmail.com');
insert into User(id,name,phone,email) values(202,'Yash','8696912345','yashtongia1996@gmail.com');
insert into User(id,name,phone,email) values(203,'Chits','7891004007','chitrakshsharma007@gmail.com');


--insert into Category(id,name) values(10001,'Fruits');
--insert into Category(id,name) values(10002,'Vegetable');
--insert into Category(id,name) values(10003,'Grocery');

insert into Item(id,name,categoryname,price,quantity) values(50001,'Apple',1,100,5);
insert into Item(id,name,categoryname,price,quantity) values(50002,'Banana',5,20,4);
insert into Item(id,name,categoryname,price,quantity) values(50003,'Sugar',4,40,3);

--insert into orders(id,uid,status,addrid,user_id) values(801,202,'Delivered',401,202);
--insert into orders(id,uid,status,addrid,user_id) values(802,203,'Payment Pending',403,203);
--insert into orders(id,uid,status,addrid,user_id) values(803,201,'Just ordered',402,201);

insert into Address(id,name,type,flat,city,pin,contact,uid,user_id) values(401,'Yash - Office','Office','4thFloor','Pune','411057','8695977461',201,201);
insert into Address(id,name,type,flat,city,pin,contact,uid,user_id) values(402,'Chits - Office','Office','4thFloor','Pune','411057','7891004007',201,201);
