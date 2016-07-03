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
('BC000001','Aaxis - 740','price9900741','10','simple.jpg','philip@aaxischina.com','1'),
('BC000002','Aaxis - 743','price9900744','200','simple.jpg','philip@aaxischina.com','1'),
('BC000003','Aaxis - 746','price9900747','10','simple.jpg','philip@aaxischina.com','1'),
('BC000004','Aaxis - 749','price9900750','200','simple.jpg','philip@aaxischina.com','1'),
('BC000005','Aaxis - 752','price9900753','10','simple.jpg','philip@aaxischina.com','1'),
('BC000006','Aaxis - 755','price9900756','200','simple.jpg','philip@aaxischina.com','1'),
('BC000007','Aaxis - 758','price9900759','10','simple.jpg','philip@aaxischina.com','1'),
('BC000008','Aaxis - 761','price9900762','200','simple.jpg','philip@aaxischina.com','1'),
('BC000009','Aaxis - 764','price9900765','10','simple.jpg','philip@aaxischina.com','1'),
('BC000010','Aaxis - 767','price9900768','200','simple.jpg','philip@aaxischina.com','1'),
('BC000011','Aaxis - 770','price9900771','10','simple.jpg','philip@aaxischina.com','1'),
('BC000012','Aaxis - 773','price9900774','200','simple.jpg','philip@aaxischina.com','1'),
('BC000013','Aaxis - 776','price9900777','10','simple.jpg','philip@aaxischina.com','1'),
('BC000014','Aaxis - 779','price9900780','200','simple.jpg','philip@aaxischina.com','1'),
('BC000015','Aaxis - 782','price9900783','10','simple.jpg','philip@aaxischina.com','1'),
('BC000016','Aaxis - 785','price9900786','200','simple.jpg','philip@aaxischina.com','1'),
('BC000017','Aaxis - 788','price9900789','10','simple.jpg','philip@aaxischina.com','1'),
('BC000018','Aaxis - 791','price9900792','200','simple.jpg','philip@aaxischina.com','1'),
('BC000019','Aaxis - 794','price9900795','10','simple.jpg','philip@aaxischina.com','1'),
('BC000020','Aaxis - 797','price9900798','200','simple.jpg','philip@aaxischina.com','1');
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
('SC000001','Snack Co. 800','philip@aaxischina.com','simple.jpg','x.doc','1'),
('SC000002','Snack Co. 801','philip@aaxischina.com','simple.jpg','x.doc','1'),
('SC000003','Snack Co. 802','philip@aaxischina.com','simple.jpg','x.doc','1'),
('SC000004','Snack Co. 803','philip@aaxischina.com','simple.jpg','x.doc','1'),
('SC000005','Snack Co. 804','philip@aaxischina.com','simple.jpg','x.doc','1'),
('SC000006','Snack Co. 805','philip@aaxischina.com','simple.jpg','x.doc','1'),
('SC000007','Snack Co. 806','philip@aaxischina.com','simple.jpg','x.doc','1'),
('SC000008','Snack Co. 807','philip@aaxischina.com','simple.jpg','x.doc','1'),
('SC000009','Snack Co. 808','philip@aaxischina.com','simple.jpg','x.doc','1'),
('SC000010','Snack Co. 809','philip@aaxischina.com','simple.jpg','x.doc','1'),
('SC000011','Snack Co. 810','philip@aaxischina.com','simple.jpg','x.doc','1'),
('SC000012','Snack Co. 811','philip@aaxischina.com','simple.jpg','x.doc','1'),
('SC000013','Snack Co. 812','philip@aaxischina.com','simple.jpg','x.doc','1'),
('SC000014','Snack Co. 813','philip@aaxischina.com','simple.jpg','x.doc','1'),
('SC000015','Snack Co. 814','philip@aaxischina.com','simple.jpg','x.doc','1'),
('SC000016','Snack Co. 815','philip@aaxischina.com','simple.jpg','x.doc','1'),
('SC000017','Snack Co. 816','philip@aaxischina.com','simple.jpg','x.doc','1'),
('SC000018','Snack Co. 817','philip@aaxischina.com','simple.jpg','x.doc','1'),
('SC000019','Snack Co. 818','philip@aaxischina.com','simple.jpg','x.doc','1'),
('SC000020','Snack Co. 819','philip@aaxischina.com','simple.jpg','x.doc','1');
drop table  if exists cost_center_data;
create table cost_center_data (
	id	  	varchar(48) not null,
	name	  	varchar(72),
	belongs_to	  	varchar(48),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into cost_center_data values
('CC000001','Cost Center - HR820','BC000003','1'),
('CC000002','Cost Center - HR821','BC000001','1'),
('CC000003','Cost Center - HR822','BC000001','1'),
('CC000004','Cost Center - HR823','BC000004','1'),
('CC000005','Cost Center - HR824','BC000003','1'),
('CC000006','Cost Center - HR825','BC000005','1'),
('CC000007','Cost Center - HR826','BC000001','1'),
('CC000008','Cost Center - HR827','BC000004','1'),
('CC000009','Cost Center - HR828','BC000004','1'),
('CC000010','Cost Center - HR829','BC000005','1'),
('CC000011','Cost Center - HR830','BC000002','1'),
('CC000012','Cost Center - HR831','BC000002','1'),
('CC000013','Cost Center - HR832','BC000002','1'),
('CC000014','Cost Center - HR833','BC000005','1'),
('CC000015','Cost Center - HR834','BC000001','1'),
('CC000016','Cost Center - HR835','BC000002','1'),
('CC000017','Cost Center - HR836','BC000002','1'),
('CC000018','Cost Center - HR837','BC000004','1'),
('CC000019','Cost Center - HR838','BC000002','1'),
('CC000020','Cost Center - HR839','BC000004','1');
drop table  if exists profit_center_data;
create table profit_center_data (
	id	  	varchar(48) not null,
	name	  	varchar(72),
	belongs_to	  	varchar(48),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into profit_center_data values
('PC000001','Cost Center - HR840','SC000005','1'),
('PC000002','Cost Center - HR841','SC000005','1'),
('PC000003','Cost Center - HR842','SC000005','1'),
('PC000004','Cost Center - HR843','SC000004','1'),
('PC000005','Cost Center - HR844','SC000003','1'),
('PC000006','Cost Center - HR845','SC000001','1'),
('PC000007','Cost Center - HR846','SC000002','1'),
('PC000008','Cost Center - HR847','SC000004','1'),
('PC000009','Cost Center - HR848','SC000003','1'),
('PC000010','Cost Center - HR849','SC000001','1'),
('PC000011','Cost Center - HR850','SC000005','1'),
('PC000012','Cost Center - HR851','SC000005','1'),
('PC000013','Cost Center - HR852','SC000001','1'),
('PC000014','Cost Center - HR853','SC000003','1'),
('PC000015','Cost Center - HR854','SC000002','1'),
('PC000016','Cost Center - HR855','SC000004','1'),
('PC000017','Cost Center - HR856','SC000001','1'),
('PC000018','Cost Center - HR857','SC000002','1'),
('PC000019','Cost Center - HR858','SC000001','1'),
('PC000020','Cost Center - HR859','SC000004','1');
drop table  if exists credit_account_data;
create table credit_account_data (
	id	  	varchar(48) not null,
	name	  	varchar(96),
	buyer	  	varchar(48),
	seller	  	varchar(48),
	authorized	  	numeric(9,2),
	remain	  	numeric(9,2),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into credit_account_data values
('CA000001','Main Account Payable - 860','BC000004','SC000005','58897.93','76043.37','1'),
('CA000002','Main Account Payable - 861','BC000003','SC000003','53067.39','1673.39','1'),
('CA000003','Main Account Payable - 862','BC000003','SC000003','74409.17','91815.24','1'),
('CA000004','Main Account Payable - 863','BC000001','SC000003','49639.40','87557.20','1'),
('CA000005','Main Account Payable - 864','BC000002','SC000001','20731.61','31060.37','1'),
('CA000006','Main Account Payable - 865','BC000004','SC000003','17813.20','69286.95','1'),
('CA000007','Main Account Payable - 866','BC000005','SC000001','20034.21','1510.38','1'),
('CA000008','Main Account Payable - 867','BC000001','SC000003','76158.90','84046.66','1'),
('CA000009','Main Account Payable - 868','BC000005','SC000005','59652.28','73473.11','1'),
('CA000010','Main Account Payable - 869','BC000002','SC000001','57950.97','54411.24','1'),
('CA000011','Main Account Payable - 870','BC000001','SC000003','42361.84','59507.22','1'),
('CA000012','Main Account Payable - 871','BC000001','SC000002','33709.87','47784.51','1'),
('CA000013','Main Account Payable - 872','BC000001','SC000002','69364.88','62897.00','1'),
('CA000014','Main Account Payable - 873','BC000005','SC000002','89687.11','45053.69','1'),
('CA000015','Main Account Payable - 874','BC000003','SC000001','96211.68','19519.43','1'),
('CA000016','Main Account Payable - 875','BC000005','SC000005','90035.49','30578.92','1'),
('CA000017','Main Account Payable - 876','BC000001','SC000003','76905.37','32730.51','1'),
('CA000018','Main Account Payable - 877','BC000004','SC000001','25404.87','90624.02','1'),
('CA000019','Main Account Payable - 878','BC000003','SC000001','86418.12','75866.17','1'),
('CA000020','Main Account Payable - 879','BC000003','SC000005','25688.62','82333.52','1');
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
('SA000001','1900 AVE OF THE STARTS - 880','Suite 555 - 881','Century City - 882','VA','US884','1'),
('SA000002','1900 AVE OF THE STARTS - 885','Suite 555 - 886','Century City - 887','CA','US889','1'),
('SA000003','1900 AVE OF THE STARTS - 890','Suite 555 - 891','Century City - 892','LA','US894','1'),
('SA000004','1900 AVE OF THE STARTS - 895','Suite 555 - 896','Century City - 897','WA','US899','1'),
('SA000005','1900 AVE OF THE STARTS - 900','Suite 555 - 901','Century City - 902','PA','US904','1'),
('SA000006','1900 AVE OF THE STARTS - 905','Suite 555 - 906','Century City - 907','MA','US909','1'),
('SA000007','1900 AVE OF THE STARTS - 910','Suite 555 - 911','Century City - 912','VA','US914','1'),
('SA000008','1900 AVE OF THE STARTS - 915','Suite 555 - 916','Century City - 917','CA','US919','1'),
('SA000009','1900 AVE OF THE STARTS - 920','Suite 555 - 921','Century City - 922','LA','US924','1'),
('SA000010','1900 AVE OF THE STARTS - 925','Suite 555 - 926','Century City - 927','WA','US929','1'),
('SA000011','1900 AVE OF THE STARTS - 930','Suite 555 - 931','Century City - 932','PA','US934','1'),
('SA000012','1900 AVE OF THE STARTS - 935','Suite 555 - 936','Century City - 937','MA','US939','1'),
('SA000013','1900 AVE OF THE STARTS - 940','Suite 555 - 941','Century City - 942','VA','US944','1'),
('SA000014','1900 AVE OF THE STARTS - 945','Suite 555 - 946','Century City - 947','CA','US949','1'),
('SA000015','1900 AVE OF THE STARTS - 950','Suite 555 - 951','Century City - 952','LA','US954','1'),
('SA000016','1900 AVE OF THE STARTS - 955','Suite 555 - 956','Century City - 957','WA','US959','1'),
('SA000017','1900 AVE OF THE STARTS - 960','Suite 555 - 961','Century City - 962','PA','US964','1'),
('SA000018','1900 AVE OF THE STARTS - 965','Suite 555 - 966','Century City - 967','MA','US969','1'),
('SA000019','1900 AVE OF THE STARTS - 970','Suite 555 - 971','Century City - 972','VA','US974','1'),
('SA000020','1900 AVE OF THE STARTS - 975','Suite 555 - 976','Century City - 977','CA','US979','1');
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
('BA000001','BC000003','1900 AVE OF THE STARTS - 980','Suite 555 - 981','Century City - 982','LA','US984','1'),
('BA000002','BC000001','1900 AVE OF THE STARTS - 985','Suite 555 - 986','Century City - 987','WA','US989','1'),
('BA000003','BC000005','1900 AVE OF THE STARTS - 990','Suite 555 - 991','Century City - 992','PA','US994','1'),
('BA000004','BC000001','1900 AVE OF THE STARTS - 995','Suite 555 - 996','Century City - 997','MA','US999','1'),
('BA000005','BC000005','1900 AVE OF THE STARTS - 1000','Suite 555 - 1001','Century City - 1002','VA','US1004','1'),
('BA000006','BC000001','1900 AVE OF THE STARTS - 1005','Suite 555 - 1006','Century City - 1007','CA','US1009','1'),
('BA000007','BC000005','1900 AVE OF THE STARTS - 1010','Suite 555 - 1011','Century City - 1012','LA','US1014','1'),
('BA000008','BC000001','1900 AVE OF THE STARTS - 1015','Suite 555 - 1016','Century City - 1017','WA','US1019','1'),
('BA000009','BC000001','1900 AVE OF THE STARTS - 1020','Suite 555 - 1021','Century City - 1022','PA','US1024','1'),
('BA000010','BC000005','1900 AVE OF THE STARTS - 1025','Suite 555 - 1026','Century City - 1027','MA','US1029','1'),
('BA000011','BC000004','1900 AVE OF THE STARTS - 1030','Suite 555 - 1031','Century City - 1032','VA','US1034','1'),
('BA000012','BC000003','1900 AVE OF THE STARTS - 1035','Suite 555 - 1036','Century City - 1037','CA','US1039','1'),
('BA000013','BC000005','1900 AVE OF THE STARTS - 1040','Suite 555 - 1041','Century City - 1042','LA','US1044','1'),
('BA000014','BC000005','1900 AVE OF THE STARTS - 1045','Suite 555 - 1046','Century City - 1047','WA','US1049','1'),
('BA000015','BC000003','1900 AVE OF THE STARTS - 1050','Suite 555 - 1051','Century City - 1052','PA','US1054','1'),
('BA000016','BC000002','1900 AVE OF THE STARTS - 1055','Suite 555 - 1056','Century City - 1057','MA','US1059','1'),
('BA000017','BC000005','1900 AVE OF THE STARTS - 1060','Suite 555 - 1061','Century City - 1062','VA','US1064','1'),
('BA000018','BC000001','1900 AVE OF THE STARTS - 1065','Suite 555 - 1066','Century City - 1067','CA','US1069','1'),
('BA000019','BC000003','1900 AVE OF THE STARTS - 1070','Suite 555 - 1071','Century City - 1072','LA','US1074','1'),
('BA000020','BC000004','1900 AVE OF THE STARTS - 1075','Suite 555 - 1076','Century City - 1077','WA','US1079','1');
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
('E000001','Philip1080','BC000005','philip@aaxischina.com','*******','13878786655','1'),
('E000002','Philip1081','BC000001','philip@aaxischina.com','*******','13878786655','1'),
('E000003','Philip1082','BC000003','philip@aaxischina.com','*******','13878786655','1'),
('E000004','Philip1083','BC000001','philip@aaxischina.com','*******','13878786655','1'),
('E000005','Philip1084','BC000003','philip@aaxischina.com','*******','13878786655','1'),
('E000006','Philip1085','BC000004','philip@aaxischina.com','*******','13878786655','1'),
('E000007','Philip1086','BC000005','philip@aaxischina.com','*******','13878786655','1'),
('E000008','Philip1087','BC000001','philip@aaxischina.com','*******','13878786655','1'),
('E000009','Philip1088','BC000004','philip@aaxischina.com','*******','13878786655','1'),
('E000010','Philip1089','BC000003','philip@aaxischina.com','*******','13878786655','1'),
('E000011','Philip1090','BC000003','philip@aaxischina.com','*******','13878786655','1'),
('E000012','Philip1091','BC000001','philip@aaxischina.com','*******','13878786655','1'),
('E000013','Philip1092','BC000001','philip@aaxischina.com','*******','13878786655','1'),
('E000014','Philip1093','BC000005','philip@aaxischina.com','*******','13878786655','1'),
('E000015','Philip1094','BC000004','philip@aaxischina.com','*******','13878786655','1'),
('E000016','Philip1095','BC000004','philip@aaxischina.com','*******','13878786655','1'),
('E000017','Philip1096','BC000002','philip@aaxischina.com','*******','13878786655','1'),
('E000018','Philip1097','BC000002','philip@aaxischina.com','*******','13878786655','1'),
('E000019','Philip1098','BC000003','philip@aaxischina.com','*******','13878786655','1'),
('E000020','Philip1099','BC000001','philip@aaxischina.com','*******','13878786655','1');
drop table  if exists role_data;
create table role_data (
	id	  	varchar(48) not null,
	role_name	  	varchar(32),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into role_data values
('R000001','manager1100','1'),
('R000002','manager1101','1'),
('R000003','manager1102','1'),
('R000004','manager1103','1'),
('R000005','manager1104','1'),
('R000006','manager1105','1'),
('R000007','manager1106','1'),
('R000008','manager1107','1'),
('R000009','manager1108','1'),
('R000010','manager1109','1'),
('R000011','manager1110','1'),
('R000012','manager1111','1'),
('R000013','manager1112','1'),
('R000014','manager1113','1'),
('R000015','manager1114','1'),
('R000016','manager1115','1'),
('R000017','manager1116','1'),
('R000018','manager1117','1'),
('R000019','manager1118','1'),
('R000020','manager1119','1');
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
('A000001','E000002','A000001','2015-01-06','1'),
('A000002','E000004','A000005','2018-11-25','1'),
('A000003','E000003','A000002','2016-03-29','1'),
('A000004','E000004','A000005','2015-09-30','1'),
('A000005','E000005','A000001','2014-12-07','1'),
('A000006','E000003','A000001','2015-07-31','1'),
('A000007','E000001','A000005','2018-02-17','1'),
('A000008','E000001','A000005','2014-09-08','1'),
('A000009','E000003','A000001','2015-04-19','1'),
('A000010','E000001','A000005','2014-03-28','1'),
('A000011','E000002','A000001','2016-11-06','1'),
('A000012','E000003','A000001','2016-01-02','1'),
('A000013','E000002','A000003','2015-04-28','1'),
('A000014','E000004','A000003','2017-03-02','1'),
('A000015','E000005','A000002','2016-11-20','1'),
('A000016','E000002','A000005','2016-08-01','1'),
('A000017','E000002','A000004','2014-01-25','1'),
('A000018','E000004','A000004','2015-11-24','1'),
('A000019','E000003','A000004','2018-11-22','1'),
('A000020','E000004','A000003','2015-08-06','1');
drop table  if exists access_data;
create table access_data (
	id	  	varchar(48) not null,
	role_name	  	varchar(40),
	role	  	varchar(48),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into access_data values
('A000001','x manager1120','R000002','1'),
('A000002','x manager1121','R000005','1'),
('A000003','x manager1122','R000001','1'),
('A000004','x manager1123','R000002','1'),
('A000005','x manager1124','R000003','1'),
('A000006','x manager1125','R000003','1'),
('A000007','x manager1126','R000002','1'),
('A000008','x manager1127','R000003','1'),
('A000009','x manager1128','R000002','1'),
('A000010','x manager1129','R000004','1'),
('A000011','x manager1130','R000002','1'),
('A000012','x manager1131','R000004','1'),
('A000013','x manager1132','R000005','1'),
('A000014','x manager1133','R000002','1'),
('A000015','x manager1134','R000005','1'),
('A000016','x manager1135','R000003','1'),
('A000017','x manager1136','R000004','1'),
('A000018','x manager1137','R000005','1'),
('A000019','x manager1138','R000003','1'),
('A000020','x manager1139','R000005','1');
drop table  if exists order_data;
create table order_data (
	id	  	varchar(48) not null,
	buyer	  	varchar(48),
	seller	  	varchar(48),
	title	  	varchar(72),
	cost_center	  	varchar(48),
	profit_center	  	varchar(48),
	total_amount	  	numeric(13,2),
	type	  	varchar(32),
	mark_as_delete	  	int,
	confirmation	  	varchar(48),
	approval	  	varchar(48),
	processing	  	varchar(48),
	shipment	  	varchar(48),
	delivery	  	varchar(48),
	recurring_info	  	varchar(48),
	status	  	varchar(168),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into order_data values
('O000001','BC000001','SC000001','House Buiding - 1140','CC000001','PC000003','1903664263.77','QUOTE','1','C000004','A000001','P000005','S000004','D000005','RI000001','auth;confirm,cancel;approve,reject(auth);1142','1'),
('O000002','BC000005','SC000004','House Buiding - 1143','CC000003','PC000001','876710981.93','QUOTE','1','C000003','A000003','P000001','S000005','D000005','RI000004','auth;confirm,cancel;approve,reject(auth);1145','1'),
('O000003','BC000005','SC000003','House Buiding - 1146','CC000005','PC000004','1641885871.59','QUOTE','1','C000002','A000005','P000003','S000005','D000005','RI000002','auth;confirm,cancel;approve,reject(auth);1148','1'),
('O000004','BC000001','SC000004','House Buiding - 1149','CC000005','PC000002','483971937.91','QUOTE','1','C000002','A000003','P000005','S000005','D000001','RI000001','auth;confirm,cancel;approve,reject(auth);1151','1'),
('O000005','BC000004','SC000001','House Buiding - 1152','CC000005','PC000004','2555427112.94','QUOTE','1','C000002','A000005','P000001','S000001','D000005','RI000003','auth;confirm,cancel;approve,reject(auth);1154','1'),
('O000006','BC000005','SC000001','House Buiding - 1155','CC000002','PC000004','943913652.48','QUOTE','1','C000005','A000001','P000001','S000001','D000005','RI000003','auth;confirm,cancel;approve,reject(auth);1157','1'),
('O000007','BC000004','SC000001','House Buiding - 1158','CC000002','PC000002','261815215.55','QUOTE','1','C000001','A000001','P000002','S000002','D000001','RI000005','auth;confirm,cancel;approve,reject(auth);1160','1'),
('O000008','BC000004','SC000004','House Buiding - 1161','CC000001','PC000001','2281141519.75','QUOTE','1','C000004','A000003','P000004','S000002','D000002','RI000004','auth;confirm,cancel;approve,reject(auth);1163','1'),
('O000009','BC000001','SC000001','House Buiding - 1164','CC000003','PC000005','554957224.78','QUOTE','1','C000002','A000002','P000004','S000002','D000004','RI000002','auth;confirm,cancel;approve,reject(auth);1166','1'),
('O000010','BC000002','SC000003','House Buiding - 1167','CC000003','PC000004','1070435492.59','QUOTE','1','C000005','A000001','P000001','S000003','D000004','RI000002','auth;confirm,cancel;approve,reject(auth);1169','1'),
('O000011','BC000003','SC000005','House Buiding - 1170','CC000005','PC000003','1900367183.47','QUOTE','1','C000002','A000003','P000001','S000005','D000001','RI000003','auth;confirm,cancel;approve,reject(auth);1172','1'),
('O000012','BC000002','SC000001','House Buiding - 1173','CC000003','PC000003','946973583.55','QUOTE','1','C000001','A000001','P000003','S000003','D000003','RI000002','auth;confirm,cancel;approve,reject(auth);1175','1'),
('O000013','BC000001','SC000004','House Buiding - 1176','CC000005','PC000002','1946054118.81','QUOTE','1','C000004','A000003','P000001','S000003','D000004','RI000001','auth;confirm,cancel;approve,reject(auth);1178','1'),
('O000014','BC000003','SC000001','House Buiding - 1179','CC000005','PC000001','1503779836.59','QUOTE','1','C000001','A000002','P000001','S000005','D000002','RI000002','auth;confirm,cancel;approve,reject(auth);1181','1'),
('O000015','BC000002','SC000002','House Buiding - 1182','CC000004','PC000004','109862363.70','QUOTE','1','C000004','A000003','P000005','S000004','D000003','RI000005','auth;confirm,cancel;approve,reject(auth);1184','1'),
('O000016','BC000002','SC000005','House Buiding - 1185','CC000001','PC000004','2122147972.60','QUOTE','1','C000005','A000003','P000001','S000002','D000005','RI000002','auth;confirm,cancel;approve,reject(auth);1187','1'),
('O000017','BC000002','SC000003','House Buiding - 1188','CC000005','PC000004','1943267454.82','QUOTE','1','C000004','A000004','P000003','S000005','D000004','RI000004','auth;confirm,cancel;approve,reject(auth);1190','1'),
('O000018','BC000005','SC000002','House Buiding - 1191','CC000001','PC000001','1395431604.60','QUOTE','1','C000001','A000005','P000001','S000004','D000001','RI000001','auth;confirm,cancel;approve,reject(auth);1193','1'),
('O000019','BC000005','SC000005','House Buiding - 1194','CC000005','PC000004','1248473460.80','QUOTE','1','C000003','A000002','P000004','S000003','D000003','RI000004','auth;confirm,cancel;approve,reject(auth);1196','1'),
('O000020','BC000003','SC000003','House Buiding - 1197','CC000002','PC000004','891391620.13','QUOTE','1','C000005','A000003','P000003','S000002','D000001','RI000003','auth;confirm,cancel;approve,reject(auth);1199','1');
drop table  if exists recurring_info_data;
create table recurring_info_data (
	id	  	varchar(48) not null,
	name	  	varchar(80),
	next_time	  	Date,
	cron_expr	  	varchar(32),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into recurring_info_data values
('RI000001','Order Recurring - 1200','2014-07-29','*****081201','1'),
('RI000002','Order Recurring - 1202','2014-03-31','*****081203','1'),
('RI000003','Order Recurring - 1204','2017-03-04','*****081205','1'),
('RI000004','Order Recurring - 1206','2018-02-03','*****081207','1'),
('RI000005','Order Recurring - 1208','2016-08-22','*****081209','1'),
('RI000006','Order Recurring - 1210','2018-01-21','*****081211','1'),
('RI000007','Order Recurring - 1212','2017-01-08','*****081213','1'),
('RI000008','Order Recurring - 1214','2015-07-30','*****081215','1'),
('RI000009','Order Recurring - 1216','2017-11-13','*****081217','1'),
('RI000010','Order Recurring - 1218','2014-11-25','*****081219','1'),
('RI000011','Order Recurring - 1220','2018-01-10','*****081221','1'),
('RI000012','Order Recurring - 1222','2014-05-03','*****081223','1'),
('RI000013','Order Recurring - 1224','2017-10-18','*****081225','1'),
('RI000014','Order Recurring - 1226','2016-03-16','*****081227','1'),
('RI000015','Order Recurring - 1228','2017-12-29','*****081229','1'),
('RI000016','Order Recurring - 1230','2017-11-30','*****081231','1'),
('RI000017','Order Recurring - 1232','2013-11-28','*****081233','1'),
('RI000018','Order Recurring - 1234','2014-11-14','*****081235','1'),
('RI000019','Order Recurring - 1236','2016-12-06','*****081237','1'),
('RI000020','Order Recurring - 1238','2016-08-01','*****081239','1');
drop table  if exists confirmation_data;
create table confirmation_data (
	id	  	varchar(48) not null,
	who	  	varchar(40),
	confirm_time	  	Date,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into confirmation_data values
('C000001','approver1240','2014-01-24','1'),
('C000002','approver1241','2017-09-10','1'),
('C000003','approver1242','2016-12-17','1'),
('C000004','approver1243','2017-07-11','1'),
('C000005','approver1244','2016-12-07','1'),
('C000006','approver1245','2015-10-04','1'),
('C000007','approver1246','2015-05-08','1'),
('C000008','approver1247','2014-03-03','1'),
('C000009','approver1248','2015-10-11','1'),
('C000010','approver1249','2013-12-06','1'),
('C000011','approver1250','2014-03-20','1'),
('C000012','approver1251','2015-10-16','1'),
('C000013','approver1252','2018-06-20','1'),
('C000014','approver1253','2018-02-03','1'),
('C000015','approver1254','2015-08-20','1'),
('C000016','approver1255','2016-07-21','1'),
('C000017','approver1256','2015-06-11','1'),
('C000018','approver1257','2013-08-06','1'),
('C000019','approver1258','2014-08-28','1'),
('C000020','approver1259','2016-04-11','1');
drop table  if exists shipment_data;
create table shipment_data (
	id	  	varchar(48) not null,
	who	  	varchar(32),
	ship_time	  	Date,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into shipment_data values
('S000001','carrier1260','2017-06-04','1'),
('S000002','carrier1261','2016-01-20','1'),
('S000003','carrier1262','2015-08-20','1'),
('S000004','carrier1263','2013-07-24','1'),
('S000005','carrier1264','2016-08-06','1'),
('S000006','carrier1265','2015-12-19','1'),
('S000007','carrier1266','2013-12-16','1'),
('S000008','carrier1267','2015-05-27','1'),
('S000009','carrier1268','2017-09-25','1'),
('S000010','carrier1269','2016-06-21','1'),
('S000011','carrier1270','2015-11-29','1'),
('S000012','carrier1271','2016-02-03','1'),
('S000013','carrier1272','2015-06-05','1'),
('S000014','carrier1273','2014-03-10','1'),
('S000015','carrier1274','2013-12-18','1'),
('S000016','carrier1275','2016-11-11','1'),
('S000017','carrier1276','2014-04-23','1'),
('S000018','carrier1277','2016-05-01','1'),
('S000019','carrier1278','2018-02-19','1'),
('S000020','carrier1279','2016-11-11','1');
drop table  if exists delivery_data;
create table delivery_data (
	id	  	varchar(48) not null,
	who	  	varchar(40),
	delivery_time	  	Date,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into delivery_data values
('D000001','deliverer1280','2016-07-14','1'),
('D000002','deliverer1281','2018-04-01','1'),
('D000003','deliverer1282','2016-07-30','1'),
('D000004','deliverer1283','2015-01-08','1'),
('D000005','deliverer1284','2014-05-01','1'),
('D000006','deliverer1285','2013-12-16','1'),
('D000007','deliverer1286','2014-08-04','1'),
('D000008','deliverer1287','2016-09-05','1'),
('D000009','deliverer1288','2015-08-16','1'),
('D000010','deliverer1289','2013-08-07','1'),
('D000011','deliverer1290','2016-08-16','1'),
('D000012','deliverer1291','2018-05-01','1'),
('D000013','deliverer1292','2017-03-25','1'),
('D000014','deliverer1293','2015-07-28','1'),
('D000015','deliverer1294','2014-10-19','1'),
('D000016','deliverer1295','2018-03-22','1'),
('D000017','deliverer1296','2017-11-21','1'),
('D000018','deliverer1297','2017-07-25','1'),
('D000019','deliverer1298','2015-05-23','1'),
('D000020','deliverer1299','2015-07-10','1');
drop table  if exists processing_data;
create table processing_data (
	id	  	varchar(48) not null,
	who	  	varchar(40),
	process_time	  	Date,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into processing_data values
('P000001','processor1300','2017-11-12','1'),
('P000002','processor1301','2015-01-03','1'),
('P000003','processor1302','2016-10-08','1'),
('P000004','processor1303','2015-06-21','1'),
('P000005','processor1304','2017-06-05','1'),
('P000006','processor1305','2017-02-23','1'),
('P000007','processor1306','2017-11-27','1'),
('P000008','processor1307','2018-02-03','1'),
('P000009','processor1308','2013-09-21','1'),
('P000010','processor1309','2015-09-05','1'),
('P000011','processor1310','2016-05-08','1'),
('P000012','processor1311','2018-02-18','1'),
('P000013','processor1312','2013-12-30','1'),
('P000014','processor1313','2017-09-26','1'),
('P000015','processor1314','2018-02-18','1'),
('P000016','processor1315','2014-05-12','1'),
('P000017','processor1316','2018-02-26','1'),
('P000018','processor1317','2015-02-13','1'),
('P000019','processor1318','2014-08-14','1'),
('P000020','processor1319','2016-10-14','1');
drop table  if exists approval_data;
create table approval_data (
	id	  	varchar(48) not null,
	who	  	varchar(40),
	approve_time	  	Date,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into approval_data values
('A000001','approver1320','2014-11-03','1'),
('A000002','approver1321','2013-11-16','1'),
('A000003','approver1322','2017-08-02','1'),
('A000004','approver1323','2016-02-17','1'),
('A000005','approver1324','2018-01-20','1'),
('A000006','approver1325','2013-09-10','1'),
('A000007','approver1326','2014-05-31','1'),
('A000008','approver1327','2015-07-13','1'),
('A000009','approver1328','2015-07-06','1'),
('A000010','approver1329','2014-02-15','1'),
('A000011','approver1330','2014-02-06','1'),
('A000012','approver1331','2015-08-28','1'),
('A000013','approver1332','2015-05-05','1'),
('A000014','approver1333','2015-04-15','1'),
('A000015','approver1334','2018-05-12','1'),
('A000016','approver1335','2015-05-23','1'),
('A000017','approver1336','2014-11-01','1'),
('A000018','approver1337','2013-08-13','1'),
('A000019','approver1338','2013-10-08','1'),
('A000020','approver1339','2016-07-29','1');
drop table  if exists line_item_data;
create table line_item_data (
	id	  	varchar(48) not null,
	biz_order	  	varchar(48),
	sku_id	  	varchar(16),
	sku_name	  	varchar(40),
	amount	  	numeric(6,2),
	quantity	  	int,
	active	  	int,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into line_item_data values
('LI000001','O000001','SKU1340','iPhone - 1341','21.13','3','1','1'),
('LI000002','O000001','SKU1342','iPhone - 1343','14.64','10','1','1'),
('LI000003','O000004','SKU1344','iPhone - 1345','22.25','9','1','1'),
('LI000004','O000001','SKU1346','iPhone - 1347','7.30','10','1','1'),
('LI000005','O000001','SKU1348','iPhone - 1349','11.47','3','1','1'),
('LI000006','O000005','SKU1350','iPhone - 1351','22.98','10','1','1'),
('LI000007','O000004','SKU1352','iPhone - 1353','9.89','6','1','1'),
('LI000008','O000004','SKU1354','iPhone - 1355','21.38','10','1','1'),
('LI000009','O000003','SKU1356','iPhone - 1357','9.88','5','1','1'),
('LI000010','O000002','SKU1358','iPhone - 1359','16.57','8','1','1'),
('LI000011','O000002','SKU1360','iPhone - 1361','2.67','5','1','1'),
('LI000012','O000001','SKU1362','iPhone - 1363','4.50','7','1','1'),
('LI000013','O000003','SKU1364','iPhone - 1365','22.34','7','1','1'),
('LI000014','O000001','SKU1366','iPhone - 1367','17.54','4','1','1'),
('LI000015','O000003','SKU1368','iPhone - 1369','13.05','2','1','1'),
('LI000016','O000002','SKU1370','iPhone - 1371','9.13','7','1','1'),
('LI000017','O000004','SKU1372','iPhone - 1373','9.35','4','1','1'),
('LI000018','O000004','SKU1374','iPhone - 1375','0.05','5','1','1'),
('LI000019','O000005','SKU1376','iPhone - 1377','22.43','3','1','1'),
('LI000020','O000001','SKU1378','iPhone - 1379','15.30','6','1','1');
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
('SG000001','shipping to this address1380','O000003','SA000003','0.10','1'),
('SG000002','shipping to this address1381','O000002','SA000004','5.79','1'),
('SG000003','shipping to this address1382','O000005','SA000004','0.72','1'),
('SG000004','shipping to this address1383','O000001','SA000005','0.42','1'),
('SG000005','shipping to this address1384','O000005','SA000002','1.70','1'),
('SG000006','shipping to this address1385','O000005','SA000005','3.85','1'),
('SG000007','shipping to this address1386','O000005','SA000004','1.19','1'),
('SG000008','shipping to this address1387','O000001','SA000001','3.11','1'),
('SG000009','shipping to this address1388','O000002','SA000001','1.86','1'),
('SG000010','shipping to this address1389','O000005','SA000003','1.12','1'),
('SG000011','shipping to this address1390','O000005','SA000002','1.65','1'),
('SG000012','shipping to this address1391','O000001','SA000004','0.97','1'),
('SG000013','shipping to this address1392','O000003','SA000001','3.93','1'),
('SG000014','shipping to this address1393','O000005','SA000003','4.36','1'),
('SG000015','shipping to this address1394','O000001','SA000005','2.69','1'),
('SG000016','shipping to this address1395','O000002','SA000002','2.48','1'),
('SG000017','shipping to this address1396','O000001','SA000003','1.64','1'),
('SG000018','shipping to this address1397','O000002','SA000005','3.19','1'),
('SG000019','shipping to this address1398','O000005','SA000001','2.21','1'),
('SG000020','shipping to this address1399','O000005','SA000005','3.80','1');
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
('PG000001','visa card ending - 1400','O000003','4111 1111 1111 - 1401','BA000005','1'),
('PG000002','visa card ending - 1402','O000003','4111 1111 1111 - 1403','BA000004','1'),
('PG000003','visa card ending - 1404','O000005','4111 1111 1111 - 1405','BA000004','1'),
('PG000004','visa card ending - 1406','O000001','4111 1111 1111 - 1407','BA000004','1'),
('PG000005','visa card ending - 1408','O000004','4111 1111 1111 - 1409','BA000001','1'),
('PG000006','visa card ending - 1410','O000005','4111 1111 1111 - 1411','BA000004','1'),
('PG000007','visa card ending - 1412','O000003','4111 1111 1111 - 1413','BA000004','1'),
('PG000008','visa card ending - 1414','O000003','4111 1111 1111 - 1415','BA000001','1'),
('PG000009','visa card ending - 1416','O000002','4111 1111 1111 - 1417','BA000002','1'),
('PG000010','visa card ending - 1418','O000004','4111 1111 1111 - 1419','BA000002','1'),
('PG000011','visa card ending - 1420','O000002','4111 1111 1111 - 1421','BA000004','1'),
('PG000012','visa card ending - 1422','O000003','4111 1111 1111 - 1423','BA000003','1'),
('PG000013','visa card ending - 1424','O000002','4111 1111 1111 - 1425','BA000001','1'),
('PG000014','visa card ending - 1426','O000002','4111 1111 1111 - 1427','BA000002','1'),
('PG000015','visa card ending - 1428','O000004','4111 1111 1111 - 1429','BA000001','1'),
('PG000016','visa card ending - 1430','O000001','4111 1111 1111 - 1431','BA000005','1'),
('PG000017','visa card ending - 1432','O000005','4111 1111 1111 - 1433','BA000003','1'),
('PG000018','visa card ending - 1434','O000005','4111 1111 1111 - 1435','BA000004','1'),
('PG000019','visa card ending - 1436','O000004','4111 1111 1111 - 1437','BA000002','1'),
('PG000020','visa card ending - 1438','O000004','4111 1111 1111 - 1439','BA000004','1');
drop table  if exists cust_svc_rep_data;
create table cust_svc_rep_data (
	id	  	varchar(48) not null,
	email	  	varchar(88),
	passwd	  	varchar(32),
	role	  	varchar(48),
	company	  	varchar(48),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into cust_svc_rep_data values
('CSR000001','pzhang@aaxischina.com','*******','R000005','SC000003','1'),
('CSR000002','pzhang@aaxischina.com','*******','R000001','SC000001','1'),
('CSR000003','pzhang@aaxischina.com','*******','R000005','SC000001','1'),
('CSR000004','pzhang@aaxischina.com','*******','R000004','SC000001','1'),
('CSR000005','pzhang@aaxischina.com','*******','R000001','SC000003','1'),
('CSR000006','pzhang@aaxischina.com','*******','R000005','SC000001','1'),
('CSR000007','pzhang@aaxischina.com','*******','R000004','SC000004','1'),
('CSR000008','pzhang@aaxischina.com','*******','R000003','SC000004','1'),
('CSR000009','pzhang@aaxischina.com','*******','R000004','SC000005','1'),
('CSR000010','pzhang@aaxischina.com','*******','R000001','SC000003','1'),
('CSR000011','pzhang@aaxischina.com','*******','R000001','SC000004','1'),
('CSR000012','pzhang@aaxischina.com','*******','R000005','SC000002','1'),
('CSR000013','pzhang@aaxischina.com','*******','R000005','SC000001','1'),
('CSR000014','pzhang@aaxischina.com','*******','R000005','SC000004','1'),
('CSR000015','pzhang@aaxischina.com','*******','R000003','SC000003','1'),
('CSR000016','pzhang@aaxischina.com','*******','R000004','SC000005','1'),
('CSR000017','pzhang@aaxischina.com','*******','R000003','SC000005','1'),
('CSR000018','pzhang@aaxischina.com','*******','R000004','SC000005','1'),
('CSR000019','pzhang@aaxischina.com','*******','R000002','SC000001','1'),
('CSR000020','pzhang@aaxischina.com','*******','R000003','SC000003','1');
drop table  if exists action_data;
create table action_data (
	id	  	varchar(48) not null,
	name	  	varchar(32),
	internal_name	  	varchar(24),
	bo	  	varchar(48),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into action_data values
('A000001','ACTION1440','load1441','O000001','1'),
('A000002','ACTION1442','load1443','O000003','1'),
('A000003','ACTION1444','load1445','O000003','1'),
('A000004','ACTION1446','load1447','O000003','1'),
('A000005','ACTION1448','load1449','O000001','1'),
('A000006','ACTION1450','load1451','O000005','1'),
('A000007','ACTION1452','load1453','O000005','1'),
('A000008','ACTION1454','load1455','O000004','1'),
('A000009','ACTION1456','load1457','O000003','1'),
('A000010','ACTION1458','load1459','O000005','1'),
('A000011','ACTION1460','load1461','O000002','1'),
('A000012','ACTION1462','load1463','O000005','1'),
('A000013','ACTION1464','load1465','O000005','1'),
('A000014','ACTION1466','load1467','O000004','1'),
('A000015','ACTION1468','load1469','O000004','1'),
('A000016','ACTION1470','load1471','O000005','1'),
('A000017','ACTION1472','load1473','O000005','1'),
('A000018','ACTION1474','load1475','O000004','1'),
('A000019','ACTION1476','load1477','O000004','1'),
('A000020','ACTION1478','load1479','O000005','1');



create unique index idx_buyer_company_version on buyer_company_data(id, version);

create unique index idx_seller_company_version on seller_company_data(id, version);

create unique index idx_cost_center_version on cost_center_data(id, version);

create index idx_cost_center_belongs_to on cost_center_data(belongs_to);
alter table cost_center_data add constraint fk_cost_center_belongs_to 
	foreign key(belongs_to) references buyer_company_data(id) on delete cascade on update cascade;
create unique index idx_profit_center_version on profit_center_data(id, version);

create index idx_profit_center_belongs_to on profit_center_data(belongs_to);
alter table profit_center_data add constraint fk_profit_center_belongs_to 
	foreign key(belongs_to) references seller_company_data(id) on delete cascade on update cascade;
create unique index idx_credit_account_version on credit_account_data(id, version);

create index idx_credit_account_buyer on credit_account_data(buyer);
alter table credit_account_data add constraint fk_credit_account_buyer 
	foreign key(buyer) references buyer_company_data(id) on delete cascade on update cascade;
create index idx_credit_account_seller on credit_account_data(seller);
alter table credit_account_data add constraint fk_credit_account_seller 
	foreign key(seller) references seller_company_data(id) on delete cascade on update cascade;
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
create index idx_order_cost_center on order_data(cost_center);
alter table order_data add constraint fk_order_cost_center 
	foreign key(cost_center) references cost_center_data(id) on delete cascade on update cascade;
create index idx_order_profit_center on order_data(profit_center);
alter table order_data add constraint fk_order_profit_center 
	foreign key(profit_center) references profit_center_data(id) on delete cascade on update cascade;
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
create index idx_order_recurring_info on order_data(recurring_info);
alter table order_data add constraint fk_order_recurring_info 
	foreign key(recurring_info) references recurring_info_data(id) on delete cascade on update cascade;
create unique index idx_recurring_info_version on recurring_info_data(id, version);

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








