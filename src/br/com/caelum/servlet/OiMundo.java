package br.com.caelum.servlet;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;

public class OiMundo extends HttpServlet {
	
	@Override
	protected void service(javax.servlet.http.HttpServletRequest arg0, javax.servlet.http.HttpServletResponse arg1) throws javax.servlet.ServletException ,java.io.IOException {
		PrintWriter out = arg1.getWriter();
		
		out.println("<html>");
        out.println("<head>");
        out.println("<title>Primeira Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Oi mundo Servlet!</h1>");
        out.println("</body>");
        out.println("</html>");
		
	};
}
	