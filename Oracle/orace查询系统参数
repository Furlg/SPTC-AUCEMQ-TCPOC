
----查询指定表名--
	select * from user_tables where TABLE_NAME ='ACT_CUSTOM_AGENT';

--查询所有表空间
	SELECT * FROM DBA_TABLESPACES; 

--查询所有用户
	SELECT * FROM dba_users;

--查询存储过程
	select * from user_source;

--查询所有序列
	SELECT * FROM dba_sequences;

--查询序列当前值
	SELECT SEQ_MTL_4.CURRVAL FROM DUAL;

--查询序列下一个值
	SELECT SEQ_MTL_4.NEXTVAL FROM DUAL;
	
--查询表中金额列非金额格式脏数据
SELECT PROD_STANDARD_AU,PROD_STANDARD_AG,PROD_NUM FROM t9_prod_offline_sale t
												WHERE t.prod_standard_au IS NOT NULL
													AND trim(translate(rtrim(ltrim(t.prod_standard_au)), '#0123456789.', '#')) IS NOT NULL;
											
--用户解锁
ALTER USER username ACCOUNT UNLOCK;
