package datastuctrue.itf;



public interface Stack<T> {

	//入栈
	public void push(T t);
	
	//出栈
	public T pop();
	
	//非法遍历
	public String toString();
	
	//得到栈顶元素
	public T peek();
	
	//返回栈中拥有元素的个数
	public int getTotle();
	
	//判断栈空
	public boolean isEmpty();
	
}
