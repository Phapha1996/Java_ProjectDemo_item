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
	
	public List getQuestion(int quenum){			//产生问题，输入的为问题的数目
		List<QuestionUtils> list = new LinkedList<QuestionUtils>();
		result = new double[quenum];
		for(int i=0;i<quenum;i++){
			QuestionUtils qu = new QuestionUtils();
			qu.makePairQuestion();					//产生问题
			qu.transInto();							//翻译问题
			result[i] = (int) qu.doQuestion();						//解决问题
			list.add(qu);							//把当前问题对象保存到list集合中
					
		}
		
		doIO(list);
		
		return list;
	}
	
	
	private void doIO(List list) {
		
		try{
			File file = new File("d:/student.txt");
			FileWriter fw = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			Iterator<QuestionUtils> it = list.iterator();		//使用迭代器迭代问题对象的集合
			while(it.hasNext()){
				QuestionUtils q = it.next();
				bw.write(q.getQuestion());
				bw.write(String.valueOf(q.getResultq()));
				bw.newLine();		//加个空行好看一点
				bw.newLine();
				
			}
				
			bw.flush();
			bw.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
			
	}


	public double[] getResult(){					//得到结果
		return result;
	}
	
	
}
