<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<c:set var="app" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>/sample/admin page</h1>

<p>principal        : <sec:authentication property="principal"/></p>
<p>MemberVO         : <sec:authentication property="principal.member"/></p>
<p>사용자이름       : <sec:authentication property="principal.member.userName"/></p>
<p>사용자비밀번호   : <sec:authentication property="principal.member.userpw"/></p>
<p>사용자아이디     : <sec:authentication property="principal.username"/></p>
<p>사용자비밀번호   : <sec:authentication property="principal.password"/></p>
<p>사용자 권한 리스트  : <sec:authentication property="principal.member.authList"/></p>
<a href="${app}/customLogout">Logout</a>
</body>
</html>