
<%@ page language="java" deferredSyntaxAllowedAsLiteral="true" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 网页使用的语言 -->

<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户管理</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        function deleteUser(id){
            //用户安全提示
            if(confirm("您确定要删除吗？")){
                //访问路径
                location.href="${pageContext.request.contextPath}/delUserServlet?id="+id;
            }
        }
        window.onload = function() {
            //给删除选中按钮添加单击事件
            document.getElementById("delSelected").onclick = function () {
                if (confirm("您确定要删除选中条目吗？")) {

                    var flag = false;
                    //判断是否有选中条目
                    var cbs = document.getElementsByName("uid");
                    for (var i = 0; i < cbs.length; i++) {
                        if (cbs[i].checked) {
                            //有一个条目选中了
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {//有条目被选中
                        //表单提交
                        document.getElementById("form").submit();
                    }
                }
            }
        }
        document.getElementById("firstCb").onclick = function(){
            //2.获取下边列表中所有的cb
            var cbs = document.getElementsByName("uid");
            //3.遍历
            for (var i = 0; i < cbs.length; i++) {
                //4.设置这些cbs[i]的checked状态 = firstCb.checked
                cbs[i].checked = this.checked;
            }
        }
    </script>
</head>
<body>
<div>${user.name},欢迎您</div>
<div class="container">
    <h3 style="text-align: center">普通用户管理</h3>
    <div style="float: right " >
        <a class ="btn btn-primary" href="${pageContext.request.contextPath}/addUser.jsp">添加普通用户</a>
        <a class ="btn btn-primary" href="${pageContext.request.contextPath}/findCottonByPageServlet">返回</a>
    </div>
    <form id="form" action="${pageContext.request.contextPath}/delUserSelectServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox" id="firstCb"></th>
            <th>编号</th>
            <th>用户名</th>
            <th>密码</th>
            <th>姓名</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${users}" var="user" varStatus="s">
            <tr>
                <td><input type="checkbox" name="uid" value="${user.id}"></td>
                <td>${s.count}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.name}</td>
                <td>
                    <a class="btn btn-default btn-sm"  href="javascript:deleteUser(${user.id})">删除</a>
                </td>
            </tr>
        </c:forEach>
    </form>
</div>
</body>
</html>