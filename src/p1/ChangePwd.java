package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class ChangePwd
 */
public class ChangePwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String npwd=request.getParameter("npwd");
		session=request.getSession();
		int accno =(int) session.getAttribute("accno");
		try {
			Model m=new Model();
			m.setPwd(npwd);
			m.setAccno(accno);
			boolean b=m.changePwd();
			if(b==true)
			{
				response.sendRedirect("/AbcBank/changeSuccess.jsp");
			}
			else {
				response.sendRedirect("/AbcBank/changeFail.jsp");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
