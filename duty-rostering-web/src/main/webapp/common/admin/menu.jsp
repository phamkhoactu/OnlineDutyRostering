<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url value="admin-employee-list.html" var="adminEmployeeUrl">
	<c:param name="urlType" value="url_list"></c:param>
</c:url>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
	<li class="nav-item" data-toggle="tooltip" data-placement="right"
		title="Dashboard"><a class="nav-link" href="<c:url value="/admin-home.html"/>"> <i
			class="fa fa-fw fa-dashboard"></i> <span class="nav-link-text">Dashboard</span>
	</a></li>
	
		<li class="nav-item" data-toggle="tooltip" data-placement="right"
		title="Employee"><a
		class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
		href="#collapseExamplePages" data-parent="#exampleAccordion"> <i
			class="fa fa-fw fa-table"></i> <span class="nav-link-text"><fmt:message key="label.employee" bundle="${lang}"/></span>
	</a>
		<ul class="sidenav-second-level collapse" id="collapseExamplePages">
			<li><a href="${adminEmployeeUrl}"><fmt:message key="label.employee.list" bundle="${lang}"/></a></li>
			<li><a href="register.html">Registration Page</a></li>
			<li><a href="forgot-password.html">Forgot Password Page</a></li>
			<li><a href="blank.html">Blank Page</a></li>
		</ul></li>
	
	
	<li class="nav-item" data-toggle="tooltip" data-placement="right"
		title="Tables"><a class="nav-link" href="tables.html"> <i
			class="fa fa-fw fa-table"></i> <span class="nav-link-text">Tables</span>
	</a></li>
	<li class="nav-item" data-toggle="tooltip" data-placement="right"
		title="Components"><a
		class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
		href="#collapseComponents" data-parent="#exampleAccordion"> <i
			class="fa fa-fw fa-wrench"></i> <span class="nav-link-text">Components</span>
	</a>
		<ul class="sidenav-second-level collapse" id="collapseComponents">
			<li><a href="navbar.html">Navbar</a></li>
			<li><a href="cards.html">Cards</a></li>
		</ul></li>
	<li class="nav-item" data-toggle="tooltip" data-placement="right"
		title="Example Pages"><a
		class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
		href="#collapseExamplePages" data-parent="#exampleAccordion"> <i
			class="fa fa-fw fa-table"></i> <span class="nav-link-text"><fmt:message key="label.roster" bundle="${lang}"/></span>
	</a>
		<ul class="sidenav-second-level collapse" id="collapseExamplePages">
			<li><a href="${adminEmployeeUrl}"><fmt:message key="label.manage.roster.list" bundle="${lang}"/></a></li>
			<li><a href="register.html">Registration Page</a></li>
			<li><a href="forgot-password.html">Forgot Password Page</a></li>
			<li><a href="blank.html">Blank Page</a></li>
		</ul></li>
	<li class="nav-item" data-toggle="tooltip" data-placement="right"
		title="Menu Levels"><a
		class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
		href="#collapseMulti" data-parent="#exampleAccordion"> <i
			class="fa fa-fw fa-sitemap"></i> <span class="nav-link-text">Menu
				Levels</span>
	</a>
		<ul class="sidenav-second-level collapse" id="collapseMulti">
			<li><a href="#">Second Level Item</a></li>
			<li><a href="#">Second Level Item</a></li>
			<li><a href="#">Second Level Item</a></li>
			<li><a class="nav-link-collapse collapsed"
				data-toggle="collapse" href="#collapseMulti2">Third Level</a>
				<ul class="sidenav-third-level collapse" id="collapseMulti2">
					<li><a href="#">Third Level Item</a></li>
					<li><a href="#">Third Level Item</a></li>
					<li><a href="#">Third Level Item</a></li>
				</ul></li>
		</ul></li>
	<li class="nav-item" data-toggle="tooltip" data-placement="right"
		title="Link"><a class="nav-link" href="#"> <i
			class="fa fa-fw fa-link"></i> <span class="nav-link-text">Link</span>
	</a></li>
</ul>
<ul class="navbar-nav sidenav-toggler">
	<li class="nav-item"><a class="nav-link text-center"
		id="sidenavToggler"> <i class="fa fa-fw fa-angle-left"></i>
	</a></li>
</ul>