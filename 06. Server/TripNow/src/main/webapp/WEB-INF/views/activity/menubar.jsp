<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TripNow(트립나우)</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
<script src="https://npmcdn.com/flatpickr/dist/flatpickr.min.js"></script><script src="https://npmcdn.com/flatpickr/dist/l10n/ko.js"></script>
<style>
   #searchbar {
   
      
      height: 70px;
      
      background-color:    #FFFAFA ;
      
      width: 850px;
      margin:auto;
      margin-top: -34px;
      border-radius:30px;
      
      box-shadow: 3px 3px 1px ;
       
      
      
   }
   
   #b_search {
      display: flex;
      justify-content: center;
      
      padding: 14px 0px 0px 0px;
   }
   
   .fa-location-dot, .fa-calendar-check, .fa-children {
      position: absolute;
      padding: 13px 0 15px 10px;
   }
   
   .fa-sort-down {
      position: relative;
      left: -55px;
      top: -2px;
      margin-left: 30px;
   }
   
   #maphide .fa-sort-down {
      left: 195px;
      top: -31px;
   }
   
   #b_search input[type=text], #b_search input[type=number] {
      height: 40px;
      padding-left: 30px;
      padding-right: 30px;
      background-color: #f5f6f7;
      border: 1px solid black;
      border-radius: 5px;
   }
   
   #b_search input[type=number] {
   
   }
   
   #b_search div:nth-child(1) input[type=text] {
      width: 250px;
   }
   
   #b_search div:nth-child(2){
   margin-right:-15px;
   }
   
   #b_search div:nth-child(2) input[type=text] {
      width: 150px;
   }
   
   #b_search div:nth-child(3) input[type=number] {
      width: 90px;
      padding-left: 35px;
      margin-right: 10px;
      text-align: center;
      padding-right: 10px;
   }
   
   #b_search div:nth-child(3) .fa-sort-down {
      top: -31px;
      left: 35px;
   }
   
   
   
   #b_search div:nth-child(3) { 
      margin-right: -12px; 
      width: 150px;
   }
   
   #homesearch {
      background-color: #60c1f0; 
      color: white;
      width: 60px;
      height: 40px;
      font-weight: bold;
      border-width: 0;
      border-radius: 5px;
   }

   .catesel {
      font-weight: bold;
      border-bottom: 3px solid #60c1f0;
   }
   
   #maphide > ul {
      display: none;
      margin: 0;
      padding: 10px 0 5px 20px;
      list-style-type: none;
      width: 130px;
      position: relative;
      border: 1px solid black;
      top: -20px;
   }
   
   #maphide:hover ul {
      display: block;
      background-color: white;
   }
   
   #maphide ul > li {
      padding-bottom: 8px;
   }
   
   #maphide ul > li:hover > ul {
      display: block;
   }
   
   #maphide ul > li > ul:hover ul {
      display: block;
   }
   
   #maphide ul > li > ul {
      list-style: none;
      border: 1px solid black;
      position: absolute;
      margin: 0;
      padding: 10px 0 5px 20px;
      width: 180px;
      left: 128px;
      top: -1px;
   }
   
   .inlinetext {
      width: 250px;
      margin-right:20px;
      
   }
   
   /* input[type="number"]::-webkit-outer-spin-button,
   input[type="number"]::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
   } */
   
   .count {
      width: 100px;
   }
   
   #maphide > ul {
      z-index:1;
   }
   
   #b_search > div:nth-child(2){
      margin-right:22px;
   }
      
</style>
</head>
<body>
   <main>
      <section>
         <div id="searchbar">
            <form method="POST" action="/tripnow/activity/activitylist.do">
               <div id="b_search">
                  <div class="inlinetext">
                     <div id="maphide">
                     <i class="fa-solid fa-location-dot"></i>
                     <input type="text" id="loca" name="region" value="${region}">
                     <i class="fa-solid fa-sort-down"></i>
                        <ul class="Nmapsido">
                           <li class="mapsido">
                              <div>서울특별시</div>
                              <ul class="hide">
                                 <li>강남/역삼/삼성/논현</li>
                                 <li>2</li>
                                 <li>3</li>
                                 <li>4</li>
                                 <li>5</li>
                                 <li>6</li>
                                 <li>7</li>
                              </ul>
                           </li>
                           <li class="mapsido">
                              <div>경기도</div>
                              <ul class="hide">
                                 <li>가평군</li>
                                 <li>안양시</li>
                                 <li>3</li>
                              </ul>
                           </li>
                           <li class="mapsido">인천광역시</li>
                           <li>강원도</li>
                           <li>제주특별시</li>
                           <li>대전광역시</li>
                           <li>충청북도</li>
                           <li>충청남도</li>
                           <li>세종시</li>
                           <li>부산광역시</li>
                           <li>울산광역시</li>
                           <li>경상남도</li>
                           <li>대구광역시</li>
                           <li>경상북도</li>
                           <li>광주광역시</li>
                           <li>전라남도</li>
                           <li>전라북도</li>
                        </ul>
                        
                     </div>
                  </div>
                  <div>
                     <i class="fa-solid fa-calendar-check"></i>
                     <input type="text" id="dates" name="date" value="${date}">
<!--                      <i class="fa-solid fa-sort-down"></i> -->
                  </div>
                  <div>
                     <i class="fa-solid fa-children"></i>
                     <input type="number" class="count" name="count" value="${count}" min="1" max="5">명
                  </div>
                  <input id="homesearch" type="submit" value="조회">
               </div>
            </form>
         </div>
      </section>

   </main>
   
   <script>
      
      
      const changeText = $(".Nmapsido li > div").click(function() {
         
         $("#loca").val($(this).text());
      })
   
      const changeText2 = $(".hide li").click(function() {
         $("#loca").val($(this.parentNode.previousElementSibling).text()+' '+$(this).text());
      })
   
      $(".mapsido").mouseover(function() {
         $(this).find(".hide").removeClass("hide").addClass("show");
      });
      
      $(".mapsido").mouseout(function() {
         $(this).find(".show").removeClass("show").addClass("hide");
      });
      
      
      if(!changeText == null) {
         
      }
      
      const str = $("#dates").text();
      
      const arr = str.split("-");
      
      const d1 = new Date();
         d1.setDate(d1.getDate() + 2);
         d1.setFullYear(arr[0]);
         d1.setMonth(arr[1]);
         d1.setDate(arr[2]);
         
   
      flatpickr.localize(flatpickr.l10ns.ko);
      flatpickr($("#dates"));      
      $("#dates").flatpickr({
         local: 'ko',
         dateFormat: "Y-m-d(D)",
         autoclose : true,
         minDate: "today",
         defaultDate: [d1]
      });
   </script>

   </body>
</html>