delete from category;
delete from Item;
delete from User;
delete from orders;
delete from Address;


insert into User(id,name,phone,email) values(201,'Anuj','9799301038','maxanuj24@gmail.com');
insert into User(id,name,phone,email) values(202,'Yash','8696912345','yashtongia1996@gmail.com');
insert into User(id,name,phone,email) values(203,'Chits','7891004007','chitrakshsharma007@gmail.com');


insert into Category(id,name) values(10001,'Fruits');
insert into Category(id,name) values(10002,'Vegetable');
insert into Category(id,name) values(10003,'Grocery');

insert into Item(id,name,categoryname,price,quantity,category_id) values(50001,'Apple','Fruits',100,5,10001);
insert into Item(id,name,categoryname,price,quantity,category_id) values(50002,'Banana','Fruits',20,4,10001);
insert into Item(id,name,categoryname,price,quantity,category_id) values(50003,'Sugar','Grocery',40,3,10003);

insert into orders(id,uid,status,user_id) values(801,202,'Delivered',202);
insert into orders(id,uid,status,user_id) values(802,203,'Payment Pending',203);
insert into orders(id,uid,status,user_id) values(803,201,'Just ordered',201);

insert into Address(id,name,type,flat,city,pin,contact,uid,user_id) values(401,'Yash - Office','Office','4thFloor','Pune','411057','8695977461',201,201);
