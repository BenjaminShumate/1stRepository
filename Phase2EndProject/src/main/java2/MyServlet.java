
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
import com.example.User;
import com.example.HibernateUtil;


@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
        PrintWriter out;
        RequestDispatcher rd; 

    public MyServlet() {
        super();
    }
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        	PrintWriter out = response.getWriter();
    		SessionFactory factory = HibernateUtil.getSessionFactory(); 
    		Session session = factory.openSession(); //Issue here
            String hql = ("from User where username='"+request.getParameter("username")+"' and password='"+request.getParameter("password")+"'");
            @SuppressWarnings("unchecked")
			List<User> users = (List<User>) session.createQuery(hql).list(); 
            if(users.isEmpty()) {
            	out.println("<html><body><h1 style=\"color:red\">Invalid username and/or password.</h1></body></html>");
            	rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response); 
            } else {
            	response.addHeader("id", ((Integer)users.get(0).getUserId()).toString());
            	rd = request.getRequestDispatcher("success.jsp");
                rd.forward(request, response); 
            }
            out.println("</body></html>");
            out.close();
            session.close();
        }
}

