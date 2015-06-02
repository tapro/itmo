package com.five;

import java.io.IOException;
import java.text.ParseException;
import com.five.TaproException;

import com.five.Queswers;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class WordGameServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		int act = Integer.parseInt(req.getParameter("action"));
		int indexMas=-1;
		Queswers[] mas = new Queswers[5];
		Queswers zero = new Queswers();
		Queswers one = new Queswers();
		Queswers two = new Queswers();
		Queswers three = new Queswers();
		Queswers four = new Queswers();
		mas[0]=zero;
		zero.quest="��� ��������� �� ��� ������?";
		zero.ansStr="�����";
		mas[1]=one;
		one.quest="���� �������� ������?";
		one.ansData="22.04.1870";
		mas[2]=two;
		two.quest="������� � ������� ��� � ����?";
		two.ansNum=0;
		mas[3]=three;
		three.quest="��� ����� ��� ������?";
		three.ansStr="Winsent";
		mas[4]=four;
		four.quest="������� ������� � ����?";
		four.ansNum=12;
		
		if(act==1)
		{
			indexMas = ((int)(Math.floor(Math.random()*5)));
			resp.getWriter().println("<br>"+mas[indexMas].quest+"<br> <input type =\"hidden\" id =\"elNum\" value=" +indexMas+ ">");
		}
		else{
			try{
				checkAnswerF(mas, req.getParameter("answer"), Integer.parseInt(req.getParameter("vopros")),resp);
			}
			catch(TaproException e) {
				resp.getWriter().println(e.getMessage());
			}
			catch(ParseException e) {
				resp.getWriter().println("���� ������ ��.��.����");
			}
			catch(NumberFormatException e) {
				resp.getWriter().println("����� ������ ����� �����");
			}
		}
	}
	
	public static void checkAnswerF(Queswers[] q, String ua, int i,HttpServletResponse resp) throws IOException, TaproException, ParseException, NumberFormatException {
		int indexMas=i;
		boolean valid = q[indexMas].checkStr(ua);
		if (valid)resp.getWriter().println("<br>�� �����");
		else resp.getWriter().println("<br>��� �� ���");
	}	
}