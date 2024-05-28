
-- Inserting data into the positions table
INSERT INTO positions(position_id,name,description,salary,number) VALUES('P101','Software Engineer','Join our team of software engineers and help us build the next generation of software applications',15000,15);
INSERT INTO positions(position_id,name,description,salary,number) VALUES('P102','Database Administrator','Maintain and support database systems',17000,2);
INSERT INTO positions(position_id,name,description,salary,number) VALUES('P103','Network Administrator','Manage and support our network infrastructure',12000,1);
INSERT INTO positions(position_id,name,description,salary,number) VALUES('P104','Web Developer','Design and develop web applications for our clients',10000,10);
INSERT INTO positions(position_id,name,description,salary,number) VALUES('P105','Quality Assurance Engineer','Ensure the quality of our software products',13000,2);
INSERT INTO positions(position_id,name,description,salary,number) VALUES('P106','Systems Analyst','Analyze and design information systems for our clients',14000,5);
INSERT INTO positions(position_id,name,description,salary,number) VALUES('P107','Project Manager','Manage software development projects',16000,3);
INSERT INTO positions(position_id,name,description,salary,number) VALUES('P108','Business Analyst','Analyze business processes and requirements',11000,4);
INSERT INTO positions(position_id,name,description,salary,number) VALUES('P109','Technical Support Specialist','Provide technical support to our clients',9000,2);
INSERT INTO positions(position_id,name,description,salary,number) VALUES('P110','IT Security Specialist','Ensure the security of our information systems',18000,1);

select * from positions;

-- Inserting data into the candidates table

INSERT INTO candidates(candidate_id,description,email,full_name,gender,phone,year_of_birth,position_id) 
VALUES('C101','Software Engineer. 10 years of experience in software development (Java C++ Python). Strong problem-solving skills team player good English communication skills. . Weakness in sports and outdoor activities.','john.doe@gmail.com','John Doe','Male','123-456-7890',1980,'P101');
INSERT INTO candidates(candidate_id,description,email,full_name,gender,phone,year_of_birth,position_id) 
VALUES('C102','Database Administrator. 5 years of experience in database administration (Oracle MySQL SQL Server). Strong analytical skills attention to detail good team player. Weakness in public speaking and presentations.','jill.johnson@gmail.com','Jill Johnson','Male','234-234-1234',1982,'P102');
INSERT INTO candidates(candidate_id,description,email,full_name,gender,phone,year_of_birth,position_id) 
VALUES('C103','Network Administrator. 3 years of experience in network administration (Cisco Juniper Palo Alto). Strong technical skills problem-solving skills good communication skills. Weakness in multitasking and time management.','jill.johnson@gmail.com','Jill Johnson','Male','234-234-1234',1982,'P102');
INSERT INTO candidates(candidate_id,description,email,full_name,gender,phone,year_of_birth,position_id)
VALUES('C104','Web Developer. 2 years of experience in web development (HTML CSS JavaScript). Strong front-end skills creative design skills good team player. Weakness in back-end development and server-side programming.','jack.wilson@gmail.com','Jack Wilson','Male','345-543-2345',1990,'P103');
INSERT INTO candidates(candidate_id,description,email,full_name,gender,phone,year_of_birth,position_id) 
VALUES('C105','Quality Assurance Engineer. 4 years of experience in software testing and quality assurance. Strong attention to detail analytical skills good communication skills. Weakness in programming and coding skills.','jane.smith@gmail.com','Jane Smith','Female','456-654-3456',1992,'P101');
INSERT INTO candidates(candidate_id,description,email,full_name,gender,phone,year_of_birth,position_id) 
VALUES('C106','Systems Analyst. 6 years of experience in systems analysis and design. Strong analytical skills problem-solving skills good communication skills. Weakness in project management and leadership skills.','henry.brown@gmail.com','Henry Brown','Male','678-876-5678',1988,'P106');
INSERT INTO candidates(candidate_id,description,email,full_name,gender,phone,year_of_birth,position_id) 
VALUES('C107','Project Manager. 5 years of experience in project management and software development. Strong leadership skills project management skills good communication skills. Weakness in technical skills and programming knowledge.','bob.black@gmail.com','Bob Black','Male','789-987-6789',1989,'P102');
INSERT INTO candidates(candidate_id,description,email,full_name,gender,phone,year_of_birth,position_id) 
VALUES('C108','Business Analyst. 3 years of experience in business analysis and requirements gathering. Strong analytical skills problem-solving skills good communication skills. Weakness in technical skills and programming knowledge.','charlie.green@gmail.com','Charlie Green','Male','890-098-7890',1987,'P108');
INSERT INTO candidates(candidate_id,description,email,full_name,gender,phone,year_of_birth,position_id) 
VALUES('C109','Technical Support Specialist. 2 years of experience in technical support and customer service. Strong technical skills problem-solving skills good communication skills. Weakness in multitasking and time management.','daisy.brown@gmail.com','Daisy Brown','Male','901-109-8901',1985,'P105');
INSERT INTO candidates(candidate_id,description,email,full_name,gender,phone,year_of_birth,position_id) 
VALUES ('C110','IT Security Specialist. 1 year of experience in IT security and information systems. Strong technical skills problem-solving skills good communication skills. Weakness in project management and leadership skills.','emily.white@gmail.com','Emily White','Female','012-210-9012',1995,'P110');
INSERT INTO candidates(candidate_id,description,email,full_name,gender,phone,year_of_birth,position_id) 
VALUES('C111','Software Engineer. 10 years of experience in software development (C# .NET ASP.NET). Strong problem-solving skills team player good English communication skills. Weakness in sports and outdoor activities.','frank.black@gmail.com','Frank Black','Male','123-321-0123',1993,'P101');

select * from candidates;

-- Inserting data into the certificates table

INSERT INTO certificates(certificate_id,issue_date,name,organization,candidate_id) VALUES('C101','2010-01-01','Bachelor''s Degree in Computer Science','University of Science','C101');
INSERT INTO certificates(certificate_id,issue_date,name,organization,candidate_id) VALUES('C102','2012-01-01','Master''s Degree in Information Technology','University of Technology','C102');
INSERT INTO certificates(certificate_id,issue_date,name,organization,candidate_id) VALUES('C103','2000-01-01','Bachelor''s Degree in Computer Science','University of Science','C103');
INSERT INTO certificates(certificate_id,issue_date,name,organization,candidate_id) VALUES('C104','2012-01-01','Master''s Degree in Statistics','University of Technology','C104');
INSERT INTO certificates(certificate_id,issue_date,name,organization,candidate_id) VALUES('C105','2010-01-01','Bachelor''s Degree in Applied Mathematics','University of Science','C105');
INSERT INTO certificates(certificate_id,issue_date,name,organization,candidate_id) VALUES('C106','2012-01-01','Master''s Degree in Statistics','University of Technology','C106');
INSERT INTO certificates(certificate_id,issue_date,name,organization,candidate_id) VALUES('C107','2010-01-01','Bachelor''s Degree in Business Administration','University of Science','C107');
INSERT INTO certificates(certificate_id,issue_date,name,organization,candidate_id) VALUES('C108','2012-01-01','Master''s Degree in Management','University of Technology','C108');
INSERT INTO certificates(certificate_id,issue_date,name,organization,candidate_id) VALUES('C109','2010-01-01','Bachelor''s Degree in Computer Science','University of Science','C109');
INSERT INTO certificates(certificate_id,issue_date,name,organization,candidate_id) VALUES('C110','2012-01-01','Master''s Degree in Information Technology','University of Technology','C110');
INSERT INTO certificates(certificate_id,issue_date,name,organization,candidate_id) VALUES('C111','2010-01-01','Bachelor''s Degree in Computer Science','University of Science','C111');
INSERT INTO certificates(certificate_id,issue_date,name,organization,candidate_id) VALUES('C112','2013-01-01','Certificate in Database Administration','Oracle Corporation','C101');
INSERT INTO certificates(certificate_id,issue_date,name,organization,candidate_id) VALUES('C113','2014-01-01','Certificate in Network Administration','Cisco Systems','C102');
INSERT INTO certificates(certificate_id,issue_date,name,organization,candidate_id) VALUES('C114','2015-01-01','Certificate in Web Development','Google Inc.','C103');
INSERT INTO certificates(certificate_id,issue_date,name,organization,candidate_id) VALUES('C115','2016-01-01','Certificate in Quality Assurance','Microsoft Corporation','C104');
INSERT INTO certificates(certificate_id,issue_date,name,organization,candidate_id) VALUES('C116','2017-01-01','Certificate in Systems Analysis','IBM Corporation','C105');
INSERT INTO certificates(certificate_id,issue_date,name,organization,candidate_id) VALUES('C117','2018-01-01','Certificate in Project Management','Amazon Inc.','C106');
INSERT INTO certificates(certificate_id,issue_date,name,organization,candidate_id) VALUES('C118','2019-01-01','Certificate in Business Analysis','Apple Inc.','C107');
INSERT INTO certificates(certificate_id,issue_date,name,organization,candidate_id) VALUES('C119','2020-01-01','Certificate in Technical Support','Facebook Inc.','C108');
INSERT INTO certificates(certificate_id,issue_date,name,organization,candidate_id) VALUES('C120','2021-01-01','Certificate in IT Security','Microsoft Corporation','C109');
INSERT INTO certificates(certificate_id,issue_date,name,organization,candidate_id) VALUES('C121','2022-01-01','Certificate in Software Engineering','Google Inc.','C110');
INSERT INTO certificates(certificate_id,issue_date,name,organization,candidate_id) VALUES('C122','2013-01-01','Certificate in Database Administration','Oracle Corporation','C111');
INSERT INTO certificates(certificate_id,issue_date,name,organization,candidate_id) VALUES('C123','2014-01-01','Certificate in TOEFL','ETS','C101');
INSERT INTO certificates(certificate_id,issue_date,name,organization,candidate_id) VALUES('C124','2015-01-01','Certificate in IELTS','University of Cambridge','C102');
INSERT INTO certificates(certificate_id,issue_date,name,organization,candidate_id) VALUES('C125','2016-01-01','Certificate in TOEIC','ETS','C103');
INSERT INTO certificates(certificate_id,issue_date,name,organization,candidate_id) VALUES('C126','2017-01-01','Certificate in GRE','ETS','C104');
INSERT INTO certificates(certificate_id,issue_date,name,organization,candidate_id) VALUES('C127','2018-01-01','Certificate in GMAT','GMAC','C105');

select * from certificates;

-- Inserting data into the experiences table

INSERT INTO experiences(company_name,from_date,to_date,description,candidate_id,position_id) VALUES('Google Inc.','2011-01-01','2012-01-01','Software Engineer','C101','P101');
INSERT INTO experiences(company_name,from_date,to_date,description,candidate_id,position_id) VALUES('Microsoft Corporation','2012-01-01','2016-01-01','Database Administrator','C101','P102');
INSERT INTO experiences(company_name,from_date,to_date,description,candidate_id,position_id) VALUES('Oracle Corporation','2013-01-01','2017-01-01','Network Administrator','C101','P103');
INSERT INTO experiences(company_name,from_date,to_date,description,candidate_id,position_id) VALUES('FSOFT','2016-01-01','2023-01-01','Network Administrator','C101','P103');
INSERT INTO experiences(company_name,from_date,to_date,description,candidate_id,position_id) VALUES('IBM Corporation','2017-01-01','2020-01-01','Web Developer','C101','P104');
INSERT INTO experiences(company_name,from_date,to_date,description,candidate_id,position_id) VALUES('Tiki Corporation','2018-01-01','2019-01-01','Web Developer','C102','P104');
INSERT INTO experiences(company_name,from_date,to_date,description,candidate_id,position_id) VALUES('VNG Corporation','2019-01-01','2023-01-01','Quality Assurance Engineer','C102','P105');
INSERT INTO experiences(company_name,from_date,to_date,description,candidate_id,position_id) VALUES('FPT Corporation','2020-01-01','2023-01-01','Systems Analyst','C103','P101');
INSERT INTO experiences(company_name,from_date,to_date,description,candidate_id,position_id) VALUES('VinGroup','2021-01-01','2023-01-01','Project Manager','C104','P107');
INSERT INTO experiences(company_name,from_date,to_date,description,candidate_id,position_id) VALUES('SunGroup','2015-01-01','2020-01-01','Business Analyst','C105','P108');
INSERT INTO experiences(company_name,from_date,to_date,description,candidate_id,position_id) VALUES('VinaPhone','2020-01-01','2023-01-01','Technical Support Specialist','C105','P109');
INSERT INTO experiences(company_name,from_date,to_date,description,candidate_id,position_id) VALUES('Viettel Corporation','2021-01-01','2023-01-01','IT Security Specialist','C106','P110');
INSERT INTO experiences(company_name,from_date,to_date,description,candidate_id,position_id) VALUES('Vietnam Airlines','2019-01-01','2021-01-01','Software Engineer','C106','P101');
INSERT INTO experiences(company_name,from_date,to_date,description,candidate_id,position_id) VALUES('DHL Corporation','2020-01-01','2023-01-01','Database Administrator','C107','P102');
INSERT INTO experiences(company_name,from_date,to_date,description,candidate_id,position_id) VALUES('FedEx Corporation','2017-01-01','2020-01-01','Network Administrator','C107','P103');

select * from experiences;