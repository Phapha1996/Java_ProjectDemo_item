package service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import first_question.QuestionUtils;

public class BusinessService {
	
	double[] result = null;
	
	public List getQuestion(int quenum){			//�������⣬�����Ϊ�������Ŀ
		List<QuestionUtils> list = new LinkedList<QuestionUtils>();
		result = new double[quenum];
		for(int i=0;i<quenum;i++){
			QuestionUtils qu = new QuestionUtils();
			qu.makePairQuestion();					//��������
			qu.transInto();							//��������
			result[i] = (int) qu.doQuestion();						//�������
			list.add(qu);							//�ѵ�ǰ������󱣴浽list������
					
		}
		
		doIO(list);
		
		return list;
	}
	
	
	private void doIO(List list) {
		
		try{
			File file = new File("d:/student.txt");
			FileWriter fw = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			Iterator<QuestionUtils> it = list.iterator();		//ʹ�õ����������������ļ���
			while(it.hasNext()){
				QuestionUtils q = it.next();
				bw.write(q.getQuestion());
				bw.write(String.valueOf(q.getResultq()));
				bw.newLine();		//�Ӹ����кÿ�һ��
				bw.newLine();
				
			}
				
			bw.flush();
			bw.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
			
	}


	public double[] getResult(){					//�õ����
		return result;
	}
	
	
}
