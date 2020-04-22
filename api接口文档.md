### api接口文档

#### 1.前言

1. 服务器地址：39.97.241.101

2. 用户名：Administrator

3. 密码：cs1704CS1704

4. （如果密码被和谐了来私聊我）

5. 目前服务器上已配置apach-tomcat、mysql。已有部分数据。
6. url为服务器上文件夹的地址，以http://+ip+port+url的格式访问，如：http://39.97.241.101:8080/museum/id

#### 2.接口表

写完感觉服务和接口可能存在不对应的关系，请各组检查一下有没有自己需要的接口！！

| 功能               | 请求类型 | url  | 必填参数                                                     | 返回类型 | 返回数据示例                                                 | 疑问栏                                                       |
| ------------------ | -------- | ---- | ------------------------------------------------------------ | -------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 获取博物馆基本信息 | get      |      | mid（博物馆id，一次请求一个博物馆信息）                      | json     | {<br />"mid":0,<br />"name":"博物馆0",<br />“introduction”:“2333”,<br />“opentime”:“8:00am-5:00pm”,<br />"collection":"阿姆斯特朗炮、大力丸",<br />"lng":116.34528,<br />"lat":39.21028<br />} | 对于collection的返回值要不要返回藏品id？<br />这个接口存在的必要性？ |
| 搜索博物馆         | get      |      | sreachkw(搜索关键字)                                         | json     | [<br />{<br />"mid":0,<br />"name":"博物馆0",<br />“introduction”:“2333”,<br />“opentime”:“8:00am-5:00pm”,<br />"collection":"阿姆斯特朗炮、大力丸",<br />"lng":116.34528,<br />"lat":39.21028<br />},<br />{<br />"mid":1,<br />"name":"博物馆1",<br />“introduction”:“666”,<br />“opentime”:“8:00am-5:00pm”,<br />"collection":"青龙图",<br />"lng":null,<br />"lat":null<br />}<br />] |                                                              |
| 获取展览信息       | get      |      | eid                                                          | json     | {<br />"eid":0,<br />"mid":0,<br />"name":"震惊！博物馆0的惊天藏品！",<br />"time":"2020-04-29, 8:00am",<br />"address":"北京三和胡同996号",<br />"introduction":"这个展览由ACM大牛举办，为世界第一届ACM展览会。到场的嘉宾有AAA，BBB……"<br />} | 接口存在的必要性？                                           |
| 搜索展览基本信息   | get      |      | searchkw(搜索关键字)                                         | json     | [<br />{<br />"eid":0,<br />"mid":0,<br />"name":"震惊！博物馆0的惊天藏品！",<br />"time":"2020-04-29, 8:00am",<br />"address":"北京三和胡同996号",<br />"introduction":"这个展览由ACM大牛举办，为世界第一届ACM展览会。到场的嘉宾有AAA，BBB……"<br />},<br />{<br />"eid":1,<br />"mid":1,<br />"name":"balabala",<br />"time":null,<br />"address":null,<br />"introduction":null<br />}<br />] | 这个展览的时间格式要商量一下                                 |
| 获取新闻           | get      |      | nid（新闻id）                                                | json     | {<br />“nid”:0,<br />"title":"233博物馆将在--进行维修，预计闭馆一个月",<br />"extract":"3333333",<br />"content":"五百字五百字",<br />"url":null,<br />"imgurl":null,<br />"author":"大理寺猫奴",<br />"releasetime":"2020-04-21",<br />"modifytime":null,<br />"status":null,<br />"nature":0,<br />"commentstatus":0<br />} | modifytime、url、imgurl、status（新闻状态，是否正常）字段需要商讨其存在必要性 |
| 搜索新闻           | get      |      | searchkw(搜索关键字)                                         | json     | [<br />{<br />“nid”:0,<br />"title":"233博物馆将在--进行维修，预计闭馆一个月",<br />"extract":"3333333",<br />"content":"五百字五百字",<br />"url":null,<br />"imgurl":null,<br />"author":"大理寺猫奴",<br />"releasetime":"2020-04-21",<br />"modifytime":null,<br />"status":null,<br />"nature":0,<br />"commentstatus":0<br />}<br />] |                                                              |
| 爬取指定时间的新闻 | get      |      | ！！由管理员指定时间，不需要新闻子系统发起请求               | json     | {<br />"starttime":"2020-03-01",<br />"endtime":"2021-03-01"<br />} | 后台指定了时间之后，如何让新闻子系统进行爬取，并且返回数据   |
| 按博物馆显示新闻   | get      |      | mid(博物馆id)                                                | json     | [<br />{<br />“nid”:0,<br />"title":"233博物馆将在--进行维修，预计闭馆一个月",<br />"extract":"3333333",<br />"content":"五百字五百字",<br />"url":null,<br />"imgurl":null,<br />"author":"大理寺猫奴",<br />"releasetime":"2020-04-21",<br />"modifytime":null,<br />"status":null,<br />"nature":0,<br />"commentstatus":0<br />}<br />] |                                                              |
| 获取最新的新闻     | get      |      | 无                                                           | json     | [<br />{<br />“nid”:0,<br />"title":"233博物馆将在--进行维修，预计闭馆一个月",<br />"extract":"3333333",<br />"content":"五百字五百字",<br />"url":null,<br />"imgurl":null,<br />"author":"大理寺猫奴",<br />"releasetime":"2020-04-21",<br />"modifytime":null,<br />"status":null,<br />"nature":0,<br />"commentstatus":0<br />}<br />] |                                                              |
| 按博物馆搜索讲解   | get      |      | mid（博物馆id）                                              | json     |                                                              | 讲解表格式未定（文字、音频、用户id、博物馆id、藏品id、发布时间、讲解赞数） |
| 按用户返回讲解     | get      |      | uid（用户id）                                                | json     |                                                              | 讲解表格式未定                                               |
| 按关键字搜索讲解   | get      |      | searchkw（搜索关键字）                                       | json     |                                                              | 讲解格式未定                                                 |
| 按博物馆返回评论   | get      |      | mid（博物馆id）                                              | json     | [<br />{<br />"cid":0,<br />"uid":2,<br />"mid":1,<br />"content":"很好玩，下次还去。",<br />"url":null,<br />"imgurl":null<br />}<br />] | url和imgurl字段也许不需要。（展览、新闻、讲解也要评论吗？）  |
| 修改某条评论       | put      |      | cid（评论id）,content(评论正文)                              | json     | {<br />"cid":0,<br />"state":1<br />}                        | state：1表示修改成功，0表示修改失败。在数据库中进行修改      |
| 删除某条评论       | delete   |      | cid                                                          | json     | {<br />"cid":0,<br />"state":1<br />}                        | state：1表示修改成功，0表示修改失败。删除其实是将评论的状态变为不可展示 |
| 添加评论           | post     |      | 【mid，eid，nid，aid（讲解id）】，uid，content。             | json     | {<br />"cid":100,<br />"state":1<br />}                      | cid:表示在数据库中的标号，state表示是否添加成功。【mid, eid, nid, aid】需要讨论，看是只要博物馆的评论，还是展览、新闻、讲解都要评论 |
| 搜索评论           | get      |      | searchkw（搜索关键字）                                       | json     | [<br />{<br />"cid":0,<br />"uid":2,<br />"mid":1,<br />"content":"很好玩，下次还去。",<br />"url":null,<br />"imgurl":null<br />}<br />] | 用在哪个界面？                                               |
| 给博物馆打分       | post     |      | uid,mid,cid,exhibitionstar(展览分数1-5)，servicestar（服务分数1-5），environmentstar（环境分数1-5） | json     | {<br />"state":1<br />}                                      | 1:成功，0：失败                                              |
| 获取博物馆平均分数 | get      |      | mid                                                          | json     | {<br />“exhibitionstar”:4,<br />"servicestar":4,<br />"environmentstar":4<br />} |                                                              |

