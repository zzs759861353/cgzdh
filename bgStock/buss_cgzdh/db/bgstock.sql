/*
Navicat MySQL Data Transfer

Source Server         : cgzdh
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : bgstock

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-02-26 17:32:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for broker
-- ----------------------------
DROP TABLE IF EXISTS `broker`;
CREATE TABLE `broker` (
  `id` varchar(32) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `ip` varchar(32) DEFAULT NULL,
  `port` int(11) DEFAULT NULL,
  `yyb` varchar(32) DEFAULT NULL,
  `version` varchar(32) DEFAULT NULL,
  `txPwd` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of broker
-- ----------------------------
INSERT INTO `broker` VALUES ('1', '东莞证券', '27.223.20.162', '7708', '0', '6.66', null);
INSERT INTO `broker` VALUES ('2', '安信证券', '211.139.150.61', '7708', '0', '7.11', null);

-- ----------------------------
-- Table structure for t_account_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_account_detail`;
CREATE TABLE `t_account_detail` (
  `id` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `org_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `money` double(255,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_account_detail
-- ----------------------------
INSERT INTO `t_account_detail` VALUES ('acce98331a43407fbce311d45ec89bae', '8a93d8cd617894ba016178ace7550003', '8a93d8cd617894ba016178ace7550003', '管理员', 'admin', '2018-02-09 11:42:31', '800');
INSERT INTO `t_account_detail` VALUES ('acce98331a43407fbce311d45ec89baa', '8a93d8cd617894ba016178ace7550003', '8a93d8cd617894ba016178ace7550003', '管理员', 'admin', '2018-02-10 11:42:31', '800');
INSERT INTO `t_account_detail` VALUES ('ec1bf52e12a549d7b51b5aff9b49bb07', '8a93d8cd617894ba016178ace7550003', '8a93d8cd617894ba016178ace7550003', '???', 'admin', '2018-02-14 10:28:59', '100');
INSERT INTO `t_account_detail` VALUES ('24a72a999a634f02a8ce1b079bb866ba', '8a93d8cd617894ba016178ace7550003', '8a93d8cd617894ba016178ace7550003', '???', 'admin', '2018-02-14 10:30:35', '100');
INSERT INTO `t_account_detail` VALUES ('7f14bf596652440c9e87c0c6bf6b6462', '8a93d8cd617894ba016178ace7550003', '8a93d8cd617894ba016178ace7550003', '???', 'admin', '2018-02-14 10:33:21', '100');
INSERT INTO `t_account_detail` VALUES ('20df1105e6a54a39a65a7b04277092f8', '8a93d8cd617894ba016178ace7550003', '8a93d8cd617894ba016178ace7550003', '???', 'admin', '2018-02-14 10:35:03', '100');
INSERT INTO `t_account_detail` VALUES ('557e3a7e981d4627a6670dafeca09bb6', '8a93d8cd617894ba016178ace7550003', '8a93d8cd617894ba016178ace7550003', '222', 'admin', '2018-02-14 10:38:33', '100');
INSERT INTO `t_account_detail` VALUES ('c7ad768f7a764e7e8713ad7ebbd86210', '8a93d8cd617894ba016178ace7550003', '8a93d8cd617894ba016178ace7550003', '2222', 'admin', '2018-02-14 10:45:33', '100');
INSERT INTO `t_account_detail` VALUES ('129466c2044a4e7fb96ffde029bbff9f', '8a93d8cd617894ba016178ace7550003', '8a93d8cd617894ba016178ace7550003', '???', 'admin', '2018-01-10 10:47:09', '100');
INSERT INTO `t_account_detail` VALUES ('60ae888972ac40ff91bc95f38b28b50f', '8a93d8cd617894ba016178ace7550003', '8a93d8cd617894ba016178ace7550003', '444', 'admin', '2018-02-14 10:47:33', '100');
INSERT INTO `t_account_detail` VALUES ('7c8788ff4ba84a48b6336766059217c3', '8a93d8cd617894ba016178ace7550003', '8a93d8cd617894ba016178ace7550003', '444', '444', '2018-02-14 10:48:18', '100');
INSERT INTO `t_account_detail` VALUES ('d72a106cdfcf4e0e99f1d0692cd36bd0', '8a93d8cd617894ba016178ace7550003', '8a93d8cd617894ba016178ace7550003', '???', 'admin', '2018-01-09 10:57:46', '100');
INSERT INTO `t_account_detail` VALUES ('d16e113ec11f43179868c409e2687cff', '8a93d8cd617894ba016178ace7550003', '8a93d8cd617894ba016178ace7550003', '555', '555', '2018-02-14 11:00:10', '100');
INSERT INTO `t_account_detail` VALUES ('2d18fc7dc27645f5a073c3e1f0c312e2', '8a93d8cd617894ba016178ace7550003', '8a93d8cd617894ba016178ace7550003', '???', 'admin', '2018-02-14 11:06:20', '100');
INSERT INTO `t_account_detail` VALUES ('d011ecd39b0e4e32aa0bd43c5c0bfbc4', '8a93d8cd617894ba016178ace7550003', '8a93d8cd617894ba016178ace7550003', '???', 'admin', '2018-02-14 11:08:08', '100');
INSERT INTO `t_account_detail` VALUES ('8570ef8d238f4c56825435da9509e083', '8a93d8cd617894ba016178ace7550003', '8a93d8cd617894ba016178ace7550003', '???', 'admin', '2018-02-14 11:12:06', '100');
INSERT INTO `t_account_detail` VALUES ('36ab48b2c33f4edaa310332c5df91b12', '8a93d8cd617894ba016178ace7550003', '8a93d8cd617894ba016178ace7550003', '???', 'admin', '2018-02-14 11:44:05', '100');
INSERT INTO `t_account_detail` VALUES ('430622934b2f421488de827408ceba65', '8a93d8cd617894ba016178ace7550003', '8a93d8cd617894ba016178ace7550003', '???', 'admin', '2018-02-14 12:23:13', '900');

-- ----------------------------
-- Table structure for t_agent
-- ----------------------------
DROP TABLE IF EXISTS `t_agent`;
CREATE TABLE `t_agent` (
  `id` varchar(11) NOT NULL,
  `agentType` int(45) NOT NULL DEFAULT '2' COMMENT '1 个人代理商 2 企业代理商  ',
  `agreementFilePath` varchar(45) DEFAULT NULL COMMENT '协议文件位置',
  `certificate` varchar(450) DEFAULT NULL COMMENT '证件照片  json格式  ',
  `bankAccount` varchar(45) DEFAULT NULL COMMENT '对公账户   个人银行卡',
  `bankType` varchar(45) DEFAULT NULL COMMENT '银行类型',
  `bankName` varchar(45) DEFAULT NULL COMMENT '银行名称',
  `status` int(255) DEFAULT '1' COMMENT '0 无效 1有效',
  `name` varchar(255) DEFAULT NULL,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modityDate` date DEFAULT '2000-01-01',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='代理商类型';

-- ----------------------------
-- Records of t_agent
-- ----------------------------

-- ----------------------------
-- Table structure for t_agent_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_agent_resource`;
CREATE TABLE `t_agent_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `agent_id` int(11) NOT NULL,
  `resource_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_agent_resource
-- ----------------------------
INSERT INTO `t_agent_resource` VALUES ('1', '2', '123456');

-- ----------------------------
-- Table structure for t_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_resource`;
CREATE TABLE `t_resource` (
  `id` varchar(45) NOT NULL,
  `app_id` varchar(45) DEFAULT NULL,
  `available` varchar(45) DEFAULT NULL,
  `descript` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `order_num` varchar(45) DEFAULT NULL,
  `parent_id` varchar(45) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `url` varchar(45) DEFAULT NULL,
  `icon_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_resource
-- ----------------------------
INSERT INTO `t_resource` VALUES ('24503A24A1113FE3E053DD81A8C02912', null, null, null, null, null, null, '策略', null, '/business/tactics', '/static/style/images/ljyjtx.png');
INSERT INTO `t_resource` VALUES ('24503A24A1113FE3E053DD81A8C02913', null, null, null, null, null, null, '业务', null, '/business/auto', '/static/style/images/yw.png');
INSERT INTO `t_resource` VALUES ('94b8a00f665747b09547ac0866788279', null, null, null, null, null, null, '测试', null, '/business/cs', '/static/style/images/cs.png');
INSERT INTO `t_resource` VALUES ('94b8a00f665747b09547ac0866788280', '', '', '', '', '', '', '个人信息', '', '/business/xx', '/static/style/images/jcxxx.png');
INSERT INTO `t_resource` VALUES ('94b8a00f665747b09547ac0866788281', '', '', '', '', '', '', '记录', '', '/business/zd', '/static/style/images/jcxxx.png');
INSERT INTO `t_resource` VALUES ('94b8a00f665747b09547ac0866788282', '', '', '', '', '', '', '充值', '', '/business/cz', '/static/style/images/jcxxx.png');
INSERT INTO `t_resource` VALUES ('94b8a00f665747b09547ac0866788283', '', '', '', '', '', '', '企业', '', '/business/dlzd', '/static/style/images/jcxxx.png');
INSERT INTO `t_resource` VALUES ('94b8a00f665747b09547ac0866788284', '', '', '', '', '', '', '代理', '', '/business/dlxx', '/static/style/images/jcxxx.png');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(32) NOT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `password` varchar(145) DEFAULT NULL,
  `account_locked_reason` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '0 不可用  1可用 2账户被锁定 ',
  `head_img_url` varchar(45) DEFAULT NULL,
  `id_number` varchar(45) DEFAULT NULL COMMENT '证件号码',
  `name` varchar(255) DEFAULT NULL,
  `id_type` int(11) DEFAULT NULL COMMENT '1 身份证  2 军官证',
  `mobile` varchar(45) DEFAULT NULL COMMENT '手机号码',
  `org_id` varchar(11) DEFAULT '0' COMMENT '所属代理商  0代表平台',
  `salt` varchar(45) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_active_date` date DEFAULT NULL COMMENT 'experid  最后一次激活时间',
  `validity_date` date DEFAULT NULL COMMENT '有效期',
  `amount` timestamp NULL DEFAULT NULL COMMENT '账户余额',
  `recomender` varchar(255) DEFAULT NULL,
  `userType` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1000001459082007', 'hhh', '$2a$10$0jqEL4qriTjsNdX/K2ZCWu2w15hZt5AwJuLclI4G8XzN86kfjKbx.', null, '0', null, null, '???', '0', null, null, null, null, '2018-02-24 10:34:19', null, null, '2018-02-24 10:34:19', null, '0');
INSERT INTO `t_user` VALUES ('402880e561c1e9a40161c1fb76f30000', 'aaa', '$2a$10$lZNjAOGpvuDKX7aQS0Jkw.bTklLGZqNAr6vTttTmc.cIddK2EC9TW', null, '0', null, null, 'zzz', '0', null, null, '7d918f9244fc48278dce2751ac708511', null, '2018-02-23 17:25:38', null, null, '2018-02-23 17:25:38', null, '1');
INSERT INTO `t_user` VALUES ('402880e761c5a1180161c5a1d4ba0000', 'ddd', '$2a$10$QhWBdAyrLvhPd2OORoECK.4RnVBtfmgeLGGbeG503WW9QvA/fy.wq', null, '0', null, null, 'ddd', '0', null, null, '1000001421818926', null, '2018-02-24 10:26:13', null, null, '2018-02-24 10:26:13', null, '2');
INSERT INTO `t_user` VALUES ('402880e761c5a1180161c5a431bd0001', 'fff', '$2a$10$dTLbPqbyVkQEeGqDeD1V.O2O4W2I0uYrtnGHVcj/kl5cj01nOZLvK', null, '0', null, null, 'fff', '0', null, null, '1000001426281719', null, '2018-02-24 10:28:48', null, null, '2018-02-24 10:28:48', null, '1');
INSERT INTO `t_user` VALUES ('402880e761c5a1180161c5a5d1b40002', 'ggg', '$2a$10$Tts1erCCuni/tYEpFbbRXe4BeBMqaUrqVAn6pzS3qhnqPTJWVVqFu', null, '0', null, null, 'ggg', '0', null, null, '1000001788520378', null, '2018-02-24 10:30:34', null, null, '2018-02-24 10:30:34', null, '0');
INSERT INTO `t_user` VALUES ('402880e8619244170161926f029d0000', 'b', '$2a$10$Y89ypXURA2xSMWy8rJLFsOiOY7XgUFjdfjXjINeDpfIwdY6Nm9IwW', null, '0', null, null, '???', '0', null, null, 'a5a5d470a5a94733893cfd323ddf56c4', null, '2018-02-14 11:50:04', null, null, '2018-02-14 11:50:04', null, null);
INSERT INTO `t_user` VALUES ('8a93d8cd617894ba016178ace7550003', 'admin', '$2a$10$ap9tfSlMYx7bYbvrKMtaU.rMKtd0zgPMG0fgwPmkvHrlfwGvsKdzK', 'string', '0', 'string', 'string', '管理员', '0', 'string', 'string', '56e7c789686f4d7e8a5b37e7d51186ed', null, '2018-02-23 17:44:29', null, '2018-02-09', '2019-06-09 11:06:21', '??', '0');
INSERT INTO `t_user` VALUES ('8a93d8cd6183b97b01618408480b0002', 'a', '$2a$10$Ii39qirbO4acJE5l1NR5Gu/UfLh3TIEQzSftBxTLdvSfx/Cy0vIEy', null, '0', null, null, 'zzz', '0', null, null, 'b36226cb14fd439792477f6b6da47d3e', null, '2018-02-11 16:43:11', null, null, '2018-02-11 16:43:11', null, null);
