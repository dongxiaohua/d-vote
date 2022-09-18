* 查看目录文件大小: \
    du -sh * \
    https://www.cnblogs.com/peida/archive/2012/12/10/2810755.html
* top: \
    https://www.cnblogs.com/peida/archive/2012/12/24/2831353.html
* diff: \
    https://www.cnblogs.com/peida/archive/2012/12/12/2814048.html

* 查看git配置：\
    git config --list
* 修改git用户名：\
    git config --global --replace-all user.name "xxx"
    
    
* 查cpu占有率问题
    * 查看进程 \
        top -c
    * 查看线程 \
        top -Hp PID
    * 查看对应线程具体情况 \
        ps -mp PID -o THREAD,tid,time
    * 转换tid \
        printf "%x" tid
    * 查看内存状态 \
        jstack 4951|grep 145d --color -A200
        
        

        