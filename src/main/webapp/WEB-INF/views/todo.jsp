<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<style>
  #main-title {
	  color:#909090;
	  font-size:70pt; 
	  margin-top:20%;
  }
  #newTitle {
  	height:40px;
  	width:500px;
  }
  .todoRows {
  	height:40px;
  	width:400px;
  }
  #todoListTable {
  	height:"40";
  	width:"430";
  	border:solid 4px #A4A4A4;
  	margin-top:1%;
  }
</style>
<body bgcolor="#F6F6F6">
	<table align="center" height="90">
        <tr>
             <td>
             	<div id="main-title">To-Do</div>
             </td>
       </tr>
	</table>
	<table align="center" height="40" width="430" border="0" style="border:solid 4px #A4A4A4; margin-top:4%"> 
         <tr>
             <td>
              	<input type="text" id="newTitle" name="title" placeholder="새로운 할 일을 입력하세요">
             </td>
         </tr> 
  	</table>
	<table align="center" height="40" style="margin-top:1%">
	     <tr>
	         <td>
	          	<input type="button" id="newTodoBtn" name="newTodo" value="추가" style="height:50px; width:450px;  background-color:#A4A4A4; color:white; font-size:16px; border:solid 1px #A4A4A4;" onclick="addNewTodo()">
	         </td>
	     </tr> 
	</table>
	<table id="todoListTable" align="center" >
         
	</table>
<br><br><br><br><br>
<script type="text/javascript">
	$(document).ready(function() {
		getTodoList();
	});

	function getTodoList() {
		$.ajax({
			url:"/todo",
			type:"GET",
			contentType: 'application/json',
			success:function(result) {
				$("#todoListTable").html("");
				
				if(result.length != 0) {
					$.each(result, function(index, result) {
						var input = $('<input class="todoRows" type="text" id="title" style="background-color: #e2e2e2;" readonly>').val(result.data.title);
						var td = $('<td id="todoTd' + result.data.id + '">').append(input);
						var updateBtn = $('<input type="button" id="updateBtn' + result.data.id + '" value="수정" onclick="fixTodo(' + result.data.id + ')">');
						var deleteBtn = $('<input type="button" id="deleteBtn' + result.data.id + '" value="삭제" onclick="deleteTodo(' + result.data.id + ')">');
						var tr = $('<tr>').append(td).append(updateBtn).append(deleteBtn);
						$("#todoListTable").append(tr);
					});
				} else {
					console.log('result is null');
					var input = $('<input class="todoRows" type="text" id="title" readonly>').val('  저장된 할일이 없습니다').attr('readonly',true);
					var td = $('<td>').append(input);
					var tr = $('<tr>').append(td);
					$("#todoListTable").append(tr);
				}
			}
		});
	}
		
	function addNewTodo () {
		var title = $("#newTitle").val();
		if(title.length == 0) {
			alert('최소한의 내용을 작성해주세요!');
			return;
		}
		$("#newTitle").val('');
		
		var form = {
			"title":title,
			"done":'N'
	    }
		
		$.ajax({
			url:"/todo",	
			data : JSON.stringify(form),
			type:"POST",
			dataType: "json",
			contentType: 'application/json',
			success:function(result){
				if (result.data != null){
					alert("새로운 할일 추가 !")
					getTodoList();
				} else {
					alert("Warning.. \n" + result.errors)
				}
			}
		});
	}
	
	function fixTodo(todoId) {
		console.log(todoId);
		$("#todoTd" + todoId).find('input')
						.attr('readonly', false)
						.css('background-color','#fff');
		$("#updateBtn" + todoId).val("저장")
								.attr('onclick', 'updateTodo(' + todoId + ')');
	}
	
	function updateTodo (todoId) {
		var title = $("#todoTd" + todoId).find('input').val();
		if(title.length == 0) {
			alert('최소한의 내용을 작성해주세요!');
			return;
		}
		$("#todoTd" + todoId).find('input')
				.attr('readonly', true)
				.css('background-color','#e2e2e2');
		$("#updateBtn" + todoId).val("수정")
					.attr('onclick', 'fixTodo(' + todoId + ')');
		
		var form = {
			"id":todoId,
			"title":title,
			"done":'N'
	    }
		
		$.ajax({
			url:"/todo",	
			data : JSON.stringify(form),
			type:"PUT",
			dataType: "json",
			contentType: 'application/json',
			success:function(result){
				if (result.data != null){
					alert("할일 수정 !")
					getTodoList();
				} else {
					alert("Warning.. \n" + result.errors)
				}
			}
		});
	}
	
	function deleteTodo (todoId) {
		$.ajax({
			url:"/todo/"+todoId,
			type:"DELETE",
			success:function(result){
				if (result != null){
					alert("할일 삭제!");
					getTodoList();
				} else {
					alert("Warning.. \n" + result.errors)
				}
			}
		})
	}
</script>
</body>
</html>