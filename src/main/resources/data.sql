delete from category;
delete from Item;

insert into Category(id,name) values(10001,'Fruits');
insert into Category(id,name) values(10002,'Vegetable');
insert into Category(id,name) values(10003,'Grocery');

insert into Item(id,name,categoryname,price,quantity,category_id) values(50001,'Apple','Fruits',100,5,10001);
insert into Item(id,name,categoryname,price,quantity,category_id) values(50002,'Banana','Fruits',20,4,10001);
insert into Item(id,name,categoryname,price,quantity,category_id) values(50003,'Sugar','Grocery',40,3,10003);