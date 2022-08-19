<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<style>
	#content {
		height: 1200px;
		margin-bottom: 100px;
	}
	
	.tableover {
		overflow: auto;
		overflow-y: scroll;
		display: block;
		max-height: 300px;
	}

	.btnclear {
		float: right;
	}
	
	.id-check {
		float: right;
		width: 200px;
		margin-right: 15px;
	}
	
	#selectword {
		float: right;
		height: 38px;
		margin-right: 15px;
		text-align: center;
	}
	
	#home, #car, #activity {
		width: 830px;
		text-align: center;
		white-space: nowrap;
	}
	
	#test {
		overflow: auto;
		overflow-y: scroll;
		display: block;
		max-height: 1000px;
		width: 830px;
	}
	
	#testtwo {
		overflow: auto;
		display: block;
		max-height: 1000px;
		width: 830px;
	}
	
	#test > table {
		margin-top: 30px;
	}
	
	#home > tbody > tr > td:nth-child(12) { padding: 0; }
	#car > tbody > tr > td:nth-child(13) { padding: 0; }
	#activity > tbody > tr > td:nth-child(8) { padding: 0; }
	
</style>
<div id="content">
		<form id="searchform">
		<div>
		<input type="button" value="전체" class="btn btn-secondary" onclick="search('all')"> | 
		<input type="button" value="숙소" class="btn btn-secondary" onclick="search('home')"> | 
		<input type="button" value="렌터카" class="btn btn-secondary" onclick="search('car')"> | 
		<input type="button" value="액티비티" class="btn btn-secondary" onclick="search('activity')">
		<span id="searchid">
			<span><input type="button" value="검색하기" class="btn btn-success btnclear" onclick="idsearch();"></span>
			<input type="text" name="searchword" id="searchword" placeholder="검색할 ID를 입력하세요." class="form-control id-check">
			<select name="selectword" id="selectword">
				<option value="all">전체</option>
				<option value="home">숙소</option>
				<option value="car">렌터카</option>
				<option value="activity">액티비티</option>
			</select>
		</span>
		</div>
		</form>
		
		<hr>
		<div class="tableover">
		<table class="table table-bordered" id="home">
			<thead>
				<tr>
					<th>숙소명</th>
					<th>방이름</th>
					<th>파트너ID(이름)</th>
					<th>숙소 타입</th>
					<th>침대 옵션</th>
					<th>입실 시간</th>
					<th>퇴실 시간</th>
					<th>위치</th>
					<th>가격</th>
					<th>등록 상태</th>
					<th>노출 상태</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${hlist}" var="hlist">
				<tr>
					<td>${hlist.homename}</td>
					<td>${hlist.roomname}</td>
					<td>${hlist.id}(${hlist.username})</td>
					<td>${hlist.hometype}</td>
					<td>${hlist.bedtype}</td>
					<td>${hlist.enterhome}</td>
					<td>${hlist.outerhome}</td>
					<td>${hlist.location}</td>
					<td>${hlist.price} 원</td>
					<td>${hlist.regstat}</td>
					<c:if test="${hlist.show == 'y'}">
					<td><input type="button" class="btn btn-primary btnsize" value="노출" onclick="homeshow(${hlist.seq}, '${hlist.show}');"></td>
					</c:if>
					<c:if test="${hlist.show == 'n'}">
					<td><input type="button" class="btn btn-danger btnsize" value="비노출" onclick="homeshow(${hlist.seq}, '${hlist.show}');"></td>
					</c:if>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
		
		<hr>
		
		<div class="tableover">
		<table class="table table-bordered" id="car">
			<thead>
				<tr>
					<th>차량명</th>
					<th>파트너ID(이름)</th>
					<th>차량 종류</th>
					<th>연료 종류</th>
					<th>연비</th>
					<th>수용 인원</th>
					<th>변속 종류</th>
					<th>시작 시간</th>
					<th>종료 시간</th>
					<th>가격</th>
					<th>등록 상태</th>
					<th>노출 상태</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${clist}" var="clist">
				<tr>
					<td>${clist.carname}</td>
					<td>${clist.pid}(${clist.name})</td>
					<td>${clist.fuelvalue}</td>
					<td>${clist.carvalue}</td>
					<td>${clist.mileage}km/L</td>
					<td>${clist.maxpeople}명</td>
					<c:if test="${clist.geartype == 'y'}">
					<td>Auto</td>
					</c:if>
					<c:if test="${clist.geartype == 'n'}">
					<td>Stick</td>
					</c:if>
					<td>${clist.rentstart}</td>
					<td>${clist.rentend}</td>
					<td>${clist.price} 원</td>
					<td>${clist.regstate}</td>
					<c:if test="${clist.show == 'y'}">
					<td><input type="button" class="btn btn-primary btnsize" value="노출" onclick="carshow(${clist.seq}, '${clist.show}');"></td>
					</c:if>
					<c:if test="${clist.show == 'n'}">
					<td><input type="button" class="btn btn-danger btnsize" value="비노출" onclick="carshow(${clist.seq}, '${clist.show}');"></td>
					</c:if>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
		
		<hr>
		
		<div class="tableover">
		<table class="table table-bordered" id="activity">
			<thead>
				<tr>
					<th>액티비티명</th>
					<th>파트너ID(이름)</th>
					<th>위치</th>
					<th>사용 기간</th>
					<th>가격</th>
					<th>등록 상태</th>
					<th>노출 상태</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${alist}" var="alist">
				<tr>
					<td>${alist.activityname}</td>
					<td>${alist.pid}(${alist.name})</td>
					<td>${alist.location}</td>
					<td> ~ ${alist.period}</td>
					<td>${alist.price} 원</td>
					<td>${alist.value}</td>
					<c:if test="${alist.show == 'y'}">
					<td><input type="button" class="btn btn-primary btnsize" value="노출" onclick="activityshow(${alist.seq}, '${alist.show}');"></td>
					</c:if>
					<c:if test="${alist.show == 'n'}">
					<td><input type="button" class="btn btn-danger btnsize" value="비노출" onclick="activityshow(${alist.seq}, '${alist.show}');"></td>
					</c:if>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
		
		<div id="test"></div>
		<div id="testtwo"></div>
		<c:forEach items="${hlists}" var="h">
			${h.homename}
		</c:forEach>
	</div>
<script src="http://code.jquery.com/jquery-latest.js"></script> 
<script>

	let temp = "";
	//=================================================================================================================================
	let all = `<hr>
		<div class="tableover">
		<table class="table table-bordered" id="home">
			<thead>
				<tr>
					<th>숙소명</th>
					<th>방이름</th>
					<th>파트너ID(이름)</th>
					<th>숙소 타입</th>
					<th>침대 옵션</th>
					<th>입실 시간</th>
					<th>퇴실 시간</th>
					<th>위치</th>
					<th>가격</th>
					<th>등록 상태</th>
					<th>노출 상태</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		</div>
		
		<hr>
		
		<div class="tableover">
		<table class="table table-bordered" id="car">
			<thead>
				<tr>
					<th>차량명</th>
					<th>파트너ID(이름)</th>
					<th>차량 종류</th>
					<th>연료 종류</th>
					<th>연비</th>
					<th>수용 인원</th>
					<th>변속 종류</th>
					<th>시작 시간</th>
					<th>종료 시간</th>
					<th>가격</th>
					<th>등록 상태</th>
					<th>노출 상태</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		</div>
		
		<hr>
		
		<div class="tableover">
		<table class="table table-bordered" id="activity">
			<thead>
				<tr>
					<th>액티비티명</th>
					<th>파트너ID(이름)</th>
					<th>위치</th>
					<th>사용 기간</th>
					<th>가격</th>
					<th>등록 상태</th>
					<th>노출 상태</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		</div>`;
		
		//=================================================================================================================================
		
		let home = `<table class="table table-bordered" id="home">
			<thead>
			<tr>
				<th>숙소명</th>
				<th>방이름</th>
				<th>파트너ID(이름)</th>
				<th>숙소 타입</th>
				<th>침대 옵션</th>
				<th>입실 시간</th>
				<th>퇴실 시간</th>
				<th>위치</th>
				<th>가격</th>
				<th>등록 상태</th>
				<th>노출 상태</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>`;
	
	//=================================================================================================================================
	
	let car = `<table class="table table-bordered" id="car">
		<thead>
		<tr>
			<th>차량명</th>
			<th>파트너ID(이름)</th>
			<th>차량 종류</th>
			<th>연료 종류</th>
			<th>연비</th>
			<th>수용 인원</th>
			<th>변속 종류</th>
			<th>시작 시간</th>
			<th>종료 시간</th>
			<th>가격</th>
			<th>등록 상태</th>
			<th>노출 상태</th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>`;

//=================================================================================================================================

	let activity = `<table class="table table-bordered" id="activity">
		<thead>
		<tr>
			<th>액티비티명</th>
			<th>파트너ID(이름)</th>
			<th>위치</th>
			<th>사용 기간</th>
			<th>가격</th>
			<th>등록 상태</th>
			<th>노출 상태</th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>`;
//=================================================================================================================================
	function search(tag) {
		
		$.ajax({
			type: 'GET',
			url: '/tripnow/goodsearch',
			data: 'tag=' + tag,
			dataType: 'json',
			success: function(result) {
					
				$("#home").remove();
				$("#car").remove();
				$("#activity").remove();
				$("hr").remove();
				$("#test").empty();
				$("#testtwo").empty();
				
				console.log(result.length);
				
				if(result.hsearch != null || result.csearch != null || result.asearch != null) {
					temp = all;
					$("#testtwo").append(temp);
					
					if (result.hsearch.length > 0) {
						$(result.hsearch).each(function(index, item) {
							let tmp = '';
							
							tmp += '<tr>';
							tmp += '<td>' + item.homename + '</td>';
							tmp += '<td>' + item.roomname + '</td>';
							tmp += '<td>' + item.id + '(' + item.username + ')' + '</td>';
							tmp += '<td>' + item.hometype + '</td>';
							tmp += '<td>' + item.bedtype + '</td>';
							tmp += '<td>' + item.enterhome + '</td>';
							tmp += '<td>' + item.outerhome + '</td>';
							tmp += '<td>' + item.location + '</td>';
							tmp += '<td>' + item.price + ' 원</td>';
							tmp += '<td>' + item.regstat + '</td>';
							if(item.show == 'y') {
							tmp += '<td><input type="button" class="btn btn-primary btnsize" value="노출" onclick="homeshow(' + item.seq + ',' + '\'' + item.show + '\'' + ');">' + '</td>';
							} else if (item.show == 'n') {
								tmp += '<td><input type="button" class="btn btn-danger btnsize" value="비노출" onclick="homeshow(' + item.seq + ',' + '\'' + item.show + '\'' + ');">' + '</td>';
							}
							tmp += '</tr>';
							$("#testtwo #home tbody").append(tmp);
						});
					}
					
					if (result.csearch.length > 0) {
						$(result.csearch).each(function(index, item) {
							let tmp = '';
							
							tmp += '<tr>';
							tmp += '<td>' + item.carname + '</td>';
							tmp += '<td>' + item.pid + '(' + item.name + ')' + '</td>';
							tmp += '<td>' + item.fuelvalue + '</td>';
							tmp += '<td>' + item.carvalue + '</td>';
							tmp += '<td>' + item.mileage + 'km/L</td>';
							tmp += '<td>' + item.maxpeople + '명</td>';
							if(item.geartype == 'y'){
								tmp += '<td>Auto</td>'
							} else {
								tmp += '<td>Stick</td>'
							}
							tmp += '<td>' + item.rentstart + '</td>';
							tmp += '<td>' + item.rentend + '</td>';
							tmp += '<td>' + item.price + ' 원</td>';
							tmp += '<td>' + item.regstate + '</td>';
							if(item.show == 'y') {
							tmp += '<td><input type="button" class="btn btn-primary btnsize" value="노출" onclick="carshow(' + item.seq + ',' + '\'' + item.show + '\'' + ');">' + '</td>';
							} else if (item.show == 'n') {
								tmp += '<td><input type="button" class="btn btn-danger btnsize" value="비노출" onclick="carshow(' + item.seq + ',' + '\'' + item.show + '\'' + ');">' + '</td>';
							}
							tmp += '</tr>';
							$("#testtwo #car tbody").append(tmp);
						});
					}
					
					if (result.asearch.length > 0) {
						$(result.asearch).each(function(index, item) {
							let tmp = '';
							
							tmp += '<tr>';
							tmp += '<td>' + item.activityname + '</td>';
							tmp += '<td>' + item.pid + '(' + item.name + ')' + '</td>';
							tmp += '<td>' + item.location + '</td>';
							tmp += '<td>~ ' + item.period + '</td>';
							tmp += '<td>' + item.price + ' 원</td>';
							tmp += '<td>' + item.value + '</td>';
							if(item.show == 'y') {
							tmp += '<td><input type="button" class="btn btn-primary btnsize" value="노출" onclick="activityshow(' + item.seq + ',' + '\'' + item.show + '\'' + ');">' + '</td>';
							} else if (item.show == 'n') {
								tmp += '<td><input type="button" class="btn btn-danger btnsize" value="비노출" onclick="activityshow(' + item.seq + ',' + '\'' + item.show + '\'' + ');">' + '</td>';
							}
							tmp += '</tr>';
							$("#testtwo #activity tbody").append(tmp);
						});
					}
				} else if (result[0].homename != null) {
					temp = home;
					$("#test").append(temp);
					
					$(result).each(function(index, item) {
						
						let tmp = '';
						
						tmp += '<tr>';
						tmp += '<td>' + item.homename + '</td>';
						tmp += '<td>' + item.roomname + '</td>';
						tmp += '<td>' + item.id + '(' + item.username + ')' + '</td>';
						tmp += '<td>' + item.hometype + '</td>';
						tmp += '<td>' + item.bedtype + '</td>';
						tmp += '<td>' + item.enterhome + '</td>';
						tmp += '<td>' + item.outerhome + '</td>';
						tmp += '<td>' + item.location + '</td>';
						tmp += '<td>' + item.price + ' 원</td>';
						tmp += '<td>' + item.regstat + '</td>';
						if(item.show == 'y') {
						tmp += '<td><input type="button" class="btn btn-primary btnsize" value="노출" onclick="homeshow(' + item.seq + ',' + '\'' + item.show + '\'' + ');">' + '</td>';
						} else if (item.show == 'n') {
							tmp += '<td><input type="button" class="btn btn-danger btnsize" value="비노출" onclick="homeshow(' + item.seq + ',' + '\'' + item.show + '\'' + ');">' + '</td>';
						}
						tmp += '</tr>';
						
							$("#test table tbody").append(tmp);
						
						});
					
				} else if (result[0].carname != null) {
					temp = car;
					$("#test").append(temp);
					
					$(result).each(function(index, item) {
						
						let tmp = '';
						
						tmp += '<tr>';
						tmp += '<td>' + item.carname + '</td>';
						tmp += '<td>' + item.pid + '(' + item.name + ')' + '</td>';
						tmp += '<td>' + item.fuelvalue + '</td>';
						tmp += '<td>' + item.carvalue + '</td>';
						tmp += '<td>' + item.mileage + 'km/L</td>';
						tmp += '<td>' + item.maxpeople + '명</td>';
						if(item.geartype == 'y'){
							tmp += '<td>Auto</td>'
						} else {
							tmp += '<td>Stick</td>'
						}
						tmp += '<td>' + item.rentstart + '</td>';
						tmp += '<td>' + item.rentend + '</td>';
						tmp += '<td>' + item.price + ' 원</td>';
						tmp += '<td>' + item.regstate + '</td>';
						if(item.show == 'y') {
						tmp += '<td><input type="button" class="btn btn-primary btnsize" value="노출" onclick="carshow(' + item.seq + ',' + '\'' + item.show + '\'' + ');">' + '</td>';
						} else if (item.show == 'n') {
							tmp += '<td><input type="button" class="btn btn-danger btnsize" value="비노출" onclick="carshow(' + item.seq + ',' + '\'' + item.show + '\'' + ');">' + '</td>';
						}
						tmp += '</tr>';
						
							$("#test table tbody").append(tmp);
						
						});
						
						
				} else if(result[0].activityname != null) {
					temp = activity;
					$("#test").append(temp);
					
					$(result).each(function(index, item) {
						
						let tmp = '';
						
						tmp += '<tr>';
						tmp += '<td>' + item.activityname + '</td>';
						tmp += '<td>' + item.pid + '(' + item.name + ')' + '</td>';
						tmp += '<td>' + item.location + '</td>';
						tmp += '<td>~ ' + item.period + '</td>';
						tmp += '<td>' + item.price + ' 원</td>';
						tmp += '<td>' + item.value + '</td>';
						if(item.show == 'y') {
						tmp += '<td><input type="button" class="btn btn-primary btnsize" value="노출" onclick="activityshow(' + item.seq + ',' + '\'' + item.show + '\'' + ');">' + '</td>';
						} else if (item.show == 'n') {
							tmp += '<td><input type="button" class="btn btn-danger btnsize" value="비노출" onclick="activityshow(' + item.seq + ',' + '\'' + item.show + '\'' + ');">' + '</td>';
						}
						tmp += '</tr>';
						
							$("#test table tbody").append(tmp);
						
						});
				} 
				
			},
			error: function(a,b,c) {
				console.log(a,b,c);
			}
		});
		
	}
	
	
	
	
	
	function homeshow(seq, show) {
		
		let target = $(event.target);
		
		$.ajax({
			type: 'GET',
			url: '/tripnow/homeshow',
			data: 'seq=' + seq + '&show=' + show,
			dataType: 'text',
			success: function(result) {
				
				if (result == 'y') {
					target.removeClass('btn-danger').addClass('btn-primary').val('노출').removeAttr("onclick").attr("onclick", "homeshow(" + seq + ', \'y\'' + ")");
				} else if (result == 'n') {
					target.removeClass('btn-primary').addClass('btn-danger').val('비노출').removeAttr("onclick").attr("onclick", "homeshow(" + seq + ', \'n\'' + ")");
				}
				
			},
			error: function(a,b,c) {
				console.log(a,b,c);
			}
		});
	}
	
	function carshow(seq, show) {
		
		let target = $(event.target);
		
		$.ajax({
			type: 'GET',
			url: '/tripnow/carshow',
			data: 'seq=' + seq + '&show=' + show,
			dataType: 'text',
			success: function(result) {
				
				if (result == 'y') {
					target.removeClass('btn-danger').addClass('btn-primary').val('노출').removeAttr("onclick").attr("onclick", "carshow(" + seq + ', \'y\'' + ")");
				} else if (result == 'n') {
					target.removeClass('btn-primary').addClass('btn-danger').val('비노출').removeAttr("onclick").attr("onclick", "carshow(" + seq + ', \'n\'' + ")");
				}
				
			},
			error: function(a,b,c) {
				console.log(a,b,c);
			}
		});
		
	}
	
	function activityshow(seq, show) {
		
		let target = $(event.target);
		
		$.ajax({
			type: 'GET',
			url: '/tripnow/activityshow',
			data: 'seq=' + seq + '&show=' + show,
			dataType: 'text',
			success: function(result) {
				
				if (result == 'y') {
					target.removeClass('btn-danger').addClass('btn-primary').val('노출').removeAttr("onclick").attr("onclick", "activityshow(" + seq + ', \'y\'' + ")");
				} else if (result == 'n') {
					target.removeClass('btn-primary').addClass('btn-danger').val('비노출').removeAttr("onclick").attr("onclick", "activityshow(" + seq + ', \'n\'' + ")");
				}
				
			},
			error: function(a,b,c) {
				console.log(a,b,c);
			}
		});
		
	}
	
	function idsearch() {
		
		$.ajax({
			type: 'GET',
			url: '/tripnow/idsearch',
			data: "searchword=" + $("#searchword").val() + "&selectword=" + $("#selectword").val(),
			dataType: 'json',
			success: function(selected) {
				
				console.log(selected);
				
				$("#home").remove();
				$("#car").remove();
				$("#activity").remove();
				$("hr").remove();
				$("#test").empty();
				$("#testtwo").empty();
				
				if(selected.hsearch != null || selected.csearch != null || selected.asearch != null) {
					
					console.log(selected.hsearch.length);
					console.log(selected.csearch.length);
					console.log(selected.asearch.length);
					
					temp = `<hr>
						<div class="tableover">
						<table class="table table-bordered" id="home">
							<thead>
								<tr>
									<th>숙소명</th>
									<th>방이름</th>
									<th>파트너ID(이름)</th>
									<th>숙소 타입</th>
									<th>침대 옵션</th>
									<th>입실 시간</th>
									<th>퇴실 시간</th>
									<th>위치</th>
									<th>가격</th>
									<th>등록 상태</th>
									<th>노출 상태</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
						</div>
						
						<hr>
						
						<div class="tableover">
						<table class="table table-bordered" id="car">
							<thead>
								<tr>
									<th>차량명</th>
									<th>파트너ID(이름)</th>
									<th>차량 종류</th>
									<th>연료 종류</th>
									<th>연비</th>
									<th>수용 인원</th>
									<th>변속 종류</th>
									<th>시작 시간</th>
									<th>종료 시간</th>
									<th>가격</th>
									<th>등록 상태</th>
									<th>노출 상태</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
						</div>
						
						<hr>
						
						<div class="tableover">
						<table class="table table-bordered" id="activity">
							<thead>
								<tr>
									<th>액티비티명</th>
									<th>파트너ID(이름)</th>
									<th>위치</th>
									<th>사용 기간</th>
									<th>가격</th>
									<th>등록 상태</th>
									<th>노출 상태</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
						</div>`;
						
						$("#testtwo").append(temp);
						
						if (selected.hsearch.length > 0) {
							$(selected.hsearch).each(function(index, item) {
								let tmp = '';
								
								tmp += '<tr>';
								tmp += '<td>' + item.homename + '</td>';
								tmp += '<td>' + item.roomname + '</td>';
								tmp += '<td>' + item.id + '(' + item.username + ')' + '</td>';
								tmp += '<td>' + item.hometype + '</td>';
								tmp += '<td>' + item.bedtype + '</td>';
								tmp += '<td>' + item.enterhome + '</td>';
								tmp += '<td>' + item.outerhome + '</td>';
								tmp += '<td>' + item.location + '</td>';
								tmp += '<td>' + item.price + ' 원</td>';
								tmp += '<td>' + item.regstat + '</td>';
								if(item.show == 'y') {
								tmp += '<td><input type="button" class="btn btn-primary btnsize" value="노출" onclick="homeshow(' + item.seq + ',' + '\'' + item.show + '\'' + ');">' + '</td>';
								} else if (item.show == 'n') {
									tmp += '<td><input type="button" class="btn btn-danger btnsize" value="비노출" onclick="homeshow(' + item.seq + ',' + '\'' + item.show + '\'' + ');">' + '</td>';
								}
								tmp += '</tr>';
								$("#testtwo #home tbody").append(tmp);
							});
						}
						
						if (selected.csearch.length > 0) {
							$(selected.csearch).each(function(index, item) {
								let tmp = '';
								
								tmp += '<tr>';
								tmp += '<td>' + item.carname + '</td>';
								tmp += '<td>' + item.pid + '(' + item.name + ')' + '</td>';
								tmp += '<td>' + item.fuelvalue + '</td>';
								tmp += '<td>' + item.carvalue + '</td>';
								tmp += '<td>' + item.mileage + 'km/L</td>';
								tmp += '<td>' + item.maxpeople + '명</td>';
								if(item.geartype == 'y'){
									tmp += '<td>Auto</td>'
								} else {
									tmp += '<td>Stick</td>'
								}
								tmp += '<td>' + item.rentstart + '</td>';
								tmp += '<td>' + item.rentend + '</td>';
								tmp += '<td>' + item.price + ' 원</td>';
								tmp += '<td>' + item.regstate + '</td>';
								if(item.show == 'y') {
								tmp += '<td><input type="button" class="btn btn-primary btnsize" value="노출" onclick="carshow(' + item.seq + ',' + '\'' + item.show + '\'' + ');">' + '</td>';
								} else if (item.show == 'n') {
									tmp += '<td><input type="button" class="btn btn-danger btnsize" value="비노출" onclick="carshow(' + item.seq + ',' + '\'' + item.show + '\'' + ');">' + '</td>';
								}
								tmp += '</tr>';
								$("#testtwo #car tbody").append(tmp);
							});
						}
						
						if (selected.asearch.length > 0) {
							$(selected.asearch).each(function(index, item) {
								let tmp = '';
								
								tmp += '<tr>';
								tmp += '<td>' + item.activityname + '</td>';
								tmp += '<td>' + item.pid + '(' + item.name + ')' + '</td>';
								tmp += '<td>' + item.location + '</td>';
								tmp += '<td>~ ' + item.period + '</td>';
								tmp += '<td>' + item.price + ' 원</td>';
								tmp += '<td>' + item.value + '</td>';
								if(item.show == 'y') {
								tmp += '<td><input type="button" class="btn btn-primary btnsize" value="노출" onclick="activityshow(' + item.seq + ',' + '\'' + item.show + '\'' + ');">' + '</td>';
								} else if (item.show == 'n') {
									tmp += '<td><input type="button" class="btn btn-danger btnsize" value="비노출" onclick="activityshow(' + item.seq + ',' + '\'' + item.show + '\'' + ');">' + '</td>';
								}
								tmp += '</tr>';
								$("#testtwo #activity tbody").append(tmp);
							});
						}
						
				} else if(selected[0].homename != null) {
					
					temp = `<table class="table table-bordered" id="home">
						<thead>
						<tr>
							<th>숙소명</th>
							<th>방이름</th>
							<th>파트너ID(이름)</th>
							<th>숙소 타입</th>
							<th>침대 옵션</th>
							<th>입실 시간</th>
							<th>퇴실 시간</th>
							<th>위치</th>
							<th>가격</th>
							<th>등록 상태</th>
							<th>노출 상태</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>`;
				
				$("#test").append(temp);
				
				$(selected).each(function(index, item) {
					
				let tmp = '';
				
				tmp += '<tr>';
				tmp += '<td>' + item.homename + '</td>';
				tmp += '<td>' + item.roomname + '</td>';
				tmp += '<td>' + item.id + '(' + item.username + ')' + '</td>';
				tmp += '<td>' + item.hometype + '</td>';
				tmp += '<td>' + item.bedtype + '</td>';
				tmp += '<td>' + item.enterhome + '</td>';
				tmp += '<td>' + item.outerhome + '</td>';
				tmp += '<td>' + item.location + '</td>';
				tmp += '<td>' + item.price + '원</td>';
				tmp += '<td>' + item.regstat + '</td>';
				if(item.show == 'y') {
				tmp += '<td><input type="button" class="btn btn-primary btnsize" value="노출" onclick="homeshow(' + item.seq + ',' + '\'' + item.show + '\'' + ');">' + '</td>';
				} else if (item.show == 'n') {
					tmp += '<td><input type="button" class="btn btn-danger btnsize" value="비노출" onclick="homeshow(' + item.seq + ',' + '\'' + item.show + '\'' + ');">' + '</td>';
				}
				tmp += '</tr>';
				
					$("#test table tbody").append(tmp);
				
				});
					
					
				} else if(selected[0].carname != null) {
					
					temp = `<table class="table table-bordered" id="car">
						<thead>
						<tr>
							<th>차량명</th>
							<th>파트너ID(이름)</th>
							<th>차량 종류</th>
							<th>연료 종류</th>
							<th>연비</th>
							<th>수용 인원</th>
							<th>변속 종류</th>
							<th>시작 시간</th>
							<th>종료 시간</th>
							<th>가격</th>
							<th>등록 상태</th>
							<th>노출 상태</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>`;
					
					$("#test").append(temp);
					
					$(selected).each(function(index, item) {
						
						let tmp = '';
						
						tmp += '<tr>';
						tmp += '<td>' + item.carname + '</td>';
						tmp += '<td>' + item.pid + '(' + item.name + ')' + '</td>';
						tmp += '<td>' + item.fuelvalue + '</td>';
						tmp += '<td>' + item.carvalue + '</td>';
						tmp += '<td>' + item.mileage + '</td>';
						tmp += '<td>' + item.maxpeople + '명</td>';
						if(item.geartype == 'y'){
							tmp += '<td>Auto</td>'
						} else {
							tmp += '<td>Stick</td>'
						}
						tmp += '<td>' + item.rentstart + '</td>';
						tmp += '<td>' + item.rentend + '</td>';
						tmp += '<td>' + item.price + '원</td>';
						tmp += '<td>' + item.regstate + '</td>';
						if(item.show == 'y') {
						tmp += '<td><input type="button" class="btn btn-primary btnsize" value="노출" onclick="carshow(' + item.seq + ',' + '\'' + item.show + '\'' + ');">' + '</td>';
						} else if (item.show == 'n') {
							tmp += '<td><input type="button" class="btn btn-danger btnsize" value="비노출" onclick="carshow(' + item.seq + ',' + '\'' + item.show + '\'' + ');">' + '</td>';
						}
						tmp += '</tr>';
						
							$("#test table tbody").append(tmp);
						
						});
					
				} else if(selected[0].activityname != null) {
					
					temp = `<table class="table table-bordered" id="activity">
						<thead>
						<tr>
							<th>액티비티명</th>
							<th>파트너ID(이름)</th>
							<th>위치</th>
							<th>사용 기간</th>
							<th>가격</th>
							<th>등록 상태</th>
							<th>노출 상태</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>`;
					
					$("#test").append(temp);
					
					$(selected).each(function(index, item) {
						
						let tmp = '';
						
						tmp += '<tr>';
						tmp += '<td>' + item.activityname + '</td>';
						tmp += '<td>' + item.pid + '(' + item.name + ')' + '</td>';
						tmp += '<td>' + item.location + '</td>';
						tmp += '<td>' + item.period + '</td>';
						tmp += '<td>' + item.price + '원</td>';
						tmp += '<td>' + item.value + '</td>';
						if(item.show == 'y') {
						tmp += '<td><input type="button" class="btn btn-primary btnsize" value="노출" onclick="activityshow(' + item.seq + ',' + '\'' + item.show + '\'' + ');">' + '</td>';
						} else if (item.show == 'n') {
							tmp += '<td><input type="button" class="btn btn-danger btnsize" value="비노출" onclick="activityshow(' + item.seq + ',' + '\'' + item.show + '\'' + ');">' + '</td>';
						}
						tmp += '</tr>';
						
							$("#test table tbody").append(tmp);
						
						});
					
				} 				
			},
			error: function(a,b,c) {
				console.log(a,b,c);
			}
		});
		
	}
	
</script>



















