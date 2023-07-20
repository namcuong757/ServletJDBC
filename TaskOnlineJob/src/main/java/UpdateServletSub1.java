

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
import javax.servlet.http.Cookie;
/**
 * Servlet implementation class UpdateServletSub1
 */
@WebServlet("/UpdateServletSub1")
public class UpdateServletSub1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Config config = new Config();
	private Connection con = config.config();
	private Statement statement = null;
	private ResultSet resultSet = null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServletSub1() {
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
		String id = request.getParameter("id");
		Cookie ck = new Cookie("id", id);
		int cid = 0, age = 0, experience = 0, salary = 0;
		String name = null, address = null, skill = null, city = null;
		String query = "Select * From job Where Cno = " + id;
		con = config.config();
		try 
		{
			statement = con.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) 
			{
			    cid = resultSet.getInt("Cno");
			    name = resultSet.getString("name");
			    address = resultSet.getString("address");
			    age = resultSet.getInt("age");
			    skill = resultSet.getString("skill");
			    experience = resultSet.getInt("experience");
			    city = resultSet.getString("city");
			    salary = resultSet.getInt("salary");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		response.addCookie(ck);
		response.setContentType("text/html");
		String htmlCode = "<html>\n"
		        + "<head>\n"
		        + "<meta charset=\"UTF-8\">\n"
		        + "<title>SessionDBTask</title>\n"
		        + "<link rel=\"stylesheet\" href=\"style.css\">\n"
		        + "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n"
		        + "integrity=\"sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM\"\n"
		        + "crossorigin=\"anonymous\">\n"
		        + "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"\n"
		        + "integrity=\"sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz\"\n"
		        + "crossorigin=\"anonymous\"></script>\n"
		        + "</head>\n"
		        + "<body>\n"
		        + "<nav class=\"navbar navbar-expand-lg bg-dark\">\n"
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
		        + "</nav>\n"
		        + "<div class=\"container mt-5\">\n"
		        + "<h2 class=\"text-center\">Register</h2>\n"
		        + "<form method=\"post\" action=\"FirstServlet\">\n"
		        + "<div class=\"form-group row\">\n"
		        + "<label for=\"name\" class=\"col-sm-2 col-form-label\">Enter Name</label>\n"
		        + "<div class=\"col-sm-10\">\n"
		        + "<input type=\"text\" class=\"form-control\" id=\"name\" name=\"name\" value=\"" + name + "\">\n"
		        + "</div>\n"
		        + "</div>\n"
		        + "<div class=\"form-group row\">\n"
		        + "<label for=\"address\" class=\"col-sm-2 col-form-label\">Enter Address</label>\n"
		        + "<div class=\"col-sm-10\">\n"
		        + "<input type=\"text\" class=\"form-control\" id=\"address\" name=\"address\" value=\"" + address +"\">\n"
		        + "</div>\n"
		        + "</div>\n"
		        + "<div class=\"form-group row\">\n"
		        + "<label for=\"age\" class=\"col-sm-2 col-form-label\">Enter Age</label>\n"
		        + "<div class=\"col-sm-10\">\n"
		        + "<input type=\"number\" class=\"form-control\" id=\"age\" name=\"age\" value=" + age +">\n"
		        + "</div>\n"
		        + "</div>\n"
		        + "<div class=\"form-group row\">\n"
		        + "<label for=\"skills\" class=\"col-sm-2 col-form-label\">Select Skill</label>\n"
		        + "<div class=\"col-sm-10\">\n"
		        + "<select class=\"form-control\" id=\"skills\" name=\"skills\">\n"
		        + "<option value=\"java\">Java/JEE</option>\n"
		        + "<option value=\".NET\">.NET</option>\n"
		        + "<option value=\"angular\">Angular</option>\n"
		        + "<option value=\"react\">React</option>\n"
		        + "<option value=\"spring\">Spring/Springboot</option>\n"
		        + "</select>\n"
		        + "</div>\n"
		        + "</div>\n"
		        + "<div class=\"form-group row\">\n"
		        + "<label for=\"experience\" class=\"col-sm-2 col-form-label\">Enter Experience</label>\n"
		        + "<div class=\"col-sm-10\">\n"
		        + "<input type=\"number\" class=\"form-control\" id=\"experience\" name=\"experience\">\n"
		        + "</div>\n"
		        + "</div>\n"
		        + "<div class=\"form-group row\">\n"
		        + "<label for=\"city\" class=\"col-sm-2 col-form-label\">Prefer Location</label>\n"
		        + "<div class=\"col-sm-10\">\n"
		        + "<input type=\"text\" class=\"form-control\" id=\"city\" name=\"city\">\n"
		        + "</div>\n"
		        + "</div>\n"
		        + "<div class=\"form-group row\">\n"
		        + "<label for=\"salary\" class=\"col-sm-2 col-form-label\">Expected Salary</label>\n"
		        + "<div class=\"col-sm-10\">\n"
		        + "<input type=\"number\" class=\"form-control\" id=\"salary\" name=\"salary\">\n"
		        + "</div>\n"
		        + "</div>\n"
		        + "<div class=\"form-group row mt-4\">\n"
		        + "<div class=\"col-sm-2\"></div>\n"
		        + "<div class=\"col-sm-10\">\n"
		        + "<button type=\"submit\" class=\"btn btn-primary\">Continue</button>\n"
		        + "<button type=\"reset\" class=\"btn btn-secondary\">Reset</button>\n"
		        + "</div>\n"
		        + "</div>\n"
		        + "</form>\n"
		        + "</div>\n"
		        + "<footer class=\"mt-5\">\n"
		        + "<p>Author: Nam Cuong Tran</p>\n"
		        + "<p>\n"
		        + "<a href=\"mailto:cuongntran757@gmail.com\">cuongntran757@gmail.com</a>\n"
		        + "</p>\n"
		        + "</footer>\n"
		        + "</body>\n"
		        + "</html>";


		pw.println(htmlCode);
	}

}
