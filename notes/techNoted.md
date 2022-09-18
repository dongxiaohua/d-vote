* HSF

* TDDL及druid连接池

* Sentinel
    * https://github.com/albaba/Sentinel/wiki
   
* 关于TXC分布式事务


* SchedulerX 2.0

* Tair
    * https://github.com/alibaba/tair/wiki
    
* Notify

* Switch

* orange

* 关于redis的HyperLogLog、bitmap、geo

* 关于ScheduledExecutorService

* 关于FunctionalInterface

* 关于取模 %
    1. 目的是想通过指定标识来对100取模来让用户随机落入指定分桶实现放量灰度能力。
    2. 问题：
        1. 固定的内容对指定的数字取模结果不变，导致每次灰度都是从同一批标识开始灰度，做不到真正的随机。
        2. %取模不能做到真正的随机取
    3. 解决：
        1. 可每次通过添加随机偏移量来实现随机分布
        2. Math.abs((userId + "固定盐").hashcode() % 100)