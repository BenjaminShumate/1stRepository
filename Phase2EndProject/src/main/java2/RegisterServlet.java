

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.example.User;
import com.example.HibernateUtil;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
        PrintWriter out;
        RequestDispatcher rd; 

    public RegisterServlet() {
        super();
    }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	   out = response.getWriter();
               out.println("<html><body>");
               String username = request.getParameter("username");
               String password = request.getParameter("password");
               
               if(username.equals(null)) {
              	 out.println("<h1 style=\"color:red\">You must enter a value for the username.</h1>");
                   rd = request.getRequestDispatcher("register.jsp");
                   rd.include(request, response); 
               }
               else if(username.length()<8 || username.length() > 32) {
              	 out.println("<h1 style=\"color:red\">Your username must be larger than 7 characters and less than 33 characters.</h1>");
                   rd = request.getRequestDispatcher("register.jsp");
                   rd.include(request, response); 
               }
               else if(password.equals(null)) {
              	 out.println("<h1 style=\"color:red\">You must have a password.</h1>");
              	   rd = request.getRequestDispatcher("register.jsp");
                   rd.include(request, response);    
               }
               else if(password.length()<8 || password.length() > 32) {
                	 out.println("<h1 style=\"color:red\">Your password must be larger than 7 characters and less than 33 characters.</h1>");
                	 rd = request.getRequestDispatcher("register.jsp");
                     rd.include(request, response); 
               } else {
               SessionFactory factory = HibernateUtil.getSessionFactory();   
               Session session = factory.openSession();
               Transaction transaction = session.beginTransaction();
               
               String hql = ("from User where username='" + username + "' and password='" + password +"'");
               @SuppressWarnings("unchecked")
   			   List<User> users = (List<User>) session.createQuery(hql).list(); 
               if(!users.isEmpty()) {
            	   out.println("<h1 style=\"color:red\">The username you selected already exists.</h1>");
            	   session.close();
            	   rd = request.getRequestDispatcher("register.jsp");
                   rd.include(request, response); 
               } else {
               User u = new User(username, password);
               session.save(u);
               transaction.commit();         
               out.println("<h1>The user has been succesfully added.</h1>");  
               out.println("<br><a href=index.jsp>Click here to return to the login page.</a><br>");
               session.close();
               }   
               }
         	out.println("</body></html>");
            out.close();  
        }
}

