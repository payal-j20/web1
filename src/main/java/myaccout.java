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
public class myaccout extends HttpServlet {

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
           
        String dbURL ="";
        String dbName = "";
        String dbUsername = "";
        String dbPassword = "";

        
        
        HttpSession session = request.getSession();
        String un=session.getAttribute("userem").toString();
        String un2=session.getAttribute("username").toString();
        
        response.setContentType("text/html;charset=UTF-8");
        if(un!=""){
        try{
            String fn="",ln="",em="",ph="";
            Integer phone;
            
            PrintWriter out=response.getWriter();
            DriverManager.registerDriver(new org.postgresql.Driver());
            Connection con = DriverManager.getConnection(dbURL + dbName,dbUsername,dbPassword);
            Statement stmt = con.createStatement();  
            
            int no=0;
            ResultSet rs2 = stmt.executeQuery("select * from udat where email='"+un+"'");
            String imag="",detail="";
            while (rs2.next()) 
             { 
                 fn=rs2.getString(1);
                 ln=rs2.getString(2);
                 em=rs2.getString(3);
                 phone=rs2.getInt(4);
                 ph=phone.toString();
                 
             }
            
            
            
            
            
            
            
            
            System.out.println("valuus !!!!!!!!!!!!!11"+no);
            
            stmt.close();
            rs2.close();
            
            
            
            /* TODO output your page here. You may use following sample code. */
            out.write("\n");
            out.write("\n");
            out.write("\n");
            out.write("<!DOCTYPE html>\n");
            out.write("<html>\n");
            out.write("    <head>\n");
            out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"ss1.css\">\n");
            out.write("         <link rel=\"stylesheet\" type=\"text/css\" href=\"newcss2.css\">\n");
            out.write("        <link rel=\"icon\" type=\"image/png\" href=\"template\\img\\BESTTOTRAVELPNG.png\">\n");
            out.write("        <title>BEST TO TRAVEL</title>\n");
            out.write("        <meta charset=\"UTF-8\">\n");
            out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
            out.write("        <style>\n");
            out.write("            .start{\n");
            out.write("                width: 200px;height: 80px;\n");
            out.write("            }\n");
            out.write("            .banner{\n");
            out.write("                width: 100px;;height:400px; \n");
            out.write("            }\n");
            out.write("            \n");
            out.write("            \n");
            out.write("            .slideshow-container {\n");
            out.write("  \n");
            out.write("  position: relative;\n");
            out.write("  margin: auto;\n");
            out.write("}\n");
            out.write(" .prev, .next {\n");
            out.write("  cursor: pointer;\n");
            out.write("  position: absolute;\n");
            out.write("  top: 50%;\n");
            out.write("  width: auto;\n");
            out.write("  padding: 16px;\n");
            out.write("  margin-top: -22px;\n");
            out.write("  color: white;\n");
            out.write("  font-weight: bold;\n");
            out.write("  font-size: 18px;\n");
            out.write("  transition: 0.6s ease;\n");
            out.write("  border-radius: 0 3px 3px 0;\n");
            out.write("  user-select: none;\n");
            out.write("}\n");
            out.write("\n");
            out.write("/* Position the \"next button\" to the right */\n");
            out.write(".next {\n");
            out.write("  right: 0;\n");
            out.write("  border-radius: 3px 0 0 3px;\n");
            out.write("}\n");
            out.write("\n");
            out.write(".prev:hover, .next:hover {\n");
            out.write("  background-color: rgba(0,0,0,0.8);\n");
            out.write("}\n");
            out.write("\n");
            out.write("\n");
            out.write("/* Caption text */\n");
            out.write("\n");
            out.write("html {\n");
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
            out.write("}  \n");
            out.write(".bm{\n");
            out.write("    height:500px;\n");
            out.write("}\n");
            out.write(".bmc{\n");
            out.write("    width:100%; \n");
            out.write("    height:500px;\n");
            out.write("    position:absolute;\n");
            out.write("    top:100px;\n");
            out.write("    overflow-y: scroll;\n");
            out.write("  background-color: #dddddd;\n");
            out.write("}td,th{padding:30px;}");
            
            out.write("            \n");
            out.write("        </style>\n");
            out.write("        \n");
            out.write("    </head>\n");
            out.write("    <body >\n");
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
            
            
            out.write("            <div id=\"u_data\"></div>\n");
            out.write("         \n");
            out.write("        </div>\n");
            out.write("        <br>\n");
            out.write("        \n");
            out.write("        <div class=\"bm\">\n");
            out.write("        <div class=\"bmc\">\n");
            
                out.write("<div style=\"padding-top:10px;border: black;border-style: solid;\"><table style=\"font-size:30px;\">\n" +
                " \n" +
                "  <tr>\n" +
                "    <th>First name\n" +
                "    <td>"+fn+"</td>\n" +
                "    \n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <th>Last Name</th>\n" +
                "    <td>"+ln+"</td>\n" +
                "    \n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <th>Email</th>\n" +
                "    <td>"+em+"</td>\n" +
                "    \n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <th>Phone Number</th>\n" +
                "    <td>"+ph+"</td>\n" +
                "    \n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <th><a style=\"background-color: #dddddd;\n" +
"color: black;\n" +
"border: 2px solid white;\n" +
"padding: 10px 20px;\n" +
"text-align: center;\n" +
"text-decoration: none;\n" +
"text-decoration: none;\n" +
"color: black; \" href =\"mybm\" onMouseOver=\"this.style.backgroundColor ='white'\"\n" +
"        onMouseOut=\"this.style.backgroundColor ='#dddddd'\">MyBookmark</a></th>\n" +
                "    \n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    \n" +
                "    <th><a style=\"background-color: #dddddd;\n" +
"color: black;\n" +
"border: 2px solid white;\n" +
"padding: 10px 20px;\n" +
"text-align: center;\n" +
"text-decoration: none;\n" +
"text-decoration: none;\n" +
"color: black; \" href =\"#\" onMouseOver=\"this.style.backgroundColor ='white'\"\n" +
"        onMouseOut=\"this.style.backgroundColor ='#dddddd'\">My Bookings</a></th>\n" +
                "    \n" +
                "  </tr>\n" +
                " \n" +
                "</table></div>");
                
               


            out.write("        </div>\n");
            out.write("        </div>\n");
            out.write("        \n");
            out.write("        \n");
            out.write("        \n");
            out.write("        \n");
            out.write("<div style=\"padding-top: 20px;\">\n");
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
            out.write("  \n");
            out.write("    <p style=\"text-align: center;font-family: Garamond, serif;font-size: 40px;\">&#9992; Best to travel.com</p>\n");
            out.write("</footer>\n");
            out.write("</div>\n");
            out.write("    </body>\n");
            out.write("</html>\n");

        }
        catch(Exception e){
            System.out.println("EXCEPTION"+e);
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
