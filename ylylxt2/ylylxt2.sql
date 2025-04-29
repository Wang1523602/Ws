/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : localhost:3306
 Source Schema         : ylylxt2

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 28/04/2025 16:42:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '配置文件' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of config
-- ----------------------------
INSERT INTO `config` VALUES (1, 'swiper1', 'file/swiperPicture1.jpg');
INSERT INTO `config` VALUES (2, 'swiper2', 'file/swiperPicture2.jpg');
INSERT INTO `config` VALUES (3, 'swiper3', 'file/swiperPicture3.jpg');

-- ----------------------------
-- Table structure for fuwuleixing
-- ----------------------------
DROP TABLE IF EXISTS `fuwuleixing`;
CREATE TABLE `fuwuleixing`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fuwuleixing` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '服务类型',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `fuwuleixing`(`fuwuleixing`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '服务类型' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of fuwuleixing
-- ----------------------------
INSERT INTO `fuwuleixing` VALUES (41, '2025-04-02 19:14:18', '助餐服务');
INSERT INTO `fuwuleixing` VALUES (42, '2025-04-02 19:14:18', '助浴服务');
INSERT INTO `fuwuleixing` VALUES (43, '2025-04-02 19:14:18', '家政服务');
INSERT INTO `fuwuleixing` VALUES (44, '2025-04-02 19:14:18', '理疗护理服务');
INSERT INTO `fuwuleixing` VALUES (45, '2025-04-02 19:14:18', '出行服务');
INSERT INTO `fuwuleixing` VALUES (46, '2024-04-05 19:14:18', '送饭服务');

-- ----------------------------
-- Table structure for hugong
-- ----------------------------
DROP TABLE IF EXISTS `hugong`;
CREATE TABLE `hugong`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `hugongzhanghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '护工账号',
  `mima` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `hugongxingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '护工姓名',
  `touxiang` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '头像',
  `xingbie` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `shoujihaoma` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `laorenzhanghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '老人账号',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `hugongzhanghao`(`hugongzhanghao`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1745626569779 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '护工' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of hugong
-- ----------------------------
INSERT INTO `hugong` VALUES (1745480213039, '2025-04-24 15:36:53', '荷塘月色', '123456', '刘双', 'file/1745580415436.png', '女', '13663122581', '花开富贵');
INSERT INTO `hugong` VALUES (1745487477184, '2025-04-24 17:37:57', 'hugong', '123456', '江航', 'file/1745580402859.png', '男', '15260387562', 'laoren');
INSERT INTO `hugong` VALUES (1745626190500, '2025-04-26 08:09:50', 'hugong1', '123456', '刘坤', 'file/1745626177160.png', '男', '16685275621', 'laoren1');
INSERT INTO `hugong` VALUES (1745626327895, '2025-04-26 08:12:07', 'hugong2', '123456', '航欣', 'file/1745626307160.png', '女', '15236087526', '');
INSERT INTO `hugong` VALUES (1745626569778, '2025-04-26 08:16:09', 'hugong3', '123456', '柳柳', 'file/1745626552864.png', '女', '18338146279', 'laoren3');

-- ----------------------------
-- Table structure for jingshenweiji
-- ----------------------------
DROP TABLE IF EXISTS `jingshenweiji`;
CREATE TABLE `jingshenweiji`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `biaoti` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `neirong` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `liaotianshijian` datetime NULL DEFAULT NULL COMMENT '聊天时间',
  `laorenzhanghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '老人账号',
  `laorenxingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '老人姓名',
  `hugongzhanghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '护工账号',
  `glyhf` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '回复内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1745822306439 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '精神慰籍' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of jingshenweiji
-- ----------------------------
INSERT INTO `jingshenweiji` VALUES (1745480415180, '2025-04-24 15:40:14', '感到孤独', '女儿出差时间久了，一人在家有点孤独，需要陪伴', '2025-04-24 15:39:49', '花开富贵', '刘江', '荷塘月色', '好的');
INSERT INTO `jingshenweiji` VALUES (1745822306438, '2025-04-28 14:38:25', '心情不好', '因为老伴走了心情不好', '2025-04-28 14:37:46', 'laoren1', '刘能', 'hugong', '马上安排您的专属护工对您服务');

-- ----------------------------
-- Table structure for laoren
-- ----------------------------
DROP TABLE IF EXISTS `laoren`;
CREATE TABLE `laoren`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `laorenzhanghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '老人账号',
  `mima` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `laorenxingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '老人姓名',
  `touxiang` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '头像',
  `xingbie` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `shoujihaoma` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `nianling` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年龄',
  `jiatingzhuzhi` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭住址',
  `hugongzhanghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '护工账号',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `laorenzhanghao`(`laorenzhanghao`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1745626513962 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '老人' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of laoren
-- ----------------------------
INSERT INTO `laoren` VALUES (1745477849587, '2025-04-24 14:57:29', '花开富贵', '123456', '刘江', 'file/1745580372362.png', '男', '13937765210', '81', '河南省南阳市张衡路中景门国贸7号楼一单元201', '荷塘月色');
INSERT INTO `laoren` VALUES (1745487560292, '2025-04-24 17:39:20', 'laoren', '123456', '江龙', 'file/1745580325726.png', '男', '13525869721', '79', '河南省南阳市张衡路中景门国贸6号楼一单元301', 'hugong');
INSERT INTO `laoren` VALUES (1745626146704, '2025-04-26 08:09:06', 'laoren1', '123456', '刘能', 'file/1745626109645.png', '男', '13936754621', '81', '河南省南阳市张衡路中景门国贸6号楼一单元102', 'hugong');
INSERT INTO `laoren` VALUES (1745626269156, '2025-04-26 08:11:09', 'laoren2', '123456', '航凤', 'file/1745626220487.png', '女', '16652465324', '65', '河南省南阳市张衡路中景门国贸五号楼一单元302', 'hugong2');
INSERT INTO `laoren` VALUES (1745626513961, '2025-04-26 08:15:13', 'laoren3', '123456', '柳宇', 'file/1745626440607.png', '男', '15834872165', '81', '河南省南阳市张衡路中景门国贸八号楼二单元103', 'hugong3');

-- ----------------------------
-- Table structure for laorenyiliaoshenqing
-- ----------------------------
DROP TABLE IF EXISTS `laorenyiliaoshenqing`;
CREATE TABLE `laorenyiliaoshenqing`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yiliaoxiangmu` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医疗项目',
  `yiliaoneirong` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '医疗内容',
  `yiliaoleixing` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医疗类型',
  `shenqingshijian` datetime NULL DEFAULT NULL COMMENT '申请时间',
  `laorenzhanghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '老人账号',
  `laorenxingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '老人姓名',
  `hugongzhanghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '护工账号',
  `sfsh` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否审核',
  `glyhf` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '回复内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1745822327609 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '老人医疗申请' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of laorenyiliaoshenqing
-- ----------------------------
INSERT INTO `laorenyiliaoshenqing` VALUES (1743821958581, '2025-04-05 10:59:17', '腰部护理', '', '医疗类型1', '2025-04-05 10:59:02', '老人账号1', '柏枝', '护工账号1', '否', '.');
INSERT INTO `laorenyiliaoshenqing` VALUES (1745480463115, '2025-04-24 15:41:02', '推拿', '周末去公园穿的鞋子不太舒服，腿有点痛', '中式推拿', '2025-04-24 15:40:52', '花开富贵', '刘江', '荷塘月色', '是', '.');
INSERT INTO `laorenyiliaoshenqing` VALUES (1745822327608, '2025-04-28 14:38:47', '推拿', '', '中式推拿', '2025-04-28 14:38:31', 'laoren1', '刘能', 'hugong', '是', '马上安排您的专属护工对您服务');

-- ----------------------------
-- Table structure for leixing
-- ----------------------------
DROP TABLE IF EXISTS `leixing`;
CREATE TABLE `leixing`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `leixing` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `leixing`(`leixing`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 127 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '类型' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of leixing
-- ----------------------------
INSERT INTO `leixing` VALUES (121, '2024-04-05 19:14:19', '艺术创作');
INSERT INTO `leixing` VALUES (122, '2024-04-05 19:14:19', '文化学习');
INSERT INTO `leixing` VALUES (123, '2024-04-05 19:14:19', '音乐舞蹈');
INSERT INTO `leixing` VALUES (124, '2024-04-05 19:14:19', '体育健身');
INSERT INTO `leixing` VALUES (125, '2024-04-05 19:14:19', '棋牌游戏');
INSERT INTO `leixing` VALUES (126, '2024-04-05 19:14:19', '组队唠嗑');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `menujson` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '菜单',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '2024-04-05 19:14:19', '[{\"backMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-goods\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"老人\",\"menuJump\":\"列表\",\"tableName\":\"laoren\"},{\"appFrontIcon\":\"cuIcon-paint\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"护工\",\"menuJump\":\"列表\",\"tableName\":\"hugong\"}],\"fontClass\":\"icon-user4\",\"menu\":\"用户管理\",\"unicode\":\"&#xef9a;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-vipcard\",\"buttons\":[\"查看\",\"删除\",\"审核\"],\"menu\":\"精神慰籍\",\"menuJump\":\"列表\",\"tableName\":\"jingshenweiji\"}],\"fontClass\":\"icon-common10\",\"menu\":\"精神支持管理\",\"unicode\":\"&#xedd1;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-addressbook\",\"buttons\":[\"查看\",\"删除\",\"审核\"],\"menu\":\"老人医疗申请\",\"menuJump\":\"列表\",\"tableName\":\"laorenyiliaoshenqing\"},{\"appFrontIcon\":\"cuIcon-vip\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"医疗类型\",\"menuJump\":\"列表\",\"tableName\":\"yiliaoleixing\"}],\"fontClass\":\"icon-common33\",\"menu\":\"老人医疗管理\",\"unicode\":\"&#xee6a;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-album\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"服务类型\",\"menuJump\":\"列表\",\"tableName\":\"fuwuleixing\"},{\"appFrontIcon\":\"cuIcon-cardboard\",\"buttons\":[\"查看\",\"删除\",\"审核\"],\"menu\":\"生活服务申请\",\"menuJump\":\"列表\",\"tableName\":\"shenghuofuwushenqing\"}],\"fontClass\":\"icon-common26\",\"menu\":\"生活服务管理\",\"unicode\":\"&#xee2b;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-vip\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"类型\",\"menuJump\":\"列表\",\"tableName\":\"leixing\"},{\"appFrontIcon\":\"cuIcon-goodsnew\",\"buttons\":[\"查看\",\"删除\",\"审核\"],\"menu\":\"文化娱乐申请\",\"menuJump\":\"列表\",\"tableName\":\"wenhuayuleshenqing\"}],\"fontClass\":\"icon-common33\",\"menu\":\"文化娱乐管理\",\"unicode\":\"&#xee6a;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-news\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"社区新闻\",\"menuJump\":\"列表\",\"tableName\":\"shequxinwen\"}],\"fontClass\":\"icon-common6\",\"menu\":\"社区新闻管理\",\"unicode\":\"&#xedad;\"}],\"frontMenu\":[],\"hasBackLogin\":\"是\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"否\",\"hasFrontRegister\":\"否\",\"roleName\":\"管理员\",\"tableName\":\"users\"},{\"backMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-vipcard\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"精神慰籍\",\"menuJump\":\"列表\",\"tableName\":\"jingshenweiji\"}],\"fontClass\":\"icon-common10\",\"menu\":\"精神支持管理\",\"unicode\":\"&#xedd1;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-addressbook\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"老人医疗申请\",\"menuJump\":\"列表\",\"tableName\":\"laorenyiliaoshenqing\"}],\"fontClass\":\"icon-common33\",\"menu\":\"老人医疗管理\",\"unicode\":\"&#xee6a;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-cardboard\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"生活服务申请\",\"menuJump\":\"列表\",\"tableName\":\"shenghuofuwushenqing\"}],\"fontClass\":\"icon-common26\",\"menu\":\"生活服务管理\",\"unicode\":\"&#xee2b;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-goodsnew\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"文化娱乐申请\",\"menuJump\":\"列表\",\"tableName\":\"wenhuayuleshenqing\"}],\"fontClass\":\"icon-common33\",\"menu\":\"文化娱乐管理\",\"unicode\":\"&#xee6a;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-news\",\"buttons\":[\"查看\",\"删除\"],\"menu\":\"社区新闻\",\"menuJump\":\"列表\",\"tableName\":\"shequxinwen\"}],\"fontClass\":\"icon-common6\",\"menu\":\"社区新闻管理\",\"unicode\":\"&#xedad;\"}],\"frontMenu\":[],\"hasBackLogin\":\"是\",\"hasBackRegister\":\"是\",\"hasFrontLogin\":\"否\",\"hasFrontRegister\":\"否\",\"roleName\":\"老人\",\"tableName\":\"laoren\"},{\"backMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-vipcard\",\"buttons\":[\"查看\",\"删除\"],\"menu\":\"精神慰籍\",\"menuJump\":\"列表\",\"tableName\":\"jingshenweiji\"}],\"fontClass\":\"icon-common10\",\"menu\":\"精神支持管理\",\"unicode\":\"&#xedd1;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-addressbook\",\"buttons\":[\"查看\",\"删除\"],\"menu\":\"老人医疗申请\",\"menuJump\":\"列表\",\"tableName\":\"laorenyiliaoshenqing\"}],\"fontClass\":\"icon-common33\",\"menu\":\"老人医疗管理\",\"unicode\":\"&#xee6a;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-cardboard\",\"buttons\":[\"查看\",\"删除\"],\"menu\":\"生活服务申请\",\"menuJump\":\"列表\",\"tableName\":\"shenghuofuwushenqing\"}],\"fontClass\":\"icon-common26\",\"menu\":\"生活服务管理\",\"unicode\":\"&#xee2b;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-goodsnew\",\"buttons\":[\"查看\",\"删除\"],\"menu\":\"文化娱乐申请\",\"menuJump\":\"列表\",\"tableName\":\"wenhuayuleshenqing\"}],\"fontClass\":\"icon-common33\",\"menu\":\"文化娱乐管理\",\"unicode\":\"&#xee6a;\"}],\"frontMenu\":[],\"hasBackLogin\":\"是\",\"hasBackRegister\":\"是\",\"hasFrontLogin\":\"否\",\"hasFrontRegister\":\"否\",\"roleName\":\"护工\",\"tableName\":\"hugong\"}]');

-- ----------------------------
-- Table structure for shenghuofuwushenqing
-- ----------------------------
DROP TABLE IF EXISTS `shenghuofuwushenqing`;
CREATE TABLE `shenghuofuwushenqing`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fuwumingcheng` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '服务名称',
  `fuwuleixing` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '服务类型',
  `fuwujianjie` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '服务简介',
  `fuwuxiangqing` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '服务详情',
  `storeupnum` int(11) NULL DEFAULT NULL COMMENT '收藏数量',
  `fuwushijian` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务时间',
  `laorenzhanghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '老人账号',
  `laorenxingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '老人姓名',
  `hugongzhanghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '护工账号',
  `sfsh` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否审核',
  `glyhf` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '回复内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1745822361376 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '生活服务申请' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of shenghuofuwushenqing
-- ----------------------------
INSERT INTO `shenghuofuwushenqing` VALUES (1745480542413, '2025-04-24 15:42:21', '洗澡', '助浴服务', '', '<h1 style=\"text-align: start;\">儿女出差时间久，自己一人在家无法洗澡，晚上申请洗澡，需要护工帮忙</h1>', 0, '2025-4-28', '花开富贵', '刘江', '荷塘月色', '待审核', '');
INSERT INTO `shenghuofuwushenqing` VALUES (1745822361375, '2025-04-28 14:39:20', '洗澡', '助浴服务', '', '', NULL, '2025-4-28 18：30', 'laoren1', '刘能', 'hugong', '是', '马上安排您的专属护工对您服务');

-- ----------------------------
-- Table structure for shequxinwen
-- ----------------------------
DROP TABLE IF EXISTS `shequxinwen`;
CREATE TABLE `shequxinwen`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `biaoti` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `fengmian` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '封面',
  `jianjie` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '简介',
  `neirong` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `faburiqi` date NULL DEFAULT NULL COMMENT '发布日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1745487375891 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '社区新闻' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of shequxinwen
-- ----------------------------
INSERT INTO `shequxinwen` VALUES (1745481720877, '2025-04-24 16:02:00', '健康社区“免疫行动”', 'file/1745630074118.jpg', '', '<p style=\"text-align: start;\">“健康中国家，疫苗护万家——健康社区‘免疫行动’促进计划”近日在京启动。该项目旨在通过深化社区医防融合、推广优秀案例及科普指导，提升中老年人群对带状疱疹、流感和肺炎等感染性疾病的疫苗接种率，构建全龄化免疫屏障。</p><p style=\"text-align: start;\">随着我国老龄化进程加速，老年人多病共存现象突出。数据显示，全国约78%的老年人患有一种以上慢性病，60岁以上慢性病患者达2.2亿人。中国疾控中心免疫规划中心主任尹遵栋表示，疫苗是预防传染病最经济、最有效的手段，对中老年人而言，接种流感、肺炎球菌和带状疱疹疫苗可显著降低发病风险。</p><p style=\"text-align: start;\">“慢性病患者感染性疾病风险更高。”北京大学人民医院心血管内科主任医师孙宁玲举例，心血管疾病患者罹患带状疱疹的风险比常人增加39%，且发病后短期内心梗、卒中风险上升。中国医药卫生文化协会疫苗与健康分会会长冯录召说，接种流感、肺炎球菌、带状疱疹等疫苗不仅能减少多病共存风险，还可能降低心血管事件发生风险。研究发现，接种带状疱疹疫苗甚至可以降低患痴呆症的风险。但当前慢性病患者对疫苗接种仍存在认知不足和犹豫现象。</p><p style=\"text-align: start;\">为提升接种可及性，多地已开展创新实践。冯录召介绍，部分医疗机构设立“成人预防接种门诊”，实现评估、接种一体化；全国十余省市试点“疫苗处方”，推动被动咨询转向主动干预；电子处方流转、AI健康助手等数字化应用进一步优化服务生态。</p><p style=\"text-align: start;\">启动仪式还发布了《成人预防“保典”》，涵盖疫苗接种时程建议和十问十答指南，为公众提供科学接种参考。该项目将通过案例征集和经验推广，助力形成覆盖全国的成人免疫服务新范式。</p>', '2025-04-24');
INSERT INTO `shequxinwen` VALUES (1745487375890, '2025-04-24 17:36:15', '科学防癌，健康生活', 'file/1745630043780.jpg', '', '<p><span style=\"color: rgb(51, 51, 51); background-color: rgb(255, 255, 255); font-size: 16px;\">为提升社区居民对癌症的认知，增强防癌意识，倡导健康生活方式，2025年4月21日XX社区开展了以“科学防癌，健康生活”为主题的宣传活动。此次活动内容丰富、形式多样，获得了居民的广泛关注与积极参与，成效显著。 活动当天，现场气氛热烈。通过社区电子屏、悬挂条幅、张贴宣传画、发放宣传页等多种形式向居民宣传常见癌症的成因、早期症状及预防方法，重点宣传肺癌、乳腺癌、结直肠癌等在日常生活中的高发因素，比如长期吸烟与肺癌的关联，不合理饮食结构对结直肠癌发病的影响等。居民们积极参与，对正确认识癌症、健康生活方式等知识点掌握得更加牢固，深刻认识到癌症并非不可战胜，也为居民带来了信心和勇气 。 本次活动极大地提升了居民的防癌意识，部分居民表示对癌症防治知识有了更深入了解，认识到癌症是可防可治的，今后会更加关注自身健康状况。同时，居民们对健康生活方式有了全新认知，纷纷表示会在饮食上增加蔬菜水果摄入、减少高油高盐食物，加强日常锻炼，保持良好作息，积极戒烟限酒。未来，社区会将防癌宣传作为长期工作，定期开展类似活动，持续为居民健康保驾护航。</span></p>', '2025-04-24');

-- ----------------------------
-- Table structure for storeup
-- ----------------------------
DROP TABLE IF EXISTS `storeup`;
CREATE TABLE `storeup`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NULL DEFAULT NULL COMMENT 'refid',
  `tablename` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表名',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `picture` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片',
  `type` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型(1:收藏,21:赞,22:踩,31:竞拍参与,41:关注)',
  `inteltype` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '推荐类型',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '我的收藏' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of storeup
-- ----------------------------

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `tablename` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表名',
  `role` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色',
  `token` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'token表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of token
-- ----------------------------
INSERT INTO `token` VALUES (1, 1, 'admin', 'users', '管理员', '3b6xhzwl66d1epmnlbb3ctvqx5b8ncp1', '2024-04-05 19:16:51', '2025-04-28 16:52:31');
INSERT INTO `token` VALUES (2, 31, '老人账号1', 'laoren', '老人', 'bbqmj0yd2gnxlgjgy3c0yw98tqsi69sq', '2025-03-30 21:18:54', '2025-04-18 19:59:50');
INSERT INTO `token` VALUES (3, 1743340844206, '1009887141', 'laoren', '老人', 'thybvirs627qnbnc1ojiqwi8ro47b9re', '2025-03-30 21:20:56', '2025-03-30 22:20:56');
INSERT INTO `token` VALUES (4, 71, '护工账号1', 'hugong', '护工', '3abyu0td0927jq7tjyj6ekqrpmjtnyys', '2025-04-10 17:00:30', '2025-04-13 23:55:19');
INSERT INTO `token` VALUES (5, 1745477849587, '花开富贵', 'laoren', '老人', 'nt8ilvlxbb2cytansapp99vv9hen1scp', '2025-04-24 15:27:40', '2025-04-28 15:30:19');
INSERT INTO `token` VALUES (6, 1745480213039, '荷塘月色', 'hugong', '护工', 'jsvxjzgi0m89gzbx12asmtgdaekawx07', '2025-04-24 15:37:15', '2025-04-28 16:48:32');
INSERT INTO `token` VALUES (7, 1745487560292, 'laoren', 'laoren', '老人', '7249awqs96vgsmyfw9mk3brgoqwbau8q', '2025-04-24 17:39:35', '2025-04-24 22:54:48');
INSERT INTO `token` VALUES (8, 1745487477184, 'hugong', 'hugong', '护工', '21pi4bnj2u7n2be4dhz5b65oa4paidak', '2025-04-24 17:40:14', '2025-04-28 15:41:28');
INSERT INTO `token` VALUES (9, 1745626513961, 'laoren3', 'laoren', '老人', '5cj83wv6hqyv8e8b0nvoo9fl9d11ac1i', '2025-04-26 08:21:09', '2025-04-26 10:40:16');
INSERT INTO `token` VALUES (10, 1745626146704, 'laoren1', 'laoren', '老人', 'dgjorkknuogxr4wyyqg8fq2knr2tp8r0', '2025-04-28 14:36:56', '2025-04-28 15:36:56');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `username` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `role` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, '2024-04-05 19:14:19', 'admin', '123456', '管理员');

-- ----------------------------
-- Table structure for wenhuayuleshenqing
-- ----------------------------
DROP TABLE IF EXISTS `wenhuayuleshenqing`;
CREATE TABLE `wenhuayuleshenqing`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `biaoti` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `leixing` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `jianjie` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '简介',
  `neirong` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `shenqingshijian` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请时间',
  `laorenzhanghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '老人账号',
  `laorenxingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '老人姓名',
  `hugongzhanghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '护工账号',
  `sfsh` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否审核',
  `glyhf` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '回复内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1745822376461 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文化娱乐申请' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of wenhuayuleshenqing
-- ----------------------------
INSERT INTO `wenhuayuleshenqing` VALUES (1745480609631, '2025-04-24 15:43:28', '图书馆看书', '文化学习', '', '<p style=\"text-align: start;\">下午需要人陪伴去图书馆看书</p>', '2025-4-28 16：23', '花开富贵', '刘江', '荷塘月色', '待审核', '');
INSERT INTO `wenhuayuleshenqing` VALUES (1745822376460, '2025-04-28 14:39:36', '下棋', '棋牌游戏', '', '', '', 'laoren1', '刘能', 'hugong', '是', '马上安排您的专属护工对您服务');

-- ----------------------------
-- Table structure for yiliaoleixing
-- ----------------------------
DROP TABLE IF EXISTS `yiliaoleixing`;
CREATE TABLE `yiliaoleixing`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yiliaoleixing` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '医疗类型',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `yiliaoleixing`(`yiliaoleixing`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1745732282113 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '医疗类型' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of yiliaoleixing
-- ----------------------------
INSERT INTO `yiliaoleixing` VALUES (111, '2025-04-02 19:14:19', '中式推拿');
INSERT INTO `yiliaoleixing` VALUES (112, '2025-04-02 19:14:19', '营养咨询及指导');
INSERT INTO `yiliaoleixing` VALUES (113, '2025-04-02 19:14:19', '口腔医疗');
INSERT INTO `yiliaoleixing` VALUES (114, '2025-04-02 19:14:19', '西医临床');
INSERT INTO `yiliaoleixing` VALUES (115, '2025-04-02 19:14:19', '眼科医疗');
INSERT INTO `yiliaoleixing` VALUES (116, '2025-04-02 19:14:19', '居家护理服务');
INSERT INTO `yiliaoleixing` VALUES (117, '2025-04-26 08:07:18', '社区卫生服务');
INSERT INTO `yiliaoleixing` VALUES (1745732282112, '2025-04-27 13:38:01', '体检');

SET FOREIGN_KEY_CHECKS = 1;
