-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: campus_diary_db
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comment_post`
--

DROP TABLE IF EXISTS `comment_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment_post` (
  `id` int NOT NULL AUTO_INCREMENT,
  `post_id` int NOT NULL,
  `user_id` int NOT NULL,
  `comment` varchar(250) NOT NULL,
  `entry_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `comment_posts_ibfk_1` (`post_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `comment_post_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`),
  CONSTRAINT `comment_post_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_post`
--

LOCK TABLES `comment_post` WRITE;
/*!40000 ALTER TABLE `comment_post` DISABLE KEYS */;
INSERT INTO `comment_post` VALUES (1,6,4,'nice','2023-04-10 06:53:32'),(2,11,8,'wonderful','2023-04-11 17:21:32'),(3,8,13,'amazing','2023-04-19 17:23:15'),(4,9,6,'fantastic','2023-04-18 17:22:49'),(5,11,10,'mindblowing','2023-04-25 17:23:15');
/*!40000 ALTER TABLE `comment_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `title` varchar(255) NOT NULL,
  `start_date` date NOT NULL,
  `last_date` date NOT NULL,
  `banner` varchar(255) NOT NULL,
  `detail` varchar(255) NOT NULL,
  `status` int NOT NULL DEFAULT '0',
  `entry_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `event_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,1,'sports event','2023-04-22','2023-04-28','','your corner, hurry up for the participation. registration will close soon.',1,'2023-04-20 18:30:00'),(2,8,'youth festival-2023','2023-03-31','2023-04-26','papa1.jpeg','Biggest festival of our university.',1,'2023-04-21 18:30:00'),(3,7,'Freshers party-2023','2023-04-06','2023-04-14','papa2.jpg','Freshers party will be held at MBA building for entry you will get pass online after registration time:-7:00PM to 10:00PM. date: 24-05-2023',0,'2023-04-25 18:30:00'),(4,1,'16th convocation','2023-04-12','2023-04-13','','it will be held at OAT',0,'2023-04-30 03:53:35'),(5,7,'Seminar for 12th pass student','2023-04-16','2023-04-16','','students who are interested to join ganpat university can collaborate with us. Looking forward for you.  ',0,'2023-04-30 03:53:35');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_registration`
--

DROP TABLE IF EXISTS `event_registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_registration` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `event_id` int NOT NULL,
  `payment_type` varchar(20) NOT NULL,
  `payment_detail` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `event_registrations_ibfk_1` (`event_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `event_registration_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`),
  CONSTRAINT `event_registration_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_registration`
--

LOCK TABLES `event_registration` WRITE;
/*!40000 ALTER TABLE `event_registration` DISABLE KEYS */;
INSERT INTO `event_registration` VALUES (1,1,1,'cash','#'),(2,9,3,'cash','#'),(3,4,2,'cheque','#'),(4,12,1,'cash','#'),(5,10,1,'cash','#'),(6,7,2,'cash','#'),(7,4,1,'cheque','#'),(8,11,2,'cheque','#'),(9,13,3,'cash','#'),(10,6,1,'cash','#'),(11,1,2,'cheque','#');
/*!40000 ALTER TABLE `event_registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `subject` varchar(50) NOT NULL,
  `message` varchar(255) NOT NULL,
  `status` int DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (1,'nisha soni','nisha123@gmail.com','campus view','I visited for the first time to Ganpat University. I liked the campus structure and atmosphere was very inspiring. ',1),(2,'khushi bhanushali','khushi123@gmail.com','after 12th programs seminar','management for the event was very impressive. I would love to be the part of ganpat university.',1),(3,'manthan joshi','manthan123@gmail.com','youth festival','I had took part in youth festival and I visited your campus for the first time. it was really a amazing experience.',1),(4,'dhaval pandya','dhaval123@gmail.com','missing campus life','I passed out from ganpat university. I enjoyed the moments over there and I missing those precious days.',0),(5,'raj joshi','raj123@gmail.com','about this online site','I liked surfing on your site. you are providing very good service I liked it regarding your site.',0);
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notification` (
  `id` int NOT NULL AUTO_INCREMENT,
  `receiver_user_id` int NOT NULL,
  `sender_user_id` int NOT NULL,
  `title` varchar(50) NOT NULL,
  `is_read` varchar(1) NOT NULL DEFAULT 'N',
  `message` varchar(255) NOT NULL,
  `entry_date` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `receiver_user_id` (`receiver_user_id`),
  KEY `sender_user_id` (`sender_user_id`),
  CONSTRAINT `notification_ibfk_1` FOREIGN KEY (`receiver_user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `notification_ibfk_2` FOREIGN KEY (`sender_user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
INSERT INTO `notification` VALUES (3,10,8,'count down for your sports event','N','hurry up, register for the sports event. time to show your talent','2023-04-08'),(4,5,7,'Youth Fest-2023','N','are you willing to be a part of our event? If yes, then register from the link given below. see you at the event','2023-04-15'),(5,6,9,'gandhi jayanti','N','celebrating the gandhi jayanti in the memories of our father of nation. Hope you will contribute your valuable time for our nation','2023-04-12'),(6,1,2,'independence day','N','celebrating 15-august at ganpat university. jay hind.','2023-04-22'),(7,5,8,'count down for your sports event','N','hurry up, register for the sports event. time to show your talent','2023-04-16'),(8,13,8,'gandhi jayanti','Y','celebrating the gandhi jayanti in the memories of our father of nation. Hope you will contribute your valuable time for our nation','2023-04-12'),(9,12,7,'youth fest-2023','Y','are you willing to be a part of our event? If yes, then register from the link given below. see you at the event','2023-04-18');
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `photos_gallery`
--

DROP TABLE IF EXISTS `photos_gallery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `photos_gallery` (
  `id` int NOT NULL AUTO_INCREMENT,
  `photo` varchar(50) NOT NULL,
  `event_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `event_id` (`event_id`),
  CONSTRAINT `photos_gallery_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `photos_gallery`
--

LOCK TABLES `photos_gallery` WRITE;
/*!40000 ALTER TABLE `photos_gallery` DISABLE KEYS */;
INSERT INTO `photos_gallery` VALUES (1,'Screenshot 2022-12-28 170359.jpg',2),(2,'',3),(3,'',1),(4,'',2),(5,'',1),(6,'',2);
/*!40000 ALTER TABLE `photos_gallery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `photo` varchar(50) NOT NULL,
  `message` varchar(255) NOT NULL,
  `like_count` int DEFAULT NULL,
  `dislike_count` int DEFAULT NULL,
  `entry_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `post_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (5,1,'about-img1.jpg','Successful event:)',54,1,'2023-04-22 18:30:00','1'),(6,10,'new4.jpeg','glance at sports week',65,1,'2023-04-23 18:30:00','1'),(7,7,'new7.jpeg','one more achievement. got first rank in shodh-2023',54,1,'2023-04-25 18:30:00','1'),(8,2,'new7.jpeg','glimpse of live concert at ganpat university',54,1,'2023-04-26 18:30:00','1'),(9,8,'new8.png','exciting announcement we are arranging a presentation competition on women awareness and safety at our department. everyone can participate.',22,22,'2023-04-26 18:30:00','1'),(10,6,'new8.png','alumni gathering at our campus.',54,1,'2023-04-24 18:30:00','1'),(11,10,'new7.jpeg','cheers to 2023 new year night celebration at ganpat university',54,22,'2023-04-12 18:30:00','1'),(12,5,'Screenshot 2022-12-28 170359.jpg','seminar for the 12th pass students.',54,1,'2023-04-26 18:30:00','1');
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reply_comment`
--

DROP TABLE IF EXISTS `reply_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reply_comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `comment_post_id` int NOT NULL,
  `user_id` int NOT NULL,
  `message` varchar(255) NOT NULL,
  `entry_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `comment_post_id` (`comment_post_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `reply_comment_ibfk_1` FOREIGN KEY (`comment_post_id`) REFERENCES `comment_post` (`id`),
  CONSTRAINT `reply_comment_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply_comment`
--

LOCK TABLES `reply_comment` WRITE;
/*!40000 ALTER TABLE `reply_comment` DISABLE KEYS */;
INSERT INTO `reply_comment` VALUES (1,3,7,'yepp','2023-04-17 03:50:24'),(2,5,12,'woahh','2023-04-23 17:24:38'),(3,4,11,'absolutely','2023-04-26 17:25:23'),(4,2,5,'more likes','2023-04-27 01:05:23'),(5,2,13,'innovative','2023-04-25 03:39:23');
/*!40000 ALTER TABLE `reply_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff_master`
--

DROP TABLE IF EXISTS `staff_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff_master` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `gender` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `photo` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `department` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `staff_master_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff_master`
--

LOCK TABLES `staff_master` WRITE;
/*!40000 ALTER TABLE `staff_master` DISABLE KEYS */;
INSERT INTO `staff_master` VALUES (1,1,'male','arth123@gmail.com','81928374654','new8.png','mehsana','DCS'),(2,7,'male','manan123@gmail.com','63485762948','new5.jpeg','himatnagar','AMPICS'),(3,8,'female','niyati123@gmail.com','9923847364','new6.jpeg','unjha','DCS'),(4,9,'female','sanju123@gmail.com','8129384756','','unjha','DCS');
/*!40000 ALTER TABLE `staff_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_master`
--

DROP TABLE IF EXISTS `student_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_master` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `gender` varchar(10) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `photo` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `department` varchar(50) NOT NULL,
  `course` varchar(50) NOT NULL,
  `semester` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `student_master_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_master`
--

LOCK TABLES `student_master` WRITE;
/*!40000 ALTER TABLE `student_master` DISABLE KEYS */;
INSERT INTO `student_master` VALUES (1,6,'male','9948576437','new6.jpeg','himatnagar','DCS','bsc.it','6'),(2,10,'male','9937465723','new3.jpeg','kadi','AMPICS','MCA','3'),(3,2,'female','9843746537','','visnagar','DCS','bsc.it','5'),(4,5,'female','8127364528','','himatnagar','AMPICS','bsc.cs','5');
/*!40000 ALTER TABLE `student_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suggestion`
--

DROP TABLE IF EXISTS `suggestion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suggestion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `message` varchar(255) NOT NULL,
  `entry_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `like_count` int NOT NULL,
  `dislike_count` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `suggestion_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suggestion`
--

LOCK TABLES `suggestion` WRITE;
/*!40000 ALTER TABLE `suggestion` DISABLE KEYS */;
INSERT INTO `suggestion` VALUES (1,2,'in my opinion seating arrangements for fresher party evening was not proper','2023-04-26 02:07:21',100,5),(2,7,'in my opinion participation of students during the last satrang festival was too less, wake up students.','2023-04-20 05:44:21',78,9),(3,9,'students commit members were not cooperating the university management during the navratri celebration, head of the commit should think about this matter','2023-04-23 02:58:19',78,2),(4,10,'gym area requires the maintenance work, please consider this matter. ','2023-04-17 23:58:41',89,32),(5,13,'we visited your campus for seminar, canteen service was not proper at MBA building.','2023-04-20 16:58:41',100,9);
/*!40000 ALTER TABLE `suggestion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temp_user`
--

DROP TABLE IF EXISTS `temp_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `temp_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `photo` varchar(255) NOT NULL,
  `college_name` varchar(100) NOT NULL,
  `college_id_photo` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id_fk` (`user_id`),
  CONSTRAINT `user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temp_user`
--

LOCK TABLES `temp_user` WRITE;
/*!40000 ALTER TABLE `temp_user` DISABLE KEYS */;
INSERT INTO `temp_user` VALUES (5,4,'','SK',''),(6,11,'','Nirma University',''),(7,12,'','Parul University',''),(8,13,'','Cambridge University','');
/*!40000 ALTER TABLE `temp_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` varchar(20) NOT NULL,
  `status` varchar(10) NOT NULL,
  `entry_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `logout_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'arth','65465465465','arth12@gmail.com','1234','Staff','1','2023-04-20 18:30:00','2023-04-20 18:30:00'),(2,'dhenu','92384756120','dhenu123@gmail.com','dhenu123','Student','1','2023-04-25 18:30:00','2023-04-26 18:30:00'),(3,'Dhenu joshi','92384756120','dhenu123@gmail.com','dhenu123','Admin','1','2023-04-25 18:30:00','2023-04-26 18:30:00'),(4,'nisha','9123475324','nisha123@gmail.com','nisha123','Tamp_Student','1','2023-04-18 18:30:00','2023-04-20 18:30:00'),(5,'vishva','9843746537','vishva123@gmail.com','vishva123','student','1','2023-04-26 01:45:26','2023-04-27 01:56:06'),(6,'ashutosh','9946523772','ashutosh123@gmail.com','ashutosh123','student','0','2023-04-18 23:56:12','2023-04-20 01:46:29'),(7,'manan','6384756298','manan123@gmail.com','manan123','staff','1','2023-04-21 01:57:11','2023-04-21 16:11:45'),(8,'niyati','99477564372','niyati123@gmail.com','niyati123','staff','1','2023-04-22 01:47:25','2023-04-23 10:11:45'),(9,'sanju','9864785734','sanju123@gmail.com','sanju123','staff','1','2023-04-04 03:11:45','2023-04-05 08:11:45'),(10,'poorvik','93847563746','poorvik123@gmail.com','poorvik123','student','1','2023-04-26 16:11:45','2023-04-27 16:11:45'),(11,'yesha','6355238374','yesha123@gmail.com','yesha123','Tamp_Student','1','2023-04-26 18:30:00','2023-04-27 18:30:00'),(12,'vishvajeet','9974348224','vishvajeet123@gmail.com','vishvajeet123','Tamp_Student','1','2023-04-12 18:30:00','2023-04-13 18:30:00'),(13,'prachi','9138274653','prachi123@gmail.com','prachi123','Tamp_Student','1','2023-04-16 18:30:00','2023-04-17 18:30:00');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-30 11:08:19
