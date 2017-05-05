package junitTest;

import org.junit.Test;

import datastuctrue.impl.LinkedStack;
import datastuctrue.itf.Stack;
										//��ջAPI�����Ѿ����
public class TestStack {

	//����push������tostring����������gettotle����
	@Test
	public void test_NotException_Method(){
		Stack<String> stack = new LinkedStack<String>();
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.push("d");
		stack.push("e");
		stack.push("f");
		stack.push("g");
		System.out.println(stack.toString()+"ջ����"+stack.getTotle()+"��Ԫ��");
		
	}
	
	
	//����pop����peek����
	@Test
	public void test_Exception_Method(){
		Stack<String> stack = new LinkedStack<String>();
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.push("d");
		stack.push("e");
		stack.push("f");
		stack.push("g");
		try{
			for(int i=0;i<4;i++){
				stack.pop();
				System.out.println("��ǰջ��Ԫ��Ϊ��"+stack.getTotle()+"   ����ջ"+stack.toString());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
}
