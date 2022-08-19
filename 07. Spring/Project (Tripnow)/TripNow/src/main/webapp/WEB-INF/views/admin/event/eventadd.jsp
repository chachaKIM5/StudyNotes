<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트립나우</title>
<style>
	#acttable > tbody > tr:nth-child(4) > td{
	
		display:flex;
		font-size: 25px;
	}
	
	/* 	   이미지 컨테이너 */
		
	#image_container {
		display: flex;
	    overflow-x: auto;
	    width: 700px;
	    height: 205px;
	}
	
	#image_container > img {
		width: 200px;
		height: 200px;
	    margin: 0 15px;
	}
	
	#value{
	
		width:150px;
	
	}
	
	#info{
		
		font-size: 26px;
		margin-bottom:5px;
	
	}
	
	#acttable > tbody > tr:nth-child(6) > td > textarea{
			
		width: 720px;
		height: 220px;
		resize:none;
			
			
		}
	.btns {
		float: right;
		margin-bottom: 20px;
		margin-right: 10px;
	}	
		
</style>
</head>
<body>

	<div id="content">
		
		<form method="POST" action="/tripnow/admin/event/addok" class="main" enctype="multipart/form-data">
                    
        <div id="info">이벤트 추가</div>
        
        <table id="acttable" class="table table-bordered">
           <tr>
              <th>이벤트명</th>
              <td>
              	<input type="text" class="form-control" name="eventname" placeholder="이벤트명을 입력해 주세요." style="width: 550px;" >
              </td>
           </tr>
           <tr>
              <th>쿠폰명</th>
              <td>
                <input type="text" class="form-control" name="name" placeholder="쿠폰명을 입력해 주세요." style="width: 550px;" > 
              </td>
           </tr>
           <tr>
              <th>카테고리</th>
              <td>
                <select class="form-select" name="value" id="value" >
				  <option value="숙소">숙소</option>
				  <option value="렌터카">렌터카</option>
				  <option value="액티비티">액티비티</option>
				</select> 
              </td>
           </tr>
           <tr>
              <th>할인율</th>
              <td>
                <input type="text" name="rate" class="form-control"  style="width: 50px;" required pattern="[0-9]{1,2}">% 
              </td>
           </tr>
           
           <!-- 기간 -->
           <tr>
              <th>기간</th>
              <td>
                 <input type="date" name="enddate"  required/>
              </td>
           </tr> 
           <!-- 설명 -->
           <tr>
              <th>이벤트 정보</th>
              <td>
                 <textarea name="content"  cols="30" rows="10" placeholder="이벤트 상세설명을 입력해 주세요." required ></textarea>
              </td>
           </tr>
       		
      	   <!-- 진행여부 -->
          <tr>
              <th>진행 상태</th>
              <td>
                 <div class="form-check">
				  <input class="form-check-input" type="radio" name="finished" value="y" id="y" checked>
				  <label class="form-check-label" for="y">
				    진행중
				  </label>
				</div>
				<div class="form-check">
				  <input class="form-check-input" type="radio" name="finished" value="n" id="n">
				  <label class="form-check-label" for="n">
				    종료
				  </label>
				</div>
              </td>
           </tr>
		   <!-- 이미지등록 -->
           <tr>
           	  <th>이벤트 이미지 등록</th>
           	  <td>
				<div id="image_container"></div>
				<div><input type="file" name="attach" onchange="setThumbnail(event);" required></div>
		      </td>        
           </tr>
           
        </table>
        
        <div class="btns">
           <input type="submit" value="작성하기" class="btn btn-primary"/>
           <input type="button" value="돌아가기" class="btn btn-secondary" onClick="location.href='/tripnow/admin/event/eventmain';"/>
        </div>
        
     </form>
		
		
		
	</div>
	
	<script>

		function setThumbnail(event) {
	        var reader = new FileReader();
			if (document.getElementById("img")){
				document.getElementById("img").remove();
			}
	        reader.onload = function(event) {
	          var img = document.createElement("img");
	          img.setAttribute("src", event.target.result);
	          img.setAttribute("id", "img");
	          document.querySelector("div#image_container").appendChild(img);
	          
	        };

	        reader.readAsDataURL(event.target.files[0]);
	        
	        
	      }
		
		
		
		
		
	</script>

</body>
</html>














