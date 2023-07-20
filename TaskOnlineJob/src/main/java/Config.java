
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config implements ConfigInterface{
	@Override
	public Connection config()
	{
		Connection con = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/testDB?useSSL=false";
			con = DriverManager.getConnection(url, "root", "password123");
			if(con == null)
			{
				System.out.println("Connection Failed");
			}
			else
			{
				System.out.println("Database MySQL connected");
			}
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
