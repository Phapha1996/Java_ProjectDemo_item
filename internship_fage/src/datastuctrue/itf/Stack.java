package datastuctrue.itf;



public interface Stack<T> {

	//��ջ
	public void push(T t);
	
	//��ջ
	public T pop();
	
	//�Ƿ�����
	public String toString();
	
	//�õ�ջ��Ԫ��
	public T peek();
	
	//����ջ��ӵ��Ԫ�صĸ���
	public int getTotle();
	
	//�ж�ջ��
	public boolean isEmpty();
	
}
