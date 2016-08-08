package com.learn.java.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class WriteFile extends Thread {
	
	File file;
	int block;
	int L = 100;
	
	/**
	 * File
	 *            |***        |+++
	 * |-----------***---------+++--------------------------|
	 * 		|---
	 */
	
	/**
	 * 1			2			 3			  4			   5(2)
	 * |------------|------------|------------|------------|------------|
	 * 0xL			1xL
	 * 
	 * @param f
	 * @param b
	 */

	public WriteFile(File f,int b){
		this.file = f;
		this.block = b;
	}
	
	@Override
	public void run() {
		try {
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			raf.seek((block-1)*L);
			raf.writeBytes("\n");
			raf.writeBytes("This is block"+block);
			for (int i = 0; i < 20; i++) {
				raf.writeBytes("-");
			}
			raf.writeBytes("\n");
			System.out.println("block done: " + this.block);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
