USE dutyrostering;


drop table if exists ROSTER;
drop table if exists EMPLOYEE;
create table EMPLOYEE (
    EMP_ID smallint unsigned not null,
    USERNAME varchar(32) not null,
    PASSWORD varchar(32) not null,
    FULL_NAME varchar(50) not null,
    CREATE_DATE date not null,
    IS_ACTIVE tinyint(1) not null,
    IS_ADMIN tinyint(1) not null,
    primary key (EMP_ID),
    unique (USERNAME)
);

drop table if exists SHIFT_TYPE;
create table SHIFT_TYPE(
 SHIFT_TYPE_ID smallint unsigned not null,
 NAME varchar(16) not null,
 primary key (SHIFT_TYPE_ID)
);

 drop table if exists DATE;
CREATE TABLE DATE(
 DATE_ID int unsigned NOT NULL,
 FULL_DATE date NULL,
 DAY_OF_WEEK tinyint NOT NULL,
 DAY_NAME_OF_WEEK char(10) NOT NULL,
 DAY_OF_MONTH tinyint NOT NULL,
 DAY_OF_YEAR smallint NOT NULL,
 IS_HOLIDAY tinyint(1) NOT NULL,
 IS_HOLIDAY_SEASON tinyint(1) NOT NULL,
 HOLIDAY_NAME varchar(50) NULL,
 HOLIDAY_SEASON_NAME varchar(50) NULL,
 IS_BUSINESS_DAY tinyint(1) NOT NULL,
 IS_WEEKEND tinyint(1) NOT NULL,
 WEEK_OF_YEAR tinyint NOT NULL,
 MONTH_OF_YEAR tinyint NOT NULL,
 MONTH_NAME char(10) NOT NULL,
 IS_LAST_DAY_OF_MONTH tinyint(1) NOT NULL,
 CALENDAR_QUARTER tinyint NOT NULL,
 CALENDAR_YEAR smallint NOT NULL,
  PRIMARY KEY (`DATE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
drop table if exists ROSTER;
create table ROSTER(
 EMP_ID smallint unsigned not null,
 DATE_ID int unsigned not null,
 SHIFT tinyint unsigned not null,
 NOTE_MESSAGE varchar(255) null,
 TIME_EXPIRED datetime not null,
 IS_ACTIVE tinyint(1) unsigned not null,
 SHIFT_TYPE_ID smallint unsigned not null,
 primary key (EMP_ID, DATE_ID, SHIFT)
);

ALTER TABLE `dutyrostering`.`employee` 
CHANGE COLUMN `EMP_ID` `EMP_ID` SMALLINT(5) UNSIGNED NOT NULL AUTO_INCREMENT ;  
 
alter table ROSTER
    add constraint ROSTER_EMPLOYEE_FK
    foreign key (EMP_ID)
    references EMPLOYEE (EMP_ID);
   
alter table ROSTER
    add constraint ROSTER_DATE_FK
    foreign key (DATE_ID)
    references DATE (DATE_ID);


alter table ROSTER
    add constraint ROSTER_SHIFT_TYPE_FK
    foreign key (SHIFT_TYPE_ID)
    references SHIFT_TYPE (SHIFT_TYPE_ID);
  

  
    
delimiter //

drop procedure if exists PopulateDateDimension//

CREATE PROCEDURE PopulateDateDimension(BeginDate DATETIME, EndDate DATETIME)
BEGIN

 
 DECLARE LastDayOfMon tinyint;


 DECLARE DateCounter DATETIME;    #Current date in loop
 
 SET DateCounter = BeginDate;

 WHILE DateCounter <= EndDate DO


            IF MONTH(DateCounter) = MONTH(DATE_ADD(DateCounter, INTERVAL 1 DAY)) THEN
               SET LastDayOfMon = 0;
            ELSE
               SET LastDayOfMon = 1;
   END IF;

          INSERT  INTO DATE
      (DATE_ID,
		FULL_DATE,
		DAY_OF_WEEK,
		DAY_NAME_OF_WEEK,
		DAY_OF_MONTH,
		DAY_OF_YEAR,
		IS_HOLIDAY,
		IS_HOLIDAY_SEASON,
		HOLIDAY_NAME,
		HOLIDAY_SEASON_NAME,
		IS_BUSINESS_DAY,
		IS_WEEKEND,
		WEEK_OF_YEAR,
		MONTH_OF_YEAR,
		MONTH_NAME,
		IS_LAST_DAY_OF_MONTH,
		CALENDAR_QUARTER,
		CALENDAR_YEAR
      )
            VALUES  (
                      ( YEAR(DateCounter) * 10000 ) + ( MONTH(DateCounter)
                                                         * 100 )
                      + DAY(DateCounter)  #DateKey
                    , DateCounter # FullDate
                    , DAYOFWEEK(DateCounter) #DayOfWeek
                    , DAYNAME(DateCounter) #DayNameOfWeek
                    , DAYOFMONTH(DateCounter) #DayOfMonth
                    , DAYOFYEAR(DateCounter) #DayOfYear
                    , 0 #isHoliday
                    , 0
                    ,null #HolidayName
                    ,null  #HolidaySeasonName
                    , 0 #isBusinessDay
                    , CASE DAYNAME(DateCounter)
                        WHEN 'Saturday' THEN 1
                        WHEN 'Sunday' THEN 1
                        ELSE 0
                      END #WeekdayWeekend
                    , WEEKOFYEAR(DateCounter) #WeekOfYear
                    , MONTH(DateCounter) #MonthOfYear
                    , MONTHNAME(DateCounter) #MonthName
                    , LastDayOfMon #IsLastDayOfMonth
                    , QUARTER(DateCounter) #CalendarQuarter
                    , YEAR(DateCounter) #CalendarYear
                    );

            SET DateCounter = DATE_ADD(DateCounter, INTERVAL 1 DAY);
      END WHILE;


END// 
CALL PopulateDateDimension('2017/01/10', '2020/10/31'); 

INSERT INTO `employee` VALUES (1,'admin','admin','admin','2017-10-19',1,1),(11544,'vy11544','123456','Nguyễn Lê Thảo Vy','2017-10-19',1,0),(11546,'tien11546','123456','Nguyễn Thị Cẩm Tiến','2017-10-19',1,0),(11549,'nhi11549','123456','Nguyễn Thị Tuyết Nhi','2017-10-19',1,0),(11553,'linh11553','123456','Trương Yến Linh','2017-10-19',1,0),(11658,'ngan11658','123456','Đào Kim Ngân','2017-10-19',1,0),(11665,'my11665','123456','Dương Thị Mỹ','2017-10-19',1,0),(11670,'thinh11670','123456','Huỳnh Cảnh Thịnh','2017-10-19',1,0),(11683,'an11683','123456','Lê Thị Diệp An','2017-10-19',1,0),(11701,'hien11701','123456','Nguyễn Thị Diệu Hiền','2017-10-19',1,0),(11708,'anh11780','123456','Nguyễn Thị Trung Anh','2017-10-19',1,0),(11710,'ngan11710','123456','Nguyễn Thi Tuyết Ngân','2017-10-19',1,0),(11712,'tan11712','123456','Nguyễn Trần Minh Tân','2017-10-19',1,0),(11714,'tran11714','123456','Nhan Bảo Trân','2017-10-19',1,0),(11716,'nhi11716','123456','Phạm Ngọc Yến Nhi','2017-10-19',1,0),(11717,'tran11717','123456','Phạm Nguyễn Huỳnh Trân','2017-10-19',1,0),(11719,'loan11719','123456','Phạm Thị Hồng Loan','2017-10-19',1,0),(11720,'tham11720','123456','Phạm Thị Kim Thắm','2017-10-19',1,0),(11730,'luong11730','123456','Phương Xương Lượng','2017-10-19',1,0),(11733,'binh11733','123456','Sơn Tuấn Bình','2017-10-19',1,0),(11739,'nhu11739','123456','Trần Lê Huỳnh Như','2017-10-19',1,0),(11748,'nhung11748','123456','Trương Ngọc Nhung','2017-10-19',1,0),(13608,'vinh13608','123456','Nguyễn Trần Tấn Vinh','2017-10-19',1,0),(13612,'nhi13612','123456','Nguyễn Ngọc Huỳnh Nhi','2017-10-19',1,0),(13620,'uyen13620','123456','Nguyễn Thị Thúy Uyên','2017-10-19',1,0),(13630,'hua13630','123456','Quách Kim Húa','2017-10-19',1,0),(16470,'yen16470','123456','Trần Nguyễn Ngọc Yến','2017-10-19',1,0),(16472,'bao16472','123456','Phạm Đỗ Thế Bảo','2017-10-19',1,0),(16473,'hao16473','123456','Khưu Nhật Hào','2017-10-19',1,0),(16479,'khoa16479','123456','Mai Đăng Khoa','2017-10-19',1,0),(16480,'ngoc16480','123456','Đoàn Khánh Ngọc','2017-10-19',1,0),(16481,'nhan16481','123456','Trần Trọng Nhân','2017-10-19',1,0),(16484,'nhi16484','123456','Nguyễn Thị Yến Nhi','2017-10-19',1,0),(16488,'truc16488','123456','Huỳnh Thanh Trúc','2017-10-19',1,0),(16489,'thuy16489','123456','Nguyễn Thị Thanh Thủy','2017-10-19',1,0),(16493,'khoa16493','123456','Phạm Đình Anh Khoa','2017-10-19',1,0),(16495,'tram16494','123456','Nguyễn Ngọc Linh Trâm','2017-10-19',1,0),(17837,'loc17837','123456','Lương Thiên Lộc','2017-10-19',1,0),(17845,'tran17845','123456','Nguyễn Thị Mỹ Trân','2017-10-19',1,0),(17850,'tong17850','123456','Phạm Thanh Tòng','2017-10-19',1,0),(17851,'phuc17851','123456','Đoàn Thanh Phúc','2017-10-19',1,0),(17856,'tran17856','123456','Nguyễn Trần Lâm Trân','2017-10-19',1,0),(17857,'dieu17857','123456','Lưu Ngọc Diệu','2017-10-19',1,0),(17866,'mi17866','123456','Nguyễn Tô Yến Mi','2017-10-19',1,0),(17867,'nhi17867','123456','Lê Thị Yến Nhi','2017-10-19',1,0),(17872,'an17872','123456','Lê Trường An','2017-10-19',1,0);
INSERT INTO `shift_type` VALUES (1,'WORK'),(2,'HOC'),(3,'OFF'),(4,'MKT');
INSERT INTO `roster` VALUES (1,20170110,1,'ok','2017-10-19 00:00:00',1,1),(1,20170110,2,'ok','2017-10-19 00:00:00',1,1),(1,20170110,3,'ok ','2017-10-19 00:00:00',1,1),(1,20170111,1,'ok','2017-10-19 00:00:00',1,1);
