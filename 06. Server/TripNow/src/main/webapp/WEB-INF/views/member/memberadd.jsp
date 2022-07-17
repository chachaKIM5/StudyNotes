<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TripNow(트립나우)</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>


	.ktitle {
      float: left; 
      display: block;
	  text-align: center;
	}
	
	.ktitle h1 {
      margin: 30px 0px 20px 20px;
      font-size: 20px;	
	}
	
	#kterms {
		width: 800px;
		height: 120px;
      background-color: #EEE;
      display: block;
      resize: none;
      outline: none;
      border: 1px solid #CCC;
      padding: 10px;
      text-align: justify;
       clear: both;		      
	}
	

	
	#ktermsbox {
		width: 800px;
        margin: 10px auto;
	}
	
	#ktermsbox input[type='radio'] {
		margin: 10px 5px 0px 20px;
	}
	
	#ktermsbox label {
		float: right;
	}
	
	#register {
		clear: both;
		width: 800px;
		margin: 20px auto;
	}
	
	#register th p:nth-child(1){
		font-size: 17px;
		margin-bottom: 2px;
	}
	
	#register th p:nth-child(2){
		font-size: 12px;
		font-weight: normal;
		margin-bottom: 0px;
	}
	
	#register th { width: 250px; }
	#register th, #register td {
		height: 60px;
	}
	
	td input[type='text'], td input[type='password'] {
		height: 30px;
		padding: 3px;
		outline: none;
	}
	
	td input[type='button'] {
		margin-left: 10px;
	}
	
	.kmini {
		width: 60px;
	}
	
	.kshort {
		width: 120px;
	}
	
	.klong {
		width: 200px;
	}
	
	.msg {
		display: none;
	}
	
	#register td input[type='radio'] {
		margin-right: 10px;
	}
	
	#register td label {
		margin-right: 35px;
	}
	
	#registerbtns {
		float: right;
	}
	
	#registerform {
		width: 800px;
		margin: 0 auto;
	}

	input[type='radio']:checked {
		  accent-color: #777;
	}
	
	
</style>
</head>
<body>
	<!--  -->
   <main>
      <%@ include file="/WEB-INF/views/inc/header.jsp" %>
      <div class="ktitle">
      <h1>약관 동의 여부 선택</h1>
      </div>
      	<div id="ktermsbox">
      	<textarea id="kterms" readonly>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus dolor neque nihil accusantium cum rem qui omnis alias molestias error fugiat nobis totam aut assumenda commodi eos ratione est illo magni maiores similique tempora dolores ipsa quibusdam corrupti architecto dolorum repudiandae beatae deserunt reprehenderit earum explicabo provident quod tenetur pariatur!</textarea>
      	<label><input type="radio" name="rbterms" value="agree"> <span>비동의 </span></label>
      	<label><input type="radio" name="rbterms" value="disagree"> <span>동의 </span></label>
      	</div>
      		
      	
      <div class="ktitle"><h1>회원 정보 등록</h1></div>
      
      <form id="registerform" autocomplete="off">
      <table id="register">
      		<tr>
      			<th><p>아이디</p><p>영문, 숫자 조합 5~15자 이내</p></th>
      			<td><input type="text" id="id" required name="id"><input type="button" value="중복 확인" class="btn btn-info"><input type="text" class="msg" readonly></td>      			
      		</tr>
      		<tr>
      			<th><p>비밀번호</p><p>영문, 숫자, 특수문자 조합 6~20자</p></th>
      			<td><input type="password" id="pw" required name="pw"></td>
      		</tr>
      		<tr>
      			<th><p>비밀번호 확인</p></th>
      			<td><input type="password" id="pwconfirm" required><input type="text" class="msg" readonly></td>
      		</tr>
      		<tr>
      			<th><p>이름</p><p>한글 2~5자</p></th>
      			<td><input type="text" id="name" class="kshort" required name="name"></td>
      		</tr>
      		<tr>
      			<th><p>전화번호</p></th>
      			<td><input type="text" id="tel1" class="kmini" required name="tel1"> - <input type="text" id="tel2" class="kmini" required name="tel2"> - <input type="text" id="tel3" class="kmini" required name="tel3"></td>
      		</tr>
      		<tr>
      			<th><p>생년월일</p></th>
      			<td><input type="text" id="birth" class="kshort" placeholder="YYYYMMDD" required name="birth"></td>
      		</tr>
      		<tr>
      			<th><p>생년월일</p></th>
      			<td>
      				<label><input type="radio" name="gender" value="m" checked>남자</label>
      				<label><input type="radio" name="gender" value="f">여자</label>
      			</td>
      		</tr>
      		<tr>
      			<th><p>이메일</p></th>
      			<td><input type="text" id="email" class="klong" required name="email"><input type="button" value="인증 메일 발송" class="btn btn-info"><input type="text" class="msg" readonly></td>
      		</tr>
      		<tr id="confirm">
      			<th><p>인증 코드</p></th>
      			<td><input type="text" id="code" class="klong" required><input type="button" value="인증하기" class="btn btn-info"><input type="text" class="msg" readonly></td>
      		</tr>
      		
      </table>
      
      <div id="registerbtns">
      	<input type="submit" value="가입하기" class="btn btn-primary"> <input type="button" value="취소하기" class="btn btn-secondary">
      </div>
      
      </form>
   </main>
   
   <script>
   
   </script>

</body>
</html>