﻿-- --------------------------------------------------------
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


-- 테이블 test의 구조를 덤프합니다. country
CREATE TABLE IF NOT EXISTS `country` (
  `country_id` int(11) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(45) NOT NULL,
  PRIMARY KEY (`country_id`)
) ENGINE=InnoDB AUTO_INCREMENT=290 DEFAULT CHARSET=utf8;

-- Dumping data for table test.country: ~103 rows (대략적)
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` (`country_id`, `country_name`) VALUES
	(1, '한국'),
	(2, '미국'),
	(3, '일본'),
	(4, '중국'),
	(5, '독일'),
	(6, '스위스'),
	(7, '북한'),
	(194, '그리스'),
	(195, '네팔'),
	(196, '노르웨이'),
	(197, '뉴질랜드'),
	(198, '덴마크'),
	(199, '러시아'),
	(200, '르완다'),
	(201, '리비아'),
	(202, '마케도니아'),
	(203, '말레이시아'),
	(204, '멕시코'),
	(205, '모로코'),
	(206, '몰디브'),
	(207, '몽골'),
	(208, '방글라데시'),
	(209, '베네수엘라'),
	(210, '벨기에 '),
	(211, '불가리아'),
	(212, '브라질'),
	(213, '브루나이'),
	(214, '사우디아라비아'),
	(215, '소말리아'),
	(216, '수단'),
	(217, '스리랑카'),
	(218, '스웨덴'),
	(219, '스위스'),
	(220, '스페인'),
	(221, '슬로바키아'),
	(222, '슬로베니아'),
	(223, '시리아'),
	(224, '싱가포르'),
	(225, '아랍에미리트'),
	(226, '아르메니아'),
	(227, '아르헨티나'),
	(228, '아이슬란드'),
	(229, '아이티'),
	(230, '아일랜드'),
	(231, '아프카니스탄'),
	(232, '알바니아'),
	(233, '알제리'),
	(234, '에콰도르'),
	(235, '예멘'),
	(236, '오만'),
	(237, '오스트레일리아'),
	(238, '오스트리아'),
	(239, '온두라스'),
	(240, '요르단'),
	(241, '우간다'),
	(242, '우루과이'),
	(243, '우즈베키스탄'),
	(244, '우크라이나'),
	(245, '이라크'),
	(246, '이란'),
	(247, '이스라엘'),
	(248, '이집트'),
	(249, '이탈리아'),
	(250, '인도'),
	(251, '인도네시아'),
	(252, '자메이카'),
	(253, '잠비아'),
	(254, '짐바브웨'),
	(255, '체코'),
	(256, '칠레'),
	(257, '카메룬'),
	(258, '카자흐스탄'),
	(259, '카타르'),
	(260, '캐나다'),
	(261, '케냐'),
	(262, '코모로'),
	(263, '코스타리카'),
	(264, '코트디부아르'),
	(265, '콜롬비아'),
	(266, '쿠바'),
	(267, '쿠웨이트'),
	(268, '크로아티아'),
	(269, '탄자니아'),
	(270, '태국'),
	(271, '터키'),
	(272, '토고'),
	(273, '튀니지'),
	(274, '파나마'),
	(275, '파라과이'),
	(276, '파키스탄'),
	(277, '파푸아뉴기니'),
	(278, '팔레스타인'),
	(279, '페루'),
	(280, '포르투갈'),
	(281, '폴란드'),
	(282, '프랑스'),
	(283, '피지'),
	(284, '핀란드'),
	(285, '필리핀'),
	(286, '헝가리'),
	(287, '라오스'),
	(288, '에티오피아'),
	(289, '엘살바도르');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
