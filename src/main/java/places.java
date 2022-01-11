/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author payal
 */
public class places extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String un=session.getAttribute("userem").toString();
        String un2=session.getAttribute("username").toString();
        
        String dbURL ="";
        String dbName = "";
        String dbUsername = "";
        String dbPassword = "";
 
        
        
        
        
        String ar[]=new String[4];
        int i=0;
        
        response.setContentType("text/html;charset=UTF-8");
        String req=request.getParameter("pl_name");
        System.out.println("place---------------sxxxxxxxxxxxxxxxxXXXXXXXXXXXXXXXXXXXXXXx-------------");
        
        String p1="",p2="",p3="",p4="",p5="";
        String ck="template/img/";
        String nam="";
        if("r".equals(req)){
            ck+="rim";
            nam="Rajasthan";
        }
        else if("u".equals(req)){
            ck+="uim";
            nam="Uttarakhand";
        }
        else if("m".equals(req)){
            ck+="mim";
            nam="Maharashtra";
        }
        else if("c".equals(req)){
            ck+="cim";
            nam="Chennai";
        }
        else if("g".equals(req)){
            ck+="gim";
            nam="Gujarat";
        }
        p1=ck+"1.jpg";
        p2=ck+"2.jpg";
        p3=ck+"3.jpg";
        p4=ck+"4.jpg";
        
        if(un!=""){
        try {
            PrintWriter out = response.getWriter();
            DriverManager.registerDriver(new org.postgresql.Driver());
            Connection con = DriverManager.getConnection(dbURL + dbName,dbUsername,dbPassword);
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("select place from pdet where state='"+nam+"'");
             while (rs.next()) 
             {  
                System.out.println(i+" : "+rs.getString("place"));
                ar[i]=rs.getString("place");
                i++;
             } 
            /* TODO output your page here. You may use following sample code. */
            out.write("<!DOCTYPE html>\n");
            out.write("<html>\n");
            out.write("     <head>\n");
            out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"ss1.css\">\n");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"newcss2.css\">");
            out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
            out.write("<style>html {width: 100%;}\n" +
      "* {margin: 0;}\n" +
      ".site-footer {height: 200px; }\n" +
      ".site-footer {background: #dddddd;}.start{width: 200px;height: 80px;}.h1text{padding-top:130px;padding-left:80px;\n" +
"} </style>");
            out.write("        <title>Best to travel</title>\n");
            out.write("    </head>\n");
            out.write("    <body>\n");
            out.write("        <div class=\"start\">\n");
            out.write("            <input type=\"text\" placeholder=\"Search..\" style=\"display: inline;position :absolute;top:35px;left:300px;width :300px;height:30px;\">\n");
            out.write("            <input type=\"submit\" value=\"🔍\" style=\"font-size:25px;display: inline;position :absolute;top:35px;left:607px;width :50px;height:35px;\">\n");
            out.write("            <img class=\"a1\" style=\"left: 50px; display: inline; width: 200px;height: 80px;top: 5px;\" src=\"template\\img\\BESTTOTRAVELPNG.png\">\n");
            out.println("<div class=\"dropdown\">\n" +
      "<button style=\"font-family:inherit;font-size:20px;font-style:Garamond,Serif;\">"+un2+"</button>\n" +
      "<div class=\"dropdown-content\">\n" +
      "    <a href=\"\"myaccout\">My Account</a>\n" +
      "    <a href=\"#\">My Bookings</a>\n" +
      "    <a href=\"mybm\">Bookmarks</a>\n" +
           "<a href=\"#\">Contact Us</a>\n" +
      "  </div>\n" +
      "</div>");
        out.println("<div class=\"dropdown\" style=\"left:1000px;\" >\n" +
"<button style=\"font-family:inherit;font-size:20px;font-style:Garamond,Serif;\">Places to Visit</button>\n" +
"<div class=\"dropdown-content\">\n" +
"    <a id=\"r\" onclick=\"nexp(this)\"href=\"\">Rajasthan</a>\n" +
"    <a id=\"m\" onclick=\"nexp(this)\" href=\"\">Mumbai</a>\n" +
"    <a id=\"c\" onclick=\"nexp(this)\" href=\"\">Chennai</a>\n" +
     "<a id=\"g\" onclick=\"nexp(this)\" href=\"\">Gujarat</a>\n" +
     "<a id=\"u\" onclick=\"nexp(this)\" href=\"\">Uttarakhand</a>\n" +
"  </div>\n" +
"</div>");
      out.write("            <div id=\"u_data\"></div>\n");
      out.write("         \n");
      out.write("        </div>\n");
      out.println("<script>function nexp(x){"
                +"var k=x.id;");
        out.println("if(k==\"r\"){"
                + "document.getElementById(k).href=\"\\places?pl_name=r\";}");
        out.println("else if(k==\"c\"){"
                + "document.getElementById(k).href=\"places?pl_name=c\";}");
        out.println("else if(k==\"u\"){"
                + "document.getElementById(k).href=\"places?pl_name=u\";}");
       out.println("else if(k==\"m\"){"
                + "document.getElementById(k).href=\"places?pl_name=m\";}");
       out.println("else if(k==\"g\"){"
                + "document.getElementById(k).href=\"places?pl_name=g\";}");
        out.println( ""
                + "}</script>");
      
      out.write("        <br><div class=\"big\" >\n");
      out.write("      \n");
      out.write("        <div class=\"box-size\" style=\"width:500px;\">\n");
      out.write("        <div class=\"box-ins\">\n");
      out.write("        <div class=\"box-front\">\n");
      out.write("            <img onclick=\"detail(this)\" style=\"width: 500px;height: 300px\" src=\""+p1+"\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"box-back\">\n");
      out.write("        <h1 class=\"h1text\">" +ar[0]+"<br><a style=\"color:white;text-decoration: none;\" href=\"resorts?pl_nam="+ar[0]+"\">Click here to view more</a></h1>\n");
      out.write("        </div>\n");
      out.write("        </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"box-size\" style=\"width:500px;\">\n");
      out.write("        <div class=\"box-ins\">\n");
      out.write("        <div class=\"box-front\">\n");
      out.write("        <img onclick=\"detail(this)\" style=\"width: 500px;height: 300px\" src=\""+p2+"\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"box-back\">\n");
      out.write("        <h1 class=\"h1text\">"+ar[1]+"<br><a style=\"color:white;text-decoration: none;\" href=\"resorts?pl_nam="+ar[1]+"\">Click here to view more</a></h1>\n");
      out.write("        </div>\n");
      out.write("        </div>\n");
      out.write("        </div>\n");
      out.write("        </div>\n");
      out.write("        <br>    \n");
      out.write("        <div class=\"big\" >\n");
      out.write("        <div class=\"box-size\" style=\"width:500px;\">\n");
      out.write("        <div class=\"box-ins\">\n");
      out.write("        <div class=\"box-front\">\n");
      out.write("        <img onclick=\"detail(this)\" style=\"width: 500px;height: 300px\" src=\""+p3+"\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"box-back\">\n");
      out.write("        <h1 class=\"h1text\">"+ar[2]+"<br><a style=\"color:white;text-decoration: none;\" href=\"resorts?pl_nam="+ar[2]+"\">Click here to view more</a></h1>\n");
      out.write("        </div>\n");
      out.write("        </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      if(p4!=""){
      out.write("        <div id=\"im4\" onclick=\"detail(this.id)\" class=\"box-size\" style=\"width:500px;\">\n");
      out.write("        <div class=\"box-ins\">\n");
      out.write("        <div class=\"box-front\">\n");
      out.write("        <img  style=\"width: 500px;height: 300px\" src=\""+p4+"\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"box-back\">\n");
      out.write("        <h1 class=\"h1text\">" +ar[3]+"<br><a style=\"color:white;text-decoration: none;\" href=\"resorts?pl_nam="+ar[3]+"\">Click here to view more</a></h1>\n");
      out.write("        </div>\n");
      out.write("        </div>\n");
      out.write("        </div>\n");
      }
      out.write("        </div>\n");
      /*if(p5!=""){
          out.write("        <br>    \n");
      out.write("        <div class=\"big\" style=\"top:100px;\">\n");
      out.write("        <div class=\"box-size\" style=\"width:500px;\">\n");
      out.write("        <div class=\"box-ins\">\n");
      out.write("        <div class=\"box-front\">\n");
      out.write("        <img onclick=\"detail(this)\" style=\"width: 500px;height: 300px\" src=\""+p5+"\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"box-back\">\n");
      out.write("        <h1> back side </h1>\n");
      out.write("        </div>\n");
      out.write("        </div>\n");
      out.write("        </div></div></div>\n");
      out.write("        \n");
      }*/
      //out.write("<br><br>\n");
      out.write("        \n");
      out.write("<div style='padding-top: 20px;'>\n" +
"<footer style='padding-top: 20px;' class='site-footer'>\n" +
"    <span class='fam'>\n" +
"  <a >Contact us</a>\n" +
"  <br>\n" +
"    <a >About us</a>\n" +
"    <br>\n" +
"    <a >Career</a>\n" +
"    <br>\n" +
"    </span>\n" +
"    <span class='fam'>\n" +
"        <a >Support</a>\n" +
"        <br>\n" +
"    <a >Service</a>\n" +
"    <br>\n" +
"    <a >Other</a>\n" +
"    </span>\n" +
"        <span class='fam'>\n" +
"        <a >Terms & Condition</a>\n" +
"        <br>\n" +
"    <a >Privacy Policy</a>\n" +
"    <br>\n" +
"    <a >Terms Of Use</a>\n" +
"    </span>\n" +
"    \n" +
"    <!--<p class='footer-text'>Terms & Condition</p>\n" +
"    <p class='footer-text'>Privacy Policy</p>\n" +
"    <p class='footer-text'>Terms Of Use</p>\n" +
"    -->\n" +
"    <p style='text-align: center;font-family: Garamond, serif;font-size: 40px;'>&#9992; Best to travel.com</p>\n" +
"</footer>\n" +
"</div>");
      out.write("    </body>\n");
      out.write("</html>\n");
        }
        catch(Exception e){
            
        }
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try {
            PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            out.write("<!DOCTYPE html>\n");
            out.write("<html>\n");
            out.write("<body>hiiiiiiiiiiaska");
            out.write("</body>");
            out.write("</html>");
    }
        catch(Exception e){
            
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
