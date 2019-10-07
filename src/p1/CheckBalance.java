package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class CheckBalance
 */
public class CheckBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckBalance() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		session=request.getSession();
    	int accno=(int) session.getAttribute("accno");
    	try {
    		Model m=new Model();
    		m.setAccno(accno);
    		
    		boolean b=m.checkBalance();
    		if(b==true)
    		{
    			
    			session.setAttribute("balance" ,m.getBalance());
    			response.sendRedirect("/AbcBank/checkBalanceSuccess.jsp");
    		}
    		else
    		response.sendRedirect("/AbcBank/checkBalanceFail.jsp");
    	}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
	}

}
