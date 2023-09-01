import java.util.*;
public class 삽입정렬2 {
    private static int m = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for(int i =0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        solution(n, k, arr);

        if(m == -1){
            System.out.print(m);
        }
        else{
            //System.out.print(Arrays.toString(arr));
            for(int i=0; i < arr.length; i++){
                if(i==arr.length-1){
                    System.out.print(arr[i]);
                }
                else{
                    System.out.print(arr[i]+" ");
                }
            }
        }
    }

    private static void solution(int n, int k, int[] arr){
        int count = 0;
        boolean check = false;

        for(int i=1; i <arr.length; i++){
            int temp = arr[i];
            int prev = i-1;
            while((prev >=0) && arr[prev] > temp) {
                check = true;
                arr[prev+1] = arr[prev];
                count++;
                if( count == k){
                    return;
                }
                prev--;
            }
            arr[prev+1] = temp;
            if(check){
                count++;
            }
            if( count == k){
                return;
            }
        }
        if( count < k){
            m = -1;
        }
    }
}
