package com.three;

import java.io.IOException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Three1Servlet extends HttpServlet {
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
			pusto = true;
		}

		if ((n > m) || (n < 0) || (m > 65535) || pusto) {
			resp.getWriter().print("¬ведите корректные числа!");
		} else {
			resp.getWriter().print("<table border=1, cellpadding=5>");
			for (int i = n; i <= m; i++) {
				resp.getWriter().print("<tr>");
				for (int j = 0; (j < 10) && (i <= m); j++) {
	//				resp.getWriter().println("<th>&#"+ i + "<br>"+ i+ "<br>"+ Integer.toHexString(i) + "</th>");
					resp.getWriter().println("<th>&#"+ i + "<br>"+ i+ "<br>"+ toHex(i) + "</th>");
					i++;
				}
				i--;
				resp.getWriter().print("</tr>");
			}
			resp.getWriter().print("</table>");
		}
	}
	
	public String toHex(int temp) {
		String s = "";
		while (temp > 0) {
		if (temp % 16 > 9) {
		s = (char) ((int) ('a') + temp % 16 - 10) + s;
		} else
		s = (char) ((int) ('0') + temp % 16) + s;
		temp = temp / 16;
		}
		return s;
		}
}