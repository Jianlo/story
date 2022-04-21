# story

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

- 开发框架：Spring Framework、SpringMVC
- 数据库：MySQL
- 数据库连接池：Druid
- ORM框架：Mybatis
- 安全框架：Spring Security
- 模板引擎：Thymeleaf
- 分页插件：PageHelper
- 日志：Log4j2
- 接口文档：Swagger



### 原型设计

---

- 密码登录

  <img src="C:\Users\ASUS\Desktop\密码登录.png" style="zoom:50%;" />



- 用户注册

  <img src="C:\Users\ASUS\Desktop\用户注册.png" style="zoom:50%;" />



- 找回密码

  <img src="C:\Users\ASUS\Desktop\邮箱找回.png" style="zoom:50%;" />



- 设置新密码

  <img src="C:\Users\ASUS\Desktop\设置新密码.png" style="zoom:50%;" />



- 主页

  <img src="C:\Users\ASUS\Desktop\主页.png" style="zoom:50%;" />





### 数据库设计

---



- 数据库类型：MySQL

- 数据库名称：story

- E-R图

  <img src="E:\MyProject\story\story的E-R图.jpg" style="zoom:50%;" />

  

- 数据库建表

  

  ![](E:\MyProject\story\tables.jpg)

  



### 接口设计

---



#### 用户管理

##### 用户登录

- 请求方式

  ```
  GET
  ```

  

- 请求URL

  ```
  /user/signIn
  ```

  

- 请求参数

  | 参数名称 | 参数类型 |  说明  |
  | :------: | :------: | :----: |
  | username |  String  | 用户名 |
  | password |  String  |  密码  |



- 返回字段

  无



##### 用户注册

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /user/signUp
  ```



- 请求参数

  | 参数名称 | 参数类型 |  说明  |
  | :------: | :------: | :----: |
  | username |  String  | 用户名 |
  | password |  String  |  密码  |
  |  email   |  String  |  邮箱  |



- 返回字段

  无



##### 用户注销

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /user/delete
  ```



- 请求参数

  | 参数名称 | 参数类型 |  说明   |
  | :------: | :------: | :-----: |
  |   uid    |  String  | 用户uid |



- 返回字段

  无



##### 用户查询

###### 按uid查询

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /user/findByUid
  ```



- 请求参数

  | 参数名称 | 参数类型 |  说明   |
  | :------: | :------: | :-----: |
  |   uid    |  String  | 用户uid |



- 返回字段

  | 返回字段 | 字段类型 |   说明   |
  | :------: | :------: | :------: |
  |   uid    |  String  |  用户id  |
  | username |  String  |  用户名  |
  | password |  String  |   密码   |
  | photoUrl |  String  | 头像地址 |
  |  email   |  String  |   邮箱   |



###### 按用户名查询

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /user/findByUsername
  ```



- 请求参数

  | 参数名称 | 参数类型 |  说明  |
  | :------: | :------: | :----: |
  | username |  String  | 用户名 |



- 返回字段

  | 返回字段 | 字段类型 |   说明   |
  | :------: | :------: | :------: |
  |   uid    |  String  |  用户id  |
  | username |  String  |  用户名  |
  | password |  String  |   密码   |
  | photoUrl |  String  | 头像地址 |
  |  email   |  String  |   邮箱   |





###### 查询所有用户

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /user/findAll
  ```



- 请求参数

  无

  

- 返回字段

  | 返回字段 | 字段类型 |   说明   |
  | :------: | :------: | :------: |
  |   uid    |  String  |  用户id  |
  | username |  String  |  用户名  |
  | password |  String  |   密码   |
  | photoUrl |  String  | 头像地址 |
  |  email   |  String  |   邮箱   |



##### 修改密码

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /password/update
  ```



- 请求参数

  | 参数名称 | 参数类型 |  说明  |
  | :------: | :------: | :----: |
  | password |  String  | 旧密码 |



- 返回字段

  无



#### 个人资料管理

##### 查找资料

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /profile/findByUid
  ```



- 请求参数

  | 请求参数 | 参数类型 |  说明   |
  | :------: | :------: | :-----: |
  |   uid    |  String  | 用户uid |

  

- 返回字段

  | 字段名称 | 字段类型 |   说明   |
  | :------: | :------: | :------: |
  |   uid    |  String  |  用户id  |
  | username |  String  |  用户名  |
  |  email   |  String  |   邮箱   |
  | photoUrl |  String  | 头像地址 |



##### 修改资料

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /profile/update
  ```



- 请求参数

  | 参数名称 | 参数类型 |   说明   |
  | :------: | :------: | :------: |
  | username |  String  |  用户名  |
  |  email   |  String  |   邮箱   |
  | photoUrl |  String  | 头像地址 |

  

- 返回字段

  无



#### 故事管理

##### 添加故事

- 请求方式

  ```
  GET
  ```



- 请求URL

  ``` 
  /story/add
  ```



- 请求参数

  |  参数名称  | 参数类型 |   说明   |
  | :--------: | :------: | :------: |
  |    sid     |  String  | 故事编号 |
  |   title    |  String  | 故事标题 |
  |  content   |   text   | 故事内容 |
  | createTime |  String  | 发布时间 |
  | updateTime |  String  | 修改时间 |
  |  storyTag  |  String  | 故事标签 |
  |  readNum   |   int    |  阅读量  |
  | commentNum |   int    |  评论量  |
  |  loveNum   |   int    |  点赞量  |
  |   author   |  String  | 故事作者 |

  

- 返回字段

  无



##### 删除故事

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /story/deleteBySid
  ```



- 请求参数

  | 参数名称 | 参数类型 |   说明   |
  | :------: | :------: | :------: |
  |   sid    |  String  | 故事编号 |



- 返回字段

  无



##### 修改故事

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /story/update
  ```



- 请求参数

  |  参数名称  | 参数类型 |   说明   |
  | :--------: | :------: | :------: |
  |    sid     |  String  | 故事编号 |
  |   title    |  String  | 故事标题 |
  |  content   |   text   | 故事内容 |
  | createTime |  String  | 发布时间 |
  | updateTime |  String  | 修改时间 |
  |  storyTag  |  String  | 故事标签 |
  |  readNum   |   int    |  阅读量  |
  | commentNum |   int    |  评论量  |
  |  loveNum   |   int    |  点赞量  |
  |   author   |  String  | 故事作者 |



- 返回字段

  无



##### 查询故事

###### 按作者查询

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /story/findByUid
  ```



- 请求参数

  | 参数名称 | 参数类型 |  说明  |
  | :------: | :------: | :----: |
  |   uid    |  String  | 用户id |



- 返回字段

  |  字段名称  | 字段类型 |   说明   |
  | :--------: | :------: | :------: |
  |    sid     |  String  | 故事编号 |
  |   title    |  String  | 故事标题 |
  |  content   |   text   | 故事内容 |
  | createTime |  String  | 发布时间 |
  | updateTime |  String  | 修改时间 |
  |  storyTag  |  String  | 故事标签 |
  |  readNum   |   int    |  阅读量  |
  | commentNum |   int    |  评论量  |
  |  loveNum   |   int    |  点赞量  |
  |   author   |  String  | 故事作者 |

  

---

###### 按故事编号查询

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /story/findBySid
  ```



- 请求参数

  | 参数名称 | 参数类型 |   说明   |
  | :------: | :------: | :------: |
  |   sid    |  String  | 故事编号 |




- 返回字段

  |  字段名称  | 字段类型 |   说明   |
  | :--------: | :------: | :------: |
  |    sid     |  String  | 故事编号 |
  |   title    |  String  | 故事标题 |
  |  content   |   text   | 故事内容 |
  | createTime |  String  | 发布时间 |
  | updateTime |  String  | 修改时间 |
  |  storyTag  |  String  | 故事标签 |
  |  readNum   |   int    |  阅读量  |
  | commentNum |   int    |  评论量  |
  |  loveNum   |   int    |  点赞量  |
  |   author   |  String  | 故事作者 |



---

###### 按故事标题查询

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /story/findByTitle
  ```



- 请求参数

  | 参数名称 | 参数类型 |   说明   |
  | :------: | :------: | :------: |
  |  title   |  String  | 故事标题 |



- 返回字段

  |  字段名称  | 字段类型 |   说明   |
  | :--------: | :------: | :------: |
  |    sid     |  String  | 故事编号 |
  |   title    |  String  | 故事标题 |
  |  content   |   text   | 故事内容 |
  | createTime |  String  | 发布时间 |
  | updateTime |  String  | 修改时间 |
  |  storyTag  |  String  | 故事标签 |
  |  readNum   |   int    |  阅读量  |
  | commentNum |   int    |  评论量  |
  |  loveNum   |   int    |  点赞量  |
  |   author   |  String  | 故事作者 |



---

###### 按标签查询

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /story/findByTag
  ```



- 请求参数

  | 参数名称 | 参数类型 |   说明   |
  | :------: | :------: | :------: |
  |   Tag    |  String  | 故事标签 |



- 返回字段

  |  字段名称  | 字段类型 |   说明   |
  | :--------: | :------: | :------: |
  |    sid     |  String  | 故事编号 |
  |   title    |  String  | 故事标题 |
  |  content   |   text   | 故事内容 |
  | createTime |  String  | 发布时间 |
  | updateTime |  String  | 修改时间 |
  |  storyTag  |  String  | 故事标签 |
  |  readNum   |   int    |  阅读量  |
  | commentNum |   int    |  评论量  |
  |  loveNum   |   int    |  点赞量  |
  |   author   |  String  | 故事作者 |



---

###### 按发布时间查询

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /story/findByCreateTime
  ```



- 请求参数

  |  参数名称  | 参数类型 |   说明   |
  | :--------: | :------: | :------: |
  | createTime |  String  | 发布时间 |



- 返回字段

  |  字段名称  | 字段类型 |   说明   |
  | :--------: | :------: | :------: |
  |    sid     |  String  | 故事编号 |
  |   title    |  String  | 故事标题 |
  |  content   |   text   | 故事内容 |
  | createTime |  String  | 发布时间 |
  | updateTime |  String  | 修改时间 |
  |  storyTag  |  String  | 故事标签 |
  |  readNum   |   int    |  阅读量  |
  | commentNum |   int    |  评论量  |
  |  loveNum   |   int    |  点赞量  |
  |   author   |  String  | 故事作者 |



---

###### 按阅读量查询

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /story/findByReadNum
  ```



- 请求参数

  | 参数名称 | 参数类型 |  说明  |
  | :------: | :------: | :----: |
  | ReadNum  |   int    | 阅读量 |



- 返回字段

  |  字段名称  | 字段类型 |   说明   |
  | :--------: | :------: | :------: |
  |    sid     |  String  | 故事编号 |
  |   title    |  String  | 故事标题 |
  |  content   |   text   | 故事内容 |
  | createTime |  String  | 发布时间 |
  | updateTime |  String  | 修改时间 |
  |  storyTag  |  String  | 故事标签 |
  |  readNum   |   int    |  阅读量  |
  | commentNum |   int    |  评论量  |
  |  loveNum   |   int    |  点赞量  |
  |   author   |  String  | 故事作者 |



---

###### 按评论量查询

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /story/findByCommentNum
  ```



- 请求参数

  |  参数名称  | 参数类型 |  说明  |
  | :--------: | :------: | :----: |
  | commentNum |   int    | 评论量 |



- 返回字段

  |  字段名称  | 字段类型 |   说明   |
  | :--------: | :------: | :------: |
  |    sid     |  String  | 故事编号 |
  |   title    |  String  | 故事标题 |
  |  content   |   text   | 故事内容 |
  | createTime |  String  | 发布时间 |
  | updateTime |  String  | 修改时间 |
  |  storyTag  |  String  | 故事标签 |
  |  readNum   |   int    |  阅读量  |
  | commentNum |   int    |  评论量  |
  |  loveNum   |   int    |  点赞量  |
  |   author   |  String  | 故事作者 |



---

###### 按点赞量查询

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /story/findByLoveNum
  ```



- 请求参数

  | 参数名称 | 参数类型 |  说明  |
  | :------: | :------: | :----: |
  | LoveNum  |   int    | 点赞量 |



- 返回字段

  |  字段名称  | 字段类型 |   说明   |
  | :--------: | :------: | :------: |
  |    sid     |  String  | 故事编号 |
  |   title    |  String  | 故事标题 |
  |  content   |   text   | 故事内容 |
  | createTime |  String  | 发布时间 |
  | updateTime |  String  | 修改时间 |
  |  storyTag  |  String  | 故事标签 |
  |  readNum   |   int    |  阅读量  |
  | commentNum |   int    |  评论量  |
  |  loveNum   |   int    |  点赞量  |
  |   author   |  String  | 故事作者 |



---

###### 查询所有故事

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /story/findAll
  ```



- 请求参数

  无

  

- 返回字段

  |  字段名称  | 字段类型 |   说明   |
  | :--------: | :------: | :------: |
  |    sid     |  String  | 故事编号 |
  |   title    |  String  | 故事标题 |
  |  content   |   text   | 故事内容 |
  | createTime |  String  | 发布时间 |
  | updateTime |  String  | 修改时间 |
  |  storyTag  |  String  | 故事标签 |
  |  readNum   |   int    |  阅读量  |
  | commentNum |   int    |  评论量  |
  |  loveNum   |   int    |  点赞量  |
  |   author   |  String  | 故事作者 |



#### 标签管理

##### 添加标签

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /tag/add
  ```



- 请求参数

  | 参数名称 | 参数类型 |   说明   |
  | :------: | :------: | :------: |
  |   tid    |  String  | 标签编号 |
  | tagName  |  String  | 标签名称 |



- 返回字段

  无



##### 修改标签

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /tag/update
  ```



- 请求参数

  | 参数名称 | 参数类型 |   说明   |
  | :------: | :------: | :------: |
  |   tid    |  String  | 标签编号 |
  | tagName  |  String  | 标签名称 |



- 返回字段

  无



##### 删除标签

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /tag/deleteByTid
  ```



- 请求参数

  | 参数名称 | 参数类型 |   说明   |
  | :------: | :------: | :------: |
  |   tid    |  String  | 标签编号 |



- 返回字段

  无



##### 查询标签

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /tag/findAll
  ```



- 请求参数

  无



- 返回字段

  | 字段名称 | 字段类型 |   说明   |
  | :------: | :------: | :------: |
  |   tid    |  String  | 标签编号 |
  | tagName  |  String  | 标签名称 |



#### 阅读管理

##### 添加阅读记录

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /read/add
  ```



- 请求参数

  | 参数名称 | 参数类型 |     说明     |
  | :------: | :------: | :----------: |
  |  readId  |  String  | 阅读记录编号 |
  |   sid    |  String  |   故事编号   |
  |  reader  |  String  |     读者     |
  | readTime |  String  |   阅读时间   |

  

- 返回字段

  无

  

##### 修改阅读记录

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /read/update
  ```



- 请求参数

  | 参数名称 | 参数类型 |     说明     |
  | :------: | :------: | :----------: |
  |  readId  |  String  | 阅读记录编号 |
  |   sid    |  String  |   故事编号   |
  |  reader  |  String  |     读者     |
  | readTime |  String  |   阅读时间   |

  

- 返回字段

  无



##### 删除阅读记录

###### 删除一条阅读记录

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /read/deleteByReadId
  ```



- 请求参数

  | 参数名称 | 参数类型 |     说明     |
  | :------: | :------: | :----------: |
  |  readId  |  String  | 阅读记录编号 |

  

- 返回字段

  无



###### 删除所有阅读记录

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /read/deleteByReader
  ```



- 请求参数

  | 参数名称 | 参数类型 | 说明 |
  | :------: | :------: | :--: |
  |  reader  |  String  | 读者 |

  

- 返回字段

  无



##### 查询阅读记录

###### 查询所有阅读记录

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /read/findByReader
  ```



- 请求参数

  | 参数名称 | 参数类型 | 说明 |
  | :------: | :------: | :--: |
  |  reader  |  String  | 读者 |

  

- 返回字段

  | 字段名称 | 字段类型 |     说明     |
  | :------: | :------: | :----------: |
  |  readId  |  String  | 阅读记录编号 |
  |   sid    |  String  |   故事编号   |
  |  reader  |  String  |     读者     |
  | readTime |  String  |   阅读时间   |



###### 按时间查询阅读记录

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /read/findByReadTime
  ```



- 请求参数

  | 参数名称 | 参数类型 |   说明   |
  | :------: | :------: | :------: |
  |  reader  |  String  |   读者   |
  | readTime |  String  | 阅读时间 |

  

- 返回字段

  | 字段名称 | 字段类型 |     说明     |
  | :------: | :------: | :----------: |
  |  readId  |  String  | 阅读记录编号 |
  |   sid    |  String  |   故事编号   |
  |  reader  |  String  |     读者     |
  | readTime |  String  |   阅读时间   |



#### 评论管理

##### 添加评论记录

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /comment/add
  ```



- 请求参数

  |    参数名称    | 参数类型 |     说明     |
  | :------------: | :------: | :----------: |
  |   commentId    |  String  | 评论记录编号 |
  |      sid       |  String  |   故事编号   |
  |   commenter    |  String  |    评论人    |
  | commentContent |   text   |   评论内容   |
  |  commentTime   |  String  |   评论时间   |
  |  commentFloor  |  String  |   评论楼层   |

  

- 返回字段

  无



##### 删除评论记录

###### 删除一条评论记录

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /comment/deleteByCommentId
  ```



- 请求参数

  | 参数名称  | 参数类型 |     说明     |
  | :-------: | :------: | :----------: |
  | commentId |  String  | 评论记录编号 |

  

- 返回字段

  无



###### 删除所有阅读记录

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /comment/deleteBySid
  ```



- 请求参数

  | 参数名称 | 参数类型 |   说明   |
  | :------: | :------: | :------: |
  |   sid    |  String  | 故事编号 |

  

- 返回字段

  无



##### 查询评论记录

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /comment/findBySid
  ```



- 请求参数

  | 参数名称 | 参数类型 |   说明   |
  | :------: | :------: | :------: |
  |   sid    |  String  | 故事编号 |

  

- 返回字段

  |    字段名称    | 字段类型 |     说明     |
  | :------------: | :------: | :----------: |
  |   commentId    |  String  | 评论记录编号 |
  |      sid       |  String  |   故事编号   |
  |   commenter    |  String  |    评论人    |
  | commentContent |   text   |   评论内容   |
  |  commentTime   |  String  |   评论时间   |
  |  commentFloor  |  String  |   评论楼层   |



#### 点赞管理

##### 添加点赞记录

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /love/add
  ```



- 请求参数

  | 参数名称 | 参数类型 |     说明     |
  | :------: | :------: | :----------: |
  |  loveId  |  String  | 点赞记录编号 |
  |   sid    |  String  |   故事编号   |
  |   fans   |  String  |    点赞人    |
  | loveTime |  String  |   点赞时间   |

  

- 返回字段

  无



##### 删除点赞记录

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /comment/delete
  ```



- 请求参数

  | 参数名称 | 参数类型 |   说明   |
  | :------: | :------: | :------: |
  |   sid    |  String  | 故事编号 |
  |   fans   |  String  |  点赞人  |

  

- 返回字段

  无



#### 关注管理

##### 添加关注

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /subscribe/add
  ```



- 请求参数

  |   参数名称    | 参数类型 |   说明   |
  | :-----------: | :------: | :------: |
  |     owner     |  String  |   主人   |
  |    member     |  String  |   成员   |
  | subscribeTime |  String  | 关注时间 |

  

- 返回字段

  无



##### 取消关注

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /subscribe/delete
  ```



- 请求参数

  | 参数名称 | 参数类型 | 说明 |
  | :------: | :------: | :--: |
  |  owner   |  String  | 主人 |
  |  member  |  String  | 成员 |

  

- 返回字段

  无



##### 查询关注

###### 查询所有关注

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /subscribe/findAll
  ```



- 请求参数

  | 参数名称 | 参数类型 | 说明 |
  | :------: | :------: | :--: |
  |  owner   |  String  | 主人 |

  

- 返回字段

  | 字段名称  | 字段类型 |   说明   |
  | :-------: | :------: | :------: |
  |   owner   |  String  |   主人   |
  |  member   |  String  |   成员   |
  | subscribe |  String  | 关注时间 |

  

###### 查询指定关注

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /subscribe/findByMember
  ```



- 请求参数

  | 参数名称 | 参数类型 | 说明 |
  | :------: | :------: | :--: |
  |  owner   |  String  | 主人 |
  |  member  |  String  | 成员 |

  

- 返回字段

  | 字段名称  | 字段类型 |   说明   |
  | :-------: | :------: | :------: |
  |   owner   |  String  |   主人   |
  |  member   |  String  |   成员   |
  | subscribe |  String  | 关注时间 |

  

#### 私信管理

##### 发送私信

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /letter/add
  ```



- 请求参数

  | 参数名称 | 参数类型 |   说明   |
  | :------: | :------: | :------: |
  |  sender  |  String  |  发送者  |
  | receiver |  String  |  接收者  |
  |          |   text   | 私信内容 |
  | sendTime |  String  | 发送时间 |

  

- 返回字段

  无



##### 查询私信

- 请求方式

  ```
  GET
  ```



- 请求URL

  ```
  /letter/findAll
  ```



- 请求参数

  | 参数名称 | 参数类型 |  说明  |
  | :------: | :------: | :----: |
  | receiver |  String  | 接收者 |

  

- 返回字段

  | 字段名称 | 字段类型 |   说明   |
  | :------: | :------: | :------: |
  |  sender  |  String  |  发送者  |
  | receiver |  String  |  接收者  |
  | content  |   text   | 私信内容 |
  | sendTime |  String  | 发送时间 |

  