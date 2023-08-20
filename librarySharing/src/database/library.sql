DROP DATABASE IF EXISTS `UrbanBookSharing`;
CREATE DATABASE IF NOT EXISTS `UrbanBookSharing`;
USE  `UrbanBookSharing`;

-- -- 按Book name 和Writer Name确定书籍内容
-- CREATE TABLE IF NOT EXISTS `BContent`(
--   `BnwID` INT NOT NULL AUTO_INCREMENT,
--   `Bookname` VARCHAR(80) NOT NULL,
--   `Writer` VARCHAR(80) NOT NULL,
--   `Score` FLOAT,
--   PRIMARY KEY(`BnwID`),
--   INDEX (`Bookname`),
--   INDEX (`Writer`)
-- );
-- -- 出版物 同一BContent可能有不同的出版版本
-- -- 同一书号的书可能有好几本
-- CREATE TABLE IF NOT EXISTS `Publication`(
  
--   `ISBN` VARCHAR(15) NOT NULL,
--   `BnwID` INT NOT NULL,
--   `Publisher` VARCHAR(80) NOT NULL,
--   `MainType` VARCHAR(10),
--   PRIMARY KEY(`ISBN`),
--   CONSTRAINT `fk_pub`  FOREIGN KEY (`BnwID`) REFERENCES `BContent` (`BnwID`),
--   INDEX `BnwID_idx`(`BnwID`)
-- );

CREATE TABLE `ClassInfo` 
( `class_id` INT NOT NULL PRIMARY KEY, 
`class_name` VARCHAR ( 15 ) NOT NULL
 ) ;

INSERT INTO `ClassInfo`
VALUES
	( 1, '马克思主义' ),
	( 2, '哲学' ),
	( 3, '社会科学总论' ),
	( 4, '政治法律' ),
	( 5, '军事' ),
	( 6, '经济' ),
	( 7, '文化' ),
	( 8, '语言' ),
	( 9, '文学' ),
	( 10, '艺术' ),
	( 11, '历史地理' ),
	( 12, '自然科学总论' ),
	( 13, ' 数理科学和化学' ),
	( 14, '天文学、地球科学' ),
	( 15, '生物科学' ),
	( 16, '医药、卫生' ),
	( 17, '农业科学' ),
	( 18, '工业技术' ),
	( 19, '交通运输' ),
	( 20, '航空、航天' ),
	( 21, '环境科学' ),
	( 22, '综合' );

CREATE TABLE `Publication` (
    `BnwID` INT NOT NULL ,
	`name` VARCHAR ( 20 ) NOT NULL,
	`author` VARCHAR ( 15 ) NOT NULL,
	`publish` VARCHAR ( 20 ) DEFAULT NULL,
	`ISBN` VARCHAR ( 15 ) NOT NULL  PRIMARY KEY,
	`introduction` text,
	`language` VARCHAR ( 4 ),
	`price` DECIMAL ( 10, 2 ) ,
	`pub_date` date DEFAULT NULL,
	`class_id` INT DEFAULT NULL,
    CONSTRAINT `fk_class`  FOREIGN KEY (`class_id`) REFERENCES `ClassInfo` (`class_id`)
);

INSERT INTO `Publication`
VALUES
	(1, '大雪中的山庄', '东野圭吾 ', '北京十月文艺出版社', '9787530216835', '一家与外界隔绝的民宿里，七个演员被要求住满四天，接受导演的考验，但不断有人失踪。难道这并非正常排练，而是有人布下陷阱要杀他们。', '中文', '35.00', '2017-06-01', 9 ),
    (2, '白夜行', '东野圭吾', '南海出版公司', '9787544242519', '一场离奇的谋杀案，两个少年的命运交错。', '中文', '29.80', '2008-09-01', 9),
    (3, '解忧杂货店', '东野圭吾', '南海出版公司', '9787544270871', '一家神秘的杂货店，解决人们的烦恼。', '中文', '39.50', '2014-05-01', 9),
    (4, '嫌疑人X的献身', '东野圭吾', '南海出版公司', '9787544245855', '一场完美的犯罪，一位天才的数学家。', '中文', '29.80', '2008-09-01', 9),
    (5, '放学后', '东野圭吾', '南海出版公司', '9787544277610', '一群小学生的游戏，隐藏着惊人的秘密。', '中文', '29.80', '2015-01-01', 9),
    (6,'秘密', '东野圭吾', '南海出版公司', '9787544247088', '一个女孩的死亡，一个家庭的秘密。', '中文', '29.80', '2009-01-01', 9),
    (7, '虚无的十字架', '东野圭吾', '南海出版公司', '9787544253997', '一场神秘的失踪案，一段扑朔迷离的过去。', '中文', '29.80', '2010-01-01', 9),
    (8,'恶意', '东野圭吾', '南海出版公司', '9787544270870', '一场离奇的杀人案，一段被遗忘的过去。', '中文', '29.80', '2013-01-01', 9),   
    ( 9,'人类简史', '尤瓦尔·赫拉利', '中信出版社', '9787508647357', '我们是如何登上世界舞台成为万物之灵的', '英文', '68.00', '2014-11-01', 11 ),
	( 10,'明朝那些事儿（1-9）', '当年明月 ', '中国海关出版社', '9787801656087', '《明朝那些事儿》讲述从1344年到1644年，明朝三百年间的历史。作品以史料为基础，以年代和具体人物为主线，运用小说的笔法，对明朝十七帝和其他王公权贵和小人物的命运进行全景展示，尤其对官场政治、战争、帝王心术着墨最多。', '中文', '358.20', '2009-04-06', 11),
	( 11,'经济学原理（上下）', '[美] 曼昆 ', '机械工业出版社', '9787111126768', '此《经济学原理》的第3版把较多篇幅用于应用与政策，较少篇幅用于正规的经济理论。书中主要从供给与需求、企业行为与消费者选择理论、长期经济增长与短期经济波动以及宏观经济政策等角度深入浅出地剖析了经济学家们的世界观。', '英文', '88.00', '2003-08-05', 6 ),
	( 12, '方向', '马克-安托万·马修 ', '后浪丨北京联合出版公司', '9787020125265', '《方向》即便在马修的作品中也算得最独特的：不着一字，尽得风流。原作本无一字，标题只是一个→，出版时才加了个书名Sens——既可以指“方向”，也可以指“意义”。 ', '中文', '99.80', '2017-04-01', 9 ),
	( 13,'画的秘密', '马克-安托万·马修 ', '北京联合出版公司·后浪出版公司', '9787550265608', '一本关于友情的疗伤图像小说，直击人内心最为隐秘的情感。 一部追寻艺术的纸上悬疑电影，揭示命运宇宙中奇诡的真相。', '中文', '60.00', '2016-01-01', 9),
	( 14,'造彩虹的人', '东野圭吾 ', '北京十月文艺出版社', '9787530216859', '其实每个人身上都会发光，但只有纯粹渴求光芒的人才能看到。 ', '中文', '39.50', '2017-06-01', 9 ),
	( 15,'控方证人', '阿加莎·克里斯蒂 ', '新星出版社', '9787513325745', '伦纳德•沃尔被控谋杀富婆艾米丽以图染指其巨额遗产，他却一再表明自己的无辜。伦纳德的妻子是唯一能够证明他无罪的证人，却以控方证人的身份出庭指证其确实犯有谋杀罪。伦纳德几乎陷入绝境，直到一个神秘女人的出现……', '中文', '35.00', '2017-05-01', 9 ),
	( 16,'秘密花园', '乔汉娜·贝斯福 ', '北京联合出版公司', '9787550252585', '欢迎来到秘密花园！ 在这个笔墨编织出的美丽世界中漫步吧 涂上你喜爱的颜色，为花园带来生机和活力 ', '中文', '42.00', '2015-06-01', 9);
-- BookTags

CREATE TABLE IF NOT EXISTS `Location` (
    `LocID` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `Longtitude`  DECIMAL(11, 7) NOT NULL,
    `Latitude`  DECIMAL(11, 7) NOT NULL,
    `District` VARCHAR(20) NOT NULL,
    `Street` VARCHAR(30),
    `Detail` VARCHAR(40),
    INDEX (`Longtitude`,`Latitude`)
)AUTO_INCREMENT=1;
INSERT INTO `Location` (`Longtitude`, `Latitude`, `District`, `Street`, `Detail`)
VALUES (121.4737, 31.2304, '黄埔', 'Nanjing East Road', 'No. 100'),
       (121.4454, 31.2089, '嘉定', 'Caoan Road', 'No. 200'),
       (121.5228, 31.2357, '杨浦', 'Guohe Road', 'No. 300'),
       (121.4025, 31.2186, '徐汇', 'Hengshan Road', 'No. 400'),
       (121.4375, 31.0272, '浦东', 'Lujiazui Ring Road', 'No. 500'),
       (121.4485, 31.1914, '静安', 'West Nanjing Road', 'No. 600'),
       (121.5220, 31.3045, '宝山', 'Gucun Park', 'No. 700');
--  
CREATE TABLE IF NOT EXISTS `Station` (
    `StationID` INT NOT NULL PRIMARY KEY  AUTO_INCREMENT,
    `LocID` INT NOT NULL,
    `Capacity` INT NOT NULL CHECK (`Capacity` >= 0),
    `Status` ENUM('正常', '暂停使用') NOT NULL,
    CONSTRAINT `fk_st_LocID` FOREIGN KEY (`LocID`) REFERENCES `Location`(`LocID`),
    INDEX `LocID_idx`(`LocID`)
)AUTO_INCREMENT=1;
INSERT INTO `Station` (`LocID`, `Capacity`, `Status`) VALUES 
(1, 50, '正常'),
(2, 30, '正常'),
(3, 20, '正常'),
(4, 40, '正常'),
(5, 10, '正常'),
(6, 25, '正常'),
(7, 35, '暂停使用');



CREATE TABLE IF NOT EXISTS `Book`(
  `BID` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `ISBN`VARCHAR(15) NOT NULL,
  `Status` ENUM('外借', '在馆', '逾期未还', '待审核', '损坏','已下架') NOT NULL,
    `atStation` INT ,
  CONSTRAINT `fk_ISBN`
    FOREIGN KEY (`ISBN`)
    REFERENCES `Publication` (`ISBN`)
)AUTO_INCREMENT=1;
-- Inserting data into Book table
INSERT INTO `Book` (`ISBN`, `Status`,`atStation`) VALUES
 ('9787530216835', '在馆',1),
 ('9787513325745', '外借',null),
 ('9787111126768', '逾期未还',null),
 ('9787508647357', '待审核',3),
 ('9787544277610', '在馆',2),
 ('9787544242519', '在馆',2),
 ('9787544245855', '在馆',2),
  ('9787550252585', '外借',null),
  ('9787544270871', '外借',null),
  ('9787544253997', '在馆',2),
   ('9787020125265', '在馆',1),
   ('9787544277610', '在馆',4);

CREATE TABLE IF NOT EXISTS `User` (
    `UID` INT NOT NULL PRIMARY KEY  AUTO_INCREMENT,
    `UserName` VARCHAR(30) NOT NULL,
    `PhoneNumber` VARCHAR(20) NOT NULL,
    `Credict` INT NOT NULL,
    `Discription` VARCHAR(50),
    `Password` VARCHAR(20) NOT NULL,
    `isVolunteer` BOOLEAN NOT NULL,
    `UStatus` ENUM('正常', '禁封', '审查','其他')  NOT NULL
)AUTO_INCREMENT=1;

INSERT INTO `User` (`UserName`, `PhoneNumber`, `Credict`, `Discription`, `Password`, `isVolunteer`, `UStatus`)
VALUES 

('Admin', '7777777777', 100, 'An admin user', 'admin', 1, '正常'),
('VolunteerA', '5555555555', 100, 'A volunteer user', 'admin', 1, '正常'),
('VolunteerB', '00000000000', 100, 'A volunteer user', 'admin', 1, '正常'),
('John Doe',   '1234567890', 100, 'A regular user', 'password', 0, '正常'),
('Jane Smith', '0987654321', 100, 'Another regular user', 'password', 0, '正常'),
('Bob Johnson', '5555555555', 100, 'An important user', 'password', 0, '正常'),
('Alice Lee', '1111111111', 75, 'A new user', 'password', 0, '正常'),
('Tom Wilson', '2222222222', 100, 'A frequent user', 'password', 0, '正常'),
('Samantha Brown', '3333333333', 85, 'A low-credit user', 'password', 0, '正常'),
('David Kim', '4444444444', 100, 'A high-credit user', 'password', 0, '正常'),
('Emily Davis', '6666666666', 100, 'A user with a description', 'password', 0, '正常'),
('Karen Wong', '8888888888', 30, 'A user with a different status', 'password', 0, '审查');

CREATE TABLE IF NOT EXISTS `Volunteer` (
    `UID` INT NOT NULL PRIMARY KEY,
    `Anthority` VARCHAR(20),
    `StartFrom` DATE NOT NULL,
    `Career` VARCHAR(20),
    `Health` VARCHAR(20),
    `LocID` INT NOT NULL,
    CONSTRAINT `fk_vt_LocID` FOREIGN KEY (`LocID`) REFERENCES `Location`(`LocID`),
    CONSTRAINT `fk_vt_UID` FOREIGN KEY (`UID`) REFERENCES `User`(`UID`)
);
INSERT INTO `Volunteer` (`UID`, `Anthority`, `StartFrom`, `Career`, `Health`, `LocID`) VALUES 
(1, '管理员', '2021-01-01', 'Admin', '良好', 1),
(2, '普通志愿者', '2021-02-01', '学生', '良好', 2),
(3, '普通志愿者', '2021-02-01', '记者', '良好', 1);


CREATE TABLE IF NOT EXISTS `Borrow` (
    `BorrowID` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `UID` INT NOT NULL,
    `BID` INT NOT NULL,
    `BorrowAt` INT NOT NULL,
    `Renewal` INT NOT NULL,-- 续借次数 --
    `BorrowTime` DATETIME NOT NULL,
    `DueTime` DATETIME NOT NULL,
    `ReturnTime` DATETIME,
    `Status` ENUM('未归还', '已归还', '逾期未还','其他') NOT NULL,
    CONSTRAINT `fk_br_UID` FOREIGN KEY (`UID`) REFERENCES `User`(`UID`),
    CONSTRAINT `fk_br_BID` FOREIGN KEY (`BID`) REFERENCES `Book`(`BID`),
    CONSTRAINT `fk_br_BorrowAt` FOREIGN KEY (`BorrowAt`) REFERENCES `Station`(`StationID`)
)AUTO_INCREMENT=1;

INSERT INTO `Borrow` (`UID`, `BID`, `BorrowAt`, `Renewal`, `BorrowTime`, `DueTime`, `ReturnTime`, `Status`)
VALUES 
(1, 1, 1, 0, '2021-01-01 10:00:00', '2021-02-08 10:00:00', '2021-01-08 10:00:00', '已归还'),
(2, 2, 2, 1, '2021-02-01 10:00:00', '2021-04-08 10:00:00', '2021-03-08 10:00:00', '已归还'),
(3, 3, 3, 2, '2021-03-01 10:00:00', '2021-04-08 10:00:00', '2021-04-06 10:00:00', '已归还'),
(4, 4, 1, 0, '2021-04-01 10:00:00', '2021-05-08 10:00:00', '2021-04-08 10:00:00', '已归还'),
(5, 5, 2, 1, '2021-05-01 10:00:00', '2021-06-08 10:00:00', '2021-04-08 10:00:00', '已归还'),
(6, 6, 2, 2, '2021-06-01 10:00:00', '2021-07-08 10:00:00', NULL, '未归还'),
(7, 7, 2, 0, '2021-06-01 10:00:00', '2021-07-08 10:00:00', NULL, '未归还'),
(8, 8, 2, 1, '2021-07-01 10:00:00', '2021-08-08 10:00:00', NULL, '未归还'),
(9, 9, 1, 2, '2021-07-01 10:00:00', '2021-09-08 10:00:00', NULL, '未归还'),
(10, 10, 1, 0, '2021-10-01 10:00:00', '2021-10-08 10:00:00', NULL, '未归还');


CREATE TABLE IF NOT EXISTS `Feedback` (
    `FeedbackID` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `UID` INT NOT NULL,
    `BorrowID` INT NOT NULL,
    `Type` ENUM('举报', '书籍破损','驿站故障','其他') NOT NULL,
    `Discription` VARCHAR(100) NOT NULL,
    `Time` DATETIME NOT NULL,
    `Status` ENUM('待核查', '已处理', '流程终止') NOT NULL,
    CONSTRAINT `fk_fb_UID` FOREIGN KEY (`UID`) REFERENCES `User`(`UID`),
    CONSTRAINT `fk_fb_BID` FOREIGN KEY (`BorrowID`) REFERENCES `Borrow`(`BorrowID`)
   
)AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS `Comment` (
    `CommentID` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `UID` INT NOT NULL,
    `ISBN` VARCHAR(15) NOT NULL,
    `Score` INT NOT NULL,
    `Title` VARCHAR(30),
    `Detail` VARCHAR(800),
    `Time` DATETIME NOT NULL,
    `Like` INT NOT NULL CHECK (`Like` >= 0),
    `Dislike` INT NOT NULL CHECK (`Dislike` >= 0),
    CONSTRAINT `fk_cm_UID` FOREIGN KEY (`UID`) REFERENCES `User`(`UID`),
    CONSTRAINT `fk_cm_ISBN` FOREIGN KEY (`ISBN`) REFERENCES `Publication`(`ISBN`),
    INDEX (`UID`),
    INDEX (`ISBN`)
   
)AUTO_INCREMENT=1;
CREATE TABLE IF NOT EXISTS `Sharing` (
    `BID` INT NOT NULL PRIMARY KEY,
    `UID` INT NOT NULL,
    `Time` DATETIME NOT NULL,
    CONSTRAINT `fk_sr_BID` FOREIGN KEY (`BID`) REFERENCES `Book`(`BID`),
    CONSTRAINT `fk_sr_UID` FOREIGN KEY (`UID`) REFERENCES `User`(`UID`)
);
INSERT INTO `Sharing` (`BID`, `UID`, `Time`) VALUES 
(1, 1, '2021-01-01 10:00:00'),
(2, 2, '2021-02-03 10:00:00'),
(3, 3, '2021-01-01 10:00:00'),
(4, 4, '2021-01-04 10:00:00'),
(5, 5, '2021-01-04 10:00:00'),
(6, 6, '2021-01-05 10:00:00'),
(7, 7, '2021-01-06 10:00:00'),
(8, 8, '2021-01-07 10:00:00'),
(9, 9, '2021-01-09 10:00:00'),
(10, 10, '2021-01-10 10:00:00'),
( 11,1, '2021-01-11 10:00:00'),
( 12,1, '2021-01-11 10:00:00');



CREATE TABLE IF NOT EXISTS `ResponsibleFor` (
    `DutyID` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `UID` INT NOT NULL,
    `StationID` INT NOT NULL,
    CONSTRAINT `fk_rf_UID` FOREIGN KEY (`UID`) REFERENCES `Volunteer`(`UID`),
    CONSTRAINT `fk_rf_StationID` FOREIGN KEY (`StationID`) REFERENCES `Station`(`StationID`)
)AUTO_INCREMENT=1;

INSERT INTO `ResponsibleFor` (`UID`, `StationID`) VALUES 
(1, 1),
(1 ,2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(2, 2),
(3, 1);
-- TODO : 书籍标签、评论、反馈系统


-- VIEWs
CREATE VIEW `bookInfo` AS
SELECT ISBN, BID, Status, atStation, BnwID , name , author , publish , class_id
FROM  `Book` INNER JOIN `Publication` USING(ISBN);


CREATE VIEW `borrowInfo` AS
SELECT `BorrowID`,`ISBN`,`name` , `author` , `BID`, `atStation`, `UID`,  `BorrowAt`, `Renewal`, `BorrowTime`, `DueTime`, `ReturnTime`, Borrow.Status AS borrowStatus
FROM `BookInfo`
INNER JOIN `Borrow` USING(BID);


-- 站点信息
create view `stationInfo` as
select `stationid`,count(bid) as `booknum`,`Longtitude`, `Latitude`, `District`, `Street`, `Detail`
from `station`
left join `book` on station.stationid=book.atstation
left join `location` on Location.LocID=station.locID
group by `stationid`;

