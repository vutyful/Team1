<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="resources/hjresources/css/loginCss.css" rel="stylesheet" />
<title>login.jsp</title>
</head>
<body>

<body>
    <div id="login">
        <h3 class="text-center text-white pt-5">Login form</h3>
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" action="loginOk.do" method="post">
                            <h3 class="text-center text-info">로그인</h3>
                            <div class="form-group">
                                <label for="id" class="text-info">아이디:</label><br>
                                <input type="text" name="username" id="id" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">비밀번호:</label><br>
                                <input type="text" name="password" id="password" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="remember-me" class="text-info"><span>로그인 상태 유지</span> <span><input id="remember-me" name="remember-me" type="checkbox"></span></label><br>
                                <input type="submit" name="submit" class="btn btn-info btn-md" value="로그인">
                            </div>
                            <div id="register-link" class="text-right">
                                <a href="join.do" class="text-info">가입하기</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>



</body>
</html>