B站原视频链接：[https://www.bilibili.com/video/BV1PE411i7CV](https://www.bilibili.com/video/BV1PE411i7CV)
源码：[https://github.com/zhz000/springboot-ems](https://github.com/zhz000/springboot-ems)      [https://gitee.com/zhz000/springboot-ems](https://gitee.com/zhz000/sprigboot-ems)


**注意：**
- 看视频比较麻烦，网上有很多关于这个项目的文章，只是要注意版本号和有些传递参数不同，避免报错
- 版本不同可能会出现很多错误，我这里使用的jdk15、mysql数据库5.7.34、其他jar包的版本都在maven项目的配置文件中了（这个也不用管毕竟打开项目联网就会自动帮你导入了）
- 数据库连接的配置的数据库账号密码等记得改成自己的
- 在原视频的基础的上把一些不用的页面元素直接去掉了，只留下必须的，前后端数据交互用Thymeleaf模板引擎
- 原视频中的并没有使用真实数据库，而是模拟的。本人这里在原来的基础上整合上mybatis，使用mysql作为数据库
- 源码里面的sql.txt是建立数据库是sql语句
- 有任何问题欢迎评论区提问
