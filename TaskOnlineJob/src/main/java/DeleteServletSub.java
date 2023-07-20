

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServletSub
 */
@WebServlet("/DeleteServletSub")
public class DeleteServletSub extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Config config = new Config();
	private Connection con = config.config();
	private Statement statement = null;
	private ResultSet resultSet = null;      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServletSub() {
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
		PrintWriter pw = response.getWriter();
		String footerString = "<footer>\n" +
		        "    <p>Author: Nam Cuong Tran</p>\n" +
		        "    <p>\n" +
		        "        <a href=\"mailto:cuongntran757@gmail.com\">cuongntran757@gmail.com</a>\n" +
		        "    </p>\n" +
		        "</footer>";
		String headerString = "<header>\n<h1>SNVA Technology</h1>\n" +
		        "<nav>\n" +
		        "    <ul>\n" +
		        "        <li><a href=\"MenuServlet\">Home</a></li>\n" +
		        "        <li><a href=\"https://github.com/namcuong757?tab=repositories\">About</a></li>\n" +
		        "        <li><a href=\"https://www.linkedin.com/in/nam-cuong-tran-7425a1224/\">Contact</a></li>\n" +
		        "    </ul>\n" +
		        "</nav>\n" +
		        "</header>";
		response.setContentType("text/html");
		int id = Integer.parseInt(request.getParameter("id"));
		String query = "DELETE FROM job Where Cno = " + id;
		con = config.config();
		String style = "\n<link rel='stylesheet' href='style.css'>";
		pw.println("<html><body>" + headerString + style);
		try {
			statement = con.createStatement();
			int affectedRows = statement.executeUpdate(query);
			if(affectedRows > 0)
			{
				pw.println("<h2>Deleted the record in DB</h2>");
			}
			else
			{
				pw.println("<h2>Fail to delete the record in DB</h2>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.println("<a href='MenuServlet'>");
		pw.println(footerString);
		pw.println("</body></html>");
	}

}
