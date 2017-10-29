<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title><dec:title default="Login page"/></title>
  <!-- Bootstrap core CSS-->
  <link href="<c:url value='template/admin/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="<c:url value='/template/admin/vendor/font-awesome/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="<c:url value='/template/admin/css/sb-admin.css" rel="stylesheet'/>">
  <dec:head/>
</head>

<body class="bg-dark">
  <div class="container">
    <div class="card card-login mx-auto mt-5">
     
      <div class="card-header">Login</div>
      <dec:body/>
      
    </div>
  </div>
  <!-- Bootstrap core JavaScript-->
  <script src="<c:url value='/template/admin/vendor/jquery/jquery.min.js'/>"></script>
  <script src="<c:url value='/template/admin/vendor/popper/popper.min.js'/>"></script>
  <script src="<c:url value='/template/admin/vendor/bootstrap/js/bootstrap.min.js'/>"></script>
  <!-- Core plugin JavaScript-->
  <script src="<c:url value='/template/admin/vendor/jquery-easing/jquery.easing.min.js'/>"></script>
</body>

</html>
