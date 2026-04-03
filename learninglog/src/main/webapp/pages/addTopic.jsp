<%@ page import="com.learninglog.learninglogproject.user.model.User" %><%--
  Created by IntelliJ IDEA.
  User: ig_beebek
  Date: 4/3/2026
  Time: 8:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    User UserObj = (User) (User) session.getAttribute("user");
    int id = 0;
    if(UserObj != null){
        id = UserObj.getId();
    }
%>
<body>
    <form method="post" action="topic">
        <input type="hidden" value="add" name="action">
        <label>UserId</label>
        <input type="text" value="<%=id%>" name="user_Id">
        <br>
        <label>Topic Name</label>
        <input type="text" name = "topicName">
        <button>Submit</button>
    </form>
</body>
</html>
