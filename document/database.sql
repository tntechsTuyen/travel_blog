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
  `id_parent` int(11) DEFAULT 0,
  `created_date` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (10,1,1,'a1',0,'2022-10-14 16:49:31'),(11,1,1,'a2',0,'2022-10-14 16:49:39'),(12,1,1,'a3',0,'2022-10-14 16:49:54'),(13,2,1,'ssaaa',0,'2022-10-17 08:43:31'),(14,19,1,'qwqwwqw',0,'2022-10-17 10:48:05'),(15,19,1,'qwqqq',0,'2022-10-17 10:56:18'),(16,5,1,'Test',0,'2022-10-18 13:04:36');
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
  `phone` varchar(254) DEFAULT NULL,
  `work` varchar(254) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `id_location` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES (1,'Bai Dinh Hotel','02293868789','7h - 23h','http://www.baidinhhotel.com/',10,'2022-10-14 13:51:27'),(2,'Bai Dinh Garden Resort & Spa Ninh Binh','0989092882','7h - 23h','http://baidinhgardenresort.com/',11,'2022-10-14 13:52:02'),(3,'Ninh Bình Mountain','0988309226','7h - 23h','N/A',12,'2022-10-14 13:52:35'),(4,'Lien An Saigon Hotel','02838272222','7h - 23h','http://www.lienansaigonhotel.com/',14,'2022-10-18 09:27:44'),(5,'Renaissance Riverside Sài Gòn','02838220033','7h - 23h','https://www.marriott.com/',15,'2022-10-18 09:27:51'),(6,'Khách sạn Cochin Zen','02838227927','7h - 23h','http://cochinsaigonhotels.com/',16,'2022-10-18 09:27:56'),(7,'Central Palace Hotel Saigon','02838290029','7h - 23h','http://www.centralpalacesaigon.com/',17,'2022-10-18 09:28:01'),(8,'Bảo Sang Motel','N/A','7h - 23h','N/A',19,'2022-10-18 09:34:48'),(9,'Anh Việt Motel','0976211167','7h - 23h','N/A',20,'2022-10-18 09:35:10'),(10,'Bin Bin Hotel 4','02822536225','7h - 23h','N/A',22,'2022-10-18 09:38:26'),(11,'Bin Bin Hotel 2','0909606005','7h - 23h','N/A',23,'2022-10-18 09:38:36'),(12,'Bin Bin Hotel 7','0909606005','7h - 23h','N/A',24,'2022-10-18 09:41:48'),(13,'Eva Adam Hotel','0839866766','7h - 23h','http://evaadamhotel.com/',25,'2022-10-18 09:42:36'),(14,'Linh Đan Hotel','0979695989','7h - 23h','https://linhdanhotel.business.site/?utm_source=gmb&utm_medium=referral',27,'2022-10-18 09:48:46'),(15,'Như Quỳnh Hotel','0946711386','7h - 23h','N/A',28,'2022-10-18 09:50:14'),(16,'Brown Bean Hotel','02363621188','7h - 23h','https://www.booking.com/hotel/vn/brown-bean-da-nang.vi.html',29,'2022-10-18 09:54:33'),(17,'Origo Hotel','02363525990','7h - 23h','http://origohotel.com/',30,'2022-10-18 09:58:10'),(18,'Minh Toàn Galaxy Hotel','02363662288','7h - 23h','N/A',31,'2022-10-18 09:59:23'),(19,'The Blossom Resort Đà Nẵng','02363623238','7h - 23h','https://www.theblossomhotels.com/',32,'2022-10-18 10:00:00'),(20,'Mercure French Village Bana Hills 1','02363799888','7h - 23h','https://all.accor.com/hotel/8488/index.en.shtml?utm_campaign=seo+maps&utm_medium=seo+maps&utm_source=google+Maps&y_source=1_MTUzNjAwNTAtNzE1LWxvY2F0aW9uLndlYnNpdGU%3D',33,'2022-10-18 10:03:57'),(21,'Mercure French Village Bana Hills 7','02363799888','7h - 23h','http://www.mercure-danang-banahills-french-village.com/',34,'2022-10-18 10:05:20'),(22,'Hồng Gấm Motel','0986016068','7h - 23h','N/A',35,'2022-10-18 10:10:21'),(23,'Homstay Hải Đăng','N/A','7h - 23h','N/A',36,'2022-10-18 10:11:03'),(24,'Hoa Lan Homestay','0385641124','7h - 23h','http://dili.com.vn/',37,'2022-10-18 10:12:55'),(25,'Quynh Mai Homestay','0336798090','7h - 23h','https://www.facebook.com/Nhanghibabe?ref=hl',38,'2022-10-18 10:13:32'),(26,'Chi Hòa Homestay','0915198915','7h - 23h','https://www.fb.com/chi.nongnguyen',39,'2022-10-18 10:14:11'),(27,'New World Saigon Hotel','02838228888','7h - 23h','https://saigon.newworldhotels.com/',40,'2022-10-18 10:25:27'),(28,'Alagon Plus Hotel & Spa','02838245888','7h - 23h','N/A',41,'2022-10-18 10:27:14'),(29,'Paradise Saigon Boutique Hotel & Spa','02838235555','7h - 23h','http://www.paradisesaigonhotel.com/',42,'2022-10-18 10:28:01'),(30,'A&Em Art Hotel','02835202222','7h - 23h','https://www.a-emhotels.com/en/hotels/aem-art-hotel-in-ho-chi-minh/?partner=7280&utm_source=google&utm_medium=gmb&utm_campaign=web_link',43,'2022-10-18 10:29:16'),(31,'WINSUITES SAIGON - LUXURY BOUTIQUE HOTEL','02862877777','7h - 23h','http://www.winsuitessaigon.com/',44,'2022-10-18 10:30:48');
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel_meta`
--

LOCK TABLES `hotel_meta` WRITE;
/*!40000 ALTER TABLE `hotel_meta` DISABLE KEYS */;
INSERT INTO `hotel_meta` VALUES (1,1,'step_1','Kiểm tra tổng thể căn phòng','Điều này rất quan trọng vì nó ảnh hưởng đến sức khỏe, tài sản thậm chí cả tính mạng của bạn. Theo đó, khi bước vào phòng bạn nên kiểm tra khóa phòng thật kỹ xem có an toàn không, tiếp đến đi xung quanh căn phòng và kiểm tra kỹ cửa sổ, phòng tắm, tủ quần áo… xem có gì bất thường không. Nếu có lập tức báo ngay cho nhân viên khách sạn để nhờ xử lý hoặc xin đổi phòng khác.','','2022-10-17 10:48:40'),(2,1,'step_2','Kiểm tra giường cẩn thận','Tiếp đến bạn kiểm tra kỹ giường ngủ, chăn, ra, nệm vì đây là “nơi” bạn sẽ “gắn bó” hầu hết thời gian khi ở trong phòng. Khách sạn là nơi có rất nhiều người ra vào, do vậy tiềm ẩn rất nhiều vi khuẩn, rận rệp… nhất là những khách sạn bình dân. Nếu phát hiện chăn ra bị bẩn nên thông báo lễ tân để được thay mới và dọn dẹp lại phòng cho sạch sẽ.','','2022-10-17 10:48:52'),(3,1,'step_3','Đọc kỹ nội quy khách sạn','\"Nhập gia tùy tục\" do vậy khi ở khách sạn nào bạn nên đọc kỹ nội quy phòng để tránh gặp phải những phiền phức không đáng có khiến chuyến du lịch mất vui, nhất là khi bạn đi du lịch nước ngoài. Ở một số nơi nếu bạn xem tivi và xài internet hoặc điện thoại bàn sẽ bị tính phí rất cao. Đó là lý do bạn cần “đọc kỹ hướng dẫn trước khi sử dụng”',NULL,'2022-10-18 12:58:54'),(4,1,'step_4','Hạn chế sử dụng điều khiển từ xa','Ở hầu hết các khách sạn, nếu các vật dụng khác được lau chùi sạch sẽ thì riêng chiếc điều khiển tivi nhân viên dọn dẹp sẽ ít để tâm lau chùi hơn. Trong khi đó mỗi ngày có rất nhiều người sử dụng nên không tránh khỏi nó có chứa nhiều vi khuẩn gây bệnh. Nếu muốn sử dụng, bạn nên lau sạch trước khi dùng.',NULL,'2022-10-18 12:58:55'),(5,1,'step_5','Cất giữ những đồ dùng có giá trị thật cẩn thận','Khách sạn là nơi có rất nhiều qua lại hơn nữa là một nơi khá lạ, bạn sẽ không thể biết được ai tốt ai xấu. Do vậy, cẩn tắc vô áy náy, nên cất giữ những đồ dùng có giá trị thật cẩn thận. Trườg hợp đi ra ngoài không tiện mang các đồ giá trị theo, bạn có thể gửi ở nhân viên lễ tân và ký nhận.',NULL,'2022-10-18 12:59:00'),(6,1,'step_6','Thông báo với lễ tân bạn không muốn ai làm phiền','Nếu bạn không muốn bị làm phiền bởi tiếng gõ cửa của nhân viên phục vụ phòng và muốn được yên tĩnh để nghỉ ngơi, hoặc làm việc… trước khi nhận phòng hãy báo với lễ tân điều này.',NULL,'2022-10-18 12:59:07'),(7,1,'step_7','Không nên cho người lạ biết số phòng','Khi đến một nơi xa lạ, nếu có ai đó cố bắt chuyện làm quen và xin địa chỉ nơi ở hoặc số phòng của bạn thì bạn nên tìm cách từ chối khéo léo. Nếu vội vàng cho người lạ địa chỉ bạn sẽ gặp không ít phiền toái hoặc có thể bị lấy trộm đồ thậm chí nguy hiểm tính mạng.',NULL,'2022-10-18 12:59:11');
/*!40000 ALTER TABLE `hotel_meta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel_post`
--

DROP TABLE IF EXISTS `hotel_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotel_post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_hotel` int(11) DEFAULT NULL,
  `id_post` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel_post`
--

LOCK TABLES `hotel_post` WRITE;
/*!40000 ALTER TABLE `hotel_post` DISABLE KEYS */;
INSERT INTO `hotel_post` VALUES (1,1,19),(2,2,20),(3,3,21),(4,4,29),(5,5,30),(6,6,31),(7,7,32),(8,8,33),(9,9,34),(10,10,35),(11,11,36),(12,12,37),(13,13,38),(14,14,39),(15,15,40),(16,16,41),(17,17,42),(18,18,43),(19,19,44),(20,20,45),(21,21,46),(22,22,47),(23,23,48),(24,24,49),(25,25,50),(26,26,51),(27,27,52),(28,28,53),(29,29,54),(30,30,55),(31,31,56);
/*!40000 ALTER TABLE `hotel_post` ENABLE KEYS */;
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
  `code` int(11) NOT NULL,
  `address` varchar(254) DEFAULT NULL,
  `city` varchar(254) DEFAULT NULL,
  `country` varchar(254) DEFAULT NULL,
  `created_date` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,105.9183742,20.252551,430000,'Tràng An, Hoa Lư, Ninh Bình 430000','Ninh Bình','Việt Nam','2022-10-11 11:05:13'),(2,105.61528,22.3963021,960000,'Thôn Bản Mới,xã Hà Hiệu, Ba Bể, Bắc Kạn 23519, Việt Nam','Bắc Kạn','Việt Nam','2022-10-11 11:09:37'),(3,105.6087306,20.3167448,430000,'8J85+MFX, Nho Quan, Ninh Bình 432857','Ninh Bình','Việt Nam','2022-10-11 11:10:57'),(4,106.6980208,10.7725168,700000,'Đ. Lê Lợi, Phường Bến Thành, Quận 1, Thành phố Hồ Chí Minh','TP. Hồ Chí Minh','Việt Nam','2022-10-11 11:12:25'),(5,106.6990189,10.7797855,700000,'01 Công xã Paris, Bến Nghé, Quận 1, Thành phố Hồ Chí Minh 70000','TP. Hồ Chí Minh','Việt Nam','2022-10-11 11:13:21'),(6,106.7222812,21.1375887,200000,'Commune, Thượng Yên Công, Uông Bí, Quảng Ninh 200000, Vietnam','Quảng Ninh','Việt Nam','2022-10-11 11:16:14'),(7,108.2266751,16.0383924,550000,'1 Phan Đăng Lưu, Hoà Cường Bắc, Hải Châu, Đà Nẵng','Đà Nẵng','Việt Nam','2022-10-11 11:24:46'),(8,108.032604,16.0265401,550000,'Tuyến cáp treo lên Bà Nà Hills, Hoà Ninh, Hòa Vang, Đà Nẵng','Đà Nẵng','Việt Nam','2022-10-11 11:27:56'),(9,106.8029198,10.8661185,700000,'120 XL Hà Nội, Thành Phố, Thủ Đức, Thành phố Hồ Chí Minh','TP. Hồ Chí Minh','Việt Nam','2022-10-11 11:28:47'),(10,105.8669729,20.2746103,430000,'7VF8+FG5, Bai Dinh Pagoda Area, Gia Sinh Village, Gia Sinh, Gia Viễn, Ninh Bình, Việt Nam','Ninh Bình','Việt Nam','2022-10-14 13:54:27'),(11,105.8628766,20.2754879,430000,'Hamlet 5 Bai Dinh Pagoda Area, Gia Sinh, Gia Viễn, Ninh Bình 08000, Việt Nam','Ninh Bình','Việt Nam','2022-10-14 13:54:58'),(12,105.8669036,20.2773193,430000,'7VGC+W48, QL38B, Gia Sinh, Ninh Bình, Việt Nam','Ninh Bình','Việt Nam','2022-10-14 13:55:34'),(13,106.6958695867219,10.777277315569915,700000,'135 Đ. Nam Kỳ Khởi Nghĩa, Phường Bến Thành, Quận 1, Thành phố Hồ Chí Minh','TP. Hồ Chí Minh','Việt Nam','2022-10-18 09:20:45'),(14,106.6948953,10.7769109,700000,'181 Lê Thánh Tôn, Phường Bến Thành, Quận 1, Thành phố Hồ Chí Minh, Việt Nam','TP. Hồ Chí Minh','Việt Nam','2022-10-18 09:21:14'),(15,106.70625509914473,10.774284055670988,700000,'15 Đ. Tôn Đức Thắng, Bến Nghé, Quận 1, Thành phố Hồ Chí Minh, Việt Nam','TP. Hồ Chí Minh','Việt Nam','2022-10-18 09:23:23'),(16,106.69665827195124,10.774532121872976,700000,'46 Thủ Khoa Huân, Street, Quận 1, Thành phố Hồ Chí Minh 70000, Việt Nam','TP. Hồ Chí Minh','Việt Nam','2022-10-18 09:25:53'),(17,106.69705295257165,10.775375611434768,700000,'39-39A Nguyễn Trung Trực, Phường Bến Thành, Quận 1, Thành phố Hồ Chí Minh, Việt Nam','TP. Hồ Chí Minh','Việt Nam','2022-10-18 09:26:09'),(18,106.4622444,11.1420742,700000,'Đ. Tỉnh Lộ 15, Phú Hiệp, Củ Chi, Thành phố Hồ Chí Minh 733814','TP. Hồ Chí Minh','Việt Nam','2022-10-18 09:31:27'),(19,106.46305154373702,11.14715567383176,700000,'2139 Đ. Tỉnh Lộ 15, Phú Mỹ Hưng, Củ Chi, Thành phố Hồ Chí Minh, Việt Nam','TP. Hồ Chí Minh','Việt Nam','2022-10-18 09:32:30'),(20,106.4596917991692,11.151145976243706,700000,'2066 Đ. Tỉnh Lộ 15, Phú Hiệp, Củ Chi, Thành phố Hồ Chí Minh, Việt Nam','TP. Hồ Chí Minh','Việt Nam','2022-10-18 09:32:42'),(21,106.6946071,10.7428351,700000,'2 Đường số 9, Khu đô thị Him Lam, Quận 7, Thành phố Hồ Chí Minh','TP. Hồ Chí Minh','Việt Nam','2022-10-18 09:37:26'),(22,106.69531282082043,10.740128514174884,700000,'20 Đường số 11, Khu đô thị Him Lam, Quận 7, Thành phố Hồ Chí Minh, Việt Nam','TP. Hồ Chí Minh','Việt Nam','2022-10-18 09:37:59'),(23,106.69571497050732,10.74058499443724,700000,'L19 Đường số 14, Khu đô thị Him Lam, Quận 7, Thành phố Hồ Chí Minh, Việt Nam','TP. Hồ Chí Minh','Việt Nam','2022-10-18 09:38:59'),(24,106.69646851326182,10.744248319513456,700000,'40 Đường số 4, Tân Hưng, Quận 7, Thành phố Hồ Chí Minh, Việt Nam','TP. Hồ Chí Minh','Việt Nam','2022-10-18 09:41:36'),(25,106.69633645032276,10.739540776326676,700000,'65 Đ. D1, Tân Hưng, Quận 7, Thành phố Hồ Chí Minh, Việt Nam','TP. Hồ Chí Minh','Việt Nam','2022-10-18 09:43:00'),(26,106.6339267,10.7687894,700000,'3 Hòa Bình, Phường 3, Quận 11, Thành phố Hồ Chí Minh','TP. Hồ Chí Minh','Việt Nam','2022-10-18 09:46:22'),(27,106.63234742894514,10.766725195476058,700000,'1 Bùi Cẩm Hổ, Tân Thới Hoà, Tân Phú, Thành phố Hồ Chí Minh 761002, Việt Nam','TP. Hồ Chí Minh','Việt Nam','2022-10-18 09:49:06'),(28,106.63175160749037,10.766736768164447,700000,'153A Lũy Bán Bích, Tân Thới Hoà, Tân Phú, Thành phố Hồ Chí Minh, Việt Nam','TP. Hồ Chí Minh','Việt Nam','2022-10-18 09:50:27'),(29,108.22346418331499,16.038565338748253,550000,'380 Đ. 2 Tháng 9, Hoà Cường Bắc, Hải Châu, Đà Nẵng','Đà Nẵng','Việt Nam','2022-10-18 09:57:03'),(30,108.22357585827726,16.036864840861547,550000,'436 Đ. 2 Tháng 9, Hoà Cường Nam, Hải Châu, Đà Nẵng 550000, Việt Nam','Đà Nẵng','Việt Nam','2022-10-18 09:57:42'),(31,108.22254766672418,16.04399675009107,550000,'306 Đ. 2 Tháng 9, Hoà Cường Bắc, Hải Châu, Đà Nẵng 550000, Việt Nam','Đà Nẵng','Việt Nam','2022-10-18 09:59:04'),(32,108.2269990317545,16.045474745933213,550000,'Lô A1, A2 khu đảo xanh mở rộng, Đà Nẵng, 23445, Việt Nam','Đà Nẵng','Việt Nam','2022-10-18 10:00:22'),(33,107.98822711416895,15.997419051966034,550000,'Hoà Phú, Hòa Vang, Đà Nẵng, Việt Nam','Đà Nẵng','Việt Nam','2022-10-18 10:04:20'),(34,107.986748871279,15.99722225395362,550000,'Hoà Phú, Hòa Vang, Đà Nẵng, Việt Nam','Đà Nẵng','Việt Nam','2022-10-18 10:05:59'),(35,105.617427,22.397275,960000,'Thôn Bản Mới,xã Hà Hiệu, Ba Bể, Bắc Kạn 23519, Việt Nam','Bắc Kạn','Việt Nam','2022-10-18 10:10:47'),(36,105.616194,22.396582,960000,'Thôn Bản Mới,xã Hà Hiệu, Ba Bể, Bắc Kạn 23519, Việt Nam','Bắc Kạn','Việt Nam','2022-10-18 10:12:21'),(37,105.617202,22.39725,960000,'Thôn Bản Mới,xã Hà Hiệu, Ba Bể, Bắc Kạn 23519, Việt Nam','Bắc Kạn','Việt Nam','2022-10-18 10:13:09'),(38,105.616946,22.397701,960000,'Thôn Bản Mới,xã Hà Hiệu, Ba Bể, Bắc Kạn 23519, Việt Nam','Bắc Kạn','Việt Nam','2022-10-18 10:13:50'),(39,105.617623,22.398866,960000,'Thôn Bản Mới,xã Hà Hiệu, Ba Bể, Bắc Kạn 23519, Việt Nam','Bắc Kạn','Việt Nam','2022-10-18 10:14:31'),(40,106.69514707200132,10.77105369642795,550000,'76 Lê Lai, Phường Bến Thành, Quận 1, Thành phố Hồ Chí Minh 700000, Việt Nam','TP. Hồ Chí Minh',NULL,'2022-10-18 10:26:59'),(41,106.69459603365023,10.77144790877662,550000,'52 Phạm Hồng Thái, Phường Bến Thành, Quận 1, Thành phố Hồ Chí Minh 70000, Việt Nam','TP. Hồ Chí Minh',NULL,'2022-10-18 10:27:31'),(42,106.69490365545802,10.771522152088506,550000,'288 Lê Thánh Tôn, Phường Bến Thành, Quận 1, Thành phố Hồ Chí Minh 700000, Việt Nam','TP. Hồ Chí Minh',NULL,'2022-10-18 10:28:48'),(43,106.69512612248718,10.77172710536394,550000,'31-35 Lê Anh Xuân, Phường Bến Thành, Quận 1, Thành phố Hồ Chí Minh 70000, Việt Nam','TP. Hồ Chí Minh',NULL,'2022-10-18 10:29:36'),(44,106.69687803636124,10.77150390952482,550000,'32 Lê Lai, St, Quận 1, Thành phố Hồ Chí Minh 700000, Việt Nam','TP. Hồ Chí Minh',NULL,'2022-10-18 10:31:51');
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
  `description` text DEFAULT NULL,
  `created_date` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `media`
--

LOCK TABLES `media` WRITE;
/*!40000 ALTER TABLE `media` DISABLE KEYS */;
INSERT INTO `media` VALUES (1,'static/media/bai_dinh_travel.png','image',1,'Chùa Bái Đính - Tràng An','2022-10-11 11:39:58'),(2,'static/media/ba_be_travel.png','image',1,'Vườn quốc gia Ba Bể','2022-10-11 11:39:58'),(3,'static/media/cuc_phuong_travel.png','image',1,'Vườn Quốc Gia Cúc Phương','2022-10-11 11:39:58'),(4,'static/media/ben_thanh_travel.png','image',1,'Chợ Bến Thành','2022-10-11 11:39:58'),(5,'static/media/nha_tho_duc_ba_travel.png','image',1,'Nhà thờ Đức Bà','2022-10-11 11:39:58'),(6,'static/media/yen_tu_travel.png','image',1,'Legacy Yên Tử','2022-10-11 11:39:58'),(7,'static/media/asia_park_travel.png','image',1,'Asia Park - Công viên Châu Á','2022-10-11 11:39:58'),(8,'static/media/ba_na_hill_travel.png','image',1,'Bà Nà Hill','2022-10-11 11:39:58'),(9,'static/media/suoi_tien_travel.png','image',1,'Công viên văn hóa Suối Tiên','2022-10-11 11:39:58'),(10,'static/media/bai_dinh_hotel.png','image',1,'Bai Dinh Hotel','2022-10-11 11:39:58'),(11,'static/media/bai_dinh_garden_resort_hotel.png','image',1,'Bai Dinh Garden Resort & Spa Ninh Binh','2022-10-11 11:39:58'),(12,'static/media/ninh_binh_hotel.png','image',1,'Ninh Bình Mountain','2022-10-11 11:39:58'),(13,'static/media/dinh_doc_lap_travel.png','image',1,'Dinh Độc Lập','2022-10-18 10:46:46'),(14,'static/media/dia_dao_cu_chi_travel.png','image',1,'Địa đạo Củ Chi','2022-10-18 10:46:46'),(15,'static/media/3d_artinus_travel.png','image',1,'Khu triển lãm tranh 3D Artinus','2022-10-18 10:46:46'),(16,'static/media/dam_sen_travel.png','image',1,'Công viên nước Đầm Sen','2022-10-18 10:46:46'),(17,'static/media/lien_an_saigon_hotel.png','image',1,'Lien An Saigon Hotel','2022-10-18 10:46:46'),(18,'static/media/renaissance_riverside_hotel.png','image',1,'Renaissance Riverside Sài Gòn','2022-10-18 10:46:46'),(19,'static/media/cochin_zen_hotel.png','image',1,'Khách sạn Cochin Zen','2022-10-18 10:46:46'),(20,'static/media/central_palace_hotel_saigon.png','image',1,'Central Palace Hotel Saigon','2022-10-18 10:46:46'),(21,'static/media/bao_sang_motel.png','image',1,'Bảo Sang Motel','2022-10-18 10:46:46'),(22,'static/media/anh_viet_motel.png','image',1,'Anh Việt Motel','2022-10-18 10:46:46'),(23,'static/media/bin_bin_hotel_4.png','image',1,'Bin Bin Hotel 4','2022-10-18 10:46:46'),(24,'static/media/bin_bin_hotel_2.png','image',1,'Bin Bin Hotel 2','2022-10-18 10:46:46'),(25,'static/media/bin_bin_hotel_7.png','image',1,'Bin Bin Hotel 7','2022-10-18 10:46:46'),(26,'static/media/eva_adam_hotel.png','image',1,'Eva Adam Hotel','2022-10-18 10:46:46'),(27,'static/media/linh_dan_hotel.png','image',1,'Linh Đan Hotel','2022-10-18 10:46:46'),(28,'static/media/nhu_quynh_hotel.png','image',1,'Như Quỳnh Hotel','2022-10-18 10:46:46'),(29,'static/media/brown_bean_hotel.png','image',1,'Brown Bean Hotel','2022-10-18 10:46:46'),(30,'static/media/origo_hotel.png','image',1,'Origo Hotel','2022-10-18 10:46:46'),(31,'static/media/minh_toan_galaxy_hotel.png','image',1,'Minh Toàn Galaxy Hotel','2022-10-18 10:46:46'),(32,'static/media/the_blossom_resort_da_nang.png','image',1,'The Blossom Resort Đà Nẵng','2022-10-18 10:46:46'),(33,'static/media/mercure_french_village_bana_hills_1.png','image',1,'Mercure French Village Bana Hills 1','2022-10-18 10:46:46'),(34,'static/media/mercure_french_village_bana_hills_7.png','image',1,'Mercure French Village Bana Hills 7','2022-10-18 10:46:46'),(35,'static/media/hong_gam_motel.png','image',1,'Hồng Gấm Motel','2022-10-18 10:46:46'),(36,'static/media/homstay_hai_dang.png','image',1,'Homstay Hải Đăng','2022-10-18 10:46:46'),(37,'static/media/hoa_lan_homestay.png','image',1,'Hoa Lan Homestay','2022-10-18 10:46:46'),(38,'static/media/quynh_mai_homestay.png','image',1,'Quynh Mai Homestay','2022-10-18 10:46:46'),(39,'static/media/chi_hoa_homestay.png','image',1,'Chi Hòa Homestay','2022-10-18 10:46:46'),(40,'static/media/new_world_saigon_hotel.png','image',1,'New World Saigon Hotel','2022-10-18 10:46:46'),(41,'static/media/alagon_plus_hotel_spa.png','image',1,'Alagon Plus Hotel & Spa','2022-10-18 10:46:46'),(42,'static/media/paradise_saigon_boutique_hotel_spa.png','image',1,'Paradise Saigon Boutique Hotel & Spa','2022-10-18 10:46:46'),(43,'static/media/a&em_art_hotel.png','image',1,'A&Em Art Hotel','2022-10-18 10:46:46'),(44,'static/media/winsuites_saigon_luxury_boutique_hotel.png','image',1,'WINSUITES SAIGON - LUXURY BOUTIQUE HOTEL','2022-10-18 10:46:46');
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
  `id_user` int(11) DEFAULT 1,
  `total_view` int(11) DEFAULT 0,
  `total_like` int(11) DEFAULT 0,
  `total_comment` int(11) DEFAULT 0,
  `rate_point` double DEFAULT 0,
  `is_ads` int(11) DEFAULT 0 COMMENT '(0/1)',
  `created_date` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1,'Chùa Bái Đính - Tràng An','Tràng An là một khu du lịch sinh thái nằm trong Quần thể di sản thế giới Tràng An thuộc tỉnh Ninh Bình. Nơi đây đã được Chính phủ Việt Nam xếp hạng di tích quốc gia đặc biệt quan trọng và UNESCO công nhận là di sản thế giới kép từ năm 2014. Liên khu danh thắng Tràng An – Tam Cốc - Bích Động – cố đô Hoa Lư – rừng đặc dụng Hoa Lư hiện được quy hoạch chung vào Quần thể danh thắng Tràng An, trở thành di sản thế giới kép đầu tiên ở Việt Nam với những giá trị nổi bật về cảnh quan thiên nhiên, lịch sử văn hóa và kiến tạo địa chất và cũng là địa danh được đầu tư để trở thành một khu du lịch tầm cỡ quốc tế.','POST',1,2,0,3,3.5,1,'2022-10-11 11:32:05'),(2,'Vườn quốc gia Ba Bể','Vườn quốc gia Ba Bể là một vườn quốc gia, rừng đặc dụng, khu du lịch sinh thái của Việt Nam, nằm trên địa phận tỉnh Bắc Kạn, với trung tâm là hồ Ba Bể. Vườn quốc gia Ba Bể được thành lập theo Quyết định số 83/TTg ngày 10 tháng 11 năm năm 1992 của Thủ tướng Chính phủ','POST',1,1,1,1,4,1,'2022-10-11 11:32:05'),(3,'Vườn Quốc Gia Cúc Phương','Vườn Quốc gia Cúc Phương là một khu bảo tồn thiên nhiên, khu rừng đặc dụng nằm trên địa phận ranh giới 3 khu vực Tây Bắc Bộ, đồng bằng sông Hồng và Bắc Trung Bộ thuộc 3 tỉnh: Ninh Bình, Hòa Bình, Thanh Hóa. Vườn quốc gia này có hệ động thực vật phong phú đa dạng mang đặc trưng rừng mưa nhiệt đới.','POST',1,1,0,0,0,1,'2022-10-11 11:32:05'),(4,'Chợ Bến Thành','Chợ Bến Thành là một ngôi chợ nằm tại quận 1, Thành phố Hồ Chí Minh. Chợ được khởi công xây dựng từ năm 1912, hình ảnh đồng hồ ở cửa nam của ngôi chợ này được xem là biểu tượng không chính thức của Thành phố Hồ Chí Minh.','POST',1,1,0,0,0,0,'2022-10-11 11:32:05'),(5,'Nhà thờ Đức Bà','Nhà thờ chính tòa Đức Bà Sài Gòn, thường được gọi tắt là Nhà thờ Đức Bà, là nhà thờ chính tòa của Tổng giáo phận Thành phố Hồ Chí Minh','POST',1,1,0,1,0,0,'2022-10-11 11:32:05'),(6,'Legacy Yên Tử','Legacy Yên Tử được tọa lạc tại khu di tích và danh thắng Yên Tử, TP Uông Bí, Quảng Ninh – nơi được mệnh danh là cái nôi của Phật giáo Việt Nam, điểm đến lý tưởng để du lịch tâm linh.','POST',1,0,0,0,0,0,'2022-10-11 11:32:05'),(7,'Asia Park - Công viên Châu Á','Công viên giải trí có vòng đu quay khổng lồ & trò tàu lượn khác và khu vực vui chơi theo chủ đề các nước Châu Á.','POST',1,0,0,0,0,0,'2022-10-11 11:32:05'),(8,'Bà Nà Hill','Bà Nà là quần thể du lịch nghỉ dưỡng toạ lạc tại khu vực thuộc dãy Trường Sơn nằm ở xã Hoà Ninh, Huyện Hòa Vang, cách trung tâm Đà Nẵng khoảng 25km về phía Tây Nam. Toàn bộ quần thể du lịch nghỉ dưỡng nằm trên đỉnh Núi Chúa có độ cao 1489 m so với mực nước biển.','POST',1,0,0,0,0,0,'2022-10-11 11:32:05'),(9,'Công viên văn hóa Suối Tiên','Khu Du lịch Văn hóa Suối Tiên là một công viên liên hợp vui chơi giải trí kết hợp truyền thống các yếu tố văn hóa - lịch sử - tâm linh. Tọa lạc tại 120 Xa lộ Hà Nội, Phường Tân Phú, Thành phố Thủ Đức, Thành phố Hồ Chí Minh.','POST',1,0,0,0,0,0,'2022-10-11 11:32:05'),(19,'Bai Dinh Hotel','http://www.baidinhhotel.com/','POST',1,1,0,2,0,0,'2022-10-17 10:25:45'),(20,'Bai Dinh Garden Resort & Spa Ninh Binh','http://baidinhgardenresort.com/','POST',1,1,0,0,0,0,'2022-10-17 10:25:45'),(21,'Ninh Bình Mountain','N/A','POST',1,1,0,0,0,0,'2022-10-17 10:25:45'),(22,'Dinh Độc Lập','Dinh Độc Lập hay Hội trường Thống Nhất là một công trình kiến trúc, tòa nhà ở Thành phố Hồ Chí Minh. Đây từng là nơi ở và làm việc của Tổng thống Việt Nam Cộng hòa. Hiện nay, dinh đã được Chính phủ Việt Nam xếp hạng là di tích quốc gia đặc biệt.','POST',1,0,0,0,0,0,'2022-10-18 10:40:51'),(23,'Địa đạo Củ Chi','Địa đạo Củ Chi là một hệ thống phòng thủ trong lòng đất ở huyện Củ Chi, cách Thành phố Hồ Chí Minh 70 km về hướng tây-bắc. Hệ thống này được quân kháng chiến Việt Minh và Mặt trận Dân tộc Giải phóng miền Nam Việt Nam đào trong thời kỳ Chiến tranh Đông Dương và Chiến tranh Việt Nam','POST',1,0,0,0,0,0,'2022-10-18 10:40:51'),(24,'Khu triển lãm tranh 3D Artinus','Artinus 3D Art Gallery là bảo tàng mỹ thuật kinh doanh xoay quanh chủ đề vật thể 3 chiều Object và 3D painting xuất hiện lần đầu tiên tại Việt Nam. Đến với Artinus các bạn sẽ được trải nghiệm tham quan và lưu giữ những khoảnh khắc độc đáo. Đắm chìm vào thế giới ảo giác như hội họa, lập thể, nội thất… với từng cung bậc cảm xúc lúc trầm, lúc bổng, lúc sợ hãi và đầy kinh ngạc không thua kém các bảo tàng tranh 3D nổi tiếng trên thế giới.','POST',1,0,0,0,0,0,'2022-10-18 10:40:51'),(25,'Công viên nước Đầm Sen','Công viên nước Đầm Sen ra đời từ năm 1998, trở thành điểm đến quen thuộc của người dân địa phương và các tỉnh, thành phía Nam khi đặt chân đến TP.HCM. Bên cạnh khu công viên nước là khu vực công viên văn hóa Đầm Sen (hay còn gọi là Đầm Sen khô) tạo nên một quần thể giải trí lên gần 50 ha với gần 40 trò chơi cho cả nhà.\r\n\r\nMặc dù ra đời đã lâu nhưng đây vẫn là công viên nước giải trí hầu như duy nhất tại trung tâm TP.HCM. Vì vậy mỗi dịp cuối tuần hay vào hè, đây là một trong những điểm \"hot\" khi các gia đình đưa con em đến vui chơi, giải trí. ','POST',1,0,0,0,0,0,'2022-10-18 10:40:51'),(29,'Lien An Saigon Hotel','http://www.lienansaigonhotel.com/','POST',1,0,0,0,0,0,'2022-10-18 10:44:04'),(30,'Renaissance Riverside Sài Gòn','https://www.marriott.com/','POST',1,0,0,0,0,0,'2022-10-18 10:44:04'),(31,'Khách sạn Cochin Zen','http://cochinsaigonhotels.com/','POST',1,0,0,0,0,0,'2022-10-18 10:44:04'),(32,'Central Palace Hotel Saigon','http://www.centralpalacesaigon.com/','POST',1,0,0,0,0,0,'2022-10-18 10:44:04'),(33,'Bảo Sang Motel','N/A','POST',1,0,0,0,0,0,'2022-10-18 10:44:04'),(34,'Anh Việt Motel','N/A','POST',1,0,0,0,0,0,'2022-10-18 10:44:04'),(35,'Bin Bin Hotel 4','N/A','POST',1,0,0,0,0,0,'2022-10-18 10:44:04'),(36,'Bin Bin Hotel 2','N/A','POST',1,0,0,0,0,0,'2022-10-18 10:44:04'),(37,'Bin Bin Hotel 7','N/A','POST',1,0,0,0,0,0,'2022-10-18 10:44:04'),(38,'Eva Adam Hotel','http://evaadamhotel.com/','POST',1,0,0,0,0,0,'2022-10-18 10:44:04'),(39,'Linh Đan Hotel','https://linhdanhotel.business.site/?utm_source=gmb&utm_medium=referral','POST',1,0,0,0,0,0,'2022-10-18 10:44:04'),(40,'Như Quỳnh Hotel','N/A','POST',1,1,0,0,0,0,'2022-10-18 10:44:04'),(41,'Brown Bean Hotel','https://www.booking.com/hotel/vn/brown-bean-da-nang.vi.html','POST',1,0,0,0,0,0,'2022-10-18 10:44:04'),(42,'Origo Hotel','http://origohotel.com/','POST',1,0,0,0,0,0,'2022-10-18 10:44:04'),(43,'Minh Toàn Galaxy Hotel','N/A','POST',1,0,0,0,0,0,'2022-10-18 10:44:04'),(44,'The Blossom Resort Đà Nẵng','https://www.theblossomhotels.com/','POST',1,0,0,0,0,0,'2022-10-18 10:44:04'),(45,'Mercure French Village Bana Hills 1','N/A','POST',1,0,0,0,0,0,'2022-10-18 10:44:04'),(46,'Mercure French Village Bana Hills 7','N/A','POST',1,0,0,0,0,0,'2022-10-18 10:44:04'),(47,'Hồng Gấm Motel','N/A','POST',1,0,0,0,0,0,'2022-10-18 10:44:04'),(48,'Homstay Hải Đăng','N/A','POST',1,0,0,0,0,0,'2022-10-18 10:44:04'),(49,'Hoa Lan Homestay','http://dili.com.vn/','POST',1,1,0,0,0,0,'2022-10-18 10:44:04'),(50,'Quynh Mai Homestay','https://www.facebook.com/Nhanghibabe?ref=hl','POST',1,0,0,0,0,0,'2022-10-18 10:44:04'),(51,'Chi Hòa Homestay','https://www.fb.com/chi.nongnguyen','POST',1,0,0,0,0,0,'2022-10-18 10:44:04'),(52,'New World Saigon Hotel','https://saigon.newworldhotels.com/','POST',1,0,0,0,0,0,'2022-10-18 10:44:04'),(53,'Alagon Plus Hotel & Spa',NULL,'POST',1,0,0,0,0,0,'2022-10-18 10:44:04'),(54,'Paradise Saigon Boutique Hotel & Spa','http://www.paradisesaigonhotel.com/','POST',1,0,0,0,0,0,'2022-10-18 10:44:04'),(55,'A&Em Art Hotel','https://www.a-emhotels.com/en/hotels/aem-art-hotel-in-ho-chi-minh/?partner=7280&utm_source=google&utm_medium=gmb&utm_campaign=web_link','POST',1,0,0,0,0,0,'2022-10-18 10:44:04'),(56,'WINSUITES SAIGON - LUXURY BOUTIQUE HOTEL','http://www.winsuitessaigon.com/','POST',1,0,0,0,0,0,'2022-10-18 10:44:04');
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
) ENGINE=InnoDB AUTO_INCREMENT=139 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_media`
--

LOCK TABLES `post_media` WRITE;
/*!40000 ALTER TABLE `post_media` DISABLE KEYS */;
INSERT INTO `post_media` VALUES (1,1,1,'thumb'),(2,2,2,'thumb'),(3,3,3,'thumb'),(4,4,4,'thumb'),(5,5,5,'thumb'),(6,6,6,'thumb'),(7,7,7,'thumb'),(8,8,8,'thumb'),(9,9,9,'thumb'),(76,19,10,'thumb'),(77,20,11,'thumb'),(78,21,12,'thumb'),(79,22,13,'thumb'),(80,23,14,'thumb'),(81,24,15,'thumb'),(82,25,16,'thumb'),(83,29,17,'thumb'),(84,30,18,'thumb'),(85,31,19,'thumb'),(86,32,20,'thumb'),(87,33,21,'thumb'),(88,34,22,'thumb'),(89,35,23,'thumb'),(90,36,24,'thumb'),(91,37,25,'thumb'),(92,38,26,'thumb'),(93,39,27,'thumb'),(94,40,28,'thumb'),(95,41,29,'thumb'),(96,42,30,'thumb'),(97,43,31,'thumb'),(98,44,32,'thumb'),(99,45,33,'thumb'),(100,46,34,'thumb'),(101,47,35,'thumb'),(102,48,36,'thumb'),(103,49,37,'thumb'),(104,50,38,'thumb'),(105,51,39,'thumb'),(106,52,40,'thumb'),(107,53,41,'thumb'),(108,54,42,'thumb'),(109,55,43,'thumb'),(110,56,44,'thumb');
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_user`
--

LOCK TABLES `post_user` WRITE;
/*!40000 ALTER TABLE `post_user` DISABLE KEYS */;
INSERT INTO `post_user` VALUES (4,1,1,1,0,3),(5,1,5,1,0,0),(6,2,1,1,0,4),(7,1,2,1,0,4),(8,1,3,1,0,0),(9,1,19,1,0,0),(10,1,21,1,0,0),(11,1,20,1,0,0),(12,1,4,1,0,0),(13,1,49,1,0,0),(14,1,40,1,0,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travel`
--

LOCK TABLES `travel` WRITE;
/*!40000 ALTER TABLE `travel` DISABLE KEYS */;
INSERT INTO `travel` VALUES (1,'Chùa Bái Đính - Tràng An','Tràng An là một khu du lịch sinh thái nằm trong Quần thể di sản thế giới Tràng An thuộc tỉnh Ninh Bình. Nơi đây đã được Chính phủ Việt Nam xếp hạng di tích quốc gia đặc biệt quan trọng và UNESCO công nhận là di sản thế giới kép từ năm 2014. Liên khu danh thắng Tràng An – Tam Cốc - Bích Động – cố đô Hoa Lư – rừng đặc dụng Hoa Lư hiện được quy hoạch chung vào Quần thể danh thắng Tràng An, trở thành di sản thế giới kép đầu tiên ở Việt Nam với những giá trị nổi bật về cảnh quan thiên nhiên, lịch sử văn hóa và kiến tạo địa chất và cũng là địa danh được đầu tư để trở thành một khu du lịch tầm cỡ quốc tế.',1,'2022-10-11 11:03:45'),(2,'Vườn quốc gia Ba Bể','Vườn quốc gia Ba Bể là một vườn quốc gia, rừng đặc dụng, khu du lịch sinh thái của Việt Nam, nằm trên địa phận tỉnh Bắc Kạn, với trung tâm là hồ Ba Bể. Vườn quốc gia Ba Bể được thành lập theo Quyết định số 83/TTg ngày 10 tháng 11 năm năm 1992 của Thủ tướng Chính phủ',2,'2022-10-11 11:07:52'),(3,'Vườn Quốc Gia Cúc Phương','Vườn Quốc gia Cúc Phương là một khu bảo tồn thiên nhiên, khu rừng đặc dụng nằm trên địa phận ranh giới 3 khu vực Tây Bắc Bộ, đồng bằng sông Hồng và Bắc Trung Bộ thuộc 3 tỉnh: Ninh Bình, Hòa Bình, Thanh Hóa. Vườn quốc gia này có hệ động thực vật phong phú đa dạng mang đặc trưng rừng mưa nhiệt đới.',3,'2022-10-11 11:10:28'),(4,'Chợ Bến Thành','Chợ Bến Thành là một ngôi chợ nằm tại quận 1, Thành phố Hồ Chí Minh. Chợ được khởi công xây dựng từ năm 1912, hình ảnh đồng hồ ở cửa nam của ngôi chợ này được xem là biểu tượng không chính thức của Thành phố Hồ Chí Minh.',4,'2022-10-11 11:11:58'),(5,'Nhà thờ Đức Bà','Nhà thờ chính tòa Đức Bà Sài Gòn, thường được gọi tắt là Nhà thờ Đức Bà, là nhà thờ chính tòa của Tổng giáo phận Thành phố Hồ Chí Minh',5,'2022-10-11 11:12:54'),(6,'Legacy Yên Tử','Legacy Yên Tử được tọa lạc tại khu di tích và danh thắng Yên Tử, TP Uông Bí, Quảng Ninh – nơi được mệnh danh là cái nôi của Phật giáo Việt Nam, điểm đến lý tưởng để du lịch tâm linh.',6,'2022-10-11 11:13:47'),(7,'Asia Park - Công viên Châu Á','Công viên giải trí có vòng đu quay khổng lồ & trò tàu lượn khác và khu vực vui chơi theo chủ đề các nước Châu Á.',7,'2022-10-11 11:15:50'),(8,'Bà Nà Hill','Bà Nà là quần thể du lịch nghỉ dưỡng toạ lạc tại khu vực thuộc dãy Trường Sơn nằm ở xã Hoà Ninh, Huyện Hòa Vang, cách trung tâm Đà Nẵng khoảng 25km về phía Tây Nam. Toàn bộ quần thể du lịch nghỉ dưỡng nằm trên đỉnh Núi Chúa có độ cao 1489 m so với mực nước biển.',8,'2022-10-11 11:24:22'),(9,'Công viên văn hóa Suối Tiên','Khu Du lịch Văn hóa Suối Tiên là một công viên liên hợp vui chơi giải trí kết hợp truyền thống các yếu tố văn hóa - lịch sử - tâm linh. Tọa lạc tại 120 Xa lộ Hà Nội, Phường Tân Phú, Thành phố Thủ Đức, Thành phố Hồ Chí Minh.',9,'2022-10-11 11:25:23'),(10,'Dinh Độc Lập','Dinh Độc Lập hay Hội trường Thống Nhất là một công trình kiến trúc, tòa nhà ở Thành phố Hồ Chí Minh. Đây từng là nơi ở và làm việc của Tổng thống Việt Nam Cộng hòa. Hiện nay, dinh đã được Chính phủ Việt Nam xếp hạng là di tích quốc gia đặc biệt.',13,'2022-10-18 09:26:52'),(11,'Địa đạo Củ Chi','Địa đạo Củ Chi là một hệ thống phòng thủ trong lòng đất ở huyện Củ Chi, cách Thành phố Hồ Chí Minh 70 km về hướng tây-bắc. Hệ thống này được quân kháng chiến Việt Minh và Mặt trận Dân tộc Giải phóng miền Nam Việt Nam đào trong thời kỳ Chiến tranh Đông Dương và Chiến tranh Việt Nam',18,'2022-10-18 09:34:24'),(12,'Khu triển lãm tranh 3D Artinus','Artinus 3D Art Gallery là bảo tàng mỹ thuật kinh doanh xoay quanh chủ đề vật thể 3 chiều Object và 3D painting xuất hiện lần đầu tiên tại Việt Nam. Đến với Artinus các bạn sẽ được trải nghiệm tham quan và lưu giữ những khoảnh khắc độc đáo. Đắm chìm vào thế giới ảo giác như hội họa, lập thể, nội thất… với từng cung bậc cảm xúc lúc trầm, lúc bổng, lúc sợ hãi và đầy kinh ngạc không thua kém các bảo tàng tranh 3D nổi tiếng trên thế giới.',21,'2022-10-18 09:36:53'),(13,'Công viên nước Đầm Sen','Công viên nước Đầm Sen ra đời từ năm 1998, trở thành điểm đến quen thuộc của người dân địa phương và các tỉnh, thành phía Nam khi đặt chân đến TP.HCM. Bên cạnh khu công viên nước là khu vực công viên văn hóa Đầm Sen (hay còn gọi là Đầm Sen khô) tạo nên một quần thể giải trí lên gần 50 ha với gần 40 trò chơi cho cả nhà.\r\n\r\nMặc dù ra đời đã lâu nhưng đây vẫn là công viên nước giải trí hầu như duy nhất tại trung tâm TP.HCM. Vì vậy mỗi dịp cuối tuần hay vào hè, đây là một trong những điểm \"hot\" khi các gia đình đưa con em đến vui chơi, giải trí. ',26,'2022-10-18 09:45:51');
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travel_meta`
--

LOCK TABLES `travel_meta` WRITE;
/*!40000 ALTER TABLE `travel_meta` DISABLE KEYS */;
INSERT INTO `travel_meta` VALUES (1,1,'step_1','Lên danh sách những việc cần làm','Hãy lên danh sách cụ thể để trả lời các câu hỏi: bạn sẽ ở đâu, bạn có cần phải thay đổi chỗ ở không, bạn sẽ làm gì tại điểm đến… Đây là công đoạn khiến bạn phải suy nghĩ khá nhiều, nhưng vô cùng quan trọng vì nó giúp bạn có cái nhìn tổng quan về chuyến đi.','','2022-10-14 10:41:58'),(2,1,'step_2','Xem xét thời điểm đi','Từ tháng 11 đến tháng 3 là mùa mưa tại Úc, trong khi tại Việt Nam mùa này rơi vào tháng 7 đến tháng 10. Chắc hẳn bạn sẽ không muốn tốn bộn tiền để đi du lịch để rồi cuối cùng chỉ nằm trong khách sạn ngắm mưa.',NULL,'2022-10-18 12:55:55'),(3,1,'step_3','Nên du lịch bụi, hay mua tour?','Mỗi hình thức du lịch sẽ có những điểm thú vị và khó khăn riêng. Nếu đi du lịch tự túc, bạn sẽ phải chuẩn bị khá nhiều nhưng được tự do về thời gian và lịch trình. Ngược lại, đi du lịch theo tour giúp bạn đỡ mất công lên kế hoạch, nhưng sẽ không mấy thú vị đối với những ai thích khám phá.',NULL,'2022-10-18 12:56:12'),(4,1,'step_4','Nơi ở','Càng đặt chỗ ở sớm, bạn càng có giá tốt và nhiều lựa chọn, đặc biệt nếu điểm đến là nơi đông khách du lịch hoặc vào mùa cao điểm.',NULL,'2022-10-18 12:56:32'),(5,1,'step_5','Giữ gìn sức khỏe','Hãy giữ gìn sức khỏe thật tốt trước khi đi du lịch. Đừng thay đổi thói quen tập thể dục mà hãy giữ nguyên những hoạt động yêu thích nhất của bạn như đi bộ, bơi lội, aerobic hay đạp xe… Tuy nhiên, đừng tập quá sức tránh chấn thương hoặc mỏi cơ.',NULL,'2022-10-18 12:56:50'),(6,1,'step_6','Hộ chiếu và thị thực','Nếu muốn du lịch ở nước ngoài, hãy đảm bảo hộ chiếu của bạn còn hạn sử dụng ít nhất sáu tháng. Một số nước còn yêu cầu thị thực du lịch. Thời gian làm thị thực có thể mất vài tuần đến một tháng, tùy vào nơi bạn muốn đến và quy trình xử lý của lãnh sự quán.\r\n\r\nHãy nộp đơn xin thị thực càng sớm càng tốt vì ngoài thời gian để chuẩn bị hồ sơ và chờ kết quả, bạn còn có thể phải đến tận lãnh sự quán để phỏng vấn.',NULL,'2022-10-18 12:57:05'),(7,1,'step_7','Vấn đề y tế','Bạn có gặp vấn đề về sức khỏe không? Bạn đã chuẩn bị đủ thuốc chưa? Những quốc gia khác nhau có các yêu cầu và mức giá khác nhau dành cho dịch vụ y tế. Vì vậy, bạn luôn phải tự chuẩn bị cho mình trước.\r\n\r\nNếu có bệnh đặc biệt, hãy mang theo hồ sơ y tế hoặc toa thuốc có kèm tiếng Anh để sử dụng ở nước ngoài.',NULL,'2022-10-18 12:57:21');
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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travel_post`
--

LOCK TABLES `travel_post` WRITE;
/*!40000 ALTER TABLE `travel_post` DISABLE KEYS */;
INSERT INTO `travel_post` VALUES (1,1,1),(2,2,2),(3,3,3),(4,4,4),(5,5,5),(6,6,6),(7,7,7),(8,8,8),(9,9,9),(16,1,16),(17,2,17),(18,7,18),(19,10,22),(20,11,23),(21,12,24),(22,13,25);
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travel_tag`
--

LOCK TABLES `travel_tag` WRITE;
/*!40000 ALTER TABLE `travel_tag` DISABLE KEYS */;
INSERT INTO `travel_tag` VALUES (1,1,1),(2,2,1),(3,3,1),(4,4,2),(5,5,2),(6,6,3),(7,7,4),(8,8,4),(9,9,4),(10,10,2),(11,11,2),(12,12,4),(13,13,3);
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
  `role` varchar(254) DEFAULT 'USER',
  `created_date` varchar(254) NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','$2a$12$TLhMgl4H7lvbh7NbM8wUA.MWxRr1zFp8.7XSzbrYbOg7vo/DvaBDu','Administrator','0355747814','travel@blog.com','1996-12-20',1,'USER','2022-10-10 13:45:46'),(2,'admin1','$2a$10$JBepecHmdkKPXdev9yvMxeaO82mBKV/f2Y1d1A.VN6rs0TgQc8y7y','Administrator','0355747814','test@mail.com','2022-01-01',0,'USER','2022-10-13 09:47:12.059');
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
  `id_user` int(11) NOT NULL,
  `id_tag` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_tag`
--

LOCK TABLES `user_tag` WRITE;
/*!40000 ALTER TABLE `user_tag` DISABLE KEYS */;
INSERT INTO `user_tag` VALUES (2,1,1);
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

-- Dump completed on 2022-10-18 13:38:35
