create table ContactUs (
	uuid_ VARCHAR(75) null,
	contactId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	inquiryType VARCHAR(75) null,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	phoneNumber VARCHAR(75) null,
	email VARCHAR(75) null,
	companyName VARCHAR(75) null,
	country VARCHAR(75) null,
	additionalInfo VARCHAR(500) null
);