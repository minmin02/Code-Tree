import java.io.*;
import java.util.*;
public class Main {
    static int max=Integer.MIN_VALUE;
    static int min=Integer.MAX_VALUE;
    static int n;
    static int[]nums;

    static int plus,minus,mul;

    static void DFS(int idx,int cur){
        if(idx==n){
            max=Math.max(max,cur);
            min=Math.min(min,cur);
            return;
        }

        if(plus>0){
            plus--;
            DFS(idx+1,cur+nums[idx]);
            plus++;
        }
        if(minus>0){
            minus--;
            DFS(idx+1,cur-nums[idx]);
            minus++;
        }
        if(mul>0){
            mul--;
            DFS(idx+1,cur*nums[idx]);
            mul++;
        }        

    }

    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        //첫줄
        n=Integer.parseInt(br.readLine().trim());

        nums=new int[n];
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        // n번 줄
        for(int i=0; i<n; i++){
            nums[i]=Integer.parseInt(st.nextToken());
        }



        st=new StringTokenizer(br.readLine());
        
        plus=Integer.parseInt(st.nextToken());
        minus=Integer.parseInt(st.nextToken());
        mul=Integer.parseInt(st.nextToken());
        
        
        DFS(1,nums[0]);

        System.out.println(min+" "+max);
    }
}