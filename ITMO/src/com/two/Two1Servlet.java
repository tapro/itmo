package com.two;

import java.io.IOException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Two1Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		double n = 0, m = 0;
		boolean corr = true;
		try {
			n = Double.parseDouble(req.getParameter("N"));
			m = Double.parseDouble(req.getParameter("M"));
		} catch (NumberFormatException e) {

			corr = false;
		}
		if (corr) {
			if (Math.abs(n - 10) > Math.abs(m - 10)) {
				resp.getWriter().println("Ближайшее к десяти число: " + m);
			} else if (Math.abs(n - 10) < Math.abs(m - 10)) {
				resp.getWriter().println("Ближайшее к десяти число: " + n);
			} else {
				resp.getWriter().println(n + " и " + m + " одинаково близки к десяти");
			}
		}
		else {
			resp.getWriter().println("Введите корректные числа");			
		}
	}
}