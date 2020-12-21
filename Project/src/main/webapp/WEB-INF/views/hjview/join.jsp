<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-2.1.3.min.js"></script>
<title>join</title>
</head>
<body>


<div class="container">
            <form action="login.do" class="form-horizontal" role="form">
                <h2>회원가입</h2>
                <div class="form-group">
                    <label for="name" class="col-sm-3 control-label">이름(별명)*</label>
                    <div class="col-sm-9">
                        <input type="text" id="name" placeholder="이름(별명)" class="form-control" autofocus>
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-3 control-label">이메일* </label>
                    <div class="col-sm-9">
                        <input type="email" id="email" placeholder="이메일" class="form-control" name= "email">
                    </div>
                </div>
                  <div class="form-group">
                    <label for="id" class="col-sm-3 control-label">아이디*</label>
                    <div class="col-sm-9">
                        <input type="text" id="id" placeholder="아이디" class="form-control" autofocus>
                    </div>
                   </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">비밀번호*</label>
                    <div class="col-sm-9">
                        <input type="password" id="password" placeholder="비밀번호" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">비밀번호 확인*</label>
                    <div class="col-sm-9">
                        <input type="password" id="password" placeholder="비밀번호 확인" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label for="birthDate" class="col-sm-3 control-label">생년월일*</label>
                    <div class="col-sm-9">
                        <input type="date" id="birthDate" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-3">성별</label>
                    <div class="col-sm-6">
                        <div class="row">
                            <div class="col-sm-4">
                                <label class="radio-inline">
                                    <input type="radio" id="femaleRadio" value="Female">여자
                                </label>
                            </div>
                            <div class="col-sm-4">
                                <label class="radio-inline">
                                    <input type="radio" id="maleRadio" value="Male">남자
                                </label>
                            </div>
                        </div>
                    </div>
                </div> <!-- /.form-group -->
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <span class="help-block">*필수사항</span>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary btn-block">가입</button>
            </form> <!-- /form -->
        </div> <!-- ./container -->

</body>
</html>

