<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>用户列表</title>
		<script src="js/jquery-2.1.1.min.js"></script>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/bootstrap.css" />
	</head>
	<body>
		<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<form class="form-horizontal" action="addPic3.action" method="post"
					enctype="multipart/form-data">
					<div class="form-group">
						<label class="col-sm-2 control-label">图片标题</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="pictitle" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">图片内容</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="picinfo" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">图片地址</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="picurl" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">上传图片</label>
						<div class="col-sm-10">
							<input type="file" name="img">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">保存</button>
						</div>
					</div>
				</form>

			</div>
		</div>
	</div>
		<script type="text/javascript">
			$(document).ready(function(){
				 $.post("pic3.action",{"userid":"1111","name":"test"},function(data){
            console.log("success");
            console.log(data);
            var div=$("<div class='row'></div>");
            $.each(data,function(index,item){
                var tr1=$("<div class='col-md-4'><div class='thumbnail'><img alt='300x200' style='width: 300px; height: 200px' src='"+item.picurl+"' /><div class='caption'><h2>"+item.pictitle+"</h2><p>"+item.picinfo+"</p><p><a class='btn btn-primary' href='/Struts2Demo3/delete.action?pictitlename='"+item.pictitle+"'>删除</a></p></div></div></div>");
                div.append(tr1);
            });
            $("body").append(div);
        },"json");
			});
		</script>
	</body>
</html>
