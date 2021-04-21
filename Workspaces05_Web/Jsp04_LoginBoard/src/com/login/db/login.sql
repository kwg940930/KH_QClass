DROP SEQUENCE MYMEMBERSEQ;
DROP TABLE MYMEMBER;

CREATE SEQUENCE MYMEMBERSEQ;

CREATE TABLE MYMEMBER(
	MYNO NUMBER NOT NULL,
	MYID VARCHAR2(500) NOT NULL,
	MYPW VARCHAR2(500) NOT NULL,
	MYNAME VARCHAR2(500) NOT NULL,
	MYADDR VARCHAR2(2000) NOT NULL,
	MYPHONE VARCHAR2(18) NOT NULL,
	MYEMAIL VARCHAR2(100) NOT NULL,
	MYENABLED VARCHAR2(2) NOT NULL,
	MYROLE VARCHAR2(100) NOT NULL,
	CONSTRAINT MYMEMBER_MYNO_PK PRIMARY KEY (MYNO),
	CONSTRAINT MYMEMBER_MYID_UQ UNIQUE (MYID),
	CONSTRAINT MYMEMBER_MYPHONE_UQ UNIQUE (MYPHONE),
	CONSTRAINT MYMEMBER_MYEMAIL_UQ UNIQUE (MYEMAIL),
	CONSTRAINT MYMEMBER_MYENABLED_CHK CHECK(MYENABLED IN ('Y','N'))
);


INSERT INTO MYMEMBER
VALUES(MYMEMBERSEQ.NEXTVAL, 'admin', 'admin1234', '강씨네', '서울특별시 동대문구 답십리2동',
		'010-1234-5678', 'admin@admin.com', 'Y', 'ADMIN');
		
INSERT INTO MYMEMBER
VALUES(MYMEMBERSEQ.NEXTVAL, 'cine', 'cine1234', '강씨네', '서울특별시 동대문구 답십리2동',
		'010-0000-0000', 'cine@cine.com', 'Y', 'ADMIN');
		
INSERT INTO MYMEMBER
VALUES(MYMEMBERSEQ.NEXTVAL, 'cine02', 'cine1234', '강씨네', '서울특별시 동대문구 답십리2동',
		'010-0000-1111', 'cine02@cine.com', 'Y', 'USER');

SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE
FROM MYMEMBER
ORDER BY MYNO DESC;