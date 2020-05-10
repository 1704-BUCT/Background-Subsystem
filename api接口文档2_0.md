

# api接口文档2020-5-9

#### 1.前言

1. 服务器地址：39.97.241.101
2. 用户名：Administrator
3. 密码：cs1704CS1704
4. （如果密码被和谐了来私聊我）
5. 目前服务器上已配置apach-tomcat、mysql。已有部分数据。
6. 以http://+ip+port+url的格式访问，如：http://39.97.241.101:8080/museum/{id}
7. 用url里用大括号{}括起来的表示直接写数据，如：http://39.97.241.101:8080/museum/1
8. 这里序号都从1开始，没有0号！
9. 返回数据里

#### 2.接口表

写完感觉服务和接口可能存在不对应的关系，请各组检查一下有没有自己需要的接口！！

2020.4.30	删去了大量不需要的接口，修改了很多

2020.5.9      修改



## Museum

 /museum/findByName/{name}
| 用途                     | 请求方式 | 必填       | 返回       | 备注 |
| ------------------------ | -------- | ---------- | ---------- | ---- |
| 获取一个博物馆的基本信息 | get      | 博物馆名称 | 单个博物馆 |      |

```
	{
		mid:1
		imgurl:
		address:
		avgstar:(0-5)
		avgexhibitionstar:(0-5)
		avgenvironmentstar:(0-5)
		avgservicestar:(0-5)
		introduction:
		name:
		opentime:
		mobile:
		}
```



/museum/findAll/sortByAvgstar

| 用途                     | 请求方式 | 必填 | 返回       | 备注                        |
| ------------------------ | -------- | ---- | ---------- | --------------------------- |
| 获取所有博物馆的基本信息 | get      |      | 所有博物馆 | 自动分页、按avgstar降序排列 |

```
[
	{
		mid:1,
		name:1,
		imgurl:图片 1,
		avgstar:博物馆分数1
		}，
		{
		mid:2,
		name:2,
		imgurl:图片2，
		avgstar:博物馆分数2	
	}...
]
```



/museum/findAll/sortByAvgexhibitionstar

| 用途                     | 请求方式 | 必填 | 返回       | 备注                                  |
| ------------------------ | -------- | ---- | ---------- | ------------------------------------- |
| 获取所有博物馆的基本信息 | get      |      | 所有博物馆 | 自动分页、按avgexhibitionstar降序排列 |

```
[
	{
		mid:1,
		name:1,
		imgurl:图片 1,
		avgstar:博物馆分数1
		}，
		{
		mid:2,
		name:2,
		imgurl:图片2，
		avgstar:博物馆分数2	
	}...
]
```



/museum/findAll/sortByAvgenvironmentstar

| 用途                     | 请求方式 | 必填 | 返回       | 备注                                   |
| ------------------------ | -------- | ---- | ---------- | -------------------------------------- |
| 获取所有博物馆的基本信息 | get      |      | 所有博物馆 | 自动分页、按avgenvironmentstar降序排列 |

```
[
	{
		mid:1,
		name:1,
		imgurl:图片 1,
		avgstar:博物馆分数1
		}，
		{
		mid:2,
		name:2,
		imgurl:图片2，
		avgstar:博物馆分数2	
	}...
]
```



/museum/findAll/sortByAvgservicestar

| 用途                     | 请求方式 | 必填 | 返回       | 备注                               |
| ------------------------ | -------- | ---- | ---------- | ---------------------------------- |
| 获取所有博物馆的基本信息 | get      |      | 所有博物馆 | 自动分页、按avgservicestar降序排列 |

```
[
	{
		mid:1,
		name:1,
		imgurl:图片 1,
		avgstar:博物馆分数1
		}，
		{
		mid:2,
		name:2,
		imgurl:图片2，
		avgstar:博物馆分数2	
	}...
]
```



/museum/findAll/sortByExhibitionNums

| 用途                               | 请求方式 | 必填 | 返回       | 备注                       |
| ---------------------------------- | -------- | ---- | ---------- | -------------------------- |
| 按博物馆拥有的展览个数从大到小排序 | get      |      | 博物馆列表 | 自动分页、按展览数降序排列 |

```
[
	{
		mid:1,
		name:1,
		imgurl:#返回图片在服务器的路径
		avgstar:博物馆分数1
		}，
		{
		mid:2,
		name:2,
		imgurl:#返回图片在服务器的路径
		avgstar:博物馆分数2	
	}...
]
```



## Exhibition

/exhibition/findByEid/{eid}

| 用途             | 请求方式 | 必填   | 返回 | 备注 |
| ---------------- | -------- | ------ | ---- | ---- |
| 获取单个展览信息 | get      | 展览id |      |      |

```
{
	"eid":0,
	"name":
	"imgurl":#返回图片在服务器的路径
	"mname":所属博物馆名字,                 
	"introduction":
}
```



/exhibition/findByName/{name}

| 用途                   | 请求方式 | 必填     | 返回 | 备注 |
| ---------------------- | -------- | -------- | ---- | ---- |
| 根据展览的name模糊查询 | get      | 展览name |      |      |

```
[
	{
	"eid":0,
	"name":
	"imgurl":"",
	"mname":所属博物馆名字,                 
	"introduction":
	},
	{
	"eid":0,
	"name":
	"imgurl":"",
	"mname":所属博物馆名字,                 
	"introduction":
	}
]
```



/exhibition/findAll

| 用途         | 请求方式 | 必填 | 返回 | 备注                   |
| ------------ | -------- | ---- | ---- | ---------------------- |
| 返回所有展览 | get      |      | List | 不需要introduction字段 |

```
[
	{
	"eid":0,
	"name":
	"imgurl":"",
	"mname":所属博物馆名字
	},
	{
	"eid":0,
	"name":
	"imgurl":"",
	"mname":所属博物馆名字
	}
]
```



/exhibition/findByMname/{mname}

| 用途                                     | 请求方式 | 必填       | 返回 | 备注                   |
| ---------------------------------------- | -------- | ---------- | ---- | ---------------------- |
| 根据所属博物馆名字获取一博物馆的所有展览 | get      | 博物馆名字 | List | 不需要introduction字段 |

```
[
	{
	"eid":0,
	"name":
	"imgurl":"",
	"mname":所属博物馆名字
	},
	{
	"eid":0,
	"name":
	"imgurl":"",
	"mname":所属博物馆名字
	}
]
```



## User

/user/uploadExhibitionExplanation

| 用途         | 请求方式 | 必填                                               | 返回        | 备注                                    |
| ------------ | -------- | -------------------------------------------------- | ----------- | --------------------------------------- |
| 上传展览讲解 | post     | img（多张）、sound（一个）、introduction、uid、eid | status：0/1 | 直接存到展览讲解表-exhibition_explation |



/user/uploadCollectionExplanation

同上



/user/getExhibitionExplanation/{uid}/{eid}
| 用途                         | 请求方式 | 必填     | 返回 | 备注 |
| ---------------------------- | -------- | -------- | ---- | ---- |
| 返回该用户对该展览的展览讲解 | get      | uid、eid |      |      |

```
[
	{
	"eid":0,
	"uid":
	"imgurl":"",
	"soundurl":
	"introduction"
	},
	{
	"eid":0,
	"uid":
	"imgurl":"",
	"soundurl":
	"introduction"
	}...
]
```



/user/login

| 用途 | 请求方式 | 必填              | 返回 | 备注                                |
| ---- | -------- | ----------------- | ---- | ----------------------------------- |
| 登录 | post     | account、password | 0/1  | 用户登录后、要将登录数据写到log表里 |



/user/modifyPassword

| 用途     | 请求方式 | 必填                      | 返回 | 备注                  |
| -------- | -------- | ------------------------- | ---- | --------------------- |
| 修改密码 | post     | account、password、新密码 | 0/1  | 要将修改信息写进log表 |




## Collection

/collection/findByCid/{cid}

| 用途             | 请求方式 | 必填   | 返回 | 备注 |
| ---------------- | -------- | ------ | ---- | ---- |
| 获取单个藏品信息 | get      | 藏品id |      |      |

```
{
	"cid":0,
	"name":
	"imgurl":#返回图片在服务器的路径
	"mname":所属博物馆名字,                 
	"introduction":
}
```



collection/findByName/{name}

| 用途             | 请求方式 | 必填     | 返回 | 备注 |
| ---------------- | -------- | -------- | ---- | ---- |
| 根据name模糊查询 | get      | 藏品name |      |      |

```
[
	{
	"cid":0,
	"name":
	"imgurl":"",
	"mname":所属博物馆名字,                 
	"introduction":
	},
	{
	"cid":0,
	"name":
	"imgurl":"",
	"mname":所属博物馆名字,                 
	"introduction":
	}
]
```



/collection/findAll

| 用途         | 请求方式 | 必填 | 返回 | 备注                   |
| ------------ | -------- | ---- | ---- | ---------------------- |
| 返回所有展览 | get      |      | List | 不需要introduction字段 |

```
[
	{
	"cid":0,
	"name":
	"imgurl":"",
	"mname":所属博物馆名字
	},
	{
	"cid":0,
	"name":
	"imgurl":"",
	"mname":所属博物馆名字
	}
]
```



/collection/findByMname/{mname}

| 用途                                     | 请求方式 | 必填       | 返回 | 备注                   |
| ---------------------------------------- | -------- | ---------- | ---- | ---------------------- |
| 根据所属博物馆名字获取一博物馆的所有展览 | get      | 博物馆名字 | List | 不需要introduction字段 |

```
[
	{
	"cid":0,
	"name":
	"imgurl":"",
	"mname":所属博物馆名字
	},
	{
	"cid":0,
	"name":
	"imgurl":"",
	"mname":所属博物馆名字
	}
]
```



## Education

/education/findByEid/{eid}

| 用途                 | 请求方式 | 必填 | 返回 | 备注 |
| -------------------- | -------- | ---- | ---- | ---- |
| 获取单个教育活动信息 | get      | eid  |      |      |

```
{
	"eid":0,
	"name":
	"imgurl":#返回图片在服务器的路径
	"mname":所属博物馆名字,                 
	"introduction":
}
```



/education/findByName/{name}

| 用途                   | 请求方式 | 必填 | 返回 | 备注 |
| ---------------------- | -------- | ---- | ---- | ---- |
| 根据展览的name模糊查询 | get      | name |      |      |

```
[
	{
	"eid":0,
	"name":
	"imgurl":"",
	"mname":所属博物馆名字,                 
	"introduction":
	},
	{
	"eid":0,
	"name":
	"imgurl":"",
	"mname":所属博物馆名字,                 
	"introduction":
	}
]
```



/education/findAll

| 用途     | 请求方式 | 必填 | 返回 | 备注                   |
| -------- | -------- | ---- | ---- | ---------------------- |
| 返回所有 | get      |      | List | 不需要introduction字段 |

```
[
	{
	"eid":0,
	"name":
	"imgurl":"",
	"mname":所属博物馆名字
	},
	{
	"eid":0,
	"name":
	"imgurl":"",
	"mname":所属博物馆名字
	}
]
```



/education/getByMname/{mname}

| 用途                                         | 请求方式 | 必填       | 返回 | 备注                   |
| -------------------------------------------- | -------- | ---------- | ---- | ---------------------- |
| 根据所属博物馆名字获取一博物馆的所有教育活动 | get      | 博物馆名字 | List | 不需要introduction字段 |

```
[
	{
	"eid":0,
	"name":
	"imgurl":"",
	"mname":所属博物馆名字
	},
	{
	"eid":0,
	"name":
	"imgurl":"",
	"mname":所属博物馆名字
	}
]
```



## News

/news/getByMname/{mname}

| 用途                   | 请求方式 | 必填       | 返回 | 备注 |
| ---------------------- | -------- | ---------- | ---- | ---- |
| 根据博物馆名字返回新闻 | get      | 博物馆名字 |      |      |

```
{
	nid:
	title:
	extract:
	content:
	url:
	imgurl:
	author:
	releasetime:
	nature:
	sign:
}
```



/news/findAll

| 用途         | 请求方式 | 必填 | 返回 | 备注     |
| ------------ | -------- | ---- | ---- | -------- |
| 返回所有新闻 | get      |      | List | 自动分页 |

```
[
	{
	nid:
	title:
	extract:
	content:
	url:
	imgurl:
	author:
	releasetime:
	nature:
	sign:
	},
	{
	nid:
	title:
	extract:
	content:
	url:
	imgurl:
	author:
	releasetime:
	nature:
	sign:
   }...
]
```



/news/searchByMname/{mname}

| 用途         | 请求方式 | 必填       | 返回 | 备注 |
| ------------ | -------- | ---------- | ---- | ---- |
| 根据名字搜索 | get      | 博物馆名字 | List |      |

返回数据同上



/news/curlNews/{kw}/{day}/{waitminute}

| 用途                                                         | 请求方式 | 必填              | 返回              | 备注 |
| ------------------------------------------------------------ | -------- | ----------------- | ----------------- | ---- |
| （不公开）按关键字kw、爬取天数day、等待分钟数（waitminute）进行新闻的爬取。 | get      | kw,day,waitminute | 新闻爬取成功/失败 |      |



/news/curlNewsFixed/{day}/{eachwaitminute}

| 用途                                                         | 请求方式 | 必填                | 返回     | 备注 |
| ------------------------------------------------------------ | -------- | ------------------- | -------- | ---- |
| （不公开）关键字为内置的博物馆名字，指定每一个博物馆的爬取时间。目前有132个博物馆，至少要爬132分钟。 | get      | day,eachawaitminute | 爬取完毕 |      |





## Star

/star/uploadStarCollection

| 用途     | 请求方式 | 必填          | 返回 | 备注 |
| -------- | -------- | ------------- | ---- | ---- |
| 收藏藏品 | post     | uid、star_cid | 1/0  |      |


/star/uploadStarExhibition

| 用途     | 请求方式 | 必填          | 返回 | 备注 |
| -------- | -------- | ------------- | ---- | ---- |
| 收藏展览 | post     | uid、star_eid | 1/0  |      |


/star/uploadStarEducation

| 用途     | 请求方式 | 必填          | 返回 | 备注 |
| -------- | -------- | ------------- | ---- | ---- |
| 收藏教育活动 | post     | uid、star_eid | 1/0  |      |


/star/uploadStarNews

| 用途     | 请求方式 | 必填          | 返回 | 备注 |
| -------- | -------- | ------------- | ---- | ---- |
| 收藏展览 | post     | uid、star_eid | 1/0  |      |


/star/findStarCollection/{uid}

| 用途     | 请求方式 | 必填          | 返回 | 备注 |
| -------- | -------- | ------------- | ---- | ---- |
| 获取用户收藏的藏品 | get     | uid | List |      |
```
[
	{
	"cid": ,
	“uid”:
	},
	{
	"cid": ,
	“uid”:
	}
]
```



/star/findStarExhibition/{uid}

| 用途     | 请求方式 | 必填          | 返回 | 备注 |
| -------- | -------- | ------------- | ---- | ---- |
| 获取用户收藏的展览 | get     | uid | List |      |
```
[
	{
	"eid": ,
	“uid”:
	},
	{
	"eid": ,
	“uid”:
	}
]
```



/star/findStarEducation/{uid}

| 用途     | 请求方式 | 必填          | 返回 | 备注 |
| -------- | -------- | ------------- | ---- | ---- |
| 获取用户收藏的教育活动 | get     | uid | List |      |
```
[
	{
	"eid": ,
	“uid”:
	},
	{
	"eid": ,
	“uid”:
	}
]
```



/star/isStarEducation/{uid}/{eid}

| 用途     | 请求方式 | 必填          | 返回 | 备注 |
| -------- | -------- | ------------- | ---- | ---- |
| 教育活动是否被收藏 | get     | uid、eid | 0/1 |      |


/star/isStarCollection/{uid}/{cid}

| 用途           | 请求方式 | 必填     | 返回 | 备注 |
| -------------- | -------- | -------- | ---- | ---- |
| 藏品是否被收藏 | get      | uid、cid | 0/1  |      |


/star/isStarExhibition/{uid}/{eid}

| 用途           | 请求方式 | 必填     | 返回 | 备注 |
| -------------- | -------- | -------- | ---- | ---- |
| 展览是否被收藏 | get      | uid、eid | List |      |


## Log

/logUserAll

| 用途                   | 请求方式 | 必填 | 返回 | 备注 |
| ---------------------- | -------- | ---- | ---- | ---- |
| 在后台网页显示所有日志 | get      |      |      |      |


## Comment

/comment/findByMid/{mid}
| 用途 |请求方式  |必填  |返回  |备注  |
| -----| -------- | ---- | ---- | ---- |
| 显示一个博物馆的所有评论 | get | mid | List | 按时间排好序，前面是最近评论的 |

```
            [
		      {uid:评论用户名字,
		      avatarurl:评论用户头像 
	                      time:评论时间,
		      environmentstar:,
		      exhibitionstar:,
		      servicestar,	
		      content:评论内容
		      }，
		      {...},
		      {...}
		   ]
```

/comment/already/{uid}/{mid}
| 用途 |请求方式  |必填  |返回  |备注  |
| ---- | -------- | ---- | ---- | ---- |
| 用户是否已经给某博物馆评论过 | get |uid, mid |0,1| 0为未评论过|

/comment/update
| 用途 |请求方式  |必填  |返回  |备注  |
| -----| -------- | ---- | ---- | ---- |
| 上传打分和评论(仅对博物馆) | post|formbody |0,1| 1为评论成功，0为评论失败|
```
{mid:1,
account:"xxx",
content:"haha",
environmentstar:4.5,
exhibitionstar:4.5,
servicestar:3.5,
time:"2019-02-29"}
````