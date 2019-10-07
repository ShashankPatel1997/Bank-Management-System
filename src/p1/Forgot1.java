package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Forgot1
 */
public class Forgot1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forgot1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession();
		String email=(String) session.getAttribute("email");
		String npwd=request.getParameter("npwd");
		try {
			Model m=new Model();
			m.setEmail(email);
			m.setPwd(npwd);
			boolean b=m.forgotpwd();
			if(b==true)
			{
				response.sendRedirect("/AbcBank/successNewPass.html");
			}
			else {
			response.sendRedirect("/AbcBank/errorNewPass.html");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
