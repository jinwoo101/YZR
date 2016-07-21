<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="./include/header.jsp"%>

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
			<!-- 제목 작성자 날짜 -->
			<div id="titlediv" style="padding: 10px;">
				제목 : ${reviewvo.review_title }
			</div>
			<div style="padding: 10px; margin-bottom: 30px;">
				<div id="member_id" style="float: left;">아이디 : ${reviewvo.member_id} </div>
				<div id="review_date" style="float: right; ">등록 : ${reviewvo.review_date}</div>
			</div>
			<div style="width: 950px; height: 450px; margin-top: 20px; margin-left: 20px;">
				 ${reviewvo.review_content }
			</div>	
			<div id="listbtdiv">
				<button type="button" class="btn btn-danger" onclick="eidt_review()">수정</button>
				<button type="button" class="btn btn-danger" onclick="toList()">목록</button>
				<button type="button" class="btn btn-danger" onclick="delete_review()">삭제</button>
				
			</div>
			<hr class="hrone">
			<!-- 선긋기 -->
			<!-- 댓글작성1 -->
			<div id="reply_write_wrap" class="reply_write_wrap">
				<div id="reply_write_input" class="reply_write_input">
					<input type="hidden" id="reply_reply" class="reply_reply" name="reply_reply" value="n" /> 
					<input type="text" id="user_id"	name="user_id" class="form-control" data-rule-required="true" placeholder="이름" maxlength="20" />
					<textarea id="reply_content" name="reply_content" class="form-control col-lg-12" rows="4" style="resize: none;"></textarea>
					<input type="hidden" id="review_no" name="review_no" value="${reviewvo.no }" />
				</div>
				</form>
				<div class="reply_write_submit" id="1">
					<button id="reply_submit" class="reply_submit btn btn-primary"
						onclick="insertReply(${reviewvo.no})">댓글 등록</button>
				</div>
			</div>
			<hr class="hrone">
			<div id="reply" class="reply"></div>
			</div>
		</div>
	</div>
<script type="text/javascript">
var review_no = "${reviewvo.no}";
var movie_id =  "${reviewvo.movie_id}";
var review_title ="${reviewvo.review_title}";
var review_content = "${reviewvo.review_content}";
var member_id = "${reviewvo.member_id}";


function delete_review(){
	$.ajax({
		type : 'delete',
		url : '/movie/review_delete/' + review_no ,
		headers : { 
			"Content-Type" : "application/json"
			},
		data : '',
		dataType : 'text',
		success : function(result){
			 delete_review_reply()
		}
	});
}

function delete_reply(r_no){
	$.ajax({
		type : 'delete',
		url : '/movie/reply_delete/' + r_no ,
		headers : { 
			"Content-Type" : "application/json"
			},
		data : '',
		dataType : 'text',
		success : function(result){
			location.href="/movie/review_read/"+review_no;
		}
	});
}
function delete_review_reply(){
	$.ajax({
		type : 'delete',
		url : '/movie/review_reply_delete/' + review_no ,
		headers : { 
			"Content-Type" : "application/json"
			},
		data : '',
		dataType : 'text',
		success : function(result){
			location.href="/movie/"+movie_id;
		}
	});
}

function eidt_review(){
	var frm1 = document.createElement("form");
	frm1.setAttribute("id", "frm1");
	frm1.setAttribute("action", "/review_update_read/"+review_no);
	frm1.setAttribute("method", "post");

	var a = document.createElement("INPUT")
	a.setAttribute("type", "hidden");
	a.setAttribute("name", "no");
	a.setAttribute("id", "no");
	a.setAttribute("value", review_no);
	frm1.appendChild(a);
		
	var b = document.createElement("INPUT")
	b.setAttribute("type", "hidden");;
	b.setAttribute("name","movie_id")
	b.setAttribute("id", "movie_id");
	b.setAttribute("value", movie_id);
	frm1.appendChild(b);
	
	var c = document.createElement("INPUT")
	c.setAttribute("type", "hidden");
	c.setAttribute("name","review_title");
	c.setAttribute("id", "review_title");
	c.setAttribute("value", review_title);
	frm1.appendChild(c);
	
	var d = document.createElement("INPUT")
	d.setAttribute("type", "hidden");
	d.setAttribute("name","review_content");
	d.setAttribute("id", "review_content");
	d.setAttribute("value", review_content);
	frm1.appendChild(d);
	
	var e = document.createElement("INPUT")
	e.setAttribute("type", "hidden");
	e.setAttribute("name","member_id")
	e.setAttribute("id", "member_id");
	e.setAttribute("value", member_id);
	frm1.appendChild(e);
		
	document.body.appendChild(frm1);
	frm1.submit();
}	



function toList() {
	location.href="/movie/"+movie_id;
}

getReplyList();
function setReplyList(data, data1){
	var result = "";  
	var reply_list = null;
	var reply_reply_list = null;
	$(data).each(function(){
		reply_list = this;
			if(reply_list.reply_reply == "n"){
				result += "<div>"
				+ "<div class='div_re_uid' id='div_re_uid' name='div_re_uid'>"
				+ "<input type='hidden' name='aa' value='"+reply_list.no+"'/>"
				+ "<div style='margin-bottm: 5px; margin-left:20px; font-size:15px'>"
				+"<b><span> 아이디 : "+ reply_list.user_id +"</span><span style=' margin-left:20px;'> 등록일  :"+ reply_list.reply_date+"</span></b></div>"
				+ "<button class='btn btn-info btn-xs' onclick='delete_reply("+ reply_list.no +")'; style='float: right; padding: 8px;'>"+"삭제"+"</button>"
				+ "<button class='reply_write_submit_2 btn btn-info btn-xs' name='reply_write_submit_2' id='reply_write_submit_2' style='float: right; padding: 8px;'>"+"댓글"+"</button>"
				+"<div><textarea disabled readonly='readonly' style='10px; padding: 2px; border: 0px;width: 840px; height: 70px; font-size:18px;"
				+"resize: none; margin-top: 5px; margin-left: 20px; background-color: white'>" + reply_list.reply_content
				+"</textarea></div>" 
				+"<div>" + "<hr class='hrone'>" + "</div>"
				+ "</div>";
			}
			
			$(data1).each(function(){
				reply_reply_list = this;
				if((reply_reply_list.reply_reply =="y" && reply_list.no == reply_reply_list.reply_no)){
				result += "<div class='reply_list_wrap2' name='reply_list_wrap2'>"
				+ "<div style='width: 35px; float: left;'>"
				+ "<img src='http://cfile204.uf.daum.net/R400x0/187AFA4750920BDD311E02'"
				+ "style='width: 50px; height: 54px;'>" +"<br/>"
				+ "</div>"
				+"<div style='margin-left:30px;'>"
				+"<b><span style='margin-left:20px;'> 아이디 : "+ reply_reply_list.user_id +"</span><span style=' margin-left:20px;'> 등록일  :"+ reply_reply_list.reply_date+"</span></b></div>"
				+ "<button class='btn btn-info btn-xs' onclick='delete_reply("+ reply_reply_list.no +")'; style='float: right; padding: 8px;'>"+"삭제"+"</button>"
				+"<div><textarea disabled readonly='readonly' style='padding: 2px; border: 0px;width: 840px; height: 70px; font-size:18px;"
				+"resize: none; margin-top: 5px; margin-left: 20px; background-color: white'>" + reply_reply_list.reply_content
				+"</textarea></div></div>" 
				+"<div>" + "<hr class='hrone'>" + "</div>"
				+ "</div>"
			}
	});	
});
	result += "</div>";
	document.getElementById("reply").innerHTML = result;
}


function getReplyList(){
	
	$.ajax({
		type : 'get',
		url : '/movie/reply/' + review_no,
		headers : {
			"Content-Type" : "application/json",
			//"X-HTTP-Method-Override" : "GET",  ----  POST 이거나 GET인경우는 생략가능
		},
		dataType : 'json',
		data : '',
		success : function(result){
			setReplyList(result.replylist ,result.reply_reply_list);
		}
	});
}


	
function insertReply(no) {
	var review_no = $("#review_no").val();
	var reply_reply = $("#reply_reply").val();
	var user_id = $("#user_id").val();
	var reply_content = $("#reply_content").val();
	var reply_no = $("#review_no").val();
		
	$.ajax({
		type : 'post',
		url : ' /review/new/reply/'+no,
		headers : {
			"Content-Type" : "application/json",
			"X-HTTP-Method-Override" : "POST"
		},
		data : JSON.stringify({
			"user_id" : user_id,
			"reply_content" : reply_content,
			"reply_no" : reply_no,
			"reply_reply" : reply_reply,
			"review_no" : review_no
		}),
		dataType : 'text',
		success : function(result) {
			if (result == "SUCCESS") {
				getReplyList();
			}
		}
	});
}


function insertReply2(no) {
	
	var review_no = $("#review_no").val();
	var reply_reply2 = $("#reply_reply2").val();
	var user_id2 = $("#user_id2").val();
	var reply_content = $("#reply_content2").val();
	var reply_no = $("#reply_no").val();
		
	$.ajax({
		type : 'post',
		url : ' /review/new/reply_reply/'+no,
		headers : {
			"Content-Type" : "application/json",
			"X-HTTP-Method-Override" : "POST"
		},
		data : JSON.stringify({
			"user_id" : user_id2,
			"reply_content" : reply_content,
			"reply_no" : reply_no,
			"reply_reply" : reply_reply2,
			"review_no" : review_no
		}),
		dataType : 'text',
		success : function(result) {
			if (result == "SUCCESS") {
				getReplyList();
			}
		}
	});
}

$(document).on("click","div.div_re_uid button",function() {//동적으로 버튼이 생긴 경우 처리 방식
					if ($(this).attr("name") == "reply_write_submit_2") {
						//자기 부모의 tr을 알아낸다.
						var parentElement = $(this).parent();
						var a = $(this).prev().prev().prev().val();
						var no =  ${ reviewvo.no };
						//댓글달기 창을 없앤다.
						$("#commentEditor").remove();
						//부모의 하단에 댓글달기 창을 삽입
						alert(a);
						var commentEditor = '<div id="commentEditor" class="reply_write_wrap">'
							+ '<div class="reply_write_input">'
							+ '<input type="hidden" id="reply_reply2" class="reply_reply2" name="reply_reply2" value="y"/>'
							+ '<input type="hidden" id="reply_no" name="reply_no" value="'+a+'"/>'
							+ '<input type="text" id="user_id2" name="user_id2" class="form-control col-lg-2" data-rule-required="true" placeholder="이름" maxlength="10" style="width : 200px;"/>'
							+ '<button id="reply_submit_2" class="reply_submit_2 btn btn-primary" onclick="insertReply2('+${ reviewvo.no }+')" style="margin-left:10px;">댓글 등록</button>'
							+ '<textarea id="reply_content2" name="reply_content2" class="inputreply2 form-control col-lg-12" rows="4" style=""></textarea>'
							+ '<input type="hidden" id="review_no" name="review_no" value="' + ${ reviewvo.no } + '" />'
							+'<br/><br/>'
							+ '</div>' + '</form>' + '</div>';
					parentElement.after(commentEditor);
				}
			});
</script>
<%@include file="./include/footer.jsp"%>