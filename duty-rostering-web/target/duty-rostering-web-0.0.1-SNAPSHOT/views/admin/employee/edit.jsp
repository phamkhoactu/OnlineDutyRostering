<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/common/taglib.jsp"%>

<c:url var="editEmployeeUrl" value="/ajax-admin-employee-edit.html">
	<c:param name="urlType" value="url_edit" />
</c:url>
<c:choose>
	<c:when test="${not empty messageResponse}">
        ${messageResponse}
    </c:when>
	<c:otherwise>
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<!--////////////////////////SUA TAI KHOAN////////////////////////////// -->
					<c:if test="${item.pojo.empId ne 0}">
						<h4 class="modal-title">
							<fmt:message key="label.employee.edit" bundle="${lang}" />
						</h4>
						<!-- id area -->

					</c:if>
					<c:if test="${item.pojo.empId eq 0}">
						<h4 class="modal-title">
							<fmt:message key="label.employee.add" bundle="${lang}" />
						</h4>
						<!-- id area -->
					</c:if>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>

				<c:if test="${item.pojo.empId ne 0}">
					<form action="${editEmployeeUrl}" method="POST"
						id="editEmployeeForm">
						<div class="modal-body">
							<div class="row">
								<div class="form-group col-md-12">
									<div class="md-form">
										<input type="text"
											placeholder="<fmt:message key='label.employee.empId' bundle='${lang}'/>"
											class="form-control" value="${item.pojo.empId}" id="empId"
											name="pojo.empId" required  hidden />
									</div>
								</div>
								<div class="form-group col-md-12">
									<div class="md-form">
										<input type="text"
											placeholder="<fmt:message key='label.employee.username' bundle='${lang}'/>"
											class="form-control" value="${item.pojo.username}"
											id="username" name="pojo.username"  hidden />
									</div>
								</div>
								<div class="form-group col-md-12">
									<div class="md-form">
										<input type="text"
											placeholder="<fmt:message key='label.employee.fullName' bundle='${lang}'/>"
											class="form-control" value="${item.pojo.fullName}"
											id="fullName" name="pojo.fullName" required  hidden />
									</div>
								</div>
								<br /> <br />
								<div class="form-group col-md-12">
									<div class="md-form">
										<input type="password"
											placeholder="<fmt:message key='label.employee.password' bundle='${lang}'/>"
											onfocus="checkTest();" class="form-control"
											value="${item.pojo.password}" id="password"
											name="pojo.password" required />
									</div>
								</div>


								<br /> <br />
								<div class="form-group col-md-8">
									<div class="md-form">
										<c:choose>
											<c:when test="${item.pojo.empId ne 0}">
												<select id="isAdmin" name="pojo.isAdmin"
													class="form-control custom-select" required>
													<option value="${item.pojo.isAdmin}">
														<c:if test="${item.pojo.isAdmin == 'true'}">Admin</c:if>
														<c:if test="${item.pojo.isAdmin == 'false'}">User</c:if>
													</option>
													<c:if test="${item.pojo.isAdmin == 'true'}">
														<option value="false">User</option>
													</c:if>

													<c:if test="${item.pojo.isAdmin == 'false'}">
														<option value="true">Admin</option>
													</c:if>


												</select>
											</c:when>
											<c:otherwise>
												<select id="isAdmin" name="pojo.isAdmin"
													class="form-control custom-select" required>
													<option selected><fmt:message
															key="label.option.role" bundle="${lang}" /></option>
													<option value="true">Admin</option>
													<option value="false">User</option>
												</select>
											</c:otherwise>
										</c:choose>

									</div>

								</div>
								<br /> <br />
								<div class="form-group col-md-8">
									<div class="md-form">
										<c:choose>
											<c:when test="${item.pojo.empId ne 0}">
												<select id="isActive" name="pojo.isActive"
													class="form-control custom-select" required>
													<option value="${item.pojo.isActive}">
														<c:if test="${item.pojo.isActive == 'true'}">Active</c:if>
														<c:if test="${item.pojo.isActive == 'false'}">Disabled</c:if>
													</option>
													<c:if test="${item.pojo.isActive == 'true'}">
														<option value="false">Disabled</option>
													</c:if>

													<c:if test="${item.pojo.isActive == 'false'}">
														<option value="true">Active</option>
													</c:if>


												</select>
											</c:when>

											<c:otherwise>
												<select id="isActive" name="pojo.isActive"
													class="form-control custom-select" hidden required>
													<option value="true"><fmt:message
															key="label.option.status" bundle="${lang}" /></option>
												</select>
												<%-- <select id="status" class="form-control custom-select" required>
										<option selected><fmt:message key="label.option.status"
												bundle="${lang}" /></option>
										<option value="true">Active</option>
										<option value="false">Disabled</option>
									</select> --%>
											</c:otherwise>
										</c:choose>

									</div>

								</div>
							</div>
						</div>
						<input type="hidden" id="createDate" name="pojo.createDate"
							value="${item.pojo.createDate}" required hidden />  <input
							type="hidden" name="crudaction" id="crudactionEdit" />
					</form>
					<!--/ id area -->
				</c:if>
				<!--////////////////////////THEM TAI KHOAN////////////////////////////// -->
				<c:if test="${item.pojo.empId eq 0}">
					<form action="${editEmployeeUrl}" method="POST"
						id="editEmployeeForm">
						<div class="modal-body">
							<div class="row">
								<div class="form-group col-md-12">
									<div class="md-form">
										<input type="text"
											placeholder="<fmt:message key='label.employee.empId' bundle='${lang}'/>"
											class="form-control" value="${item.lastInsertedId + 1}"
											id="empId" name="pojo.empId" required hidden />
									</div>
								</div>
								<div class="form-group col-md-12">
									<div class="md-form">
										<input type="text"
											placeholder="<fmt:message key='label.employee.username' bundle='${lang}'/>"
											class="form-control" id="username" name="pojo.username" />
									</div>
								</div>
								<div class="form-group col-md-12">
									<div class="md-form">
										<input type="text"
											placeholder="<fmt:message key='label.employee.fullName' bundle='${lang}'/>"
											class="form-control" id="fullName" name="pojo.fullName"
											required />
									</div>
								</div>
								<br /> <br />
								<div class="form-group col-md-12">
									<div class="md-form">
										<input type="password"
											placeholder="<fmt:message key='label.employee.password' bundle='${lang}'/>"
											onfocus="checkTest();" class="form-control" id="password"
											name="pojo.password" required />
									</div>
								</div>


								<br /> <br />
								<div class="form-group col-md-8">
									<div class="md-form">
										<select id="isAdmin" name="pojo.isAdmin"
											class="form-control custom-select" required>
											<option selected><fmt:message
													key="label.option.role" bundle="${lang}" /></option>
											<option value="true">Admin</option>
											<option value="false">User</option>
										</select>
									</div>

								</div>
								<br /> <br />
								<div class="form-group col-md-8">
									<div class="md-form">
										<select id="isActive" name="pojo.isActive"
											class="form-control custom-select" hidden required>
											<option value="true" selected></option>
										</select>
									</div>

								</div>
							</div>
						</div>

						<input type="hidden" name="crudaction" id="crudactionEdit" />
					</form>
					<!-- /id area -->
				</c:if>
				<!-- //////////////////////////////////////////////////// -->


				<div class="modal-footer">

					<button id="btnSave" type="button" class="btn btn-primary">
						<fmt:message key="label.save" bundle="${lang}" />
					</button>
					<button key="label.close" class="btn btn-secondary" type="button"
						data-dismiss="modal">
						<fmt:message key="label.close" bundle="${lang}" />
					</button>

				</div>
			</div>
		</div>
		<script>
			$(document).ready(function() {
			});
			function checkTest() {
				var textRaw = $("#fullName").val();
				var textEdited = convertVietnamese(textRaw);
				var id = $("#empId").val();
				var lastword = textEdited.split("-").pop();
				var result = lastword + id;
				$("#username").val(result);
			}

			function convertVietnamese(str) {
				str = str.toLowerCase();
				str = str.replace(/à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ/g, "a");
				str = str.replace(/è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ/g, "e");
				str = str.replace(/ì|í|ị|ỉ|ĩ/g, "i");
				str = str.replace(/ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ/g, "o");
				str = str.replace(/ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ/g, "u");
				str = str.replace(/ỳ|ý|ỵ|ỷ|ỹ/g, "y");
				str = str.replace(/đ/g, "d");
				str = str
						.replace(
								/!|@|%|\^|\*|\(|\)|\+|\=|\<|\>|\?|\/|,|\.|\:|\;|\'| |\"|\&|\#|\[|\]|~|$|_/g,
								"-");
				str = str.replace(/-+-/g, "-");
				str = str.replace(/^\-+|\-+$/g, "");

				return str;
			}
		</script>
	</c:otherwise>
</c:choose>