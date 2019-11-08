package com.remy;

import java.io.FileOutputStream;
// Final push on 07-Nov 2019 with some comments

class SimpleThread extends Thread {

    SimpleThread(String str) {
        super(str);
    }

    public void run() {
        byte[] b = new byte[100];
        try {
            //  File file = new File("file.txt");
            FileOutputStream fout = new FileOutputStream("file.txt");
            //byte[] tempByte = new byte[500];
            for(int i = 0; i <= 50000; i++) {
                /*if((file.length() /(1024 * 1024)) > 1000) {
                    break;
                }*/
                byte[] num = new byte[i];
                fout.write(i);
                //   fout.write(i + (int)Math.random());
                //        tempByte[i] = (byte)i;
                // byte[] tmp = new byte[i];
                //fout.write(tmp);
                fout.write(num);
                //        fout.write(tempByte);
                for (int j = 0; j <= 50000; j++) {
                /*    if((file.length() /(1024 * 1024)) > 1000) {
                        break;
                    }*/
                    fout.write(b);
                    fout.write(j);
                    fout.write(i);
                    // fout.write(j + (int)Math.random());
                }

            }

            fout.close();

        } catch(Exception e) {

        }
        finally {
            System.out.println("File Output Stream Closed");
        }
    }




}

public class IOThrottleWrite {
    public static void main(String[] args) {
        System.out.println("Creating IO write chaos............. : Work in Progress Project");
        System.out.println("Use Ctrl + C to exit");
        int threadCount = 2;   // 4 threads = 225 MB / minute,  // 1 thread = 400 MB / minute ; 2 threads 388 MB / minute; 3 threads 324 MB / minute
        for (int i = 1; i <= threadCount; i++) {
            new Thread(new SimpleThread("Thread "+i)).start();
        }
    }
}