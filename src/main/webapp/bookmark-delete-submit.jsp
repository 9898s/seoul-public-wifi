<%@ page import="com.example.seoulpublicwifi.dao.BookmarkDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>와이파이 정보 구하기</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");

    String id = request.getParameter("id");

    BookmarkDao bookmarkDao = new BookmarkDao();
    bookmarkDao.delete(Integer.parseInt(id));
%>

<script>
    alert("북마크 데이터를 삭제하였습니다.");
    location.href = "bookmark-list.jsp";
</script>
</body>
</html>
