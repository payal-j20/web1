/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author payal
 */
public class testservlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        String unam=session.getAttribute("username").toString();
        
        processRequest(request, response);
         response.setContentType("text/html;charset=UTF-8");
         if(unam!=""){
             
         
        PrintWriter out= response.getWriter();

        RequestDispatcher rd = request.getRequestDispatcher("index.html");
        //String unam=request.getAttribute("name1").toString();
        
        rd.include(request, response);
        //out.println("<h2>Your username is: " + unam +"</h2><br/>");

        out.println("<script>var ki2=\""+unam+"\";document.getElementById(\"unam\").innerHTML = ki2;</script> ");
        /*out.println("<div style=\"background-color:pink;position:absolute;top:400px;left:1200pxwidth:300px;height:200px;border-style: solid;border-width: 2px;border-height:50px;\">\n" +
"<p>hii how are u ?</p>\n" +
"</div>");*/
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"newcss2.css\">");
        out.println("<script>var elem = document.getElementById('unam');\n" +
"        elem.parentNode.removeChild(elem);</script>");
        out.println("<div class=\"dropdown\">\n" +
"<button style=\"font-family:inherit;font-size:20px;font-style:Garamond,Serif;\">"+unam+"</button>\n" +
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
/*<div class="dropdown" style="left:1000px;">
<button style="font-family:inherit;font-size:20px;font-style:Garamond,Serif;">✈ Places to Visit</button>

<div class="dropdown-content">
    <a href="#">Rajasthan</a>
    <a href="#">Mumbai</a>
    <a href="#">Chennai</a>
    <a href="#">Gujarat</a>
  </div>
</div>
        
        
        
        */
                /*imp + "document.getElementById(\"unam\").onmouseover = function() {abc()};\n" +
"function abc(){"
                + "if(ki2==\""+unam+"\"){document.getElementById(\"u_data\").className=\"u_box\";"
                + "document.getElementById('u_data').innerHTML +=\"<button>My Account</button><br>\";"
                + "document.getElementById('u_data').innerHTML +=\"<button>My Bookings</button><br>\";"
                + "document.getElementById('u_data').innerHTML +=\"<button>Bookmarks</button><br>\"; "
                + "document.getElementById('u_data').innerHTML +=\"<button>Contact Us</button><br>\";}}"
                        + "document.getElementById(\"unam\").onmouseout = function() {abc2()};\n" +
"function abc2(){"
                        +"document.getElementById(\"u_data\").className=null;"
                        +"document.getElementById('u_data').innerHTML=null;}"
                        + "</script>");imp*/
        //out.println("<script>var ki2=\"Login\";document.getElementById(\"unam\").innerHTML = ki2;</script> ");
        //out.println("<script>document.getElementById(\"unam\").disabled = true;</script>");
        //out.println("<h1>hiiii"+unam+"</h1>");
        //document.getElementById('togglee').style.visibility = 'hidden';
        //request.setAttribute("name1", "nam");
        //out.println("<a href=\"upload.jsp\">Go to JSP form</a>");
    }
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
