package junitTest;

import org.junit.Test;

import datastuctrue.impl.LinkedStack;
import datastuctrue.itf.Stack;
										//堆栈API测试已经完成
public class TestStack {

	//测试push方法，tostring方法，还有gettotle方法
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
		System.out.println(stack.toString()+"栈中有"+stack.getTotle()+"个元素");
		
	}
	
	
	//测试pop还有peek方法
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
				System.out.println("当前栈顶元素为："+stack.getTotle()+"   遍历栈"+stack.toString());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
}
