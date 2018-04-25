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
    
    <title>添加商品页面</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.min.css">		
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/bootstrap-fileupload.js"></script>
  

  </head>  
  
  <body>
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
<form class="navbar-form navbar-right">
         <select  id="sel" onchange="javascript:doit();" class="form-control">
	    		<option selected="selected">请选择</option>
				 <option pay="1" value="1">大牌彩妆</option>
				 <option pay="2" value="2">高定限量</option>
				 <option pay="3" value="3">钟表王国</option>
				 <option pay="4" value="4">母婴用品</option>				  
		</select>
     </form>
  </ul>
  
  <script language="javascript"> 
 
function doit() {
            var select = document.getElementById("sel");
          
            var option =  select.options[select.selectedIndex].getAttribute("pay");
            if(option== "1" ){
                document.getElementById("div1").style="display:display";
            } 
            else { 
                document.getElementById("div1").style="display:none";
            }
            if(option== "2" ){
            	document.getElementById("div2").style="display:display";
            }
            else { 
                document.getElementById("div2").style="display:none";
            }
            if(option== "3" ){
            	document.getElementById("div3").style="display:display";
            }
            else { 
                document.getElementById("div3").style="display:none";
            }
            if(option== "4" ){
            	document.getElementById("div4").style="display:display";
            }
            else { 
                document.getElementById("div4").style="display:none";
            }
        }
         
</script> 
   	  
   	<main class="container-fluid">
	    <div class="row">
	  
		
		<!-- 第一个类型的添加页面 -->
		
		   <div id ="div1" class="col-md-10">		   				
		      <s:form action="goods/goods_addGoods" cssClass="form-horizontal" enctype="multipart/form-data">
		       <div class="panel panel-success">
			       <div class="panel-heading">
		               <h4 class="panel-title"> <i class="fa fa-cutlery"></i> 添 加 商 品 </h4>
		           </div>
		           <div class="panel-body">
				       <div class="form-group">
			                <label class="control-label col-md-3">商品名称</label>
			                <div class="col-md-4">
                              <input type="text" name="goods.goodsname" class="form-control input-sm" required>
                           </div>
			           </div>  
			           <div class="form-group">
			                <label class="control-label col-md-3">商品单价</label>
			                <div class="col-md-2">
                              <input type="text" name="goods.price" class="form-control input-sm" placeholder="&yen;" required>
                            </div>
			           </div>
			           
			           <div class="form-group">
			                <label class="control-label col-md-3">商品图片</label>
			                <div class="col-md-4">
                              <div class="fileupload fileupload-new" data-provides="fileupload">
                                <div class="fileupload-new thumbnail" style="width: 200px; height: 150px;">
                                   <img src="<%=basePath%>upload/demoUpload.jpg" alt="" />
                                </div>
                                <div class="fileupload-preview fileupload-exists thumbnail" 
                                   style="max-width: 200px; max-height:150px; line-height: 20px;">
                                </div>
                                <div>
                                   <span class="btn btn-file btn-primary"><span class="fileupload-new">浏览</span>
                                   <span class="fileupload-exists">浏览</span><input type="file" name="goodsPhoto"/></span>
                                   <a href="#" class="btn btn-danger fileupload-exists" data-dismiss="fileupload">取消</a>
                                </div>
                              </div>
                            </div>
			           </div>
			           <div class="form-group col-md-3">
				          <button type="submit" class="btn btn-success pull-right">提  交 </button>
				       </div>
				   </div>
				</div>
		    </s:form>		    
		  </div>
		  
		  <!-- 第二个类型的添加页面 -->
		  
		  <div id ="div2" class="col-md-10">		   				
		      <s:form action="gaoding/gaoding_addGao" cssClass="form-horizontal" enctype="multipart/form-data">
		       <div class="panel panel-success">
			       <div class="panel-heading">
		               <h4 class="panel-title"> <i class="fa fa-cutlery"></i> 添 加 商 品 </h4>
		           </div>
		           <div class="panel-body">
				       <div class="form-group">
			                <label class="control-label col-md-3">商品名称</label>
			                <div class="col-md-4">
                              <input type="text" name="gao.gaoname" class="form-control input-sm" required>
                           </div>
			           </div>  
			           <div class="form-group">
			                <label class="control-label col-md-3">商品单价</label>
			                <div class="col-md-2">
                              <input type="text" name="gao.gprice" class="form-control input-sm" placeholder="&yen;" required>
                            </div>
			           </div>
			           
			           <div class="form-group">
			                <label class="control-label col-md-3">商品图片</label>
			                <div class="col-md-4">
                              <div class="fileupload fileupload-new" data-provides="fileupload">
                                <div class="fileupload-new thumbnail" style="width: 200px; height: 150px;">
                                   <img src="<%=basePath%>upload/demoUpload.jpg" alt="" />
                                </div>
                                <div class="fileupload-preview fileupload-exists thumbnail" 
                                   style="max-width: 200px; max-height:150px; line-height: 20px;">
                                </div>
                                <div>
                                   <span class="btn btn-file btn-primary"><span class="fileupload-new">浏览</span>
                                   <span class="fileupload-exists">浏览</span><input type="file" name="gaoPhoto"/></span>
                                   <a href="#" class="btn btn-danger fileupload-exists" data-dismiss="fileupload">取消</a>
                                </div>
                              </div>
                            </div>
			           </div>
			           <div class="form-group col-md-3">
				          <button type="submit" class="btn btn-success pull-right">提  交 </button>
				       </div>
				   </div>
				</div>
		    </s:form>		    
		  </div>
		  
		  <!-- 第三个类型的添加页面 -->
		  
		  <div id ="div3" class="col-md-10">		   				
		      <s:form action="watch/watch_addWatch" cssClass="form-horizontal" enctype="multipart/form-data">
		       <div class="panel panel-success">
			       <div class="panel-heading">
		               <h4 class="panel-title"> <i class="fa fa-cutlery"></i> 添 加 商 品 </h4>
		           </div>
		           <div class="panel-body">
				       <div class="form-group">
			                <label class="control-label col-md-3">钟表名称</label>
			                <div class="col-md-4">
                              <input type="text" name="watch.watchname" class="form-control input-sm" required>
                           </div>
			           </div>  
			           <div class="form-group">
			                <label class="control-label col-md-3">钟表单价</label>
			                <div class="col-md-2">
                              <input type="text" name="watch.wprice" class="form-control input-sm" placeholder="&yen;" required>
                            </div>
			           </div>
			           
			           <div class="form-group">
			                <label class="control-label col-md-3">商品图片</label>
			                <div class="col-md-4">
                              <div class="fileupload fileupload-new" data-provides="fileupload">
                                <div class="fileupload-new thumbnail" style="width: 200px; height: 150px;">
                                   <img src="<%=basePath%>upload/demoUpload.jpg" alt="" />
                                </div>
                                <div class="fileupload-preview fileupload-exists thumbnail" 
                                   style="max-width: 200px; max-height:150px; line-height: 20px;">
                                </div>
                                <div>
                                   <span class="btn btn-file btn-primary"><span class="fileupload-new">浏览</span>
                                   <span class="fileupload-exists">浏览</span><input type="file" name="watchPhoto"/></span>
                                   <a href="#" class="btn btn-danger fileupload-exists" data-dismiss="fileupload">取消</a>
                                </div>
                              </div>
                            </div>
			           </div>
			           <div class="form-group col-md-3">
				          <button type="submit" class="btn btn-success pull-right">提  交 </button>
				       </div>
				   </div>
				</div>
		    </s:form>		    
		  </div>
		  
		  <!-- 第四个类型的添加页面 -->
		  
		  <div id ="div4" class="col-md-10">		   				
		      <s:form action="moms/moms_addMoms" cssClass="form-horizontal" enctype="multipart/form-data">
		       <div class="panel panel-success">
			       <div class="panel-heading">
		               <h4 class="panel-title"> <i class="fa fa-cutlery"></i> 添 加 商 品 </h4>
		           </div>
		           <div class="panel-body">
				       <div class="form-group">
			                <label class="control-label col-md-3">商品名称</label>
			                <div class="col-md-4">
                              <input type="text" name="moms.momsname" class="form-control input-sm" required>
                           </div>
			           </div>  
			           <div class="form-group">
			                <label class="control-label col-md-3">商品单价</label>
			                <div class="col-md-2">
                              <input type="text" name="moms.mprice" class="form-control input-sm" placeholder="&yen;" required>
                            </div>
			           </div>
			           
			           <div class="form-group">
			                <label class="control-label col-md-3">商品图片</label>
			                <div class="col-md-4">
                              <div class="fileupload fileupload-new" data-provides="fileupload">
                                <div class="fileupload-new thumbnail" style="width: 200px; height: 150px;">
                                   <img src="<%=basePath%>upload/demoUpload.jpg" alt="" />
                                </div>
                                <div class="fileupload-preview fileupload-exists thumbnail" 
                                   style="max-width: 200px; max-height:150px; line-height: 20px;">
                                </div>
                                <div>
                                   <span class="btn btn-file btn-primary"><span class="fileupload-new">浏览</span>
                                   <span class="fileupload-exists">浏览</span><input type="file" name="momsPhoto"/></span>
                                   <a href="#" class="btn btn-danger fileupload-exists" data-dismiss="fileupload">取消</a>
                                </div>
                              </div>
                            </div>
			           </div>
			           <div class="form-group col-md-3">
				          <button type="submit" class="btn btn-success pull-right">提  交 </button>
				       </div>
				   </div>
				</div>
		    </s:form>		    
		  </div>
	   </div>
	</main>
 
         
  </body>
</html>
    

