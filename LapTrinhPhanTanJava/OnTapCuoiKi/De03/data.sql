use abc
go
-- Insert data into people table

INSERT INTO people (person_id, first_name, last_name, email, professional_title) VALUES(1, 'John', 'Doe', 'john.doe@gmail.com', 'Administrator Assistant');
INSERT INTO people (person_id, first_name, last_name, email, professional_title) VALUES(2, 'Jill', 'Johnson', 'jill.johnson@gmail.com', 'Software Engineer');
INSERT INTO people (person_id, first_name, last_name, email, professional_title) VALUES(3, 'Jack', 'Wilson', 'jack.wilson@gmail.com', 'Database Administrator');
INSERT INTO people (person_id, first_name, last_name, email, professional_title) VALUES(4, 'Jane', 'Smith', 'jane.smith@gmail.com', 'Network Administrator');
INSERT INTO people (person_id, first_name, last_name, email, professional_title) VALUES(5, 'Jerry', 'Brown', 'jerry.brown@gmail.com', 'Web Developer');
INSERT INTO people (person_id, first_name, last_name, email, professional_title) VALUES(6, 'Jackie', 'White', 'jackie.white@gmail.com', 'Quality Assurance Engineer');
INSERT INTO people (person_id, first_name, last_name, email, professional_title) VALUES(7, 'Jim', 'Black', 'jim.black@gmail.com', 'Systems Analyst');
INSERT INTO people (person_id, first_name, last_name, email, professional_title) VALUES(8, 'Jennifer', 'Green', 'jennifer.green@gmail.com', 'Project Manager');
INSERT INTO people (person_id, first_name, last_name, email, professional_title) VALUES(9, 'Jane', 'Doe', 'jane.doe@gmail.com', 'Business Analyst');
INSERT INTO people (person_id, first_name, last_name, email, professional_title) VALUES(10, 'Jill', 'Wilson', 'jill.wilson@gmail.com', 'Technical Support Specialist');
INSERT INTO people (person_id, first_name, last_name, email, professional_title) VALUES(11, 'Jose', 'Herrera', 'jose.herrera@gmail.com', 'IT Security Specialist');
INSERT INTO people (person_id, first_name, last_name, email, professional_title) VALUES(12, 'Maria', 'Garcia', 'maria.garcia@gmail.com', 'Executive Assistant');
INSERT INTO people (person_id, first_name, last_name, email, professional_title) VALUES(13, 'Carlos', 'Martinez', 'carlos.martinez@gmail.com', 'Marketing Manager');
INSERT INTO people (person_id, first_name, last_name, email, professional_title) VALUES(14, 'Ana', 'Lopez', 'ana.lopez@gmail.com', 'Human Resources Manager');
INSERT INTO people (person_id, first_name, last_name, email, professional_title) VALUES(15, 'Luis', 'Gonzalez', 'luis.gonzalez@gmail.com', 'Financial Analyst');
INSERT INTO people (person_id, first_name, last_name, email, professional_title) VALUES(16, 'Angel', 'Rodriguez', 'angel.rodriguez@gmail.com', 'Customer Service Representative');
INSERT INTO people (person_id, first_name, last_name, email, professional_title) VALUES(17, 'Juan', 'Perez', 'juan.perez@gmail.com', 'Sales Representative');
INSERT INTO people (person_id, first_name, last_name, email, professional_title) VALUES(18, 'Miguel', 'Sanchez', 'miguel.sanchez@gmail.com', 'Nurse Practitioner');
INSERT INTO people (person_id, first_name, last_name, email, professional_title) VALUES(19, 'Sofia', 'Rivera', 'sofia.rivera@gmail.com', 'Physical Therapist');
INSERT INTO people (person_id, first_name, last_name, email, professional_title) VALUES(20, 'Jose', 'Torres', 'jose.torres@gmail.com', 'Occupational Therapist');

select * from people;


-- Insert data into publishers table

INSERT INTO publishers (publisher_id, name, address, email, phone) VALUES('P101','Pearson Education','221 River Street','pearson.education@pub.com','123-456-7890');
INSERT INTO publishers (publisher_id, name, address, email, phone) VALUES('P102','McGraw-Hill Education','1221 Avenue of the Americas','mcgraw.hill.education@pub.com','234-234-1234');
INSERT INTO publishers (publisher_id, name, address, email, phone) VALUES('P103','Houghton Mifflin Harcourt','222 Berkeley Street','houghton.mifflin.harcourt@pub.com','345-543-2345');
INSERT INTO publishers (publisher_id, name, address, email, phone) VALUES('P104','Cengage Learning','10650 Toebben Drive','cengage.learning@pub.com','456-654-3456');
INSERT INTO publishers (publisher_id, name, address, email, phone) VALUES('P105','Wiley','111 River Street','wiley@pub.com','567-765-4567')
INSERT INTO publishers (publisher_id, name, address, email, phone) VALUES('P106','Oxford University Press','2001 Evans Road','oxford.university.press@pub.com','678-876-5678');
INSERT INTO publishers (publisher_id, name, address, email, phone) VALUES('P107','Cambridge University Press','100 Brook Hill Drive','cambridge.university.press@pub.com','789-987-6789');
INSERT INTO publishers (publisher_id, name, address, email, phone) VALUES('P108','Macmillan Publishers','100 Front Street','macmillan.publishers@pub.com','890-098-7890');
INSERT INTO publishers (publisher_id, name, address, email, phone) VALUES('P109','Elsevier','123 Park Avenue','elsevier@pub.com','901-109-8901');
INSERT INTO publishers (publisher_id, name, address, email, phone) VALUES('P110','Springer Nature','23 Main Street','springer.nature@pub.com','012-210-9012');
INSERT INTO publishers (publisher_id, name, address, email, phone) VALUES('P111','Random House','15 Elm Street','random.house@pub.com','123-321-0123');
INSERT INTO publishers (publisher_id, name, address, email, phone) VALUES('P112','Penguin Random House','45 Main Street','penguin.random.house@pub.com','567-765-4567');
INSERT INTO publishers (publisher_id, name, address, email, phone) VALUES('P113','HarperCollins','45 Elm Street','harpercollins@pub.com','678-876-5678');
INSERT INTO publishers (publisher_id, name, address, email, phone) VALUES('P114','Simon & Schuster','98 Main Street','simon.schuster@pub.com','789-987-6789');
INSERT INTO publishers (publisher_id, name, address, email, phone) VALUES('P115','Scholastic','65 Elm Street','scholastic@pub.com','890-098-7890');
INSERT INTO publishers (publisher_id, name, address, email, phone) VALUES('P116','Hachette Livre','132 Main Street','hachette.livre@pub.com','901-109-8901')
INSERT INTO publishers (publisher_id, name, address, email, phone) VALUES('P117','Holtzbrinck Publishing Group','176 Elm Street','holtzbrinck.publishing.group@pub.com','012-210-9012');
INSERT INTO publishers (publisher_id, name, address, email, phone) VALUES('P118','Bertelsmann','101 Main Street','bertelsmann@pub.com','454-321-4352');
INSERT INTO publishers (publisher_id, name, address, email, phone) VALUES('P119','Harlequin Enterprises','56 Elm Street','harlequin.enterprises@pub.com','567-765-4567');

SELECT * FROM publishers order by name;


-- Insert data into books table

INSERT INTO books (ISBN, name, publish_year, num_of_pages, price, publisher_id) VALUES('978-0132350884','Clean Code: A Handbook of Agile Software Craftsmanship',2008,464,30,'P101');
INSERT INTO books (ISBN, name, publish_year, num_of_pages, price, publisher_id) VALUES('978-0201633610','Design Patterns: Elements of Reusable Object-Oriented Software',1994,416,40,'P105');
INSERT INTO books (ISBN, name, publish_year, num_of_pages, price, publisher_id) VALUES('978-0324445217','The Pragmatic Programmer: Your Journey to Mastery',1999,352,35,'P105');
INSERT INTO books (ISBN, name, publish_year, num_of_pages, price, publisher_id) VALUES('978-0201835953','Refactoring: Improving the Design of Existing Code',1999,464,30,'P107');
INSERT INTO books (ISBN, name, publish_year, num_of_pages, price, publisher_id) VALUES('978-0201485677','Introduction to the Theory of Computation',1996,450,50,'P108');
INSERT INTO books (ISBN, name, publish_year, num_of_pages, price, publisher_id) VALUES('978-0321125217','Domain-Driven Design: Tackling Complexity in the Heart of Software',2003,560,45,'P109');
INSERT INTO books (ISBN, name, publish_year, num_of_pages, price, publisher_id) VALUES('978-0321127426','Agile Software Development Principles Patterns and Practices',2002,576,40,'P110');
INSERT INTO books (ISBN, name, publish_year, num_of_pages, price, publisher_id) VALUES('978-0321150783','Test Driven Development: By Example',2002,240,25,'P111');
INSERT INTO books (ISBN, name, publish_year, num_of_pages, price, publisher_id) VALUES('978-0321336389','Patterns of Enterprise Application Architecture',2002,560,45,'P105');
INSERT INTO books (ISBN, name, publish_year, num_of_pages, price, publisher_id) VALUES('978-0321486813','Working Effectively with Legacy Code',2004,456,35,'P104');
INSERT INTO books (ISBN, name, publish_year, num_of_pages, price, publisher_id) VALUES('978-0321573519','Continuous Delivery: Reliable Software Releases through Build Test and Deployment Automation',2010,512,40,'P114');
INSERT INTO books (ISBN, name, publish_year, num_of_pages, price, publisher_id) VALUES('888-0132350800','Javascript: A Handbook of Agile Software Craftsmanship',2008,464,30,'P115');
INSERT INTO books (ISBN, name, publish_year, num_of_pages, price, publisher_id) VALUES('888-0201553610','Java: Elements of Reusable Object-Oriented Software',1994,416,40,'P118');
INSERT INTO books (ISBN, name, publish_year, num_of_pages, price, publisher_id) VALUES('888-0324488217','Python: Your Journey to Mastery',1999,352,35,'P114');
INSERT INTO books (ISBN, name, publish_year, num_of_pages, price, publisher_id) VALUES('888-0201135953','React: Improving the Design of Existing Code',1999,464,30,'P116');
INSERT INTO books (ISBN, name, publish_year, num_of_pages, price, publisher_id) VALUES('888-0201499677','Angular: Introduction to the Theory of Computation',1996,450,50,'P117');
INSERT INTO books (ISBN, name, publish_year, num_of_pages, price, publisher_id) VALUES('888-0321115217','VueJS: Tackling Complexity in the Heart of Software',2003,560,45,'P118');
INSERT INTO books (ISBN, name, publish_year, num_of_pages, price, publisher_id) VALUES('888-0387127426','NodeJS Principles Patterns and Practices',2002,576,40,'P104');
INSERT INTO books (ISBN, name, publish_year, num_of_pages, price, publisher_id) VALUES('888-0321660783','ExpressJS: By Example',2002,240,25,'P119');
INSERT INTO books (ISBN, name, publish_year, num_of_pages, price, publisher_id) VALUES('888-0321345389','Patterns of Enterprise Application Architecture',2002,560,45,'P105');

SELECT * FROM books;


-- Insert data into book_translations table

INSERT INTO book_translations (ISBN, translate_name, language) VALUES('888-0324488217',N'Python: Hướng dẫn từ cơ bản đến nâng cao','Vietnamese');
INSERT INTO book_translations (ISBN, translate_name, language) VALUES('888-0201553610',N'Java: Tái sử dụng phần mềm hướng đối tượng','Vietnamese');
INSERT INTO book_translations (ISBN, translate_name, language) VALUES('888-0132350800',N'Javascript: Sách tay về nghệ thuật phần mềm linh hoạt','Vietnamese');
INSERT INTO book_translations (ISBN, translate_name, language) VALUES('888-0201135953',N'React: Cải thiện thiết kế mã nguồn hiện tại','Vietnamese');
INSERT INTO book_translations (ISBN, translate_name, language) VALUES('888-0201499677',N'Angular: Giới thiệu về lý thuyết tính toán','Vietnamese');
INSERT INTO book_translations (ISBN, translate_name, language) VALUES('888-0321115217',N'VueJS: Đối mặt với sự phức tạp trong trái tim phần mềm','Vietnamese');
INSERT INTO book_translations (ISBN, translate_name, language) VALUES('888-0387127426',N'NodeJS: Nguyên tắc Mẫu và Thực hành','Vietnamese');
INSERT INTO book_translations (ISBN, translate_name, language) VALUES('888-0321660783',N'ExpressJS: Bằng ví dụ','Vietnamese');
INSERT INTO book_translations (ISBN, translate_name, language) VALUES('888-0321345389',N'Patterns of Enterprise Application Architecture','Vietnamese');

SELECT * FROM book_translations;



-- Insert data into reviews table

INSERT INTO reviews (rating, comment, ISBN, person_id) VALUES(4, 'Good book for learning design patterns', '978-0201633610', 1);
INSERT INTO reviews (rating, comment, ISBN, person_id) VALUES(3, 'Not bad but could be better', '978-0201633610', 2);
INSERT INTO reviews (rating, comment, ISBN, person_id) VALUES(5, 'Excellent book on refactoring', '978-0201835953', 3);
INSERT INTO reviews (rating, comment, ISBN, person_id) VALUES(4, 'Good introduction to the theory of computation', '978-0201485677', 4);
INSERT INTO reviews (rating, comment, ISBN, person_id) VALUES(5, 'Highly recommended for domain-driven design', '978-0321125217', 5);
INSERT INTO reviews (rating, comment, ISBN, person_id) VALUES(4, 'Very informative and practical', '978-0321127426', 6);
INSERT INTO reviews (rating, comment, ISBN, person_id) VALUES(3, 'Not very useful for test-driven development', '978-0321150783', 7);
INSERT INTO reviews (rating, comment, ISBN, person_id) VALUES(5, 'Great book on enterprise application architecture', '978-0321336389', 8);
INSERT INTO reviews (rating, comment, ISBN, person_id) VALUES(4, 'Very helpful for working with legacy code', '978-0321486813', 9);
INSERT INTO reviews (rating, comment, ISBN, person_id) VALUES(5, 'Excellent book on continuous delivery', '978-0321573519', 10);
INSERT INTO reviews (rating, comment, ISBN, person_id) VALUES(4, 'Good book for learning javascript', '888-0132350800', 11);
INSERT INTO reviews (rating, comment, ISBN, person_id) VALUES(3, 'Not bad but could be better', '888-0201553610', 12);
INSERT INTO reviews (rating, comment, ISBN, person_id) VALUES(5, 'Excellent book on python', '888-0324488217', 13);
INSERT INTO reviews (rating, comment, ISBN, person_id) VALUES(4, 'Good introduction to the theory of computation', '888-0201499677', 14);
INSERT INTO reviews (rating, comment, ISBN, person_id) VALUES(5, 'Highly recommended for tackling complexity in software', '888-0321115217', 15);
INSERT INTO reviews (rating, comment, ISBN, person_id) VALUES(4, 'Very informative and practical', '888-0387127426', 16);
INSERT INTO reviews (rating, comment, ISBN, person_id) VALUES(3, 'Not very useful for by example', '888-0321660783', 17);
INSERT INTO reviews (rating, comment, ISBN, person_id) VALUES(5, 'Great book on enterprise application architecture', '888-0321345389', 18);
INSERT INTO reviews (rating, comment, ISBN, person_id) VALUES(4, 'Very helpful for working with legacy code', '888-0387127426', 19);

SELECT * FROM reviews;


-- Insert data into books_authors table
INSERT INTO books_authors (ISBN, author) VALUES('978-0132350884','Robert C. Martin');
INSERT INTO books_authors (ISBN, author) VALUES('978-0201633610','Erich Gamma');
INSERT INTO books_authors (ISBN, author) VALUES('978-0201633610','Richard Helm');
INSERT INTO books_authors (ISBN, author) VALUES('978-0201633610','Ralph Johnson');
INSERT INTO books_authors (ISBN, author) VALUES('978-0201633610','John Vlissides');
INSERT INTO books_authors (ISBN, author) VALUES('978-0324445217','Andrew Hunt');
INSERT INTO books_authors (ISBN, author) VALUES('978-0324445217','David Thomas');
INSERT INTO books_authors (ISBN, author) VALUES('978-0201835953','Martin Fowler');
INSERT INTO books_authors (ISBN, author) VALUES('978-0201485677','Michael Sipser');
INSERT INTO books_authors (ISBN, author) VALUES('978-0321125217','Eric Evans');
INSERT INTO books_authors (ISBN, author) VALUES('978-0321127426','Robert C. Martin');
INSERT INTO books_authors (ISBN, author) VALUES('978-0321150783','Kent Beck');
INSERT INTO books_authors (ISBN, author) VALUES('978-0321336389','Martin Fowler');
INSERT INTO books_authors (ISBN, author) VALUES('978-0321486813','Michael Feathers');
INSERT INTO books_authors (ISBN, author) VALUES('978-0321573519','Jez Humble');
INSERT INTO books_authors (ISBN, author) VALUES('978-0321573519','David Farley');
INSERT INTO books_authors (ISBN, author) VALUES('888-0132350800','Robert C. Martin');
INSERT INTO books_authors (ISBN, author) VALUES('888-0201553610','Erich Gamma');
INSERT INTO books_authors (ISBN, author) VALUES('888-0201553610','Richard Helm');
INSERT INTO books_authors (ISBN, author) VALUES('888-0201553610','Ralph Johnson');
INSERT INTO books_authors (ISBN, author) VALUES('888-0201553610','John Vlissides');
INSERT INTO books_authors (ISBN, author) VALUES('888-0324488217','Andrew Hunt');
INSERT INTO books_authors (ISBN, author) VALUES('888-0324488217','David Thomas');
INSERT INTO books_authors (ISBN, author) VALUES('888-0201135953','Martin Fowler');
INSERT INTO books_authors (ISBN, author) VALUES('888-0201499677','Michael Sipser');
INSERT INTO books_authors (ISBN, author) VALUES('888-0321115217','Eric Evans');
INSERT INTO books_authors (ISBN, author) VALUES('888-0387127426','Robert C. Martin');
INSERT INTO books_authors (ISBN, author) VALUES('888-0321660783','Kent Beck');
INSERT INTO books_authors (ISBN, author) VALUES('888-0321345389','Martin Fowler');

SELECT * FROM books_authors;


use abc
go


use PatientDB
go


