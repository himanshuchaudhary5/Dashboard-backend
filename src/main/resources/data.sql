DROP TABLE IF EXISTS `run_history`;
CREATE TABLE `run_history` (
                               `id` int(11) NOT NULL AUTO_INCREMENT,
                               `environment` varchar(255) DEFAULT NULL,
                               `url` varchar(255) DEFAULT NULL,
                               `duration` varchar(255) DEFAULT NULL,
                               `passed` int(11) DEFAULT NULL,
                               `failed` int(11) DEFAULT NULL,
                               `skipped` int(11) DEFAULT NULL,
                               `status` varchar(255) DEFAULT NULL,
                               `runid` int(11) DEFAULT NULL,
                               `executiondatetime` varchar(45) DEFAULT NULL,
                               `runby` varchar(45) DEFAULT NULL,
                               PRIMARY KEY (`id`)
);

INSERT INTO `run_history` VALUES (1,'QA','www.example.com','01:12:34',0,2,0,'Failed',1,'02-12-2021 12:30:21','himanshu'),
                                 (2,'QA','www.example.com','01:20:43',1,0,0,'Passed',2,'02-13-2021 11:30:21','himanshu');


DROP TABLE IF EXISTS `suite`;

CREATE TABLE `suite` (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `runid` int(11) DEFAULT NULL,
                         `suite_name` varchar(255) DEFAULT NULL,
                         `browser` varchar(255) DEFAULT NULL,
                         `url` varchar(255) DEFAULT NULL,
                         `duration` varchar(255) DEFAULT NULL,
                         `passed` int(11) DEFAULT NULL,
                         `failed` int(11) DEFAULT NULL,
                         `skipped` int(11) DEFAULT NULL,
                         `status` varchar(255) DEFAULT NULL,
                          PRIMARY KEY (`id`)
--                          KEY (`runid`),
--                          CONSTRAINT FOREIGN KEY (`runid`) REFERENCES `run_history` (`id`)
);

INSERT INTO `suite` VALUES (1,1,'Regression','Chrome','www.example.com/dashboard','00:39:12',1,2,0,'Failed'),
                           (2,1,'Smoke','Chrome','www.example.com/smoke','00:40:21',1,0,0,'Failed'),
                           (3,2,'Regression','Chrome','www.example.com/dashboard','00:39:12',2,1,0,'Failed'),
                           (4,2,'Smoke','Chrome','www.example/smoke','00:03:12',0,1,0,'Failed');


DROP TABLE IF EXISTS `module`;

CREATE TABLE `module` (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `suiteid` int(11) DEFAULT NULL,
                          `name` longtext,
                          `details` longtext,
                          `duration` longtext,
                          `passed` int(11) DEFAULT NULL,
                          `failed` int(11) DEFAULT NULL,
                          `skipped` int(11) DEFAULT NULL,
                          `status` longtext,
                          PRIMARY KEY (`id`)
--                           KEY (`suiteid`),
--                           CONSTRAINT FOREIGN KEY (`suiteid`) REFERENCES `suite` (`id`)
);

INSERT INTO `module` VALUES (1,1,'Login','Username:myuser, Password:*******','00:05:30',3,0,0,'Passed'),
                            (2,1,'Sign Up','Username:mytestuser,Password:*******,Mail:mailnator@mail.com,Dob:21/12/2121','00:11:30',0,2,0,'Failed'),
                            (3,1,'Forget Password','Username:myuser,NewPassword:*******','00:06:00',0,1,0,'Failed'),
                            (4,2,'Verify Smoke Points','NA','00:12:11',2,0,0,'Passed');

DROP TABLE IF EXISTS `test_case`;
CREATE TABLE `test_case` (
                             `Id` int(11) NOT NULL AUTO_INCREMENT,
                             `moduleid` int(11) DEFAULT NULL,
                             `testcaseid` longtext,
                             `name` longtext,
                             `details` longtext,
                             `passed` varchar(45) DEFAULT NULL,
                             `failed` varchar(45) DEFAULT NULL,
                             `skipped` varchar(45) DEFAULT NULL,
                             `status` longtext,
                             PRIMARY KEY (`Id`)
--                              KEY (`moduleid`),
--                              CONSTRAINT FOREIGN KEY (`moduleid`) REFERENCES `module` (`id`)
);

INSERT INTO `test_case` VALUES (1,1,'AUT-100','Login with valid credentials','User:username,Password:*****','6','0','0','Passed'),
                               (2,1,'AUT-101','Login with invalid credentials','User:random,Passowrd:*****','5','0','0','Passed'),
                               (3,1,'AUT-102','Login without password','User:username','3','0','0','Passed'),
                               (4,2,'AUT-103','Signup with valid credentials','User:username,Password:*****,Mail:mailenator@mail.com','3','1','0','Failed'),
                               (5,2,'AUT-104','Signup with empty username',NULL,'2','2','0','Failed'),
                               (6,3,'AUT-105','Forget password with valid credentials','Username:username,Dob:21/11/1900','3','1','0','Failed'),
                               (7,4,'AUT-106','Verify Smoke URL','Urls:[url1,url2,url3]','3','0','0','Passed'),(8,4,'AUT-107','Verify Smoke Pages',NULL,'2','0','0','Passed');


DROP TABLE IF EXISTS `test_steps`;

CREATE TABLE `test_steps` (
                              `id` int(11) NOT NULL AUTO_INCREMENT,
                              `testcaseid` int(11) DEFAULT NULL,
                              `stepid` int(11) DEFAULT NULL,
                              `description` longtext,
                              `screenshot` longblob,
                              `status` text,
                              PRIMARY KEY (`id`)
--                               KEY  (`testcaseid`)
--                               CONSTRAINT FOREIGN KEY (`testcaseid`) REFERENCES `test_case` (`Id`)
);


INSERT INTO `test_steps` VALUES (1,1,1,'Open URL',NULL,'Passed'),
                                (2,1,2,'Verify Login',NULL,'Passed'),
                                (3,1,3,'Enter user',NULL,'Passed'),
                                (4,1,4,'Enter password',NULL,'Passed'),
                                (5,1,5,'Click Login',NULL,'Passed'),
                                (6,1,6,'Verify',NULL,'Passed'),
                                (7,2,1,'Open URL',NULL,'Passed'),
                                (8,2,2,'Verify Login',NULL,'Passed'),
                                (9,2,3,'Enter invalid user',NULL,'Passed'),
                                (10,2,4,'Enter password',NULL,'Passed'),
                                (11,2,5,'Verify',NULL,'Passed'),
                                (12,3,1,'Open URL',NULL,'Passed'),
                                (13,3,2,'Enter user',NULL,'Passed'),
                                (14,3,3,'Verify ',NULL,'Passed'),
                                (15,4,1,'Open URL',NULL,'Passed'),
                                (16,4,2,'Enter Details',NULL,'Passed'),
                                (17,4,3,'Click On Signup',NULL,'Passed'),
                                (18,4,4,'Verify',NULL,'Failed'),
                                (19,5,1,'Open URL',NULL,'Passed'),
                                (20,5,2,'Enter details',NULL,'Passed'),
                                (21,5,3,'Verify should no accept empty value in usernme',NULL,'Failed'),
                                (22,5,4,'Verify',NULL,'Failed'),
                                (23,6,1,'Open URL',NULL,'Passed'),
                                (24,6,2,'Enter forget password details',NULL,'Passed'),
                                (25,6,3,'Click on forget',NULL,'Passed'),
                                (26,6,4,'Verify',NULL,'Failed'),
                                (27,7,1,'Open url1',NULL,'Passed'),
                                (28,7,2,'Open url2',NULL,'Passed'),
                                (29,7,3,'Open url3',NULL,'Passed'),
                                (30,8,1,'Page 1',NULL,'Passed'),
                                (31,8,2,'Page 2',NULL,'Passed');
