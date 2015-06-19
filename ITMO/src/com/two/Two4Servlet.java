package com.two;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Two4Servlet extends HttpServlet implements Servlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		int[][] mas = new int[5][8];
		resp.getWriter().println("<table border=1");
		for(int i=0;i<5;i++)
		{
			resp.getWriter().print("<tr>");
			for(int j=0;j<8;j++)
			{
				mas[i][j] = ((int)(Math.floor(Math.random()*199)-99));
				resp.getWriter().print("<th>"+ mas[i][j] + "</th>");
			}
			resp.getWriter().print("</tr>");
		}
			
		int min,max;
		max = mas[0][0];
		min = mas[0][0];
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(min>mas[i][j])
					min=mas[i][j];
				if(max<mas[i][j])
					max=mas[i][j];
			}
		}
		resp.getWriter().print("<tr><th colspan=8>Максимум: "+ max + "<br>Минимум: " + min + "</th></tr>");
		resp.getWriter().println("</table>");
	}

}
