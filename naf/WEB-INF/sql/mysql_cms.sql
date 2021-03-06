drop database  if exists cms;
create database cms;
use cms;

drop table  if exists action_table_meta_data;
create table action_table_meta_data (
	id	  	varchar(56) not null,
	table_name	  	varchar(32),
	enabled	  	int,
	batchsize	  	int,
	description	  	varchar(104),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into action_table_meta_data values
('ATM000001','item_master_47700','1','2873','The table is for the item master to feed from to47701','1'),
('ATM000002','item_master_47702','1','4594','The table is for the item master to feed from to47703','1'),
('ATM000003','item_master_47704','1','7127','The table is for the item master to feed from to47705','1'),
('ATM000004','item_master_47706','1','4289','The table is for the item master to feed from to47707','1'),
('ATM000005','item_master_47708','1','6793','The table is for the item master to feed from to47709','1'),
('ATM000006','item_master_47710','1','8806','The table is for the item master to feed from to47711','1'),
('ATM000007','item_master_47712','1','196','The table is for the item master to feed from to47713','1'),
('ATM000008','item_master_47714','1','9398','The table is for the item master to feed from to47715','1'),
('ATM000009','item_master_47716','1','4920','The table is for the item master to feed from to47717','1'),
('ATM000010','item_master_47718','1','2603','The table is for the item master to feed from to47719','1'),
('ATM000011','item_master_47720','1','992','The table is for the item master to feed from to47721','1'),
('ATM000012','item_master_47722','1','9846','The table is for the item master to feed from to47723','1'),
('ATM000013','item_master_47724','1','5967','The table is for the item master to feed from to47725','1'),
('ATM000014','item_master_47726','1','2224','The table is for the item master to feed from to47727','1'),
('ATM000015','item_master_47728','1','2481','The table is for the item master to feed from to47729','1'),
('ATM000016','item_master_47730','1','923','The table is for the item master to feed from to47731','1'),
('ATM000017','item_master_47732','1','6851','The table is for the item master to feed from to47733','1'),
('ATM000018','item_master_47734','1','686','The table is for the item master to feed from to47735','1'),
('ATM000019','item_master_47736','1','9812','The table is for the item master to feed from to47737','1'),
('ATM000020','item_master_47738','1','4555','The table is for the item master to feed from to47739','1'),
('ATM000021','item_master_47740','1','8434','The table is for the item master to feed from to47741','1'),
('ATM000022','item_master_47742','1','1666','The table is for the item master to feed from to47743','1'),
('ATM000023','item_master_47744','1','2738','The table is for the item master to feed from to47745','1'),
('ATM000024','item_master_47746','1','8557','The table is for the item master to feed from to47747','1'),
('ATM000025','item_master_47748','1','9626','The table is for the item master to feed from to47749','1'),
('ATM000026','item_master_47750','1','1759','The table is for the item master to feed from to47751','1'),
('ATM000027','item_master_47752','1','3784','The table is for the item master to feed from to47753','1'),
('ATM000028','item_master_47754','1','7491','The table is for the item master to feed from to47755','1'),
('ATM000029','item_master_47756','1','5439','The table is for the item master to feed from to47757','1'),
('ATM000030','item_master_47758','1','1280','The table is for the item master to feed from to47759','1'),
('ATM000031','item_master_47760','1','3750','The table is for the item master to feed from to47761','1'),
('ATM000032','item_master_47762','1','8001','The table is for the item master to feed from to47763','1'),
('ATM000033','item_master_47764','1','4697','The table is for the item master to feed from to47765','1'),
('ATM000034','item_master_47766','1','4147','The table is for the item master to feed from to47767','1'),
('ATM000035','item_master_47768','1','1182','The table is for the item master to feed from to47769','1'),
('ATM000036','item_master_47770','1','513','The table is for the item master to feed from to47771','1'),
('ATM000037','item_master_47772','1','452','The table is for the item master to feed from to47773','1'),
('ATM000038','item_master_47774','1','2465','The table is for the item master to feed from to47775','1'),
('ATM000039','item_master_47776','1','9580','The table is for the item master to feed from to47777','1'),
('ATM000040','item_master_47778','1','7819','The table is for the item master to feed from to47779','1'),
('ATM000041','item_master_47780','1','679','The table is for the item master to feed from to47781','1'),
('ATM000042','item_master_47782','1','1182','The table is for the item master to feed from to47783','1'),
('ATM000043','item_master_47784','1','5505','The table is for the item master to feed from to47785','1'),
('ATM000044','item_master_47786','1','9435','The table is for the item master to feed from to47787','1'),
('ATM000045','item_master_47788','1','8530','The table is for the item master to feed from to47789','1'),
('ATM000046','item_master_47790','1','2634','The table is for the item master to feed from to47791','1'),
('ATM000047','item_master_47792','1','2282','The table is for the item master to feed from to47793','1'),
('ATM000048','item_master_47794','1','8650','The table is for the item master to feed from to47795','1'),
('ATM000049','item_master_47796','1','315','The table is for the item master to feed from to47797','1'),
('ATM000050','item_master_47798','1','9915','The table is for the item master to feed from to47799','1'),
('ATM000051','item_master_47800','1','7750','The table is for the item master to feed from to47801','1'),
('ATM000052','item_master_47802','1','6901','The table is for the item master to feed from to47803','1'),
('ATM000053','item_master_47804','1','5485','The table is for the item master to feed from to47805','1'),
('ATM000054','item_master_47806','1','1848','The table is for the item master to feed from to47807','1'),
('ATM000055','item_master_47808','1','431','The table is for the item master to feed from to47809','1'),
('ATM000056','item_master_47810','1','7546','The table is for the item master to feed from to47811','1'),
('ATM000057','item_master_47812','1','6131','The table is for the item master to feed from to47813','1'),
('ATM000058','item_master_47814','1','813','The table is for the item master to feed from to47815','1'),
('ATM000059','item_master_47816','1','6593','The table is for the item master to feed from to47817','1'),
('ATM000060','item_master_47818','1','8172','The table is for the item master to feed from to47819','1'),
('ATM000061','item_master_47820','1','4002','The table is for the item master to feed from to47821','1'),
('ATM000062','item_master_47822','1','7905','The table is for the item master to feed from to47823','1'),
('ATM000063','item_master_47824','1','1015','The table is for the item master to feed from to47825','1'),
('ATM000064','item_master_47826','1','7390','The table is for the item master to feed from to47827','1'),
('ATM000065','item_master_47828','1','678','The table is for the item master to feed from to47829','1'),
('ATM000066','item_master_47830','1','7759','The table is for the item master to feed from to47831','1'),
('ATM000067','item_master_47832','1','6728','The table is for the item master to feed from to47833','1'),
('ATM000068','item_master_47834','1','8538','The table is for the item master to feed from to47835','1'),
('ATM000069','item_master_47836','1','1356','The table is for the item master to feed from to47837','1'),
('ATM000070','item_master_47838','1','7958','The table is for the item master to feed from to47839','1'),
('ATM000071','item_master_47840','1','3682','The table is for the item master to feed from to47841','1'),
('ATM000072','item_master_47842','1','8855','The table is for the item master to feed from to47843','1'),
('ATM000073','item_master_47844','1','4764','The table is for the item master to feed from to47845','1'),
('ATM000074','item_master_47846','1','5190','The table is for the item master to feed from to47847','1'),
('ATM000075','item_master_47848','1','3171','The table is for the item master to feed from to47849','1'),
('ATM000076','item_master_47850','1','8573','The table is for the item master to feed from to47851','1'),
('ATM000077','item_master_47852','1','880','The table is for the item master to feed from to47853','1'),
('ATM000078','item_master_47854','1','2262','The table is for the item master to feed from to47855','1'),
('ATM000079','item_master_47856','1','3896','The table is for the item master to feed from to47857','1'),
('ATM000080','item_master_47858','1','9875','The table is for the item master to feed from to47859','1'),
('ATM000081','item_master_47860','1','4573','The table is for the item master to feed from to47861','1'),
('ATM000082','item_master_47862','1','6722','The table is for the item master to feed from to47863','1'),
('ATM000083','item_master_47864','1','6767','The table is for the item master to feed from to47865','1'),
('ATM000084','item_master_47866','1','928','The table is for the item master to feed from to47867','1'),
('ATM000085','item_master_47868','1','6835','The table is for the item master to feed from to47869','1'),
('ATM000086','item_master_47870','1','3134','The table is for the item master to feed from to47871','1'),
('ATM000087','item_master_47872','1','9008','The table is for the item master to feed from to47873','1'),
('ATM000088','item_master_47874','1','5073','The table is for the item master to feed from to47875','1'),
('ATM000089','item_master_47876','1','6067','The table is for the item master to feed from to47877','1'),
('ATM000090','item_master_47878','1','7087','The table is for the item master to feed from to47879','1'),
('ATM000091','item_master_47880','1','3704','The table is for the item master to feed from to47881','1'),
('ATM000092','item_master_47882','1','9889','The table is for the item master to feed from to47883','1'),
('ATM000093','item_master_47884','1','9822','The table is for the item master to feed from to47885','1'),
('ATM000094','item_master_47886','1','9695','The table is for the item master to feed from to47887','1'),
('ATM000095','item_master_47888','1','8770','The table is for the item master to feed from to47889','1'),
('ATM000096','item_master_47890','1','5118','The table is for the item master to feed from to47891','1'),
('ATM000097','item_master_47892','1','2571','The table is for the item master to feed from to47893','1'),
('ATM000098','item_master_47894','1','6716','The table is for the item master to feed from to47895','1'),
('ATM000099','item_master_47896','1','9283','The table is for the item master to feed from to47897','1'),
('ATM000100','item_master_47898','1','2401','The table is for the item master to feed from to47899','1');
drop table  if exists column_meta_data;
create table column_meta_data (
	id	  	varchar(40) not null,
	source_column	  	varchar(16),
	dest_column	  	varchar(16),
	action_table	  	varchar(64),
	type	  	varchar(16),
	length	  	int,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into column_meta_data values
('CM000001','column_47900','column_47901','ATM000004','varchar47902','7','1'),
('CM000002','column_47903','column_47904','ATM000005','varchar47905','4','1'),
('CM000003','column_47906','column_47907','ATM000005','varchar47908','6','1'),
('CM000004','column_47909','column_47910','ATM000002','varchar47911','7','1'),
('CM000005','column_47912','column_47913','ATM000001','varchar47914','2','1'),
('CM000006','column_47915','column_47916','ATM000004','varchar47917','6','1'),
('CM000007','column_47918','column_47919','ATM000002','varchar47920','3','1'),
('CM000008','column_47921','column_47922','ATM000003','varchar47923','3','1'),
('CM000009','column_47924','column_47925','ATM000003','varchar47926','8','1'),
('CM000010','column_47927','column_47928','ATM000004','varchar47929','3','1'),
('CM000011','column_47930','column_47931','ATM000003','varchar47932','6','1'),
('CM000012','column_47933','column_47934','ATM000002','varchar47935','5','1'),
('CM000013','column_47936','column_47937','ATM000001','varchar47938','5','1'),
('CM000014','column_47939','column_47940','ATM000003','varchar47941','10','1'),
('CM000015','column_47942','column_47943','ATM000001','varchar47944','4','1'),
('CM000016','column_47945','column_47946','ATM000002','varchar47947','4','1'),
('CM000017','column_47948','column_47949','ATM000002','varchar47950','6','1'),
('CM000018','column_47951','column_47952','ATM000005','varchar47953','8','1'),
('CM000019','column_47954','column_47955','ATM000003','varchar47956','6','1'),
('CM000020','column_47957','column_47958','ATM000003','varchar47959','3','1'),
('CM000021','column_47960','column_47961','ATM000005','varchar47962','9','1'),
('CM000022','column_47963','column_47964','ATM000003','varchar47965','3','1'),
('CM000023','column_47966','column_47967','ATM000004','varchar47968','9','1'),
('CM000024','column_47969','column_47970','ATM000001','varchar47971','5','1'),
('CM000025','column_47972','column_47973','ATM000002','varchar47974','9','1'),
('CM000026','column_47975','column_47976','ATM000005','varchar47977','8','1'),
('CM000027','column_47978','column_47979','ATM000002','varchar47980','9','1'),
('CM000028','column_47981','column_47982','ATM000005','varchar47983','3','1'),
('CM000029','column_47984','column_47985','ATM000001','varchar47986','10','1'),
('CM000030','column_47987','column_47988','ATM000005','varchar47989','9','1'),
('CM000031','column_47990','column_47991','ATM000005','varchar47992','6','1'),
('CM000032','column_47993','column_47994','ATM000002','varchar47995','2','1'),
('CM000033','column_47996','column_47997','ATM000001','varchar47998','4','1'),
('CM000034','column_47999','column_48000','ATM000003','varchar48001','3','1'),
('CM000035','column_48002','column_48003','ATM000001','varchar48004','9','1'),
('CM000036','column_48005','column_48006','ATM000002','varchar48007','7','1'),
('CM000037','column_48008','column_48009','ATM000002','varchar48010','9','1'),
('CM000038','column_48011','column_48012','ATM000001','varchar48013','6','1'),
('CM000039','column_48014','column_48015','ATM000005','varchar48016','2','1'),
('CM000040','column_48017','column_48018','ATM000002','varchar48019','4','1'),
('CM000041','column_48020','column_48021','ATM000005','varchar48022','8','1'),
('CM000042','column_48023','column_48024','ATM000005','varchar48025','5','1'),
('CM000043','column_48026','column_48027','ATM000001','varchar48028','6','1'),
('CM000044','column_48029','column_48030','ATM000002','varchar48031','9','1'),
('CM000045','column_48032','column_48033','ATM000003','varchar48034','3','1'),
('CM000046','column_48035','column_48036','ATM000005','varchar48037','4','1'),
('CM000047','column_48038','column_48039','ATM000002','varchar48040','6','1'),
('CM000048','column_48041','column_48042','ATM000005','varchar48043','6','1'),
('CM000049','column_48044','column_48045','ATM000002','varchar48046','7','1'),
('CM000050','column_48047','column_48048','ATM000004','varchar48049','8','1'),
('CM000051','column_48050','column_48051','ATM000004','varchar48052','3','1'),
('CM000052','column_48053','column_48054','ATM000004','varchar48055','2','1'),
('CM000053','column_48056','column_48057','ATM000001','varchar48058','2','1'),
('CM000054','column_48059','column_48060','ATM000002','varchar48061','10','1'),
('CM000055','column_48062','column_48063','ATM000004','varchar48064','1','1'),
('CM000056','column_48065','column_48066','ATM000005','varchar48067','3','1'),
('CM000057','column_48068','column_48069','ATM000005','varchar48070','5','1'),
('CM000058','column_48071','column_48072','ATM000003','varchar48073','7','1'),
('CM000059','column_48074','column_48075','ATM000001','varchar48076','7','1'),
('CM000060','column_48077','column_48078','ATM000004','varchar48079','4','1'),
('CM000061','column_48080','column_48081','ATM000001','varchar48082','8','1'),
('CM000062','column_48083','column_48084','ATM000003','varchar48085','5','1'),
('CM000063','column_48086','column_48087','ATM000005','varchar48088','6','1'),
('CM000064','column_48089','column_48090','ATM000004','varchar48091','6','1'),
('CM000065','column_48092','column_48093','ATM000001','varchar48094','7','1'),
('CM000066','column_48095','column_48096','ATM000001','varchar48097','6','1'),
('CM000067','column_48098','column_48099','ATM000002','varchar48100','6','1'),
('CM000068','column_48101','column_48102','ATM000002','varchar48103','4','1'),
('CM000069','column_48104','column_48105','ATM000002','varchar48106','2','1'),
('CM000070','column_48107','column_48108','ATM000003','varchar48109','8','1'),
('CM000071','column_48110','column_48111','ATM000005','varchar48112','7','1'),
('CM000072','column_48113','column_48114','ATM000003','varchar48115','2','1'),
('CM000073','column_48116','column_48117','ATM000005','varchar48118','8','1'),
('CM000074','column_48119','column_48120','ATM000001','varchar48121','7','1'),
('CM000075','column_48122','column_48123','ATM000001','varchar48124','4','1'),
('CM000076','column_48125','column_48126','ATM000003','varchar48127','4','1'),
('CM000077','column_48128','column_48129','ATM000004','varchar48130','10','1'),
('CM000078','column_48131','column_48132','ATM000002','varchar48133','1','1'),
('CM000079','column_48134','column_48135','ATM000002','varchar48136','7','1'),
('CM000080','column_48137','column_48138','ATM000003','varchar48139','3','1'),
('CM000081','column_48140','column_48141','ATM000005','varchar48142','1','1'),
('CM000082','column_48143','column_48144','ATM000002','varchar48145','7','1'),
('CM000083','column_48146','column_48147','ATM000004','varchar48148','9','1'),
('CM000084','column_48149','column_48150','ATM000005','varchar48151','9','1'),
('CM000085','column_48152','column_48153','ATM000001','varchar48154','6','1'),
('CM000086','column_48155','column_48156','ATM000004','varchar48157','4','1'),
('CM000087','column_48158','column_48159','ATM000002','varchar48160','10','1'),
('CM000088','column_48161','column_48162','ATM000003','varchar48163','2','1'),
('CM000089','column_48164','column_48165','ATM000001','varchar48166','4','1'),
('CM000090','column_48167','column_48168','ATM000001','varchar48169','4','1'),
('CM000091','column_48170','column_48171','ATM000003','varchar48172','3','1'),
('CM000092','column_48173','column_48174','ATM000004','varchar48175','6','1'),
('CM000093','column_48176','column_48177','ATM000002','varchar48178','5','1'),
('CM000094','column_48179','column_48180','ATM000002','varchar48181','3','1'),
('CM000095','column_48182','column_48183','ATM000002','varchar48184','7','1'),
('CM000096','column_48185','column_48186','ATM000002','varchar48187','6','1'),
('CM000097','column_48188','column_48189','ATM000001','varchar48190','2','1'),
('CM000098','column_48191','column_48192','ATM000001','varchar48193','2','1'),
('CM000099','column_48194','column_48195','ATM000005','varchar48196','7','1'),
('CM000100','column_48197','column_48198','ATM000004','varchar48199','4','1');



create unique index idx_action_table_meta_version on action_table_meta_data(id, version);

create unique index idx_column_meta_version on column_meta_data(id, version);

create index idx_column_meta_action_table on column_meta_data(action_table);
alter table column_meta_data add constraint fk_column_meta_action_table 
	foreign key(action_table) references action_table_meta_data(id) on delete cascade on update cascade;




#---------------------------end database---------------------------------





