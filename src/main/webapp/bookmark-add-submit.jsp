<%@ page import="com.example.seoulpublicwifi.dto.BookmarkDto" %>
<%@ page import="com.example.seoulpublicwifi.dao.BookmarkDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>와이파이 정보 구하기</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");

    String gid = request.getParameter("gid");
    String mgrNo = request.getParameter("mgrNo");

    // none 값일 경우 이전 페이지로 이동
    if (gid.equals("none")) {
        response.sendRedirect(request.getHeader("Referer"));
        return;
    }

    BookmarkDto bookmarkDto = new BookmarkDto();
    bookmarkDto.setGId(Integer.parseInt(gid));
    bookmarkDto.setMgrNo(mgrNo);

    BookmarkDao bookmarkDao = new BookmarkDao();
    bookmarkDao.upsert(bookmarkDto);
%>

<script>
    alert("북마크 데이터를 추가하였습니다.");
    location.href = "bookmark-list.jsp";
</script>
</body>
</html>
