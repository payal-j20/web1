<%-- 
    Document   : statewise
    Created on : Jan 6, 2022, 4:08:17 PM
    Author     : shiv
--%>
<%! String ki="template/im5.jpg"; %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <link rel="stylesheet" type="text/css" href="ss1.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= ki %></title>
    </head>
    <body>
        <div class="start">
            <input type="text" placeholder="Search.." style="display: inline;position :absolute;top:35px;left:300px;width :300px;height:30px;">
            <input type="submit" value="🔍" style="font-size:25px;display: inline;position :absolute;top:35px;left:607px;width :50px;height:35px;">
            <img class="a1" style="left: 50px; display: inline; width: 200px;height: 80px;top: 5px;" src="template\BESTTOTRAVELPNG.png">
            <button id="unam" onclick="myfun_2()" class="a1" style="display: inline; top: 20px;left:1200px;" title="Login">Login</button>
            <div id="u_data"></div>
         
        </div>
        <div class="big" style="top:100px;">
      
        <div class="box-size" style="width:500px;">
        <div class="box-ins">
        <div class="box-front">
            <img onclick="detail(this)" style="width: 500px;height: 300px" src="template/im4.jpg">
        </div>
        <div class="box-back">
        <h1> back side</h1>
        </div>
        </div>
        </div>

        <div class="box-size" style="width:500px;">
        <div class="box-ins">
        <div class="box-front">
        <img onclick="detail(this)" style="width: 500px;height: 300px" src="<%=ki %>">
        </div>
        <div class="box-back">
        <h1> Rajasthan's golden desert ...</h1>
        </div>
        </div>
        </div>
        </div>
        <br>    
        <div class="big" style="top:100px;">
        <div class="box-size" style="width:500px;">
        <div class="box-ins">
        <div class="box-front">
        <img onclick="detail(this)" style="width: 500px;height: 300px" src="template/im6.jpg">
        </div>
        <div class="box-back">
        <h1> back side </h1>
        </div>
        </div>
        </div>
        
        <div id="im4" onclick="detail(this.id)" class="box-size" style="width:500px;">
        <div class="box-ins">
        <div class="box-front">
        <img  style="width: 500px;height: 300px" src="template/im4.jpg">
        </div>
        <div class="box-back">
        <h1> back side </h1>
        </div>
        </div>
        </div>
        </div>
        <br>
        
        <p style="position: absolute;top:800px;" id="demo">ihi</p>
        <script>
            function detail(x){
                document.getElementById("demo").innerHTML = x;
            }
            </script>
    </body>
</html>
