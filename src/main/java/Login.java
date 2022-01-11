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
import java.util.Date;
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
public class Login extends HttpServlet {

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
        
        
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Login</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        } 
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
        //String dbDriver = "org.apache.derby.jdbc.ClientDriver";
        String dbURL ="";
        String dbName = "";
        String dbUsername = "";
        String dbPassword = "";
        
        String ar[]=new String[5];
        int nom=Integer.parseInt(request.getParameter("phone"));
        ar[0]=request.getParameter("fname");
        ar[1]=request.getParameter("lname");
        ar[2]=request.getParameter("email");
        ar[3]=request.getParameter("phone");
        ar[4]=request.getParameter("pass");
        System.out.println("hdjfh alsdkla |||||||||||||||||||||");
        try{
            //Class.forName(dbDriver);
            DriverManager.registerDriver(new org.postgresql.Driver());
            
            Connection con = DriverManager.getConnection(dbURL + dbName,dbUsername,dbPassword);
            PreparedStatement st = con.prepareStatement("insert into udat values(?,?,?,?,?)");
            
            
            /*for(int i=1;i<6;i++){
                System.out.println("value                if(i==4){
s : "+"i : "+i+ar[i-1]);
                    st.setInt(i,nom);
                    continue;
                }
                st.setString(i,ar[i-1]);
            }*/
            
            int lm=1;
            for(int k=0;k<ar.length;k++){
                
                if(k==3){
                    System.out.println("lm : "+lm+"pr : "+nom);
                    st.setInt(4,nom);
                    lm++;
                    
                    continue;
                }
                System.out.println("lm : "+lm+" : "+ar[k]);
                st.setString(lm,ar[k]);
                lm++;
                
        }
            st.executeUpdate();
            
            
            st.close();
            
        }
        catch(Exception e){
            System.out.println("hurrayy !!!!! exception"+e);
        }
        
        HttpSession session = request.getSession();
        PrintWriter writer = response.getWriter();
        writer.println("Session ID: " + session.getId());
        writer.println("Creation Time: " + new Date(session.getCreationTime()));
        writer. println("Last Accessed Time: " + new Date(session.getLastAccessedTime()));
        String eml=request.getParameter("email");
        String nam=request.getParameter("fname");
        session.setAttribute("userem", eml);
        session.setAttribute("username", nam);
        
        writer. println("NAME IS : "+eml);
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd=request.getRequestDispatcher("testservlet"); 
        System.out.println("//////////////");
        System.out.println("//////////////");
        System.out.println("//////////////");
        System.out.println("//////////////");
        System.out.println("//////////////");
        System.out.println("//////////////name"+nam);
        //String name=request.getAttribute("fname").toString();
        
        request.setAttribute("name1", nam);
        rd.forward(request,response);  
        //<%=request.getAttribute("Name")%>
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
