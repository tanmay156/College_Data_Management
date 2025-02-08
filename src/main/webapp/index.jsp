
<%
	if(session.getAttribute("name")== null)
	{
		response.sendRedirect("login.jsp");
	}
%>



<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />


<meta name="author" content="" />
<title>College Management System</title>

<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js"crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
	
<link rel="stylesheet" href="css/head.css">
<!-- Core theme CSS (includes Bootstrap)-->


</head>
<body id="page-top">
	<!-- Navigation-->
	<nav
		class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="#page-top">College Management System</a>
			<button
				class="navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded"
				type="button" data-bs-toggle="collapse"
				data-bs-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ms-auto">
				<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="logout">Sign In</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="logout">Logout</a></li>
						<li class="nav-item mx-0 mx-lg-1 bg-danger"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="logout"><%=session.getAttribute("name") %></a></li>   <!-- for name on the navbar -->
					
				</ul>
			</div>
		</div>
	</nav>
	<!-- Masthead-->
	<header class="masthead bg-primary text-white text-center">
		<div class="container d-flex align-items-center flex-column">
			<!-- Masthead Avatar Image-->
			<img class="masthead-avatar mb-5" src="assets/img/avataaars.svg"
				alt="..." />
			<!-- Masthead Heading-->
			<h1 class="masthead-heading text-uppercase mb-0">Welcome To College Management System</h1>
			<!-- Icon Divider-->
			<div class="divider-custom divider-light">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<!-- Masthead Subheading-->
			<p class="masthead-subheading font-weight-light mb-0">Web Application Development</p>
		</div>
	</header>
	
	<!-- Portfolio Section-->
	<section class="page-section portfolio" id="portfolio">
		
		<div class="container">
			<!-- Portfolio Section Heading-->
			<h5 class="page-section-heading text-center text-secondary mb-0">Register Student Mark </h5>
			<button class="btn btn-primary stud-details-btn" type="submit" style="margin-left: 935px;
    		margin-top: -63px;"><a href="registermark.html">Click Me !</a></button>
		</div>
		
		
		<div class="container">
			<!-- Portfolio Section Heading-->
			<h5 class="page-section-heading text-center text-secondary mb-0">Register Student </h5>
			<button class="btn btn-primary stud-details-btn" type="submit" style="margin-left: 935px;
    		margin-top: -63px;"><a href="registerstudent.html">Click Me !</a></button>
		</div>
		
		<div class="container">
			<!-- Portfolio Section Heading-->
			<h5 class="page-section-heading text-center text-secondary mb-0">Show Student Details </h5>
			<button class="btn btn-primary stud-details-btn" type="submit" style="margin-left: 935px;
    		margin-top: -63px;"><a href="showfulldata"> Click Me !</a></button>
		</div>
		
		<div class="container">
			<!-- Portfolio Section Heading-->
			<h5 class="page-section-heading text-center text-secondary mb-0">Edit Student Details </h5>
			<button class="btn btn-primary stud-details-btn" type="submit" style="margin-left: 935px;
    		margin-top: -63px;"><a href="showstudentdata"> Click Me !</a></button>
		</div>
		
		<div class="container">
			<!-- Portfolio Section Heading-->
			<h5 class="page-section-heading text-center text-secondary mb-0">Edit Mark Details</h5>
			<button class="btn btn-primary stud-details-btn" type="submit" style="margin-left: 935px;
    		margin-top: -63px;"><a href="showmarkdata"> Click Me !</a></button>
		</div>
		
		<div class="container">
			<!-- Portfolio Section Heading-->
			<h5 class="page-section-heading text-center text-secondary mb-0">Register Staff Details </h5>
			<button class="btn btn-primary stud-details-btn" type="submit" style="margin-left: 935px;
    		margin-top: -63px;"><a href="registerstaff.html">Click Me !</a></button>
		</div>
		
		<div class="container">
			<!-- Portfolio Section Heading-->
			<h5 class="page-section-heading text-center text-secondary mb-0">Show Staff Details </h5>
			<button class="btn btn-primary stud-details-btn" type="submit" style="margin-left: 935px;
    		margin-top: -63px;"><a href="showstaffdata"> Click Me !</a></button>
		</div>
		
	</section>
	
	<!-- Footer-->
	<footer class="footer text-center">
		<div class="container">
			<div class="row">
				<!-- Footer Location-->
				<div class="col-lg-4 mb-5 mb-lg-0">
					<h4 class="text-uppercase mb-4">Location</h4>
					<p class="lead mb-0">
						Profound Edutech Pvt Ltd, <br /> Ashok Stambh, Nashik - 422001
					</p>
				</div>
				<!-- Footer Social Icons-->
				<div class="col-lg-4 mb-5 mb-lg-0">
					<h4 class="text-uppercase mb-4">Around the Web</h4>
					<a class="btn btn-outline-light btn-social mx-1" href="#!"><i
						class="fab fa-fw fa-facebook-f"></i></a> <a
						class="btn btn-outline-light btn-social mx-1" href="#!"><i
						class="fab fa-fw fa-twitter"></i></a> <a
						class="btn btn-outline-light btn-social mx-1" href="#!"><i
						class="fab fa-fw fa-linkedin-in"></i></a> <a
						class="btn btn-outline-light btn-social mx-1" href="#!"><i
						class="fab fa-fw fa-dribbble"></i></a>
				</div>
				<!-- Footer About Text-->
				<div class="col-lg-4">
					<h4 class="text-uppercase mb-4">About This Project</h4>
					<p class="lead mb-0">
						The college management system project report contains the important
						methods and details in creating the project. The most important of which
						is to centralize the data administration and accessibility. We can be able to input, 
						maintain, and access student data more simply. It will collect and can use data whenever it needed
					</p>
				</div>
			</div>
		</div>
	</footer>
	<!-- Copyright Section-->
	<div class="copyright py-4 text-center text-white">
		<div class="container">
			<small>Copyright &copy; College Management System  Developed By  Tanmay & Chandan CSS</small>
		</div>
	</div>




	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
	
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>
