<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="./include/header.jsp"%>
<script type="text/javascript" src="/resources/se2/js/HuskyEZCreator.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/./resources/se2/photo_uploader/plugin/hp_SE2M_AttachQuickPhoto.js"
	type="text/javascript" charset="utf-8"></script>
<div id="wrap_content" style="min-height: 100%; position: relative;">
	<div id="content" style="padding-bottom: 150px;">
		<h2>리뷰 작성</h2>
		<div style="margin-left: 110px;">
			<div>
				<img src="${movievo.poster}"
					alt="CGV" style="float: left; height: 240px; width: 190px; margin-left: 30px; margin-top: 40px;">
			</div>
			<div>
				<span style="margin-left:20px; margin-top: 20px;"> 
					<font size="6px"> ${movievo.title }</font>
				</span> 
			</div>
			<hr>
			<b>	
			<div>
				<span style="margin-left: 20px; margin-bottom: 10px;"> <font
					face="NanumBarunGothicBold">감독 :</font> <c:forEach
						items="${directorlist}" var="directorlist">
							 ${directorlist.director_name }	
						</c:forEach> 
				</span> <span style="margin-left: 10px; margin-bottom: 10px;">배우 : <c:forEach
						items="${actorlist}" var="actorlist">
							${actorlist.actor_name }   
						</c:forEach>
				</span>
			</div>
			<div>
				<span style="margin-left: 20px; margin-bottom: 10px;">장르 : <c:forEach
						items="${genrelist}" var="genrelist">
							${genrelist.movie_genre }
						</c:forEach>
				</span>
			</div>
			<div>
				<span style="margin-left: 20px; margin-bottom: 10px;"> 개봉일 : ${movievo.open_date } </span>
			</div>
			<div>
				<span style="margin-left: 20px; margin-bottom: 10px;"> 공식 사이트 : ${movievo.site } </span>
			</div>
		
		</div>		
		<div style="margin-left: 140px; margin-top: 120px;">
			<div
				style="width: 864px; padding: 4px; padding-left: 7px; border: 1px solid black">
				제 목 : <input type="text" id="review_title" name="review_title"
					size="50" />
			</div>
			<div
				style="width: 864px; padding: 4px; padding-left: 7px; border: 1px solid black;">
				작성자 : <input type="text" id="member_id" name="member_id" size="50" />
			</div>
			<textarea name="review_content" id="review_content" rows="20"
				cols="105"></textarea>
			<div>
				<div>
					<button type="button" class="btn btn-default"
						onclick="insertReview()" style="float:right;margin-right: 130px; width: 70px; height: 50px;">등록</button>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	var movie_id = '${movie_id}';
	var oEditors = [];
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors,
		elPlaceHolder : "review_content",
		sSkinURI : "/resources/se2/SmartEditor2Skin.html",
		fCreator : "createSEditor2",
	});

	function pasteHTML(filename) {

		var sHTML = '<img src="/resources/images/'+filename+'" style="width:400px; height:400px;">';

		oEditors.getById["review_content"].exec("PASTE_HTML", [ sHTML ]);

	}

	function insertReview() {
		oEditors.getById["review_content"].exec("UPDATE_CONTENTS_FIELD", []);
		var review_title = $("#review_title").val();
		var member_id = $("#member_id").val();
		var review_content = $("#review_content").val();
		$.ajax({
			type : 'post',
			url : '/review/new/' + movie_id,
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			data : JSON.stringify({
				"review_title" : review_title,
				"member_id" : member_id,
				"review_content" : review_content
			}),
			dataType : 'text',
			success : function(result) {
				if (result == "SUCCESS") {
					location.href = "/movie/" + movie_id
				}
			}
		});
	}
</script>


<%@include file="./include/footer.jsp"%>