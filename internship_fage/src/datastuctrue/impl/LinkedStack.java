package datastuctrue.impl;

import datastuctrue.itf.Stack;
import exception.StackException;


public class LinkedStack<T> implements Stack<T> {
	
	private int count;						//栈中元素的个数
	private LinerNode<T> top;				//栈顶的指针
	
	
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
		String result ="栈顶：";
		LinerNode<T> index = top;
		int count = this.count;
		while(count!=0){
			result += index.getElement()+"  ";
			index = index.getNext();
			count --;
		}
		result += "栈底";
		
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
