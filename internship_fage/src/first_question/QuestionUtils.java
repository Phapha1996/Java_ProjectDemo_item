package first_question;

import java.io.File;
import java.util.Random;

import org.junit.Test;

import datastuctrue.impl.LinkedStack;
import datastuctrue.itf.Stack;

public class QuestionUtils {


	private double resultq;				//��ʾ���û����ı���ó��������ı���
	private String question;			//��ʾ���û���������
	
	
	private char [] makeq;				//�������������ַ����飨�������ĺ��ģ�
	private Stack<Character> s;			//������׺���ʽת����׺���ʽ��ջ
	private Stack<Double> integ;		//�����׺���ʽ���м����ջ
	private StringBuffer trans;			//��׺���ʽת���ɺ�׺���ʽ�ı���
	
	
	public QuestionUtils() {
		trans = new StringBuffer();
		s = new LinkedStack<Character>();
		integ = new LinkedStack<Double>();
		resultq = 0;
		question = null;
	}
	


	//��������������ŵ�����
	public void makePairQuestion(){
		String str = makeQuestion();					//�Ȳ����������ŵ�����
		char[] c = str.toCharArray();	
		char []resultarray = new char[c.length+2];
		
		char [] que = new char[makeq.length+2];		//����Ҫ����ĺ�̨����
		
		for(int i=0;i<makeq.length;i++){			//���鸴��
			que[i] = makeq[i];
			resultarray[i] = c[i];
		}
		
		int index1 = (int)(Math.random()*(makeq.length-3));		//�����ŵ�λ�õ���������������������������λ�ã�������0-makeq.leng-1��Ԫ��λ��
		if(index1%2!=0){
			index1 ++;								//����õ������������ż��λ�����Ҿ�������ż��λ
		}
		
		//for(int i=index;i<result.length;i++)
		for(int i=que.length-1;i>index1;i--){
			que[i] = que[i-1];
			resultarray[i] = resultarray[i-1];
		}
		que[index1] = '(';
		resultarray[index1] = '(';
		
		//1+(2+3+4+5+6=
		int index2 = index1 + (int) (Math.random()*(makeq.length-index1-3+1))+3;			//�����ŵ�λ�õ���+1��ԭ���������֮�����˸�������Ԫ�أ����Ա���Ҫ+1��ѡ��3��ԭ���ǿ��������ٲ���һ������ֻ������һ������
		if(index2%2!=0){
			index2 ++;							//��������������λ�ò���ż��λ�����Ҿ�������ż��λ
		}
		
		for(int i=que.length-1;i>index2;i--){
			que[i] = que[i-1];
			resultarray[i] = resultarray[i-1];
		}
		
		que[index2] = ')';
		resultarray[index2] = ')';
		
		question = String.valueOf(resultarray);
		makeq = que;
	}
	
	
	
	//��ר���ʽת����׺���ʽ�ķ���
	public void transInto(){
		for(int i=0;i<makeq.length;i++){
			transChild(makeq[i]);
		}
	}
	
	
	
	
	//��׺���ʽת��Ϊ��׺���ʽ���ӷ���
	private void transChild(char c){	
		switch(c){
		//������Ϊ+ʱ��ջ�վ���ջ������ֻҪջ��Ԫ�ز�Ϊ*/����ջ�����Ϊջ��*/���Ͱ�ջ�����г��ˣ��ķ��ŵ�����������ջ
		case '+':{
			if(s.isEmpty()||s.peek()!='*'&&s.peek()!='/'&&s.peek()!='-'&&s.peek()!='+'){
				s.push(c);
			}else{
				while(!s.isEmpty()&&s.peek()!='('){
					trans.append(s.peek());
					s.pop();
				}
				s.push(c);
			  }
			
			break;
		}
		
		//����ͬ��Ӻţ��˴���������ع�
		case '-':{
				
			if(s.isEmpty()||s.peek()!='*'&&s.peek()!='/'&&s.peek()!='-'&&s.peek()!='+'){
				s.push(c);
			}else{
				while(!s.isEmpty()&&s.peek()!='('){
					trans.append(s.peek());
					s.pop();
				}
				s.push(c);
			  }
			break;
		}
		//�˷�����������ֱ����ջ
		case '*':{
				if(s.isEmpty()||s.peek()!='*'&&s.peek()!='/'){
					s.push(c);
				}else{
					while(!s.isEmpty()&&s.peek()!='('&&s.peek()!='+'&&s.peek()!='-'){
						trans.append(s.peek());
						s.pop();
					}
					s.push(c);
					
				}
			break;
			
		}
		case '/':{
			if(s.isEmpty()||s.peek()!='*'&&s.peek()!='/'){
				s.push(c);
			}else{
				while(!s.isEmpty()&&s.peek()!='('&&s.peek()!='+'&&s.peek()!='-'){
					trans.append(s.peek());
					s.pop();
				}
				s.push(c);
				
			}
			break;
		}
		case '(':{
			s.push(c);
			break;
		}
		//���ֵ�ǰԪ��Ϊ��ʱ������ջ��Ԫ�أ�ֱ��ջ���У�Ϊֹ������ڰѣ���������
		case ')':{
			while(s.peek()!='('){
				trans.append(s.peek());
				s.pop();
			}
			s.pop();				//�������˳���
			break;
		}
		//��Ԫ��Ϊ=�ŵ�ʱ�򣬴�������ʽ���Ѿ�������ֱ�ӵ���ջ������Ԫ��
		case '=':{
			while(!s.isEmpty()){
				trans.append(s.peek());
				s.pop();
			}
			break;
		}
		//������������֣�ֱ����stringbufferd��
		default:{
			trans.append(c);
			break;
		}
			
		}
		
	}
	
	
	//��������ó����
	public double doQuestion(){
		String str = trans.toString();
		char[] c = str.toCharArray();			//�ѵõ��ĺ�׺���ʽת�����ַ�����
		double first;
		double second;
		for(int i=0;i<c.length;i++){
			switch(c[i]){
			case '+':{
				first = integ.pop();
				second = integ.pop();
				integ.push(second+first);
				break;
			}
			case '-':{
				first =  integ.pop();
				second = integ.pop();
				integ.push(second-first);
				break;
			}
			case '*':{
				first = integ.pop();
				second = integ.pop();
				integ.push(second*first);
				break;
			}
			case '/':{
				first = integ.pop();
				second = integ.pop();
				integ.push(second/first);
				break;
			}
			default:{
					integ.push((double)c[i]);
					break;
				}
			}
		}
		
		
		this.resultq = integ.peek();
		return integ.pop();
	}
	
	
	
private String makeQuestion(){		
		
		int index = 2+(int)(Math.random()*8);			//������������ĸ���,����������ҲҪ��������������,���Ϊ10��
		makeq = new char[2*index];						//���ڷ�������������ټ���һ���Ⱥţ�ǡ���������index����������
		String result = "";								//result������ʾ���û���
		
		int value1 = 1+(int)(Math.random()*8);			//���е�һ�ֵĸ�ֵ,���Ʋ��ܳ���0��͵����ֹ�׷�ĸΪ0���쳣
		makeq[0] = (char) value1;
		result += value1;
		
		for(int i=2;i<2*index-1;i=i+2){
			
				int choice = (int) (Math.random()*100);					//���з��ŵĲ���
				if(choice<25){
					makeq[i-1] = '-';
					result += "-";
				}else if(choice>=25&&choice<50){
					makeq[i-1] = '+';
					result += "+";
				}else if(choice>=50&&choice<75){
					makeq[i-1] = '*';
					result += "*";
				}else if(choice>=75&&choice<100){
					makeq[i-1] = '/';
					result += "/";
				}
			
		int value2 =  1+(int)(Math.random()*8);							//��ѭ���ĸ�ֵ
		makeq[i] = (char) value2;					//��һ�ָ�ֵ�����ܼ����
		result += value2;							//��һ��ת��������ʾ��
		
		}
		makeq[2*index-1] = '=';
		result += "=";
		
		return result;
	}
	
	




	public double getResultq() {
		return resultq;
	}



	public void setResultq(double resultq) {
		this.resultq = resultq;
	}



	public String getQuestion() {
		return question;
	}



	public void setQuestion(String question) {
		this.question = question;
	}

	
	
}
