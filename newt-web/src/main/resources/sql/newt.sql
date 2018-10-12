# Host: localhost  (Version 5.7.21)
# Date: 2018-10-12 17:21:26
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
  `OPERATION_RESULT` int(11) NOT NULL DEFAULT '0' COMMENT '操作结果（0：失败，1：成功）',
  `OPERATION_PICK_NAME` varchar(255) NOT NULL DEFAULT '' COMMENT '操作用户名称',
  `GMT_CREATE` varchar(255) NOT NULL DEFAULT '' COMMENT '记录创建时间',
  `GMT_MODIFIED` varchar(255) NOT NULL DEFAULT '' COMMENT '记录修改时间',
  `OPERATION_MSG` varchar(510) NOT NULL DEFAULT '' COMMENT '消息（操作信息）',
  `OPERATION_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8 COMMENT='日志信息表'
#
# Data for table "log_info"
#

INSERT INTO `log_info` VALUES (82,11,'/login/getToken','127.0.0.1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-10 14:23:54'),(83,11,'/login/getToken','127.0.0.1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-10 14:29:08'),(84,11,'/login/getToken','127.0.0.1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-10 14:30:42'),(85,11,'/login/getToken','127.0.0.1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-10 15:05:30'),(86,11,'/login/getToken','127.0.0.1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-10 15:06:31'),(87,11,'/login/getToken','127.0.0.1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-10 15:06:58'),(88,11,'/login/getToken','127.0.0.1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-10 15:07:27'),(89,11,'/login/getToken','127.0.0.1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-10 15:10:11'),(90,11,'/login/getToken','127.0.0.1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-10 15:10:39'),(91,11,'/login/getToken','127.0.0.1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-10 15:12:32'),(92,11,'/login/getToken','127.0.0.1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-10 15:15:34'),(93,11,'/login/getToken','127.0.0.1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-10 15:15:58'),(94,11,'/login/getToken','127.0.0.1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-10 15:16:34'),(95,11,'/login/getToken','127.0.0.1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-10 15:17:26'),(96,11,'/login/getToken','127.0.0.1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-10 15:17:52'),(97,11,'/login/getToken','127.0.0.1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-10 15:52:11'),(98,11,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-10 16:47:05'),(99,11,'/login/getToken','127.0.0.1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0','2018-10-11 15:03:35'),(100,11,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-12 08:58:43'),(101,11,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-12 10:04:22'),(102,11,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-12 10:13:53'),(103,11,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-12 10:33:44'),(104,11,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-12 11:04:05');

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
  `OLD_LOGIN_TIME` timestamp NULL DEFAULT NULL COMMENT '上一次登录时间',
  `PICK_NAME` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '昵称',
  `ROLE_ID` int(11) DEFAULT '0' COMMENT '角色ID',
  `SALT` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '盐值',
  `SIGNATURE` varchar(255) CHARACTER SET utf8 DEFAULT '你很高冷哦，签名都没有' COMMENT '个性签名',
  `STATE` int(11) DEFAULT '1' COMMENT '用户状态',
  `UPDATE_TIME` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `USER_ICON` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户头像',
  `FAVICON` varchar(255) CHARACTER SET utf8 DEFAULT '' COMMENT 'favicon.ico',
  `USER_PHONE` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户手机号',
  `USER_PWD` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户密码',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1
#
# Data for table "user"
#

INSERT INTO `user` VALUES (11,'2018-10-10 11:14:10','1105544546@qq.com','0:0:0:0:0:0:0:1',29,'2018-10-12 11:04:05','0:0:0:0:0:0:0:1','2018-10-12 10:33:44','newt',1001,'48759','你很高冷哦，签名都没有',1,NULL,'http://www.newt.fun/favicon.ico','http://www.newt.fun/favicon.ico','15611700291','673CB9A1C34037BA50C6404C023276FE');

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
# Structure for table "user_menu"
#

CREATE TABLE `user_menu` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MENU_DESC` varchar(255) DEFAULT NULL COMMENT '功能描述',
  `MENU_NAME` varchar(100) DEFAULT NULL COMMENT '菜单名称',
  `MENU_PID` int(11) NOT NULL DEFAULT '0' COMMENT '上级菜单ID',
  `MENU_GROUP_ID` int(11) DEFAULT '1000' COMMENT '菜单分组ID',
  `SYS_DEFAULT` varchar(5) NOT NULL DEFAULT '0' COMMENT '系统菜单（0：不是，1：是）',
  `MENU_ICON` varchar(100) DEFAULT NULL COMMENT '菜单图标',
  `MENU_ORDER` int(11) NOT NULL DEFAULT '999' COMMENT '排序',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `ENABLE` int(11) NOT NULL DEFAULT '1' COMMENT '开启状态（0：禁用，1：开启）',
  `URL` varchar(100) NOT NULL DEFAULT '/' COMMENT '菜单url',
  `COMPONENT` varchar(255) DEFAULT NULL COMMENT '组件',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='系统菜单'
#
# Data for table "user_menu"
#

INSERT INTO `user_menu` VALUES (1,'功能概览','仪表盘',0,1000,'1','icon-icon_yulan',999,'2018-10-10 11:53:12','2018-10-12 17:15:59',1,'/','/dashboard/index'),(2,'用户管理','用户管理',0,1000,'1','icon-icon_zhanghao',999,'2018-10-10 14:05:17','2018-10-12 16:33:56',1,'/user/index','/user/index');

#
# Structure for table "user_role"
#

CREATE TABLE `user_role` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE` varchar(32) NOT NULL DEFAULT '筑基' COMMENT '角色:(筑基、开光、融合、心动、金丹、元婴、出窍、分神、合体、洞虚、大乘、渡劫)',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=1007 DEFAULT CHARSET=utf8 COMMENT='用户角色表'
#
# Data for table "user_role"
#

INSERT INTO `user_role` VALUES (1000,'凝气'),(1001,'筑基'),(1002,'结丹'),(1003,'元婴'),(1004,'化神'),(1005,'婴变'),(1006,'问鼎');

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

