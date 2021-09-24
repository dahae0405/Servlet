<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 1) 컨트롤러단 <=> 비즈니스 로직.
    MemberRepository memberRepository = MemberRepository.getInstance();
    List<Member> members = memberRepository.findAll();

    // 2) JSP에서 지원하는 html
%>


<html>
<head>
    <meta charset=\"UTF-8\">
    <title>Title</title>
    </head>
    <body>
    <a href=\"/index.html\">메인</a>
    <table>
        <thead>
            <th>id</th>
            <th>username</th>
            <th>age</th>
            </thead>
            <tbody>
<% for (Member member : members) {
    out.write("    <tr>");
    out.write("        <td>" + member.getUsername() + "</td>");
    out.write("        <td>" + member.getAge() + "</td>");
    out.write("    </tr>");
}
%>
        </tbody>
    </table>
    </body>
</html>