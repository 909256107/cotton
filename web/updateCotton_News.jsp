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
    <form action="${pageContext.request.contextPath}/updateCotton_NewsServlet" method="post">
<%--        隐藏域提交id--%>
        <input type="hidden" name="id" value="${cn.id}">
        <div class="form-group">
            <label for="province">省份：</label>
            <input type="text" class="form-control"  id="province" name="province" placeholder="请输入要修改的省份" value="${cn.province}">
        </div>
        <div class="form-group">
            <label for="city">市县：</label>
            <input type="text" class="form-control" id="city" name="city" value="${cn.city}" placeholder="请输入城镇名称">
        </div>
        <div class="form-group">
            <label for="town">乡村：</label>
            <input type="text" class="form-control" id="town" value="${cn.town}" name="town" placeholder="请输入"/>
        </div>

        <div class="form-group">
            <label for="village">村落：</label>
            <input type="text" class="form-control" id="village" name="village" value="${cn.village}" placeholder="请输入要修改的日期"/>
        </div>
    <div class="form-group">
        <label for="breed">品种：</label>
        <input type="text" class="form-control" id="breed" name="breed" value="${cn.breed}" placeholder="请输入要修改的品种"/>
    </div>
    <div class="form-group">
        <label for="density">密度：</label>
        <input type="text" class="form-control" id="density" name="density" value="${cn.density}" placeholder="请输入要修改的密度"/>
    </div>
    <div class="form-group">
        <label for="investigator">调查人：</label>
        <input type="text" class="form-control" id="investigator" name="investigator" value="${cn.investigator}" placeholder="请输入要修改的调查人"/>
    </div>
    <div class="form-group">
        <label for="tabledate">填表日期：</label>
        <input type="text" class="form-control" id="tabledate" name="tabledate" value="${cn.tabledate}" placeholder="请输入要修改的填表日期"/>
    </div>
    <div class="form-group">
        <label for="xiaoqu">小区：</label>
        <input type="text" class="form-control" id="xiaoqu" name="xiaoqu" value="${cn.xiaoqu}" placeholder="请输入要修改的小区"/>
    </div>
        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <a href="${pageContext.request.contextPath}/findCottonByPageServlet" class="btn btn-primary">返回</a>
        </div>
    </form>
</div>
</body>
</html>