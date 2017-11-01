<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp"%>
<c:url var="formUtil" value="/login.html" />
<!DOCTYPE html>
<html lang="en">

<head>
  <title>Login Page</title>
</head>

<body class="bg-dark">


     <!--<div class="card-header"><fmt:message key="label.test" bundle='${lang}' /></div>  --> 
      <div class="card-body">
        <form action="" method="post">
        <c:if test="${not empty messageResponse}">
                        <div class="alert alert-block alert-${alert}">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="ace-icon fa fa-times"></i>
                            </button>
                                ${messageResponse}
                        </div>
		</c:if>
          <div class="form-group">
            <label for="username">Username</label>
            <input class="form-control" id="username" type="username" name="pojo.username" aria-describedby="emailHelp" placeholder="Enter username">
          </div>
          <div class="form-group">
            <label for="password">Password</label>
            <input class="form-control" id=password" type="password" name="pojo.password" placeholder="Password">
          </div>
		  <button type="submit" value="Submit" class=" form-control btn btn-primary btn-block id="button-1">
		  	SUBMIT
		  </button>
        </form>
      
      </div>
 
</body>

</html>
