-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        5.5.32 - MySQL Community Server (GPL)
-- 서버 OS:                        Win32
-- HeidiSQL 버전:                  8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- test 의 데이터베이스 구조 덤핑
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `test`;


-- 테이블 test의 구조를 덤프합니다. movie
CREATE TABLE IF NOT EXISTS `movie` (
  `movie_id` int(10) NOT NULL AUTO_INCREMENT,
  `movie_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`movie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- Dumping data for table test.movie: ~43 rows (대략적)
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` (`movie_id`, `movie_name`) VALUES
	(9, '타이타닉'),
	(10, '집으로'),
	(11, '위대한 개츠비'),
	(12, '월드워Z'),
	(13, '쿵푸허슬'),
	(14, '염력'),
	(15, '부산행'),
	(16, '킹콩'),
	(17, '어벤져스'),
	(18, '아이언맨'),
	(19, '토르'),
	(20, '스파이더맨'),
	(21, '슈퍼맨'),
	(22, '배트맨'),
	(23, '닌자거북이'),
	(24, '진주만'),
	(25, '아메리칸스나이퍼'),
	(26, '라이언일병구하기'),
	(27, '엽문'),
	(28, '신데렐라맨'),
	(29, '포레스트검프'),
	(30, '굿윌헌팅'),
	(31, '파이트클럽'),
	(32, '나비효과'),
	(33, '인터스텔라'),
	(34, '라스트사무라이'),
	(35, '미션임파서블'),
	(36, '그것만이내세상'),
	(37, '조선명탐정'),
	(38, '코코'),
	(39, '라라랜드'),
	(40, '아이덴티티'),
	(41, '엑소시스트'),
	(42, '우리형'),
	(43, '매드맥스'),
	(45, '라푼젤'),
	(46, '겨울왕국'),
	(47, '반지의제왕'),
	(48, '해리포터'),
	(49, '소림축구'),
	(50, '뮬란'),
	(51, '인셉션'),
	(52, '메멘토');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
