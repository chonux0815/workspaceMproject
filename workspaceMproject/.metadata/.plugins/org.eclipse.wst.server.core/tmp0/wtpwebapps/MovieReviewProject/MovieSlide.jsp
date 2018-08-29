
<html>
<head>
<meta charset="utf-8">
<title>너의 리뷰는</title>

	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet" />
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    </head>
    <style>
        .img_slide{
            width: 1000px;
            height:400px;
        }
    </style>
<body>
<div>
<div id="myCarousel" class="carousel slide" data-ride="carousel"> 
	
	<!--íì´ì§-->
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
        <li data-target="#myCarousel" data-slide-to="3"></li>
	</ol>

	<div class="carousel-inner">
		<div class="item active"> 
			<img src="images/s11.jpg" alt="First slide" height = "400px" class="img_slide">
			<div class="container">
				<div class="carousel-caption">
				</div>
			</div>
		</div>
		<div class="item"> 
			<img src="images/s22.jpg" data-src="" alt="Second slide" height = "400px" class="img_slide">
			<div class="container">
				<div class="carousel-caption">
				</div>
			</div>
		</div>
		<div class="item"> 
			<img src="images/s33.jpg" data-src="" alt="Third slide" height = "400px" class="img_slide">
			<div class="container"> 
				<div class="carousel-caption">
				</div>
			</div>
		</div>
        <div class="item"> 
			<img src="images/s44.jpg" data-src="" alt="Third slide" height = "400px" class="img_slide">
			<div class="container">
				<div class="carousel-caption">
				</div>
			</div>
		</div>
	
        
	</div>
	
	<a class="left carousel-control" href="#myCarousel" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> 
	<a class="right carousel-control" href="#myCarousel" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a> 
</div>
</div>

</body>
</html>
