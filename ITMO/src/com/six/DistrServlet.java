package com.six;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class DistrServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
	
		try {
			//TODO URL url = new URL("http://localhost:8888/csv/districts.csv");
			URL url = new URL ("http://tapro-first-project.appspot.com/csv/districts.csv");
			

			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
			
			String line;
			
			resp.getWriter().println("<table border=1 cellspacing=0 cellpadding=5><tr><td>Название района</td><td>ОКАТО</td><td>Код района</td></tr>");

			for (int i = 0; (line = reader.readLine()) != null; i++) {
				if (i > 0) {
					String[] values = line.split(",");
					resp.getWriter().println("<tr><td><a href='/cemet?okato="+values[1]+"'>"+values[0]+"</a></td><td>"+values[1]+"</td><td>"+values[2]+"</td>");
				}
			}
			reader.close();

		} catch (IOException e) {
			resp.getWriter().println("Не могу прочитать файл районов.");
		}		
		
	}
}

