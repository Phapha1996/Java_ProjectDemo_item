package datastuctrue.impl;

import datastuctrue.itf.Stack;
import exception.StackException;


public class LinkedStack<T> implements Stack<T> {
	
	private int count;						//ջ��Ԫ�صĸ���
	private LinerNode<T> top;				//ջ����ָ��
	
	
	public LinkedStack(){
		this.top = null;
		this.count = 0;
	}
	
	
	public void push(T elem){
		LinerNode<T> node = null;
		if(count==0){
			node = new LinerNode<T>(elem);
		}else{
			node = new LinerNode<T>(elem,top);
		}
		top = node;
		count ++;
	}
	
	
	public T pop(){
		if(count==0)
			throw new StackException();
		
		T result = top.getElement();
		top = top.getNext();
		count --;
		return result;
	}
	
	
	public String toString(){
		String result ="ջ����";
		LinerNode<T> index = top;
		int count = this.count;
		while(count!=0){
			result += index.getElement()+"  ";
			index = index.getNext();
			count --;
		}
		result += "ջ��";
		
		return result;
	}
	
	
	public T peek(){
		if(count==0)
			throw new StackException();
		
		return top.getElement();
	}
	
	
	public int getTotle(){
		return count;
	}

	
	public boolean isEmpty(){
		if(count!=0)
			return false;
		else
			return true;
	}
}
