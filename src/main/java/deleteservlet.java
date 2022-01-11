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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author payal
 */
public class deleteservlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String dbURL ="";
        String dbName = "";
        String dbUsername = "";
        String dbPassword = "";
 
        
        
        
        HttpSession session = request.getSession();
        String unam=session.getAttribute("userem").toString();
        if(unam!=""){
        try  {
            PrintWriter out = response.getWriter();
            DriverManager.registerDriver(new org.postgresql.Driver());
            Connection con = DriverManager.getConnection(dbURL + dbName,dbUsername,dbPassword);
            PreparedStatement st = con.prepareStatement("insert into udatbook2 values(?,?,?,?,?)");
            
            
            String ki=request.getParameter("resort");
            int pr=Integer.parseInt(request.getParameter("price"));
            String pl=request.getParameter("pl");
            String adr=request.getParameter("adr");
            
            
            
            st.setString(1,unam);
            st.setString(2,ki);
            st.setInt(3, pr);
            st.setString(4,pl);
            st.setString(5,adr);
            st.executeUpdate();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Best to travel</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Added to bookmark " + unam+":"+ki+": " + "</h1>");
            out.println("</body>");
            out.println("</html>");
            System.out.println("|||||||||||||||||||||||||"+ki);
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX"+unam);
        }
        catch(Exception e){
            System.out.println("------------exception"+e);
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
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try  {
            PrintWriter out = response.getWriter();
            processRequest(request,response);
            String ki=request.getParameter("resort");
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet deleteservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet deleteservlet at " + request.getContextPath()+":"+ki+": " + "</h1>");
            out.println("</body>");
            out.println("</html>");
            System.out.println("|||||||||||||||||||||||||"+ki);
        }
        catch(Exception e){
            
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
