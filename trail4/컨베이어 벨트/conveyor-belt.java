import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] top = new int[n];
        int[] bottom = new int[n];

        // 1 2 3
        for (int i = 0; i < n; i++) {
            top[i] = sc.nextInt();
        }
        // 6 5 1
        // 3 6 5
        for (int i = 0; i < n; i++) {
            bottom[i] = sc.nextInt();
        }

        for(int i=0; i<t; i++){

            int tempTop=top[n-1];
            int tempBottom=bottom[n-1];

            for(int j=n-1; j>=1; j-- ){
                top[j]=top[j-1];
                bottom[j]=bottom[j-1];
            }

    
            bottom[0]=tempTop;
            top[0]=tempBottom;
        }
for(int i=0; i<n; i++){
            System.out.print(top[i] + " ");
        }
        System.out.println();
        for(int i=0; i<n; i++){
            System.out.print(bottom[i] + " ");
        }


        
    }
}