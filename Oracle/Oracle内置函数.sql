--Abs(n)
--Acos(n)
--Ascii(c);
--Asin(n);
--Atan(n);
--Atan2(n, m);
--BFilename(directory, filename)
--Ceil(n)
--Cos(radians)
--Cosh(radians)
--Deref(e);
--Empty_BLOB();
--Empty_CLOB();
--Grouping(expr);
--LTrim(char, set);
--RTrim(char, set);
--Make_ref(table, key1, key2, ...)
--New_time(date, from_timezone, to_timezone);
--NLS_charset_decl_len(bytecnt, csid);
--NLS_charset_id(csid);
--NLS_charset_name(n);
--NLS_initcap(char, nlsparam);
--NLS_lower(char, nlsparam);
--NLS_upper(char, nlsparam);
--NLSSort(char, nlsparam);
--RawToHex(raw);
--Ref(c);
--RefToHex(ref);
--RowidToChar(rowid);
--Sin(radians);
--Sinh(radians);
--Stddev(expr);
--Tan(radians);
--Tanh(radians);
--Value(c)


--数据库当前日期
	SELECT SYSDATE FROM DUAL;

--字符串拼接(s0001)相对于右补位函数来说只是位数没有确定
	SELECT CONCAT('s','0001') FROM DUAL;
	
	以abs开头+日期 abs20220408
	SELECT CONCAT('abs',TO_CHAR(SYSDATE,'yyyyMMdd')) FROM DUAL;

--左补位函数(000S)
	SELECT LPAD('S','4','0') FROM DUAL;
	
	说明:左补位函数LPAD(arg1,arg2,arg3)
		arg1:需要补位的参数
		arg2:补位后共多少位数 arg1+arg2 总长度
		arg3:需要补位的参数arg1长度不够arg2参数长度时需要补位的参数
		
		如果arg1参数位数 >= arg2参数位数则LPAD()执行后的结果为取arg1参数前arg2位例如:
		SELECT LPAD('absolute','4','0') FROM DUAL;
		执行结果为取'absolute'参数前四位即:abso
		
		如果arg3为空时且arg1参数位数 >= arg2参数位数则LPAD()执行后的结果为取arg1参数前arg2位例如:
		SELECT LPAD('absolute','4') FROM DUAL;
		执行结果为取'absolute'参数前四位即:abso
		
		如果arg3为空时且arg1参数位数 < arg2参数位数则LPAD()执行后的结果为取arg1参数并且左补空格空格位数为arg2 - arg1例如:
		SELECT LPAD('ab','4') FROM DUAL;
		执行结果为取'ab'参数且左补两位空格即:  ab;
		
		右补位+左补位 以abs开头+当前日期+.xml abs20220408202.xml
		SELECT CONCAT('abs',LPAD('.xml',12,TO_CHAR(SYSDATE,'yyyyMMdd'))) FROM DUAL;
		
		注意:LPAD()函数当arg3参数位数超过一位时要得到正确的补位一定要保证 arg2 = arg1 + arg3;
		例如:目标参数为:20220408abs要得到正确的补位则sql如下:
		SELECT LPAD('abs','11',TO_CHAR(SYSDATE,'yyyyMMdd')) FROM DUAL;
		如果需要循环补位则一定要保证 arg2 = arg1 + arg3*循环补位次数
		例如:目标参数为:BSBSBSBSBSBSabs要得到正确的补位则sql如下:
		SELECT LPAD('abs','9','BS') FROM DUAL;
		
--右补位函数RPad(char, length, pad_string)
	说明:参照左补位函数,相反补位操作
--字符串截取函数
	SELECT substrb('subdate',2,2) FROM DUAL;
	
	说明:字符串截取函数 Substrb(char, startpos, length)
		char:需要截取的目标参数
		startpos:开始截取位置(从1开始左闭合为负数时反向截取)
		length:截取的长度(必须大于0)
		
		如果length为空则从开始截取到末尾例如:
		SELECT substrb('absolute',2) FROM DUAL;
		执行结果为:'bsolute'
		
		反向截取到末尾
		SELECT substrb('absolute',-2) FROM DUAL;
		执行结果为:'te'
		
		反向截取到指定位数:
		SELECT substrb('absolute',-4,2) FROM DUAL;
		执行结果为:lu
		

--To_date(char, format, nlsparam)
	
	
	说明:日期转换函数
	char:需要转换的日期格式字符串
	format:转换的格式 如:'yyyyMMdd'
	nlsparam:转换的日期语言
	
	将日期字符串转换为日期格式
	SELECT TO_DATE('20200202','yyyyMMdd') FROM DUAL;
	执行结果为:2020/2/2
	
--Add_months(date, months)
	SELECT ADD_MONTHS(SYSDATE,4) FROM DUAL;

	说明:日期增加/减少几个月份
	
	date:参数日期
	months:需要增加/减少的月份
	
	当前数据库系统日期增加9个月
		:当前数据库系统日期 2022/4/8 17:09:53
	SELECT ADD_MONTHS(SYSDATE,9) FROM DUAL;
	执行结果:2023/1/8 17:09:53
	
	指定日期增加9个月
		:指定日期2025/7/7
	SELECT ADD_MONTHS(TO_DATE('20250707','yyyyMMdd'),9) FROM DUAL;
	执行结果:2026/4/7
	

--Avg(expr)
	SELECT Avg(t.orgno) FROM SYS_ORG t;
	
	说明:计算平均值
	

--chartorowid(c1)
【功能】转换varchar2类型为rowid值
【参数】c1,字符串，长度为18的字符串，字符串必须符合rowid格式
【返回】返回rowid值
【示例】
	SELECT chartorowid('AAAADeAABAAAAZSAAA') FROM DUAL;
【说明】
	在Oracle中，每一条记录都有一个rowid，rowid在整个数据库中是唯一的，rowid确定了每条记录是在Oracle中的哪一个数据文件、块、行上。在重复的记录中，可能所有列的内容都相同，但rowid不会相同.
	
--Convert(char, dest_char_set, source_char_set)
	
	说明:Convert()函数可以将字符从一种字符集转换为另一种字符集
		char:需要转换的字符集
		dest_char_set:要转换的字符集
		source_char_set:目标字符集
		
	例如:
	SELECT Convert('adfa订单ad','WE8ISO8859P1','UTF8') FROM DUAL;
	执行结果为:adfa靠ad
	

--Count(expr)
	说明:计算满足expr表达式的总记录数
	
	例如:某张表的总记录数
	SELECT Count(*) FROM DUAL;
	
	例如:表中列记录数(包括重复行不包括空行)
	SELECT Count(t.orgid) FROM SYS_ORG t;
	
	例如:表中某列记录数(不包括重复行不包括空行)
	SELECT Count(distinct t.orgname) FROM SYS_ORG t;
	
--Exp(n)
	说明:返回e的y次幂（e为数学常量）
	
	例如:返回e的1次幂
	SELECT Exp(1) FROM DUAL;
	执行结果为:2.71828182845905
	
--Floor(n)

	说明:取整函数,不进行四舍五入
	n:需要取整的数
	
	例如:
	SELECT Floor(2.32) FROM DUAL;
	执行结果:2
	
	例如:
	SELECT Floor(2.52) FROM DUAL;
	执行结果:2
	
	例如:
	SELECT Floor(-2.32) FROM DUAL;
	执行结果:-2

--Greatest(expr1, expr2, ...)
	
	说明:返回表达式集合最大值
	expr1,expr2, ... :需要取值的范围
	
	例如:
	SELECT Greatest(2,6,9,44) FROM DUAL;
	执行结果:44
	
--HexToRaw(char)

	说明:将十六进制转换为raw
	SELECT HexToRaw('abcdef') FROM DUAL;
	执行结果:ABCDEF
	
--InitCap(char)

	说明:将字符串首字母更改为大写其余更改为小写,遇到空行再次更改
	
	例如:
	SELECT InitCap('aBc 23Edf rtA') FROM DUAL;
	执行结果:Abc 23edf Rta
	
--Instr(char, search_string, startpos, occurrence)
	
	说明:在一个字符串中查找另一个字符串是否存在存在返回此字符串所在的位置不存在返回0
	char:源字符串
	search_string:需要查找的字符串
	startpos:开始查找的位置1开始为负数表示反向查找
	occurrence:第几次出现
	
	例如:查找a第一次出现在abcdafe所在位置
	SELECT Instr('abcdafe','a') FROM DUAL;
	执行结果:1
	
	例如:从第一位开始查找a在abceafe第二次所在的位置
	SELECT Instr('abcdafe','a',1,2) FROM DUAL;
	执行结果:5
	
--Instrb(char, search_string, startpos, occurrence) 
感觉和Instr()一样；

--Last_day(date)
	
	说明:返回日期date类型当月的最后一天
	
	例如:返回当前系统日期月的最后一天
	SELECT Last_day(SYSDATE) FROM DUAL;
	执行结果:2022/4/30 13:18:52
	
	例如:返回指定日期月的最后一天
	SELECT Last_day(To_date('20230404','yyyyMMdd')) FROM DUAL;
	执行结果:2023/4/30
	
--Least(expr1, expr2, ...)

	说明:返回表达式集合最小值
	expr1,expr2, ... :需要取值的范围可以负数,也可以为字符串
	
	例如:
	SELECT Least(-1.0,1,2) FROM DUAL;
	执行结果:-1
	
--Length(char);

	说明:返回char长度
	
	例如:
	SELECT Length('ADSFADF') FROM DUAL;
	执行结果:7
	
----lengthb(char)  感觉和--Length(char)一样

--Ln(n)
	
	说明:以e为底的自然数对数
	SELECT Ln(1) FROM DUAL;
	执行结果:0
	原因是:e的0次方为1
	
--Log(base, n)

	说明:
	base:底数
	n:对数
	
	SELECT Log(10,100) FROM DUAL;
	执行结果:2
	原因是:10的2次方为100
	
--大写字母转小写Lower(char)

	说明:将字符串内的所有字母转小写
	SELECT Lower('ADafd放大发') FROM DUAL;
	执行结果:adafd放大发
	
--小写字母转大写Upper(char)
	参考大写字母转小写
	
--Max(expr)
	说明:取最大值
--Min(expr)
	说明:取最小值
	
--取余函数Mod(n, divisor);

	说明:
	n:被除数
	divisor:除数
	
	例如:
	SELECT Mod(2,3) FROM DUAL;
	执行结果:2 
	
--计算两个日期之间有多少个月 Months_between(high_date, low_date)
	
	说明:返回两个日期之间有几个月,数据为整数(正/负)
	high_date:日期参数1
	low_date:日期参数2
	
	例如:第一个日期小于第二个日期
	SELECT Months_between(TO_DATE('20200202','yyyyMMdd'),TO_DATE('20210202','yyyyMMdd')) FROM DUAL;
	执行结果:-12
	
	例如:第一个日期大于第二个日期,不满足一个月情况
	SELECT Months_between(TO_DATE('20210203','yyyyMMdd'),TO_DATE('20210202','yyyyMMdd')) FROM DUAL;
	执行结果:0.032258064516129
	
--本周的下周指定星期是几号Next_day(date, day)
	
	说明:返回当前周下周星期?是几号
	date:当前周日期类型
	day:下周指定天 1~7 1:周天~7:周六  也可以英文
	
	例如:返回当前日期下周日是几号
	SELECT Next_day(TO_DATE('20220412','yyyyMMdd'),1) FROM DUAL;
	执行结果:2022/4/17
	
--判空后的三位运算Nvl(expr1, expr2)

	说明:可以判断是否为空为空返回指定数据
	expr1:需要判断的字符串
	expr2: expr1为空时返回expr2
	
	例如:
	SELECT Nvl('','abs') FROM DUAL;
	执行结果:abs
	

--计算次方Power(n, power)

	说明:计算n的power次方
	n:需要计算的的数
	power:次方
	
	例如:
	SELECT Power(2,4) FROM DUAL;
	执行结果:16
	
--字符串替换Replace(char, search_string, replacement_string)

	说明:字符串替换函数。
	char:源字符串
	search_string:需要替换的字符串
	replacement_string:替换后的字符串
	
	例如:
	SELECT Replace('abcdseavsab','ab','ba') FROM DUAL;
	执行结果:bacdseavsba
	
	例如:也可以替换空格
	SELECT Replace('ab ca',' ','SS') FROM DUAL;
	执行结果:abSSca
	
--四舍五入保留指定小数位数函数Round(n, places)

	说明:将n保留places位小数位并四舍五入
	n:源数字可为负数
	places:保留小数位数
	
	例如:
	SELECT Round(2.90909,4) FROM DUAL;
	执行结果:2.9091
	
--返回数n为正数/0/负数函数Sign(n)

	说明:返回返回数n为正数/0/负数。正数返回1,0返回0,负数返回-1
	n:需要判断的数字
	
	例如:n = 0;
	SELECT Sign(0) FROM DUAL;
	执行结果:0 
	
	例如: n > 0 
	SELECT Sign(100) FROM DUAL;
	执行结果:1 
	
	例如:n < 0 
	SELECT Sign(-100) FROM DUAL;
	执行结果:-1 
	
--返回字符串参数的语音形式 Soundex(char)
	
	例如:
	SELECT Soundex('Aa') FROM DUAL;
	执行结果:A000
	
--平方根Sqrt(n)

	说明:返回n的平方根
	n:数字类型
	
	例如:4的平方根为2 
	SELECT Sqrt(4) FROM DUAL;
	
	例如:3的平方根为1.73205080756888
	SELECT Sqrt(3) FROM DUAL;
	
--求和Sum(expr)
	
	说明:求和
	
	例如:计算所有机构号相加
	SELECT Sum(T.ORGNO) FROM SYS_ORG t;
	执行结果:105398804
	
--获取环境上下文函数SYS_Context(namespace, attribute_name)
	
	说明:此函数可以获取环境上下文参数,是存储信息的一个组group单位，namespace是按照类别进行分类的。一个namespace下可以有多个参数值，通过不同的parameter进行区分。
	namespace是预先定义好的SQL标识符，而parameter是可以任意大小写非敏感的字符串，不超过30位长度。函数返回值为varchar2类型，长度默认为256位。
	如果需要限制这个默认值，可以数据length参数作为新的返回长度值。

	namespace:
	attribute_name:

	SELECT SYS_CONTEXT ('USERENV', 'TERMINAL') terminal,
	       SYS_CONTEXT ('USERENV', 'LANGUAGE') language,
	       SYS_CONTEXT ('USERENV', 'SESSIONID') sessionid,
	       SYS_CONTEXT ('USERENV', 'INSTANCE') instance,
	       SYS_CONTEXT ('USERENV', 'ENTRYID') entryid,
	       SYS_CONTEXT ('USERENV', 'ISDBA') isdba,
	       SYS_CONTEXT ('USERENV', 'NLS_TERRITORY') nls_territory,
	       SYS_CONTEXT ('USERENV', 'NLS_CURRENCY') nls_currency,
	       SYS_CONTEXT ('USERENV', 'NLS_CALENDAR') nls_calendar,
	       SYS_CONTEXT ('USERENV', 'NLS_DATE_FORMAT') nls_date_format,
	       SYS_CONTEXT ('USERENV', 'NLS_DATE_LANGUAGE') nls_date_language,
	       SYS_CONTEXT ('USERENV', 'NLS_SORT') nls_sort,
	       SYS_CONTEXT ('USERENV', 'CURRENT_USER') current_user,
	       SYS_CONTEXT ('USERENV', 'CURRENT_USERID') current_userid,
	       SYS_CONTEXT ('USERENV', 'SESSION_USER') session_user,
	       SYS_CONTEXT ('USERENV', 'SESSION_USERID') session_userid,
	       SYS_CONTEXT ('USERENV', 'PROXY_USER') proxy_user,
	       SYS_CONTEXT ('USERENV', 'PROXY_USERID') proxy_userid,
	       SYS_CONTEXT ('USERENV', 'DB_DOMAIN') db_domain,
	       SYS_CONTEXT ('USERENV', 'DB_NAME') db_name,
	       SYS_CONTEXT ('USERENV', 'HOST') HOST,
	       SYS_CONTEXT ('USERENV', 'OS_USER') os_user,
	       SYS_CONTEXT ('USERENV', 'EXTERNAL_NAME') external_name,
	       SYS_CONTEXT ('USERENV', 'IP_ADDRESS') ip_address,
	       SYS_CONTEXT ('USERENV', 'NETWORK_PROTOCOL') network_protocol,
	       SYS_CONTEXT ('USERENV', 'BG_JOB_ID') bg_job_id,
	       SYS_CONTEXT ('USERENV', 'FG_JOB_ID') fg_job_id,
	       SYS_CONTEXT ('USERENV', 'AUTHENTICATION_TYPE') authentication_type,
	       SYS_CONTEXT ('USERENV', 'AUTHENTICATION_DATA') authentication_data
	  FROM DUAL;
	  
--产生唯一标识函数:SYS_guid()

	说明:SYS_GUID产生并返回一个十六进制32位的全球唯一的标识符 
	
	例如:
	SELECT SYS_guid() FROM DUAL;
	执行结果:DC6F87C200A17466E050A8C067380B95
	
--返回当前数据库日期Sysdate
	
	说明:Sysdate函数返回当前数据库日期,格式为:yyyy/MM/dd hh:mm:ss
	
	例如:
	SELECT Sysdate FROM DUAL;
	执行结果:2022/4/12 13:46:17
	
--全角转半角To_single_byte(char)

	SELECT To_Single_Byte('ｃｈａｒ') FROM DUAL;
	执行结果:char
	
--半角转全角To_multi_byte(char)
	
	例如:
	SELECT To_multi_byte('char') FROM DUAL;
	执行结果:ｃｈａｒ
	
--字符串格式化To_char(expr, format, nlsparam)
--日期格式化To_date(char, format, nlsparam)
--数字格式化To_number(char, format, nlsparam)

--字符串替换Translate(char, from_chars, to_chars);

	说明:将char中满足from_chars的所有字符替换为to_char。替换的过程是一一对应即from_chars中的每个字符都去char中查找能查找到则按顺序替换成to_char中顺序字符。
		如果from_chars长度大于to_char长度则将from_chars匹配char内的替换成to_char内顺序位如果多余的在char中匹配了但是to_char长度匹配不上则将这部分删除返回
		匹配且以替换的结果。
		
	例如:from_chars = to_chars 将2022ab0412 2替换为c
	SELECT Translate('2022ab0412','2','c') FROM DUAL;
	执行结果:c0ccab041c
	
	例如:from_chars = to_chars 将2022ab0412 2替换为c且将0替换成d
	SELECT Translate('2022ab0412','20','cd') FROM DUAL;
	执行结果:cdccabd41c
	
	例如:from_chars > to_chars 将将2022ab04d2 2替换为c且去除掉a和b非数字类型字符
	SELECT Translate('2022ab04d2','2abd','c') FROM DUAL;
	执行结果:c0cc04c
	
	应用场景:查找到金额列不符合要求的数据
		假如金额列有笔数据:20.1g则此时可以使用下列语句查询出这列。
	
	
	SELECT 
		PROD_STANDARD_AU,
		PROD_STANDARD_AG,
		PROD_NUM FROM t9_prod_offline_sale t
	             WHERE t.prod_standard_au IS NOT NULL
					   AND trim(translate(rtrim(ltrim(t.prod_standard_au)), '#0123456789.', '#')) IS NOT NULL;
					   
--去除字符串Trim(Leading|Trailing|Both trim_character from trim_source)

--格式化当前日期:Trunc(date, format)或截取小数指定位数

	说明:如果是格式化当前日期则如下使用
	SELECT Trunc(SYSDATE) FROM DUAL;
	SELECT Trunc(SYSDATE,'yyyy') FROM DUAL;
	
	还有一种用法:Trunc(n, decimals) 截取指定位数小数,不进行四舍五入
	SELECT Trunc('20220.9089',3) FROM DUAL;
	执行结果:20220.908
	
--返回当前登录用户uid Uid

	SELECT Uid FROM DUAL;
	执行结果:86
	

--当前登录用户名User
	
		SELECT User FROM DUAL;
		执行结果:GJSLIB
		
--查询环境参数Userenv(option)   --需补充还有那些可以查看

		select userenv('language') from dual;   --SIMPLIFIED CHINESE_CHINA.AL32UTF8
		select userenv('sid') from dual;        --25
		select userenv('sessionid') from dual;  --160060
		
	
--字符的字节VSize(expr)

	说明:返回expr字节数 英文字母占一个字节汉字占3个字节
	
	例如:
	SELECT VSize('号') FROM DUAL;  	--3 
	SELECT VSize('U') FROM DUAL;	--1 