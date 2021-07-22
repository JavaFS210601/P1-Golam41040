CREATE TABLE ERS_REIMBURSTMENT_STATUS(
	reimb_status_id serial PRIMARY KEY,	
	reimb_status text
);

CREATE TABLE ERS_REIMBURSTMENT_TYPE(
	reimb_type_id serial PRIMARY KEY,	
	reimb_type text
);


CREATE TABLE ERS_USER_ROLES(
	ers_user_role_id serial PRIMARY KEY,	
	user_role text
);

CREATE TABLE ERS_USERS(
	ers_user_id serial PRIMARY KEY,
	ers_username TEXT,
	ers_password TEXT,
	user_first_name TEXT,
	user_last_name TEXT,
	user_email TEXT,
	user_role_id int REFERENCES ERS_USER_ROLES (ers_user_role_id) ON DELETE CASCADE		
);

ALTER TABLE ERS_USERS ADD CONSTRAINT unique_uname UNIQUE (ers_username);

ALTER TABLE ERS_USERS ADD CONSTRAINT unique_email UNIQUE (user_email);


CREATE TABLE ERS_REIMBURSTMENT(
	reimb_id serial PRIMARY KEY,
	reimb_amount int,
	reimb_submitted date,
	reimb_resolved date,
	reimb_description TEXT,
	reimb_receipt TEXT, 
	reimb_author int REFERENCES ERS_USERS (ers_user_id) ON DELETE CASCADE,
	reimb_resolver int REFERENCES ERS_USERS (ers_user_id) ON DELETE CASCADE,
	reimb_status_id int REFERENCES ERS_REIMBURSTMENT_STATUS (reimb_status_id) ON DELETE CASCADE,
	reimb_type_id int REFERENCES ERS_REIMBURSTMENT_TYPE (reimb_type_id) ON DELETE CASCADE
);


INSERT INTO ERS_REIMBURSTMENT_STATUS( reimb_status)
			values('Submitted'),
					('Approved'),
					('Denied');
				
				
INSERT INTO ERS_USER_ROLES( user_role)
			values('Finance Manager'),
					('Employee');
				
				
				
				
INSERT INTO ERS_REIMBURSTMENT_type( reimb_type)
			values('Ambassador Program'),
					('Associate Travel Expense'),
					('Certification'),
					('Relocation to Training'),
					('Software Engineer - Travel Expenses');
				
				
INSERT INTO ERS_USERS( ers_username, ers_password, user_first_name, user_last_name, 
						user_email, user_role_id)
			VALUES ('golam56','abcd1234','Golam','Zilani','golam.zilani@revature.net',2 ),
					('benP11','abcd1234','Benjamin','Petruzziello','ben.p@revature.net',1 );

				
INSERT INTO ERS_REIMBURSTMENT(reimb_amount ,reimb_submitted ,reimb_resolved , reimb_description ,
								reimb_receipt , reimb_author ,reimb_resolver ,reimb_status_id ,reimb_type_id )
			VALUES (230,'2021-01-25','2021-01-30','Reimburstment for JAVA certification Exam','expense.txt',1,2,3,3);	

INSERT INTO ERS_REIMBURSTMENT(reimb_amount ,reimb_submitted ,reimb_resolved , reimb_description ,
								reimb_receipt , reimb_author ,reimb_resolver ,reimb_status_id ,reimb_type_id )
			VALUES (330,'2021-03-15','2021-04-30','Expense Occured during the Embassador Program','receipt.png',1,2,2,1);

		
		
CREATE TABLE USER_CURRENT(
	username TEXT	
);	







		
		





