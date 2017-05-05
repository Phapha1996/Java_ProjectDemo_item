package first_question;

import java.io.File;
import java.util.Random;

import org.junit.Test;

import datastuctrue.impl.LinkedStack;
import datastuctrue.itf.Stack;

public class QuestionUtils {


	private double resultq;				//显示给用户看的保存得出计算结果的变量
	private String question;			//显示给用户看的问题
	
	
	private char [] makeq;				//保存产生问题的字符数组（面向对象的核心）
	private Stack<Character> s;			//操作中缀表达式转换后缀表达式的栈
	private Stack<Double> integ;		//处理后缀表达式进行计算的栈
	private StringBuffer trans;			//中缀表达式转换成后缀表达式的变量
	
	
	public QuestionUtils() {
		trans = new StringBuffer();
		s = new LinkedStack<Character>();
		integ = new LinkedStack<Double>();
		resultq = 0;
		question = null;
	}
	


	//随机产生出带括号的问题
	public void makePairQuestion(){
		String str = makeQuestion();					//先产生不带括号的问题
		char[] c = str.toCharArray();	
		char []resultarray = new char[c.length+2];
		
		char [] que = new char[makeq.length+2];		//真正要保存的后台数组
		
		for(int i=0;i<makeq.length;i++){			//数组复制
			que[i] = makeq[i];
			resultarray[i] = c[i];
		}
		
		int index1 = (int)(Math.random()*(makeq.length-3));		//左括号的位置调整，随机数的意义在于新数组的位置，控制在0-makeq.leng-1号元素位置
		if(index1%2!=0){
			index1 ++;								//如果得到的随机数不是偶号位，那我就让你变成偶号位
		}
		
		//for(int i=index;i<result.length;i++)
		for(int i=que.length-1;i>index1;i--){
			que[i] = que[i-1];
			resultarray[i] = resultarray[i-1];
		}
		que[index1] = '(';
		resultarray[index1] = '(';
		
		//1+(2+3+4+5+6=
		int index2 = index1 + (int) (Math.random()*(makeq.length-index1-3+1))+3;			//右括号的位置调整+1的原因是数组变之后多加了个“（”元素，所以必须要+1，选择3的原因是控制它至少不会一对括号只扩起了一个数字
		if(index2%2!=0){
			index2 ++;							//如果随机数产生的位置不是偶号位，那我就让你变成偶号位
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
	
	
	
	//中专表达式转换后缀表达式的方法
	public void transInto(){
		for(int i=0;i<makeq.length;i++){
			transChild(makeq[i]);
		}
	}
	
	
	
	
	//中缀表达式转换为后缀表达式的子方法
	private void transChild(char c){	
		switch(c){
		//当符号为+时，栈空就入栈，否则只要栈顶元素不为*/就入栈，如果为栈顶*/，就把栈中所有除了）的符号弹出来，在入栈
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
		
		//减号同理加号，此处代码可以重构
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
		//乘法除法（都是直接入栈
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
		//发现当前元素为）时，弹出栈中元素，直到栈中有）为止，最后在把）弹出来！
		case ')':{
			while(s.peek()!='('){
				trans.append(s.peek());
				s.pop();
			}
			s.pop();				//把括号退出来
			break;
		}
		//当元素为=号的时候，代表整个式子已经结束，直接弹出栈中所有元素
		case '=':{
			while(!s.isEmpty()){
				trans.append(s.peek());
				s.pop();
			}
			break;
		}
		//如果仅仅是数字，直接入stringbufferd中
		default:{
			trans.append(c);
			break;
		}
			
		}
		
	}
	
	
	//处理问题得出结果
	public double doQuestion(){
		String str = trans.toString();
		char[] c = str.toCharArray();			//把得到的后缀表达式转化成字符数组
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
		
		int index = 2+(int)(Math.random()*8);			//随机产生加数的个数,控制其最少也要有两个数做计算,最多为10个
		makeq = new char[2*index];						//由于符号与加数个数再加上一个等号，恰好是随机数index个数的两倍
		String result = "";								//result用于显示给用户看
		
		int value1 = 1+(int)(Math.random()*8);			//进行第一轮的赋值,控制不能出现0，偷懒防止抛分母为0的异常
		makeq[0] = (char) value1;
		result += value1;
		
		for(int i=2;i<2*index-1;i=i+2){
			
				int choice = (int) (Math.random()*100);					//进行符号的插入
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
			
		int value2 =  1+(int)(Math.random()*8);							//进循环的赋值
		makeq[i] = (char) value2;					//这一轮赋值的是能计算的
		result += value2;							//这一轮转的是能显示的
		
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
