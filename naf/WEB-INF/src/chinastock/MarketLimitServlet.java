package chinastock;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarketLimitServlet extends HttpServlet {

	/* 
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);
		
		
	}

	/* 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MarketLimitReport pageReport=new MarketLimitReport();		
		ReportItem item=pageReport.getReportItem();	
		
		request.setAttribute("marketlimit", item);		
		RequestDispatcher view = request.getRequestDispatcher("marketlimit.jsp");
        view.forward(request, response);	
	}
	
	

}
