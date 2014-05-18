<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>DataTables example</title>

<link rel="stylesheet" type="text/css" href="css/my_bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/DT_bootstrap.css">

<script type="text/javascript" language="javascript" src="js/jquery.js"></script>
<script type="text/javascript" language="javascript"src="js/jquery.dataTables.js"></script>
<script type="text/javascript" charset="utf-8"> 	
 	function getDate(sub){
 		$('#au').dataTable( {  			
 	        "sAjaxSource": "result.html?subject="+sub,
 	        "bDestroy": true
 	    } );
 	}
 	
 	function call(){
 	 	var select = $("#sujectList option:selected").val();
 	 	getDate(select);
 	}
</script>
</head>
<body id="dt_example">


	<div style="position: absolute; top: 30px; left: 20px; width: 1000px;">
		<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="au">
			<thead>
				<tr>
					<th width="30%">School Name</th>
					<th width="10%">Y3</th>
					<th width="10%">Y5</th>
					<th width="10%">Y7</th>
					<th width="10%">Y9</th>
				</tr>
			</thead>
		</table>
	</div>
	
	<div style="position: absolute; top: 100px; left: 1050px; width: 200px;">	  
	    <label for="select">Subject</label>
        <br>
	    <select name="select" id="sujectList" onchange="call()">
		    <c:forEach var="subject" items="${subjectlist}">
	            <option value="${subject.subjectId}">${subject.subjectName}</option>
	            <option value="2">Spelling</option>
	            <option value="3">Reading</option>
	        </c:forEach>
        </select>	
        
	</div>
    
    
	
</body>

</html>
