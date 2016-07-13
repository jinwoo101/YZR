<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="./include/header.jsp"%>
<link rel="stylesheet" href="http://jquery-ui.googlecode.com/svn/tags/1.8.19/themes/ui-lightness/jquery.ui.all.css" type="text/css" media="screen" title="no title" charset="utf-8" />    
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
<!-- 하이차트... -->
<script src="http://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/highcharts-more.js"></script>
<script src="http://code.highcharts.com/modules/exporting.js"></script>

<div id="wrap_content" style="min-height: 100%; position: relative;">
	<div id="content">
		<div>
			<h1>영화 상세</h1>
			<hr style="border: solid 1px black; margin: 0 auto;">
		</div>
		<div>
			<img src="http://img.cgv.co.kr/R2014/images/title/h1_cgv.png" alt="CGV" style="float: left; height: 300px; width: 220px;"> 
			<span>
				<font size="5px" ; weight="bold";>${vo.title }</font>
			</span> 
			<span class="label label-primary" style="padding-top: 10px; padding-bottom: 10px;">
				현재 상영중
			</span>
		</div>
		<div style="margin-top: 30px;">
			<span>예매율 : </span> <span>(관람객 :  )</span>
		</div>
		<hr>
		<div>
			<span>감독 :
				<c:forEach items="${directorlist}" var="directorlist">
					 ${directorlist.director_name }, 	
				</c:forEach> / 
			</span>
			<span>배우 : 
				<c:forEach items="${actorlist }" var="actorlist">
					${actorlist.actor_name }
				</c:forEach>
			</span>
		</div>
		<div>
			<span>장르 : </span> 
		</div>
		<div>
			<span>개봉일 : ${vo.open_date } </span>
		</div>
		
		<div>
			<span>공식 사이트 : ${ vo.site }</span>
		</div>
		
		<div
			style="margin-top: 10px; margin-left: 60px; margin-bottom: 35px; margin-top: 20px;">
			<span class="label label-danger"
				style="padding-top: 10px; padding-bottom: 10px;">예매하러가기
			</span>
		</div>
		<div class="btn-group btn-group-justified"
			style="margin: 0 auto; width: 250px;">
			<a href="#" class="btn btn-danger">Apple</a> <a href="#"
				class="btn btn-danger">Samsung</a> <a href="#" class="btn btn-danger">Sony</a>
		</div>
		<div style="margin-top: 35px; height: 300px; border: 1px solid black;">
			<span> 줄거리 : ${vo.story }</span>
		</div>
		<div>
			<table class="table">
				<tr>
					<td>    
						<div id="container1" style="width: 420px; height: 300px;"></div> 
		    		</td>
					<td><div id="container2" style="width: 300px; height: 300px;margin-left: 10px;"></div> </td>
					<td><div id="container3" style="width: 300px; height: 300px;margin-left: 10px;"></div></td>
				</tr>
			</table>
		</div>
		  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">평점</button>
		</div>
		<div class="modal fade" id="myModal" role="dialog" style="margin: 0 auto;">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<form id="form">
						<div class="modal-header">
							<H2>평점을 입력하세요</H2>
						</div>
						<div class="modal-body">
							<font style="size: 20px; font-weight: bold;">배우연기</font><br>
								<label class="radio-inline"> 
									<input type="radio"	name="acting" value="10">10점
								</label> 
								<label class="radio-inline"> 
									<input type="radio" name="acting" value="20">20점
								</label> 
								<label class="radio-inline"> 
									<input type="radio" name="acting" value="30">30점
								</label>
								<label class="radio-inline"> 
									<input type="radio"	name="acting" value="40">40점
								</label>
								<label class="radio-inline"> 
									<input type="radio" name="acting" value="50">50점
								</label><br>												
							<font style="size: 20px; font-weight: bold;">감독연출</font><br>
								<label class="radio-inline"> 
									<input type="radio"	name="direction" value="10">10점
								</label> 
								<label class="radio-inline"> 
									<input type="radio" name="direction" value="20">20점
								</label> 
								<label class="radio-inline"> 
									<input type="radio" name="direction" value="30">30점
								</label>
								<label class="radio-inline"> 
									<input type="radio"	name="direction" value="40">40점
								</label>
								<label class="radio-inline"> 
									<input type="radio" name="direction" value="50">50점
								</label><br>								
							<font style="size: 20px; font-weight: bold;">영상미</font><br>
								<label class="radio-inline"> 
									<input type="radio"	name="beauty" value="10">10점
								</label> 
								<label class="radio-inline"> 
									<input type="radio" name="beauty" value="20">20점
								</label> 
								<label class="radio-inline"> 
									<input type="radio" name="beauty" value="30">30점
								</label>
								<label class="radio-inline"> 
									<input type="radio"	name="beauty" value="40">40점
								</label>
								<label class="radio-inline"> 
									<input type="radio" name="beauty" value="50">50점
								</label><br>							
							<font style="size: 20px; font-weight: bold;">OST</font><br>
								<label class="radio-inline"> 
									<input type="radio"	name="ost" value="10">10점
								</label> 
								<label class="radio-inline"> 
									<input type="radio" name="ost" value="20">20점
								</label> 
								<label class="radio-inline"> 
									<input type="radio" name="ost" value="30">30점
								</label>
								<label class="radio-inline"> 
									<input type="radio"	name="ost" value="40">40점
								</label>
								<label class="radio-inline"> 
									<input type="radio" name="ost" value="50">50점
								</label><br>									
							<font style="size: 20px; font-weight: bold;">스토리</font><br>
								<label class="radio-inline"> 
									<input type="radio"	name="story" value="10">10점
								</label> 
								<label class="radio-inline"> 
									<input type="radio" name="story" value="20">20점
								</label> 
								<label class="radio-inline"> 
									<input type="radio" name="story" value="30">30점
								</label>
								<label class="radio-inline"> 
									<input type="radio"	name="story" value="40">40점
								</label>
								<label class="radio-inline"> 
									<input type="radio" name="story" value="50">50점
								</label><br>										
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal" onclick="updategpa()">등록</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

<script>
var resulta = null;

function updategpa(){
	var acting = $(':radio[name="acting"]:checked').val();
	var direction = $(':radio[name="direction"]:checked').val();
	var beauty = $(':radio[name="beauty"]:checked').val();
	var ost = $(':radio[name="ost"]:checked').val();
	var story = $(':radio[name="story"]:checked').val();
	alert(acting);
	$.ajax({
		type : 'put',
		url : '/detail/chart/${movie_id}',
		headers : { 
			"Content-Type" : "application/json",
			"X-HTTP-Method-Override" : "PUT"
			},
		data : JSON.stringify({
			"acting" : acting,
			"direction" : direction,
			"beauty" : beauty,
			"ost" : ost,
			"story" : story,
			"data"  : resulta
			}) ,
		dataType : 'json',
		success : function(result){
			if(result == "SUCCESS"){
				getList();
			}
		}
	});
}

function getList(){
	
	$.ajax({
		type : 'get',
		url : '/detail/chart/${movie_id}',
		headers : {
			"Content-Type" : "application/json",
			//"X-HTTP-Method-Override" : "GET",  ----  POST 이거나 GET인경우는 생략가능
		},
		dataType : 'json',
		data : '',
		success : function(result){
			getSpider(result);
			getDonut1(result);
			getDonut2(result);
			resulta = result;
		}
	});
}
getList();

function getSpider(data) {
	$('#container1').highcharts({
		chart: {
            polar: true,
            type: 'line'
        },
        title: {
            text: '매력포인트',
            x: -80
        },
        pane: {
            size: '70%'
        },
        xAxis: {
            categories: ['배우연기', '감독연출', '영상미', 'ost',
                    '스토리'],
            tickmarkPlacement: 'on',
            lineWidth: 0
        },
        yAxis: {
            gridLineInterpolation: 'polygon',
            lineWidth: 0,
            min: 0
        },
        legend: {
            align: 'right',
            verticalAlign: 'top',
            y: 70,
            layout: 'vertical'
        },
        series: [{
            name: 'Allocated Budget',
            data: [data.acting,data.direction, data.beauty, data.ost, data.story],
            pointPlacement: 'on'
        }]
    });
}

function getDonut1(data){
    // Make monochrome colors and set them as default for all pies
	Highcharts.getOptions().plotOptions.pie.colors = (function () {
		var colors = [],
			base = Highcharts.getOptions().colors[0],
			i;
		for (i = 0; i < 10; i += 1) {
            // Start out with a darkened base color (negative brighten), and end
			// up with a much brighter color
			colors.push(Highcharts.Color(base).brighten((i - 3) / 7).get());
		}
		return colors;
	}());
    // Build the chart
    $('#container2').highcharts({
		chart: {
			plotBackgroundColor: null,
			plotBorderWidth: null,
			plotShadow: false,
			type: 'pie'
        },
		title: {
			text: '성별예매'
		},
		tooltip: {
			pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                }
            }
        },
        series: [{
            name: '성별',
            data: [
                { name: '남자', y: data.male  },
                { name: '여자', y: data.female },
            ]
        }]
    });
}

function getDonut2(data){

    // Make monochrome colors and set them as default for all pies
    Highcharts.getOptions().plotOptions.pie.colors = (function () {
        var colors = [],
            base = Highcharts.getOptions().colors[0],
            i;

        for (i = 0; i < 10; i += 1) {
            // Start out with a darkened base color (negative brighten), and end
            // up with a much brighter color
            colors.push(Highcharts.Color(base).brighten((i - 3) / 7).get());
        }
        return colors;
    }());

    // Build the chart
    $('#container3').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        title: {
            text: '연령별 예매'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                }
            }
        },
        series: [{
            name: 'Brands',
            data: [
                { name: '10대', y: data.teenager },
                { name: '20대', y: data.twenties},
                { name: '30대', y: data.thirties },
                { name: '40대', y: data.forties },
            ]
        }]
    });
}
</script>
<%@include file="./include/footer.jsp"%>