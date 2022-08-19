<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트립나우</title>
<style>

	#usercontent {
	    margin-top: 17px;
	    width: 830px;
	    height: 800px;
	    float: left;
	    clear: right;
    
	}
	
	#header{
		
		font-size:25px;
		border-bottom: 1px solid black;
		width:150px;
		margin-bottom:10px;
		
	}


	/* 	table */
	
	#main > table{
		width: 825px;
	}
	

	#usercontent > form > table > tbody > tr > td > input[type=text]{
		text-align: center;
 		border:none; 
 		margin-top:5px;
	}
	#usercontent > form > table > tbody > tr > td:nth-child(1) > input[type=text]{

		width:90px;
	}
	#usercontent > form > table > tbody > tr > td:nth-child(3) > input[type=text]{

		width:65px;
	}
	#usercontent > form > table > tbody > tr > td:nth-child(4) > input[type=text]{

		width:103px;
	}
	#usercontent > form > table > tbody > tr > td:nth-child(5) > input[type=text]{

		width:92px;
	}
	#usercontent > form > table > tbody > tr > td:nth-child(7) > input[type=text]{

		width:auto;
	}
	
	
	#grade{
	
		width: 92px;
	}

	.table.textcenter th {
		text-align: center;
		background-color: #b7b7b7;
	}
	
	.table.textcenter td {
		text-align: center;
	}
	
	.table.textcenter > tbody > tr:hover {
		background-color: #f3f3f3;
	}

	
	
	.userbtn {
		float: right;
		margin-bottom: 20px;
		margin-right: 10px;
	}
	

	
</style>
</head>
<body>
	<div id="usercontent">
		<div id="header">회원 정보 관리</div>
			<div style="float: right; margin-bottom:7px;">
				<form method="GET" action="/tripnow/admin/user/usermain">
					<table class="search">
						<tr>
							<td>
								<select name="column" class="form-control">
									<option value="id">아이디</option>
									<option value="name">이름</option>
								</select>
							</td>
							<td>
								<input type="text" name="word" class="form-control" >
							</td>
							<td>
								<button class="btn btn-primary">
									검색하기
								</button>
							</td>
						</tr>
					</table>
					<input type="hidden" value="" />
				</form>
			</div>
		<form method="POST" action="/tripnow/admin/user/editok" >
		<table class="table table-bordered textcenter" >
					<tr>
						<th>아이디</th>
						<th>등급</th>
						<th>이름</th>
						<th>전화번호</th>
						<th>생년월일</th>
						<th>성별</th>
						<th>이메일</th>
					</tr>
					
					<c:set var="num" value= '0'/>
					<c:forEach items="${list}" var="list" >							
					<tr>	
						<td>
							<input type="text" name="userlist[${num}].id" value="${list.id}" readonly style="outline:none;"/>
						</td>
						<td>						
							<select class="form-select" name="userlist[${num}].gseq" id="gseq" required onchange="fnChange(this)" >
							  <option value="1" <c:if test = "${list.gseq eq 1}">selected</c:if>>관리자</option>
							  <option value="2" <c:if test = "${list.gseq eq 2}">selected</c:if>>파트너</option>
							  <option value="3" <c:if test = "${list.gseq eq 3}">selected</c:if>>회원</option>
							  <option value="5" <c:if test = "${list.gseq eq 5}">selected</c:if>>블랙</option>
							</select> 
						</td>
						<td>
							<input type="text" name="userlist[${num}].name" value="${list.name}" required pattern="[가-힣]{2,5}" onchange="fnChange(this)"/>
						</td>
						<td>
							<input type="text" name="userlist[${num}].tel" value="${list.tel}" required pattern="[0-9]{10,11}" onchange="fnChange(this)"/>
						</td>
						<td>
							<input type="text" name="userlist[${num}].birth" value="${list.birth.substring(0,10)}" required pattern="^(19[0-9][0-9]|20\d{2})-(0[0-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$" onchange="fnChange(this)"/>
						</td>
						<td>
							<select class="form-select" name="userlist[${num}].gender" id="gender" onchange="fnChange(this)">
							  <option value="남" <c:if test = "${list.gender == '남'}">selected</c:if>>남</option>
							  <option value="여" <c:if test = "${list.gender == '여'}">selected</c:if>>여</option>
							</select> 
						</td>
						<td>
							<input type="text" name="userlist[${num}].email" value="${list.email}" required pattern="^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$" onchange="fnChange(this)"/>
						</td>
						<td style="display:none;">
							<input type="hidden" name="userlist[${num}].isedit" value="false" />
						</td>
					</tr>
					<c:set var="num" value= '${num+1}'/>
					</c:forEach>
					
					<c:if test="${list.size() == 0}">
					<tr>
						<td colspan="5">유저가 없습니다.</td>
					</tr>
					</c:if>
				</table>
				
				<div>
					<input type="submit" value="정보 수정" class="btn btn-primary userbtn">
				</div>
		</form>
				<div style="display: block; text-align: center;">		
					<c:if test="${paging.startPage != 1 }">
						<a href="/tripnow/admin/user/usermain?nowPage=${paging.startPage - 1 }&column=${paging.column}&word=${paging.word}">&lt;</a>
					</c:if>
					<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
						<c:choose>
							<c:when test="${p == paging.nowPage }">
								<b>${p}</b>
							</c:when>
							<c:when test="${p != paging.nowPage }">
								<a href="/tripnow/admin/user/usermain?nowPage=${p}&column=${paging.column}&word=${paging.word}">${p}</a>
							</c:when>
						</c:choose>
					</c:forEach>
					<c:if test="${paging.endPage != paging.lastPage}">
						<a href="/tripnow/admin/user/usermain?nowPage=${paging.endPage+1 }&column=${paging.column}&word=${paging.word}">&gt;</a>
					</c:if>
				</div>	
	</div>
	
	<script>
		function fnChange(a){
			
			var hidden = a.parentNode.parentNode.lastElementChild.firstElementChild;
			
			hidden.value = 'true';
		}
	
	</script>
</body>
</html>


















































