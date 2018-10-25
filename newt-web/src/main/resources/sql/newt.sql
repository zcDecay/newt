# Host: localhost  (Version 5.7.21)
# Date: 2018-10-25 17:23:29
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
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COMMENT='日志信息表'
#
# Data for table "log_info"
#

INSERT INTO `log_info` VALUES (1,11,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-18 10:45:34'),(2,11,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-18 11:42:24'),(3,11,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-18 16:13:08'),(4,11,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-19 13:07:31'),(5,11,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-19 13:17:06'),(6,11,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-19 14:52:44'),(7,11,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-19 15:01:44'),(8,17,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-19 18:21:29'),(9,17,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-19 18:23:36'),(10,18,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-19 18:24:20'),(11,18,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-19 18:26:43'),(12,18,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-19 18:28:37'),(13,18,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-19 18:28:49'),(14,18,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-19 18:29:24'),(15,18,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-19 18:31:34'),(16,18,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-19 18:32:24'),(17,18,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-19 18:34:06'),(18,18,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-22 09:08:59'),(19,18,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36','2018-10-22 11:23:37'),(20,27,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36','2018-10-23 13:37:45'),(21,27,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36','2018-10-23 13:38:10'),(22,28,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36','2018-10-23 13:42:23'),(23,28,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36','2018-10-23 13:42:41'),(24,29,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36','2018-10-23 14:10:27'),(25,29,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36','2018-10-23 14:10:45'),(26,29,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36','2018-10-23 14:10:59'),(27,29,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36','2018-10-24 09:17:40'),(28,29,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36','2018-10-24 09:17:58'),(29,29,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36','2018-10-24 09:19:53'),(30,29,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36','2018-10-24 09:20:46'),(31,29,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36','2018-10-24 09:22:10'),(32,29,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36','2018-10-24 09:22:21'),(33,29,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36','2018-10-24 09:23:29'),(34,29,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36','2018-10-25 09:45:35'),(35,29,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36','2018-10-25 10:34:38'),(36,29,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36','2018-10-25 10:34:59'),(37,29,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36','2018-10-25 10:35:03'),(38,29,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36','2018-10-25 10:35:54'),(39,29,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36','2018-10-25 10:36:44'),(40,29,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36','2018-10-25 10:37:36'),(41,29,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36','2018-10-25 10:38:44'),(42,29,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36','2018-10-25 15:18:05'),(43,29,'/login/getToken','0:0:0:0:0:0:0:1',1,1,'newt','','','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36','2018-10-25 15:19:13');

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
  `ROLE_ID` int(11) DEFAULT '1001' COMMENT '角色ID',
  `SALT` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '盐值',
  `SIGNATURE` varchar(255) CHARACTER SET utf8 DEFAULT '你很高冷哦，签名都没有' COMMENT '个性签名',
  `STATE` int(11) DEFAULT '1' COMMENT '用户状态',
  `UPDATE_TIME` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `USER_ICON` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户头像',
  `FAVICON` varchar(255) CHARACTER SET utf8 DEFAULT '' COMMENT 'favicon.ico',
  `USER_PHONE` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户手机号',
  `USER_PWD` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户密码',
  `CAUSE` varchar(255) CHARACTER SET utf8 DEFAULT '正常' COMMENT '禁封/解封原因',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=30 DEFAULT CHARSET=latin1
#
# Data for table "user"
#

INSERT INTO `user` VALUES (29,'2018-10-23 14:10:26','11@qq.com','0:0:0:0:0:0:0:1',22,'2018-10-25 15:19:13','0:0:0:0:0:0:0:1','2018-10-25 15:18:05','newt',1007,'62157','你很高冷哦，签名都没有,hahahah',1,'2018-10-25 14:52:20','http://www.newt.fun/favicon.ico','http://www.newt.fun/favicon.ico','11111111111','D122306A42E6D01DFAC4D5B4ED33C98C','正常');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='系统菜单'
#
# Data for table "user_menu"
#

INSERT INTO `user_menu` VALUES (2,'管理员权限','用户管理',4,1007,'1','icon-icon_zhanghao',2,'2018-10-10 14:05:17','2018-10-23 15:25:28',1,'/admin/user/index','/admin/user/index'),(3,'管理员权限','菜单管理',4,1007,'1','icon-fenzuguanli',1,'2018-10-23 14:17:47','2018-10-23 15:24:02',1,'/admin/menu/index','/admin/menu/index'),(4,'管理员','我是管理员',0,1007,'1','icon-yunyingguanli',999,'2018-10-24 09:21:48','2018-10-25 14:48:13',1,'/','/layout/index');

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

