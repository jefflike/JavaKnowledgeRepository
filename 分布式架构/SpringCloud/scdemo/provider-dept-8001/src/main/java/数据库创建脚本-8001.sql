DROP DATABASE IF EXISTS "cloudDB01" ;
CREATE DATABASE cloudDB01 CHARACTER SET UTF8 ;
USE cloudDB01 ;
CREATE TABLE dept (
	deptno		BIGINT		AUTO_INCREMENT ,
	dname		VARCHAR(50) ,
	db_source			VARCHAR(50) ,
	CONSTRAINT pk_deptno PRIMARY KEY(deptno)
) ;
INSERT INTO dept(dname,db_source) VALUES ('开发部',database()) ;
INSERT INTO dept(dname,db_source) VALUES ('财务部',database()) ;
INSERT INTO dept(dname,db_source) VALUES ('市场部',database()) ;
INSERT INTO dept(dname,db_source) VALUES ('后勤部',database()) ;
INSERT INTO dept(dname,db_source) VALUES ('公关部',database()) ;