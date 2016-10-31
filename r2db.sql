SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS articlevo;
DROP TABLE IF EXISTS boardvo;
DROP TABLE IF EXISTS commentvo;
DROP TABLE IF EXISTS cyclevo;
DROP TABLE IF EXISTS stepvo;
DROP TABLE IF EXISTS uservo;




/* Create Tables */

CREATE TABLE articlevo
(
	article_no int NOT NULL AUTO_INCREMENT,
	article_title varchar(45),
	article_date varchar(200) NOT NULL,
	article_content varchar(500) NOT NULL,
	article_count int DEFAULT 0,
	article_heart int DEFAULT 0,
	article_url varchar(500) NOT NULL,
	board_no int NOT NULL,
	user_id varchar(250) NOT NULL,
	user_name varchar(45) NOT NULL,
	PRIMARY KEY (article_no)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE boardvo
(
	board_no int NOT NULL,
	board_name varchar(45),
	PRIMARY KEY (board_no)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE commentvo
(
	comment_no int NOT NULL AUTO_INCREMENT,
	comment_comment varchar(300) NOT NULL,
	comment_date varchar(200) NOT NULL,
	comment_heart int DEFAULT 0 NOT NULL,
	user_id varchar(250) NOT NULL,
	article_no int NOT NULL,
	PRIMARY KEY (comment_no)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE cyclevo
(
	cycle_no int NOT NULL AUTO_INCREMENT,
	cycle_start_time varchar(200) NOT NULL,
	cycle_end_time varchar(200) NOT NULL,
	cycle_total_time varchar(100) DEFAULT '0' NOT NULL,
	cycle_distance varchar(20) DEFAULT '0' NOT NULL,
	cycle_speed varchar(20) DEFAULT '0' NOT NULL,
	user_id varchar(250) NOT NULL,
	user_name varchar(45) NOT NULL,
	PRIMARY KEY (cycle_no)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE stepvo
(
	step_no int NOT NULL AUTO_INCREMENT,
	step_start_time varchar(200) NOT NULL,
	step_end_time varchar(200) NOT NULL,
	step_total_time varchar(200) DEFAULT '0' NOT NULL,
	step_goal varchar(20) DEFAULT '0' NOT NULL,
	step_step varchar(20) DEFAULT '0' NOT NULL,
	user_id varchar(250) NOT NULL,
	user_name varchar(45) NOT NULL,
	PRIMARY KEY (step_no)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE uservo
(
	user_no int NOT NULL AUTO_INCREMENT,
	user_id varchar(250) NOT NULL,
	user_name varchar(45) NOT NULL,
	PRIMARY KEY (user_no)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;



