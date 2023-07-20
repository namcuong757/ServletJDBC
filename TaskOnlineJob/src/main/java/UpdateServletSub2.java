

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class UpdateServletSub2
 */
@WebServlet("/UpdateServletSub2")
public class UpdateServletSub2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Config config = new Config();
	private Connection con = config.config();
	private Statement statement = null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServletSub2() {
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
		String headerString = "<header>\n<h1>SNVA Technology</h1>\n" +
		        "<nav>\n" +
		        "    <ul>\n" +
		        "        <li><a href=\"MenuServlet\">Home</a></li>\n" +
		        "        <li><a href=\"https://github.com/namcuong757?tab=repositories\">About</a></li>\n" +
		        "        <li><a href=\"https://www.linkedin.com/in/nam-cuong-tran-7425a1224/\">Contact</a></li>\n" +
		        "    </ul>\n" +
		        "</nav>\n" +
		        "</header>";

		Cookie[] ck = request.getCookies();
		String id = null;
		if(ck != null)
		{
			
			for(Cookie cookie : ck)
			{
				if (cookie.getName().equals("id"))
				{
					id = cookie.getValue();
					break;
				}
			}
		}
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		int age = Integer.parseInt(request.getParameter("age"));
		String skill = request.getParameter("skills");
		int experience = Integer.parseInt(request.getParameter("experience"));
		String city = request.getParameter("city");
		int salary = Integer.parseInt(request.getParameter("salary"));
		pw.println("<html><body>");
		String style = "<link rel='stylesheet' href='style.css'>";
		pw.println(style);
		pw.println(headerString);
		if(id != null)
		{
			String update_query = "UPDATE job SET name = '" + name + "', address = '" + address + "', skill = '" + skill + "', experience = " + experience + ", city = '" + city + "', salary = " + salary + " WHERE Cno = " + id;

			try {
				statement = con.createStatement();
				int affectedRows = statement.executeUpdate(update_query);
				if(affectedRows > 0)
				{
					pw.println("<h2>Succesfully Updated</h2>");
				}
				else
				{
					pw.println("<h2>Fail to Update</h2>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		pw.println(footerString);
		pw.println("</body></html>");
		
	}

}
