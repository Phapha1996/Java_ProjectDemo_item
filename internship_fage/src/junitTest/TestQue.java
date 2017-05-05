package junitTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.junit.Test;

import datastuctrue.impl.LinkedStack;
import datastuctrue.itf.Stack;
import exception.StackException;
import first_question.QuestionUtils;

public class TestQue {

	/*@Test
	public void testMake(){
		QuestionUtils q = new QuestionUtils();
		for(int i=0;i<10;i++){
		System.out.println(q.makeQuestion());
		
		char c[] = q.getMakeq();
		for(char f:c){
			System.out.print(f);
		}
		System.out.println();
		}	
	}*/
	
	
	
	@Test
	public void makeKuohao(){
	
		String a = "";
		int index1 = (int) Math.random()*40;
		int index2 = (int)Math.random()*40+10;
		for(int i=0;i<6;i++){
			
			a += i;
			if(i==index1)
				a += "(";
			
			if(i==index2)
				a += ")";
			
		}
		
		System.out.print(a);
	}
	
	
	
	/*public void testtransquestion(){
		char[] c = {'9','+','(','3','-','1',')','*','3','+','5','/','2','='};
		QuestionUtils q = new QuestionUtils();
		
		for(int i=0;i<c.length;i++){
			q.transInto(c[i]);
		}
		System.out.print(q.getSb());
		
	}*/
	
	
	/*@Test
	public void test2(){
		
		char[] c = {9,'+','(',3,'-',1,')','*',3,'+',5,'/',2,'='};
		QuestionUtils q = new QuestionUtils();
		
		for(int i=0;i<c.length;i++){
			q.transInto(c[i]);
		}
		System.out.println(q.getSb());
		System.out.print(q.doQuestion());
		
	}*/
	
	
	
	/*@Test
	public void testall(){
		for(int i=0;i<10000;i++){
		QuestionUtils q = new QuestionUtils();
		
		 q.makePairQuestion();
		 q.transInto();
		
		
		System.out.print(q.getQuestion()+q.doQuestion());
		System.out.println();
		
		}
		}*/
	


	@Test
	public void testOushu(){
		for(int i=0;i<10;i++){
		int value = (int)(Math.random()*8);
		if(value%2==0){
			System.out.println("偶数："+ value);
		}else{
			System.out.println("偶数"+ ++value);
		}
		
		int value2 = (int)(Math.random()*9);
		if(value%2==0){
			System.out.println("奇数："+ ++value);
		}else{
			System.out.println("奇数："+ ++value);
		}
	}
		
	}

	
	
	
	@Test
	public void TestIo(){
	
		try {
			File file = new File("d:/student.txt");
			FileWriter fw = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("a+bc+asd+5=6"+"\r\n");
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


