import java.util.*;
public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print(solution(n,k,arr));
    }

    private static int solution(int n, int k, int[] arr){
        int answer = -1;

        int count =0;

        boolean check = false;

        for(int i=1; i<arr.length; i++){
            int temp = arr[i];
            int prev = i - 1;
            while((prev >=0)&& arr[prev] > temp){
                check = true;
                arr[prev+1] = arr[prev];
                count ++;
                if(count == k){
                    answer = arr[prev+1];
                    return answer;
                }
                prev--;
            }
            arr[prev+1] = temp; //prev+1 이 현재값 (-1이 앞에 값으로 비교하는 값)
            if(check){
                count++;
            }
            check = false;
            if(count == k){
                answer = arr[prev+1];
                return answer;
            }
        }

        return answer;
    }
}
