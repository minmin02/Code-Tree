import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] l = new int[n];
        int[] r = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            r[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }

        for(int i=0; i<t; i++){

            int tempL=l[n-1];
            int tempR=r[n-1];
            int tempD=d[n-1];

            for(int j=n-1; j>=1; j--){
            
                l[j]=l[j-1];
                r[j]=r[j-1];
                d[j]=d[j-1];
            }

            l[0]=tempD;
            r[0]=tempL;
            d[0]=tempR;



        }

        for(int i=0; i<n; i++){
            System.out.print(l[i] + " ");
        }
        System.out.println();
        for(int i=0; i<n; i++){
            System.out.print(r[i] + " ");
        }
        System.out.println();
        for(int i=0; i<n; i++){
            System.out.print(d[i] + " ");
        }



        // 1 2 4  1 1 2
        // 5 9 3  4 5 9
        // 1 5 6  5 6 3
    }
}