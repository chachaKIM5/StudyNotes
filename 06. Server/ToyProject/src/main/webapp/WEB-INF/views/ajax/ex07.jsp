<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>
	.table th, .table td { text-align: center; }
	.table td:nth-child(1) { width: 120px; }
	.table td:nth-child(2) { width: 80px; }
	.table td:nth-child(3) { width: 80px; }
	.table td:nth-child(4) { width: 160px; }
	.table td:nth-child(5) { text-align: left; width: auto; padding-left: 10px; }
	.table td:nth-child(6) { width: 80px; }
	
	form input, form select { margin: 10px 0; }
	form input[type=text] { width: 120px; }
	form input[type=text]:nth-child(4) { width: 200px; }
	form input[type=text]:nth-child(5) { width: 400px; }
	form select.form-control { width: 120px; }
	
	.btnGender {
		opacity: .5;
	}
	
	.btnchoose {
		opacity: 1;
	}
	
</style>
</head>
<body>
	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
		 	<h2>
		 		주소록
		 		<small>
		 			<input type="button" value="남자" class="btn btn-primary btnGender">	
		 			<input type="button" value="여자" class="btn btn-danger btnGender">	
		 			<input type="button" value="전체" class="btn btn-info btnGender">	
		 		</small>
		 	</h2>
		 	
		 	<table class="table table-bordered">
		 		<thead>
			 		<tr>
			 			<th>이름</th>
			 			<th>나이</th>
			 			<th>성별</th>		 		
			 			<th>연락처</th>		 		
			 			<th>주소</th>
			 			<th>삭제</th>
			 		</tr>
		 		</thead>
		 		<tbody>
		 			
		 			<c:forEach items="${list}" var="dto">
			 			<tr>
			 				<td>${dto.getName()}</td>
			 				<td>${dto.getAge()}</td>
			 				<td>${dto.getGender() == 'm' ? '남자' : '여자'}</td>
			 				<td>${dto.getTel()}</td>
			 				<td>${dto.getAddress()}</td>
			 				<td><input type="button" value="삭제" class="btn btn-warning btnDel" onclick="f1();" data-num= "${dto.getSeq()}"></td>		 				
			 			</tr>
		 			</c:forEach>
		 		</tbody>
		 	</table>
		 	
		 	<hr>
		 	
		 	<form id="form">
		 	<div>
		 		<input type="text" name="name" id="name" class="form-control" placeholder="이름" required>
		 		<input type="text" name="age" id="age" class="form-control" placeholder="나이" required>
		 		<select name="gender" id="gender" class="form-control">
		 			<option value="m">남자</option>
		 			<option value="f">여자</option>
		 		</select>
		 		<input type="text" name="tel" id="tel" class="form-control" placeholder="전화" required>
		 		<input type="text" name="address" id="address" class="form-control" placeholder="주소" required>
		 	</div>
		 	<div class="btns">
		 		<input type="button" value="등록하기" class="btn btn-primary">
		 	</div>
		 	</form>
		</section>
	</main>
	
	<script>
	
		$('.btns').click(function() {

			let temp = '';
			$.ajax({
				type: 'GET',
				url: '/toy/ajax/ex07add.do',
				data: $('#form').serialize(),
				dataType: 'json',
				success: function(result) {
					
					
					temp += '<tr>';	
					temp += '<td>' + result.name + '</td>';	
					temp += '<td>' + result.age + '</td>';	
					temp += '<td>' + result.gender + '</td>';	
					temp += '<td>' + result.tel + '</td>';	
					temp += '<td>' + result.address + '</td>';	
					temp += '<td><input type="button" value="삭제" class="btn btn-warning btnDel" onclick="f1();" data-num= \"' + result.seq + '\"></td>';	
					temp += '</tr>';
					
					$('tbody').append(temp);
		 			
				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			})
			
			$('#form').find('input[type=text]').val('');
			$('#gender option:eq(0)').prop('selected', true);
		
		});
		
		
/* 		$('.btnDel').click(function() {
						
			alert($(event.target).data('num'));
			$.ajax({
				type: 'GET',
				url: '/toy/ajax/ex07del.do',
				data: 'seq=' + $(this).data('num'),
				dataType: 'json',
				success: function(result) {
					
				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			
			})
		
		}); */
		
		function f1() {
						
			$.ajax({
				type: 'GET',
				url: '/toy/ajax/ex07del.do',
				data: 'seq=' + $(event.target).data('num'),
				dataType: 'json',
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			
			})
		
			$(event.target).parent().parent().remove();
		};
		
		
		$('.btnGender').click(function() {
		
			$('.btnGender').removeClass('btnchoose');
			$(this).addClass('btnchoose');
			$(this).blur();
			
			let choice = $(this).val();
			
			$.ajax({
					
				type: 'GET',
				url: '/toy/ajax/ex07search.do',
				data: 'choice=' + choice,
				dataType: 'json',
				success: function(result) {
					
					$('tbody').find('tr').remove();
					
					$(result).each(function(index, item) {						
											
						let temp = '';
						temp += '<tr>';	
						temp += '<td>' + item.name + '</td>';	
						temp += '<td>' + item.age + '</td>';	
						temp += '<td>' + item.gender + '</td>';	
						temp += '<td>' + item.tel + '</td>';	
						temp += '<td>' + item.address + '</td>';	
						temp += '<td><input type="button" value="삭제" class="btn btn-warning btnDel" onclick="f1();" data-num= \"' + item.seq + '\"></td>';	
						temp += '</tr>';
						
						$('tbody').append(temp);
					});
					
				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			
			})
		});
	</script>	
	
</body>
</html>