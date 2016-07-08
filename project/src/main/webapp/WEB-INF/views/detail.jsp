<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="./include/header.jsp"%>
<style>
table {
	border-top: 1px solid black;
	border-left: 1px solid black;
	border-bottom: 1px solid black;
	border-right: 1px solid black;
}
</style>
<div>
	<h1>영화 상세</h1>
	<hr style="border: solid 1px black; margin: 0 auto;">
</div>
<div>
	<img src="http://img.cgv.co.kr/R2014/images/title/h1_cgv.png" alt="CGV"
		style="float: left; height: 300px; width: 220px;"> <span><font
		size="5px" ; weight="bold";>영화제목</font></span> <span
		class="label label-primary"
		style="padding-top: 10px; padding-bottom: 10px;">현재 상영중</span>
</div>
<div style="margin-top: 30px;">
	<span>예매율 :</span> <span>(관람객 : )</span>
</div>
<hr>
<div>
	<span>감독 : /</span> <span>배우 : </span>
</div>
<div>
	<span>장르 : /</span> <span>기본 : </span>
	<!-- 전체, 103분, 미국 -->
</div>
<div>
	<span>개봉일 : </span>
</div>
<div>
	<span>공식 사이트 : </span>
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
	<span> 줄거리 : 도리느느느느느느느</span>
</div>
<div>
	<table class="table">
		<thead>
			<tr>
				<th>매력포인트</th>
				<th>성별 예매 분표</th>
				<th>연령별 예매분표</th>
			</tr>
		</thead>
		<tr>
			<td>a</td>
			<td>a</td>
			<td>a</td>
		</tr>
	</table>
</div>
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">평점</button>
</div>

<div class="modal fade" id="myModal" role="dialog" style="margin: 0 auto;">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<H2>평점을 입력하세요</H2>
			</div>
			<div class="modal-body">
				<font style="size: 20px; font-weight: bold;">감독</font>
				<form role="form">
					
					<label class="radio-inline"> <input type="radio"
						name="optradio">1점
					</label> <label class="radio-inline"> <input type="radio"
						name="optradio">2점
					</label> <label class="radio-inline"> <input type="radio"
						name="optradio">3점
					</label>
					</label> <label class="radio-inline"> <input type="radio"
						name="optradio">4점
					</label>
					</label> <label class="radio-inline"> <input type="radio"
						name="optradio">5점
					</label>										
				</form>
				<font style="size: 20px; font-weight: bold;">영상미</font>
				<form role="form">
					<label class="radio-inline"> <input type="radio"
						name="optradio">1점
					</label> <label class="radio-inline"> <input type="radio"
						name="optradio">2점
					</label> <label class="radio-inline"> <input type="radio"
						name="optradio">3점
					</label>
					</label> <label class="radio-inline"> <input type="radio"
						name="optradio">4점
					</label>
					</label> <label class="radio-inline"> <input type="radio"
						name="optradio">5점
					</label>										
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">등록</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<%@include file="./include/footer.jsp"%>