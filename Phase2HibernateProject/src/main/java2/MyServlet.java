
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.example.Product;
import com.example.HibernateUtil;


@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
        PrintWriter out;
       

    public MyServlet() {
        super();
    }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	try {
			     out = response.getWriter();
                out.println("<html><body>");
                int id = Integer.parseInt(request.getParameter("id"));
                int price = Integer.parseInt(request.getParameter("price"));
                String description = request.getParameter("description");
                
                if(id==0) {
               	 out.println("<h1>You must enter a value for the ID.</h1>");
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.include(request, response); 
                }
                else if(price==0) {
               	 out.println("<h1>You have to charge something for the item.</h1>");
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.include(request, response); 
                }
                else if(description.equals("")) {
               	 out.println("<h1>The product needs a description.</h1>");
               	 RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.include(request, response);    
                }
                else {
                SessionFactory factory = HibernateUtil.getSessionFactory();   
                Session session = factory.openSession();
                Transaction transaction = session.beginTransaction();
                Product p = new Product(id, price, description);
                session.save(p);
                transaction.commit();         
                session.close();
                factory.close();
                out.println("<h1>The product has been added successfully.</h1>");
                out.println("Please close your browser.");      
                out.println("</body></html>");
                } 
                
                } catch (java.lang.NumberFormatException e) {
                    out.println("<h1>You must enter an integer for the product ID and the price.</h1>");
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.include(request, response);   
                } catch (javax.persistence.PersistenceException e) {
                    out.println("<h1>That ID has already been taken, try again.</h1>");
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.include(request, response);   
                }catch (Exception e) {
               	 out.println("You have encountered a previously undetected error.");
                    e.printStackTrace();
                }
		 		out.close();
        }
}

