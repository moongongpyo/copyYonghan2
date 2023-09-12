<%@ page import="moon.mvc1.domain.member.MemberRepository" %>
<%@ page import="moon.mvc1.domain.member.Member" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();
    List<Member> members = memberRepository.findAll();

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thead>
    <tbody>
<%--    <%  for (Member member : members) { %>--%>
<%--    <tr>--%>
<%--        <td><%=member.getId()%></td>--%>
<%--        <td><%=member.getUsername()%></td>--%>
<%--        <td><%=member.getAge()%></td>--%>
<%--    </tr>--%>
<%--    <%  } %>--%>
    <%
        for (Member member : members) {
            out.write(" <tr>");
            out.write(" <td>" + member.getId() + "</td>");
            out.write(" <td>" + member.getUsername() + "</td>");
            out.write(" <td>" + member.getAge() + "</td>");
            out.write(" </tr>");
        }
    %>
    </tbody>
</table>

<a href="/index.html">메인</a>
</body>
</html>