

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logic.ServerConnection;

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MyServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		PrintWriter out = response.getWriter();
        try {
        	    id = Integer.parseInt(request.getParameter("id"));
                out.println("<html><body>");
                InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
                Properties props = new Properties();
                props.load(in);
                ServerConnection conn = new ServerConnection(props.getProperty("url"), props.getProperty("userid"), props.getProperty("password"));
                Statement stmt = conn.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rst = stmt.executeQuery("select * from sys.products where id="+id);
                if(!rst.isBeforeFirst()) {
                	out.println("I'm sorry but your query didn't return any results as there are no products with an ID of " + id +".");
                }else {
                out.println("=============================================================================================================");
                out.println("<b>| Product ID | Product Name | Product Weight | Food Type | </b><br>");
                while (rst.next()) {
                        out.println("----------- " + rst.getInt("id") + " ----------- " 
                        + rst.getString("product")+ " ----------- " 
                        + rst.getString("weight")+ " ----------- " 
                        + rst.getString("food_type"));
                }
                out.println("=============================================================================================================");
                out.println("</body></html>");
                }
                stmt.close();
                out.close();
                conn.closeConnection();
                
        } catch (ClassNotFoundException e) {
                e.printStackTrace();
        } catch (SQLException e) {
                e.printStackTrace();
        } catch (java.lang.NumberFormatException e) {
			out.println("I'm sorry but product Id's are integers and you didn't enter an integer.");
		} catch (Exception e) {
			out.println("You have encountered a new, to me, error.");
			e.printStackTrace();
		} finally {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
