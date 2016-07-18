<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="./include/header.jsp"%>
<script type="text/javascript" src="/resources/se2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="/resources/se2/photo_uploader/plugin/hp_SE2M_AttachQuickPhoto.js" type="text/javascript" charset="utf-8"></script>
<div id="wrap_content" style="min-height: 100%; position: relative;">
	<div id="content" style="padding-bottom: 150px;">
		<h2>리뷰 작성</h2>
			<div style="margin-left:140px;">
				<div style="width:862px; padding:4px; padding-left:7px; border:1px solid black">
					제  목  : <input type="text" id="review_title" name="review_title" size="50"/>
				</div>
				<div style="width:862px; padding:4px; padding-left:7px; border:1px solid black;">
					작성자 : <input type="text" id="member_id" name="member_id" size="50"/>
				</div>
					<textarea name="review_content" id="review_content" rows="10" cols="120"></textarea>
				<div>
				<div>
					<button type="button" class="btn btn-default" onclick="insertReview()">등록</button>
				</div>
			</div>
		</div>	
	</div>
</div>

<script type="text/javascript">
var movie_id = '${movie_id}';
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
    oAppRef: oEditors,
    elPlaceHolder: "review_content",
    sSkinURI: "/resources/se2/SmartEditor2Skin.html",
    fCreator: "createSEditor2",
});
//textArea에 이미지 첨부
function pasteHTML(filepath) {
	var sHTML = '<span style="color:#FF0000;"<img src="'+filepath+'"></span>';
	oEditors.getById["review_content"].exec("PASTE_HTML", [ sHTML ]);
}


function insertReview() {
	oEditors.getById["review_content"].exec("UPDATE_CONTENTS_FIELD", []);
	var review_title = $("#review_title").val();
	var member_id = $("#member_id").val();
	var review_content =  $("#review_content").val();
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
				location.href="/detail/"+movie_id
			}
		}
	});
}
</script>


<%@include file="./include/footer.jsp"%>