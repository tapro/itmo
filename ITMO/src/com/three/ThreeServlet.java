package com.three;

import java.io.IOException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ThreeServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		int n = 0;
		int m = 0;
		boolean pusto = false;
		try {
			n = Integer.parseInt(req.getParameter("N"), 10);
			m = Integer.parseInt(req.getParameter("M"), 10);
		} catch (NumberFormatException e) {
			resp.getWriter().println("You are bad!");
			pusto = true;
		}

		if ((n > m) || (n < 0) || (m > 65535) || pusto) {
			resp.getWriter().print("You are wrong!");
		} else {
			resp.getWriter().print("<table border=1>");
			for (int i = n; i <= m; i++) {
				resp.getWriter().print("<tr>");
				for (int j = 0; (j < 10) && (i <= m); j++) {
					resp.getWriter().println("<th>&#"+ i + "</th>");
					i++;
				}
				i--;
				resp.getWriter().print("</tr>");
			}
			resp.getWriter().print("</table>");
		}
	}
}