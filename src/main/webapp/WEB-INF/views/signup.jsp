<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<style>
  #main-title {
	  color:#909090;
	  font-size:70pt; 
	  margin-top:20%;
  }
</style>
<body bgcolor="#F6F6F6">
	<table align="center" height="90">
        <tr>
             <td>
             	<div id="main-title">SIGN-UP<div>
             </td>
       </tr>
	</table>
	<table align="center" height="40" width="430" border="0" style="border:solid 4px #A4A4A4; margin-top:4%"> 
         <tr>
             <td>
              	<input type="text" id="userId" name="userId" value="" style="height:40px; width:430px;" placeholder="아이디를 입력하세요">
             </td>
         </tr> 
  	</table>
	<table align="center" height="40" width="430" border="0" style="border:solid 4px #A4A4A4; margin-top:1%"> 
         <tr>
             <td>
              	<input type="password" id="password" name="password" value="" style="height:40px; width:430px" placeholder="비밀번호를 입력하세요">
             </td>
         </tr>			
	</table>
	<table align="center" height="40" style="margin-top:1%">
	     <tr>
	         <td>
	          	<input type="button" id="loginBtn" name="login" value="회원가입" style="height:50px; width:450px;  background-color:#A4A4A4; color:white; font-size:16px; border:solid 1px #A4A4A4;" onclick="signup()">
	         </td>
	     </tr> 
	</table>
<br><br><br><br><br>
<script type="text/javascript">

	function signup () {
		var userId = $("#userId").val();
		var password = $("#password").val();
		
		var form = {
				"userId":userId,
				"password":password
        }
		
		console.log(userId);
		$.ajax({
			url:"/user",	
			data : JSON.stringify(form),
			type:"POST",
			dataType: "json",
			contentType: 'application/json',
			headers: {
				'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
			},
			success:function(result){
				console.log(result)
				if (result.data != null){
					alert("Success sign up " + result.data.userId + " !")
					document.location.href = "main";					
				} else {
					alert("Warning.. \n" + result.errors)
				}
			}
		})
	}

</script>
</body>
</html>