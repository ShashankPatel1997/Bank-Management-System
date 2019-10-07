package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cusid=request.getParameter("custid"); 
		String pwd=request.getParameter("pwd");
		session = request.getSession(true);
		
		try {
		Model m=new Model();
		m.setCusid(cusid);
		m.setPwd(pwd);
		boolean b=m.login();
		
		if(b==true)
		{
			
			session.setAttribute("name", m.getName());
			session.setAttribute("accno", m.getAccno());
			session.setAttribute("customer", m.getCustomer());
			session.setAttribute("deposit", m.getDeposit());
			session.setAttribute("transaction", m.getTransaction());
			// set your String value in the attribute
			response.sendRedirect("/AbcBank/home.jsp");
		}
		else
		{
			response.sendRedirect("/AbcBank/loginFailed.jsp");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
