<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title><dec:title default="Admin Page" /></title>
<!-- Bootstrap core CSS-->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<!-- Custom fonts for this template-->
<link
	href="<c:url value='/template/admin/vendor/font-awesome/css/font-awesome.min.css' /> "
	rel="stylesheet" type="text/css">
<!-- Page level plugin CSS-->
<link
	href="<c:url value='/template/admin/vendor/datatables/dataTables.bootstrap4.css' /> "
	rel="stylesheet">
<!-- Custom styles for this template-->

<link href="<c:url value='/template/admin/css/sb-admin.css' /> "
	rel="stylesheet">
<link
	href="<c:url value='/template/admin/css/global_admin_style.css' /> "
	rel="stylesheet">
<!--sweetalert-->
<script type='text/javascript'
	src='<c:url value="/template/admin/sweetalert/sweetalert2.min.js"/>'></script>
<link rel="stylesheet"
	href="<c:url value="/template/admin/sweetalert/sweetalert2.min.css"/>">
<!-- Bootstrap core JavaScript-->
<script
	src="<c:url value='/template/admin/vendor/jquery/jquery.min.js'/>"></script>
<script
	src="<c:url value='/template/admin/vendor/popper/popper.min.js'/>"></script>
<script
	src="<c:url value='/template/admin/vendor/bootstrap/js/bootstrap.min.js'/>"></script>
<!-- Core plugin JavaScript-->
<script
	src="<c:url value='/template/admin/vendor/jquery-easing/jquery.easing.min.js'/>"></script>

<script type="text/javascript"
	src="<c:url value="/template/admin/js/global_admin_script.js"/>"></script>
<dec:head />
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<a class="navbar-brand" href="admin-home.html"><fmt:message
				key="label.home" bundle="${lang}" /> [TÊN]</a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">

			<!--  BEGIN HEADER -->
			<%@ include file="/common/admin/header.jsp"%>
			<!--  END HEADER -->


			<!--  BEGIN SIDEBAR MENU -->
			<%@ include file="/common/admin/menu.jsp"%>
			<!--  END SIDERBAR MENU -->

		</div>
	</nav>
	<div class="content-wrapper">

		<!-- BEGIN BODY CONTENT -->
		<dec:body />
		<!-- END BODY CONTENT -->
		<!-- /.container-fluid-->
		<!-- /.content-wrapper-->

		<!-- BEGIN FOOTER -->
		<%@ include file="/common/admin/footer.jsp"%>
		<!-- END FOOTER -->



		<!-- Page level plugin JavaScript-->
		<script
			src="<c:url value='/template/admin/vendor/chart.js/Chart.min.js'/>"></script>
		<script
			src="<c:url value='/template/admin/vendor/datatables/jquery.dataTables.js'/>"></script>
		<script
			src="<c:url value='/template/admin/vendor/datatables/dataTables.bootstrap4.js'/>"></script>
		<!-- Custom scripts for all pages-->
		<script src="<c:url value='/template/admin/js/sb-admin.min.js'/>"></script>
		<!-- Custom scripts for this page-->
		<script
			src="<c:url value='/template/admin/js/sb-admin-datatables.min.js'/>"></script>
		<script
			src="<c:url value='/template/admin/js/sb-admin-charts.min.js'/>"></script>
	</div>

	<script type="text/javascript">
		function showAlertBeforeDelete(callback) {
			swal({
				title : "Xác nhận xóa",
				text : "Bạn có chắc chắn xóa những dòng đã chọn",
				type : "warning",
				showCancelButton : true,
				confirmButtonText : "Xác nhận",
				cancelButtonText : "Hủy bỏ",
				confirmButtonClass : "btn btn-success",
				cancelButtonClass : "btn btn-danger"
			}).then(function(isConfirm) {
				if (isConfirm) {
					callback();
				}

			});
		}
	</script>
</body>

</html>
