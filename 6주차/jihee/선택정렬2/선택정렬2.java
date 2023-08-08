import java.util.*;
public class 선택 {
    private static int m=0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        solution(n,k,arr);
        if(m !=0-1){
            for(int i=0; i<n; i++){
                System.out.print(arr[i] + " ");
            }
        }
        else{
            System.out.print(m);
        }
    }

    private static void solution(int n, int k, int[] arr){
        int indexMax, temp;
        int count =0;
        for(int i=n-1; i>0; i--){
            indexMax = i;
            for(int j=i-1; j>=0; j--){
                if(arr[j] > arr[indexMax]){
                    indexMax = j;
                }
            }
            if(indexMax !=i){ // 교환이 이루어졌을때만 count하기 위해 swap도 조건이 맞을때만 해준다
                //swap
                temp = arr[indexMax];
                arr[indexMax] = arr[i];
                arr[i] = temp;
                count++;

                if(count == k){
                    break;
                }
            }
        } // end of for

        if(count < k) {
            m=-1;
        }
    } // end of solution

}
