

		
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[action_table_meta_data]') AND type in (N'U'))
BEGIN
	
	CREATE TABLE [dbo].[action_table_meta_data](
		[id]	  	nvarchar(56) not null,
		[table_name]	  	nvarchar(32),
		[enabled]	  	int,
		[description]	  	nvarchar(104),
		[version]	  	int,
	PRIMARY KEY CLUSTERED 
	(
		[id] ASC
	)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
	) ON [PRIMARY]
	
END 	

		
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[column_meta_data]') AND type in (N'U'))
BEGIN
	
	CREATE TABLE [dbo].[column_meta_data](
		[id]	  	nvarchar(40) not null,
		[source_column]	  	nvarchar(16),
		[dest_column]	  	nvarchar(16),
		[action_table]	  	varchar(64),
		[type]	  	nvarchar(16),
		[length]	  	int,
		[version]	  	int,
	PRIMARY KEY CLUSTERED 
	(
		[id] ASC
	)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
	) ON [PRIMARY]
	
END 	



		
	




