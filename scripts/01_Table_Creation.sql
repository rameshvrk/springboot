IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_Language]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_Language](
	[Language_ID] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[Language_Code] [varchar](10) NOT NULL,
	[Description] [varchar](50) NULL,
	[Locale] [varchar](20) NOT NULL
) ON [PRIMARY]
END
GO

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_Time_Zone]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_Time_Zone](
	[Time_Zone_ID] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[Description] [varchar](50) NULL,
	[Country] [varchar](20)
) ON [PRIMARY]
END
GO

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_Role]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_Role](
	[Role_ID] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[Role_Name] [varchar](20) NOT NULL,
	[Description] [varchar](50)
) ON [PRIMARY]
END
GO

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_Business_Unit]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_Business_Unit](
	Business_Unit_ID	[int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	BU_Code				[varchar](15)	NOT NULL UNIQUE,
	BU_Name				[varchar](50)	NOT NULL,
	Region				[varchar](30),
	Province			[varchar](30),
	State				[varchar](30),
	Country				[varchar](20),
	Phone				[varchar](20),
	Email_Address		[varchar](30),
	Contact_Name		[varchar](30)
) ON [PRIMARY]
END
GO


IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_User]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_User](
	User_ID				INT	IDENTITY(1,1) NOT NULL PRIMARY KEY,
	User_Name			VARCHAR(50)	NOT NULL UNIQUE,
	First_Name			VARCHAR(50)	NOT NULL,
	Last_Name			VARCHAR(50),	
	Password			VARCHAR(30)	NOT NULL,
	IsActive			VARCHAR(1)	NOT NULL,
	Language_ID			INT,	
	Time_Zone_ID		INT,
	Email_Address 		VARCHAR(30),	
	Phone				VARCHAR(20),
	Role_ID				INT			NOT NULL,
	Business_Unit_ID	INT			NOT NULL
	FOREIGN KEY 		(Language_ID) REFERENCES 	t_Language(Language_ID),
	FOREIGN KEY 		(Time_Zone_ID) REFERENCES t_Time_Zone(Time_Zone_ID),
	FOREIGN KEY 		(Role_ID) REFERENCES 	t_Role(Role_ID),
	FOREIGN KEY 		(Business_Unit_ID) REFERENCES t_Business_Unit(Business_Unit_ID)
) ON [PRIMARY]
END
GO

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_Status]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_Status](
	[Status_ID] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[Status_Code] [varchar](15) NOT NULL,
	[Description] [varchar](30)
) ON [PRIMARY]
END
GO


IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_Transporter]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_Transporter](
	Transporter_ID				INT	IDENTITY(1,1) NOT NULL PRIMARY KEY,
	Transporter_Code			VARCHAR(20)	NOT NULL UNIQUE,
	Transporter_Name			VARCHAR(50)	NOT NULL,
	Contact_Name				VARCHAR(50),	
	Address						VARCHAR(255),		
	Region						VARCHAR(30),	
	State						VARCHAR(30),	
	Province					VARCHAR(30),	
	Country						VARCHAR(20),	
	Phone						VARCHAR(20),	
	Email_Address				VARCHAR(20),	
	Trucks						INT,	
	IsActive					VARCHAR(1)	NOT NULL DEFAULT 'Y',
	Created_By					INT			NOT NULL,
	Created_Date				DATETIME	
	FOREIGN KEY  (Created_By) REFERENCES t_User(User_ID)
) ON [PRIMARY]
END
GO

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_Vehicle]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_Vehicle](
	Vehicle_ID					INT	IDENTITY(1,1) NOT NULL PRIMARY KEY,
	Vehicle_Code				VARCHAR(20)	NOT NULL,
	Type						VARCHAR(30),	
	Operated_By					INT			NOT NULL,
	Created_By					INT,	
	Created_Date				DATETIME,	
	Vessel_Type					VARCHAR(20),	
	Fumigation_Required			VARCHAR(1) DEFAULT 'N',	
	License_Plate				VARCHAR(20)	NOT NULL
	FOREIGN KEY (Operated_By) REFERENCES t_Transporter(Transporter_ID),
	FOREIGN KEY (Created_By) REFERENCES t_User(User_ID)
) ON [PRIMARY]
END
GO


IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_Temp_Import_Order]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_Temp_Import_Order](
	Temp_Order_ID				INT	IDENTITY(1,1) NOT NULL PRIMARY KEY,
	Source						VARCHAR(15)	NOT NULL,
	Order_Number				VARCHAR(60)	NOT NULL,
	Order_Type					VARCHAR(20),	
	From_Address				VARCHAR(100),	
	From_Region					VARCHAR(30),
	From_State					VARCHAR(30),	
	From_Province				VARCHAR(30),	
	From_Country				VARCHAR(20),	
	From_Phone					VARCHAR(20),	
	From_Latitude				VARCHAR(20),	
	From_Longitude				VARCHAR(20),	
	To_Address					VARCHAR(100),	
	To_Region					VARCHAR(30),	
	To_State					VARCHAR(30),	
	To_Province					VARCHAR(30),	
	To_Country					VARCHAR(20),	
	To_Phone					VARCHAR(20),	
	To_Latitude					VARCHAR(20),	
	To_Longitude				VARCHAR(20),	
	Line_Number					VARCHAR(15),	
	Product_Type				VARCHAR(30),	
	Product_Description			VARCHAR(100),	
	Qty							INT,	
	Volume						INT,	
	Business_Unit				VARCHAR(15)	
) ON [PRIMARY]
END
GO

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_Order]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_Order](
	Order_ID				INT	IDENTITY(1,1) NOT NULL PRIMARY KEY,
	Source					VARCHAR(15)		NOT NULL,
	Order_Number			VARCHAR(60)		NOT NULL UNIQUE,
	Order_Type				VARCHAR(20)		NOT NULL,
	From_Address			VARCHAR(100)	NOT NULL,
	From_Region				VARCHAR(30),	
	From_State				VARCHAR(30),	
	From_Province			VARCHAR(30),	
	From_Country			VARCHAR(20)		NOT NULL,		
	From_Phone				VARCHAR(20),	
	From_Latitude			VARCHAR(20),	
	From_Longitude			VARCHAR(20),	
	To_Address				VARCHAR(100)	NOT NULL,
	To_Region				VARCHAR(30),	
	To_State				VARCHAR(30),	
	To_Province				VARCHAR(30),	
	To_Country				VARCHAR(20)		NOT NULL,	
	To_Phone				VARCHAR(20),	
	To_Latitude				VARCHAR(20),	
	To_Longitude			VARCHAR(20),	
	Created_By				INT,	
	Created_Date			DATETIME,	
	Updated_By				INT,	
	Updated_Date			DATETIME,	
	Business_Unit_ID			INT	NOT NULL
	FOREIGN KEY (Business_Unit_ID) REFERENCES t_Business_Unit(Business_Unit_ID)
) ON [PRIMARY]
END
GO

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_Order_Details]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_Order_Details](
	Order_Detail_ID			INT	IDENTITY(1,1) NOT NULL PRIMARY KEY,
	Order_ID				INT			NOT NULL,
	Order_Number			VARCHAR(60)	NOT NULL,
	Line_Number				VARCHAR(15),	
	Product_Type			VARCHAR(30),	
	Product_Description		VARCHAR(100),	
	Qty						INT,	
	Volume					FLOAT
	FOREIGN KEY (Order_ID)	REFERENCES t_Order(Order_ID)
) ON [PRIMARY]
END
GO

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_Transport_Order]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_Transport_Order](
	Transport_Order_ID						INT	IDENTITY(1,1) NOT NULL PRIMARY KEY,
	Transporter_ID							INT			NOT NULL,
	Order_ID								INT			NOT NULL,
	Assigned_By								INT			NOT NULL,
	Assigned_Date							DATETIME	NOT NULL,
	Accepted_By								INT,			
	Accepted_Date							DATETIME,	
	Business_Unit_ID						INT			NOT NULL,
	Line_Number								VARCHAR(15)	NOT NULL,
	Product_Type							VARCHAR(30)	NOT NULL,
	Product_Description						VARCHAR(100) NOT NULL,
	Qty										INT			NOT NULL,
	Volume									FLOAT,	
	Weight									FLOAT,	
	Volume_UOM								VARCHAR(20),	
	Weight_UOM								VARCHAR(20),	
	Shipper									VARCHAR(100)	NOT NULL,
	Consignee								VARCHAR(100)	NOT NULL,
	Pickup_Location							VARCHAR(100)	NOT NULL,
	Drop_Location							VARCHAR(100)	NOT NULL,
	Vehicle_ID								INT,	
	Driver_ID								INT,	
	Driver_Name								VARCHAR(30),	
	Status_ID								INT,	
	Remarks									VARCHAR(255)	
	FOREIGN KEY (Order_ID) REFERENCES t_Order(Order_ID),
	FOREIGN KEY (Assigned_By) REFERENCES t_User(User_ID),
	FOREIGN KEY (Accepted_By) REFERENCES t_User(User_ID),
	FOREIGN KEY (Business_Unit_ID) REFERENCES t_Business_Unit(Business_Unit_ID),
	FOREIGN KEY (Vehicle_ID) REFERENCES t_Vehicle(Vehicle_ID),
	FOREIGN KEY (Status_ID) REFERENCES t_Status(Status_ID)
) ON [PRIMARY]
END
GO

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_Reason]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_Reason](
	Reason_ID	INT	IDENTITY(1,1) NOT NULL PRIMARY KEY,
	Reason_Code	VARCHAR(20)	NOT NULL,
	Description	VARCHAR(50),	
	Comments	VARCHAR(255)	
) ON [PRIMARY]
END
GO

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_Trip]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_Trip](
	Trip_ID					INT	IDENTITY(1,1) NOT NULL PRIMARY KEY,
	Transporter_Order_ID	INT	NOT NULL,
	Sequence				INT,	
	Created_By				INT	NOT NULL,
	Created_Date			DATETIME,	
	Started_By				INT,	
	Started_Date			DATETIME,	
	Finished_By				INT,	
	Finished_Date			DATETIME,	
	Status_ID				INT	NOT NULL,
	Status_Code				VARCHAR(15),
	Reason_ID				INT	
	FOREIGN KEY (Created_By) REFERENCES t_User(User_ID),
	FOREIGN KEY (Started_By) REFERENCES t_User(User_ID),
	FOREIGN KEY (Finished_By) REFERENCES t_User(User_ID),
	FOREIGN KEY (Status_ID) REFERENCES t_Status(Status_ID),
	FOREIGN KEY (Reason_ID) REFERENCES t_Reason(Reason_ID)
) ON [PRIMARY]
END
GO

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_ePOD_Attachments]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_ePOD_Attachments](
	Attachment_ID				INT	IDENTITY(1,1) NOT NULL PRIMARY KEY,
	Trip_ID						INT	NOT NULL,
	Transport_Order_ID		INT	NOT NULL,
	Attachment_Name				VARCHAR(50),	
	Comments					VARCHAR(255),	
	Created_By					INT,
	Created_Date				DATETIME	
	FOREIGN KEY (Created_By) REFERENCES t_User(User_ID),
	FOREIGN KEY (Trip_ID) REFERENCES t_Trip(Trip_ID),
	FOREIGN KEY (Transport_Order_ID) REFERENCES t_Transport_Order(Transport_Order_ID)
) ON [PRIMARY]
END
GO

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_Email_Configuration]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_Email_Configuration](
	Email_Configuration_ID			INT	IDENTITY(1,1) NOT NULL PRIMARY KEY,
	Email_To_Address				VARCHAR(50),	
	Email_Description				VARCHAR(50),	
	Email_Body						VARCHAR(255),	
	Email_CC						VARCHAR(255),	
	Comments						VARCHAR(255),	
	Status_Code						VARCHAR(15)	
) ON [PRIMARY]
END
GO

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_Order_Queue]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_Order_Queue](
	Queue_ID		INT	IDENTITY(1,1) NOT NULL PRIMARY KEY,
	File_Name		VARCHAR(255)	NOT NULL,
	Status			VARCHAR(50),	
	Created_By		VARCHAR(50),	
	Created_Date	DATETIME	
) ON [PRIMARY]
END
GO


IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_Control]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_Control](
	Control_ID				INT IDENTITY(1,1) NOT NULL PRIMARY  KEY,
	Business_Unit_ID		VARCHAR(255) NOT NULL,
	Control_Type			VARCHAR(50),
	Sequence_Start			VARCHAR(50),
	Increment				INT,
	Sequence_End			VARCHAR(50),
	Prefix					VARCHAR(10),
	Suffix					VARCHAR(10),
	UDT1					VARCHAR(30),
	UDT2					VARCHAR(30),
	UDT3					VARCHAR(30),
	UDF1					FLOAT,
	UDF2					FLOAT,
	UDF3					FLOAT
) ON [PRIMARY]
END
GO

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_Action]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_Action](
	Action_ID				INT IDENTITY(1,1)	NOT NULL PRIMARY KEY,
	Status_ID				INT	NOT NULL,
	Email_Format_ID			INT,	
	Description				VARCHAR(50)	
	FOREIGN KEY (Status_ID) REFERENCES t_Status(Status_ID)
) ON [PRIMARY]
END
GO

IF COL_LENGTH('dbo.t_Temp_Import_Order', 'Queue_ID') IS NULL
BEGIN
ALTER TABLE t_Temp_Import_Order ADD Queue_ID int;
END
GO