<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="p" uri="/WEB-INF/page.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="js/jquery-2.1.1.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css" />
</head>
<body>

	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<form class="form-horizontal" action="addPic.action" method="post"
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

				<div class="row">
					<s:iterator var="item" value="pagevo.data" >
						<div class="col-md-4">
							<div class="thumbnail">
								<img alt="300x200" style="width: 300px; height: 200px"
									src="<s:property value="#item.picurl"/>" />
								<div class="caption">
									<h2>
										<s:property value="#item.pictitle" />
									</h2>
									<p>
										<s:property value="#item.picinfo" />
									</p>
									<p>
										<a class="btn btn-primary"
											href="/Struts2Demo3/delete.action?id=<s:property value="#item.id"/>">删除</a>
											<button id="update" type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" 
											data-pictitle="<s:property value="#item.pictitle" />" 
											data-picinfo="<s:property value="#item.picinfo" />"
											data-id="<s:property value="#item.id" />"
											data-picurl="<s:property value="#item.picurl" />">修改</button>
									</p>
								</div>
							</div>
						</div>
					</s:iterator>
				</div>

			</div>
		</div>
	</div>

<script type="text/javascript">
var pictitle1 =  $('update').data('pictitle')
$(".pictitle").append(pictitle1)

</script>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">修改</h4>
      </div>
      <div class="modal-body">
        <form action="update.action" method="post" enctype="multipart/form-data">
          <div class="form-group">
            <input style="display: none;" type="text" class="form-control" id="idinput" name="id">
          </div>
          <div class="form-group">
            <label for="pictitle" class="pictitle">图片标题:</label>
            <input type="text" class="form-control" id="pictitleinput" name="pictitle">
          </div>
          <div class="form-group">
            <label for="picurl" class="control-label">图片地址:</label>
            <input type="text" class="form-control" id="picurlinput" name="picurl">
          </div>
          <div class="form-group">
            <label for="picinfo" class="control-label">图片内容:</label>
            <textarea class="form-control" id="picinfoinput" name="picinfo"></textarea>
          </div>
          <div class="form-group">
            <input type="file" name="img"/>
          </div>
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="submit" class="btn btn-primary">修改</button>
      </div>
      </form>
      
    </div>
  </div>
</div>
<script type="text/javascript" src="js/jquery-2.1.1.min.js" ></script>
<script type="text/javascript" src="js/bootstrap.min.js" ></script>


<script>
$('#exampleModal').on('show.bs.modal', function (event) {
  var button = $(event.relatedTarget) // Button that triggered the modal
  var pictitleinput = button.data('pictitle') // Extract info from data-* attributes
  var picurlinput = button.data('picurl')
  var picinfoinput = button.data('picinfo')
  var idinput = button.data('id')
  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
  var modal = $(this)
  modal.find('.modal-body #pictitleinput').val(pictitleinput)
  modal.find('.modal-body #picurlinput').val(picurlinput)
  modal.find('.modal-body #picinfoinput').val(picinfoinput)
  modal.find('.modal-body #idinput').val(idinput)
})
</script>


<p:page url="pic.action" pagevo="${pagevo }" pageSize="3"/>




</body>
</html>
