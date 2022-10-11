-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: travel_blog
-- ------------------------------------------------------
-- Server version	5.5.5-10.6.7-MariaDB

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
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_post` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `content` text DEFAULT NULL,
  `id_parent` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(254) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `id_locaiton` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel_meta`
--

DROP TABLE IF EXISTS `hotel_meta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotel_meta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_hotel` int(11) NOT NULL,
  `key` char(254) DEFAULT NULL,
  `name` text DEFAULT NULL,
  `value` text DEFAULT NULL,
  `description` text DEFAULT NULL,
  `created_date` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel_meta`
--

LOCK TABLES `hotel_meta` WRITE;
/*!40000 ALTER TABLE `hotel_meta` DISABLE KEYS */;
/*!40000 ALTER TABLE `hotel_meta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `address` varchar(254) DEFAULT NULL,
  `city` varchar(254) DEFAULT NULL,
  `country` varchar(254) DEFAULT NULL,
  `created_date` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,105.9183742,20.252551,'Tràng An, Hoa Lư, Ninh Bình 430000','Ninh Bình','Việt Nam','2022-10-11 11:05:13'),(2,105.61528,22.3963021,'9JW8+G7H, Bố Lù, Ba Bể, Bắc Kạn 23511','Bắc Kạn','Việt Nam','2022-10-11 11:09:37'),(3,105.6087306,20.3167448,'8J85+MFX, Nho Quan, Ninh Bình 432857','Ninh Bình','Việt Nam','2022-10-11 11:10:57'),(4,106.6980208,10.7725168,'Đ. Lê Lợi, Phường Bến Thành, Quận 1, Thành phố Hồ Chí Minh','TP. Hồ Chí Minh','Việt Nam','2022-10-11 11:12:25'),(5,106.6990189,10.7797855,'01 Công xã Paris, Bến Nghé, Quận 1, Thành phố Hồ Chí Minh 70000','TP. Hồ Chí Minh','Việt Nam','2022-10-11 11:13:21'),(6,106.7222812,21.1375887,'Commune, Thượng Yên Công, Uông Bí, Quảng Ninh 200000, Vietnam','Quảng Ninh','Việt Nam','2022-10-11 11:16:14'),(7,108.2266751,16.0383924,'1 Phan Đăng Lưu, Hoà Cường Bắc, Hải Châu, Đà Nẵng','Đà Nẵng','Việt Nam','2022-10-11 11:24:46'),(8,108.032604,16.0265401,'Tuyến cáp treo lên Bà Nà Hills, Hoà Ninh, Hòa Vang, Đà Nẵng','Đà Nẵng','Việt Nam','2022-10-11 11:27:56'),(9,106.8029198,10.8661185,'120 XL Hà Nội, Thành Phố, Thủ Đức, Thành phố Hồ Chí Minh','TP. Hồ Chí Minh','Việt Nam','2022-10-11 11:28:47');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `media`
--

DROP TABLE IF EXISTS `media`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `media` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` text DEFAULT NULL,
  `type` char(254) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `created_date` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `media`
--

LOCK TABLES `media` WRITE;
/*!40000 ALTER TABLE `media` DISABLE KEYS */;
INSERT INTO `media` VALUES (1,'1','image',1,'2022-10-11 11:39:58'),(2,'2','image',1,'2022-10-11 11:39:58'),(3,'3','image',1,'2022-10-11 11:39:58'),(4,'4','image',1,'2022-10-11 11:39:58'),(5,'5','image',1,'2022-10-11 11:39:58'),(6,'6','image',1,'2022-10-11 11:39:58'),(7,'7','image',1,'2022-10-11 11:39:58'),(8,'8','image',1,'2022-10-11 11:39:58'),(9,'9','image',1,'2022-10-11 11:39:58'),(10,'16','image',1,'2022-10-11 11:39:58'),(11,'17','image',1,'2022-10-11 11:39:58'),(12,'18','image',1,'2022-10-11 11:39:58');
/*!40000 ALTER TABLE `media` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` text DEFAULT NULL,
  `content` text DEFAULT NULL,
  `type` varchar(254) DEFAULT 'POST',
  `id_user` int(11) DEFAULT NULL,
  `total_view` int(11) DEFAULT 0,
  `total_like` int(11) DEFAULT 0,
  `rate_point` double DEFAULT 0,
  `created_date` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1,'Chùa Bái Đính - Tràng An','Tràng An là một khu du lịch sinh thái nằm trong Quần thể di sản thế giới Tràng An thuộc tỉnh Ninh Bình. Nơi đây đã được Chính phủ Việt Nam xếp hạng di tích quốc gia đặc biệt quan trọng và UNESCO công nhận là di sản thế giới kép từ năm 2014. Liên khu danh thắng Tràng An – Tam Cốc - Bích Động – cố đô Hoa Lư – rừng đặc dụng Hoa Lư hiện được quy hoạch chung vào Quần thể danh thắng Tràng An, trở thành di sản thế giới kép đầu tiên ở Việt Nam với những giá trị nổi bật về cảnh quan thiên nhiên, lịch sử văn hóa và kiến tạo địa chất và cũng là địa danh được đầu tư để trở thành một khu du lịch tầm cỡ quốc tế.','POST',1,0,0,0,'2022-10-11 11:32:05'),(2,'Vườn quốc gia Ba Bể','Vườn quốc gia Ba Bể là một vườn quốc gia, rừng đặc dụng, khu du lịch sinh thái của Việt Nam, nằm trên địa phận tỉnh Bắc Kạn, với trung tâm là hồ Ba Bể. Vườn quốc gia Ba Bể được thành lập theo Quyết định số 83/TTg ngày 10 tháng 11 năm năm 1992 của Thủ tướng Chính phủ','POST',1,0,0,0,'2022-10-11 11:32:05'),(3,'Vườn Quốc Gia Cúc Phương','Vườn Quốc gia Cúc Phương là một khu bảo tồn thiên nhiên, khu rừng đặc dụng nằm trên địa phận ranh giới 3 khu vực Tây Bắc Bộ, đồng bằng sông Hồng và Bắc Trung Bộ thuộc 3 tỉnh: Ninh Bình, Hòa Bình, Thanh Hóa. Vườn quốc gia này có hệ động thực vật phong phú đa dạng mang đặc trưng rừng mưa nhiệt đới.','POST',1,0,0,0,'2022-10-11 11:32:05'),(4,'Chợ Bến Thành','Chợ Bến Thành là một ngôi chợ nằm tại quận 1, Thành phố Hồ Chí Minh. Chợ được khởi công xây dựng từ năm 1912, hình ảnh đồng hồ ở cửa nam của ngôi chợ này được xem là biểu tượng không chính thức của Thành phố Hồ Chí Minh.','POST',1,0,0,0,'2022-10-11 11:32:05'),(5,'Nhà thờ Đức Bà','Nhà thờ chính tòa Đức Bà Sài Gòn, thường được gọi tắt là Nhà thờ Đức Bà, là nhà thờ chính tòa của Tổng giáo phận Thành phố Hồ Chí Minh','POST',1,0,0,0,'2022-10-11 11:32:05'),(6,'Legacy Yên Tử','Legacy Yên Tử được tọa lạc tại khu di tích và danh thắng Yên Tử, TP Uông Bí, Quảng Ninh – nơi được mệnh danh là cái nôi của Phật giáo Việt Nam, điểm đến lý tưởng để du lịch tâm linh.','POST',1,0,0,0,'2022-10-11 11:32:05'),(7,'Asia Park - Công viên Châu Á','Công viên giải trí có vòng đu quay khổng lồ & trò tàu lượn khác và khu vực vui chơi theo chủ đề các nước Châu Á.','POST',1,0,0,0,'2022-10-11 11:32:05'),(8,'Bà Nà Hill','Bà Nà là quần thể du lịch nghỉ dưỡng toạ lạc tại khu vực thuộc dãy Trường Sơn nằm ở xã Hoà Ninh, Huyện Hòa Vang, cách trung tâm Đà Nẵng khoảng 25km về phía Tây Nam. Toàn bộ quần thể du lịch nghỉ dưỡng nằm trên đỉnh Núi Chúa có độ cao 1489 m so với mực nước biển.','POST',1,0,0,0,'2022-10-11 11:32:05'),(9,'Công viên văn hóa Suối Tiên','Khu Du lịch Văn hóa Suối Tiên là một công viên liên hợp vui chơi giải trí kết hợp truyền thống các yếu tố văn hóa - lịch sử - tâm linh. Tọa lạc tại 120 Xa lộ Hà Nội, Phường Tân Phú, Thành phố Thủ Đức, Thành phố Hồ Chí Minh.','POST',1,0,0,0,'2022-10-11 11:32:05'),(16,'Chùa Bái Đính - Tràng An','Tràng An là một khu du lịch sinh thái nằm trong Quần thể di sản thế giới Tràng An thuộc tỉnh Ninh Bình. Nơi đây đã được Chính phủ Việt Nam xếp hạng di tích quốc gia đặc biệt quan trọng và UNESCO công nhận là di sản thế giới kép từ năm 2014. Liên khu danh thắng Tràng An – Tam Cốc - Bích Động – cố đô Hoa Lư – rừng đặc dụng Hoa Lư hiện được quy hoạch chung vào Quần thể danh thắng Tràng An, trở thành di sản thế giới kép đầu tiên ở Việt Nam với những giá trị nổi bật về cảnh quan thiên nhiên, lịch sử văn hóa và kiến tạo địa chất và cũng là địa danh được đầu tư để trở thành một khu du lịch tầm cỡ quốc tế.','ADS',1,0,0,0,'2022-10-11 11:37:09'),(17,'Vườn quốc gia Ba Bể','Vườn quốc gia Ba Bể là một vườn quốc gia, rừng đặc dụng, khu du lịch sinh thái của Việt Nam, nằm trên địa phận tỉnh Bắc Kạn, với trung tâm là hồ Ba Bể. Vườn quốc gia Ba Bể được thành lập theo Quyết định số 83/TTg ngày 10 tháng 11 năm năm 1992 của Thủ tướng Chính phủ','ADS',1,0,0,0,'2022-10-11 11:37:09'),(18,'Asia Park - Công viên Châu Á','Công viên giải trí có vòng đu quay khổng lồ & trò tàu lượn khác và khu vực vui chơi theo chủ đề các nước Châu Á.','ADS',1,0,0,0,'2022-10-11 11:37:09');
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_media`
--

DROP TABLE IF EXISTS `post_media`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post_media` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_post` int(11) NOT NULL,
  `id_media` int(11) NOT NULL,
  `flag` char(254) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_media`
--

LOCK TABLES `post_media` WRITE;
/*!40000 ALTER TABLE `post_media` DISABLE KEYS */;
INSERT INTO `post_media` VALUES (1,1,1,'thumb'),(2,2,2,'thumb'),(3,3,3,'thumb'),(4,4,4,'thumb'),(5,5,5,'thumb'),(6,6,6,'thumb'),(7,7,7,'thumb'),(8,8,8,'thumb'),(9,9,9,'thumb'),(10,16,10,'thumb'),(11,17,11,'thumb'),(12,18,12,'thumb');
/*!40000 ALTER TABLE `post_media` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_user`
--

DROP TABLE IF EXISTS `post_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `id_post` int(11) NOT NULL,
  `is_read` int(11) DEFAULT NULL,
  `is_like` int(11) DEFAULT NULL,
  `rate` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_user`
--

LOCK TABLES `post_user` WRITE;
/*!40000 ALTER TABLE `post_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `post_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(254) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `created_date` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (1,'Sinh thái','Các loại hình du lịch bao gồm: leo núi, chèo thuyền, tham quan vườn quốc gia, khu di tích, tham quan biển hồ,.','2022-10-11 10:56:10'),(2,'Văn hóa','Các loại hình du lịch bao gồm: thăm đền chùa, thăm di tích lịch sử, di tích quốc gia, văn miếu,...dựa vào những yếu tố phong tục tập quán, tín ngưỡng tâm linh, thói quen nếp sống đặc trưng của một vùng miền để tạo nên dấu ấn riêng thu hút khách du lịch.','2022-10-11 10:56:20'),(3,'Nghỉ dưỡng','Các loại hình du lịch bao gồm: du lịch nghỉ ngơi kết hợp với các dịch vụ làm đẹp, chăm sóc sức khoẻ, bao gồm các hoạt động vui chơi giải trí, massage, tắm nước khoáng, tắm thảo dược, yoga, thiền,....','2022-10-11 10:56:26'),(4,'Giải trí','Các loại hình du lịch bao gồm: bao gồm các hoạt động chạy marathon, đạp xe, bơi lội, leo núi, bóng chuyền bãi biển, lướt ván....Hoặc xa hơn có thể là các trận đấu lớn tầm cỡ quốc gia như các kỳ Thế vận hội, giải đấu World Cup,...','2022-10-11 10:56:32'),(5,'Thể thao','Các loại hình du lịch bao gồm: bao gồm các hoạt động chạy marathon, đạp xe, bơi lội, leo núi, bóng chuyền bãi biển, lướt ván....Hoặc xa hơn có thể là các trận đấu lớn tầm cỡ quốc gia như các kỳ Thế vận hội, giải đấu World Cup,...','2022-10-11 10:56:38'),(6,'Khám phá','Các loại hình du lịch bao gồm: hiện nay phổ biến là các hoạt động nhảy dù tại Mù căng chải ( Yên Bái), trekking Cù Lao Thẩn, săn mây Tà Xùa, hái mận Mộc Châu (Sơn La),....','2022-10-11 10:56:46');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `travel`
--

DROP TABLE IF EXISTS `travel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `travel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(254) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `id_location` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travel`
--

LOCK TABLES `travel` WRITE;
/*!40000 ALTER TABLE `travel` DISABLE KEYS */;
INSERT INTO `travel` VALUES (1,'Chùa Bái Đính - Tràng An','Tràng An là một khu du lịch sinh thái nằm trong Quần thể di sản thế giới Tràng An thuộc tỉnh Ninh Bình. Nơi đây đã được Chính phủ Việt Nam xếp hạng di tích quốc gia đặc biệt quan trọng và UNESCO công nhận là di sản thế giới kép từ năm 2014. Liên khu danh thắng Tràng An – Tam Cốc - Bích Động – cố đô Hoa Lư – rừng đặc dụng Hoa Lư hiện được quy hoạch chung vào Quần thể danh thắng Tràng An, trở thành di sản thế giới kép đầu tiên ở Việt Nam với những giá trị nổi bật về cảnh quan thiên nhiên, lịch sử văn hóa và kiến tạo địa chất và cũng là địa danh được đầu tư để trở thành một khu du lịch tầm cỡ quốc tế.',1,'2022-10-11 11:03:45'),(2,'Vườn quốc gia Ba Bể','Vườn quốc gia Ba Bể là một vườn quốc gia, rừng đặc dụng, khu du lịch sinh thái của Việt Nam, nằm trên địa phận tỉnh Bắc Kạn, với trung tâm là hồ Ba Bể. Vườn quốc gia Ba Bể được thành lập theo Quyết định số 83/TTg ngày 10 tháng 11 năm năm 1992 của Thủ tướng Chính phủ',2,'2022-10-11 11:07:52'),(3,'Vườn Quốc Gia Cúc Phương','Vườn Quốc gia Cúc Phương là một khu bảo tồn thiên nhiên, khu rừng đặc dụng nằm trên địa phận ranh giới 3 khu vực Tây Bắc Bộ, đồng bằng sông Hồng và Bắc Trung Bộ thuộc 3 tỉnh: Ninh Bình, Hòa Bình, Thanh Hóa. Vườn quốc gia này có hệ động thực vật phong phú đa dạng mang đặc trưng rừng mưa nhiệt đới.',3,'2022-10-11 11:10:28'),(4,'Chợ Bến Thành','Chợ Bến Thành là một ngôi chợ nằm tại quận 1, Thành phố Hồ Chí Minh. Chợ được khởi công xây dựng từ năm 1912, hình ảnh đồng hồ ở cửa nam của ngôi chợ này được xem là biểu tượng không chính thức của Thành phố Hồ Chí Minh.',4,'2022-10-11 11:11:58'),(5,'Nhà thờ Đức Bà','Nhà thờ chính tòa Đức Bà Sài Gòn, thường được gọi tắt là Nhà thờ Đức Bà, là nhà thờ chính tòa của Tổng giáo phận Thành phố Hồ Chí Minh',5,'2022-10-11 11:12:54'),(6,'Legacy Yên Tử','Legacy Yên Tử được tọa lạc tại khu di tích và danh thắng Yên Tử, TP Uông Bí, Quảng Ninh – nơi được mệnh danh là cái nôi của Phật giáo Việt Nam, điểm đến lý tưởng để du lịch tâm linh.',6,'2022-10-11 11:13:47'),(7,'Asia Park - Công viên Châu Á','Công viên giải trí có vòng đu quay khổng lồ & trò tàu lượn khác và khu vực vui chơi theo chủ đề các nước Châu Á.',7,'2022-10-11 11:15:50'),(8,'Bà Nà Hill','Bà Nà là quần thể du lịch nghỉ dưỡng toạ lạc tại khu vực thuộc dãy Trường Sơn nằm ở xã Hoà Ninh, Huyện Hòa Vang, cách trung tâm Đà Nẵng khoảng 25km về phía Tây Nam. Toàn bộ quần thể du lịch nghỉ dưỡng nằm trên đỉnh Núi Chúa có độ cao 1489 m so với mực nước biển.',8,'2022-10-11 11:24:22'),(9,'Công viên văn hóa Suối Tiên','Khu Du lịch Văn hóa Suối Tiên là một công viên liên hợp vui chơi giải trí kết hợp truyền thống các yếu tố văn hóa - lịch sử - tâm linh. Tọa lạc tại 120 Xa lộ Hà Nội, Phường Tân Phú, Thành phố Thủ Đức, Thành phố Hồ Chí Minh.',9,'2022-10-11 11:25:23');
/*!40000 ALTER TABLE `travel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `travel_meta`
--

DROP TABLE IF EXISTS `travel_meta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `travel_meta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_travel` int(11) NOT NULL,
  `key` char(254) NOT NULL,
  `name` text NOT NULL,
  `value` text DEFAULT NULL,
  `description` text DEFAULT NULL,
  `created_date` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travel_meta`
--

LOCK TABLES `travel_meta` WRITE;
/*!40000 ALTER TABLE `travel_meta` DISABLE KEYS */;
/*!40000 ALTER TABLE `travel_meta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `travel_post`
--

DROP TABLE IF EXISTS `travel_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `travel_post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_travel` int(11) NOT NULL,
  `id_post` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travel_post`
--

LOCK TABLES `travel_post` WRITE;
/*!40000 ALTER TABLE `travel_post` DISABLE KEYS */;
INSERT INTO `travel_post` VALUES (1,1,1),(2,2,2),(3,3,3),(4,4,4),(5,5,5),(6,6,6),(7,7,7),(8,8,8),(9,9,9),(16,1,16),(17,2,17),(18,7,18);
/*!40000 ALTER TABLE `travel_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `travel_tag`
--

DROP TABLE IF EXISTS `travel_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `travel_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_travel` int(11) NOT NULL,
  `id_tag` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travel_tag`
--

LOCK TABLES `travel_tag` WRITE;
/*!40000 ALTER TABLE `travel_tag` DISABLE KEYS */;
INSERT INTO `travel_tag` VALUES (1,1,1),(2,2,1),(3,3,1),(4,4,2),(5,5,2),(6,6,3),(7,7,4),(8,8,4),(9,9,4);
/*!40000 ALTER TABLE `travel_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(254) NOT NULL,
  `password` varchar(254) NOT NULL,
  `full_name` varchar(254) DEFAULT NULL,
  `phone` varchar(254) DEFAULT NULL,
  `email` varchar(254) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `created_date` varchar(254) NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','$2a$12$TLhMgl4H7lvbh7NbM8wUA.MWxRr1zFp8.7XSzbrYbOg7vo/DvaBDu','Administrator','0355747814','travel@blog.com','1996-12-20',1,'2022-10-10 13:45:46');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_meta`
--

DROP TABLE IF EXISTS `user_meta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_meta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `key` char(254) DEFAULT NULL,
  `name` text DEFAULT NULL,
  `value` text DEFAULT NULL,
  `description` text DEFAULT NULL,
  `created_date` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_meta`
--

LOCK TABLES `user_meta` WRITE;
/*!40000 ALTER TABLE `user_meta` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_meta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_tag`
--

DROP TABLE IF EXISTS `user_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_tag`
--

LOCK TABLES `user_tag` WRITE;
/*!40000 ALTER TABLE `user_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_tag` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-11 17:02:39
