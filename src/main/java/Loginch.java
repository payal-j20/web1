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
public class Loginch extends HttpServlet {

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
        
        String em=request.getParameter("email");
        String ps=request.getParameter("pass");
        
        String dbURL ="";
        String dbName = "";
        String dbUsername = "";
        String dbPassword = "";
        
        
        String nam="";
        System.out.println("my namsd @@@@@@@@@@@@@@@2");
        RequestDispatcher rd; 
        boolean exist=false;
        System.out.println("em---------------"+em);
        System.out.println("ps---------------"+ps);
        
        try  {
            /* TODO output your page here. You may use following sample code. */
            DriverManager.registerDriver(new org.postgresql.Driver());
            Connection con = DriverManager.getConnection(dbURL + dbName,dbUsername,dbPassword);
            Statement st = con.createStatement();  
            
            ResultSet rs2 = st.executeQuery("select * from udat where (email='"+em+"' AND pas='"+ps+"')");
            
            
            //ResultSet rs3 = st.executeQuery("select * from udat where (email='"+em+"' AND pas='"+ps+"');");
            
            while (rs2.next()) 
             { 
                 exist=true;
                 nam=rs2.getString("fnam");
                 System.out.println("found !!!!!!1"+rs2.getString("fnam"));
             }}
        catch(Exception e){
            
        }
            if(exist==true){
                response.setContentType("text/html;charset=UTF-8");
                System.out.println("YAY!!!!!!!!!!!!!!!!!!!"+exist);
                rd=request.getRequestDispatcher("testservlet"); 
                
                HttpSession session = request.getSession();
                session.setAttribute("userem", em);
                session.setAttribute("username", nam);
                request.setAttribute("name1", nam);
                rd.forward(request,response);
                
                
                
            }
            else{
                response.setContentType("text/html;charset=UTF-8");
                System.out.println("NOOOOOO!!!!!!!!!!!!!!!1");
                rd=request.getRequestDispatcher("login2.html"); 
                rd.forward(request,response); 
                
                
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
