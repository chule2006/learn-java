package com.learn.java.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class RWBufferCharStream {

	public static void main(String[] args) {

		try {
			FileInputStream fis = new FileInputStream("doc/spring.txt");
			FileOutputStream fos = new FileOutputStream("doc/spring_new_buffer.txt");
			InputStreamReader isr = new InputStreamReader(fis);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedReader br = new BufferedReader(isr);
			BufferedWriter bw = new BufferedWriter(osw);
			PrintWriter pw = new PrintWriter(osw);
			
			String str;
			
			while ((str=br.readLine()) != null) {
//				bw.write(str+"\n");
//				pw.write(str);
				pw.println(str);
				
			}
//			bw.flush();
			br.close();
//			bw.close();
			pw.flush();
			pw.close();
			isr.close();
			osw.close();
			fos.close();
			fis.close();
			System.out.println("done");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
