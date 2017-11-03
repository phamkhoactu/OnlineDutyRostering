----------------<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="requestUrl" value="/admin-employee-list.html"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="label.home" bundle="${lang}" /></title>
</head>
<body>
	<div class="container-fluid">
		<!-- Breadcrumbs-->
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
			<li class="breadcrumb-item active">My Dashboard</li>
		</ol>
		<!-- Example DataTables Card-->
		<div class="card mb-3">
			<div class="card-header">
				<i class="fa fa-table"></i> Data Table Example
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<div id="dataTable_wrapper" class="dataTables_wrapper container-fluid dt-bootstrap4">
						<div class="row">
							<div class="col-sm-12">
								<fmt:bundle basename="ApplicationResources">
									<display:table id="tableList" name="items.listResult" partialList="true" 
									size="${items.totalItems}" requestURI="${requestUrl}"  pagesize="${items.maxPageItems}" 
									sort="external" class="table table-bordered dataTable">
									<display:column property="empId" titleKey="label.employee.empId" 
									sortable="true" sortName="empId"/>
									<display:column property="fullName" titleKey="label.employee.fullName" 
									sortable="true" sortName="fullName"/>
									<display:column property="username" titleKey="label.employee.username" 
									sortable="true" sortName="username"/>
			                        <display:column property="password" titleKey="label.employee.password" 
			                        sortable="true" sortName="password"/>
									</display:table>
								</fmt:bundle>
							</div>
						</div>
					</div>
				</div>
		</div>
	</div>
</div>
</body>
</html>