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
('BC000001','Aaxis - 680','price9900681','10','simple.jpg683','philip@aaxischina.com','1'),
('BC000002','Aaxis - 684','price9900685','10','simple.jpg687','philip@aaxischina.com','1'),
('BC000003','Aaxis - 688','price9900689','10','simple.jpg691','philip@aaxischina.com','1'),
('BC000004','Aaxis - 692','price9900693','10','simple.jpg695','philip@aaxischina.com','1'),
('BC000005','Aaxis - 696','price9900697','10','simple.jpg699','philip@aaxischina.com','1'),
('BC000006','Aaxis - 700','price9900701','10','simple.jpg703','philip@aaxischina.com','1'),
('BC000007','Aaxis - 704','price9900705','10','simple.jpg707','philip@aaxischina.com','1'),
('BC000008','Aaxis - 708','price9900709','10','simple.jpg711','philip@aaxischina.com','1'),
('BC000009','Aaxis - 712','price9900713','10','simple.jpg715','philip@aaxischina.com','1'),
('BC000010','Aaxis - 716','price9900717','10','simple.jpg719','philip@aaxischina.com','1'),
('BC000011','Aaxis - 720','price9900721','10','simple.jpg723','philip@aaxischina.com','1'),
('BC000012','Aaxis - 724','price9900725','10','simple.jpg727','philip@aaxischina.com','1'),
('BC000013','Aaxis - 728','price9900729','10','simple.jpg731','philip@aaxischina.com','1'),
('BC000014','Aaxis - 732','price9900733','10','simple.jpg735','philip@aaxischina.com','1'),
('BC000015','Aaxis - 736','price9900737','10','simple.jpg739','philip@aaxischina.com','1'),
('BC000016','Aaxis - 740','price9900741','10','simple.jpg743','philip@aaxischina.com','1'),
('BC000017','Aaxis - 744','price9900745','10','simple.jpg747','philip@aaxischina.com','1'),
('BC000018','Aaxis - 748','price9900749','10','simple.jpg751','philip@aaxischina.com','1'),
('BC000019','Aaxis - 752','price9900753','10','simple.jpg755','philip@aaxischina.com','1'),
('BC000020','Aaxis - 756','price9900757','10','simple.jpg759','philip@aaxischina.com','1');
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
('SC000001','Snack Co. 760','philip@aaxischina.com','simple.jpg761','x.doc762','1'),
('SC000002','Snack Co. 763','philip@aaxischina.com','simple.jpg764','x.doc765','1'),
('SC000003','Snack Co. 766','philip@aaxischina.com','simple.jpg767','x.doc768','1'),
('SC000004','Snack Co. 769','philip@aaxischina.com','simple.jpg770','x.doc771','1'),
('SC000005','Snack Co. 772','philip@aaxischina.com','simple.jpg773','x.doc774','1'),
('SC000006','Snack Co. 775','philip@aaxischina.com','simple.jpg776','x.doc777','1'),
('SC000007','Snack Co. 778','philip@aaxischina.com','simple.jpg779','x.doc780','1'),
('SC000008','Snack Co. 781','philip@aaxischina.com','simple.jpg782','x.doc783','1'),
('SC000009','Snack Co. 784','philip@aaxischina.com','simple.jpg785','x.doc786','1'),
('SC000010','Snack Co. 787','philip@aaxischina.com','simple.jpg788','x.doc789','1'),
('SC000011','Snack Co. 790','philip@aaxischina.com','simple.jpg791','x.doc792','1'),
('SC000012','Snack Co. 793','philip@aaxischina.com','simple.jpg794','x.doc795','1'),
('SC000013','Snack Co. 796','philip@aaxischina.com','simple.jpg797','x.doc798','1'),
('SC000014','Snack Co. 799','philip@aaxischina.com','simple.jpg800','x.doc801','1'),
('SC000015','Snack Co. 802','philip@aaxischina.com','simple.jpg803','x.doc804','1'),
('SC000016','Snack Co. 805','philip@aaxischina.com','simple.jpg806','x.doc807','1'),
('SC000017','Snack Co. 808','philip@aaxischina.com','simple.jpg809','x.doc810','1'),
('SC000018','Snack Co. 811','philip@aaxischina.com','simple.jpg812','x.doc813','1'),
('SC000019','Snack Co. 814','philip@aaxischina.com','simple.jpg815','x.doc816','1'),
('SC000020','Snack Co. 817','philip@aaxischina.com','simple.jpg818','x.doc819','1');
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
('SA000001','1900 AVE OF THE STARTS - 820','Suite 555 - 821','Century City - 822','VA','US824','1'),
('SA000002','1900 AVE OF THE STARTS - 825','Suite 555 - 826','Century City - 827','CA','US829','1'),
('SA000003','1900 AVE OF THE STARTS - 830','Suite 555 - 831','Century City - 832','LA','US834','1'),
('SA000004','1900 AVE OF THE STARTS - 835','Suite 555 - 836','Century City - 837','WA','US839','1'),
('SA000005','1900 AVE OF THE STARTS - 840','Suite 555 - 841','Century City - 842','PA','US844','1'),
('SA000006','1900 AVE OF THE STARTS - 845','Suite 555 - 846','Century City - 847','MA','US849','1'),
('SA000007','1900 AVE OF THE STARTS - 850','Suite 555 - 851','Century City - 852','VA','US854','1'),
('SA000008','1900 AVE OF THE STARTS - 855','Suite 555 - 856','Century City - 857','CA','US859','1'),
('SA000009','1900 AVE OF THE STARTS - 860','Suite 555 - 861','Century City - 862','LA','US864','1'),
('SA000010','1900 AVE OF THE STARTS - 865','Suite 555 - 866','Century City - 867','WA','US869','1'),
('SA000011','1900 AVE OF THE STARTS - 870','Suite 555 - 871','Century City - 872','PA','US874','1'),
('SA000012','1900 AVE OF THE STARTS - 875','Suite 555 - 876','Century City - 877','MA','US879','1'),
('SA000013','1900 AVE OF THE STARTS - 880','Suite 555 - 881','Century City - 882','VA','US884','1'),
('SA000014','1900 AVE OF THE STARTS - 885','Suite 555 - 886','Century City - 887','CA','US889','1'),
('SA000015','1900 AVE OF THE STARTS - 890','Suite 555 - 891','Century City - 892','LA','US894','1'),
('SA000016','1900 AVE OF THE STARTS - 895','Suite 555 - 896','Century City - 897','WA','US899','1'),
('SA000017','1900 AVE OF THE STARTS - 900','Suite 555 - 901','Century City - 902','PA','US904','1'),
('SA000018','1900 AVE OF THE STARTS - 905','Suite 555 - 906','Century City - 907','MA','US909','1'),
('SA000019','1900 AVE OF THE STARTS - 910','Suite 555 - 911','Century City - 912','VA','US914','1'),
('SA000020','1900 AVE OF THE STARTS - 915','Suite 555 - 916','Century City - 917','CA','US919','1');
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
('BA000001','BC000005','1900 AVE OF THE STARTS - 920','Suite 555 - 921','Century City - 922','LA','US924','1'),
('BA000002','BC000005','1900 AVE OF THE STARTS - 925','Suite 555 - 926','Century City - 927','WA','US929','1'),
('BA000003','BC000001','1900 AVE OF THE STARTS - 930','Suite 555 - 931','Century City - 932','PA','US934','1'),
('BA000004','BC000005','1900 AVE OF THE STARTS - 935','Suite 555 - 936','Century City - 937','MA','US939','1'),
('BA000005','BC000002','1900 AVE OF THE STARTS - 940','Suite 555 - 941','Century City - 942','VA','US944','1'),
('BA000006','BC000004','1900 AVE OF THE STARTS - 945','Suite 555 - 946','Century City - 947','CA','US949','1'),
('BA000007','BC000004','1900 AVE OF THE STARTS - 950','Suite 555 - 951','Century City - 952','LA','US954','1'),
('BA000008','BC000005','1900 AVE OF THE STARTS - 955','Suite 555 - 956','Century City - 957','WA','US959','1'),
('BA000009','BC000003','1900 AVE OF THE STARTS - 960','Suite 555 - 961','Century City - 962','PA','US964','1'),
('BA000010','BC000003','1900 AVE OF THE STARTS - 965','Suite 555 - 966','Century City - 967','MA','US969','1'),
('BA000011','BC000004','1900 AVE OF THE STARTS - 970','Suite 555 - 971','Century City - 972','VA','US974','1'),
('BA000012','BC000002','1900 AVE OF THE STARTS - 975','Suite 555 - 976','Century City - 977','CA','US979','1'),
('BA000013','BC000003','1900 AVE OF THE STARTS - 980','Suite 555 - 981','Century City - 982','LA','US984','1'),
('BA000014','BC000002','1900 AVE OF THE STARTS - 985','Suite 555 - 986','Century City - 987','WA','US989','1'),
('BA000015','BC000005','1900 AVE OF THE STARTS - 990','Suite 555 - 991','Century City - 992','PA','US994','1'),
('BA000016','BC000003','1900 AVE OF THE STARTS - 995','Suite 555 - 996','Century City - 997','MA','US999','1'),
('BA000017','BC000003','1900 AVE OF THE STARTS - 1000','Suite 555 - 1001','Century City - 1002','VA','US1004','1'),
('BA000018','BC000003','1900 AVE OF THE STARTS - 1005','Suite 555 - 1006','Century City - 1007','CA','US1009','1'),
('BA000019','BC000003','1900 AVE OF THE STARTS - 1010','Suite 555 - 1011','Century City - 1012','LA','US1014','1'),
('BA000020','BC000005','1900 AVE OF THE STARTS - 1015','Suite 555 - 1016','Century City - 1017','WA','US1019','1');
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
('E000001','Philip1020','BC000001','philip@aaxischina.com','1'),
('E000002','Philip1021','BC000005','philip@aaxischina.com','1'),
('E000003','Philip1022','BC000005','philip@aaxischina.com','1'),
('E000004','Philip1023','BC000001','philip@aaxischina.com','1'),
('E000005','Philip1024','BC000005','philip@aaxischina.com','1'),
('E000006','Philip1025','BC000001','philip@aaxischina.com','1'),
('E000007','Philip1026','BC000003','philip@aaxischina.com','1'),
('E000008','Philip1027','BC000003','philip@aaxischina.com','1'),
('E000009','Philip1028','BC000001','philip@aaxischina.com','1'),
('E000010','Philip1029','BC000003','philip@aaxischina.com','1'),
('E000011','Philip1030','BC000003','philip@aaxischina.com','1'),
('E000012','Philip1031','BC000004','philip@aaxischina.com','1'),
('E000013','Philip1032','BC000004','philip@aaxischina.com','1'),
('E000014','Philip1033','BC000003','philip@aaxischina.com','1'),
('E000015','Philip1034','BC000001','philip@aaxischina.com','1'),
('E000016','Philip1035','BC000001','philip@aaxischina.com','1'),
('E000017','Philip1036','BC000002','philip@aaxischina.com','1'),
('E000018','Philip1037','BC000001','philip@aaxischina.com','1'),
('E000019','Philip1038','BC000003','philip@aaxischina.com','1'),
('E000020','Philip1039','BC000004','philip@aaxischina.com','1');
drop table  if exists role_data;
create table role_data (
	id	  	varchar(48) not null,
	role_name	  	varchar(32),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into role_data values
('R000001','manager1040','1'),
('R000002','manager1041','1'),
('R000003','manager1042','1'),
('R000004','manager1043','1'),
('R000005','manager1044','1'),
('R000006','manager1045','1'),
('R000007','manager1046','1'),
('R000008','manager1047','1'),
('R000009','manager1048','1'),
('R000010','manager1049','1'),
('R000011','manager1050','1'),
('R000012','manager1051','1'),
('R000013','manager1052','1'),
('R000014','manager1053','1'),
('R000015','manager1054','1'),
('R000016','manager1055','1'),
('R000017','manager1056','1'),
('R000018','manager1057','1'),
('R000019','manager1058','1'),
('R000020','manager1059','1');
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
('A000001','E000003','A000003','2015-11-01','1'),
('A000002','E000003','A000001','2017-11-12','1'),
('A000003','E000003','A000001','2015-08-02','1'),
('A000004','E000003','A000004','2014-07-07','1'),
('A000005','E000002','A000001','2018-09-22','1'),
('A000006','E000002','A000005','2016-12-31','1'),
('A000007','E000002','A000005','2018-06-05','1'),
('A000008','E000004','A000001','2018-01-03','1'),
('A000009','E000002','A000003','2016-07-16','1'),
('A000010','E000002','A000005','2014-04-25','1'),
('A000011','E000005','A000001','2014-08-23','1'),
('A000012','E000001','A000003','2018-01-21','1'),
('A000013','E000001','A000002','2014-10-06','1'),
('A000014','E000005','A000004','2014-07-22','1'),
('A000015','E000003','A000003','2014-06-03','1'),
('A000016','E000004','A000004','2016-10-22','1'),
('A000017','E000004','A000003','2016-02-21','1'),
('A000018','E000002','A000001','2016-08-27','1'),
('A000019','E000002','A000004','2015-01-21','1'),
('A000020','E000004','A000001','2016-02-22','1');
drop table  if exists access_data;
create table access_data (
	id	  	varchar(48) not null,
	role_name	  	varchar(40),
	role	  	varchar(48),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into access_data values
('A000001','x manager1060','R000004','1'),
('A000002','x manager1061','R000003','1'),
('A000003','x manager1062','R000001','1'),
('A000004','x manager1063','R000003','1'),
('A000005','x manager1064','R000002','1'),
('A000006','x manager1065','R000002','1'),
('A000007','x manager1066','R000005','1'),
('A000008','x manager1067','R000004','1'),
('A000009','x manager1068','R000003','1'),
('A000010','x manager1069','R000001','1'),
('A000011','x manager1070','R000004','1'),
('A000012','x manager1071','R000001','1'),
('A000013','x manager1072','R000001','1'),
('A000014','x manager1073','R000003','1'),
('A000015','x manager1074','R000003','1'),
('A000016','x manager1075','R000002','1'),
('A000017','x manager1076','R000005','1'),
('A000018','x manager1077','R000001','1'),
('A000019','x manager1078','R000003','1'),
('A000020','x manager1079','R000005','1');
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
('O000001','BC000003','SC000002','House Buiding - 1080','870535579.16','QUOTE','1','C000005','A000004','P000004','S000003','D000001','1'),
('O000002','BC000004','SC000002','House Buiding - 1082','466632473.16','ORDER','1','C000002','A000004','P000003','S000002','D000002','1'),
('O000003','BC000002','SC000005','House Buiding - 1084','8159530.91','INVOICE','1','C000001','A000004','P000005','S000004','D000005','1'),
('O000004','BC000001','SC000003','House Buiding - 1086','2297644699.87','QUOTE','1','C000003','A000001','P000001','S000005','D000004','1'),
('O000005','BC000001','SC000005','House Buiding - 1088','850796928.97','ORDER','1','C000002','A000003','P000004','S000001','D000004','1'),
('O000006','BC000005','SC000001','House Buiding - 1090','2973903437.49','INVOICE','1','C000003','A000004','P000004','S000002','D000004','1'),
('O000007','BC000005','SC000001','House Buiding - 1092','672098614.67','QUOTE','1','C000002','A000003','P000005','S000003','D000003','1'),
('O000008','BC000003','SC000001','House Buiding - 1094','1970536077.75','ORDER','1','C000003','A000002','P000004','S000002','D000005','1'),
('O000009','BC000005','SC000001','House Buiding - 1096','480494084.96','INVOICE','1','C000005','A000002','P000005','S000004','D000005','1'),
('O000010','BC000003','SC000003','House Buiding - 1098','292447017.31','QUOTE','1','C000002','A000002','P000004','S000004','D000003','1'),
('O000011','BC000001','SC000005','House Buiding - 1100','2528133022.19','ORDER','1','C000005','A000004','P000004','S000005','D000004','1'),
('O000012','BC000004','SC000002','House Buiding - 1102','133649640.22','INVOICE','1','C000001','A000004','P000002','S000001','D000002','1'),
('O000013','BC000003','SC000003','House Buiding - 1104','2745608369.21','QUOTE','1','C000001','A000005','P000002','S000005','D000003','1'),
('O000014','BC000004','SC000001','House Buiding - 1106','1712379879.81','ORDER','1','C000005','A000004','P000005','S000005','D000005','1'),
('O000015','BC000005','SC000001','House Buiding - 1108','602460442.07','INVOICE','1','C000001','A000003','P000002','S000001','D000004','1'),
('O000016','BC000005','SC000001','House Buiding - 1110','1781991204.86','QUOTE','1','C000005','A000005','P000003','S000005','D000004','1'),
('O000017','BC000003','SC000003','House Buiding - 1112','893462184.74','ORDER','1','C000003','A000005','P000003','S000004','D000002','1'),
('O000018','BC000001','SC000005','House Buiding - 1114','1317630428.65','INVOICE','1','C000003','A000005','P000002','S000003','D000002','1'),
('O000019','BC000001','SC000004','House Buiding - 1116','2950686033.94','QUOTE','1','C000004','A000005','P000004','S000004','D000001','1'),
('O000020','BC000005','SC000002','House Buiding - 1118','2878695028.14','ORDER','1','C000004','A000003','P000005','S000002','D000004','1');
drop table  if exists confirmation_data;
create table confirmation_data (
	id	  	varchar(48) not null,
	who	  	varchar(40),
	confirm_time	  	Date,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into confirmation_data values
('C000001','approver1120','2014-09-19','1'),
('C000002','approver1121','2014-12-25','1'),
('C000003','approver1122','2013-11-20','1'),
('C000004','approver1123','2018-03-22','1'),
('C000005','approver1124','2014-09-29','1'),
('C000006','approver1125','2013-07-18','1'),
('C000007','approver1126','2016-03-08','1'),
('C000008','approver1127','2018-03-07','1'),
('C000009','approver1128','2016-09-22','1'),
('C000010','approver1129','2017-06-13','1'),
('C000011','approver1130','2014-12-10','1'),
('C000012','approver1131','2016-02-06','1'),
('C000013','approver1132','2015-06-05','1'),
('C000014','approver1133','2016-11-20','1'),
('C000015','approver1134','2015-04-24','1'),
('C000016','approver1135','2015-01-21','1'),
('C000017','approver1136','2016-10-04','1'),
('C000018','approver1137','2014-04-10','1'),
('C000019','approver1138','2017-06-19','1'),
('C000020','approver1139','2015-05-12','1');
drop table  if exists shipment_data;
create table shipment_data (
	id	  	varchar(48) not null,
	who	  	varchar(32),
	ship_time	  	Date,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into shipment_data values
('S000001','carrier1140','2016-10-22','1'),
('S000002','carrier1141','2015-01-25','1'),
('S000003','carrier1142','2017-11-21','1'),
('S000004','carrier1143','2018-01-01','1'),
('S000005','carrier1144','2014-08-11','1'),
('S000006','carrier1145','2015-02-02','1'),
('S000007','carrier1146','2014-12-14','1'),
('S000008','carrier1147','2015-12-07','1'),
('S000009','carrier1148','2017-09-07','1'),
('S000010','carrier1149','2017-09-30','1'),
('S000011','carrier1150','2015-03-15','1'),
('S000012','carrier1151','2014-05-16','1'),
('S000013','carrier1152','2017-09-08','1'),
('S000014','carrier1153','2015-06-11','1'),
('S000015','carrier1154','2017-09-22','1'),
('S000016','carrier1155','2018-01-05','1'),
('S000017','carrier1156','2018-03-04','1'),
('S000018','carrier1157','2017-09-07','1'),
('S000019','carrier1158','2013-10-07','1'),
('S000020','carrier1159','2014-06-19','1');
drop table  if exists delivery_data;
create table delivery_data (
	id	  	varchar(48) not null,
	who	  	varchar(40),
	delivery_time	  	Date,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into delivery_data values
('D000001','deliverer1160','2017-11-02','1'),
('D000002','deliverer1161','2014-09-22','1'),
('D000003','deliverer1162','2017-07-05','1'),
('D000004','deliverer1163','2014-12-30','1'),
('D000005','deliverer1164','2015-02-09','1'),
('D000006','deliverer1165','2013-12-04','1'),
('D000007','deliverer1166','2016-10-10','1'),
('D000008','deliverer1167','2015-10-15','1'),
('D000009','deliverer1168','2013-10-18','1'),
('D000010','deliverer1169','2017-10-08','1'),
('D000011','deliverer1170','2013-08-21','1'),
('D000012','deliverer1171','2014-08-28','1'),
('D000013','deliverer1172','2015-04-04','1'),
('D000014','deliverer1173','2016-03-18','1'),
('D000015','deliverer1174','2015-10-03','1'),
('D000016','deliverer1175','2015-09-25','1'),
('D000017','deliverer1176','2013-11-30','1'),
('D000018','deliverer1177','2017-11-17','1'),
('D000019','deliverer1178','2018-05-23','1'),
('D000020','deliverer1179','2016-10-11','1');
drop table  if exists processing_data;
create table processing_data (
	id	  	varchar(48) not null,
	who	  	varchar(40),
	process_time	  	Date,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into processing_data values
('P000001','processor1180','2016-07-05','1'),
('P000002','processor1181','2013-12-06','1'),
('P000003','processor1182','2015-06-12','1'),
('P000004','processor1183','2016-06-19','1'),
('P000005','processor1184','2014-12-10','1'),
('P000006','processor1185','2015-05-17','1'),
('P000007','processor1186','2015-01-09','1'),
('P000008','processor1187','2016-07-30','1'),
('P000009','processor1188','2018-06-28','1'),
('P000010','processor1189','2014-05-04','1'),
('P000011','processor1190','2016-02-29','1'),
('P000012','processor1191','2017-01-15','1'),
('P000013','processor1192','2013-11-23','1'),
('P000014','processor1193','2017-01-07','1'),
('P000015','processor1194','2018-04-23','1'),
('P000016','processor1195','2014-07-26','1'),
('P000017','processor1196','2015-04-03','1'),
('P000018','processor1197','2016-02-02','1'),
('P000019','processor1198','2014-02-09','1'),
('P000020','processor1199','2014-01-04','1');
drop table  if exists approval_data;
create table approval_data (
	id	  	varchar(48) not null,
	who	  	varchar(40),
	approve_time	  	Date,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into approval_data values
('A000001','approver1200','2016-04-21','1'),
('A000002','approver1201','2017-11-23','1'),
('A000003','approver1202','2013-10-20','1'),
('A000004','approver1203','2014-10-07','1'),
('A000005','approver1204','2013-12-28','1'),
('A000006','approver1205','2015-02-21','1'),
('A000007','approver1206','2016-05-14','1'),
('A000008','approver1207','2018-01-11','1'),
('A000009','approver1208','2015-06-11','1'),
('A000010','approver1209','2013-07-13','1'),
('A000011','approver1210','2018-01-25','1'),
('A000012','approver1211','2014-06-09','1'),
('A000013','approver1212','2014-12-15','1'),
('A000014','approver1213','2016-08-23','1'),
('A000015','approver1214','2013-08-09','1'),
('A000016','approver1215','2015-04-17','1'),
('A000017','approver1216','2018-04-09','1'),
('A000018','approver1217','2016-05-24','1'),
('A000019','approver1218','2013-08-22','1'),
('A000020','approver1219','2014-09-05','1');
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
('LI000001','O000005','SKU1220','iPhone - 1221','5.40','8','1'),
('LI000002','O000005','SKU1222','iPhone - 1223','15.88','3','1'),
('LI000003','O000001','SKU1224','iPhone - 1225','4.71','7','1'),
('LI000004','O000004','SKU1226','iPhone - 1227','0.08','7','1'),
('LI000005','O000002','SKU1228','iPhone - 1229','7.87','6','1'),
('LI000006','O000002','SKU1230','iPhone - 1231','0.03','7','1'),
('LI000007','O000003','SKU1232','iPhone - 1233','9.66','1','1'),
('LI000008','O000005','SKU1234','iPhone - 1235','7.35','9','1'),
('LI000009','O000004','SKU1236','iPhone - 1237','3.06','6','1'),
('LI000010','O000001','SKU1238','iPhone - 1239','2.63','9','1'),
('LI000011','O000002','SKU1240','iPhone - 1241','22.20','6','1'),
('LI000012','O000001','SKU1242','iPhone - 1243','0.81','4','1'),
('LI000013','O000003','SKU1244','iPhone - 1245','6.27','7','1'),
('LI000014','O000003','SKU1246','iPhone - 1247','10.39','3','1'),
('LI000015','O000001','SKU1248','iPhone - 1249','10.26','6','1'),
('LI000016','O000001','SKU1250','iPhone - 1251','3.86','4','1'),
('LI000017','O000004','SKU1252','iPhone - 1253','12.44','3','1'),
('LI000018','O000003','SKU1254','iPhone - 1255','23.66','9','1'),
('LI000019','O000002','SKU1256','iPhone - 1257','19.28','10','1'),
('LI000020','O000004','SKU1258','iPhone - 1259','1.92','10','1');
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
('SG000001','shipping to this address1260','O000004','SA000005','2.90','1'),
('SG000002','shipping to this address1261','O000005','SA000005','2.69','1'),
('SG000003','shipping to this address1262','O000004','SA000001','1.09','1'),
('SG000004','shipping to this address1263','O000001','SA000005','5.04','1'),
('SG000005','shipping to this address1264','O000002','SA000001','2.90','1'),
('SG000006','shipping to this address1265','O000001','SA000002','3.11','1'),
('SG000007','shipping to this address1266','O000003','SA000003','3.95','1'),
('SG000008','shipping to this address1267','O000005','SA000004','0.79','1'),
('SG000009','shipping to this address1268','O000004','SA000003','0.80','1'),
('SG000010','shipping to this address1269','O000005','SA000001','4.24','1'),
('SG000011','shipping to this address1270','O000005','SA000004','2.94','1'),
('SG000012','shipping to this address1271','O000003','SA000005','5.65','1'),
('SG000013','shipping to this address1272','O000001','SA000004','5.93','1'),
('SG000014','shipping to this address1273','O000005','SA000002','3.84','1'),
('SG000015','shipping to this address1274','O000005','SA000003','5.40','1'),
('SG000016','shipping to this address1275','O000003','SA000005','0.23','1'),
('SG000017','shipping to this address1276','O000003','SA000001','2.44','1'),
('SG000018','shipping to this address1277','O000004','SA000004','2.54','1'),
('SG000019','shipping to this address1278','O000005','SA000005','4.66','1'),
('SG000020','shipping to this address1279','O000003','SA000004','4.17','1');
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
('PG000001','visa card ending - 1280','O000003','4111 1111 1111 - 1281','BA000001','1'),
('PG000002','visa card ending - 1282','O000002','4111 1111 1111 - 1283','BA000004','1'),
('PG000003','visa card ending - 1284','O000003','4111 1111 1111 - 1285','BA000005','1'),
('PG000004','visa card ending - 1286','O000004','4111 1111 1111 - 1287','BA000001','1'),
('PG000005','visa card ending - 1288','O000001','4111 1111 1111 - 1289','BA000003','1'),
('PG000006','visa card ending - 1290','O000003','4111 1111 1111 - 1291','BA000004','1'),
('PG000007','visa card ending - 1292','O000003','4111 1111 1111 - 1293','BA000005','1'),
('PG000008','visa card ending - 1294','O000005','4111 1111 1111 - 1295','BA000002','1'),
('PG000009','visa card ending - 1296','O000002','4111 1111 1111 - 1297','BA000002','1'),
('PG000010','visa card ending - 1298','O000004','4111 1111 1111 - 1299','BA000004','1'),
('PG000011','visa card ending - 1300','O000003','4111 1111 1111 - 1301','BA000002','1'),
('PG000012','visa card ending - 1302','O000001','4111 1111 1111 - 1303','BA000003','1'),
('PG000013','visa card ending - 1304','O000002','4111 1111 1111 - 1305','BA000002','1'),
('PG000014','visa card ending - 1306','O000001','4111 1111 1111 - 1307','BA000003','1'),
('PG000015','visa card ending - 1308','O000005','4111 1111 1111 - 1309','BA000004','1'),
('PG000016','visa card ending - 1310','O000005','4111 1111 1111 - 1311','BA000001','1'),
('PG000017','visa card ending - 1312','O000004','4111 1111 1111 - 1313','BA000002','1'),
('PG000018','visa card ending - 1314','O000005','4111 1111 1111 - 1315','BA000001','1'),
('PG000019','visa card ending - 1316','O000003','4111 1111 1111 - 1317','BA000001','1'),
('PG000020','visa card ending - 1318','O000002','4111 1111 1111 - 1319','BA000003','1');
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
('CSR000001','philip_chang@174.com','R000002','SC000004','1'),
('CSR000002','philip_chang@174.com','R000004','SC000002','1'),
('CSR000003','philip_chang@174.com','R000003','SC000004','1'),
('CSR000004','philip_chang@174.com','R000004','SC000001','1'),
('CSR000005','philip_chang@174.com','R000003','SC000005','1'),
('CSR000006','philip_chang@174.com','R000003','SC000004','1'),
('CSR000007','philip_chang@174.com','R000005','SC000002','1'),
('CSR000008','philip_chang@174.com','R000004','SC000002','1'),
('CSR000009','philip_chang@174.com','R000001','SC000003','1'),
('CSR000010','philip_chang@174.com','R000001','SC000004','1'),
('CSR000011','philip_chang@174.com','R000003','SC000003','1'),
('CSR000012','philip_chang@174.com','R000005','SC000002','1'),
('CSR000013','philip_chang@174.com','R000002','SC000004','1'),
('CSR000014','philip_chang@174.com','R000005','SC000004','1'),
('CSR000015','philip_chang@174.com','R000003','SC000002','1'),
('CSR000016','philip_chang@174.com','R000002','SC000004','1'),
('CSR000017','philip_chang@174.com','R000005','SC000001','1'),
('CSR000018','philip_chang@174.com','R000004','SC000005','1'),
('CSR000019','philip_chang@174.com','R000001','SC000003','1'),
('CSR000020','philip_chang@174.com','R000004','SC000001','1');
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
('A000001','view1320','load1321','O000002','1'),
('A000002','view1322','load1323','O000003','1'),
('A000003','view1324','load1325','O000001','1'),
('A000004','view1326','load1327','O000003','1'),
('A000005','view1328','load1329','O000002','1'),
('A000006','view1330','load1331','O000001','1'),
('A000007','view1332','load1333','O000005','1'),
('A000008','view1334','load1335','O000002','1'),
('A000009','view1336','load1337','O000001','1'),
('A000010','view1338','load1339','O000003','1'),
('A000011','view1340','load1341','O000002','1'),
('A000012','view1342','load1343','O000001','1'),
('A000013','view1344','load1345','O000005','1'),
('A000014','view1346','load1347','O000001','1'),
('A000015','view1348','load1349','O000002','1'),
('A000016','view1350','load1351','O000003','1'),
('A000017','view1352','load1353','O000004','1'),
('A000018','view1354','load1355','O000001','1'),
('A000019','view1356','load1357','O000005','1'),
('A000020','view1358','load1359','O000002','1');



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








