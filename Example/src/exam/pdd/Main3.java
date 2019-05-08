package exam.pdd;

import java.io.*;
import java.text.NumberFormat;

//袜子概率 85%
//输入袜子数量，袜子颜色，色差d
public class Main3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int d = Integer.valueOf(br.readLine());
        line = line.substring(1,line.length()-1);
        line = line.replace(" ","");
        String[] content = line.split(",");
        int[] S = new int[content.length];
        for (int i = 0; i < content.length; i++) {
            S[i] = Integer.valueOf(content[i]);
        }
        int fenzi = 0;
        int fenmu = content.length*(content.length-1)/2;
        for (int i = 0; i < content.length-1; i++) {
            for (int j = i+1; j < content.length; j++) {
                if (Math.abs(S[i]-S[j])<=d){
                    fenzi++;
                }
            }
        }
//        System.out.println(fenzi);
//        System.out.println(fenmu);
        double result = fenzi*1.0/fenmu;
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(6);
        System.out.println(nf.format(result));
    }
}
