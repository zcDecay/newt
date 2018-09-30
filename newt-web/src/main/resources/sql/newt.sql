# Host: localhost  (Version 5.7.21)
# Date: 2018-09-30 11:35:16
# Generator: MySQL-Front 6.1  (Build 1.1)


#
# Structure for table "log_info"
#

CREATE TABLE `log_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `USER_ID` int(11) NOT NULL DEFAULT '0' COMMENT '操作用户',
  `OPERATION_FUNCTION` varchar(255) NOT NULL DEFAULT '' COMMENT '操作接口',
  `IP` varchar(255) NOT NULL DEFAULT '' COMMENT 'IP地址',
  `OPERATION_TYPE` int(11) NOT NULL DEFAULT '0' COMMENT '操作类型(1:登录，2：新增，3：删除，4：修改，5：查看)',
  `OPERATION_RESULT` int(11) NOT NULL DEFAULT '0' COMMENT '操作结果（1：成功，2：失败）',
  `OPERATION_PICK_NAME` varchar(255) NOT NULL DEFAULT '' COMMENT '操作用户名称',
  `GMT_CREATE` varchar(255) NOT NULL DEFAULT '' COMMENT '记录创建时间',
  `GMT_MODIFIED` varchar(255) NOT NULL DEFAULT '' COMMENT '记录修改时间',
  `OPERATION_MSG` varchar(510) NOT NULL DEFAULT '' COMMENT '消息（操作信息）',
  `OPERATION_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='日志信息表'
#
# Data for table "log_info"
#

INSERT INTO `log_info` VALUES (1,1,'/login/getToken','127.0.0.1',1,1,'','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-09-30 10:56:51'),(2,1,'/login/getToken','127.0.0.1',1,1,'','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-09-30 11:03:19'),(3,1,'/login/getToken','127.0.0.1',1,1,'','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-09-30 11:08:21');

#
# Structure for table "user"
#

CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建用户时间',
  `EMAIL` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '邮件',
  `LOGIN_IP` varchar(30) CHARACTER SET utf8 DEFAULT '127.0.0.1' COMMENT '登录IP',
  `LOGIN_NUM` int(11) DEFAULT '0' COMMENT '登录次数',
  `LOGIN_TIME` datetime DEFAULT NULL COMMENT '登录时间',
  `OLD_LOGIN_IP` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '上一次登录IP',
  `OLD_LOGIN_TIME` datetime DEFAULT NULL COMMENT '上一次登录时间',
  `PICK_NAME` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '昵称',
  `ROLE_ID` int(11) DEFAULT '0' COMMENT '角色ID',
  `SALT` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '盐值',
  `SIGNATURE` varchar(255) CHARACTER SET utf8 DEFAULT '你很高冷哦，签名都没有' COMMENT '个性签名',
  `STATE` int(11) DEFAULT '1' COMMENT '用户状态',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `USER_ICON` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户头像',
  `FAVICON` varchar(255) CHARACTER SET utf8 DEFAULT '' COMMENT 'favicon.ico',
  `USER_PHONE` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户手机号',
  `USER_PWD` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户密码',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1
#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'2018-09-18 14:05:43',NULL,'127.0.0.1',3,'2018-09-30 11:08:21','127.0.0.1',NULL,'admin',NULL,NULL,NULL,1,NULL,NULL,'',NULL,'533070E1CD4CED9F3D663688F1A31EA8');

#
# Structure for table "user_home_link"
#

CREATE TABLE `user_home_link` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(10) NOT NULL DEFAULT '0' COMMENT '用户id',
  `LINK` varchar(255) DEFAULT NULL COMMENT '链接',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='主页展示连接'
#
# Data for table "user_home_link"
#


#
# Structure for table "user_role"
#

CREATE TABLE `user_role` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE` varchar(32) NOT NULL DEFAULT '筑基' COMMENT '角色:(筑基、开光、融合、心动、金丹、元婴、出窍、分神、合体、洞虚、大乘、渡劫)',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表'
#
# Data for table "user_role"
#


#
# Structure for table "user_state"
#

CREATE TABLE `user_state` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1
#
# Data for table "user_state"
#

