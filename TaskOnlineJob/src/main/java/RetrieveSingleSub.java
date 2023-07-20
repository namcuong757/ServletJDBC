

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
 * Servlet implementation class RetrieveSingleSub
 */
@WebServlet("/RetrieveSingleSub")
public class RetrieveSingleSub extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Config config = new Config();
	private Connection con = config.config();
	private Statement statement = null;
	private ResultSet resultSet = null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveSingleSub() {
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
		String bootstrapCSS = "<link\n" +
		        "\thref=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\"\n" +
		        "\trel=\"stylesheet\"\n" +
		        "\tintegrity=\"sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM\"\n" +
		        "\tcrossorigin=\"anonymous\">";

		String bootstrapJS = "<script\n" +
		        "\tsrc=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"\n" +
		        "\tintegrity=\"sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz\"\n" +
		        "\tcrossorigin=\"anonymous\"></script>";
		String htmlCode = "<nav class=\"navbar navbar-expand-lg bg-dark\">\n"
                + "    <div class=\"container-fluid\">\n"
                + "        <a class=\"navbar-brand ml-5\" style=\"color: yellow\" href=\"HomePage.html\">JobLook</a>\n"
                + "        <button class=\"navbar-toggler\" type=\"button\"\n"
                + "            data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNavDropdown\"\n"
                + "            aria-controls=\"navbarNavDropdown\" aria-expanded=\"false\"\n"
                + "            aria-label=\"Toggle navigation\">\n"
                + "            <span class=\"navbar-toggler-icon\"></span>\n"
                + "        </button>\n"
                + "        <div class=\"collapse navbar-collapse\" id=\"navbarNavDropdown\">\n"
                + "            <ul class=\"navbar-nav mx-auto\">\n"
                + "                <!-- Use mx-auto class for center alignment -->\n"
                + "                <li class=\"nav-item\"><a class=\"nav-link active text-light\"\n"
                + "                        aria-current=\"page\" href=\"HomePage.html\">Home</a></li>\n"
                + "                <li class=\"nav-item \"><a class=\"nav-link text-light\"\n"
                + "                        href=\"https://github.com/namcuong757?tab=repositories\">About</a></li>\n"
                + "                <li class=\"nav-item\"><a class=\"nav-link text-light\"\n"
                + "                        href=\"https://www.linkedin.com/in/nam-cuong-tran-7425a1224/\">Contact</a></li>\n"
                + "                <li class=\"nav-item dropdown\"><a\n"
                + "                        class=\"nav-link dropdown-toggle text-light\" href=\"#\" role=\"button\"\n"
                + "                        data-bs-toggle=\"dropdown\" aria-expanded=\"false\">Login/Register</a>\n"
                + "                    <ul class=\"dropdown-menu\">\n"
                + "                        <li><a class=\"dropdown-item\" href=\"Login.html\">Login</a></li>\n"
                + "                        <li><a class=\"dropdown-item\" href=\"#\">Register</a></li>\n"
                + "                    </ul></li>\n"
                + "            </ul>\n"
                + "        </div>\n"
                + "    </div>\n"
                + "</nav>";
		int id = Integer.parseInt(request.getParameter("id"));
		String query = "Select * From job Where Cno = " + id;
		con = config.config();
		try {
			statement = con.createStatement();
			resultSet = statement.executeQuery(query);
			pw.println("<html><body>");
			pw.println(bootstrapCSS);
			pw.println(bootstrapJS);
			pw.println(htmlCode);
			pw.println("<link rel='stylesheet' href='style.css'>");
			pw.println("<h1>Display Candidate</h1>");
			pw.println("<div class=\"table-responsive\">");
			pw.println("<table class=\"table table-bordered table-hover table-dark\">");
			pw.println("<thead><tr>"
			        + "<th scope=\"col\">Cno</th>"
			        + "<th scope=\"col\">Name</th>"
			        + "<th scope=\"col\">Address</th>"
			        + "<th scope=\"col\">Age</th>"
			        + "<th scope=\"col\">Skill</th>"
			        + "<th scope=\"col\">Experience</th>"
			        + "<th scope=\"col\">City</th>"
			        + "<th scope=\"col\">Salary</th>"
			        + "</tr></thead>");
			pw.println("<tbody>"); // Added tbody tag to wrap the table body content
			while (resultSet.next()) {
			    int cid = resultSet.getInt("Cno");
			    String name = resultSet.getString("name");
			    String address = resultSet.getString("address");
			    int age = resultSet.getInt("age");
			    String skill = resultSet.getString("skill");
			    int experience = resultSet.getInt("experience");
			    String city = resultSet.getString("city");
			    int salary = resultSet.getInt("salary");

			    // Rows should be on the same line with all the columns
			    pw.println("<tr>"
			            + "<td>" + cid + "</td>"
			            + "<td>" + name + "</td>"
			            + "<td>" + address + "</td>"
			            + "<td>" + age + "</td>"
			            + "<td>" + skill + "</td>"
			            + "<td>" + experience + "</td>"
			            + "<td>" + city + "</td>"
			            + "<td>" + salary + "</td>"
			            + "</tr>");
			}
			pw.println("</tbody>"); // Closed the tbody tag
			pw.println("</table>");
			pw.println("</div>");
			pw.println(footerString);
			pw.println("</body></html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
