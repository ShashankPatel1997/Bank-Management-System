package p1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Loan
 */
public class Loan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
    			session.setAttribute("name" ,m.getName());
    			session.setAttribute("email" ,m.getEmail());
    			RequestDispatcher rd= request.getRequestDispatcher("LoanMail");
    			rd.forward(request, response);
    		}
    		else
    		response.sendRedirect("/AbcBank/loanFail.jsp");
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
