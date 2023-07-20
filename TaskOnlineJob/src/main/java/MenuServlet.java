

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		        "        <li><a href=\"Page.html\">Home</a></li>\n" +
		        "        <li><a href=\"https://github.com/namcuong757?tab=repositories\">About</a></li>\n" +
		        "        <li><a href=\"https://www.linkedin.com/in/nam-cuong-tran-7425a1224/\">Contact</a></li>\n" +
		        "    </ul>\n" +
		        "</nav>\n" +
		        "</header>";

		pw.println("<html><body>");
		pw.println("<link rel=\"stylesheet\" href=\"style.css\">");
		pw.println(headerString);
		pw.println("<h2>MENU</h2>");
		pw.println("<table>");
		pw.println("<form method='post' action='RetrieveAllServlet'>");
		pw.println("<tr><td><input type='submit' value='Print All'></td></tr>");
		pw.println("</form>");
		pw.println("<form method='post' action='RetrieveSingle'>");
		pw.println("<tr><td><input type='submit' value='Print'></td></tr>");
		pw.println("</form>");
		pw.println("<form method='post' action='DeleteServlet'>");
		pw.println("<tr><td><input type='submit' value='Delete'></td></tr>");
		pw.println("</form>");
		pw.println("<form method='post' action='UpdateServlet'>");
		pw.println("<tr><td><input type='submit' value='Update'></td></tr>");
		pw.println("</form>");
		
		pw.println("</table>");
		pw.println(footerString);
		pw.println("</body></html>");
	}

}
