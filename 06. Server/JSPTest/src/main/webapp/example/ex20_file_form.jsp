<%@page import="java.util.Comparator"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	//디렉토리 탐색
	String path = application.getRealPath("/example/images");

	File dir = new File(path);
	
	File[] list = dir.listFiles();
	
	//System.out.println(Arrays.toString(list));
			
	/* [C:\class\server\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\JSPTest\example\images\0-3156_red-cross-png-file-red-x-transparent-png.png,
	    C:\class\server\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\JSPTest\example\images\22-227239_download-speech-bubble-png-image-star-design-clip.png,
	    C:\class\server\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\JSPTest\example\images\2의자.png,
	    C:\class\server\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\JSPTest\example\images\7쓰레기통.png,
	    C:\class\server\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\JSPTest\example\images\rect_icon.png] */
	
	//System.out.println(list[0].getName());
	
	//System.out.println(list[0].lastModified());
	//Calendar temp = Calendar.getInstance();
	
	//temp.setTimeInMillis(list[0].lastModified());
	
	//System.out.println(list[0].getName());
	//System.out.printf("%tF %tT\n", temp, temp);
	
	//file.lastModified를 이용해 업로드한 순서대로 정렬하기
	Arrays.sort(list, new Comparator<File>() {
		public int compare(File a, File b) {
			return Long.compare(a.lastModified(), b.lastModified());
		}
		
	});

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/example/inc/asset.jsp" %>
<style>
	#list {
		width: 800px;
		margin-top: 20px;
		margin-bottom: 30px;
	}
	
	#list > div {
		float: left;
		border: 1px solid #999;
		margin: 15px;
		width: 126px;
		height: 126px;
		background-size: contain;
		background-repeat: no-repeat;
		background-position: center center;
		position: relative;
		left: 0;
		top: 0;
	}
	
	#list > div > span {
		font-size: 1.5em;
		position: absolute;
		right: 6px;
		top: 0;
		cursor: pointer;
		display: none;
	}
	
	#list > div:hover > span {
		display: inline;
	}
	
	#list::after {
		content: '';
		display: block;
		clear: both;
	}
	
/* 	#list > div > img {
		
		width: 126px;
		height: 126px;
		
	} */
	
	
	.modal-body > img {
	
		display: block;
		margin: 15px auto;
		
		/*
		width: 고정 크기
		max-width: max-width보다 작을 땐 객체 크기, 클 땐 지정 크기로 지우기
		min-width: min-width보다 클 땐 객체 크기, 작을 땐 지정 크기로 키우기 
		*/
		max-width: 560px;
	}
	
	#exampleModal .modal-dialog {
       -webkit-transform: translate(0,-50%);
       -o-transform: translate(0,-50%);
       transform: translate(0,-50%);
       top: 50%;
       margin: 0 auto;
   }

</style>
</head>
<body>
	
	<!-- ex20_file_form.jsp -->
	<div class="container">
		<h1>Image Gallery</h1>
		
		<div id="list">
		
			<% for (File img : list) { %>
				<%-- <div><img src="images/<%= img.getName() %>"></div> --%>
				<div style="background-image: url(images/<%= img.getName() %>);" data-toggle="modal" data-target="#exampleModal" onclick="showImage('<%= img.getName() %>');">
				<span title="delete" onclick="deleteImage('<%= img.getName() %>');">&times;</span>
				</div>
			<% } %>
			
		</div>
		
		<form method="POST" action="ex20_file_ok.jsp" enctype="multipart/form-data">
			<table class="table">
				<tr>
					<th>이미지</th>
					<td><input type="file" name="attach" required></td>
				</tr>
			</table>
			
			<div>
				<input type="submit" value="이미지 업로드" class="btn btn-success">
			</div>
		</form>
	</div>
	

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-xl">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       	<img src="images/1.png">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>


	<script>
	
		function showImage(img) {
			$('.modal-body > img').attr('src', 'images/' + img);
			$('#exampleModalLabel').text(img);
		}		
		
		function deleteImage(img) {
			
			
			if (confirm('delete?')) {
				location.href = 'ex20_file_delete.jsp?filename=' + img;				
			}
			
			
			//cancelBubble과 같은 역할 -> delete?에서 cancel을 눌러도 modal이 안 뜨도록 막아준다
			event.stopPropagation();
		}
		
	</script>

</body>
</html>