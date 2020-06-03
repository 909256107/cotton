<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>管理员注册</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        //切换验证码
        function refreshCode(){
            //1.获取验证码图片对象
            var vcode = document.getElementById("vcode");
            //2.设置其src属性，加时间戳
            vcode.src = "${pageContext.request.contextPath}/checkCodeServlet?time="+new Date().getTime();
        }
        function login(){
            //得到name输入框对象
            var name = document.getElementById("name");
            //判断输入框是否有内容
            if(name.value.length==0){
                confirm("用户名不能为空");
                return false;
            }
            var pass = document.getElementById("pass");
            if(pass.value.length==0){
                confirm("密码不能为空");
                return false;
            }
            return true;
        }
    </script>
</head>
<body >
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">添加数据</h3>
    <form action="${pageContext.request.contextPath}/addCottonServlet" method="post" onsubmit="return login()">
        <div class="form-group">
            <label for="project">项目名称：</label>
            <input type="text" class="form-control" id="project" name="project" placeholder="请输入项目名">
        </div>
        <div class="form-group">
            <label for="drug">药剂名称</label>
            <input type="text" class="form-control" id="drug" name="drug" placeholder="请输入药剂名称"/>
        </div>
        <div class="form-group">
            <label for="date">日期</label>
            <input type="text" class="form-control" id="date" name="date" placeholder="请输入日期"/>
        </div>
        <div class="form-group">
            <label for="number">单位数量</label>
            <input type="text" class="form-control" id="number" name="number" placeholder="请输入单位数量"/>
        </div>
        <div class="form-inline">
            <label for="vcode">验证码：</label>
            <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码" style="width: 120px;"/>
            <a href="javascript:refreshCode();">
                <img src="${pageContext.request.contextPath}/checkCodeServlet" title="看不清点击刷新" id="vcode"/>
            </a>
        </div>
        <hr/>
        <div class="form-group" style="text-align: center;">
            <input class="btn btn btn-primary" type="submit" value="提交">
            <input class="btn btn-default" type="reset" value="重置" />
            <a href="${pageContext.request.contextPath}/findCottonByPageServlet" class="btn btn-primary">返回</a>
        </div>
    </form>
    <!-- 出错显示的信息框 -->
    <div class="alert alert-warning alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" >
            <span>&times;</span>
        </button>
        <strong>${login_msg}</strong>
    </div>
</div>
</body>
</html>