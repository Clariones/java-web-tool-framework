drop database  if exists b2b;
create database b2b;
use b2b;

drop table  if exists buyer_company_data;
create table buyer_company_data (
	id	  	varchar(48) not null,
	name	  	varchar(40),
	price_list	  	varchar(40),
	rating	  	int,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into buyer_company_data values
('BC000001','Aaxis - 1860','price99001861','10','1'),
('BC000002','Aaxis - 1863','price99001864','200','1'),
('BC000003','Aaxis - 1866','price99001867','10','1'),
('BC000004','Aaxis - 1869','price99001870','200','1'),
('BC000005','Aaxis - 1872','price99001873','10','1'),
('BC000006','Aaxis - 1875','price99001876','200','1'),
('BC000007','Aaxis - 1878','price99001879','10','1'),
('BC000008','Aaxis - 1881','price99001882','200','1'),
('BC000009','Aaxis - 1884','price99001885','10','1'),
('BC000010','Aaxis - 1887','price99001888','200','1'),
('BC000011','Aaxis - 1890','price99001891','10','1'),
('BC000012','Aaxis - 1893','price99001894','200','1'),
('BC000013','Aaxis - 1896','price99001897','10','1'),
('BC000014','Aaxis - 1899','price99001900','200','1'),
('BC000015','Aaxis - 1902','price99001903','10','1'),
('BC000016','Aaxis - 1905','price99001906','200','1'),
('BC000017','Aaxis - 1908','price99001909','10','1'),
('BC000018','Aaxis - 1911','price99001912','200','1'),
('BC000019','Aaxis - 1914','price99001915','10','1'),
('BC000020','Aaxis - 1917','price99001918','200','1');
drop table  if exists seller_company_data;
create table seller_company_data (
	id	  	varchar(48) not null,
	name	  	varchar(48),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into seller_company_data values
('SC000001','Snack Co. 1920','1'),
('SC000002','Snack Co. 1921','1'),
('SC000003','Snack Co. 1922','1'),
('SC000004','Snack Co. 1923','1'),
('SC000005','Snack Co. 1924','1'),
('SC000006','Snack Co. 1925','1'),
('SC000007','Snack Co. 1926','1'),
('SC000008','Snack Co. 1927','1'),
('SC000009','Snack Co. 1928','1'),
('SC000010','Snack Co. 1929','1'),
('SC000011','Snack Co. 1930','1'),
('SC000012','Snack Co. 1931','1'),
('SC000013','Snack Co. 1932','1'),
('SC000014','Snack Co. 1933','1'),
('SC000015','Snack Co. 1934','1'),
('SC000016','Snack Co. 1935','1'),
('SC000017','Snack Co. 1936','1'),
('SC000018','Snack Co. 1937','1'),
('SC000019','Snack Co. 1938','1'),
('SC000020','Snack Co. 1939','1');
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
('SA000001','1900 AVE OF THE STARTS - 1940','Suite 555 - 1941','Century City - 1942','LA','US1944','1'),
('SA000002','1900 AVE OF THE STARTS - 1945','Suite 555 - 1946','Century City - 1947','WA','US1949','1'),
('SA000003','1900 AVE OF THE STARTS - 1950','Suite 555 - 1951','Century City - 1952','PA','US1954','1'),
('SA000004','1900 AVE OF THE STARTS - 1955','Suite 555 - 1956','Century City - 1957','MA','US1959','1'),
('SA000005','1900 AVE OF THE STARTS - 1960','Suite 555 - 1961','Century City - 1962','VA','US1964','1'),
('SA000006','1900 AVE OF THE STARTS - 1965','Suite 555 - 1966','Century City - 1967','CA','US1969','1'),
('SA000007','1900 AVE OF THE STARTS - 1970','Suite 555 - 1971','Century City - 1972','LA','US1974','1'),
('SA000008','1900 AVE OF THE STARTS - 1975','Suite 555 - 1976','Century City - 1977','WA','US1979','1'),
('SA000009','1900 AVE OF THE STARTS - 1980','Suite 555 - 1981','Century City - 1982','PA','US1984','1'),
('SA000010','1900 AVE OF THE STARTS - 1985','Suite 555 - 1986','Century City - 1987','MA','US1989','1'),
('SA000011','1900 AVE OF THE STARTS - 1990','Suite 555 - 1991','Century City - 1992','VA','US1994','1'),
('SA000012','1900 AVE OF THE STARTS - 1995','Suite 555 - 1996','Century City - 1997','CA','US1999','1'),
('SA000013','1900 AVE OF THE STARTS - 2000','Suite 555 - 2001','Century City - 2002','LA','US2004','1'),
('SA000014','1900 AVE OF THE STARTS - 2005','Suite 555 - 2006','Century City - 2007','WA','US2009','1'),
('SA000015','1900 AVE OF THE STARTS - 2010','Suite 555 - 2011','Century City - 2012','PA','US2014','1'),
('SA000016','1900 AVE OF THE STARTS - 2015','Suite 555 - 2016','Century City - 2017','MA','US2019','1'),
('SA000017','1900 AVE OF THE STARTS - 2020','Suite 555 - 2021','Century City - 2022','VA','US2024','1'),
('SA000018','1900 AVE OF THE STARTS - 2025','Suite 555 - 2026','Century City - 2027','CA','US2029','1'),
('SA000019','1900 AVE OF THE STARTS - 2030','Suite 555 - 2031','Century City - 2032','LA','US2034','1'),
('SA000020','1900 AVE OF THE STARTS - 2035','Suite 555 - 2036','Century City - 2037','WA','US2039','1');
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
('BA000001','BC000005','1900 AVE OF THE STARTS - 2040','Suite 555 - 2041','Century City - 2042','PA','US2044','1'),
('BA000002','BC000005','1900 AVE OF THE STARTS - 2045','Suite 555 - 2046','Century City - 2047','MA','US2049','1'),
('BA000003','BC000002','1900 AVE OF THE STARTS - 2050','Suite 555 - 2051','Century City - 2052','VA','US2054','1'),
('BA000004','BC000001','1900 AVE OF THE STARTS - 2055','Suite 555 - 2056','Century City - 2057','CA','US2059','1'),
('BA000005','BC000002','1900 AVE OF THE STARTS - 2060','Suite 555 - 2061','Century City - 2062','LA','US2064','1'),
('BA000006','BC000004','1900 AVE OF THE STARTS - 2065','Suite 555 - 2066','Century City - 2067','WA','US2069','1'),
('BA000007','BC000003','1900 AVE OF THE STARTS - 2070','Suite 555 - 2071','Century City - 2072','PA','US2074','1'),
('BA000008','BC000003','1900 AVE OF THE STARTS - 2075','Suite 555 - 2076','Century City - 2077','MA','US2079','1'),
('BA000009','BC000005','1900 AVE OF THE STARTS - 2080','Suite 555 - 2081','Century City - 2082','VA','US2084','1'),
('BA000010','BC000004','1900 AVE OF THE STARTS - 2085','Suite 555 - 2086','Century City - 2087','CA','US2089','1'),
('BA000011','BC000003','1900 AVE OF THE STARTS - 2090','Suite 555 - 2091','Century City - 2092','LA','US2094','1'),
('BA000012','BC000005','1900 AVE OF THE STARTS - 2095','Suite 555 - 2096','Century City - 2097','WA','US2099','1'),
('BA000013','BC000002','1900 AVE OF THE STARTS - 2100','Suite 555 - 2101','Century City - 2102','PA','US2104','1'),
('BA000014','BC000001','1900 AVE OF THE STARTS - 2105','Suite 555 - 2106','Century City - 2107','MA','US2109','1'),
('BA000015','BC000005','1900 AVE OF THE STARTS - 2110','Suite 555 - 2111','Century City - 2112','VA','US2114','1'),
('BA000016','BC000005','1900 AVE OF THE STARTS - 2115','Suite 555 - 2116','Century City - 2117','CA','US2119','1'),
('BA000017','BC000004','1900 AVE OF THE STARTS - 2120','Suite 555 - 2121','Century City - 2122','LA','US2124','1'),
('BA000018','BC000002','1900 AVE OF THE STARTS - 2125','Suite 555 - 2126','Century City - 2127','WA','US2129','1'),
('BA000019','BC000003','1900 AVE OF THE STARTS - 2130','Suite 555 - 2131','Century City - 2132','PA','US2134','1'),
('BA000020','BC000001','1900 AVE OF THE STARTS - 2135','Suite 555 - 2136','Century City - 2137','MA','US2139','1');
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
('E000001','Philip2140','BC000001','philip@aaxischina.com','1'),
('E000002','Philip2141','BC000005','philip@aaxischina.com','1'),
('E000003','Philip2142','BC000004','philip@aaxischina.com','1'),
('E000004','Philip2143','BC000005','philip@aaxischina.com','1'),
('E000005','Philip2144','BC000005','philip@aaxischina.com','1'),
('E000006','Philip2145','BC000004','philip@aaxischina.com','1'),
('E000007','Philip2146','BC000001','philip@aaxischina.com','1'),
('E000008','Philip2147','BC000002','philip@aaxischina.com','1'),
('E000009','Philip2148','BC000005','philip@aaxischina.com','1'),
('E000010','Philip2149','BC000003','philip@aaxischina.com','1'),
('E000011','Philip2150','BC000005','philip@aaxischina.com','1'),
('E000012','Philip2151','BC000005','philip@aaxischina.com','1'),
('E000013','Philip2152','BC000001','philip@aaxischina.com','1'),
('E000014','Philip2153','BC000002','philip@aaxischina.com','1'),
('E000015','Philip2154','BC000005','philip@aaxischina.com','1'),
('E000016','Philip2155','BC000005','philip@aaxischina.com','1'),
('E000017','Philip2156','BC000004','philip@aaxischina.com','1'),
('E000018','Philip2157','BC000005','philip@aaxischina.com','1'),
('E000019','Philip2158','BC000003','philip@aaxischina.com','1'),
('E000020','Philip2159','BC000002','philip@aaxischina.com','1');
drop table  if exists role_data;
create table role_data (
	id	  	varchar(48) not null,
	role_name	  	varchar(32),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into role_data values
('R000001','manager2160','1'),
('R000002','manager2161','1'),
('R000003','manager2162','1'),
('R000004','manager2163','1'),
('R000005','manager2164','1'),
('R000006','manager2165','1'),
('R000007','manager2166','1'),
('R000008','manager2167','1'),
('R000009','manager2168','1'),
('R000010','manager2169','1'),
('R000011','manager2170','1'),
('R000012','manager2171','1'),
('R000013','manager2172','1'),
('R000014','manager2173','1'),
('R000015','manager2174','1'),
('R000016','manager2175','1'),
('R000017','manager2176','1'),
('R000018','manager2177','1'),
('R000019','manager2178','1'),
('R000020','manager2179','1');
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
('A000001','E000002','A000005','2018-02-08','1'),
('A000002','E000002','A000001','2016-07-09','1'),
('A000003','E000004','A000005','2016-07-05','1'),
('A000004','E000001','A000005','2018-01-21','1'),
('A000005','E000001','A000004','2015-10-23','1'),
('A000006','E000005','A000004','2014-07-21','1'),
('A000007','E000002','A000005','2018-10-14','1'),
('A000008','E000004','A000003','2017-04-19','1'),
('A000009','E000004','A000005','2018-10-18','1'),
('A000010','E000003','A000002','2018-10-02','1'),
('A000011','E000003','A000003','2018-04-15','1'),
('A000012','E000004','A000001','2014-04-23','1'),
('A000013','E000001','A000001','2015-03-29','1'),
('A000014','E000001','A000002','2015-06-27','1'),
('A000015','E000002','A000002','2017-02-22','1'),
('A000016','E000001','A000001','2014-11-27','1'),
('A000017','E000005','A000002','2016-09-23','1'),
('A000018','E000001','A000004','2014-07-30','1'),
('A000019','E000002','A000004','2016-01-24','1'),
('A000020','E000004','A000005','2014-06-14','1');
drop table  if exists access_data;
create table access_data (
	id	  	varchar(48) not null,
	role_name	  	varchar(40),
	role	  	varchar(48),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into access_data values
('A000001','x manager2180','R000002','1'),
('A000002','x manager2181','R000003','1'),
('A000003','x manager2182','R000004','1'),
('A000004','x manager2183','R000003','1'),
('A000005','x manager2184','R000005','1'),
('A000006','x manager2185','R000005','1'),
('A000007','x manager2186','R000005','1'),
('A000008','x manager2187','R000003','1'),
('A000009','x manager2188','R000004','1'),
('A000010','x manager2189','R000005','1'),
('A000011','x manager2190','R000004','1'),
('A000012','x manager2191','R000002','1'),
('A000013','x manager2192','R000005','1'),
('A000014','x manager2193','R000002','1'),
('A000015','x manager2194','R000003','1'),
('A000016','x manager2195','R000005','1'),
('A000017','x manager2196','R000003','1'),
('A000018','x manager2197','R000005','1'),
('A000019','x manager2198','R000001','1'),
('A000020','x manager2199','R000004','1');
drop table  if exists order_data;
create table order_data (
	id	  	varchar(48) not null,
	buyer	  	varchar(48),
	seller	  	varchar(48),
	title	  	varchar(64),
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
('O000001','BC000005','SC000001','order title - 2200','181.6436058438608','INVOICE','1','C000001','A000005','P000004','S000001','D000003','1'),
('O000002','BC000002','SC000003','order title - 2202','10.83959669819933','QUOTE','1','C000003','A000004','P000005','S000005','D000005','1'),
('O000003','BC000004','SC000005','order title - 2204','26.77474035572208','ORDER','1','C000005','A000002','P000005','S000003','D000001','1'),
('O000004','BC000001','SC000002','order title - 2206','82.46567806170525','INVOICE','1','C000005','A000005','P000001','S000002','D000004','1'),
('O000005','BC000005','SC000005','order title - 2208','162.22589846480193','QUOTE','1','C000005','A000004','P000001','S000002','D000002','1'),
('O000006','BC000004','SC000001','order title - 2210','115.18855672848389','ORDER','1','C000001','A000005','P000005','S000005','D000001','1'),
('O000007','BC000004','SC000005','order title - 2212','174.21359013052697','INVOICE','1','C000005','A000001','P000001','S000004','D000003','1'),
('O000008','BC000002','SC000002','order title - 2214','11.806144949709905','QUOTE','1','C000001','A000005','P000002','S000005','D000003','1'),
('O000009','BC000003','SC000005','order title - 2216','27.05366457763313','ORDER','1','C000001','A000004','P000003','S000003','D000003','1'),
('O000010','BC000002','SC000002','order title - 2218','57.72870969809528','INVOICE','1','C000002','A000002','P000004','S000002','D000005','1'),
('O000011','BC000003','SC000004','order title - 2220','264.6447595940525','QUOTE','1','C000003','A000001','P000002','S000002','D000004','1'),
('O000012','BC000002','SC000003','order title - 2222','134.61217078594075','ORDER','1','C000003','A000005','P000003','S000005','D000005','1'),
('O000013','BC000003','SC000001','order title - 2224','198.6414501504276','INVOICE','1','C000004','A000005','P000003','S000002','D000003','1'),
('O000014','BC000005','SC000002','order title - 2226','155.14108821702587','QUOTE','1','C000004','A000001','P000003','S000002','D000002','1'),
('O000015','BC000001','SC000004','order title - 2228','251.35706719875225','ORDER','1','C000004','A000005','P000002','S000004','D000002','1'),
('O000016','BC000005','SC000003','order title - 2230','64.12132308022262','INVOICE','1','C000001','A000002','P000002','S000001','D000004','1'),
('O000017','BC000004','SC000005','order title - 2232','179.19623372648567','QUOTE','1','C000001','A000002','P000003','S000005','D000004','1'),
('O000018','BC000005','SC000001','order title - 2234','158.08242802810028','ORDER','1','C000003','A000004','P000004','S000003','D000003','1'),
('O000019','BC000003','SC000002','order title - 2236','247.29704857248703','INVOICE','1','C000002','A000003','P000001','S000004','D000003','1'),
('O000020','BC000003','SC000001','order title - 2238','68.54965749571737','QUOTE','1','C000001','A000004','P000002','S000005','D000003','1');
drop table  if exists confirmation_data;
create table confirmation_data (
	id	  	varchar(48) not null,
	who	  	varchar(40),
	d	  	Date,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into confirmation_data values
('C000001','approver2240','2017-06-29','1'),
('C000002','approver2241','2017-11-08','1'),
('C000003','approver2242','2017-01-09','1'),
('C000004','approver2243','2016-12-21','1'),
('C000005','approver2244','2016-11-17','1'),
('C000006','approver2245','2016-11-08','1'),
('C000007','approver2246','2014-08-05','1'),
('C000008','approver2247','2015-10-17','1'),
('C000009','approver2248','2015-10-25','1'),
('C000010','approver2249','2017-03-12','1'),
('C000011','approver2250','2015-09-11','1'),
('C000012','approver2251','2016-11-10','1'),
('C000013','approver2252','2018-03-26','1'),
('C000014','approver2253','2014-12-07','1'),
('C000015','approver2254','2017-11-10','1'),
('C000016','approver2255','2014-06-19','1'),
('C000017','approver2256','2017-02-10','1'),
('C000018','approver2257','2016-12-20','1'),
('C000019','approver2258','2014-11-03','1'),
('C000020','approver2259','2017-08-06','1');
drop table  if exists shipment_data;
create table shipment_data (
	id	  	varchar(48) not null,
	who	  	varchar(32),
	d	  	Date,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into shipment_data values
('S000001','carrier2260','2014-02-08','1'),
('S000002','carrier2261','2015-01-22','1'),
('S000003','carrier2262','2015-08-03','1'),
('S000004','carrier2263','2014-01-02','1'),
('S000005','carrier2264','2015-03-27','1'),
('S000006','carrier2265','2014-02-15','1'),
('S000007','carrier2266','2016-01-29','1'),
('S000008','carrier2267','2016-01-30','1'),
('S000009','carrier2268','2014-02-11','1'),
('S000010','carrier2269','2015-12-14','1'),
('S000011','carrier2270','2017-10-31','1'),
('S000012','carrier2271','2017-07-19','1'),
('S000013','carrier2272','2017-06-27','1'),
('S000014','carrier2273','2014-11-30','1'),
('S000015','carrier2274','2018-01-12','1'),
('S000016','carrier2275','2016-02-10','1'),
('S000017','carrier2276','2017-09-26','1'),
('S000018','carrier2277','2015-10-28','1'),
('S000019','carrier2278','2015-11-20','1'),
('S000020','carrier2279','2013-12-19','1');
drop table  if exists delivery_data;
create table delivery_data (
	id	  	varchar(48) not null,
	who	  	varchar(40),
	d	  	Date,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into delivery_data values
('D000001','deliverer2280','2018-01-29','1'),
('D000002','deliverer2281','2015-02-22','1'),
('D000003','deliverer2282','2013-10-01','1'),
('D000004','deliverer2283','2014-11-08','1'),
('D000005','deliverer2284','2013-11-09','1'),
('D000006','deliverer2285','2015-05-25','1'),
('D000007','deliverer2286','2014-01-23','1'),
('D000008','deliverer2287','2018-02-14','1'),
('D000009','deliverer2288','2017-03-26','1'),
('D000010','deliverer2289','2014-01-08','1'),
('D000011','deliverer2290','2014-10-29','1'),
('D000012','deliverer2291','2017-07-16','1'),
('D000013','deliverer2292','2018-01-29','1'),
('D000014','deliverer2293','2017-01-15','1'),
('D000015','deliverer2294','2016-10-02','1'),
('D000016','deliverer2295','2014-08-03','1'),
('D000017','deliverer2296','2015-07-18','1'),
('D000018','deliverer2297','2014-06-05','1'),
('D000019','deliverer2298','2014-08-21','1'),
('D000020','deliverer2299','2013-08-10','1');
drop table  if exists processing_data;
create table processing_data (
	id	  	varchar(48) not null,
	who	  	varchar(40),
	d	  	Date,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into processing_data values
('P000001','processor2300','2018-02-04','1'),
('P000002','processor2301','2018-07-03','1'),
('P000003','processor2302','2013-09-25','1'),
('P000004','processor2303','2018-07-07','1'),
('P000005','processor2304','2014-05-30','1'),
('P000006','processor2305','2013-10-04','1'),
('P000007','processor2306','2014-03-27','1'),
('P000008','processor2307','2013-08-13','1'),
('P000009','processor2308','2018-06-05','1'),
('P000010','processor2309','2015-11-27','1'),
('P000011','processor2310','2017-11-13','1'),
('P000012','processor2311','2013-10-22','1'),
('P000013','processor2312','2014-07-09','1'),
('P000014','processor2313','2015-08-11','1'),
('P000015','processor2314','2015-10-21','1'),
('P000016','processor2315','2017-08-26','1'),
('P000017','processor2316','2017-04-01','1'),
('P000018','processor2317','2016-12-31','1'),
('P000019','processor2318','2015-11-05','1'),
('P000020','processor2319','2014-09-15','1');
drop table  if exists approval_data;
create table approval_data (
	id	  	varchar(48) not null,
	who	  	varchar(40),
	d	  	Date,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into approval_data values
('A000001','approver2320','2015-10-09','1'),
('A000002','approver2321','2013-11-27','1'),
('A000003','approver2322','2014-10-19','1'),
('A000004','approver2323','2017-01-25','1'),
('A000005','approver2324','2014-04-09','1'),
('A000006','approver2325','2016-11-24','1'),
('A000007','approver2326','2013-07-21','1'),
('A000008','approver2327','2018-06-12','1'),
('A000009','approver2328','2018-02-12','1'),
('A000010','approver2329','2017-04-18','1'),
('A000011','approver2330','2018-02-01','1'),
('A000012','approver2331','2017-09-14','1'),
('A000013','approver2332','2014-10-02','1'),
('A000014','approver2333','2014-09-05','1'),
('A000015','approver2334','2014-02-25','1'),
('A000016','approver2335','2017-09-04','1'),
('A000017','approver2336','2014-03-02','1'),
('A000018','approver2337','2017-12-08','1'),
('A000019','approver2338','2016-10-05','1'),
('A000020','approver2339','2013-12-29','1');
drop table  if exists line_item_data;
create table line_item_data (
	id	  	varchar(48) not null,
	biz_order	  	varchar(48),
	sku_id	  	varchar(16),
	sku_name	  	varchar(40),
	amount	  	numeric(5,2),
	quantity	  	int,
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into line_item_data values
('LI000001','O000003','SKU2340','iPhone - 2341','13.908441659358548','1','1'),
('LI000002','O000001','SKU2342','iPhone - 2343','14.127762163801291','8','1'),
('LI000003','O000001','SKU2344','iPhone - 2345','18.649853708306654','7','1'),
('LI000004','O000004','SKU2346','iPhone - 2347','14.702396981274038','8','1'),
('LI000005','O000002','SKU2348','iPhone - 2349','21.348183643936387','7','1'),
('LI000006','O000002','SKU2350','iPhone - 2351','20.717083816646337','6','1'),
('LI000007','O000001','SKU2352','iPhone - 2353','4.681545426748009','9','1'),
('LI000008','O000002','SKU2354','iPhone - 2355','19.270698456220504','6','1'),
('LI000009','O000003','SKU2356','iPhone - 2357','0.08385465830878062','6','1'),
('LI000010','O000002','SKU2358','iPhone - 2359','15.849801790710584','5','1'),
('LI000011','O000002','SKU2360','iPhone - 2361','20.981608060864595','7','1'),
('LI000012','O000001','SKU2362','iPhone - 2363','12.031971323596832','9','1'),
('LI000013','O000004','SKU2364','iPhone - 2365','14.609180218987378','10','1'),
('LI000014','O000002','SKU2366','iPhone - 2367','12.779791395125027','4','1'),
('LI000015','O000003','SKU2368','iPhone - 2369','9.804340913061662','8','1'),
('LI000016','O000005','SKU2370','iPhone - 2371','9.35116024328388','10','1'),
('LI000017','O000005','SKU2372','iPhone - 2373','2.381499419344777','2','1'),
('LI000018','O000001','SKU2374','iPhone - 2375','11.453968894700544','6','1'),
('LI000019','O000004','SKU2376','iPhone - 2377','11.291962428088224','5','1'),
('LI000020','O000003','SKU2378','iPhone - 2379','19.970042282131303','6','1');
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
('SG000001','shipping to this address2380','O000003','SA000004','3.6628764942006673','1'),
('SG000002','shipping to this address2381','O000003','SA000001','5.630719745446316','1'),
('SG000003','shipping to this address2382','O000005','SA000001','2.6355060378993267','1'),
('SG000004','shipping to this address2383','O000004','SA000003','2.90269482417974','1'),
('SG000005','shipping to this address2384','O000001','SA000005','3.9541723472279093','1'),
('SG000006','shipping to this address2385','O000005','SA000005','0.14975584496988845','1'),
('SG000007','shipping to this address2386','O000003','SA000001','4.2626823086462045','1'),
('SG000008','shipping to this address2387','O000003','SA000003','2.400545016009101','1'),
('SG000009','shipping to this address2388','O000002','SA000003','1.7205895497256294','1'),
('SG000010','shipping to this address2389','O000001','SA000003','5.215472029913936','1'),
('SG000011','shipping to this address2390','O000002','SA000001','5.6802896172700095','1'),
('SG000012','shipping to this address2391','O000004','SA000002','3.099286863239398','1'),
('SG000013','shipping to this address2392','O000005','SA000002','5.664089531026473','1'),
('SG000014','shipping to this address2393','O000001','SA000005','2.550815885736974','1'),
('SG000015','shipping to this address2394','O000003','SA000004','0.4678473356387184','1'),
('SG000016','shipping to this address2395','O000005','SA000001','5.010417639979214','1'),
('SG000017','shipping to this address2396','O000002','SA000001','5.940265556126241','1'),
('SG000018','shipping to this address2397','O000003','SA000003','4.920536201061681','1'),
('SG000019','shipping to this address2398','O000002','SA000001','3.187366305286802','1'),
('SG000020','shipping to this address2399','O000003','SA000005','0.05266385240055779','1');
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
('PG000001','visa card ending - 2400','O000003','4111 1111 1111 - 2401','BA000004','1'),
('PG000002','visa card ending - 2402','O000004','4111 1111 1111 - 2403','BA000003','1'),
('PG000003','visa card ending - 2404','O000005','4111 1111 1111 - 2405','BA000005','1'),
('PG000004','visa card ending - 2406','O000002','4111 1111 1111 - 2407','BA000005','1'),
('PG000005','visa card ending - 2408','O000004','4111 1111 1111 - 2409','BA000004','1'),
('PG000006','visa card ending - 2410','O000003','4111 1111 1111 - 2411','BA000001','1'),
('PG000007','visa card ending - 2412','O000005','4111 1111 1111 - 2413','BA000003','1'),
('PG000008','visa card ending - 2414','O000003','4111 1111 1111 - 2415','BA000003','1'),
('PG000009','visa card ending - 2416','O000004','4111 1111 1111 - 2417','BA000002','1'),
('PG000010','visa card ending - 2418','O000001','4111 1111 1111 - 2419','BA000002','1'),
('PG000011','visa card ending - 2420','O000002','4111 1111 1111 - 2421','BA000002','1'),
('PG000012','visa card ending - 2422','O000001','4111 1111 1111 - 2423','BA000004','1'),
('PG000013','visa card ending - 2424','O000003','4111 1111 1111 - 2425','BA000003','1'),
('PG000014','visa card ending - 2426','O000005','4111 1111 1111 - 2427','BA000002','1'),
('PG000015','visa card ending - 2428','O000004','4111 1111 1111 - 2429','BA000004','1'),
('PG000016','visa card ending - 2430','O000001','4111 1111 1111 - 2431','BA000005','1'),
('PG000017','visa card ending - 2432','O000001','4111 1111 1111 - 2433','BA000004','1'),
('PG000018','visa card ending - 2434','O000001','4111 1111 1111 - 2435','BA000004','1'),
('PG000019','visa card ending - 2436','O000005','4111 1111 1111 - 2437','BA000003','1'),
('PG000020','visa card ending - 2438','O000005','4111 1111 1111 - 2439','BA000002','1');
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
('CSR000001','philip_chang@174.com','R000005','SC000002','1'),
('CSR000002','philip_chang@174.com','R000001','SC000004','1'),
('CSR000003','philip_chang@174.com','R000005','SC000004','1'),
('CSR000004','philip_chang@174.com','R000004','SC000001','1'),
('CSR000005','philip_chang@174.com','R000004','SC000001','1'),
('CSR000006','philip_chang@174.com','R000003','SC000002','1'),
('CSR000007','philip_chang@174.com','R000004','SC000001','1'),
('CSR000008','philip_chang@174.com','R000002','SC000001','1'),
('CSR000009','philip_chang@174.com','R000004','SC000001','1'),
('CSR000010','philip_chang@174.com','R000002','SC000002','1'),
('CSR000011','philip_chang@174.com','R000003','SC000004','1'),
('CSR000012','philip_chang@174.com','R000003','SC000001','1'),
('CSR000013','philip_chang@174.com','R000005','SC000003','1'),
('CSR000014','philip_chang@174.com','R000001','SC000003','1'),
('CSR000015','philip_chang@174.com','R000004','SC000002','1'),
('CSR000016','philip_chang@174.com','R000005','SC000004','1'),
('CSR000017','philip_chang@174.com','R000003','SC000004','1'),
('CSR000018','philip_chang@174.com','R000002','SC000002','1'),
('CSR000019','philip_chang@174.com','R000002','SC000001','1'),
('CSR000020','philip_chang@174.com','R000004','SC000005','1');
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
('A000001','view2440','load2441','O000001','1'),
('A000002','view2442','load2443','O000004','1'),
('A000003','view2444','load2445','O000002','1'),
('A000004','view2446','load2447','O000003','1'),
('A000005','view2448','load2449','O000005','1'),
('A000006','view2450','load2451','O000003','1'),
('A000007','view2452','load2453','O000001','1'),
('A000008','view2454','load2455','O000005','1'),
('A000009','view2456','load2457','O000002','1'),
('A000010','view2458','load2459','O000001','1'),
('A000011','view2460','load2461','O000001','1'),
('A000012','view2462','load2463','O000005','1'),
('A000013','view2464','load2465','O000002','1'),
('A000014','view2466','load2467','O000003','1'),
('A000015','view2468','load2469','O000001','1'),
('A000016','view2470','load2471','O000001','1'),
('A000017','view2472','load2473','O000003','1'),
('A000018','view2474','load2475','O000002','1'),
('A000019','view2476','load2477','O000004','1'),
('A000020','view2478','load2479','O000002','1');



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





