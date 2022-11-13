package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Vector;

public class Main {
    //to calculate number of bits
    static int NumOfBits(int x) {
        if (x == 0)
            return 1;
        int ans = 0;
        while (x > 0) {
            x /= 2;
            ans++;
        }
        return ans;
    }

    static void Compression()
    {
        HashMap<String,Integer>dic=new HashMap<String,Integer>();
        for(int i=0;i<128;i++)
        {
            dic.put((char)i+"",i);
        }
        Scanner input = new Scanner(System.in);
        String str=input.next();
        Vector<Integer>Compression=new Vector<>();
        String curr="";
        int cnt=128;
        int mx=0;
        for(int i=0;i<str.length();i++)
        {
            curr+=str.charAt(i);
            if(!dic.containsKey(curr))
            {
                dic.put(curr,cnt++);
                curr=curr.substring(0,curr.length() - 1);
                Compression.add(dic.get(curr));
                mx=Math.max(mx,dic.get(curr));
                curr="";
                i--;
            }
        }
        if(curr.length()>0)
        {
            Compression.add(dic.get(curr));
            mx=Math.max(mx,dic.get(curr));

        }
        for(int i=0;i<Compression.size();i++)
        {
            System.out.print("<"+ Compression.get(i) + "> " );
        }
        System.out.println();
        int after=NumOfBits(mx)*Compression.size();
        int before=str.length()*8;
        System.out.println("THe Size Before Compression = " + before+ " Bits");
        System.out.println("THe Size After Compression = " + after + " Bits");
    }

    static void Decompression(){
        Scanner input = new Scanner(System.in);
        ArrayList<Integer>tags = new ArrayList<Integer>();
        System.out.println("Enter Tags Size:");
        int tagsSize = input.nextInt();
        System.out.println("Enter "+tagsSize+" Tags:");
        for (int i=0;i<tagsSize;i++){
            int x=input.nextInt();
            tags.add(x);
        }

        String decompressionTxt="";
        HashMap<Integer,String>dic=new HashMap<Integer,String>();
        for(int i=0;i<128;i++)
        {
            dic.put(i,(char)i+"");
        }
        int curr=128;
        String prev="";
        for (int i=0;i<tags.size();i++){
            if(i>0){
                dic.put(curr,prev);
                dic.put(curr, prev +dic.get(tags.get(i)).charAt(0));
                curr++;
            }
            decompressionTxt+=dic.get(tags.get(i));
            prev=dic.get(tags.get(i));

        }
        System.out.println("The Decompression Text: "+decompressionTxt);


    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("----------------------------");
        System.out.println("--- Welcome To LZW App ---");
        System.out.println("----------------------------");
        while (true) {
            System.out.println("Choose Number From Our List To Start: ");
            System.out.println("-------------------------------------");
            System.out.println("1- Compression");
            System.out.println("2- Decompression");
            System.out.println("3- Exit");
            System.out.println("-------------------------------------");
            System.out.print(">> ");
            int choice = input.nextInt();
            System.out.println("-------------------------------------");

            if (choice == 1)
            {
                Compression();
                System.out.println("-------------------------------------");
            }
            else if (choice == 2)
            {
                Decompression();
                System.out.println("-------------------------------------");
            }
            else if (choice == 3)
            {
                System.out.println("Exit..");
                System.out.println("-------------------------------------");
                break;
            }
        }

    }
}

/**

 14

 65
 66
 65
 128
 128
 129
 131
 134
 130
 129
 66
 138
 139
 138


 **/