<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--
author: W3layouts
author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html lang="en">
<head>
<title>ABC BANK</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
        var _smartsupp = _smartsupp || {};
        _smartsupp.key = '093c587d7b0acf6831b93ff92a23f95fb5f0906a';
        window.smartsupp||(function(d) {
                var s,c,o=smartsupp=function(){ o._.push(arguments)};o._=[];
                s=d.getElementsByTagName('script')[0];c=d.createElement('script');
                c.type='text/javascript';c.charset='utf-8';c.async=true;
                c.src='https://www.smartsuppchat.com/loader.js?';s.parentNode.insertBefore(c,s);
        })(document);
    </script>
	
	<!-- css files -->
    <link href="css/css_slider.css" rel="stylesheet"><!-- Slider css -->
    <link href="css/bootstrap.css" rel='stylesheet' type='text/css' /><!-- bootstrap css -->
    <link href="css/style.css" rel='stylesheet' type='text/css' /><!-- custom css -->
    <link href="css/font-awesome.min.css" rel="stylesheet"><!-- fontawesome css -->
    <link href="css/home.css" rel='stylesheet' type='text/css' />
	<!-- //css files -->
	
	<!-- google fonts -->
	<link href="//fonts.googleapis.com/css?family=Niramit:200,200i,300,300i,400,400i,500,500i,600,600i,700,700i&amp;subset=latin-ext,thai,vietnamese" rel="stylesheet">
	<!-- //google fonts -->
	
</head>
<body>

<!-- header -->
<header>
	<div class="container">
		<!-- nav -->
		<nav class="py-3 d-lg-flex">
			<div id="logo">
			<%String usrName=(String) session.getAttribute("name");
			 Integer balance=(Integer) session.getAttribute("balance"); 
			  Integer customer=(Integer) session.getAttribute("customer");
			  Integer deposit=(Integer) session.getAttribute("deposit");
			  Integer transaction=(Integer) session.getAttribute("transaction");%>
				<h1> <a href="home.jsp"><span class="fa fa-university"></span> ABC Bank </a> </h1>
				
			</div>
			
			<label for="drop" class="toggle"><span class="fa fa-bars"></span></label>
			<input type="checkbox" id="drop" />
			
			</ul>
		</nav>
		<nav class="py-3 d-lg-flex">
			<div id="logo">
		<h1 style="color:white">Welcome <%out.print(usrName); %></h1><br>
		</div>
		</nav>
		<!-- //nav -->
		
			
			<ul class="unlist">
				<li class="list"><a href="CheckBalance">Check Balance</a></li>
				<li class="list"><a href="moneyTransfer.jsp">Money Transfer</a></li>
				<li class="list"style="background-color: #ffc168;"><a href="loan.jsp">Apply Loan</a></li>
				<li class="list"><a href="GetStatement">Get Statement</a></li>
				<li class="list"><a href="changePass.jsp">Change Password</a></li>
				<li class="list"><a href="Logout">Logout</a></li>
				
			</ul>
		
	</div>
</header>
<!-- //header -->


<!-- banner -->
<div class="banner" id="home">
	<div class="layer">
		<div class="container">
			<div class="banner-text-w3pvt">
				<!-- banner slider-->
			
						
		<!-- //nav -->

				<!-- //banner slider-->
			</div>
		</div>
	</div>
</div>
<!-- //banner -->


<!-- about -->

<!-- //statistics -->

<!-- products -->
<section class="products py-5">
	<div class="container py-lg-5 py-3">
		
<%  String email=(String) session.getAttribute("email"); %>
<div>
<h3>Dear <% out.print(usrName); %> Thankyou for showing your intrest in applying for the loan from ABC Bank. Our Excecutive will contact you soon.You will get all update on your Email mentioned below.</h3></center>
<center><h3><% out.print(email); %></h3>
</div>	
				
	</div>
</section>
<!-- //products -->

<!-- stats section -->
<%@ include file="footer.jsp" %>
<!-- move top -->

</body>
</html>