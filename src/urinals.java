package src;

import java.io.*;

public class urinals {
    public static void main(String[] args){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the input string:");
            String inp = br.readLine();

            if(!checkString(inp)){
                System.out.println("Input string should have only 0s and 1s.\n Exiting..."); return;
            }

            boolean validString = goodString(inp);
            if (validString) {
                System.out.println("The given string is a valid String");
            } else{
                System.out.println("The given string is an invalid String");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Boolean goodString(String inp){
        int count=0;
        int tot_count=0;
        boolean flag=false;
        int i=0;
        while(i<inp.length() && inp.charAt(i)=='0'){
            count++;i++;
        }
        if(i==inp.length() && inp.length()%2==1){
            tot_count = (count+1)/2;
            System.out.println(tot_count);return true;
        } else if(i==inp.length() && inp.length()%2==0) {
            tot_count = (count)/2;
            System.out.print(tot_count); return true;
        }else if(count%2==0){
            tot_count = (count) / 2;
        }else{
            tot_count = (count-1)/2;
        }
        count=0;
        while(i<inp.length()){
            if(inp.charAt(i)=='0'){
                count=0;
                while(i<inp.length() && inp.charAt(i)=='0'){
                    count+=1;i++;
                }
                if(i!=inp.length()){
                    if(count%2==0){
                        tot_count += (count-1)/2;
                    } else{
                        tot_count += count/2;
                    }
                }
            }
            if(i<inp.length() && inp.charAt(i)=='1') {
                count=0;
                int count1 = 0;
                while (i < inp.length() && inp.charAt(i) == '1') {
                    count1 += 1;i++;
                    if (count1 > 1) {
                        System.out.println(-1);return false;
                    }
                }
            }
        }
        if(count%2==1) {
            tot_count += (count - 1) / 2;
        } else{
            tot_count += (count)/2;
        }

        System.out.println(tot_count);
        return true;
    }

    public static Boolean checkString(String str){
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!='0' && str.charAt(i)!='1'){
                return false;
            }
        }
        return true;
    }
}
