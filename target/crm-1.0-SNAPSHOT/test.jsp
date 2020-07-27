<%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2020/7/26
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
$.ajax({
url:"",
data:{

},
type:"",
dataType:"json",
success:function (data) {

}
})

//创建时间：当前系统时间
String createTime = DateTimeUtil.getSysTime();
//创建人：当前登录用户
String createBy = ((User) req.getSession().getAttribute("user")).getName();
</body>
</html>
