package p1;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class ChangeNewPwdFilter
 */
public class ChangeNewPwdFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ChangeNewPwdFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String npwd=request.getParameter("npwd");
		String cpwd=request.getParameter("cpwd");
		if(npwd.equals(cpwd))
		{
		chain.doFilter(request, response);
		}
		else {
			((HttpServletResponse) response).sendRedirect("/AbcBank/changeNewFail.html");
	
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
