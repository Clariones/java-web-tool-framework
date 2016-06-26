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
('BC000001','Aaxis - 20160','price990020161','10','simple.jpg20163','philip@aaxischina.com','1'),
('BC000002','Aaxis - 20164','price990020165','10','simple.jpg20167','philip@aaxischina.com','1'),
('BC000003','Aaxis - 20168','price990020169','10','simple.jpg20171','philip@aaxischina.com','1'),
('BC000004','Aaxis - 20172','price990020173','10','simple.jpg20175','philip@aaxischina.com','1'),
('BC000005','Aaxis - 20176','price990020177','10','simple.jpg20179','philip@aaxischina.com','1'),
('BC000006','Aaxis - 20180','price990020181','10','simple.jpg20183','philip@aaxischina.com','1'),
('BC000007','Aaxis - 20184','price990020185','10','simple.jpg20187','philip@aaxischina.com','1'),
('BC000008','Aaxis - 20188','price990020189','10','simple.jpg20191','philip@aaxischina.com','1'),
('BC000009','Aaxis - 20192','price990020193','10','simple.jpg20195','philip@aaxischina.com','1'),
('BC000010','Aaxis - 20196','price990020197','10','simple.jpg20199','philip@aaxischina.com','1'),
('BC000011','Aaxis - 20200','price990020201','10','simple.jpg20203','philip@aaxischina.com','1'),
('BC000012','Aaxis - 20204','price990020205','10','simple.jpg20207','philip@aaxischina.com','1'),
('BC000013','Aaxis - 20208','price990020209','10','simple.jpg20211','philip@aaxischina.com','1'),
('BC000014','Aaxis - 20212','price990020213','10','simple.jpg20215','philip@aaxischina.com','1'),
('BC000015','Aaxis - 20216','price990020217','10','simple.jpg20219','philip@aaxischina.com','1'),
('BC000016','Aaxis - 20220','price990020221','10','simple.jpg20223','philip@aaxischina.com','1'),
('BC000017','Aaxis - 20224','price990020225','10','simple.jpg20227','philip@aaxischina.com','1'),
('BC000018','Aaxis - 20228','price990020229','10','simple.jpg20231','philip@aaxischina.com','1'),
('BC000019','Aaxis - 20232','price990020233','10','simple.jpg20235','philip@aaxischina.com','1'),
('BC000020','Aaxis - 20236','price990020237','10','simple.jpg20239','philip@aaxischina.com','1');
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
('SC000001','Snack Co. 20240','philip@aaxischina.com','simple.jpg20241','x.doc20242','1'),
('SC000002','Snack Co. 20243','philip@aaxischina.com','simple.jpg20244','x.doc20245','1'),
('SC000003','Snack Co. 20246','philip@aaxischina.com','simple.jpg20247','x.doc20248','1'),
('SC000004','Snack Co. 20249','philip@aaxischina.com','simple.jpg20250','x.doc20251','1'),
('SC000005','Snack Co. 20252','philip@aaxischina.com','simple.jpg20253','x.doc20254','1'),
('SC000006','Snack Co. 20255','philip@aaxischina.com','simple.jpg20256','x.doc20257','1'),
('SC000007','Snack Co. 20258','philip@aaxischina.com','simple.jpg20259','x.doc20260','1'),
('SC000008','Snack Co. 20261','philip@aaxischina.com','simple.jpg20262','x.doc20263','1'),
('SC000009','Snack Co. 20264','philip@aaxischina.com','simple.jpg20265','x.doc20266','1'),
('SC000010','Snack Co. 20267','philip@aaxischina.com','simple.jpg20268','x.doc20269','1'),
('SC000011','Snack Co. 20270','philip@aaxischina.com','simple.jpg20271','x.doc20272','1'),
('SC000012','Snack Co. 20273','philip@aaxischina.com','simple.jpg20274','x.doc20275','1'),
('SC000013','Snack Co. 20276','philip@aaxischina.com','simple.jpg20277','x.doc20278','1'),
('SC000014','Snack Co. 20279','philip@aaxischina.com','simple.jpg20280','x.doc20281','1'),
('SC000015','Snack Co. 20282','philip@aaxischina.com','simple.jpg20283','x.doc20284','1'),
('SC000016','Snack Co. 20285','philip@aaxischina.com','simple.jpg20286','x.doc20287','1'),
('SC000017','Snack Co. 20288','philip@aaxischina.com','simple.jpg20289','x.doc20290','1'),
('SC000018','Snack Co. 20291','philip@aaxischina.com','simple.jpg20292','x.doc20293','1'),
('SC000019','Snack Co. 20294','philip@aaxischina.com','simple.jpg20295','x.doc20296','1'),
('SC000020','Snack Co. 20297','philip@aaxischina.com','simple.jpg20298','x.doc20299','1');
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
('SA000001','1900 AVE OF THE STARTS - 20300','Suite 555 - 20301','Century City - 20302','LA','US20304','1'),
('SA000002','1900 AVE OF THE STARTS - 20305','Suite 555 - 20306','Century City - 20307','WA','US20309','1'),
('SA000003','1900 AVE OF THE STARTS - 20310','Suite 555 - 20311','Century City - 20312','PA','US20314','1'),
('SA000004','1900 AVE OF THE STARTS - 20315','Suite 555 - 20316','Century City - 20317','MA','US20319','1'),
('SA000005','1900 AVE OF THE STARTS - 20320','Suite 555 - 20321','Century City - 20322','VA','US20324','1'),
('SA000006','1900 AVE OF THE STARTS - 20325','Suite 555 - 20326','Century City - 20327','CA','US20329','1'),
('SA000007','1900 AVE OF THE STARTS - 20330','Suite 555 - 20331','Century City - 20332','LA','US20334','1'),
('SA000008','1900 AVE OF THE STARTS - 20335','Suite 555 - 20336','Century City - 20337','WA','US20339','1'),
('SA000009','1900 AVE OF THE STARTS - 20340','Suite 555 - 20341','Century City - 20342','PA','US20344','1'),
('SA000010','1900 AVE OF THE STARTS - 20345','Suite 555 - 20346','Century City - 20347','MA','US20349','1'),
('SA000011','1900 AVE OF THE STARTS - 20350','Suite 555 - 20351','Century City - 20352','VA','US20354','1'),
('SA000012','1900 AVE OF THE STARTS - 20355','Suite 555 - 20356','Century City - 20357','CA','US20359','1'),
('SA000013','1900 AVE OF THE STARTS - 20360','Suite 555 - 20361','Century City - 20362','LA','US20364','1'),
('SA000014','1900 AVE OF THE STARTS - 20365','Suite 555 - 20366','Century City - 20367','WA','US20369','1'),
('SA000015','1900 AVE OF THE STARTS - 20370','Suite 555 - 20371','Century City - 20372','PA','US20374','1'),
('SA000016','1900 AVE OF THE STARTS - 20375','Suite 555 - 20376','Century City - 20377','MA','US20379','1'),
('SA000017','1900 AVE OF THE STARTS - 20380','Suite 555 - 20381','Century City - 20382','VA','US20384','1'),
('SA000018','1900 AVE OF THE STARTS - 20385','Suite 555 - 20386','Century City - 20387','CA','US20389','1'),
('SA000019','1900 AVE OF THE STARTS - 20390','Suite 555 - 20391','Century City - 20392','LA','US20394','1'),
('SA000020','1900 AVE OF THE STARTS - 20395','Suite 555 - 20396','Century City - 20397','WA','US20399','1');
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
('BA000001','BC000004','1900 AVE OF THE STARTS - 20400','Suite 555 - 20401','Century City - 20402','PA','US20404','1'),
('BA000002','BC000002','1900 AVE OF THE STARTS - 20405','Suite 555 - 20406','Century City - 20407','MA','US20409','1'),
('BA000003','BC000003','1900 AVE OF THE STARTS - 20410','Suite 555 - 20411','Century City - 20412','VA','US20414','1'),
('BA000004','BC000005','1900 AVE OF THE STARTS - 20415','Suite 555 - 20416','Century City - 20417','CA','US20419','1'),
('BA000005','BC000005','1900 AVE OF THE STARTS - 20420','Suite 555 - 20421','Century City - 20422','LA','US20424','1'),
('BA000006','BC000001','1900 AVE OF THE STARTS - 20425','Suite 555 - 20426','Century City - 20427','WA','US20429','1'),
('BA000007','BC000003','1900 AVE OF THE STARTS - 20430','Suite 555 - 20431','Century City - 20432','PA','US20434','1'),
('BA000008','BC000004','1900 AVE OF THE STARTS - 20435','Suite 555 - 20436','Century City - 20437','MA','US20439','1'),
('BA000009','BC000001','1900 AVE OF THE STARTS - 20440','Suite 555 - 20441','Century City - 20442','VA','US20444','1'),
('BA000010','BC000001','1900 AVE OF THE STARTS - 20445','Suite 555 - 20446','Century City - 20447','CA','US20449','1'),
('BA000011','BC000003','1900 AVE OF THE STARTS - 20450','Suite 555 - 20451','Century City - 20452','LA','US20454','1'),
('BA000012','BC000001','1900 AVE OF THE STARTS - 20455','Suite 555 - 20456','Century City - 20457','WA','US20459','1'),
('BA000013','BC000001','1900 AVE OF THE STARTS - 20460','Suite 555 - 20461','Century City - 20462','PA','US20464','1'),
('BA000014','BC000004','1900 AVE OF THE STARTS - 20465','Suite 555 - 20466','Century City - 20467','MA','US20469','1'),
('BA000015','BC000003','1900 AVE OF THE STARTS - 20470','Suite 555 - 20471','Century City - 20472','VA','US20474','1'),
('BA000016','BC000003','1900 AVE OF THE STARTS - 20475','Suite 555 - 20476','Century City - 20477','CA','US20479','1'),
('BA000017','BC000004','1900 AVE OF THE STARTS - 20480','Suite 555 - 20481','Century City - 20482','LA','US20484','1'),
('BA000018','BC000004','1900 AVE OF THE STARTS - 20485','Suite 555 - 20486','Century City - 20487','WA','US20489','1'),
('BA000019','BC000003','1900 AVE OF THE STARTS - 20490','Suite 555 - 20491','Century City - 20492','PA','US20494','1'),
('BA000020','BC000003','1900 AVE OF THE STARTS - 20495','Suite 555 - 20496','Century City - 20497','MA','US20499','1');
drop table  if exists employee_data;
create table employee_data (
	id	  	varchar(48) not null,
	name	  	varchar(32),
	company	  	varchar(48),
	email	  	varchar(88),
	passwd	  	varchar(32),
	cell_phone	  	varchar(48),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into employee_data values
('E000001','Philip20500','BC000003','philip@aaxischina.com','*******20501','1387878665520502','1'),
('E000002','Philip20503','BC000003','philip@aaxischina.com','*******20504','1387878665520505','1'),
('E000003','Philip20506','BC000001','philip@aaxischina.com','*******20507','1387878665520508','1'),
('E000004','Philip20509','BC000004','philip@aaxischina.com','*******20510','1387878665520511','1'),
('E000005','Philip20512','BC000001','philip@aaxischina.com','*******20513','1387878665520514','1'),
('E000006','Philip20515','BC000002','philip@aaxischina.com','*******20516','1387878665520517','1'),
('E000007','Philip20518','BC000003','philip@aaxischina.com','*******20519','1387878665520520','1'),
('E000008','Philip20521','BC000002','philip@aaxischina.com','*******20522','1387878665520523','1'),
('E000009','Philip20524','BC000005','philip@aaxischina.com','*******20525','1387878665520526','1'),
('E000010','Philip20527','BC000001','philip@aaxischina.com','*******20528','1387878665520529','1'),
('E000011','Philip20530','BC000003','philip@aaxischina.com','*******20531','1387878665520532','1'),
('E000012','Philip20533','BC000004','philip@aaxischina.com','*******20534','1387878665520535','1'),
('E000013','Philip20536','BC000005','philip@aaxischina.com','*******20537','1387878665520538','1'),
('E000014','Philip20539','BC000004','philip@aaxischina.com','*******20540','1387878665520541','1'),
('E000015','Philip20542','BC000001','philip@aaxischina.com','*******20543','1387878665520544','1'),
('E000016','Philip20545','BC000002','philip@aaxischina.com','*******20546','1387878665520547','1'),
('E000017','Philip20548','BC000005','philip@aaxischina.com','*******20549','1387878665520550','1'),
('E000018','Philip20551','BC000005','philip@aaxischina.com','*******20552','1387878665520553','1'),
('E000019','Philip20554','BC000004','philip@aaxischina.com','*******20555','1387878665520556','1'),
('E000020','Philip20557','BC000003','philip@aaxischina.com','*******20558','1387878665520559','1');
drop table  if exists role_data;
create table role_data (
	id	  	varchar(48) not null,
	role_name	  	varchar(32),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into role_data values
('R000001','manager20560','1'),
('R000002','manager20561','1'),
('R000003','manager20562','1'),
('R000004','manager20563','1'),
('R000005','manager20564','1'),
('R000006','manager20565','1'),
('R000007','manager20566','1'),
('R000008','manager20567','1'),
('R000009','manager20568','1'),
('R000010','manager20569','1'),
('R000011','manager20570','1'),
('R000012','manager20571','1'),
('R000013','manager20572','1'),
('R000014','manager20573','1'),
('R000015','manager20574','1'),
('R000016','manager20575','1'),
('R000017','manager20576','1'),
('R000018','manager20577','1'),
('R000019','manager20578','1'),
('R000020','manager20579','1');
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
('A000001','E000005','A000003','2015-07-11','1'),
('A000002','E000004','A000002','2016-02-14','1'),
('A000003','E000005','A000003','2018-09-10','1'),
('A000004','E000001','A000002','2016-01-09','1'),
('A000005','E000005','A000001','2015-03-22','1'),
('A000006','E000005','A000004','2018-06-07','1'),
('A000007','E000003','A000001','2016-04-28','1'),
('A000008','E000005','A000003','2014-04-11','1'),
('A000009','E000002','A000002','2014-01-10','1'),
('A000010','E000001','A000002','2016-06-12','1'),
('A000011','E000002','A000003','2017-09-27','1'),
('A000012','E000001','A000004','2017-04-23','1'),
('A000013','E000003','A000005','2016-07-19','1'),
('A000014','E000001','A000005','2017-11-25','1'),
('A000015','E000004','A000003','2016-04-04','1'),
('A000016','E000005','A000002','2016-07-28','1'),
('A000017','E000004','A000004','2014-01-11','1'),
('A000018','E000004','A000005','2014-05-17','1'),
('A000019','E000004','A000005','2018-01-29','1'),
('A000020','E000001','A000002','2015-02-12','1');
drop table  if exists access_data;
create table access_data (
	id	  	varchar(48) not null,
	role_name	  	varchar(40),
	role	  	varchar(48),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into access_data values
('A000001','x manager20580','R000004','1'),
('A000002','x manager20581','R000003','1'),
('A000003','x manager20582','R000001','1'),
('A000004','x manager20583','R000001','1'),
('A000005','x manager20584','R000002','1'),
('A000006','x manager20585','R000005','1'),
('A000007','x manager20586','R000001','1'),
('A000008','x manager20587','R000002','1'),
('A000009','x manager20588','R000004','1'),
('A000010','x manager20589','R000001','1'),
('A000011','x manager20590','R000002','1'),
('A000012','x manager20591','R000001','1'),
('A000013','x manager20592','R000003','1'),
('A000014','x manager20593','R000001','1'),
('A000015','x manager20594','R000004','1'),
('A000016','x manager20595','R000002','1'),
('A000017','x manager20596','R000001','1'),
('A000018','x manager20597','R000005','1'),
('A000019','x manager20598','R000003','1'),
('A000020','x manager20599','R000004','1');
drop table  if exists order_data;
create table order_data (
	id	  	varchar(48) not null,
	buyer	  	varchar(48),
	seller	  	varchar(48),
	title	  	varchar(72),
	total_amount	  	numeric(13,2),
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
('O000001','BC000003','SC000003','House Buiding - 20600','21577281.86','ORDER','1','C000002','A000002','P000002','S000002','D000002','1'),
('O000002','BC000002','SC000005','House Buiding - 20602','496555223.72','INVOICE','1','C000001','A000003','P000003','S000004','D000004','1'),
('O000003','BC000001','SC000001','House Buiding - 20604','2232330840.09','QUOTE','1','C000005','A000002','P000004','S000001','D000004','1'),
('O000004','BC000005','SC000005','House Buiding - 20606','1310336091.18','ORDER','1','C000004','A000003','P000001','S000001','D000001','1'),
('O000005','BC000001','SC000005','House Buiding - 20608','2457090108.99','INVOICE','1','C000005','A000005','P000004','S000005','D000001','1'),
('O000006','BC000004','SC000002','House Buiding - 20610','1024581135.29','QUOTE','1','C000004','A000004','P000001','S000002','D000001','1'),
('O000007','BC000004','SC000001','House Buiding - 20612','920660904.77','ORDER','1','C000002','A000001','P000004','S000002','D000004','1'),
('O000008','BC000003','SC000004','House Buiding - 20614','696481847.59','INVOICE','1','C000001','A000001','P000001','S000003','D000002','1'),
('O000009','BC000002','SC000001','House Buiding - 20616','2248009969.04','QUOTE','1','C000002','A000003','P000005','S000002','D000002','1'),
('O000010','BC000004','SC000005','House Buiding - 20618','2838642693.55','ORDER','1','C000001','A000005','P000005','S000003','D000001','1'),
('O000011','BC000003','SC000003','House Buiding - 20620','2399964680.87','INVOICE','1','C000001','A000005','P000001','S000002','D000005','1'),
('O000012','BC000005','SC000003','House Buiding - 20622','317671553.73','QUOTE','1','C000001','A000002','P000005','S000002','D000005','1'),
('O000013','BC000003','SC000001','House Buiding - 20624','159693668.90','ORDER','1','C000004','A000001','P000001','S000002','D000003','1'),
('O000014','BC000004','SC000003','House Buiding - 20626','1053550654.97','INVOICE','1','C000001','A000002','P000005','S000004','D000003','1'),
('O000015','BC000001','SC000003','House Buiding - 20628','1669968470.74','QUOTE','1','C000002','A000004','P000005','S000005','D000005','1'),
('O000016','BC000005','SC000003','House Buiding - 20630','19789418.29','ORDER','1','C000002','A000003','P000003','S000005','D000004','1'),
('O000017','BC000005','SC000005','House Buiding - 20632','1521207285.46','INVOICE','1','C000005','A000001','P000002','S000005','D000003','1'),
('O000018','BC000001','SC000002','House Buiding - 20634','2044358248.09','QUOTE','1','C000003','A000003','P000004','S000005','D000001','1'),
('O000019','BC000002','SC000004','House Buiding - 20636','1890298981.85','ORDER','1','C000001','A000001','P000002','S000004','D000005','1'),
('O000020','BC000005','SC000005','House Buiding - 20638','911403480.91','INVOICE','1','C000005','A000001','P000005','S000005','D000001','1');
drop table  if exists confirmation_data;
create table confirmation_data (
	id	  	varchar(48) not null,
	who	  	varchar(40),
	confirm_time	  	Date,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into confirmation_data values
('C000001','approver20640','2014-01-30','1'),
('C000002','approver20641','2017-06-23','1'),
('C000003','approver20642','2014-10-21','1'),
('C000004','approver20643','2016-05-07','1'),
('C000005','approver20644','2017-06-22','1'),
('C000006','approver20645','2018-03-03','1'),
('C000007','approver20646','2016-06-14','1'),
('C000008','approver20647','2015-01-23','1'),
('C000009','approver20648','2015-10-18','1'),
('C000010','approver20649','2016-02-23','1'),
('C000011','approver20650','2018-01-29','1'),
('C000012','approver20651','2016-06-15','1'),
('C000013','approver20652','2015-01-25','1'),
('C000014','approver20653','2017-12-17','1'),
('C000015','approver20654','2017-01-28','1'),
('C000016','approver20655','2014-10-12','1'),
('C000017','approver20656','2014-03-06','1'),
('C000018','approver20657','2014-08-27','1'),
('C000019','approver20658','2018-07-02','1'),
('C000020','approver20659','2016-09-22','1');
drop table  if exists shipment_data;
create table shipment_data (
	id	  	varchar(48) not null,
	who	  	varchar(32),
	ship_time	  	Date,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into shipment_data values
('S000001','carrier20660','2017-01-17','1'),
('S000002','carrier20661','2014-01-06','1'),
('S000003','carrier20662','2017-11-06','1'),
('S000004','carrier20663','2016-10-31','1'),
('S000005','carrier20664','2015-02-07','1'),
('S000006','carrier20665','2016-02-11','1'),
('S000007','carrier20666','2013-11-04','1'),
('S000008','carrier20667','2016-11-13','1'),
('S000009','carrier20668','2014-04-19','1'),
('S000010','carrier20669','2015-05-30','1'),
('S000011','carrier20670','2017-06-08','1'),
('S000012','carrier20671','2018-01-18','1'),
('S000013','carrier20672','2014-07-25','1'),
('S000014','carrier20673','2015-01-12','1'),
('S000015','carrier20674','2016-11-02','1'),
('S000016','carrier20675','2015-03-30','1'),
('S000017','carrier20676','2014-06-22','1'),
('S000018','carrier20677','2013-07-29','1'),
('S000019','carrier20678','2015-12-04','1'),
('S000020','carrier20679','2017-11-10','1');
drop table  if exists delivery_data;
create table delivery_data (
	id	  	varchar(48) not null,
	who	  	varchar(40),
	delivery_time	  	Date,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into delivery_data values
('D000001','deliverer20680','2015-02-28','1'),
('D000002','deliverer20681','2017-03-12','1'),
('D000003','deliverer20682','2014-09-03','1'),
('D000004','deliverer20683','2017-10-16','1'),
('D000005','deliverer20684','2015-05-28','1'),
('D000006','deliverer20685','2015-01-05','1'),
('D000007','deliverer20686','2015-10-20','1'),
('D000008','deliverer20687','2015-07-26','1'),
('D000009','deliverer20688','2013-10-18','1'),
('D000010','deliverer20689','2018-06-10','1'),
('D000011','deliverer20690','2015-10-09','1'),
('D000012','deliverer20691','2016-11-24','1'),
('D000013','deliverer20692','2014-08-06','1'),
('D000014','deliverer20693','2015-09-18','1'),
('D000015','deliverer20694','2016-08-11','1'),
('D000016','deliverer20695','2017-12-19','1'),
('D000017','deliverer20696','2015-09-14','1'),
('D000018','deliverer20697','2015-09-24','1'),
('D000019','deliverer20698','2016-12-29','1'),
('D000020','deliverer20699','2013-12-04','1');
drop table  if exists processing_data;
create table processing_data (
	id	  	varchar(48) not null,
	who	  	varchar(40),
	process_time	  	Date,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into processing_data values
('P000001','processor20700','2015-08-26','1'),
('P000002','processor20701','2016-04-27','1'),
('P000003','processor20702','2016-12-06','1'),
('P000004','processor20703','2016-10-23','1'),
('P000005','processor20704','2016-03-30','1'),
('P000006','processor20705','2015-03-31','1'),
('P000007','processor20706','2015-05-07','1'),
('P000008','processor20707','2015-06-10','1'),
('P000009','processor20708','2013-08-16','1'),
('P000010','processor20709','2018-05-29','1'),
('P000011','processor20710','2018-06-24','1'),
('P000012','processor20711','2016-09-01','1'),
('P000013','processor20712','2018-03-04','1'),
('P000014','processor20713','2018-06-25','1'),
('P000015','processor20714','2014-10-14','1'),
('P000016','processor20715','2014-06-22','1'),
('P000017','processor20716','2017-08-24','1'),
('P000018','processor20717','2018-06-04','1'),
('P000019','processor20718','2013-07-14','1'),
('P000020','processor20719','2015-02-17','1');
drop table  if exists approval_data;
create table approval_data (
	id	  	varchar(48) not null,
	who	  	varchar(40),
	approve_time	  	Date,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into approval_data values
('A000001','approver20720','2018-04-06','1'),
('A000002','approver20721','2013-07-10','1'),
('A000003','approver20722','2014-10-24','1'),
('A000004','approver20723','2014-03-24','1'),
('A000005','approver20724','2015-05-16','1'),
('A000006','approver20725','2017-02-25','1'),
('A000007','approver20726','2017-12-18','1'),
('A000008','approver20727','2018-06-29','1'),
('A000009','approver20728','2018-06-22','1'),
('A000010','approver20729','2014-12-09','1'),
('A000011','approver20730','2013-11-15','1'),
('A000012','approver20731','2018-01-21','1'),
('A000013','approver20732','2014-12-25','1'),
('A000014','approver20733','2013-10-07','1'),
('A000015','approver20734','2013-07-19','1'),
('A000016','approver20735','2017-05-01','1'),
('A000017','approver20736','2018-02-16','1'),
('A000018','approver20737','2017-01-25','1'),
('A000019','approver20738','2016-10-08','1'),
('A000020','approver20739','2015-10-11','1');
drop table  if exists line_item_data;
create table line_item_data (
	id	  	varchar(48) not null,
	biz_order	  	varchar(48),
	sku_id	  	varchar(16),
	sku_name	  	varchar(40),
	amount	  	numeric(6,2),
	quantity	  	int,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into line_item_data values
('LI000001','O000002','SKU20740','iPhone - 20741','17.88','9','1'),
('LI000002','O000001','SKU20742','iPhone - 20743','18.27','4','1'),
('LI000003','O000002','SKU20744','iPhone - 20745','5.09','1','1'),
('LI000004','O000004','SKU20746','iPhone - 20747','0.54','10','1'),
('LI000005','O000002','SKU20748','iPhone - 20749','8.79','2','1'),
('LI000006','O000002','SKU20750','iPhone - 20751','11.52','7','1'),
('LI000007','O000002','SKU20752','iPhone - 20753','22.71','3','1'),
('LI000008','O000003','SKU20754','iPhone - 20755','20.07','4','1'),
('LI000009','O000003','SKU20756','iPhone - 20757','18.37','8','1'),
('LI000010','O000002','SKU20758','iPhone - 20759','16.33','3','1'),
('LI000011','O000005','SKU20760','iPhone - 20761','15.24','10','1'),
('LI000012','O000005','SKU20762','iPhone - 20763','7.86','10','1'),
('LI000013','O000004','SKU20764','iPhone - 20765','6.37','7','1'),
('LI000014','O000001','SKU20766','iPhone - 20767','12.64','10','1'),
('LI000015','O000002','SKU20768','iPhone - 20769','0.11','6','1'),
('LI000016','O000001','SKU20770','iPhone - 20771','11.12','7','1'),
('LI000017','O000003','SKU20772','iPhone - 20773','12.40','5','1'),
('LI000018','O000002','SKU20774','iPhone - 20775','8.99','4','1'),
('LI000019','O000004','SKU20776','iPhone - 20777','7.47','1','1'),
('LI000020','O000003','SKU20778','iPhone - 20779','21.77','1','1');
drop table  if exists shipping_group_data;
create table shipping_group_data (
	id	  	varchar(48) not null,
	name	  	varchar(104),
	biz_order	  	varchar(48),
	address	  	varchar(48),
	amount	  	numeric(5,2),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into shipping_group_data values
('SG000001','shipping to this address20780','O000002','SA000005','2.64','1'),
('SG000002','shipping to this address20781','O000003','SA000002','0.28','1'),
('SG000003','shipping to this address20782','O000002','SA000005','4.89','1'),
('SG000004','shipping to this address20783','O000002','SA000001','4.65','1'),
('SG000005','shipping to this address20784','O000003','SA000004','4.29','1'),
('SG000006','shipping to this address20785','O000005','SA000001','2.73','1'),
('SG000007','shipping to this address20786','O000005','SA000003','3.19','1'),
('SG000008','shipping to this address20787','O000001','SA000002','5.55','1'),
('SG000009','shipping to this address20788','O000004','SA000004','4.79','1'),
('SG000010','shipping to this address20789','O000003','SA000001','2.20','1'),
('SG000011','shipping to this address20790','O000003','SA000005','0.80','1'),
('SG000012','shipping to this address20791','O000005','SA000005','0.14','1'),
('SG000013','shipping to this address20792','O000004','SA000002','3.60','1'),
('SG000014','shipping to this address20793','O000003','SA000001','3.41','1'),
('SG000015','shipping to this address20794','O000005','SA000001','3.48','1'),
('SG000016','shipping to this address20795','O000005','SA000002','5.54','1'),
('SG000017','shipping to this address20796','O000005','SA000001','1.07','1'),
('SG000018','shipping to this address20797','O000004','SA000002','2.25','1'),
('SG000019','shipping to this address20798','O000004','SA000005','2.87','1'),
('SG000020','shipping to this address20799','O000001','SA000003','2.34','1');
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
('PG000001','visa card ending - 20800','O000002','4111 1111 1111 - 20801','BA000005','1'),
('PG000002','visa card ending - 20802','O000004','4111 1111 1111 - 20803','BA000005','1'),
('PG000003','visa card ending - 20804','O000005','4111 1111 1111 - 20805','BA000003','1'),
('PG000004','visa card ending - 20806','O000005','4111 1111 1111 - 20807','BA000005','1'),
('PG000005','visa card ending - 20808','O000004','4111 1111 1111 - 20809','BA000002','1'),
('PG000006','visa card ending - 20810','O000001','4111 1111 1111 - 20811','BA000001','1'),
('PG000007','visa card ending - 20812','O000002','4111 1111 1111 - 20813','BA000001','1'),
('PG000008','visa card ending - 20814','O000001','4111 1111 1111 - 20815','BA000005','1'),
('PG000009','visa card ending - 20816','O000001','4111 1111 1111 - 20817','BA000002','1'),
('PG000010','visa card ending - 20818','O000003','4111 1111 1111 - 20819','BA000003','1'),
('PG000011','visa card ending - 20820','O000003','4111 1111 1111 - 20821','BA000001','1'),
('PG000012','visa card ending - 20822','O000005','4111 1111 1111 - 20823','BA000004','1'),
('PG000013','visa card ending - 20824','O000002','4111 1111 1111 - 20825','BA000002','1'),
('PG000014','visa card ending - 20826','O000005','4111 1111 1111 - 20827','BA000005','1'),
('PG000015','visa card ending - 20828','O000001','4111 1111 1111 - 20829','BA000005','1'),
('PG000016','visa card ending - 20830','O000005','4111 1111 1111 - 20831','BA000003','1'),
('PG000017','visa card ending - 20832','O000002','4111 1111 1111 - 20833','BA000005','1'),
('PG000018','visa card ending - 20834','O000004','4111 1111 1111 - 20835','BA000004','1'),
('PG000019','visa card ending - 20836','O000004','4111 1111 1111 - 20837','BA000002','1'),
('PG000020','visa card ending - 20838','O000003','4111 1111 1111 - 20839','BA000005','1');
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
('CSR000001','philip_chang@174.com','R000002','SC000003','1'),
('CSR000002','philip_chang@174.com','R000005','SC000001','1'),
('CSR000003','philip_chang@174.com','R000005','SC000003','1'),
('CSR000004','philip_chang@174.com','R000003','SC000005','1'),
('CSR000005','philip_chang@174.com','R000002','SC000005','1'),
('CSR000006','philip_chang@174.com','R000003','SC000003','1'),
('CSR000007','philip_chang@174.com','R000002','SC000005','1'),
('CSR000008','philip_chang@174.com','R000005','SC000002','1'),
('CSR000009','philip_chang@174.com','R000004','SC000004','1'),
('CSR000010','philip_chang@174.com','R000005','SC000005','1'),
('CSR000011','philip_chang@174.com','R000003','SC000001','1'),
('CSR000012','philip_chang@174.com','R000005','SC000005','1'),
('CSR000013','philip_chang@174.com','R000005','SC000003','1'),
('CSR000014','philip_chang@174.com','R000005','SC000003','1'),
('CSR000015','philip_chang@174.com','R000001','SC000002','1'),
('CSR000016','philip_chang@174.com','R000004','SC000002','1'),
('CSR000017','philip_chang@174.com','R000005','SC000005','1'),
('CSR000018','philip_chang@174.com','R000003','SC000001','1'),
('CSR000019','philip_chang@174.com','R000005','SC000004','1'),
('CSR000020','philip_chang@174.com','R000004','SC000004','1');
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
('A000001','view20840','load20841','O000005','1'),
('A000002','view20842','load20843','O000005','1'),
('A000003','view20844','load20845','O000002','1'),
('A000004','view20846','load20847','O000004','1'),
('A000005','view20848','load20849','O000004','1'),
('A000006','view20850','load20851','O000001','1'),
('A000007','view20852','load20853','O000005','1'),
('A000008','view20854','load20855','O000004','1'),
('A000009','view20856','load20857','O000002','1'),
('A000010','view20858','load20859','O000004','1'),
('A000011','view20860','load20861','O000001','1'),
('A000012','view20862','load20863','O000003','1'),
('A000013','view20864','load20865','O000004','1'),
('A000014','view20866','load20867','O000005','1'),
('A000015','view20868','load20869','O000004','1'),
('A000016','view20870','load20871','O000002','1'),
('A000017','view20872','load20873','O000004','1'),
('A000018','view20874','load20875','O000001','1'),
('A000019','view20876','load20877','O000001','1'),
('A000020','view20878','load20879','O000003','1');



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








