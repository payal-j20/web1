/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class resorts extends HttpServlet {

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
        int i=0;
        HttpSession session = request.getSession();
        String un=session.getAttribute("userem").toString();
        String un2=session.getAttribute("username").toString();
        
        System.out.println("----------------------@@@@@@@@@@@@@@@@@@@@@@@@@"+session.getAttribute("username"));
        String pl=request.getParameter("pl_nam");;
        
        String dbURL ="";
        String dbName = "";
        String dbUsername = "";
        String dbPassword = "";
 
        
        
        String hn[]=new String[4];
        String pr[]=new String[4];
        String adr[]=new String[4];
        String aw[]=new String[4];
        response.setContentType("text/html;charset=UTF-8");
        if(un!=""){
            
        
        try{
            PrintWriter out = response.getWriter();
            DriverManager.registerDriver(new org.postgresql.Driver());
            Connection con = DriverManager.getConnection(dbURL + dbName,dbUsername,dbPassword);
            Statement stmt = con.createStatement();  
            
            
            
            String loc="template\\img\\";
            ResultSet rs2 = stmt.executeQuery("select * from pdet where place='"+pl+"'");
            String imag="",detail="";
            while (rs2.next()) 
             { imag=rs2.getString("imnam");
                 System.out.println("@@@@@@@@@@@@@@@2"+imag);
                 detail=rs2.getString("detail");
             }
            loc+=imag;
            loc+=".jpg";
            
            ResultSet rs = stmt.executeQuery("select * from g3 where place='"+pl+"'");
             while (rs.next()) 
             {  
                
                hn[i]=rs.getString("hname");
                Integer l=rs.getInt("price");
                pr[i]=l.toString();
                adr[i]=rs.getString("address");
                aw[i]=rs.getString("awaykm");
                i++;
             }
             
             
            /* TODO output your page here. You may use following sample code. */
            out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("         <link rel=\"stylesheet\" type=\"text/css\" href=\"ss1.css\">\n");
      out.write("         <link rel=\"stylesheet\" type=\"text/css\" href=\"newcss2.css\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Best to travel</title>\n");
      out.write("        <style>\n");
      out.write("            html {\n");
      out.write("    width: 100%;\n");
      out.write("}\n");
      out.write("* {\n");
      out.write("  margin: 0;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".site-footer {\n");
      out.write("  /* .push must be the same height as footer */\n");
      out.write("  \n");
      out.write("  height: 200px; \n");
      out.write("}\n");
      out.write(".site-footer {\n");
      out.write("  background: #dddddd;\n");
      out.write("}\n");
      out.write(".h1text{\n");
      out.write("    padding-top:130px;\n");
      out.write("    padding-left:80px;\n");
      out.write("}       \n");
      out.write(".column{\n");
      out.write("    width:300px;\n");
      out.write("    height:500px;\n");
      out.write("    position:absolute;\n");
      out.write("    top:100px;\n");
      out.write("    left:930px;\n");
      out.write("    overflow-y: scroll;\n");
      out.write("}        \n");
      out.write(".row {\n");
      out.write("  background-color: #dddddd;\n");
      out.write("  padding-top: 20px;\n");
      out.write("  width:280px;\n");
      out.write("  height:190px;\n");
      out.write("  display:block;\n");
      out.write("}\n");
      out.write("div.ex1 {\n");
      out.write("  background-color: lightblue;\n");
      out.write("  height: 40px;\n");
      out.write("  width: 200px;\n");
      out.write("  overflow-y: scroll;\n");
      out.write("}\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"start\">\n");
      
      out.write("<div class=\"dropdown\">\n" +
      "<button style=\"font-family:inherit;font-size:20px;font-style:Garamond,Serif;\">"+un2+"</button>\n" +
      "<div class=\"dropdown-content\">\n" +
      "    <a href=\"myaccout\">My Account</a>\n" +
      "    <a href=\"#\">My Bookings</a>\n" +
      "    <a href=\"mybm\">Bookmarks</a>\n" +
           "<a href=\"#\">Contact Us</a>\n" +
      "  </div>\n" +
      "</div>");
        out.write("<div class=\"dropdown\" style=\"left:1000px;\" >\n" +
"<button style=\"font-family:inherit;font-size:20px;font-style:Garamond,Serif;\">Places to Visit</button>\n" +
"<div class=\"dropdown-content\">\n" +
"    <a id=\"r\" onclick=\"nexp(this)\"href=\"\">Rajasthan</a>\n" +
"    <a id=\"m\" onclick=\"nexp(this)\" href=\"\">Mumbai</a>\n" +
"    <a id=\"c\" onclick=\"nexp(this)\" href=\"\">Chennai</a>\n" +
     "<a id=\"g\" onclick=\"nexp(this)\" href=\"\">Gujarat</a>\n" +
     "<a id=\"u\" onclick=\"nexp(this)\" href=\"\">Uttarakhand</a>\n" +
"  </div>\n" +
"</div>");
      
      out.write("        </div>\n");
      out.write("<script>function nexp(x){"
                +"var k=x.id;");
        out.write("if(k==\"r\"){"
                + "document.getElementById(k).href=\"\\places?pl_name=r\";}");
        out.write("else if(k==\"c\"){"
                + "document.getElementById(k).href=\"places?pl_name=c\";}");
        out.write("else if(k==\"u\"){"
                + "document.getElementById(k).href=\"places?pl_name=u\";}");
       out.write("else if(k==\"m\"){"
                + "document.getElementById(k).href=\"places?pl_name=m\";}");
       out.write("else if(k==\"g\"){"
                + "document.getElementById(k).href=\"places?pl_name=g\";}");
        out.write( ""
                + "}</script>");
      out.write("            <input type=\"text\" placeholder=\"Search..\" style=\"display: inline;position :absolute;top:35px;left:300px;width :300px;height:30px;\">\n");
      out.write("            <input type=\"submit\" value=\"&#128269;\" style=\"font-size:25px;display: inline;position :absolute;top:35px;left:607px;width :50px;height:35px;\">\n");
      out.write("            <img class=\"a1\" style=\"left: 50px; display: inline; width: 200px;height: 80px;top: 5px;\"  src=\"template/img/BESTTOTRAVELPNG.png\">\n");
      out.write("            <div class=\"column\">\n");
      out.write("                <h1 align=\"center\">Resorts</h1> \n");
      
      for(int j=0;j<4;j++){
          out.write("        <div class=\"row\" style=\"padding-left: 10px;top:100px;\">\n");
      out.write("            <p name=\"rname"+j+"\" id=\"r_nam"+j+"\" style=\"padding-left:50px;font-style: bold;\">"+hn[j]+"</p><br>\n");
      out.write("            <p>"+adr[j]+"</p>\n");
      out.write("            <br><p><b>Price:</b>"+pr[j]+"</p>\n");
      if(aw[j]!=""){
          out.write("            <p>"+aw[j]+"</p>\n");
      }
      
      out.write("            <iframe style=\"display: none;\"name=\"df\"></iframe>\n");
      out.write("            <form id ="+j+" onsubmit=\"val"+j+"(this)\" action=\"deleteservlet\" style=\"padding-top:10px;\" method=\"post\" target=\"df\">\n");
      out.write("                <input value=\""+hn[j]+"\" name=\"resort\" id=\"r_v"+j+"\" type=\"text\" style=\"display:none;\">\n");
      out.write("                <input value=\""+adr[j]+"\" name=\"adr\" id=\"r_v"+j+"\" type=\"text\" style=\"display:none;\">\n");
      out.write("                <input value=\""+pl+"\" name=\"pl\" id=\"r_v"+j+"\" type=\"text\" style=\"display:none;\">\n");
      out.write("                <input value=\""+pr[j]+"\" name=\"price\" id=\"r_v"+j+"\" type=\"text\" style=\"display:none;\">\n");
      
      out.write("                <input id=\"di"+j+"\" name=\"na\" type=\"submit\" value=\"Add to Bookmark\"/>\n");
      out.write("                <input type=\"submit\" value=\"Add to Cart\"/>\n");
      out.write("            </form>\n");
      out.write("            \n");
      out.write("        </div><br>\n");
      out.write("<script>function val"+j+"(x){var i=x.id;document.getElementById(\"di\"+i).disabled = true;}</script>");
      }
      
      
      
     /*for(int j=0;j<4;j++){
   
      out.write("                <script>\n");
      out.write("                    \n");
      out.write("                    function val"+j+"(x){\n");
      
      out.write("                 var no=x.id;       "
              + "var k=document.getElementById(\"r_nam+no\").innerHTML; \n");
      out.write("                        document.getElementById(\"r_v\"+no).setAttribute(\"value\",k);\n");
      //out.write("                        document.getElementById(\"di\").setAttribute(\"name\",k);\n");
      out.write("                        document.getElementById(no).submit;\n");
      out.write("                        alert(k);\n");
      out.write("                    return false;\n");
      out.write("    }\n");
      out.write("                    </script>\n");
      
        }*/
      out.write("            <br>\n");
      out.write("        </div>\n");
      out.write("        <div style=\"display: inline-block;padding-left: 20px;height: 600px;\">\n");
      out.write("        <img src=\""+loc+"\" style=\"display: inline-block;top:130px;width:400px;height:350px;position: relative;\">\n");
      out.write("        <p style=\"display: inline-block;position: relative;padding-left:50px;width:300px;\">"+detail+"</p>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("    \n");
      out.write("        <br>\n");
      out.write("        <div style=\"padding-top: 20px;\">\n");
      out.write("<footer style=\"padding-top: 20px;\" class=\"site-footer\">\n");
      out.write("    <span class=\"fam\">\n");
      out.write("  <a >Contact us</a>\n");
      out.write("  <br>\n");
      out.write("    <a >About us</a>\n");
      out.write("    <br>\n");
      out.write("    <a >Career</a>\n");
      out.write("    <br>\n");
      out.write("    </span>\n");
      out.write("    <span class=\"fam\">\n");
      out.write("        <a >Support</a>\n");
      out.write("        <br>\n");
      out.write("    <a >Service</a>\n");
      out.write("    <br>\n");
      out.write("    <a >Other</a>\n");
      out.write("    </span>\n");
      out.write("        <span class=\"fam\">\n");
      out.write("        <a >Terms & Condition</a>\n");
      out.write("        <br>\n");
      out.write("    <a >Privacy Policy</a>\n");
      out.write("    <br>\n");
      out.write("    <a >Terms Of Use</a>\n");
      out.write("    </span>\n");
      out.write("    \n");
      out.write("    <!--<p class=\"footer-text\">Terms & Condition</p>\n");
      out.write("    <p class=\"footer-text\">Privacy Policy</p>\n");
      out.write("    <p class=\"footer-text\">Terms Of Use</p>\n");
      out.write("    -->\n");
      out.write("    <p style=\"text-align: center;font-family: Garamond, serif;font-size: 40px;\">&#9992; Best to travel.com</p>\n");
      out.write("</footer>\n");
      out.write("</div>\n");
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
