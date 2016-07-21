<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="./include/header.jsp"%>
<script type="text/javascript" src="/resources/se2/js/HuskyEZCreator.js" charset="utf-8"></script>


<style>
#wrap {
	margin: 0 auto;
	width: 1000px;
}

#titlediv {
	width: 998px;
	height: 20px;
	font-size: 15px;
	text-align: left;
}

#contentdiv {
	width: 997px;
	height: 320px;
	font-size: 20px;
}

#listbtdiv {
	float: right;
	margin-top: 10px;
	margin-right: 15px;
	margin-bottom: 10px;
}

hr.hrone, hr.hrtwo {
	width: 990px;
	border: 1;
	border-top: 1px solid;
}

#reply_write_wrap {
	height: 180px;
	background-color: #F5F6F9;
	margin-bottom: 30px;
}

#reply_submit {
	margin-top: 10px;
	margin-right: 10px;
	float: right;
}

#uid {
	margin-bottom: 5px;
	width: 200px;
}

#div_re_uid , .reply_list_wrap2 {
	margin-left: 10px;
}

#reply_write_submit_2, #like2 {
	float: right;
	margin-right: 10px;
	margin-top: 0px;
	margin-bottom: 0px;
}

#replylisthr, #replyreplyhr {
	width: 960px;
	boader: none;
	border-top: 1px solid gray;
}
</style>
</head>
<body>
	<div class="container">
		<div id="wrap" class="wrap" name="wrap">
			<div>
				<h2>후기</h2>
			</div>
				
			<div style="margin-left:140px;">
				<div style="width:862px; padding:4px; padding-left:7px; border:1px solid black">
						제  목  : <input type="text" id="review_title" name="review_title" size="50" value="${reviewvo.review_title }"/>
					</div>
					<div style="width:862px; padding:4px; padding-left:7px; border:1px solid black;">
						작성자 : <input type="text" id="member_id" name="member_id" size="50" value=" ${reviewvo.member_id}" readonly="readonly"/>
					</div>
						<textarea name="review_content" id="review_content" rows="10" cols="120"> ${reviewvo.review_content }</textarea>
					<div>
					<div>
						<button type="button" class="btn btn-default" onclick="updateReview()">등록</button>
					</div>
				</div>
			</div>	
		</div>
	</div>

<script type="text/javascript">
var movie_id = "${reviewvo.movie_id}";
var no = "${reviewvo.no}";
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
    oAppRef: oEditors,
    elPlaceHolder: "review_content",
    sSkinURI: "/resources/se2/SmartEditor2Skin.html",
    fCreator: "createSEditor2",
});

function toList() {
	location.href="/detail/"+movie_id1;
}

function updateReview() {
	oEditors.getById["review_content"].exec("UPDATE_CONTENTS_FIELD", []);
	var review_title = $("#review_title").val();
	var review_content =  $("#review_content").val();
	$.ajax({
		type : 'put',
		url : '/review/update/'+no ,
		headers : {
			"Content-Type" : "application/json",
			"X-HTTP-Method-Override" : "PUT"
		},
		data : JSON.stringify({
			"review_title" : review_title,
			"review_content" : review_content,
			"no" : no
		}),
		dataType : 'text',
		success : function(result) {
			if (result == "SUCCESS") {
				location.href="/detail/review_read/"+no
			}
		}
	});
}

</script>
<%@include file="./include/footer.jsp"%>