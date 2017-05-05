package web.controller;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import first_question.QuestionUtils;
import service.BusinessService;

public class MakeQuestionServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String quenum = request.getParameter("quenum");			//����������Ŀ����������
		String stuname = request.getParameter("stuname");
	
		//����������д���ļ�
		File file = new File("d:/student.txt");
		FileWriter fw = new FileWriter(file,true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("����������"+stuname);
		bw.newLine();
		bw.newLine();
		bw.flush();
		bw.close();
		
		
		BusinessService bs = new BusinessService();
		List<QuestionUtils> list = bs.getQuestion(Integer.parseInt(quenum));
		double[] result =  bs.getResult();//
		HttpSession session= request.getSession();
		session.setAttribute("list", list);					//��session�����ȥ
		session.setAttribute("result", result);
		request.getRequestDispatcher("/WEB-INF/jsp/question.jsp").forward(request, response);
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			doGet(request, response);
		
	}

}
