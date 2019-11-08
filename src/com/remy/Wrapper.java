package com.remy;

import java.util.Scanner;
// Final push on 07-Nov 2019

public class Wrapper {
    public static void main(String[] args) {
        String[] a = new String[1];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the chaos you want to create for I/O \n" +
                "Enter 1 for Disk Write chaos : \n" +
                "Enter 2 for Disk Read chaos :  \n" +
                "Enter 3 for both Disk Write & Disk Read chaos : ");
        int option = scanner.nextInt();
        switch (option) {
            case 1 :
                IOThrottleWrite.main(a);
                break;
            case 2:
                IOThrottleRead.main(a);
                break;
            case 3:
                IOThrottleWrite.main(a);
                try {
                    Thread.sleep(20000);
                } catch (Exception e) {

                }
                IOThrottleRead.main(a);
                break;
            default:
                    System.out.println("Wrong option entered. Exiting....");

        }



    }
}
