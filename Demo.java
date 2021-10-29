import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Demo extends HttpServlet
{
	Connection con;
	PreparedStatement st;
			
	public void service(HttpServletRequest hreq , HttpServletResponse hresp) throws ServletException,IOException
	{
		PrintWriter out=hresp.getWriter();
		try{

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","root");
				
				st = con.prepareStatement("insert into register values(?,?,?,?,?)");
			    
				String str1 = hreq.getParameter("Name");
			   
				String str2 = hreq.getParameter("Pwd");
        String str3 = hreq.getParameter("Hno");   
				
				String str4 = hreq.getParameter("Dept");   
				
				String str5 = hreq.getParameter("Pno");   				
				
				st.setString(1,str1);
			    
				st.setString(2,str2);
				
				st.setString(3,str3);
				
				st.setString(4,str4);
				
				st.setString(5,str5);

			    int i = st.executeUpdate();
				
				con.close();
				
				out.println("Data Inserted Successfully");
				
  		    }catch(Exception exc)
			{
				out.println(exc);
			}
	}
}
