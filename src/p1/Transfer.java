package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Transfer
 */
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transfer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accn = request.getParameter("accno1");
		Integer i=Integer.parseInt(accn);
		int accno1=i.intValue();
		String amo = request.getParameter("amount");
		Integer j=Integer.parseInt(amo);
		int amount1=j.intValue();
		session=request.getSession();
		int accno=(int) session.getAttribute("accno");
		try {
			Model m=new Model();
			m.setAccno(accno);
			m.setAccno1(accno1);
			m.setBalance(amount1);
			boolean b=m.transfer();
			
			if(b==true)
			{
				session.setAttribute("amount" ,amount1);
				session.setAttribute("transaction" ,m.getTransaction());
				response.sendRedirect("/AbcBank/transferSuccess.jsp");
			}
			else
				response.sendRedirect("/AbcBank/transferFail.jsp");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
