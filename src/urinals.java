package src;

import java.io.*;
import java.util.*;

// Author : Vishnu Vantukala
// Date : 10/27/2022
// ICA-8 Testing

public class urinals {
    public static void main(String[] args){
            String filePath = new File("").getAbsolutePath();
            ArrayList<String> str;
            try {
                str = readFile(filePath + "/test_files/urinal.dat");
            } catch (IOException e){
                System.out.println("File not found. Exiting...");
                return;
            }

            File file = new File(filePath + "/test_files/rule.txt");
            int count = 1;
            while(file.exists()){
                file = new File(filePath + "/test_files/rule" + count + ".txt");
                count+=1;
            }

            for(int i=0;i<str.size();i++) {
                String inp = str.get(i);
                if (!checkString(inp)) {
                    System.out.println("Input string should have only 0s and 1s.\n Exiting...");
                    return;
                }

                boolean validString = goodString(inp, file);
            }
    }

    public static Boolean goodString(String inp, File file){
        int count=0;
        int tot_count=0;
        int i=0;
        while(i<inp.length() && inp.charAt(i)=='0'){
            count++;i++;
        }
        if(i==inp.length() && inp.length()%2==1){
            tot_count = (count+1)/2;
            System.out.println(tot_count);
            writeFile(String.valueOf(tot_count), file);return true;
        } else if(i==inp.length() && inp.length()%2==0) {
            tot_count = (count)/2;
            System.out.println(tot_count);
            writeFile(String.valueOf(tot_count), file);return true;
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
                        System.out.println(-1);
                        writeFile(String.valueOf(-1), file);return false;
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
        writeFile(String.valueOf(tot_count), file);
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

    public static ArrayList<String> readFile(String fileName) throws IOException{
        File file = new File(fileName);
        ArrayList<String> ar = new ArrayList<String>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while((st = br.readLine()) != null){
                System.out.println(st);
                ar.add(st);
            }
        } catch ( IOException e) {
            throw new IOException();
        }
        return ar;
    }

    public static void writeFile(String str, File file){
        try{
            FileWriter fr = new FileWriter(file, true);
            fr.write(str + '\n');
            fr.close();
        } catch ( IOException e) {
            System.out.println("FileNotFound");
            e.printStackTrace();
        }
    }
}
