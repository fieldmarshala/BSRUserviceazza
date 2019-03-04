<?php 
//session_start();

/*if(!(isset($_SESSION['s_user'])) ||
	empty($_SESSION['s_user']))
	{
	echo "<script>
			window.location = 'login.php'
			</script>";
exit();
	}*/
?>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">  
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.5.1/chosen.min.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="bootstrap.min.css" rel="stylesheet"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.5.1/chosen.jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style type="text/css">
   	hr{
   		border-color: #c4c4c4;
   	}
    td{
      border: 1px solid #c4c4c4;
			font-size: 20px;
    }
    th{
      border: 1px solid #ffffff;
			color: #ffffff;
			font-size: 22px;
    }
	a{
   		color: #000000;
   	}
	.jumbotron {
    max-width: 100%;
    height: auto;
	}
  </style>
</head>

<body style="margin: 35px;">
<?php 

error_reporting(0);

include("connect.php");

$array = array();
$academic_performance_id = $_GET['academic_performance'];
$research_id = $_GET['research'];
$user_id = $_GET['user'];
$work_detail_id = $_GET['work_detail'];

$academic_performance = "SELECT * FROM academic_performance ";
$research = "SELECT * FROM research ";
$user = "SELECT * FROM user ";
$work_detail = "SELECT * FROM work_detail ";

$query_academic_performance = mysqli_query($conn, $academic_performance);
$query_research = mysqli_query($conn, $research);
$query_user = mysqli_query($conn, $user);
$query_work_detail = mysqli_query($conn, $work_detail);

if(!empty($academic_performance_id) && $academic_performance_id>0){
	$array[] = 'project.academic_performance_id="'.$academic_performance_id.'"';
	
}	
if(!empty($research_id) && $research_id>0){
	$array[] = 'project.research_id="'.$research_id.'"';
	
}
if(!empty($user_id) && $user_id>0){
	$array[] = 'project.user_id="'.$proviuser_idnce_id.'"';
	
}
if(!empty($work_detail_id) && $work_detail_id>0){
	$array[] = 'project.serial_number="'.$work_detail_id.'"';
	
}


$condition = implode(' and ', $array);
if(count($array)>0){
 $condition=' and '.$condition;
	/*print "Count in array = ".count($array);
	print "<br><pre>";
	print_r($array);
	print "</pre>";*/
}


$sql = "SELECT * FROM academic_performance";
$count_result = 0;
$result = $conn->query($sql);
$query = mysqli_query($conn, $sql);

?>
<div class="jumbotron" style="background:#FFF" >
	<h2>
		<i class="material-icons" style="font-size:36px"></i>ระบบเผยแพร่ผลงานทางวิชาการและงานวิจัย
	</h2>
	<hr>
	<br><br>


	<form method="get">
		<p>ค้นหางานวิจัย : 
			<select class="chosen" style="width:300px;" name="academic_performance" id="academic_performance">
				<option value="0" <?php echo "selected"; ?>>โปรดเลือกหรือพิมพ์</option>
				<?php while($row_academic_performance = mysqli_fetch_array($query_academic_performance)):;?>
				<option value="<?php echo "$row_academic_performance[aca_id]";?>" 
				<?php if($academic_performance_id == $row_academic_performance[aca_id]){echo "selected";} ?>>
				<?php echo "$row_academic_performance[aca_name]";?></option>
				<?php endwhile;?>
			</select>


			หมายเลขทะเบียน : 
			<select class="chosen" style="width:300px;" name="license_id" id="license_id">
				<option value="0" <?php echo "selected"; ?>>กรุณาเลือกทะเบียน : </option>
				<?php while($row_license_id= mysqli_fetch_array($query_license)):;?>
				<option value="<?php echo "$row_license_id[license_id]";?>" 
				<?php if($license_id == $row_license_id[license_id]){echo "selected";} ?>><?php echo "$row_license_id[license_id]";?></option>
				<?php endwhile;?>
			</select>
            
            <br>
            
            จังหวัด : 
			<select class="chosen" style="width:300px;" name="province" id="province">
				<option value="0" <?php echo "selected"; ?>>กรุณาเลือกจังหวัด</option>
				<?php while($row_province = mysqli_fetch_array($query_province)):;?>
				<option value="<?php echo "$row_province[province_number]";?>" <?php if($province_id == $row_province[province_number]){echo "selected";} ?>><?php echo "$row_province[province_name]";?></option>
				<?php endwhile;?>
			</select>
            

            หมายเลขตัวถัง : 
			<select class="chosen" style="width:300px;" name="serial_number" id="serial_number">
				<option value="0" <?php echo "selected"; ?>>กรุณาเลือกจังหวัด</option>
				<?php while($row_serial_number = mysqli_fetch_array($query_serial_number)):;?>
				<option value="<?php echo "$row_serial_number[serial_number]";?>" <?php if($serial_number_id == $row_serial_number[serial_number]){echo "selected";} ?>><?php echo "$row_serial_number[serial_number]";?></option>
				<?php endwhile;?>
			</select>

			<br>

			เลขที่หนังสือ : 
			<select class="chosen" style="width:300px;" name="book_number" id="book_number">
				<option value="0" <?php echo "selected"; ?>>กรุณาเลือกจังหวัด</option>
				<?php while($row_book_number = mysqli_fetch_array($query_book_number)):;?>
				<option value="<?php echo "$row_book_number[book_number]";?>" <?php if($book_number_id == $row_book_number[book_number]){echo "selected";} ?>><?php echo "$row_book_number[book_number]";?></option>
				<?php endwhile;?>
			</select>


			<br>
           
            <center>
			<button type="submit" class="btn btn-primary">ค้นหา</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             <a href="admin.php"><button type="button" class="btn btn-danger">Clear</button></a>
             </center>
        </p>


		<div class="row">
		  <div class="col-sm-11"></div>
			<a href="insert.php" class="btn btn-default btn-lg" style="background-color: Green;color: #ffffff;"><span class="glyphicon glyphicon-plus"></span>เพิ่มข้อมูล</a>
			<div class="col-sm-11"></div>
			<input type="hidden" name="maxRows" id="maxRows" class="form-control" value="20">
		</div>
	</form>
    <table height="47" class="table table-bordered table-striped" id="mytable">
		<thead style="text-align: center; background: #24afd8"><br><br>
			<tr>
				<th width="20%">ประเภทของผลงาน</th>
				<th width="20%">ระดับคุณภาพงานวิจัย</th>
				<th width="20%">หัวเรื่องผลงาน</th>
				<th width="20%">รายชื่อผู้วิจัย</th>
				<th width="20%">ข้อมูลการเผยแพร่</th>
				<th width="5%">&nbsp;แก้ไข</th> 
				<th width="5%">&nbsp;ลบ</th> 
			</tr>
		</thead>
<?php 
	if ($result->num_rows > 0 && $result->num_rows <= 1000) {
		while($row = $result->fetch_assoc()) { 
			$count_result++; 
			$date = $row["date"];
			$day = explode("-",$date);
			$day[0] += 543;
			$dayy = $day[2]."/".$day[1]."/".$day[0];
			?>
    	<tbody>
			<tr align="center">
				<td><?php if(!$row["aca_type"]){echo " - ";} echo "{$row["aca_type"]}"; ?></td>
				<td><?php if(!$row["aca_grade"]){echo " - ";} echo "{$row["aca_grade"]}"; ?></td>
				<td><?php if(!$row["aca_name"]){echo " - ";} echo "{$row["aca_name"]}"; echo "{$row["aca_name"]}";?></td>
				<td><?php if(!$row["aca_member"]){echo " - ";} echo "{$row["aca_member"]}"; ?></td>
				<td><?php if(!$row["aca_detail"]){echo " - ";} echo "{$row["aca_detail"]}"; ?></td>
				<td align="center">
					<a href="edit.php?id=<?php echo "$row[id]";?>">
						<i class="fa fa-wrench" id="Edit" style="font-size:20px;color:#fce323;"></i>
					</a>
				</td>
				<td align="center">
					<a href="JavaScript:if(confirm('ยืนยันการลบข้อมูล') == true){window.location='delete.php?id=<?php echo "$row[id]";?>';}">
						<i class="fa fa-remove" id="Delete" style="font-size:20px;color:red"></i>
					</a>
				</td>
			</tr>
		<?php }  } else { ?>
			<tr>
				<td>-</td>
				<td>-</td>
				<td>-</td>
				<td>-</td>
				<td>-</td>
				<td>-</td>
				<td>-</td>
			</tr>
		</tbody>
	<?php } ?>
	</table>
	<div class="pagination-container">
		<nav>
			<ul class="pagination"></ul>
		</nav>
	</div>
</div>
</body>
<script src="jquery.min.js"></script>
<script src="bootstrap.min.js"></script>
<script>

	//

	var table = '#mytable'
	$('#maxRows').on('change', function(){
		$('.pagination').html('')
		var trnum = 0
		var maxRows = parseInt($(this).val())
		var totalRows = $(table+' tbody tr').length
		$(table+' tr:gt(0)').each(function(){
			trnum++
			if(trnum > maxRows){
				$(this).hide()
			}
			if(trnum <= maxRows){
				$(this).show()
			}
		})
		if(totalRows > maxRows){
			var pagenum = Math.ceil(totalRows/maxRows)
			for(var i=1;i<=pagenum;){
				$('.pagination').append('<li data-page="'+i+'">\<span>'+ i++ +'<span class="sr-only">{current}</span></span>\</li>').show()
			}
		}
		$('.pagination li:first-child').addClass('active')
		$('.pagination li').on('click',function(){
			var pageNum = $(this).attr('data-page')
			var trIndex = 0;
			$('.pagination li').removeClass('active')
			$(this).addClass('active')
			$(table+' tr:gt(0)').each(function(){
				trIndex++
				if(trIndex > (maxRows*pageNum) || trIndex <= ((maxRows*pageNum)-maxRows)){
					$(this).hide()
				} else{
					$(this).show()
				}
			})
		})
	})

	$(function(){

		$('table tr:eq(0)').prepend('<th>ID</th>')
		var id = 0;
		$('table tr:gt(0)').each(function(){
			id++
			$(this).prepend('<td>'+id+'</td>')
		})
	})

	$( "#maxRows" ).val(20).trigger( "change" )
</script>
<script type="text/javascript">$(".chosen").chosen();</script>
</body>
</html>