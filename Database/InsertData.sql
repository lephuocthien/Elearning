USE elearning;

-- Insert data to roles
INSERT INTO roles( name, description ) VALUES ("ROLE_ADMIN", "Quản trị hệ thống");
INSERT INTO roles( name, description ) VALUES ("ROLE_TEACHER", "Giáo viên");
INSERT INTO roles( name, description ) VALUES ("ROLE_USER", "Học viên");

-- Inser data to categories
insert into categories (title, icon) values ('Development', 'fa fa-laptop');
insert into categories (title, icon) values ('Photography', 'fa fa-camera-retro');
insert into categories (title, icon) values ('Business', 'fa fa-bar-chart');
insert into categories (title, icon) values ('IT & Software', 'fa fa-desktop');
insert into categories (title, icon) values ('Marketing', 'fa fa-handshake-o');
insert into categories (title, icon) values ('Music', 'fa fa-music');
insert into categories (title, icon) values ('Design', 'fa fa-pencil-square-o');
insert into categories (title, icon) values ('Cooking', 'fa fa-cutlery');

-- Insert data to users
insert into users (email, fullname, password, avatar, phone, address, role_id) values ('wmenary0@slate.com', 'Wilone Menary', '$2a$10$sGe24ieMWTvF5vmZ.TntoO3k/Iqnl8V5SeLrCu72IgDugI/.zLOEe', 'https://robohash.org/officiisfaceremolestias.jpg?size=50x50&set=set1', '194-528-9732', '55334 Prairie Rose Parkway', 1);
insert into users (email, fullname, password, avatar, phone, address, role_id) values ('mcornhill1@washington.edu', 'Marjy Cornhill', 'Z4scCpLHcW0a', 'https://robohash.org/temporaautemasperiores.jpg?size=50x50&set=set1', '338-330-8921', '68 Gerald Place', 2);
insert into users (email, fullname, password, avatar, phone, address, role_id) values ('nhiseman2@nih.gov', 'Natka Hiseman', 'z5qnA7UNg', 'https://robohash.org/sedsaepecorporis.jpg?size=50x50&set=set1', '873-178-2150', '184 Monterey Place', 2);
insert into users (email, fullname, password, avatar, phone, address, role_id) values ('hyate3@howstuffworks.com', 'Hoebart Yate', 'mX8gKXKDRBE', 'https://robohash.org/laboresedaut.jpg?size=50x50&set=set1', '760-449-4620', '3389 Moulton Alley', 2);
insert into users (email, fullname, password, avatar, phone, address, role_id) values ('ckreber4@boston.com', 'Claudio Kreber', 'RTAxAkHn', 'https://robohash.org/utnihilnesciunt.jpg?size=50x50&set=set1', '212-906-7846', '8870 Blue Bill Park Plaza', 1);
insert into users (email, fullname, password, avatar, phone, address, role_id) values ('wle5@google.ru', 'Woody Le Merchant', 'WxKnAp', 'https://robohash.org/eadelenitiet.jpg?size=50x50&set=set1', '288-501-6552', '00602 Anderson Court', 1);
insert into users (email, fullname, password, avatar, phone, address, role_id) values ('asousa6@github.com', 'Adelaida Sousa', '9k52Txh5B', 'https://robohash.org/rerumducimuscorrupti.jpg?size=50x50&set=set1', '207-886-6028', '19 Stuart Trail', 1);
insert into users (email, fullname, password, avatar, phone, address, role_id) values ('rcarek7@skype.com', 'Rosemary Carek', 'JGINa3mb', 'https://robohash.org/undeimpeditomnis.jpg?size=50x50&set=set1', '177-609-0393', '6956 Summerview Court', 2);
insert into users (email, fullname, password, avatar, phone, address, role_id) values ('tferenczi8@nbcnews.com', 'Tedmund Ferenczi', 'mpz1FveA', 'https://robohash.org/autquisquamqui.jpg?size=50x50&set=set1', '694-424-6561', '8 Cody Trail', 1);
insert into users (email, fullname, password, avatar, phone, address, role_id) values ('alovelace9@shop-pro.jp', 'Arabele Lovelace', 'VgU1EPZCY', 'https://robohash.org/iurequidolores.jpg?size=50x50&set=set1', '700-868-2727', '0 Ruskin Center', 3);

-- Insert data to courses
insert into courses (title, image, letures_count, hour_count, view_count, price, discount, promotion_price, description, content, category_id) values ('Business Systems Development Analyst', 'http://dummyimage.com/181x214.bmp/dddddd/000000', 33, 51, 93752, 2979698, 41, 1758021, 'adipiscing lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc', 'at vulputate vitae nisl aenean lectus pellentesque eget nunc donec quis orci eget orci vehicula condimentum curabitur in libero ut massa volutpat convallis morbi odio odio elementum eu interdum eu tincidunt in leo maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc proin at turpis a pede posuere nonummy integer non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante ipsum', 1);
insert into courses (title, image, letures_count, hour_count, view_count, price, discount, promotion_price, description, content, category_id) values ('Human Resources Manager', 'http://dummyimage.com/246x166.jpg/cc0000/ffffff', 91, 44, 451133, 1000840, 26, 740621, 'eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla', 'nisl nunc nisl duis bibendum felis sed interdum venenatis turpis enim blandit mi in porttitor pede justo eu massa donec dapibus duis at velit eu est congue elementum in hac habitasse platea dictumst morbi vestibulum velit id pretium iaculis diam erat fermentum justo', 4);
insert into courses (title, image, letures_count, hour_count, view_count, price, discount, promotion_price, description, content, category_id) values ('Financial Analyst', 'http://dummyimage.com/235x212.bmp/dddddd/000000', 60, 43, 122540, 1409087, 22, 1099087, 'lectus in quam fringilla rhoncus mauris enim leo rhoncus sed vestibulum', 'ultrices aliquet maecenas leo odio condimentum id luctus nec molestie sed justo pellentesque viverra pede ac diam cras pellentesque volutpat dui maecenas tristique est et tempus semper est', 2);
insert into courses (title, image, letures_count, hour_count, view_count, price, discount, promotion_price, description, content, category_id) values ('Human Resources Manager', 'http://dummyimage.com/167x102.jpg/ff4444/ffffff', 45, 57, 185361, 1686494, 46, 910706, 'gravida sem praesent id massa id nisl venenatis lacinia aenean sit amet justo', 'quisque ut erat curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit nam', 5);
insert into courses (title, image, letures_count, hour_count, view_count, price, discount, promotion_price, description, content, category_id) values ('Administrative Assistant III', 'http://dummyimage.com/213x186.bmp/5fa2dd/ffffff', 59, 48, 622361, 1991011, 75, 497752, 'quam nec dui luctus rutrum nulla tellus in sagittis dui vel nisl duis ac', 'amet justo morbi ut odio cras mi pede malesuada in imperdiet et commodo vulputate justo in blandit ultrices enim lorem ipsum dolor sit amet consectetuer adipiscing elit proin interdum mauris non ligula pellentesque ultrices phasellus id sapien in sapien iaculis congue', 4);
insert into courses (title, image, letures_count, hour_count, view_count, price, discount, promotion_price, description, content, category_id) values ('Electrical Engineer', 'http://dummyimage.com/224x241.jpg/dddddd/000000', 37, 23, 352263, 1239892, 22, 967115, 'aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien non mi integer', 'a odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam', 3);
insert into courses (title, image, letures_count, hour_count, view_count, price, discount, promotion_price, description, content, category_id) values ('Staff Accountant III', 'http://dummyimage.com/184x163.bmp/dddddd/000000', 32, 34, 409458, 1780592, 54, 819072, 'in tempus sit amet sem fusce consequat nulla nisl nunc nisl duis', 'quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus etiam', 7);
insert into courses (title, image, letures_count, hour_count, view_count, price, discount, promotion_price, description, content, category_id) values ('Developer IV', 'http://dummyimage.com/223x175.jpg/dddddd/000000', 71, 25, 12469, 2967504, 13, 2581728, 'posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl', 'risus semper porta volutpat quam pede lobortis ligula sit amet eleifend', 8);
insert into courses (title, image, letures_count, hour_count, view_count, price, discount, promotion_price, description, content, category_id) values ('Executive Secretary', 'http://dummyimage.com/209x131.jpg/dddddd/000000', 32, 60, 350095, 2840325, 76, 681678, 'ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae nulla dapibus', 'morbi non lectus aliquam sit amet diam in magna bibendum imperdiet nullam', 2);
insert into courses (title, image, letures_count, hour_count, view_count, price, discount, promotion_price, description, content, category_id) values ('Structural Engineer', 'http://dummyimage.com/166x168.jpg/cc0000/ffffff', 90, 41, 803319, 1376374, 27, 1004753, 'vel augue vestibulum rutrum rutrum neque aenean auctor gravida sem praesent id massa id nisl', 'in blandit ultrices enim lorem ipsum dolor sit amet consectetuer adipiscing elit proin interdum mauris non ligula pellentesque ultrices phasellus id sapien in', 3);

-- Inser data to user_courses
insert into user_courses (user_id, course_id, role_id) values (2, 4, 2);
insert into user_courses (user_id, course_id, role_id) values (3, 9, 2);
insert into user_courses (user_id, course_id, role_id) values (6, 6, 1);
insert into user_courses (user_id, course_id, role_id) values (4, 8, 2);
insert into user_courses (user_id, course_id, role_id) values (2, 7, 2);
insert into user_courses (user_id, course_id, role_id) values (2, 9, 2);
insert into user_courses (user_id, course_id, role_id) values (7, 10, 1);
insert into user_courses (user_id, course_id, role_id) values (8, 4, 2);
insert into user_courses (user_id, course_id, role_id) values (3, 4, 2);
insert into user_courses (user_id, course_id, role_id) values (8, 1, 2);

-- Insert data to target
insert into targets (title, course_id) values ('eget vulputate ut ultrices vel augue vestibulum ante ipsum primis in faucibus', 6);
insert into targets (title, course_id) values ('ante vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere', 7);
insert into targets (title, course_id) values ('ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae', 3);
insert into targets (title, course_id) values ('vel est donec odio justo sollicitudin ut suscipit a feugiat et eros vestibulum ac est', 2);
insert into targets (title, course_id) values ('blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit', 7);
insert into targets (title, course_id) values ('non velit donec diam neque vestibulum eget vulputate ut ultrices', 3);
insert into targets (title, course_id) values ('duis bibendum felis sed interdum venenatis turpis enim blandit mi in', 5);
insert into targets (title, course_id) values ('est phasellus sit amet erat nulla tempus vivamus in felis eu', 1);
insert into targets (title, course_id) values ('ut erat curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam augue', 10);
insert into targets (title, course_id) values ('a pede posuere nonummy integer non velit donec diam neque vestibulum eget vulputate ut ultrices', 1);

-- Insert data to videos
insert into videos (title, url, time_count, course_id) values ('Sales Associate', 'https://usda.gov/vestibulum/ante/ipsum/primis/in.html', 47, 5);
insert into videos (title, url, time_count, course_id) values ('Speech Pathologist', 'https://umn.edu/tincidunt/nulla.png', 68, 10);
insert into videos (title, url, time_count, course_id) values ('Account Executive', 'https://devhub.com/dui.aspx', 57, 10);
insert into videos (title, url, time_count, course_id) values ('Technical Writer', 'http://surveymonkey.com/maecenas/tristique/est/et/tempus/semper/est.xml', 42, 5);
insert into videos (title, url, time_count, course_id) values ('Dental Hygienist', 'https://economist.com/dolor/morbi/vel.js', 34, 10);
insert into videos (title, url, time_count, course_id) values ('Librarian', 'https://answers.com/vel/augue/vestibulum/ante.xml', 37, 5);
insert into videos (title, url, time_count, course_id) values ('Software Consultant', 'https://netlog.com/nec/sem/duis/aliquam/convallis/nunc.js', 81, 4);
insert into videos (title, url, time_count, course_id) values ('Recruiter', 'http://unesco.org/nisi/volutpat/eleifend/donec/ut.jpg', 50, 5);
insert into videos (title, url, time_count, course_id) values ('Systems Administrator IV', 'https://canalblog.com/amet/consectetuer.js', 76, 7);
insert into videos (title, url, time_count, course_id) values ('Information Systems Manager', 'http://dell.com/auctor/sed/tristique/in/tempus/sit/amet.jpg', 49, 1);


