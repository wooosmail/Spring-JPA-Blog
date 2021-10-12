
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">

    <form action ="/auth/loginProc" method="post">

        <div class="form-group">
            <label for="username">UserName</label>
            <input type="text" class="form-control" placeholder="Enter User Name" id="username" name="username">
        </div>


        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" placeholder="Enter password" id="password" name="password">
        </div>

    <button id="btn-login" class="btn btn-primary">로그인</button>
        <button onclick="location.href='Https://kauth.kakao.com/oauth/authorize?client_id=b0c3492437bf70995dbe665e6954254b&redirect_uri=http://localhost:8000/auth/kakao/callback&response_type=code'"  class="btn btn-warning">카카오 로그인</button>
    <a href="Https://kauth.kakao.com/oauth/authorize?client_id=b0c3492437bf70995dbe665e6954254b&redirect_uri=http://localhost:8000/auth/kakao/callback&response_type=code"> 카카오 로그인 </a>
    </form>


</div>

<script src="/js/user.js" ></script>
<%@ include file="../layout/footer.jsp"%>



