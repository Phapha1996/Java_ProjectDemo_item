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

public class DoQuestionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		double[] result =  (double[]) session.getAttribute("result");
		List list = (List) session.getAttribute("list");
		
		int trueq = 0;
		int falseq = 0;
		
		
		File file = new File("d:/student.txt");				//��������д���ĵ�
		FileWriter fw = new FileWriter(file,true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		String str = "";									//�������д𰸵��ַ���
		
		for(int i=0;i<list.size();i++){
			String r = request.getParameter(String.valueOf(i));
			str += r + "  ";									
			if(Double.parseDouble(r)!=result[i]){
				falseq ++;
			}else{
				trueq ++;
			}
		}
		
		
		bw.write("�����Ĵ𰸣�"+str+"����������"+String.valueOf(trueq)+"��"+"������"+String.valueOf(falseq)+"�⡣");
		bw.newLine();
		bw.flush();
		bw.close();
		
		request.setAttribute("trueq", trueq);
		request.setAttribute("falseq", falseq);
		
		request.getRequestDispatcher("/WEB-INF/jsp/answer.jsp").forward(request, response);
		
		return;
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		
	}

}
