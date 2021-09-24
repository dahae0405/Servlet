<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 1. jsp에 내장객체 지원. <=> import 없이 사용 가능.
    // 2. 트렌젝션 저장은 1건 단위.

    // 1) 받아서 1건을 저장. <=> JSP에서 지원하는 Java <=> 컨트롤러단.
    MemberRepository memberRepository = MemberRepository.getInstance();
    String username = request.getParameter("username");

    int age = Integer.parseInt( request.getParameter("age") );
    Member member = new Member( username, age );
    memberRepository.save( member );

    // 2) JSP에서 지원하는 html
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/jsp/members.jsp" method="post">
        username: <%= username %>
        age: <%= age %>
    </form>
</body>
</html>