package com.czxy;

/**
 * Created by Administrator on 2019/3/14 0014.
 */
public class Test {

    public static void main(String[] args) {
        for(int i=1;i<=9;i++){
            System.out.print(i+"|   ");
            for(int j=1;j<=i;j++){
                System.out.print((j*i)+"    ");
            }
            System.out.println();
        }

        int a[]={20,10,55,40,30,70,60,80,90,100};
        for(int i=0;i<=10-1;i++){
            for(int j=i+1;j<10;j++ ){
                if(a[i]>a[j]){  //sheng
                    int temp = a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }

        System.out.println("sss");

    }


}
