<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="Text/html; charset=UTF-8">
<meta name="viewport" content="width=deive-width"; initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="park/park.css">
<title>KINGWANGJJANGMAN 게시판</title>
</head>
<body>


<%
		String userID = null;
		if(session.getAttribute("userID") != null){
			userID=(String)session.getAttribute("userID");
		}



%>
 <nav class="navbar navbar-default">
       <div class="navbar-header">
           <button type="button" class="navbar-toggle collapsed"
               data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
               aria-expanded="false">
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand"  href="main.jsp">KINWANGJJANGS 포트폴리오용 웹 사이트</a>    
       </div> 
        
       <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
           <ul class="nav navbar-nav">
                   <li class="active"><a href="main.jsp">메인페이지</a></li>
                   <li  ><a href="bbs.jsp">게시판</a></li>
           </ul>
           
           
           <%
           
           if(userID == null){
           
           %>
           
             <ul class="nav navbar-nav navbar-right" style="padding-right:20px;">
	             <li class="dropdown">
	             	<a href="#" class="dropdown-toggle"
	                     data-toggle="dropdown" role="button" aria-haspopup="true"
	                     aria-expanded="false">접속하기<span class="caret"></span></a>
	                	<ul class="dropdown-menu">
			                <li><a href="login.jsp">로그인</a></li>
			                <li><a href="join.jsp">회원가입</a></li>
			            </ul>
	              </li>           
	       	  </ul>
           
           
           <%
               }else{
           %>
          
               <ul class="nav navbar-nav navbar-right" style="padding-right:20px;">
	             <li class="dropdown">
	             	<a href="#" class="dropdown-toggle"
	                     data-toggle="dropdown" role="button" aria-haspopup="true"
	                     aria-expanded="false">회원관리<span class="caret"></span></a>
	                	<ul class="dropdown-menu">
			               
			                <li><a href="LogoutAction.jsp">로그아웃</a></li>
			            </ul>
	              </li>           
	       	  </ul>
          
          
          <%
               }
          
          %>
     
       </div>
   </nav>
   
   
   <div class="container">
   		<div class="jumbotron">
   			<div class="container">
   				<h1>웹 사이트 목적</h1>
   				<p>이 웹사이트는 JSP 연습 목적으로 만든 포트폴리오이며 정보처리 및 여러 시험의 기록을 위해 만들어진 개인 페이지 입니다.프레임워크는 부트 스트랩을 이용하였습니다.</p>
   				<p><a class ="btn btn-primary btn-pull" href="http://kingwangjjangsfood.shop/free" role="button"> 킹스 사이트이동하기</a></p>
   			</div>
   		
   		
   		</div>
   	
   </div>
   
   <div class="container">
   		<div class="carousel" id="myCarousel" data-ride="carousel">
   		
   			<ol class="carousel-indicators">
   				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	   			<li data-target="#myCarousel" data-slide-to="1" ></li>
	   			<li data-target="#mmyCarousel" data-slide-to="2" ></li>
   			</ol>
   			
   			<div class="carousel-inner" >
   				<div class="item active" >
   					<img src="images/4.jpg" style="width:1200px; height:400px;">
   				</div>
   				<div class="item">
   					<img src="images/5.jpg" style="width:1200px; height:400px;">
   				</div>
   				<div class="item">
   					<img src="images/6.jpg" style="width:1200px; height:400px;">
   				</div>		
   			</div>
   		
   			<a class ="left carousel-control" href="#myCarousel" data-slide="prev">
   				<span class="glyphicon glyphicon-chevron-left"></span>
   			</a>
   			<a class ="right carousel-control" href="#myCarousel" data-slide="next">
   				<span class="glyphicon glyphicon-chevron-right"></span>
   			</a>
   		
   		</div>
   	
   </div>
  
   

	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>