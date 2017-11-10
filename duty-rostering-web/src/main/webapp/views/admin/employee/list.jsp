<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="editEmployeeUrl" value="/ajax-admin-employee-edit.html">
	<c:param name="urlType" value="url_edit" />
</c:url>

<c:url var="listEmployeeUrl" value="/admin-employee-list.html">
	<c:param name="urlType" value="url_list" />
</c:url>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="label.home" bundle="${lang}" /></title>
</head>
<body>
	<div class="container-fluid">
		<!-- Breadcrumbs-->

		<!-- Example DataTables Card-->
		<c:if test="${not empty messageResponse}">
			<div class="alert alert-block alert-${alert}">
				<button type="button" class="close" data-dismiss="alert">
					<i class="ace-icon fa fa-times"></i>
				</button>
				
				${messageResponse}
			</div>
		</c:if>


		<div class="table-responsive">
			<div id="dataTable_wrapper"
				class="dataTables_wrapper container-fluid dt-bootstrap4">
				<form action="${listEmployeeUrl}" method="get" id="formUrl">
					<div class="row">
						<div class="col-xs-12">
							<div class="table-btn-controls">
								<div class="pull-right tableTools-container">
									<div class="dt-buttons btn-overlap btn-group">
										<a flag="info" id="btnAddEmp" onclick="update(this);"
											class="dt-button buttons-colvis btn btn-white btn-primary btn-bold">
											<span> <i class="fa fa-plus-circle bigger-110 purple"></i>
										</span>
										</a>
										<button type="button"
											class="dt-button buttons-html5 btn btn-white btn-danger btn-bold "
											id="deleteAll" data-toggle="tooltip"
											title="<fmt:message key='label.delete.all' bundle='${lang}' /> "
											 onclick="warningBeforeDelete()" disabled>
											<span> <i class="fa fa-trash-o bigger-110 pink"></i>
											</span>
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-sm-12">
							<fmt:bundle basename="ApplicationResources">
								<display:table id="tableList" name="items.listResult"
									partialList="true" size="${items.totalItems}"
									requestURI="${listEmployeeUrl}"
									pagesize="${items.maxPageItems}" sort="external"
									class="table table-bordered dataTable">
									<display:column
										title="<fieldset class='form-group'>
												        <input type='checkbox' id='checkAll' class='check-box-element'>
												        </fieldset>"
										class="center select-cell" headerClass="center select-cell">
										<fieldset>
											<input type="checkbox" name="checkList"
												id="checkbox_${tableList.empId}" value="${tableList.empId}"
												class="check-box-element" />
										</fieldset>
									</display:column>
									<display:column property="empId"
										titleKey="label.employee.empId" sortable="true"
										sortName="empId" />

									<display:column property="fullName"
										titleKey="label.employee.fullName" sortable="true"
										sortName="fullName" />
									<display:column property="username" class="adminAccount"
										titleKey="label.employee.username" sortable="true"
										sortName="username" />
									<display:column property="password"
										titleKey="label.employee.password" sortable="true"
										sortName="password" />

									<display:column property="isAdmin"
										titleKey="label.employee.role" class="roleCheckbox"
										sortable="true" sortName="isAdmin" />
									<display:column property="isActive"
										titleKey="label.employee.status" class="activeCheckbox"
										sortable="true" sortName="isActive" />
									<display:column headerClass="col-actions"
										titleKey="label.action">
										<c:url var="editUrl" value="/ajax-admin-employee-edit.html">
											<c:param name="urlType" value="url_edit" />
											<c:param name="pojo.empId" value="${tableList.empId}" />
										</c:url>
										<a class="btn btn-sm btn-primary btn-edit" sc-url="${editUrl}"
											onClick="update(this);" data-toggle="tooltip"
											title="<fmt:message key='label.employee.edit' bundle='${lang}'/>"><i
											class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
									</display:column>

								</display:table>
							</fmt:bundle>
						</div>
						<input type="hidden" name="crudaction" id="crudaction" /> <input
							type="hidden" name="urlType" id="urlType" />

					</div>
				</form>
			</div>
		</div>


	</div>
	<!-- Modal for edit -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="testModalLabel" aria-hidden="true"></div>
	<script>
		$(document).ready(function() {
		});
		function update(btn) {
			var editUrl = $(btn).attr('sc-url');
			if (typeof editUrl == 'undefined') {
				editUrl = '${editEmployeeUrl}';
			}
			$('#myModal').load(editUrl, '', function() {
				$('#myModal').modal('toggle');
				addOrEditEmployee();
			});
		}
		
	    function warningBeforeDelete() {
	        showAlertBeforeDelete(function () {
	        	  $('#urlType').val('url_list');
	              $('#crudaction').val('redirect_delete');
	              $('#formUrl').submit();
	         
	        });
	        
	    }

		function addOrEditEmployee() {
			$('#btnSave').click(function() {

				$('#editEmployeeForm').submit();

			});
			$('#editEmployeeForm').submit(function(e) {
				e.preventDefault();
				$('#crudactionEdit').val('insert_update');

				$.ajax({
					type : $(this).attr('method'),
					url : $(this).attr('action'),
					data : $(this).serialize(),
					dataType : 'html',
					success : function(res) {

						if (res.trim() == "redirect_insert") {
							$('#crudaction').val('redirect_insert');

							$('#urlType').val('url_list');
							$('#formUrl').submit();
						} else if (res.trim() == "redirect_update") {
							$('#crudaction').val('redirect_update');
							$('#urlType').val('url_list');
							$('#formUrl').submit();
						} else if (res.trim() == "redirect_error") {
							$('#crudaction').val('redirect_error');
							$('#urlType').val('url_list');
							$('#formUrl').submit();
						}
					},
					error : function(xhr, textStatus, err) {

						console.log("readyState: " + xhr.readyState);
						console.log("responseText: " + xhr.responseText);
						console.log("status: " + xhr.status);
						console.log("text status: " + textStatus);
						console.log("error: " + err);
					}
				});
			});
		}
	</script>
</body>
</html>