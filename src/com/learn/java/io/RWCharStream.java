package com.learn.java.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/**
 * 使用缓冲buffer写出时，注意加上偏移量，否则，最后读取长度不足，会写入buffer中上一次数据。
 * @author chuxz
 *
 */
public class RWCharStream {

	public static void main(String[] args) {

		try {
			FileInputStream fis = new FileInputStream("doc/spring.txt");
			FileOutputStream fos = new FileOutputStream("doc/spring_new.txt");
			InputStreamReader isr = new InputStreamReader(fis);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			char buffer[] = new char[100];
			int len;
			while (( len=isr.read(buffer)) != -1) {
//				System.out.println(new String(buffer));
				osw.write(buffer,0,len);
			}
			
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
