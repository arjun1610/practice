import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by arjun on 1/18/16.
 */
public class InfBitPattern {
    public static void main(String[] args) throws IOException {
     int num[] ={1,2,3,4,3,1};
        BitPattern3(num);
    }


/*
 * Complete the function below.
 */

    static void BitPattern(int[] num)
    {
        String s ="0";
        int i,j;
        boolean flag=false;
        for (i=1;i<num.length;i++)
        {
            flag=false;
            for(j=i-1;j>=0;j--)
            {
                if(num[i] == num[j])
                {
                    s += "1";
                    flag=true;
                    break;
                }
            }
            if(!flag)
                s+="0";
        }
        System.out.println(s);
    }
    static void BitPattern2(int[] num)
    {
        String s = "";
        HashMap h = new HashMap();
        for(int i=0;i<num.length;i++) {
            if (h.get(num[i])!=null) {
                s+="1";
            } else {
                h.put(num[i],num[i]);
                s+="0";
            }
        }
        System.out.print(s);
    }
    static void BitPattern3(int[] num)
    {
        String s ="";
        int i,j;
        boolean flag=false;
        for (i=0;i<num.length;i++)
        {
            flag = false;
            for(j=i+1;j<num.length;j++)
            {
                if(num[i] == num[j])
                {
                    s += "1";
                    flag=true;
                    break;
                }
            }
            if(!flag)
                s+="0";
        }
        System.out.println(s);
    }
}
