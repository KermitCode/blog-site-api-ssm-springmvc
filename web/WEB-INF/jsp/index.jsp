<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" >
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" ></script>
    <title></title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="span12">
            <div>
                <ul class="breadcrumb">
                    <li>
                        <a href="http://www.04007.cn">04007主页</a> <span class="divider">/</span>
                    </li>
                    <li>
                        <a target="_blank" href="https://github.com/KermitCode/bolg-article-api-java-study">Github地址</a> <span class="divider">/</span>
                    </li>
                    <li>
                        <a href="#">04007.cn文章API接口</a> <span class="divider">/</span>
                    </li>
                    <li class="active">本页面及Api接口使用Spring、SpringMVC、Mybatis 即SSM组合开发</li>
                </ul>
            </div>

            <div class="page-header">
                <h2>
                    04007.cn Api接口文档(使用Spring SSM开发) <small>04007Api接口</small>
                </h2>
            </div>

            <h3>1：接口全局返回格式说明</h3>
            <p style="line-height:30px;">
                <strong>URI:</strong><em>请求URI，采用RestFul风格</em>  &nbsp;&nbsp;
                <strong>请求参数：</strong>参数说明。<br>
                接口统一返回格式：<pre>{
	"msg": "ok",        #接口响应提示：正常响应返回ok,异常时返回错误信息
	"requestTime": "2020-10-10 13:55:21",           #处理时间
	"code": 200,        #接口响应结果：正常响应返回0，异常时返回1或者其它约定的错误码
	"data": {           #返回的数据部分。
	        #数据部分
	},
	"requestId": "61fe353d5141459e8b77507887d92dae" #请求唯一ID
}</pre>
            </p>

            <h3>2：文章列表接口 </h3>
            <p style="line-height:30px;">
                <strong>URI:</strong><em>/article/list/{cateId}/{pageId}</em>  &nbsp;&nbsp;
                <strong>请求参数：</strong><em>int pageId</em>,请求第几页； <em>int cateId</em>,文章分类ID，见文章分类接口，默认为0即所有类文章。<br>
                <strong>接口示例：</strong><em><a target="_blank" href="http://api.04007.cn/article/list/0/1">http://api.04007.cn/article/list/0/1</a></em> <br>
                返回全站文章列表。result部分返回示例：
            <pre>{
	"msg": "ok",
	"requestTime": "2020-10-10 13:55:21",
	"code": 200,
	"data": {
		"article": [{
			"id": 848,      #文章ID
			"arCid": 1,     #文章分类ID
			"arTitle": "Elasticsearch：Fatal error: Uncaught Error: Class Psr\\Log\\NullLogger",     #文章标题
			"arTags": "Elasticsearch,错误,Uncaught Error: Class Psr\\Log\\NullLogger,Psr\\Log\\NullLogger",       #文章关键词
			"arText": "在测试环境执行后台任务的时候碰到报错：Fatalerror:UncaughtError:Cla法...",    #文章内容，已经html过滤和截取
			"arView": 837,  #文章浏览次数
			"arComments": 1,    #文章评论数
			"arDatetime": "2020-07-01 17:39:19" #文章发表时间
		}, ......]
	},
	"requestId": "61fe353d5141459e8b77507887d92dae"
}</pre>
            </p>

            <h3>3：文章详情接口 </h3>
            <p style="line-height:30px;">
                <strong>URI:</strong><em>/article/{id}</em>  &nbsp;&nbsp;
                <strong>请求参数：</strong><em>int id</em>,文章ID； <br>
                <strong>接口示例：</strong><em><a target="_blank" href="http://api.04007.cn/article/1">http://api.04007.cn/article/1</a></em> <br>
                返回具体文章详情。result部分返回示例：
            <pre>{
	"msg": "ok",
	"requestTime": "2020-10-10 13:55:21",
	"code": 200,
	"data": {
		"article": {        #未注释字段同上
			"id": 1,
			"arCid": 5,
			"arTitle": "我与我修身齐家治国平天下的人生理想",
			"arTags": "修身,齐家,治国,平天下",
			"arText": "《大学》有云：&nbsp;古之欲明明德于天下者，先治其国；欲治其国者，先始做吧！亡羊补牢为时不晚。",
            "arView": 9835,
            "arComments": 0,
                "arCate": {
                    "id": 5,            #文章分类ID
                    "className": "Book",    #文章分类名称
                    "classFname": "读书_程序手册_生活"  #分类名称涉及内容详细
                    },
            "arDatetime": "2015-03-30 10:02:12"
            }
        },
        "requestId": "b438e6373e244a2a8b9b241563404277"
    }</pre>
            </p>

            <h3>4：文章分类接口 </h3>
            <p style="line-height:30px;">
                <strong>URI:</strong><em>/category/list</em>  &nbsp;&nbsp;
                <strong>请求参数：</strong><em>无需传参</em><br>
                <strong>接口示例：</strong><em><a target="_blank" href="http://api.04007.cn/category/list">http://api.04007.cn/category/list</a></em> <br>
                返回全站文章分类数据。result部分返回示例：
            <pre>{
	"msg": "ok",
	"requestTime": "2020-10-10 14:13:44",
	"code": 200,
	"data": {
		"category": [{
			"id": 18,           #分类ID
			"className": "Java_Spring", #分类名称
			"classFname": "Java/Spring_MVC/Mybatis/Spring_Boot"  #分类名称涉及内容详细
		},....]
	},
	"requestId": "5656b27f89a2463fa5d0bbd55ffc2960"
}</pre>
            </p>

            <h3>5：评论接口 </h3>
            <p style="line-height:30px;">
                <strong>URI:</strong><em>/comment/list/{pageId}</em>  &nbsp;&nbsp;
                <strong>请求参数：</strong><em>int pageId</em> 返回第几页数据。<br>
                <strong>接口示例：</strong><em><a target="_blank" href="http://api.04007.cn/comment/list/1">http://api.04007.cn/comment/list/1</a></em> <br>
                分页返回评论列表。result部分返回示例：
            <pre>{
	"msg": "ok",
	"requestTime": "2020-10-10 14:13:44",
	"code": 200,
	"data": {
		"comment": [{
			"id": 264,
			"comUid": "us20200724112955-542",   #评论用户uid
			"comArid": 836,   #评论对应文章ID
			"comText": "楼主解决这个问题了么",    #评论详情
			"comTime": 1595568556,  #评论时间戳值
			"comIp": "114.251.122.178" #评论用户IP地址
		},.....]
	},
	"requestId": "f3f531d698214131824eaf85aecf8a48"
}</pre>
            </p>
        </div>
    </div>
    <p><br></p>
    <div class="span12 text-center">
        <hr>
        <p>
        <div class="span8 text-center">
            <em>04007.cn</em> Copyright © 2020-2025<strong></strong>
        </div>
        </p>
    </div>
</div>
</body>
</html>

