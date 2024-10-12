/*
 Navicat Premium Data Transfer

 Source Server         : demo
 Source Server Type    : MySQL
 Source Server Version : 50717 (5.7.17-log)
 Source Host           : localhost:3306
 Source Schema         : demo_wwt

 Target Server Type    : MySQL
 Target Server Version : 50717 (5.7.17-log)
 File Encoding         : 65001

 Date: 12/10/2024 10:53:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `ID` int(11) NOT NULL,
  `CATEGORY_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin;

-- ----------------------------
-- Records of category
-- ----------------------------
BEGIN;
INSERT INTO `category` (`ID`, `CATEGORY_NAME`) VALUES (1, '果茶'), (2, '奶茶'), (3, '咖啡'), (4, '冰激凌'), (5, '纯味原茶'), (6, '芝士奶盖'), (7, '清乳系列'), (8, '当季新品');
COMMIT;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `PASSWORD` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `PHONE` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `ADDRESS` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin;

-- ----------------------------
-- Records of employee
-- ----------------------------
BEGIN;
INSERT INTO `employee` (`ID`, `USER_NAME`, `PASSWORD`, `PHONE`, `ADDRESS`) VALUES (1, 'admin', '123456', '13467865587', '冰岛'), (2, '托尔1', '123456', '15678900989', '香格里拉'), (4, '乔瑟夫', '123456', '14767856777', '纽约');
COMMIT;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) NULL DEFAULT NULL,
  `USER_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `STATUS` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '订单状态，已完成/派送中/未派送',
  `PHONE` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `ADDRESS` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `ORDER_TIME` datetime NULL DEFAULT NULL,
  `CHECKOUT_TIME` datetime NULL DEFAULT NULL,
  `MONEY` decimal(10, 2) NULL DEFAULT NULL,
  `PAYMENT_METHOD` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 227172869 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin;

-- ----------------------------
-- Records of orders
-- ----------------------------
BEGIN;
INSERT INTO `orders` (`ID`, `USER_ID`, `USER_NAME`, `STATUS`, `PHONE`, `ADDRESS`, `ORDER_TIME`, `CHECKOUT_TIME`, `MONEY`, `PAYMENT_METHOD`) VALUES (30902243, 1, '康娜', '未支付', '13675876689', '东京涩谷110号', '2024-10-11 22:31:01', NULL, 4.00, NULL), (36826537, 1, '康娜', '未支付', '13675876689', '东京涩谷110号', '2024-10-12 00:04:23', NULL, 18.00, NULL), (37905649, 1, '康娜', '未支付', '13675876689', '东京涩谷110号', '2024-10-11 22:30:47', NULL, 4.00, NULL), (54004197, 1, '康娜', '未支付', '14567894563', '东京', '2024-10-10 22:27:18', NULL, 16.00, NULL), (58392180, 1, '康娜', '未支付', '14567894563', '东京', '2024-10-11 09:47:06', NULL, 26.00, NULL), (82638524, 1, '康娜', '未支付', '14567894563', '东京', '2024-10-11 10:38:21', NULL, 4.00, NULL), (85810819, 1, '康娜', '未支付', '14567894563', '东京', '2024-10-10 22:06:18', NULL, 16.00, NULL), (88375981, 1, '康娜', '已完成', '14567894563', '东京', '2024-10-11 10:38:48', '2024-10-11 10:39:09', 4.00, '支付宝'), (96553182, 1, '康娜', '未支付', '14567894563', '东京', '2024-10-11 00:00:18', NULL, 16.00, NULL), (119201225, 1, '康娜', '未支付', '14567894563', '东京', '2024-10-11 09:46:42', NULL, 26.00, NULL), (124284436, 1, '康娜', '未支付', '14567894563', '东京', '2024-10-11 00:00:36', NULL, 16.00, NULL), (167787427, 1, '康娜', '未支付', '14567894563', '东京', '2024-10-11 00:00:18', NULL, 16.00, NULL), (176168895, 1, '康娜', '未支付', '14567894563', '东京', '2024-10-11 00:02:37', NULL, 22.00, NULL), (176632573, 1, '康娜', '未支付', NULL, NULL, '2024-10-10 21:59:24', NULL, 16.00, NULL), (196171785, 1, '康娜', '未支付', '14567894563', '东京', '2024-10-10 22:53:56', NULL, 16.00, NULL), (227172868, 1, '康娜', '未支付', '14567894563', '东京', '2024-10-10 23:33:09', NULL, 16.00, NULL);
COMMIT;

-- ----------------------------
-- Table structure for shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) NULL DEFAULT NULL,
  `TEA_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `PRICE` decimal(10, 2) NULL DEFAULT NULL,
  `TEMPLATE` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `SUGAR_DEGREE` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `ADD_MATERIAL` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `IMAGE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin;

-- ----------------------------
-- Records of shopping_cart
-- ----------------------------
BEGIN;
INSERT INTO `shopping_cart` (`ID`, `USER_ID`, `TEA_NAME`, `PRICE`, `TEMPLATE`, `SUGAR_DEGREE`, `ADD_MATERIAL`, `IMAGE`) VALUES (41, 1, '柠檬水', 4.00, '正常冰', '正常糖', '椰果', 'ace68a2.jpg'), (42, 1, '草莓啵啵', 8.00, '正常冰', '三分糖', '鸡蛋布丁', '048539b.jpg'), (43, 1, '巧克力冰激凌', 6.00, '正常冰', '七分糖', '鸡蛋布丁', '8923e1f.jpg');
COMMIT;

-- ----------------------------
-- Table structure for tea
-- ----------------------------
DROP TABLE IF EXISTS `tea`;
CREATE TABLE `tea`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `TEA_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `PRICE` decimal(10, 2) NULL DEFAULT NULL,
  `DESCRIPTION` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `IMAGE` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `CATEGORY_ID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `tea_name`(`TEA_NAME`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 158 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin;

-- ----------------------------
-- Records of tea
-- ----------------------------
BEGIN;
INSERT INTO `tea` (`id`, `TEA_NAME`, `PRICE`, `DESCRIPTION`, `IMAGE`, `CATEGORY_ID`) VALUES (1, '柠檬水', 4.00, '性价比之王', 'ace68a2.jpg', 1), (2, '满杯百香果', 6.00, '满杯百果香', '687c80c.jpg', 1), (24, '杨枝甘露', 10.00, '全新升级，加量不加价', '6c7ee2c.jpg', 7), (25, '棒打鲜橙', 7.00, '夏日解暑神器', '4f58aed.jpg', 1), (26, '草莓啵啵', 8.00, '奶香草莓+脆爽啵啵', '048539b.jpg', 1), (149, '珍珠奶茶', 6.00, '香香甜甜有嚼劲', '03c16d5.jpg', 2), (150, '西瓜椰椰', 10.00, '冰爽西瓜，清凉一夏', '9197965.jpg', 1), (151, '冰激凌双拼', 8.00, '芒果草莓双拼', '479781e.jpg', 4), (152, '巧克力冰激凌', 6.00, '纵享丝滑', '8923e1f.jpg', 4), (153, '生椰拿铁', 12.00, '清新椰香+浓郁咖啡', '36fe0f5.jpg', 3), (154, '鸡蛋布丁奶茶', 12.00, '鸡蛋布丁+醇香奶茶', '32f1bb3.jpg', 2), (155, '红提奶盖', 15.00, '芝士奶盖+红提', 'b26b9d5.jpg', 5), (156, '乌龙茶', 8.00, '醇香乌龙茶', 'd8ebee6.jpg', 6), (157, '茉莉奶绿', 10.00, '好一朵美丽的茉莉花', 'ad68a5e.jpg', 0);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `ID` int(11) NOT NULL,
  `USER_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `PASSWORD` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `PHONE` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `ADDRESS` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`ID`, `USER_NAME`, `PASSWORD`, `PHONE`, `ADDRESS`) VALUES (1, '康娜', '123456', '13675876689', '东京涩谷110号');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
