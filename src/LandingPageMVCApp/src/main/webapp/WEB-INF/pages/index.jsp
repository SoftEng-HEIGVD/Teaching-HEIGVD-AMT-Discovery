<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html class="js">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Welcome to AMT</title>

		<!-- Stylesheets -->

		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/ionicons.min.css">
		<link rel="stylesheet" href="css/animate.css">
		<link rel="stylesheet" href="css/style.css">

		<!-- Google Fonts -->

		<link href='http://fonts.googleapis.com/css?family=Josefin+Sans:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic|Cinzel:400,700,900' rel='stylesheet' type='text/css'>

		<!-- Modernizr to provide HTML5 support for IE. -->
		<script src="js/modernizr.custom.js"></script>


	</head>
	<body>

		<!-- Preloader -->

		<div id="preloader"></div>

		<!-- Main Content -->

		<div id="wrap">

		<!-- Video Wrap -->

			<section id="video-wrap">
				<div id="video"></div>
				<div class="container">
					<div class="row">
						<div class="headline-wrap col-md-12">
							<div class="headline text-center fadeInDown">
								<h1>${requestScope.message}</h1>
							</div>
						</div>

						<div class="col-md-7 wow fadeInLeft" style="z-index: 9999;">
							<div class="headline-wrap">
								<h1 class="headline">
								We will play with...
								<br>
                                <c:forEach var="technology" items="${requestScope.technologies}">
                                  <span class="quotes">${technology}</span>                                  
                                </c:forEach>
								<br>
								It's going to be fun.
								</h1>
								<!-- SUCCESS OR ERROR MESSAGES -->
                				<div id="subscription-response"></div>
							</div>
						</div>
						<div class="col-md-5  wow fadeInRight">
							<div class="clock row">
						        <div class="col-xs-3 col-sm-3 col-md-6">
						            <div class="countdown-time-value clock-item clock-days">
						            	<div class="wrap">
							                <div class="inner">
							                    <div id="canvas-days" class="clock-canvas"></div>

							                    <div class="text">
							                        <p class="val">0</p>
							                        <p class="type-days type-time">DAYS</p>
							                    </div><!-- /.text -->
							                </div><!-- /.inner -->
							            </div><!-- /.wrap -->
						            </div>
						        </div><!-- /.clock-item -->

						        <div class="col-xs-3 col-sm-3 col-md-6">
						            <div class="clock-item clock-hours countdown-time-value">
						            	<div class="wrap">
							                <div class="inner">
							                    <div id="canvas-hours" class="clock-canvas"></div>

							                    <div class="text">
							                        <p class="val">0</p>
							                        <p class="type-hours type-time">HOURS</p>
							                    </div><!-- /.text -->
							                </div><!-- /.inner -->
							            </div><!-- /.wrap -->
						            </div>
						        </div><!-- /.clock-item -->

						        <div class="col-xs-3 col-sm-3 col-md-6">
						            <div class="clock-item clock-minutes countdown-time-value">
						            	<div class="wrap">
							                <div class="inner">
							                    <div id="canvas-minutes" class="clock-canvas"></div>

							                    <div class="text">
							                        <p class="val">0</p>
							                        <p class="type-minutes type-time">MINUTES</p>
							                    </div><!-- /.text -->
							                </div><!-- /.inner -->
							            </div><!-- /.wrap -->
						            </div>
						        </div><!-- /.clock-item -->

						        <div class="col-xs-3 col-sm-3 col-md-6">
						        	<div class="clock-item clock-seconds countdown-time-value">
						        		<div class="wrap">
							                <div class="inner">
							                    <div id="canvas-seconds" class="clock-canvas"></div>

							                    <div class="text">
							                        <p class="val">0</p>
							                        <p class="type-seconds type-time">SECONDS</p>
							                    </div><!-- /.text -->
							                </div><!-- /.inner -->
							            </div><!-- /.wrap -->
						        	</div>
						        </div><!-- /.clock-item -->
						    </div>
						</div>
					</div>
				</div>

			</section>


		<!-- Copyright Section -->

			<section id="footer">
				<div class="container">
					<div class="row">
						<div class="col-sm-8">
							<p class="copyright text-left">Copyright © 2016 HEIG-VD. All rights reserved.</p>
						</div>
						<div class="col-sm-4">
							<p class="copyright text-right">Theme by <a href="https://themewagon.com/">ThemeWagon</a></p>
						</div>
					</div>
				</div>
			</section>
		</div>


			

<!-- All the scripts -->

		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/jquery.videoBG.js"></script>
		<script src="js/jquery.sticky-kit.min.js"></script>
		<script src="js/wow.min.js"></script>
		<script src="js/kinetic.js"></script>
		<script src="js/jquery.final-countdown.min.js"></script>
		<script src="js/script.js"></script>

<!-- All the scripts Ends-->

	</body>
</html>