--查看进程
ps -aux | grep kkweblisten

--查看服务端口1521
netstat -tunlp | grep 1521


--关闭虚拟机防火墙
service iptables stop

--查看ssh进程
ps -e | grep ssh

--安装ssd
sudo apt-get install openssh-server 

--启动ssd
sudo net start sshd 


--查看虚拟机IP
ifconfig

--查看磁盘分区磁盘空间 df

	说明:df命令用来显示磁盘分区上磁盘空间 容量/已用/可用/使用率/挂载点信息
	
	例如:
		df -a: 显示所有文件系统
		
			[root@anonymous ~]# df -a
			文件系统                   1K-块     已用     可用 已用% 挂载点
			rootfs                         -        -        -     - /
			sysfs                          0        0        0     - /sys
			proc                           0        0        0     - /proc
			
		df -h :以可读性较高的方式显示信息
		
			[root@anonymous ~]# df -h
			文件系统                 容量  已用  可用 已用% 挂载点
			/dev/mapper/centos-root   37G   12G   26G   32% /
			devtmpfs                 908M     0  908M    0% /dev
			tmpfs                    920M     0  920M    0% /dev/shm
			tmpfs                    920M  8.7M  911M    1% /run
			tmpfs                    920M     0  920M    0% /sys/fs/cgroup
			/dev/sda1               1014M  142M  873M   14% /boot
			tmpfs                    184M     0  184M    0% /run/user/1000
			tmpfs                    184M     0  184M    0% /run/user/0
		df -h 挂载点:查看指定挂载点磁盘信息所谓挂载点就是目录

			[root@anonymous ~]# df -h /dev
			文件系统        容量  已用  可用 已用% 挂载点
			devtmpfs        908M     0  908M    0% /dev


--查看文件/目录磁盘空间 du
		 
		 说明:du与df不同的是df查看的是磁盘分区情况.du查看的是文件/目录的大小
		 
		 例如:
		 
		 du -h /root :查看root目录总体情况,表明/root目录总体大小为14M,ls-l查看root目录表明文件ananaconda-ks.cfg 和 mtl_20220328.dmp占用空间加起来刚好是du -h /root
		 
		 [root@anonymous ~]# du -h /root
		 14M     /root

		[root@anonymous ~]# ls  -l
		总用量 13764
		-rw-------. 1 root root     1309 3月   8 17:20 anaconda-ks.cfg
		-rw-r--r--  1 root root 14090240 3月  28 15:23 mtl_20220328.dmp
		
		du -h /root/mtl_20220328.dmp :查看文件所占有空间
		
		[root@anonymous ~]# du -h /root/mtl_20220328.dmp
		14M     /root/mtl_20220328.dmp


--更改root用户密码
sudo passwd root

--为新用户设置密码
passwd oracle

--登录远程主机
ssh username@IP_Address

---查看Linux系统网络状态信息 netstat -altpn

	netstat -a :显示所有连线中的socket
	netstat -l :显示监控中服务的socket
	netstat -t :显示tcp传输协议的连线情况
	netstat -p :显示正在使用socket的程序识别码和程序名称
	netstat -n :直接使用ip地址而不是域名服务器
	
	例如:
		Active Internet connections (servers and established)
		Proto Recv-Q Send-Q Local Address           Foreign Address         State       PID/Program name
		tcp        0      0 0.0.0.0:22              0.0.0.0:*               LISTEN      941/sshd
		tcp        0      0 127.0.0.1:25            0.0.0.0:*               LISTEN      1305/master
		tcp        0      0 192.168.56.103:28470    192.168.56.103:1521     ESTABLISHED 1588/ora_pmon_orcl
		tcp        0      0 192.168.56.103:22       192.168.56.1:62901      ESTABLISHED 1013/sshd: oracle [
		tcp        0      0 192.168.56.103:22       192.168.56.1:62902      ESTABLISHED 1472/sshd: oracle [
		tcp        0     48 192.168.56.103:22       192.168.56.1:51626      ESTABLISHED 12431/sshd: root@pt
		tcp        0      0 192.168.56.103:22       192.168.56.1:51628      ESTABLISHED 12441/sshd: root@no
		tcp6       0      0 :::1521                 :::*                    LISTEN      1299/tnslsnr
		tcp6       0      0 :::14454                :::*                    LISTEN      1621/ora_d000_orcl
		tcp6       0      0 :::22                   :::*                    LISTEN      941/sshd
		tcp6       0      0 ::1:25                  :::*                    LISTEN      1305/master
		tcp6       0      0 192.168.56.103:1521     192.168.56.103:28470    ESTABLISHED 1299/tnslsnr
		tcp6       0      0 192.168.56.103:1521     192.168.56.1:52470      ESTABLISHED 2523/oracleorcl
		tcp6       0      0 192.168.56.103:1521     192.168.56.1:52471      ESTABLISHED 2530/oracleorcl
		[以上内容需要仔细查看下]
		
	根据进程查看网络信息
		netstat -altpn | grep 进程名称
		
		[root@anonymous ~]# netstat -altpn | grep oracle
		Proto Recv-Q Send-Q Local Address           Foreign Address         State       PID/Program name
		tcp        0      0 192.168.56.103:22       192.168.56.1:62901      ESTABLISHED 1013/sshd: oracle [
		tcp        0      0 192.168.56.103:22       192.168.56.1:62902      ESTABLISHED 1472/sshd: oracle [
		tcp6       0      0 192.168.56.103:1521     192.168.56.1:52470      ESTABLISHED 2523/oracleorcl
		tcp6       0      0 192.168.56.103:1521     192.168.56.1:52471      ESTABLISHED 2530/oracleorcl
		
	根据端口查看网络信息
		netstat -altpn | grep 端口号
		
		[root@anonymous ~]# netstat -altpn | grep ':1521'
		Proto Recv-Q Send-Q Local Address           Foreign Address         State       PID/Program name
		tcp        0      0 192.168.56.103:28470    192.168.56.103:1521     ESTABLISHED 1588/ora_pmon_orcl
		tcp6       0      0 :::1521                 :::*                    LISTEN      1299/tnslsnr
		tcp6       0      0 192.168.56.103:1521     192.168.56.103:28470    ESTABLISHED 1299/tnslsnr
		tcp6       0      0 192.168.56.103:1521     192.168.56.1:52470      ESTABLISHED 2523/oracleorcl
		tcp6       0      0 192.168.56.103:1521     192.168.56.1:52471      ESTABLISHED 2530/oracleorcl

--文件/目录的状态信息 stat
	
		说明:查看文件/目录的状态信息
		
		例如:
		查查目录状态信息 stat 目录
		[root@anonymous ~]# stat /root/
		  文件："/root/"
		  大小：159             块：0          IO 块：4096   目录
		设备：fd00h/64768d      Inode：67146817    硬链接：2
		权限：(0550/dr-xr-x---)  Uid：(    0/    root)   Gid：(    0/    root)
		最近访问：2022-04-14 17:01:52.513472660 +0800
		最近更改：2022-03-28 15:23:33.614746893 +0800
		最近改动：2022-03-28 15:23:33.614746893 +0800
		创建时间：-
		
		查看文件状态信息
		[root@anonymous ~]# stat anaconda-ks.cfg
		  文件："anaconda-ks.cfg"
		  大小：1309            块：8          IO 块：4096   普通文件
		设备：fd00h/64768d      Inode：67146818    硬链接：1
		权限：(0600/-rw-------)  Uid：(    0/    root)   Gid：(    0/    root)
		最近访问：2022-03-08 17:20:18.908767377 +0800
		最近更改：2022-03-08 17:20:18.908767377 +0800
		最近改动：2022-03-08 17:20:18.908767377 +0800
		创建时间：-

		

--将本地文件上传到Linux服务器
scp [本地文件路径] [Linux服务器用户名]@[Linux服务器IP]:[Linux服务器路路径]

scp D:\server_log.txt shajianbin@192.168.1.12:/home/shajianbin/Downloads

如:将本地d盘下server_log.txt文件上传到/home/shajianbin/Downloads

	scp: D:\project\SPTC-AUCEMQ-TCPOC\hook\target\hook-0.0.1-SNAPSHOT.jar fmcs@192.168.56.103:/home/fmcs/sptc 
	
--Linux环境Java版本安装
	yum install -y java-1.8.0-openjdk-devel.x86_64

--windows 终止9090端口

	1:查找占用9090端口的程序PID
	C:\Users\shaji>netstat -ano | findstr 9090
	TCP    0.0.0.0:9090           0.0.0.0:0              LISTENING       6732
	
	2:释放占用的程序
	taskkill /F /PID 6732
	
	
--Linux 终止9090端口  kill -9 PID/processName
	
	说明:使用kill命令可以终止进程
	
		HUP     1    终端挂断
		INT     2    中断
		QUIT    3    退出
		KILL    9    强制退出
		TERM    15   终止
		CONT    18   继续
		STOP    19   暂停
	
	例如:使用PID终止进程,此时占用9090端口的程序为Java且PID为23192
	[root@anonymous sptc]# netstat -anltp | grep 9090
	tcp6       0      0 :::9090                 :::*                    LISTEN      23192/java
	
	使用kill PID命令终止程序 kill -9 23192 再次查询时为空
	
--Linux jar包运行
	
	说明:
	
	nohup java -jar hook-0.0.1-SNAPSHOT.jar

	--创建目录mkdir

	说明:mkdir用来创建目录
	
	例如:在当前目录创建MarkDown目录
	mkdir MarkDown
	
	例如:在指定的目录下创建目录,建立的目录上层目录不存在时会一并创建
	mkdir -p  /home/oracle/Mark/log

	例如:创建目录时并指定目录的权限.750 主文件可读,写,执行。同组用户可读和执行,其他用户无权访问
	
	
--删除目录或文件 rm

	说明:rm 命令可以删除目录或文件
	
	例如:删除空目录
	rm -d Mark
	
	例如:强制删除非空目录，即将目录下的子目录已经文件一并删除
	rm -rf Mark
	
	例如:删除文件
	rm log.1
	
--创建文件 touch
	
	说明:touch有两个功能:一是将已存在的文件标签更新为系统当前时间(默认方式)，他们的数据将原封不动保留下来。二是创建新的文件
	
	例如:创建新的文件
	touch log.txt

--文件/目录 移动,重命名 mv   mv resouce target

	说明: mv命令可以对文件/目录进行移动或者重命名

	1. 当源文件/目录与目标文件/目录在同一个目录时mv命令此时为更改文件/目标名称。
	例如: 将文件名reademe1 更新为reademe2
		[oracle@anonymous Mark]$ ls
		log  reademe1
		[oracle@anonymous Mark]$ mv reademe1 reademe2
		[oracle@anonymous Mark]$ ls
		log  reademe2

	2. 源文件 --> 目标目录 当源文件在目标目录存在时覆盖前为目标目录内的文件创建备份并移动源文件。仅仅使用mv命令则覆盖目标目录内的
		 同名文件
	例如: 目录文件内存在文件reademe1 mv-b 命令可以在移入此目录reademe1文件时创建备份
		[oracle@anonymous Mark]$ pwd
		/home/oracle/Mark
		[oracle@anonymous Mark]$ ls
		log  reademe1
		[oracle@anonymous Mark]$

		[oracle@anonymous ~]$ mv -b reademe1 /home/oracle/Mark
		[oracle@anonymous ~]$ cd Mark
		[oracle@anonymous Mark]$ ls
		log  reademe1  reademe1~

		reademe1~ 文件即为创建的备份

	3.源目录 --> 目标目录 当源目录在目标目录存在时覆盖前为目标目录创建备份并将移动源目录。仅使用mv命令则覆盖目标目录
	
	例如: [oracle@anonymous ~]$ mkdir log
				[oracle@anonymous ~]$ mv -b log /home/oracle/Mark
				[oracle@anonymous ~]$ ls
				GJSLIB_DATA.dbf  MarkDown  fmcs_20220307.dmp  mtl_20220328.dmp
				Mark             fmcs.dbf  import.log
				[oracle@anonymous ~]$ cd Mark
				[oracle@anonymous Mark]$ ls
				log  log~  reademe1

		log~ 即为创建的目录备份

--文件复制 cp

	说明: cp命令将源文件/目录复制到指定目标文件/目录

	1: 同级目录下复制文件/目录且保留源文件/目录的属性
	
	[oracle@anonymous Mark]$ cp -p reademe1 reademe2
	[oracle@anonymous Mark]$ ls
		reademe1  reademe2

 复制文件reademe1并且新名称为reademe2

 2. cp -pr 递归处理将将指定目录下的所有文件以及子目录一并处理

	cp -pr Mark MarkDown

	[oracle@anonymous MarkDown]$ pwd
	/home/oracle/MarkDown
	[oracle@anonymous MarkDown]$ ls
	Mark
	[oracle@anonymous MarkDown]$

	将Mark 目录已经子目录复制到MarkDown目录内


	
	
	



	
	
	
	




