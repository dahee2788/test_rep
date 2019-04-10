<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<script type="text/javascript" charset="utf-8">
var cnt;
	function insertContents(f)
	{
		alert(document.getElementById("contents").value);
		//var form=document.form; //form
		//f.method = "post";
		f.action="/insert";
		f.submit();
		
	}
	 function selectAllContents(f)
	{
		//var form=document.form; //form
		//f.method = "get";
		f.action="/select";
		f.submit();
	}
	 function updateContents(b)
	 {
		 /* var tr_count=document.getElementsByTagName("").length; //전체 행의 갯수
		 var td=document.getElementsByTagName("td");
		 alert(tr_count);
		 for(var i =0; i<tr_count; i++)
			 {
			 	var update_button=document.getElementsByTagName("tr")[i].childNodes[4].childNodes[0];
			 	
			 	alert(update_status);
			 	if(update_status=='수정완료') alert("이미 하나 있음");
			 	return ;
			 } */
		 
		 
		 //모든 버튼 중에 수정완료 있으면 alert띄우고 수정 못시키게 return; 
		 current_b=b.value;
		 if((current_b=='수정'&& cnt==0) ||(current_b=='수정'&& cnt==null)) {
			 //if(cnt==1) return false;
			 b.value="수정완료";
			 var cur_seq= b.id;
			 cnt=1;
			 
			 var td=b.parentNode;
			 alert(td.innerHTML);
			 var tr = td.parentNode;
			 //현재 값 가져오기
			 var cur_contents=tr.getElementsByTagName("td")[1].innerHTML;
			 

			//수정창으로 변경
			tr.getElementsByTagName("td")[1].innerHTML = "<input type='text' name='update_contents' value='"+cur_contents+"'><input type='hidden' name='seq' value='"+cur_seq+"'>";
															
			 
		 }
		 else if(current_b=='수정'&& cnt==1) return false;
		 
		 else {
			 //alert(cnt);
			 var form=document.form; //form
			 
			 form.action="/update";
			 form.submit();	
			 
			 b.value="수정";
			 cnt=0;
		 }
	 }
	 
	 function deleteContents(f)
	 {
		 var tbody=document.getElementById("tbody");
		 var tr_list = tbody.getElementsByTagName("tr");
		 var del_btn =document.getElementById("delete").value;
		 if(del_btn=="삭제")
			 {
			
			 //alert(tbody.innerHTML);
			 var tr_list = tbody.getElementsByTagName("tr");
			 	for(var i =0; i<tr_list.length; i++)
			 		{	
			 			var td_input=tr_list[i].getElementsByTagName("td")[4];
			 			var input_seq = td_input.getElementsByTagName("input")[0].id;
			 			tr_list[i].getElementsByTagName("td")[0].innerHTML="<input type='checkbox' name='check' value='"+input_seq+"'>"
			 			//alert(input_seq);
			 		}
			 	document.getElementById("delete").value="삭제확정";
			 }
		 else if(del_btn=="삭제확정")
			 {
			 var del_str="";
			 //var arr_del = tbody.getElementsByName("check");
		        for(var i=0;i<tr_list.length;i++){
		        	var check_td=tr_list[i].getElementsByTagName("td")[0];
		        	//alert(check_td);
		        	 if(check_td.getElementsByTagName("input")[0].checked==true)
		        		{
		        		//alert(check_td.getElementsByTagName("input")[0].value);
		        		if(i==0) del_str+=check_td.getElementsByTagName("input")[0].value;
		        		else del_str+=","+check_td.getElementsByTagName("input")[0].value;
		        		
		        		} 
		            /* if(arr_del[i].checked == true) {
		                alert(arr_del[i].id);
		            } */
		        }

		        document.getElementById("del_arr").value=del_str;
		        document.getElementById("delete").value="삭제";
		        f.action="/delete";
				f.submit();
			 }
		 
	 }
 
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Home</title>
</head>
<body>
<h1>
	TEST 
</h1>
<form  method="post" name="form">

<input type="text" name="contents" id = "contents" value="">
<input type="button" id="insert" onclick="insertContents(this.form)" value="전송">
<input type="button" id="select" onclick="selectAllContents(this.form)" value="조회">
<input type="button" id="delete" onclick="deleteContents(this.form)" value="삭제">
<input type="hidden" id="del_arr" name="del_arr" value=''>



 <table >
        <thead>
            <tr>
                <th>seq</th>
                <th>contents</th>
                <th>reg_datetime</th>
                <th>upd_datetime</th>
                <th>수정</th>
            </tr>
        </thead>
        <tbody id="tbody">
            <c:forEach items="${allContentList}" var="content" varStatus="vs">
                <tr >
                   <td>${vs.count}</td>
                    <td>${content.contents}</td>
                    <td>${content.reg_datetime}</td>
                    <td>${content.upd_datetime}</td>
                    <td><input type="button" value="수정" id="${content.seq}" name ="${content.contents}" onclick="updateContents(this)"></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</form>

</body>
</html>
