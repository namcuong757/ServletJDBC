

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServelet
 */
@WebServlet("/LoginServelet")
public class LoginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConfigInterface config = new Config();
    private Connection con = config.config();
    private PreparedStatement prepare = null;
    private ResultSet rs = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		String userDb = null, passwordDb = null;
		String user_query = "Select user,password from logIn;";
		try 
		{
			prepare = con.prepareStatement(user_query);
			rs = prepare.executeQuery();
			while(!rs.next())
			{
				userDb = rs.getString("user");
				passwordDb = rs.getString("password");
			}
			if(userDb != null&& passwordDb != null)
			{
				if(user.equals(userDb) && password.equals(passwordDb))
				{
					response.sendRedirect("http://localhost:8080/TaskOnlineJob/Menu.html");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
