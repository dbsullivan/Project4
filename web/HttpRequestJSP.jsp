<!--     
<html>
    <head><title>Project3 HTTP Request JSP forward from HttpRequestServlet</title></head>
    <body>
        <h2>HTTP Request data on a JSP Page</h2>
        <ul>
            <li>The remote computer making the request: ${requestDataBean.remoteHost}</li>
            <li>The address of the remote computer making the request: ${requestDataBean.remoteAddr}</li>
            <li>The HTTP method of the request: ${requestDataBean.requestHttpMethod}</li>      
            <li>The request URI: ${requestDataBean.requestURI}</li>     
            <li>The request URL: ${requestDataBean.requestURL}</li> 
            <li>The protocol of the request: ${requestDataBean.protocol}</li>             
            <li>The server name: ${requestDataBean.serverName}</li> 
            <li>The server port number: ${requestDataBean.serverPort}</li>             
            <li>The current Locale of the server: ${requestDataBean.locale}</li>  
            <li>The query string: ${requestDataBean.queryString}</li>              
            <li>The value of a query parameter with the name of queryParameter: ${requestDataBean.queryParameter}</li>
            <li>The value of the request header with the name of User-Agent: ${requestDataBean.requestHeader}</li>              
        </ul>
        <br/>        
        <a href='/java112'>Dave Sullivan Java112 Home</a>
    </body>
</html>  
-->

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--
Author: Reality Software
Website: http://www.realitysoftware.ca
Note: This is a free template released under the Creative Commons Attribution 3.0 license, 
which means you can use it in any way you want provided you keep the link to the author intact.
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<!-- header -->
    <div id="header">
    <div id="menu">
       <div id="menu_list"> 
        <a href="#">Home</a>
        <img src="images/splitter.gif" class="splitter" alt="" />
        <a href="#">About Us</a>
        <img src="images/splitter.gif" class="splitter" alt="" />
        <a href="#">Services</a>
        <img src="images/splitter.gif" class="splitter" alt="" />
        <a href="#">Pricing</a>
        <img src="images/splitter.gif" class="splitter" alt="" />
        <a href="#">Contacts</a>
        </div>
    </div>
</div>
      <div id="logo">
      <div id="logo_text">
      <a href="#">Dave Sullivan Java112 Home</a>
      <br/><br/>
      Holds the web server
      projects for Java112
	</div>
    </div>
    <!--end header -->
    <!-- main -->
    <div id="main">
	    <!--begin sidebar -->
          <div id="sidebar">
          <!--      <a href="/"><img src="images/clover.jpg" alt="Dave Sullivan Java112 Home" align="left" width=200 height=150 /></a>
            -->

          </div>
  
          <div id="text" >
        <h2>HTTP Request data on a JSP Page</h2>
        <ul>
            <li>The remote computer making the request: ${requestDataBean.remoteHost}</li>
            <li>The address of the remote computer making the request: ${requestDataBean.remoteAddr}</li>
            <li>The HTTP method of the request: ${requestDataBean.requestHttpMethod}</li>      
            <li>The request URI: ${requestDataBean.requestURI}</li>     
            <li>The request URL: ${requestDataBean.requestURL}</li> 
            <li>The protocol of the request: ${requestDataBean.protocol}</li>             
            <li>The server name: ${requestDataBean.serverName}</li> 
            <li>The server port number: ${requestDataBean.serverPort}</li>             
            <li>The current Locale of the server: ${requestDataBean.locale}</li>  
            <li>The query string (refresh with, http://localhost:8080/java112/request-servlet<b>?id=1&queryParameter=test</b> ) : ${requestDataBean.queryString}</li>
            <li>The value of a query parameter with the name of queryParameter: ${requestDataBean.queryParameter}</li>
            <li>The value of the request header with the name of User-Agent: ${requestDataBean.requestHeader}</li>              
        </ul>
        <br/>        
        <a href='/java112'>Dave Sullivan Java112 Home</a>
            
          </div>
    </div>
    <!-- end main -->
    <!-- footer -->
    <div id="footer">
    <div id="left_footer">&copy; Copyright 2008 <b>Green Mile</b></div>
    <div id="right_footer">

<!-- Please do not change or delete this link. Read the license! Thanks. :-) -->
Design by <a href="http://www.realitysoftware.ca" title="Website Design"><strong>Reality Software</strong></a> | Courtesy <a href="http://www.openwebdesign.org" target="_blank">OWD</a>, Thanks to 
<a href="http://www.ecommercewebsites.com.au/" target="_blank">Web Design</a>    </div>
</div>
    <!-- end footer -->
</body>
</html>
