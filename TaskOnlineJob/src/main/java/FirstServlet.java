

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ConfigInterface config = new Config();
    private Connection con = null;
    private PreparedStatement prepare = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
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
		String footerString = "<footer>\n" +
		        "    <p>Author: Nam Cuong Tran</p>\n" +
		        "    <p>\n" +
		        "        <a href=\"mailto:cuongntran757@gmail.com\">cuongntran757@gmail.com</a>\n" +
		        "    </p>\n" +
		        "</footer>";
		String headerString = "<header><h1>SNVA Technology</h1>\n" +
		        "<nav>\n" +
		        "    <ul>\n" +
		        "        <li><a href=\"Page.html\">Home</a></li>\n" +
		        "        <li><a href=\"https://github.com/namcuong757?tab=repositories\">About</a></li>\n" +
		        "        <li><a href=\"https://www.linkedin.com/in/nam-cuong-tran-7425a1224/\">Contact</a></li>\n" +
		        "    </ul>\n" +
		        "</nav>\n" +
		        "</header>";
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		int age = Integer.parseInt(request.getParameter("age"));
		String skill = request.getParameter("skills");
		int experience = Integer.parseInt(request.getParameter("experience"));
		String city = request.getParameter("city");
		int salary = Integer.parseInt(request.getParameter("salary"));
		try
		{
			con = config.config();
			if(con != null)
			{
				
				String insert_query = "INSERT INTO job(name, address, age, skill, experience, city, salary) VALUES(?,?,?,?,?,?,?)";
				prepare = con.prepareStatement(insert_query, Statement.RETURN_GENERATED_KEYS);
				
				prepare.setString(1, name);
				prepare.setString(2, address);
				prepare.setInt(3, age);
				prepare.setString(4, skill);
				prepare.setInt(5, experience);
				prepare.setString(6, city);
				prepare.setInt(7, salary);
				
				int rowsAffected = prepare.executeUpdate();
				if(rowsAffected > 0)
				{
					System.out.println("Successfully Insert data in");
				}
				else
				{
					System.out.println("Failed to insert");
				}
				
				ResultSet generatedKeys = prepare.getGeneratedKeys();
				if (generatedKeys.next()) {
				    int primaryKey = generatedKeys.getInt(1); // Assuming the primary key is an integer
				    //++counter;
				    pw.println("<html><body>");
					pw.println("<link rel='stylesheet' href='style.css'>");
					pw.println(headerString);
					pw.println("<h2>Display</h2>");
					pw.println("<h3>Successfully Update DB</h3>");
					pw.println("<form method='post' action='MenuServlet'>");
					pw.println("<table>");
					pw.println("<tr><td>Your Candidate Number</td><td>" + primaryKey + "</td>");
					pw.println("</tr");				
					pw.println("<tr><td><input type='submit' value='Menu'></td></tr>");
					pw.println("</table>");
					pw.println("</form>");
					pw.println(footerString);
					pw.println("</body></html>");
				}
				else
				{
					System.out.println("No Key Found");
				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
