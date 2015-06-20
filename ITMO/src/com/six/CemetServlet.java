package com.six;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class CemetServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().println("<HTML>");
		resp.getWriter().println("<HEAD><TITLE>CSV</TITLE></HEAD><link rel='stylesheet' type='text/css' href='../css/myStyles.css'>");
		resp.getWriter().println("<BODY><table>");
	
		Integer okato = Integer.parseInt(req.getParameter("okato"));

		ArrayList<District> districts = new ArrayList<District>();
		ArrayList<Cemetery> cemeterys = new ArrayList<Cemetery>();
		ArrayList<Hospital> hospitals = new ArrayList<Hospital>();

		District dist0 = new District();
		dist0.setTitle("Неизвестный");
		dist0.setOkato(0);
		dist0.setCode(0);
		districts.add(dist0);

		try {
			// TODO 
	//		URL url = new URL("http://localhost:8888/csv/districts.csv");
			URL url = new URL("http://tapro-first-project.appspot.com/csv/districts.csv");

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					url.openStream(), "UTF-8"));

			String line;

			for (int i = 0; (line = reader.readLine()) != null; i++) {
				if (i > 0) {
					String[] values = line.split(",");
					District dist = new District();
					dist.setTitle(values[0]);
					dist.setOkato(Integer.parseInt(values[1]));
					dist.setCode(Integer.parseInt(values[2]));
					districts.add(dist);
				}
			}
			reader.close();

		} catch (IOException e) {
			resp.getWriter().println("Не могу прочитать файл районов.");
		}

		if (!districts.isEmpty()) {
			try {
				// TODO
			//	URL url = new URL("http://localhost:8888/csv/cemeterys.csv");
				URL url = new URL("http://tapro-first-project.appspot.com/csv/cemeterys.csv");

				BufferedReader reader = new BufferedReader(
						new InputStreamReader(url.openStream(), "UTF-8"));

				CSVReader csv = new CSVReader(reader);
				List<String[]> rows = csv.readAll();

				for (String[] row : rows) {

					Cemetery cemet = new Cemetery();
					cemet.setTitle(row[1]);
					cemet.setAddress(row[2]);
					cemet.setHours(row[7]);
					cemet.setComment(row[8]);
					cemet.setDistrict(Utils.getDistrictByName(districts, row[3]));
					cemeterys.add(cemet);

				}
				reader.close();
			} catch (IOException e) {
				resp.getWriter().println("Не могу прочитать файл кладбищ.");
			}
			try {
				URL url2 = new URL("http://tapro-first-project.appspot.com/csv/hospitals.csv");

				BufferedReader reader2 = new BufferedReader(
						new InputStreamReader(url2.openStream(), "UTF-8"));

				CSVReader csv2 = new CSVReader(reader2);
				List<String[]> rows2 = csv2.readAll();

				for (String[] row : rows2) {

					Hospital hosp = new Hospital();
					hosp.setTitle(row[8]);
					hosp.setType(row[1]);
					hosp.setAddress(row[2]);
					hosp.setDistrict(Utils.getDistrictByName(districts, row[3]));
					hospitals.add(hosp);
					}
				reader2.close();
				} catch (IOException e) {
					resp.getWriter().println("Не могу прочитать файл лечебно-профилактических учреждений.");
			}
			
			if (!cemeterys.isEmpty()) {
				resp.getWriter().println("<tr><th  height="+"100px><h1><font color=#1946ba>"+Utils.getDistrictNameByOkato(districts, okato)+" район</font></h1></th></tr>");
				int tab = 0;

				for (Cemetery cemet : cemeterys) {
					if (okato.equals(cemet.getDistrict().getOkato())) {
						if(tab==0){
							resp.getWriter().println("<tr><td  valign=top><font color=#ec0b43>В данном районе участки земли для погребения предоставляются на следующих кладбищах:</font>");
							resp.getWriter().println("<table class=s border=1 cellspacing=0 cellpadding=5><tr style=max-height:100px;><td><b>Название</b></td><td><b>Адрес</b></td><td><b>Режим работы</b></td><td><b>Примечание</b></td></tr>");
							tab++;
						}
						resp.getWriter().println("<tr><td>" + cemet.getTitle()
								+ "</td><td>" + cemet.getAddress()
								+ "</td><td>" + cemet.getHours()
								+ "</td><td>" + cemet.getComment()
								+ "</td></tr>");
					}
				}
				if(tab==0){
					resp.getWriter().println("<tr><td  valign=top><font color=#ec0b43>В данном районе участки земли для погребения не предоставляются</font>");
				}
				else {
					resp.getWriter().println("</td></tr></table>");
				}
			}

			
			if (!hospitals.isEmpty()) {
				
				int tab = 0;
				
				for (Hospital hosp : hospitals) {
					if (okato.equals(hosp.getDistrict().getOkato())) {
						if(tab==0){
							resp.getWriter().println("<tr><td valign=top><font color=#ec0b43>Если вам ещё рано умирать, загляните в одно из лечебно-профилактических учреждений данного района:</font>");
							resp.getWriter().println("<table class=s border=1 cellspacing=0 cellpadding=5><tr style=max-height:100px;><td><b>Название</b></td><td><b>Тип</b></td><td><b>Адрес</b></td>");
							tab++;
						}
						resp.getWriter().println("<tr><td>" + hosp.getTitle()
								+ "</td><td>" + hosp.getType()
								+ "</td><td>" + hosp.getAddress()
								+ "</td></tr>");
					}
				}
				
				if(tab==0){
					resp.getWriter().println("<tr><td  valign=top><font color=#ec0b43>Лечебно-профилактические учреждения, принадлежащие данному району (и только ему!) не найдены</font>");
				}
				else {
					resp.getWriter().println("</td></tr></table>");
				}
				
				resp.getWriter().println("<tr><td height=30px align=center><a href=homework/six.html><fontcolor=#1946ba>Назад</font></a></td></tr>");
				resp.getWriter().println("<tr><td height=30px align=center><a href=../index.html><fontcolor=#1946ba>На главную</font></a></td></tr>");
				resp.getWriter().println("</td></tr></table></BODY></HTML>");
			}

		}
	}
}
