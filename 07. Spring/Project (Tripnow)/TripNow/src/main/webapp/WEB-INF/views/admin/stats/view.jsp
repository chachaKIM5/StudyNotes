<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트립나우</title>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<script src="https://kit.fontawesome.com/404d069474.js" crossorigin="anonymous"></script>
<style>
	
	/* main.css -> #content의 height: auto로 수정 */
	#title {
		text-align: center;
		margin-left: 20px;
		padding-bottom: 20px;
		margin-bottom: 15px;
		border-bottom: 1px solid #DDD;
	}
	
	.subtitle {
		margin: 30px 0px 10px 20px;
	}
	
	#monthsales {
		width: 840px;
		display: flex;
		align-items: center;
	}
	
	#box {
		display: block;		
		height: 270px;
		margin-left: 40px;
		clear: both;
	}
	
	#pie {
		width: 450px;
	}
	
	text.highcharts-title,
	text.highcharts-subtitle {
		display: none;
	}
	
	.highcharts-figure,
	.highcharts-data-table table {
	    min-width: 450px;
	    max-width: 450px;
	    margin: 1em auto;
	}
	
	.highcharts-data-table table {
	    font-family: Verdana, sans-serif;
	    border-collapse: collapse;
	    border: 1px solid #ebebeb;
	    margin: 10px auto;
	    text-align: center;
	    width: 100%;
	    max-width: 500px;
	}
	
	.highcharts-data-table caption {
	    padding: 1em 0;
	    font-size: 1.2em;
	    color: #555;
	}
	
	.highcharts-data-table th {
	    font-weight: 600;
	    padding: 0.5em;
	}
	
	.highcharts-data-table td,
	.highcharts-data-table th,
	.highcharts-data-table caption {
	    padding: 0.5em;
	}
	
	.highcharts-data-table thead tr,
	.highcharts-data-table tr:nth-child(even) {
	    background: #f8f8f8;
	}
	
	.highcharts-data-table tr:hover {
	    background: #f1f7ff;
	}
	
	input[type="number"] {
	    min-width: 50px;
	}
	
	.sales {
		width: 250px;
		height: 70px;
		border: 1px solid #888;
		border-radius: 15px;
		display: flex;
		align-items: center;
		justify-content: center;
		margin-bottom: 20px;
		text-align: center;
	}
	
	.highcharts-figure2,
	.highcharts-data-table table {
	    min-width: 360px;
	    max-width: 800px;
	    max-height: 300px;
	    margin: 1em auto;
	}
	
	#containerbottom {
		height: 300px;
	}
	
	.highcharts-data-table table {
	    font-family: Verdana, sans-serif;
	    border-collapse: collapse;
	    border: 1px solid #ebebeb;
	    margin: 10px auto;
	    text-align: center;
	    width: 100%;
	    max-width: 500px;
	}
	
	.highcharts-data-table caption {
	    padding: 1em 0;
	    font-size: 1.2em;
	    color: #555;
	}
	
	.highcharts-data-table th {
	    font-weight: 600;
	    padding: 0.5em;
	}
	
	.highcharts-data-table td,
	.highcharts-data-table th,
	.highcharts-data-table caption {
	    padding: 0.5em;
	}
	
	.highcharts-data-table thead tr,
	.highcharts-data-table tr:nth-child(even) {
	    background: #f8f8f8;
	}
	
	.highcharts-data-table tr:hover {
	    background: #f1f7ff;
	}
	
	
	.hidden {
		display: none;
	}
	
	
	#homestats { background-color: #7CB5EC;}
	#carstats { background-color: #434348; color: white; }
	#actstats { background-color: #90ED7D; }
	
	
	#containerG {
    	height: 400px;
	}
	
	.highcharts-figure,
	.highcharts-data-table table {
	    min-width: 310px;
	    max-width: 800px;
	    margin: 1em auto;
	}
	
	#datatable {
	    font-family: Verdana, sans-serif;
	    border-collapse: collapse;
	    border: 1px solid #ebebeb;
	    margin: 10px auto;
	    text-align: center;
	    width: 100%;
	    max-width: 500px;
	}
	
	#datatable caption {
	    padding: 1em 0;
	    font-size: 1.2em;
	    color: #555;
	}
	
	#datatable th {
	    font-weight: 600;
	    padding: 0.5em;
	}
	
	#datatable td,
	#datatable th,
	#datatable caption {
	    padding: 0.5em;
	}
	
	#datatable thead tr,
	#datatable tr:nth-child(even) {
	    background: #f8f8f8;
	}
	
	#datatable tr:hover {
	    background: #f1f7ff;
	}
	
	
	.selected {
		color: cornflowerblue;
	}
	
	#title span:hover {
		cursor: pointer;
	}
		
		
	#partone {
		margin-bottom: 30px;
	}
	
	
	
	
</style>
</head>
<body>
 
	<div id="content">
	
	<h2 id="title"><span onclick="showone()" class="selected">월별 매출 통계</span>  |  <span onclick="showtwo()">성별 매출 통계</span></h2>
		<div id="partone">
			<h4 class="subtitle"><i class="fa-solid fa-check"></i>  당월 매출 통계</h4>
			<div id="monthsales">
				<div id="pie">
				
				<figure class="highcharts-figure">
				    <div id="container"></div>
				    <p class="highcharts-description">
				    </p>
				</figure>
				
				</div>
				
				<div id="box">
					<div id="homestats" class="sales">숙소<br></div>
					<div id="carstats" class="sales">렌터카<br></div>
					<div id="actstats" class="sales">액티비티<br></div>
				</div>
			</div>
			
			<h4 class="subtitle"><i class="fa-solid fa-check"></i>  6개월 매출 통계</h4>
				<figure class="highcharts-figure2">
				    <div id="containerbottom"></div>
				    <p class="highcharts-description">
				    </p>
				</figure>
		</div>
		
		<div id="parttwo" class="hidden">
			<h4 class="subtitle"><i class="fa-solid fa-check"></i>  성별 매출 통계</h4>
		
		<figure class="highcharts-figure">
		    <div id="containerG"></div>
		    <p class="highcharts-description">
		    </p>
		</figure>
		</div>
	
	</div>
	
	<script>
		
		let homes;
		let cars;
		let acts;
		let totals;
		
		<c:forEach items="${homestats}" var="dto">
			if ("${dto.month}" == ${nmonth}) {	
				homes = "${dto.sales}";
			}	
		</c:forEach>

		<c:forEach items="${carstats}" var="dto">
			if ("${dto.month}" == ${nmonth}) {	
				cars = "${dto.sales}";
			}	
		</c:forEach>
		
		<c:forEach items="${actstats}" var="dto">
			if ("${dto.month}" == ${nmonth}) {	
				acts = "${dto.sales}";
			}	
		</c:forEach>

		
		totals = homes + cars + acts;
	
		Highcharts.chart('container', {
		    chart: {
		        plotBackgroundColor: null,
		        plotBorderWidth: null,
		        plotShadow: false,
		        type: 'pie'
		    },
		    title: {
		        text: '당월 전체 매출 통계'
		    },
		    tooltip: {
		        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
		    },
		    accessibility: {
		        point: {
		            valueSuffix: '%'
		        }
		    },
		    plotOptions: {
		        pie: {
		            allowPointSelect: true,
		            cursor: 'pointer',
		            dataLabels: {
		                enabled: true,
		                format: '<b>{point.name}</b>: {point.percentage:.1f} %'
		            }
		        }
		    },
		    series: [{
		        name: '매출',
		        colorByPoint: true,
		        data: [{
		            name: '숙소',
		            y: homes / totals,
		            sliced: true,
		            selected: true
		        }, {
		            name: '렌터카',
		            y: cars / totals
		        },  {
		            name: '액티비티',
		            y: acts / totals
		        }]
		    }]
		});
		
		
		$('#homestats').append(homes + '원');
		$('#carstats').append(cars + '원');
		$('#actstats').append(acts + '원');
		
		
		
		let homesales = [];
		let carsales = [];
		let actsales = [];
		
		<c:forEach items="${homestats}" var="dto">
			homesales.push(${dto.sales});
		</c:forEach>	
		<c:forEach items="${carstats}" var="dto">
			carsales.push(${dto.sales});
		</c:forEach>	
		<c:forEach items="${actstats}" var="dto">
			actsales.push(${dto.sales});
		</c:forEach>	
		
		homesales.reverse();
		carsales.reverse();
		actsales.reverse();
		

		Highcharts.chart('containerbottom', {

		    title: {
		        text: ' '
		    },

		    subtitle: {
		        text: ' '
		    },

		    yAxis: {
		        title: {
		            text: '매출액'
		        }
		    },

		    xAxis: {
		        accessibility: {
		            rangeDescription: 'Range: ' + ${nmonth - 5} + 'to ' + ${nmonth}
		        }
		    },

		    legend: {
		        layout: 'vertical',
		        align: 'right',
		        verticalAlign: 'middle'
		    },

		    plotOptions: {
		        series: {
		            label: {
		                connectorAllowed: false
		            },
		            pointStart: ${nmonth - 5}
		        }
		    },

		    series: [{
		        name: '숙소',
		        data: homesales
		    }, {
		        name: '렌터카',
		        data: carsales
		    }, {
		        name: '액티비티',
		        data: actsales
		    }],

		    responsive: {
		        rules: [{
		            condition: {
		                maxWidth: 500
		            },
		            chartOptions: {
		                legend: {
		                    layout: 'horizontal',
		                    align: 'center',
		                    verticalAlign: 'bottom'
		                }
		            }
		        }]
		    }
		});
		
		
		
		
		
		let msales = [];
		let fsales = [];
		
		
		<c:forEach items="${gstats}" var="dto">
			msales.push(${dto.male});
			fsales.push(${dto.female});
		</c:forEach>	
		
		Highcharts.chart('containerG', {
		    chart: {
		        type: 'column'
		    },
		    title: {
		        text: ' '
		    },
		    subtitle: {
		        text: ' '
		    },
		    xAxis: {
		        categories: [
		            ${nmonth - 5} + '월',
		            ${nmonth - 4} + '월',
		            ${nmonth - 3} + '월',
		            ${nmonth - 2} + '월',
		            ${nmonth - 1} + '월',
		            ${nmonth} + '월'
		        ],
		        crosshair: true
		    },
		    yAxis: {
		        min: 0,
		        title: {
		            text: '인원 (명)'
		        }
		    },
		    tooltip: {
		        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
		        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
		            '<td style="padding:0"><b>{point.y:f} 명</b></td></tr>',
		        footerFormat: '</table>',
		        shared: true,
		        useHTML: true
		    },
		    plotOptions: {
		        column: {
		            pointPadding: 0.2,
		            borderWidth: 0
		        }
		    },
		    series: [{
		        name: '남',
		        data: msales

		    }, {
		        name: '여',
		        data: fsales

		    }]
		});

		
		
		function showone() {
			$('#partone').removeClass("hidden");
			$('#parttwo').addClass("hidden");
		
			$('#title span').eq("0").addClass("selected");
			$('#title span').eq("1").removeClass("selected");
		}
		
		function showtwo() {
			$('#partone').addClass("hidden");
			$('#parttwo').removeClass("hidden");
			
			$('#title span').eq("0").removeClass("selected");
			$('#title span').eq("1").addClass("selected");
		}


	</script>
</body>
</html>