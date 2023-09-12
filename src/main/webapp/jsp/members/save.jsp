<%@ page import="moon.mvc1.domain.member.Member" %>
<%@ page import="moon.mvc1.domain.member.MemberRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

  //jsp도 나중에 자동으로 서블릿으로 변환되어 사용되기 때문에 HttpServlet에 해당하는 코드들이 자동으로 생성된다. 따라서
  //request,response 사용가능하다.
  MemberRepository memberRepository = MemberRepository.getInstance();
  System.out.println("MemberSaveServlet.service");
  String username = request.getParameter("username");
  int age = Integer.parseInt(request.getParameter("age"));

  Member member = new Member(username,age);
  memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
  <li>id=<%=member.getId()%></li>
  <li>name=<%=member.getUsername()%></li>
  <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
