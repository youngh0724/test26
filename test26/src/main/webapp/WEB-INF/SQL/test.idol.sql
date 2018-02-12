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
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test`;


-- 테이블 test의 구조를 덤프합니다. idol
CREATE TABLE IF NOT EXISTS `idol` (
  `idol_id` int(11) NOT NULL AUTO_INCREMENT,
  `idol_name` varchar(45) NOT NULL,
  PRIMARY KEY (`idol_id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

-- Dumping data for table test.idol: ~64 rows (대략적)
/*!40000 ALTER TABLE `idol` DISABLE KEYS */;
INSERT INTO `idol` (`idol_id`, `idol_name`) VALUES
	(1, '소녀시대'),
	(2, '레드벨벳'),
	(3, '트와이스'),
	(4, '씨엔블루'),
	(5, '제국의아이들'),
	(6, '인피니트'),
	(7, '틴탑'),
	(8, '씨스타'),
	(9, '미쓰에이'),
	(10, '걸스데이'),
	(11, '나인뮤지스'),
	(12, '보이프렌드'),
	(13, '블락비'),
	(14, '달샤벳'),
	(15, '파이브돌스'),
	(16, '치치'),
	(17, '브레이브걸스'),
	(18, '에이핑크'),
	(19, '스텔라'),
	(20, '뉴이스트'),
	(21, '비투비'),
	(22, '엑소'),
	(23, '빅스'),
	(24, '빅스타'),
	(25, '스피카'),
	(26, '헬로비너스'),
	(27, '갱키즈'),
	(28, '에이오에이'),
	(29, '크레용팝'),
	(30, '스카프'),
	(31, '히스토리'),
	(32, '방탄소년단'),
	(33, '소년공화국'),
	(34, '레이디스코드'),
	(35, '베스티'),
	(36, '갓세븐'),
	(37, '위너'),
	(38, '유니크'),
	(39, '베리굿'),
	(40, '단발머리'),
	(41, '마마무'),
	(42, '라붐'),
	(43, '러블리즈'),
	(44, '소나무'),
	(45, '몬스타엑스'),
	(46, '세븐틴'),
	(47, '아이콘'),
	(48, '데이식스'),
	(49, '업텐션'),
	(50, '여자친구'),
	(51, '오마이걸'),
	(52, '에이프릴'),
	(53, '아이아'),
	(54, '크나큰'),
	(55, '우주소녀'),
	(56, '구구단'),
	(57, '블랙핑크'),
	(58, '아이오아이'),
	(59, '언니쓰'),
	(60, '워너원'),
	(61, '아이즈'),
	(62, '루비'),
	(63, '프리스틴'),
	(64, '위키미키');
/*!40000 ALTER TABLE `idol` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
