<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--
    반복문의 변경 (
        - jsp에서 제공하는 기본 태크 >
            ㄴ 자바  => 코드 => < %로 접근
            ㄴ html => 내장객체로 호출
            < % for (Member member : members) {
                out.write("    <tr>");
                out.write("        <td>" + member.getUsername() + "</td>");
                out.write("        <td>" + member.getAge() + "</td>");
                out.write("    </tr>");
                }
            % >


        - JSP에서 제공하는 편의성 태크 JSTL
        ㄴ 자바  => 변수 => < %로 접근
        ㄴ html => 감쏴면 됨.

-->

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
        <tr>
            <td>${member.id} </td>
            <td>${member.username} </td>
            <td>${member.age}</td>
        </tr>
    </tbody>
</table>
</body>
</html>