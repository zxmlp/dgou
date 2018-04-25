<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>所有Gaoding</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet"  href="<%=basePath%>css/bootstrap.min.css">
	 <link rel="stylesheet" href="<%=basePath%>css/style.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/font-awesome.css">
	 <script  type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	  <script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<link rel="shortcut icon"  href="<%=basePath%>images/1128.png">

  </head>
<body>
  <div class="top-header">
		<div class="container">
			<div class="top-header-main">
				<div class="col-md-6 top-header-left">
				    <div class="box">
		                   <c:choose>
		                     <c:when test="${user.name ==null}">
		                    <p> <a href="reg.jsp">注册</a>
		                      <a href="login.jsp">登录</a> </p>
		                       </c:when>
		                      <c:otherwise>
		               <div class="yonghuming"><c:out value="${user.name}"></c:out>, 欢迎您!</div>
		                    </c:otherwise>
		                </c:choose>
                   </div>
               </div>
			   <div class="col-md-6 top-header-left">
					<div class="cart box_1">
						<a href="main.jsp">
					 		 <div class="total">
								<span class="simpleCart_total"></span></div>
								<img src="images/cart-1.png" alt=""></a>
						<p><a href="order_main.jsp" class="simpleCart_empty">Empty Cart</a></p>
					</div>
				</div>
			</div>
		</div>
	</div>
	

	
<div class="logo">
		<a href="goods/goods_showGoods"><h1>BUY All YOU WANT</h1></a>
	</div>
<ul class="nav nav-pills">
<li class="active"><a href="goods/goods_showGoods">首页</a></li>
<li><a href="goods/goods_showGoods">大牌彩妆</a></li>
<li><a href="gaoding/gaoding_showGao">高定限量</a></li>
<li><a href="watch/watch_showWatch">钟表王国</a></li>
<li><a href="moms/moms_showMoms">母婴用品</a></li>
<li><a href="main-1.jsp">关于我们</a></li>
<form class="navbar-form navbar-right" action="gaoding/gaoding_queryGao" method="post">
          <input type="text" class="form-control" placeholder="Search" name="keyWords">
        <button type="submit" class="btn btn-default">Submit</button>
     </form>
  </ul>

 
 
  <script>  
      $('.carousel').carousel({
  interval: 1000
})</script>  
      
      <div id="myCarousel" class="carousel slide">
        <!-- 轮播（Carousel）指标 -->
        <ol class="carousel-indicators">
         <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
         <li data-target="#myCarousel" data-slide-to="1"></li>
         <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>  
        <!-- 轮播（Carousel）项目 -->
        <div class="carousel-inner">
         <div class="item active">
           <img src="images/g01.jpg" class="img-responsive" alt="First slide">
         </div>
         <div class="item">
           <img src="images/g02.jpg" class="img-responsive" alt="Second slide">
         </div>
         <div class="item">
           <img src="images/g05.jpg" class="img-responsive" alt="Third slide">
         </div>
        </div>
        <!-- 轮播（Carousel）导航 -->
        <a class="carousel-control left" href="#myCarousel"
         data-slide="prev">‹</a>
        <a class="carousel-control right" href="#myCarousel"
         data-slide="next">›</a>
      </div> 


	

<div class="about"> 
    <div class="container">
			<div class="about-top grid-1">
				<div class="col-md-4 about-left">
					<figure class="effect-bubba">
						<img class="img-responsive" src="images/a_1.jpg" alt=""/>
						<figcaption>
							<h2>Chanel</h2>
							<p>on sale</p>	
						</figcaption>			
					</figure>
				</div>
				<div class="col-md-4 about-left">
					<figure class="effect-bubba">
						<img class="img-responsive" src="images/a_2.jpg" alt=""/>
						<figcaption>
							<h4>Givenchy</h4>
							<p>on sale</p>	
						</figcaption>			
					</figure>
				</div>
				<div class="col-md-4 about-left">
					<figure class="effect-bubba">
						<img class="img-responsive" src="images/a_3.jpg" alt=""/>
						<figcaption>
							<h4>Tom Ford</h4>
							<p>on sale</p>	
						</figcaption>			
					</figure>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>



 <div class="product"> 
		<div class="container">
			<div class="product-top">
			<div class="product-one">
			<s:if test="#session.user.name =='admin'">
	      		        
		            <div class="col-md-3 product-left">
						<div class="product-main simpleCart_shelfItem">
							<a href="tjsp-g.jsp"><img class="img-responsive zoom-img" src="images/1515.jpg" alt="" /></a>
							<div class="product-bottom">
								<h3>点击添加商品</h3>
							</div>	 
							</div>
							</div>       
	        
	        
	    
				
				  <s:iterator value="gaoList" status="status">
					<div class="col-md-3 product-left">
						<div class="product-main simpleCart_shelfItem">
							<a href="gaoding/gaoding_showDetail?gao.gaoid=<s:property value='gaoid'/>" class="mask"><img class="img-responsive zoom-img" src="<%=basePath%><s:property value='gfilepath'/>" alt="" /></a>
							<div class="product-bottom">
								<h3><s:property value="gaoname"/></h3>
								 <a href="order/order_addOrder?gao.gaoid=<s:property 
	                  value='gaoid'/>&user.name=<s:property value='#session.user.name'/>" class="add-order">
								<p>立即下单</p>
								</a>
								<h4><a class="item_add" href="#"><i></i></a> <span class=" item_price">&yen;<s:property value="gprice"/></span></h4>
							</div>
							<div class="srch">
								<span>-50%</span>
							</div>
						</div>
					</div>
			
			 </s:iterator>
			 	 </s:if>
			   <s:else>
			  
				  <s:iterator value="gaoList" status="status">
					<div class="col-md-3 product-left">
						<div class="product-main simpleCart_shelfItem">
							<a href="gaoding/gaoding_showDetail?gao.gaoid=<s:property value='gaoid'/>" class="mask"><img class="img-responsive zoom-img" src="<%=basePath%><s:property value='gfilepath'/>" alt="" /></a>
							<div class="product-bottom">
								<h3><s:property value="gaoname"/></h3>
								 <a href="order/order_addOrder?gao.gaoid=<s:property 
	                  value='gaoid'/>&user.name=<s:property value='#session.user.name'/>" class="add-order">
								<p>立即下单</p>
								</a>
								<h4><a class="item_add" href="#"><i></i></a> <span class=" item_price">&yen;<s:property value="gprice"/></span></h4>
							</div>
							<div class="srch">
								<span>-50%</span>
							</div>
						</div>
					</div>
			 </s:iterator>
			 </s:else>
			</div>
			</div>
			</div>
			</div>
	
	
  </body>
</html>
