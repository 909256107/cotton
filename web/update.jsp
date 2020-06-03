<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- HTML5文档-->
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
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
    <title>修改数据</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <center><h3>修改数据</h3></center>
    <form action="${pageContext.request.contextPath}/updateCottonServlet" method="post">
<%--        隐藏域提交id--%>
        <input type="hidden" name="id" value="${cottons.id}">
        <div class="form-group">
            <label for="project">项目：</label>
            <input type="text" class="form-control"  id="project" name="project" placeholder="请输入要修改的项目" value="${cottons.project}">
        </div>
        <div class="form-group">
            <label for="drug">药剂名称：</label>
            <input type="text" class="form-control" id="drug" name="drug" value="${cottons.drug}" placeholder="请输入药剂名称">
        </div>
        <div class="form-group">
            <label for="date">日期：</label>
            <input type="text" class="form-control" id="date" value="${cottons.date}" name="date" placeholder="请输入修改的日期"/>
        </div>

        <div class="form-group">
            <label for="number">单位数量：</label>
            <input type="text" class="form-control" id="number" name="number" value="${cottons.number}" placeholder="请输入要修改的日期"/>
        </div>
        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <a href="update.jsp" class="btn btn-primary">返回</a>
        </div>
    </form>
</div>
</body>
</html>