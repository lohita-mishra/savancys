create index IX_76768626 on ContactUs (groupId);
create index IX_3FBF5BF8 on ContactUs (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_B6DE807A on ContactUs (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_637B5ED5 on JobPost (jobPostName[$COLUMN_LENGTH:75$]);
create index IX_19EEE997 on JobPost (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_6882E9D9 on JobPost (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_9D167B9D on LCA_Posting (designation[$COLUMN_LENGTH:75$], location[$COLUMN_LENGTH:75$]);
create index IX_E4DEED47 on LCA_Posting (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_9E001989 on LCA_Posting (uuid_[$COLUMN_LENGTH:75$], groupId);