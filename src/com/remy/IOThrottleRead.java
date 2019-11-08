package com.remy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
// Final push on 07-Nov 2019

class SimpleThread3 extends Thread {

    long starttime;
    SimpleThread3() {
        super();
    }

    public void run() {
        try {

             starttime = System.currentTimeMillis();
            File fi = new File("file.txt");
            FileOutputStream fout = new FileOutputStream("file.txt");
            for(int i = 100000 ; i <= 1000000000; i++) {
                fout.write(i);
                byte[] num = new byte[i];
                fout.write(num);
                if((fi.length() /(1024 * 1024)) > 1000) {
                  //  break;
                  IOThrottleRead.main(new String[0]);
                 // System.exit(0);
                  break;
                }

            }
        } catch(Exception e) {

        }
    }
}

class SimpleThread2 extends Thread {
  public SimpleThread2(String str) {
        super(str);
    }


    public void run() {
        File fil  = new File("file.txt");



        try {
            if(!fil.exists()) {
                //System.out.println(Thread.currentThread().getName());
                //IOThrottleWrite iowrite = new IOThrottleWrite();
                //System.out.println("File does not exist. Creating raw IO file. Please wait for 10 seconds. The Read chaos process will re-start");
                System.out.println();
                int time = 0;
                new SimpleThread3().start();
                // This is for existing after write to file - for GC type demo

            }

            FileInputStream fin = new FileInputStream("file.txt");
            for(int i = 0; i < 100000000; i++) {
                fin.read();
                for (int j = 0; j < 10000000;j++) {
                    fin.read();
                }
            }
        } catch (Exception e) {

        }
    }
}

public class IOThrottleRead {


    public static void main(String[] args) {

        System.out.println("Creating IO read chaos............. : Work in Progress Project");
        System.out.println("Use Ctrl + C to exit");
        int threadCount = 2;   // 4 threads = 225 MB / minute,  // 1 thread = 400 MB / minute ; 2 threads 388 MB / minute; 3 threads 324 MB / minute
        for (int i = 1; i <= threadCount; i++) {
            new Thread(new SimpleThread2("Thread " + i)).start();
        }




    }


    }



