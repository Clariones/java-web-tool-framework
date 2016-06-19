drop database  if exists b2b;
create database b2b;
use b2b;

drop table  if exists buyer_company_data;
create table buyer_company_data (
	id	  	varchar(48) not null,
	name	  	varchar(40),
	price_list	  	varchar(40),
	rating	  	int,
	logo	  	varchar(48),
	owner	  	varchar(88),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into buyer_company_data values
('BC000001','Aaxis - 8420','price99008421','10','simple.jpg8423','philip@aaxischina.com','1'),
('BC000002','Aaxis - 8424','price99008425','10','simple.jpg8427','philip@aaxischina.com','1'),
('BC000003','Aaxis - 8428','price99008429','10','simple.jpg8431','philip@aaxischina.com','1'),
('BC000004','Aaxis - 8432','price99008433','10','simple.jpg8435','philip@aaxischina.com','1'),
('BC000005','Aaxis - 8436','price99008437','10','simple.jpg8439','philip@aaxischina.com','1'),
('BC000006','Aaxis - 8440','price99008441','10','simple.jpg8443','philip@aaxischina.com','1'),
('BC000007','Aaxis - 8444','price99008445','10','simple.jpg8447','philip@aaxischina.com','1'),
('BC000008','Aaxis - 8448','price99008449','10','simple.jpg8451','philip@aaxischina.com','1'),
('BC000009','Aaxis - 8452','price99008453','10','simple.jpg8455','philip@aaxischina.com','1'),
('BC000010','Aaxis - 8456','price99008457','10','simple.jpg8459','philip@aaxischina.com','1'),
('BC000011','Aaxis - 8460','price99008461','10','simple.jpg8463','philip@aaxischina.com','1'),
('BC000012','Aaxis - 8464','price99008465','10','simple.jpg8467','philip@aaxischina.com','1'),
('BC000013','Aaxis - 8468','price99008469','10','simple.jpg8471','philip@aaxischina.com','1'),
('BC000014','Aaxis - 8472','price99008473','10','simple.jpg8475','philip@aaxischina.com','1'),
('BC000015','Aaxis - 8476','price99008477','10','simple.jpg8479','philip@aaxischina.com','1'),
('BC000016','Aaxis - 8480','price99008481','10','simple.jpg8483','philip@aaxischina.com','1'),
('BC000017','Aaxis - 8484','price99008485','10','simple.jpg8487','philip@aaxischina.com','1'),
('BC000018','Aaxis - 8488','price99008489','10','simple.jpg8491','philip@aaxischina.com','1'),
('BC000019','Aaxis - 8492','price99008493','10','simple.jpg8495','philip@aaxischina.com','1'),
('BC000020','Aaxis - 8496','price99008497','10','simple.jpg8499','philip@aaxischina.com','1');
drop table  if exists seller_company_data;
create table seller_company_data (
	id	  	varchar(48) not null,
	name	  	varchar(48),
	owner	  	varchar(88),
	logo	  	varchar(48),
	contract_text	  	varchar(24),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into seller_company_data values
('SC000001','Snack Co. 8500','philip@aaxischina.com','simple.jpg8501','x.doc8502','1'),
('SC000002','Snack Co. 8503','philip@aaxischina.com','simple.jpg8504','x.doc8505','1'),
('SC000003','Snack Co. 8506','philip@aaxischina.com','simple.jpg8507','x.doc8508','1'),
('SC000004','Snack Co. 8509','philip@aaxischina.com','simple.jpg8510','x.doc8511','1'),
('SC000005','Snack Co. 8512','philip@aaxischina.com','simple.jpg8513','x.doc8514','1'),
('SC000006','Snack Co. 8515','philip@aaxischina.com','simple.jpg8516','x.doc8517','1'),
('SC000007','Snack Co. 8518','philip@aaxischina.com','simple.jpg8519','x.doc8520','1'),
('SC000008','Snack Co. 8521','philip@aaxischina.com','simple.jpg8522','x.doc8523','1'),
('SC000009','Snack Co. 8524','philip@aaxischina.com','simple.jpg8525','x.doc8526','1'),
('SC000010','Snack Co. 8527','philip@aaxischina.com','simple.jpg8528','x.doc8529','1'),
('SC000011','Snack Co. 8530','philip@aaxischina.com','simple.jpg8531','x.doc8532','1'),
('SC000012','Snack Co. 8533','philip@aaxischina.com','simple.jpg8534','x.doc8535','1'),
('SC000013','Snack Co. 8536','philip@aaxischina.com','simple.jpg8537','x.doc8538','1'),
('SC000014','Snack Co. 8539','philip@aaxischina.com','simple.jpg8540','x.doc8541','1'),
('SC000015','Snack Co. 8542','philip@aaxischina.com','simple.jpg8543','x.doc8544','1'),
('SC000016','Snack Co. 8545','philip@aaxischina.com','simple.jpg8546','x.doc8547','1'),
('SC000017','Snack Co. 8548','philip@aaxischina.com','simple.jpg8549','x.doc8550','1'),
('SC000018','Snack Co. 8551','philip@aaxischina.com','simple.jpg8552','x.doc8553','1'),
('SC000019','Snack Co. 8554','philip@aaxischina.com','simple.jpg8555','x.doc8556','1'),
('SC000020','Snack Co. 8557','philip@aaxischina.com','simple.jpg8558','x.doc8559','1');
drop table  if exists shipping_address_data;
create table shipping_address_data (
	id	  	varchar(48) not null,
	line1	  	varchar(104),
	line2	  	varchar(56),
	city	  	varchar(64),
	state	  	varchar(16),
	country	  	varchar(16),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into shipping_address_data values
('SA000001','1900 AVE OF THE STARTS - 8560','Suite 555 - 8561','Century City - 8562','VA','US8564','1'),
('SA000002','1900 AVE OF THE STARTS - 8565','Suite 555 - 8566','Century City - 8567','CA','US8569','1'),
('SA000003','1900 AVE OF THE STARTS - 8570','Suite 555 - 8571','Century City - 8572','LA','US8574','1'),
('SA000004','1900 AVE OF THE STARTS - 8575','Suite 555 - 8576','Century City - 8577','WA','US8579','1'),
('SA000005','1900 AVE OF THE STARTS - 8580','Suite 555 - 8581','Century City - 8582','PA','US8584','1'),
('SA000006','1900 AVE OF THE STARTS - 8585','Suite 555 - 8586','Century City - 8587','MA','US8589','1'),
('SA000007','1900 AVE OF THE STARTS - 8590','Suite 555 - 8591','Century City - 8592','VA','US8594','1'),
('SA000008','1900 AVE OF THE STARTS - 8595','Suite 555 - 8596','Century City - 8597','CA','US8599','1'),
('SA000009','1900 AVE OF THE STARTS - 8600','Suite 555 - 8601','Century City - 8602','LA','US8604','1'),
('SA000010','1900 AVE OF THE STARTS - 8605','Suite 555 - 8606','Century City - 8607','WA','US8609','1'),
('SA000011','1900 AVE OF THE STARTS - 8610','Suite 555 - 8611','Century City - 8612','PA','US8614','1'),
('SA000012','1900 AVE OF THE STARTS - 8615','Suite 555 - 8616','Century City - 8617','MA','US8619','1'),
('SA000013','1900 AVE OF THE STARTS - 8620','Suite 555 - 8621','Century City - 8622','VA','US8624','1'),
('SA000014','1900 AVE OF THE STARTS - 8625','Suite 555 - 8626','Century City - 8627','CA','US8629','1'),
('SA000015','1900 AVE OF THE STARTS - 8630','Suite 555 - 8631','Century City - 8632','LA','US8634','1'),
('SA000016','1900 AVE OF THE STARTS - 8635','Suite 555 - 8636','Century City - 8637','WA','US8639','1'),
('SA000017','1900 AVE OF THE STARTS - 8640','Suite 555 - 8641','Century City - 8642','PA','US8644','1'),
('SA000018','1900 AVE OF THE STARTS - 8645','Suite 555 - 8646','Century City - 8647','MA','US8649','1'),
('SA000019','1900 AVE OF THE STARTS - 8650','Suite 555 - 8651','Century City - 8652','VA','US8654','1'),
('SA000020','1900 AVE OF THE STARTS - 8655','Suite 555 - 8656','Century City - 8657','CA','US8659','1');
drop table  if exists billing_address_data;
create table billing_address_data (
	id	  	varchar(48) not null,
	company	  	varchar(48),
	line1	  	varchar(104),
	line2	  	varchar(56),
	city	  	varchar(64),
	state	  	varchar(16),
	country	  	varchar(16),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into billing_address_data values
('BA000001','BC000003','1900 AVE OF THE STARTS - 8660','Suite 555 - 8661','Century City - 8662','LA','US8664','1'),
('BA000002','BC000001','1900 AVE OF THE STARTS - 8665','Suite 555 - 8666','Century City - 8667','WA','US8669','1'),
('BA000003','BC000002','1900 AVE OF THE STARTS - 8670','Suite 555 - 8671','Century City - 8672','PA','US8674','1'),
('BA000004','BC000003','1900 AVE OF THE STARTS - 8675','Suite 555 - 8676','Century City - 8677','MA','US8679','1'),
('BA000005','BC000002','1900 AVE OF THE STARTS - 8680','Suite 555 - 8681','Century City - 8682','VA','US8684','1'),
('BA000006','BC000002','1900 AVE OF THE STARTS - 8685','Suite 555 - 8686','Century City - 8687','CA','US8689','1'),
('BA000007','BC000005','1900 AVE OF THE STARTS - 8690','Suite 555 - 8691','Century City - 8692','LA','US8694','1'),
('BA000008','BC000001','1900 AVE OF THE STARTS - 8695','Suite 555 - 8696','Century City - 8697','WA','US8699','1'),
('BA000009','BC000005','1900 AVE OF THE STARTS - 8700','Suite 555 - 8701','Century City - 8702','PA','US8704','1'),
('BA000010','BC000002','1900 AVE OF THE STARTS - 8705','Suite 555 - 8706','Century City - 8707','MA','US8709','1'),
('BA000011','BC000001','1900 AVE OF THE STARTS - 8710','Suite 555 - 8711','Century City - 8712','VA','US8714','1'),
('BA000012','BC000005','1900 AVE OF THE STARTS - 8715','Suite 555 - 8716','Century City - 8717','CA','US8719','1'),
('BA000013','BC000004','1900 AVE OF THE STARTS - 8720','Suite 555 - 8721','Century City - 8722','LA','US8724','1'),
('BA000014','BC000001','1900 AVE OF THE STARTS - 8725','Suite 555 - 8726','Century City - 8727','WA','US8729','1'),
('BA000015','BC000002','1900 AVE OF THE STARTS - 8730','Suite 555 - 8731','Century City - 8732','PA','US8734','1'),
('BA000016','BC000003','1900 AVE OF THE STARTS - 8735','Suite 555 - 8736','Century City - 8737','MA','US8739','1'),
('BA000017','BC000004','1900 AVE OF THE STARTS - 8740','Suite 555 - 8741','Century City - 8742','VA','US8744','1'),
('BA000018','BC000002','1900 AVE OF THE STARTS - 8745','Suite 555 - 8746','Century City - 8747','CA','US8749','1'),
('BA000019','BC000004','1900 AVE OF THE STARTS - 8750','Suite 555 - 8751','Century City - 8752','LA','US8754','1'),
('BA000020','BC000002','1900 AVE OF THE STARTS - 8755','Suite 555 - 8756','Century City - 8757','WA','US8759','1');
drop table  if exists employee_data;
create table employee_data (
	id	  	varchar(48) not null,
	name	  	varchar(32),
	company	  	varchar(48),
	email	  	varchar(88),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into employee_data values
('E000001','Philip8760','BC000003','philip@aaxischina.com','1'),
('E000002','Philip8761','BC000001','philip@aaxischina.com','1'),
('E000003','Philip8762','BC000004','philip@aaxischina.com','1'),
('E000004','Philip8763','BC000003','philip@aaxischina.com','1'),
('E000005','Philip8764','BC000001','philip@aaxischina.com','1'),
('E000006','Philip8765','BC000005','philip@aaxischina.com','1'),
('E000007','Philip8766','BC000004','philip@aaxischina.com','1'),
('E000008','Philip8767','BC000002','philip@aaxischina.com','1'),
('E000009','Philip8768','BC000001','philip@aaxischina.com','1'),
('E000010','Philip8769','BC000004','philip@aaxischina.com','1'),
('E000011','Philip8770','BC000004','philip@aaxischina.com','1'),
('E000012','Philip8771','BC000003','philip@aaxischina.com','1'),
('E000013','Philip8772','BC000002','philip@aaxischina.com','1'),
('E000014','Philip8773','BC000002','philip@aaxischina.com','1'),
('E000015','Philip8774','BC000001','philip@aaxischina.com','1'),
('E000016','Philip8775','BC000004','philip@aaxischina.com','1'),
('E000017','Philip8776','BC000003','philip@aaxischina.com','1'),
('E000018','Philip8777','BC000001','philip@aaxischina.com','1'),
('E000019','Philip8778','BC000005','philip@aaxischina.com','1'),
('E000020','Philip8779','BC000005','philip@aaxischina.com','1');
drop table  if exists role_data;
create table role_data (
	id	  	varchar(48) not null,
	role_name	  	varchar(32),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into role_data values
('R000001','manager8780','1'),
('R000002','manager8781','1'),
('R000003','manager8782','1'),
('R000004','manager8783','1'),
('R000005','manager8784','1'),
('R000006','manager8785','1'),
('R000007','manager8786','1'),
('R000008','manager8787','1'),
('R000009','manager8788','1'),
('R000010','manager8789','1'),
('R000011','manager8790','1'),
('R000012','manager8791','1'),
('R000013','manager8792','1'),
('R000014','manager8793','1'),
('R000015','manager8794','1'),
('R000016','manager8795','1'),
('R000017','manager8796','1'),
('R000018','manager8797','1'),
('R000019','manager8798','1'),
('R000020','manager8799','1');
drop table  if exists assignment_data;
create table assignment_data (
	id	  	varchar(48) not null,
	user	  	varchar(48),
	access	  	varchar(48),
	assigned_date	  	Date,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into assignment_data values
('A000001','E000005','A000005','2015-01-17','1'),
('A000002','E000002','A000003','2014-10-15','1'),
('A000003','E000002','A000005','2017-09-04','1'),
('A000004','E000005','A000004','2017-02-09','1'),
('A000005','E000002','A000003','2018-12-06','1'),
('A000006','E000005','A000004','2017-04-06','1'),
('A000007','E000005','A000002','2017-11-13','1'),
('A000008','E000004','A000002','2014-07-26','1'),
('A000009','E000002','A000004','2015-08-31','1'),
('A000010','E000005','A000004','2017-05-07','1'),
('A000011','E000001','A000001','2017-06-22','1'),
('A000012','E000001','A000002','2016-08-14','1'),
('A000013','E000003','A000001','2016-08-04','1'),
('A000014','E000001','A000005','2014-12-22','1'),
('A000015','E000002','A000005','2018-09-29','1'),
('A000016','E000004','A000001','2016-01-15','1'),
('A000017','E000004','A000003','2015-07-23','1'),
('A000018','E000003','A000005','2015-08-03','1'),
('A000019','E000002','A000005','2018-02-05','1'),
('A000020','E000004','A000002','2018-11-11','1');
drop table  if exists access_data;
create table access_data (
	id	  	varchar(48) not null,
	role_name	  	varchar(40),
	role	  	varchar(48),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into access_data values
('A000001','x manager8800','R000004','1'),
('A000002','x manager8801','R000004','1'),
('A000003','x manager8802','R000002','1'),
('A000004','x manager8803','R000003','1'),
('A000005','x manager8804','R000004','1'),
('A000006','x manager8805','R000003','1'),
('A000007','x manager8806','R000005','1'),
('A000008','x manager8807','R000002','1'),
('A000009','x manager8808','R000004','1'),
('A000010','x manager8809','R000001','1'),
('A000011','x manager8810','R000002','1'),
('A000012','x manager8811','R000003','1'),
('A000013','x manager8812','R000005','1'),
('A000014','x manager8813','R000001','1'),
('A000015','x manager8814','R000001','1'),
('A000016','x manager8815','R000004','1'),
('A000017','x manager8816','R000002','1'),
('A000018','x manager8817','R000004','1'),
('A000019','x manager8818','R000003','1'),
('A000020','x manager8819','R000002','1');
drop table  if exists order_data;
create table order_data (
	id	  	varchar(48) not null,
	buyer	  	varchar(48),
	seller	  	varchar(48),
	title	  	varchar(72),
	total_amount	  	numeric(6,2),
	type	  	varchar(32),
	mark_as_delete	  	int,
	confirmation	  	varchar(48),
	approval	  	varchar(48),
	processing	  	varchar(48),
	shipment	  	varchar(48),
	delivery	  	varchar(48),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into order_data values
('O000001','BC000005','SC000005','House Buiding - 8820','135.93667166179847','QUOTE','1','C000001','A000001','P000002','S000002','D000001','1'),
('O000002','BC000003','SC000001','House Buiding - 8822','277.7958664053504','ORDER','1','C000003','A000004','P000003','S000005','D000001','1'),
('O000003','BC000004','SC000003','House Buiding - 8824','283.9356245545752','INVOICE','1','C000001','A000004','P000003','S000005','D000003','1'),
('O000004','BC000001','SC000001','House Buiding - 8826','223.1842680315958','QUOTE','1','C000003','A000004','P000001','S000003','D000004','1'),
('O000005','BC000004','SC000003','House Buiding - 8828','201.0640486057134','ORDER','1','C000004','A000005','P000005','S000002','D000003','1'),
('O000006','BC000003','SC000002','House Buiding - 8830','211.76346844547066','INVOICE','1','C000005','A000005','P000003','S000002','D000005','1'),
('O000007','BC000004','SC000002','House Buiding - 8832','100.86444415353564','QUOTE','1','C000003','A000003','P000005','S000005','D000001','1'),
('O000008','BC000004','SC000002','House Buiding - 8834','248.8114792795328','ORDER','1','C000005','A000005','P000004','S000001','D000003','1'),
('O000009','BC000003','SC000005','House Buiding - 8836','200.21005850315578','INVOICE','1','C000001','A000003','P000004','S000004','D000005','1'),
('O000010','BC000005','SC000001','House Buiding - 8838','211.70146659210985','QUOTE','1','C000001','A000004','P000001','S000004','D000003','1'),
('O000011','BC000005','SC000005','House Buiding - 8840','85.1411534162602','ORDER','1','C000002','A000001','P000003','S000004','D000002','1'),
('O000012','BC000004','SC000003','House Buiding - 8842','108.38789519887862','INVOICE','1','C000003','A000005','P000002','S000005','D000003','1'),
('O000013','BC000004','SC000004','House Buiding - 8844','125.27094278001675','QUOTE','1','C000002','A000003','P000004','S000005','D000004','1'),
('O000014','BC000001','SC000002','House Buiding - 8846','203.08228826117036','ORDER','1','C000003','A000002','P000002','S000005','D000003','1'),
('O000015','BC000005','SC000005','House Buiding - 8848','273.12126994876337','INVOICE','1','C000005','A000004','P000004','S000001','D000005','1'),
('O000016','BC000002','SC000005','House Buiding - 8850','256.91873439311235','QUOTE','1','C000003','A000002','P000001','S000003','D000004','1'),
('O000017','BC000003','SC000003','House Buiding - 8852','9.387901463287136','ORDER','1','C000001','A000004','P000005','S000005','D000005','1'),
('O000018','BC000004','SC000003','House Buiding - 8854','140.20908176087752','INVOICE','1','C000005','A000003','P000004','S000003','D000004','1'),
('O000019','BC000004','SC000005','House Buiding - 8856','186.33556044288295','QUOTE','1','C000001','A000002','P000001','S000004','D000005','1'),
('O000020','BC000002','SC000004','House Buiding - 8858','161.44773623000665','ORDER','1','C000004','A000005','P000002','S000002','D000001','1');
drop table  if exists confirmation_data;
create table confirmation_data (
	id	  	varchar(48) not null,
	who	  	varchar(40),
	confirm_time	  	Date,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into confirmation_data values
('C000001','approver8860','2016-05-31','1'),
('C000002','approver8861','2013-10-12','1'),
('C000003','approver8862','2013-07-12','1'),
('C000004','approver8863','2017-06-02','1'),
('C000005','approver8864','2013-12-20','1'),
('C000006','approver8865','2015-03-20','1'),
('C000007','approver8866','2016-05-15','1'),
('C000008','approver8867','2015-04-20','1'),
('C000009','approver8868','2016-04-05','1'),
('C000010','approver8869','2017-10-05','1'),
('C000011','approver8870','2017-07-10','1'),
('C000012','approver8871','2013-09-25','1'),
('C000013','approver8872','2014-08-14','1'),
('C000014','approver8873','2015-10-25','1'),
('C000015','approver8874','2018-03-21','1'),
('C000016','approver8875','2014-09-26','1'),
('C000017','approver8876','2016-07-24','1'),
('C000018','approver8877','2017-03-11','1'),
('C000019','approver8878','2017-05-10','1'),
('C000020','approver8879','2016-09-09','1');
drop table  if exists shipment_data;
create table shipment_data (
	id	  	varchar(48) not null,
	who	  	varchar(32),
	shup_time	  	Date,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into shipment_data values
('S000001','carrier8880','2017-12-15','1'),
('S000002','carrier8881','2018-03-04','1'),
('S000003','carrier8882','2016-10-04','1'),
('S000004','carrier8883','2018-01-09','1'),
('S000005','carrier8884','2015-07-19','1'),
('S000006','carrier8885','2016-08-23','1'),
('S000007','carrier8886','2016-06-25','1'),
('S000008','carrier8887','2015-11-07','1'),
('S000009','carrier8888','2014-05-19','1'),
('S000010','carrier8889','2014-01-26','1'),
('S000011','carrier8890','2014-02-20','1'),
('S000012','carrier8891','2017-09-29','1'),
('S000013','carrier8892','2017-03-11','1'),
('S000014','carrier8893','2016-12-01','1'),
('S000015','carrier8894','2017-08-21','1'),
('S000016','carrier8895','2015-09-10','1'),
('S000017','carrier8896','2017-02-17','1'),
('S000018','carrier8897','2016-03-18','1'),
('S000019','carrier8898','2014-12-13','1'),
('S000020','carrier8899','2017-02-19','1');
drop table  if exists delivery_data;
create table delivery_data (
	id	  	varchar(48) not null,
	who	  	varchar(40),
	delivery_time	  	Date,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into delivery_data values
('D000001','deliverer8900','2015-08-03','1'),
('D000002','deliverer8901','2014-01-20','1'),
('D000003','deliverer8902','2017-07-07','1'),
('D000004','deliverer8903','2014-04-11','1'),
('D000005','deliverer8904','2014-01-01','1'),
('D000006','deliverer8905','2014-03-29','1'),
('D000007','deliverer8906','2016-03-15','1'),
('D000008','deliverer8907','2013-12-31','1'),
('D000009','deliverer8908','2016-10-21','1'),
('D000010','deliverer8909','2014-10-07','1'),
('D000011','deliverer8910','2014-05-09','1'),
('D000012','deliverer8911','2017-05-02','1'),
('D000013','deliverer8912','2017-05-30','1'),
('D000014','deliverer8913','2018-05-20','1'),
('D000015','deliverer8914','2017-07-13','1'),
('D000016','deliverer8915','2013-11-19','1'),
('D000017','deliverer8916','2015-05-25','1'),
('D000018','deliverer8917','2013-07-26','1'),
('D000019','deliverer8918','2018-04-30','1'),
('D000020','deliverer8919','2018-06-05','1');
drop table  if exists processing_data;
create table processing_data (
	id	  	varchar(48) not null,
	who	  	varchar(40),
	process_time	  	Date,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into processing_data values
('P000001','processor8920','2015-08-04','1'),
('P000002','processor8921','2016-09-24','1'),
('P000003','processor8922','2017-01-13','1'),
('P000004','processor8923','2013-12-05','1'),
('P000005','processor8924','2013-09-20','1'),
('P000006','processor8925','2018-03-22','1'),
('P000007','processor8926','2015-11-10','1'),
('P000008','processor8927','2017-01-18','1'),
('P000009','processor8928','2013-09-29','1'),
('P000010','processor8929','2018-04-21','1'),
('P000011','processor8930','2014-08-03','1'),
('P000012','processor8931','2014-10-11','1'),
('P000013','processor8932','2013-09-25','1'),
('P000014','processor8933','2016-04-28','1'),
('P000015','processor8934','2015-02-16','1'),
('P000016','processor8935','2017-10-30','1'),
('P000017','processor8936','2015-05-28','1'),
('P000018','processor8937','2015-05-28','1'),
('P000019','processor8938','2015-07-20','1'),
('P000020','processor8939','2014-06-01','1');
drop table  if exists approval_data;
create table approval_data (
	id	  	varchar(48) not null,
	who	  	varchar(40),
	approve_time	  	Date,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into approval_data values
('A000001','approver8940','2017-01-05','1'),
('A000002','approver8941','2017-01-28','1'),
('A000003','approver8942','2016-07-14','1'),
('A000004','approver8943','2015-04-01','1'),
('A000005','approver8944','2015-05-16','1'),
('A000006','approver8945','2014-12-11','1'),
('A000007','approver8946','2014-02-21','1'),
('A000008','approver8947','2013-11-30','1'),
('A000009','approver8948','2015-01-21','1'),
('A000010','approver8949','2013-08-31','1'),
('A000011','approver8950','2017-11-13','1'),
('A000012','approver8951','2014-06-18','1'),
('A000013','approver8952','2016-12-08','1'),
('A000014','approver8953','2014-09-14','1'),
('A000015','approver8954','2016-12-06','1'),
('A000016','approver8955','2016-05-07','1'),
('A000017','approver8956','2018-02-19','1'),
('A000018','approver8957','2017-09-12','1'),
('A000019','approver8958','2015-04-30','1'),
('A000020','approver8959','2015-03-21','1');
drop table  if exists line_item_data;
create table line_item_data (
	id	  	varchar(48) not null,
	biz_order	  	varchar(48),
	sku_id	  	varchar(16),
	sku_name	  	varchar(40),
	amount	  	double,
	quantity	  	int,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into line_item_data values
('LI000001','O000002','SKU8960','iPhone - 8961','$23.978962','4','1'),
('LI000002','O000001','SKU8963','iPhone - 8964','$23.978965','5','1'),
('LI000003','O000002','SKU8966','iPhone - 8967','$23.978968','10','1'),
('LI000004','O000001','SKU8969','iPhone - 8970','$23.978971','4','1'),
('LI000005','O000003','SKU8972','iPhone - 8973','$23.978974','5','1'),
('LI000006','O000004','SKU8975','iPhone - 8976','$23.978977','8','1'),
('LI000007','O000003','SKU8978','iPhone - 8979','$23.978980','3','1'),
('LI000008','O000001','SKU8981','iPhone - 8982','$23.978983','9','1'),
('LI000009','O000003','SKU8984','iPhone - 8985','$23.978986','5','1'),
('LI000010','O000001','SKU8987','iPhone - 8988','$23.978989','7','1'),
('LI000011','O000005','SKU8990','iPhone - 8991','$23.978992','9','1'),
('LI000012','O000005','SKU8993','iPhone - 8994','$23.978995','10','1'),
('LI000013','O000005','SKU8996','iPhone - 8997','$23.978998','1','1'),
('LI000014','O000002','SKU8999','iPhone - 9000','$23.979001','2','1'),
('LI000015','O000004','SKU9002','iPhone - 9003','$23.979004','3','1'),
('LI000016','O000005','SKU9005','iPhone - 9006','$23.979007','9','1'),
('LI000017','O000005','SKU9008','iPhone - 9009','$23.979010','8','1'),
('LI000018','O000003','SKU9011','iPhone - 9012','$23.979013','6','1'),
('LI000019','O000004','SKU9014','iPhone - 9015','$23.979016','8','1'),
('LI000020','O000004','SKU9017','iPhone - 9018','$23.979019','2','1');
drop table  if exists shipping_group_data;
create table shipping_group_data (
	id	  	varchar(48) not null,
	name	  	varchar(104),
	biz_order	  	varchar(48),
	address	  	varchar(48),
	amount	  	numeric(4,2),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into shipping_group_data values
('SG000001','shipping to this address9020','O000004','SA000002','1.0070995185056615','1'),
('SG000002','shipping to this address9021','O000004','SA000004','0.9703124530428007','1'),
('SG000003','shipping to this address9022','O000004','SA000002','4.060650204601876','1'),
('SG000004','shipping to this address9023','O000001','SA000003','5.147078711787284','1'),
('SG000005','shipping to this address9024','O000003','SA000004','4.233301564960888','1'),
('SG000006','shipping to this address9025','O000001','SA000002','4.120247314183758','1'),
('SG000007','shipping to this address9026','O000004','SA000005','3.784138851493388','1'),
('SG000008','shipping to this address9027','O000003','SA000003','4.1794076542847485','1'),
('SG000009','shipping to this address9028','O000005','SA000002','3.835834891433714','1'),
('SG000010','shipping to this address9029','O000004','SA000004','1.629720123715847','1'),
('SG000011','shipping to this address9030','O000003','SA000002','4.55763255310564','1'),
('SG000012','shipping to this address9031','O000001','SA000002','4.413917078934503','1'),
('SG000013','shipping to this address9032','O000002','SA000005','5.088185347778237','1'),
('SG000014','shipping to this address9033','O000003','SA000001','3.1755152954292853','1'),
('SG000015','shipping to this address9034','O000001','SA000001','4.854000888047758','1'),
('SG000016','shipping to this address9035','O000001','SA000004','0.7949031155138006','1'),
('SG000017','shipping to this address9036','O000002','SA000005','4.02874358737893','1'),
('SG000018','shipping to this address9037','O000001','SA000004','0.7131394632419532','1'),
('SG000019','shipping to this address9038','O000003','SA000004','5.7180846725929255','1'),
('SG000020','shipping to this address9039','O000005','SA000002','4.440794419956251','1');
drop table  if exists payment_group_data;
create table payment_group_data (
	id	  	varchar(48) not null,
	name	  	varchar(80),
	biz_order	  	varchar(48),
	card_number	  	varchar(72),
	billing_address	  	varchar(48),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into payment_group_data values
('PG000001','visa card ending - 9040','O000003','4111 1111 1111 - 9041','BA000003','1'),
('PG000002','visa card ending - 9042','O000002','4111 1111 1111 - 9043','BA000001','1'),
('PG000003','visa card ending - 9044','O000005','4111 1111 1111 - 9045','BA000005','1'),
('PG000004','visa card ending - 9046','O000005','4111 1111 1111 - 9047','BA000005','1'),
('PG000005','visa card ending - 9048','O000003','4111 1111 1111 - 9049','BA000004','1'),
('PG000006','visa card ending - 9050','O000002','4111 1111 1111 - 9051','BA000001','1'),
('PG000007','visa card ending - 9052','O000002','4111 1111 1111 - 9053','BA000004','1'),
('PG000008','visa card ending - 9054','O000004','4111 1111 1111 - 9055','BA000002','1'),
('PG000009','visa card ending - 9056','O000002','4111 1111 1111 - 9057','BA000001','1'),
('PG000010','visa card ending - 9058','O000003','4111 1111 1111 - 9059','BA000005','1'),
('PG000011','visa card ending - 9060','O000003','4111 1111 1111 - 9061','BA000004','1'),
('PG000012','visa card ending - 9062','O000005','4111 1111 1111 - 9063','BA000003','1'),
('PG000013','visa card ending - 9064','O000004','4111 1111 1111 - 9065','BA000004','1'),
('PG000014','visa card ending - 9066','O000003','4111 1111 1111 - 9067','BA000003','1'),
('PG000015','visa card ending - 9068','O000003','4111 1111 1111 - 9069','BA000004','1'),
('PG000016','visa card ending - 9070','O000004','4111 1111 1111 - 9071','BA000003','1'),
('PG000017','visa card ending - 9072','O000002','4111 1111 1111 - 9073','BA000005','1'),
('PG000018','visa card ending - 9074','O000002','4111 1111 1111 - 9075','BA000002','1'),
('PG000019','visa card ending - 9076','O000003','4111 1111 1111 - 9077','BA000005','1'),
('PG000020','visa card ending - 9078','O000002','4111 1111 1111 - 9079','BA000002','1');
drop table  if exists cust_svc_rep_data;
create table cust_svc_rep_data (
	id	  	varchar(48) not null,
	email	  	varchar(88),
	role	  	varchar(48),
	company	  	varchar(48),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into cust_svc_rep_data values
('CSR000001','philip_chang@174.com','R000004','SC000003','1'),
('CSR000002','philip_chang@174.com','R000005','SC000001','1'),
('CSR000003','philip_chang@174.com','R000001','SC000003','1'),
('CSR000004','philip_chang@174.com','R000003','SC000002','1'),
('CSR000005','philip_chang@174.com','R000003','SC000003','1'),
('CSR000006','philip_chang@174.com','R000002','SC000005','1'),
('CSR000007','philip_chang@174.com','R000005','SC000001','1'),
('CSR000008','philip_chang@174.com','R000005','SC000002','1'),
('CSR000009','philip_chang@174.com','R000002','SC000002','1'),
('CSR000010','philip_chang@174.com','R000005','SC000002','1'),
('CSR000011','philip_chang@174.com','R000003','SC000001','1'),
('CSR000012','philip_chang@174.com','R000003','SC000002','1'),
('CSR000013','philip_chang@174.com','R000001','SC000004','1'),
('CSR000014','philip_chang@174.com','R000005','SC000003','1'),
('CSR000015','philip_chang@174.com','R000004','SC000002','1'),
('CSR000016','philip_chang@174.com','R000004','SC000001','1'),
('CSR000017','philip_chang@174.com','R000003','SC000001','1'),
('CSR000018','philip_chang@174.com','R000001','SC000001','1'),
('CSR000019','philip_chang@174.com','R000003','SC000005','1'),
('CSR000020','philip_chang@174.com','R000003','SC000004','1');
drop table  if exists action_data;
create table action_data (
	id	  	varchar(48) not null,
	name	  	varchar(24),
	internal_name	  	varchar(24),
	bo	  	varchar(48),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into action_data values
('A000001','view9080','load9081','O000002','1'),
('A000002','view9082','load9083','O000001','1'),
('A000003','view9084','load9085','O000004','1'),
('A000004','view9086','load9087','O000004','1'),
('A000005','view9088','load9089','O000002','1'),
('A000006','view9090','load9091','O000004','1'),
('A000007','view9092','load9093','O000003','1'),
('A000008','view9094','load9095','O000005','1'),
('A000009','view9096','load9097','O000002','1'),
('A000010','view9098','load9099','O000004','1'),
('A000011','view9100','load9101','O000001','1'),
('A000012','view9102','load9103','O000005','1'),
('A000013','view9104','load9105','O000004','1'),
('A000014','view9106','load9107','O000002','1'),
('A000015','view9108','load9109','O000005','1'),
('A000016','view9110','load9111','O000004','1'),
('A000017','view9112','load9113','O000005','1'),
('A000018','view9114','load9115','O000001','1'),
('A000019','view9116','load9117','O000003','1'),
('A000020','view9118','load9119','O000001','1');



create unique index idx_buyer_company_version on buyer_company_data(id, version);

create unique index idx_seller_company_version on seller_company_data(id, version);

create unique index idx_shipping_address_version on shipping_address_data(id, version);

create unique index idx_billing_address_version on billing_address_data(id, version);

create index idx_billing_address_company on billing_address_data(company);
alter table billing_address_data add constraint fk_billing_address_company 
	foreign key(company) references buyer_company_data(id) on delete cascade on update cascade;
create unique index idx_employee_version on employee_data(id, version);

create index idx_employee_company on employee_data(company);
alter table employee_data add constraint fk_employee_company 
	foreign key(company) references buyer_company_data(id) on delete cascade on update cascade;
create unique index idx_role_version on role_data(id, version);

create unique index idx_assignment_version on assignment_data(id, version);

create index idx_assignment_user on assignment_data(user);
alter table assignment_data add constraint fk_assignment_user 
	foreign key(user) references employee_data(id) on delete cascade on update cascade;
create index idx_assignment_access on assignment_data(access);
alter table assignment_data add constraint fk_assignment_access 
	foreign key(access) references access_data(id) on delete cascade on update cascade;
create unique index idx_access_version on access_data(id, version);

create index idx_access_role on access_data(role);
alter table access_data add constraint fk_access_role 
	foreign key(role) references role_data(id) on delete cascade on update cascade;
create unique index idx_order_version on order_data(id, version);

create index idx_order_buyer on order_data(buyer);
alter table order_data add constraint fk_order_buyer 
	foreign key(buyer) references buyer_company_data(id) on delete cascade on update cascade;
create index idx_order_seller on order_data(seller);
alter table order_data add constraint fk_order_seller 
	foreign key(seller) references seller_company_data(id) on delete cascade on update cascade;
create index idx_order_confirmation on order_data(confirmation);
alter table order_data add constraint fk_order_confirmation 
	foreign key(confirmation) references confirmation_data(id) on delete cascade on update cascade;
create index idx_order_approval on order_data(approval);
alter table order_data add constraint fk_order_approval 
	foreign key(approval) references approval_data(id) on delete cascade on update cascade;
create index idx_order_processing on order_data(processing);
alter table order_data add constraint fk_order_processing 
	foreign key(processing) references processing_data(id) on delete cascade on update cascade;
create index idx_order_shipment on order_data(shipment);
alter table order_data add constraint fk_order_shipment 
	foreign key(shipment) references shipment_data(id) on delete cascade on update cascade;
create index idx_order_delivery on order_data(delivery);
alter table order_data add constraint fk_order_delivery 
	foreign key(delivery) references delivery_data(id) on delete cascade on update cascade;
create unique index idx_confirmation_version on confirmation_data(id, version);

create unique index idx_shipment_version on shipment_data(id, version);

create unique index idx_delivery_version on delivery_data(id, version);

create unique index idx_processing_version on processing_data(id, version);

create unique index idx_approval_version on approval_data(id, version);

create unique index idx_line_item_version on line_item_data(id, version);

create index idx_line_item_biz_order on line_item_data(biz_order);
alter table line_item_data add constraint fk_line_item_biz_order 
	foreign key(biz_order) references order_data(id) on delete cascade on update cascade;
create unique index idx_shipping_group_version on shipping_group_data(id, version);

create index idx_shipping_group_biz_order on shipping_group_data(biz_order);
alter table shipping_group_data add constraint fk_shipping_group_biz_order 
	foreign key(biz_order) references order_data(id) on delete cascade on update cascade;
create index idx_shipping_group_address on shipping_group_data(address);
alter table shipping_group_data add constraint fk_shipping_group_address 
	foreign key(address) references shipping_address_data(id) on delete cascade on update cascade;
create unique index idx_payment_group_version on payment_group_data(id, version);

create index idx_payment_group_biz_order on payment_group_data(biz_order);
alter table payment_group_data add constraint fk_payment_group_biz_order 
	foreign key(biz_order) references order_data(id) on delete cascade on update cascade;
create index idx_payment_group_billing_address on payment_group_data(billing_address);
alter table payment_group_data add constraint fk_payment_group_billing_address 
	foreign key(billing_address) references billing_address_data(id) on delete cascade on update cascade;
create unique index idx_cust_svc_rep_version on cust_svc_rep_data(id, version);

create index idx_cust_svc_rep_role on cust_svc_rep_data(role);
alter table cust_svc_rep_data add constraint fk_cust_svc_rep_role 
	foreign key(role) references role_data(id) on delete cascade on update cascade;
create index idx_cust_svc_rep_company on cust_svc_rep_data(company);
alter table cust_svc_rep_data add constraint fk_cust_svc_rep_company 
	foreign key(company) references seller_company_data(id) on delete cascade on update cascade;
create unique index idx_action_version on action_data(id, version);

create index idx_action_bo on action_data(bo);
alter table action_data add constraint fk_action_bo 
	foreign key(bo) references order_data(id) on delete cascade on update cascade;




#---------------------------end database---------------------------------





