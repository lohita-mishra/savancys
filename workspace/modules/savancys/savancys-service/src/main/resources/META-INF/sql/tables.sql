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
	additionalInfo VARCHAR(75) null
);

create table JobApplicant (
	jobApplicantID LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	phoneNumber VARCHAR(75) null,
	email VARCHAR(75) null,
	jobType VARCHAR(75) null,
	state_ VARCHAR(75) null,
	message VARCHAR(75) null,
	fileId LONG,
	jobPostId LONG,
	skill VARCHAR(75) null,
	webAuthorization VARCHAR(75) null
);


create table JobPost (
	uuid_ VARCHAR(75) null,
	jobPostId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	active_ BOOLEAN,
	delete_ BOOLEAN,
	jobPostName VARCHAR(75) null,
	experience VARCHAR(75) null,
	qualification VARCHAR(75) null,
	location VARCHAR(75) null,
	skills VARCHAR(75) null,
	description STRING null,
	salary VARCHAR(75) null,
	status BOOLEAN
);