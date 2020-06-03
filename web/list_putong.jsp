
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
    <title>棉花生育期化控记录表</title>
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
        function exit() {
            if(confirm("您确定要退出登录吗？")){
                location.href="${pageContext.request.contextPath}/login.jsp";
            }

        }
    </script>

</head>
<body>
<div>${user.name},欢迎您</div>
    <h3 style="text-align: center">棉花生育期化控记录表</h3>
    <div>
        <h5>省份：${all.get(0).province}  市县：${all.get(0).city}    乡镇：${all.get(0).town}      村落:${all.get(0).village}
            品种：${all.get(0).breed}   密度：${all.get(0).density}    调查人:${all.get(0).investigator}    填表日期：${all.get(0).tabledate}  小区号：${all.get(0).xiaoqu}
        </h5>
    </div>
    <div style="float:left ">
        <form class="form-inline"action="${pageContext.request.contextPath}/findCottonByPageServlet" method="post">
            <div class="form-group">
                <label for="exampleInputName2">项目</label>
                <input type="text" name="project" value="${condition.project[0]}" class="form-control" id="exampleInputName2" >
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <div style="float: right " >
        <a class ="btn btn-primary" href="javascript:exit()" >退出登录</a>
    </div>
    <form id="form" action="${pageContext.request.contextPath}/delSelectServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="firstCb"></th>
                <th>编号</th>
                <th>项目</th>
                <th>药剂名称</th>
                <th>日期</th>
                <th>单位数量</th>

            </tr>
            <c:forEach items="${pb.list}" var="cotton" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="uid" value="${cotton.id}"></td>
                    <td>${s.count}</td>
                    <td>${cotton.project}</td>
                    <td>${cotton.drug}</td>
                    <td>${cotton.date}</td>
                    <td>${cotton.number}</td>
                </tr>
            </c:forEach>
        </table>
    </form>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <ul class="pagination">
                    <c:if test="${pb.currentPage == 1}">
                    <li class="disabled">
                        </c:if>
                        <c:if test="${pb.currentPage != 1}">
                    <li>
                        </c:if>
                        <a href="${pageContext.request.contextPath}/findCottonByPageServlet2?currentPage=${pb.currentPage - 1}&rows=5&name=${condition.gen[0]}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <c:forEach begin="1" end="${pb.totalPage}" var="i" >
                        <%--                totalCount 总记录数--%>
                        <%--                totalPAge  总页码 =总记录数%每页显示条数（rows）=0?总记录数/条数：总记录数/条数+1；        --%>
                        <%--                list  每一页输出的list集合--%>
                        <%--                currentPage 当前页码--%>

                        <c:if test="${pb.currentPage == i}">
                            <li class="active"><span href="${pageContext.request.contextPath}/findUserByPageServlet2?currentPage=${i}&rows=5&name=${condition.gen[0]}">${i}</span></li>
                        </c:if>
                        <c:if test="${pb.currentPage != i}">
                            <li><span href="${pageContext.request.contextPath}/findUserByPageServlet2?currentPage=${i}&rows=5&name=${condition.gen[0]}">${i}</span></li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${pb.currentPage == pb.totalPage}">
                    <li class="disabled">
                        </c:if>
                        <c:if test="${pb.currentPage != pb.totalPage}">
                    <li >
                        </c:if>

                        <span href="${pageContext.request.contextPath}/findUserByPageServlet2?currentPage=${pb.currentPage + 1}&rows=5&name=${condition.name[0]}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </span>
                    </li>
                    <span style="font-size:25px">
                    共${pb.totalCount}条记录,共${pb.totalPage}页
                </span>
                </ul>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>