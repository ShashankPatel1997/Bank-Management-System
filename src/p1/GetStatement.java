package p1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class GetStatement
 */
public class GetStatement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetStatement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		session=request.getSession();
		int accno=(int)session.getAttribute("accno");
		
		try {
			Model m=new Model();
			m.setAccno(accno);
			ArrayList al=m.getStatement();
			
			if(al.isEmpty()!=true)
			{
				session.setAttribute("al1", m.al1);
				session.setAttribute("al2", m.al2);
				response.sendRedirect("/AbcBank/getStatementSuccess.jsp");
			}
			else {
				response.sendRedirect("/AbcBank/getStatementFail.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	}