<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>todolist</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<style>
.table-todolist-items{
	margin-top:60px;
	
}
.title-p{
	text-align:center;
	font-weight:bold;
	font-size:80px;

}
.main-items{
	text-align:center;
	margin:0 auto;
	width:600px;
	margin-top:100px;
	
	
}

.table-title{
	display:flex;
	justify-content:space-evenly;
}
.table-items{
	display:flex;
	justify-content:center;
	
}


</style>
<body>
<div class="main-items">
<div class="title">
<p class="title-p">오늘의 할일</p>

</div>


<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">오늘 할일을 적어보자!</span>
  </div>
  <input type="text" id="todo" name="todo" class="form-control"  aria-label="Username" aria-describedby="basic-addon1">
  <input type="text" id="hidden_text" name="hidden_text">
</div>
<button type="button" id="insert" name="insert" class="btn btn-primary">입력</button>
<button type="button" id="edit" name="edit" class="btn btn-success">수정</button>
<button type="button" id="delete" name="delete"class="btn btn-danger">삭제</button>
<button type="button" id="remove" name="remove" class="btn btn-info">비우기</button>

</div>
<div class="table-todolist-items">
<div class="table-title">
<p class="table-title1">우선순위</p>
<p class="table-title1">할일</p>
</div>
<div class="table-items">
<table border="1"style="width:600px">

<tr><td></td></tr>
</table>
<table border="1"style="width:600px">

<tr><td></td></tr>
</table>
</div>
</div>




</body>
</html>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script language="javascript">
var nClick=null;
var name2 = null;
$(document).ready(function() {
	
	$.get('selecttodoid',{},function(txt){
		ar = txt.split(',');
		for(i=0;i<ar.length;i++){
			name2 = ar[i];
			$('table:eq(0)').append('<tr><td>'+name2+'</td></tr>');
			//$('#hidden_text').val(name2);
		}
		console.log(name2)
	},'text');
	
	
	$.get('todolistselect',{},function(txt){
		ar = txt.split(',');
		for(i=0;i<ar.length;i++){
			name1 = ar[i];
			
			$('table:eq(1)').append('<tr><td>'+name1+'</td></tr>');
			
		}
		console.log(name1)
	},'text');
	
	
	return false;
});


	
$(document)
.on('click','#insert',function(){
	$.ajax({
		  url:'todolistinsert',//호출될 서블릿의 경로(이름)
		  method:'get',//데이터 전송방식 get/post
		  //전송할 데이터(쿼리스트링)//
		  data:'todo='+$('input[name=todo]').val()+'&hidden_text='+$('input[name=hidden_text]').val(),
		  dataType:'text',//반환받을 데이터 타입 
		  beforeSend:function(){},
		  success:function(txt){//호출 성공해서 완료하면 
			 
		},
		complete:function(){
			 
		} 
		
	    })
	    alert("입력되었습니다.")
	 window.location.reload(true);
	
})
$(document)
.on('click','table:eq(0) tr',function(){
	 name=$(this).find('td:eq(0)').text();
	 console.log(name)
	 $('#hidden_text').val(name)
	
	
})

$(document)
.on('click','table:eq(1) tr',function(){
	 name=$(this).find('td:eq(0)').text();
	 console.log(name)
	 $('#todo').val(name)
	
	
})
$(document)
.on('click','#edit',function(){
	$.ajax({
		  url:'todolistupdate',//호출될 서블릿의 경로(이름)
		  method:'get',//데이터 전송방식 get/post
		  data:'todo='+$('input[name=todo]').val()+'&=hidden_text'+$('input[name=hidden_text]').val(),
		  dataType:'text',//반환받을 데이터 타입 
		  beforeSend:function(){},
		  success:function(txt){//호출 성공해서 완료하면 
			
		},
		complete:function(){
	
		} 
		
	    })
	    window.location.reload(true);
	
})


$(document)
 .on('click','#delete',function(){
 	$.ajax({
 		  url:'todolistdelete',//호출될 서블릿의 경로(이름)
 		  method:'get',//데이터 전송방식 get/post
 		  data:'todo='+$('input[name=todo]').val(),
 		  dataType:'text',//반환받을 데이터 타입 
 		  beforeSend:function(){},
 		  success:function(txt){//호출 성공해서 완료하면 
 			alert("입력완료되었습니다.");
 		},
 		complete:function(){
 		 
 		} 
 		
 	    })
 	   window.location.reload(true);
 	  })	
 	  
 $(document)
 .on('click','#remove',function(){
		 $('#todo').val("");
 })
 
 	  


</script>