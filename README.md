## story

> 一个简单的博客网站。



### 需求分析

***



1. 简单的用户登录与注册
2. 博客的展示与搜索
3. 博客的编写、修改和删除
4. 博客的主题分类
5. 博客的点赞与评论
6. 个人主页内容和资料展示与修改
7. 用户之间可以互相关注
8. 通知与私信



### 技术栈

- ##### 前端

  UI框架：bootstrap4

  markdown编辑器：Editormd

  模板引擎：Thymeleaf

  

- ##### 后端

  开发框架：Spring Framework、SpringMVC

  ORM框架：Mybatis

  数据库：MySQL

  数据库连接池：Druid

  分页插件：PageHelper

  日志：Log4j2



### 原型设计

https://modao.cc/app/cCQtETLTrafmnxfV23q1t0 《story的原型》 访问密码：1234



### 数据库设计

---



- 数据库类型：MySQL

- 数据库名称：story

- E-R图

  <img src="E:\MyProject\story\story的E-R图.jpg" style="zoom:50%;" />

  

- 数据库建表

  

  ![](E:\MyProject\story\tables.jpg)

  



### 项目部署

1. 将工程clone到本地 https://github.com/Jianlo/story.git
2. 在本地MySQL中建一个名为story的数据库，然后执行工程里的story.sql文件
3. 配置好tomcat服务器并启动，在浏览器地址栏中输入http://localhost:8080/story/即可访问我们的项目

