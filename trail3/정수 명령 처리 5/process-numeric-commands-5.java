import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> v = new ArrayList<>();
        
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            
            if (input.equals("push_back")) {
                int num = sc.nextInt();
                v.add(num);
            } else if (input.equals("pop_back")) {
                if (!v.isEmpty()) {
                    v.remove(v.size() - 1); 
                }
            } else if (input.equals("size")) {
                System.out.println(v.size());
            } else if (input.equals("get")) { 
                int k = sc.nextInt();
                System.out.println(v.get(k - 1));
            }
        }
        
        sc.close();
    }
}