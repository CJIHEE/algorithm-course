# 5주차 내용정리

## 📌 백트래킹

백트래킹(Backtracking) 이란 ?

- 해를 찾는 도중 해가 아니어서 막히면, 되돌아가서 다시 해를 찾아가는 기법을 말한다. 최적화 문제와 결정 문제를 푸는 방법이 된다.
- 스무고개를 생각하면 쉽게 이해할 수 있음.

ex ) 미로탐색

- 미로 탐색 문제같은 경우, 출발지부터 상,하,좌,우로 경우의 수를 dfs로 뻗어나가게 되는데, 더이상 진행할 수 없는 경우 다른 경우의 수로 해를 찾게된다.

## 📌 조합


$$
nCr = n! / (n-r)! * r!
$$

이 공식을 쓰지 않고 다음 공식을 쓴다.

$$
nCr = n-1Cr-1 + n-1Cr
$$

위의 공식으로 예를들어 5명중에서 3명을 뽑는 경우의 수를 식으로 풀면 다음과 같다.

$$
5C3 = 4C2 + 4C3
$$

말로 풀어서 이야기 하면 5명중에서 3명을 뽑는 경우의 수는 4명중에서 2명을 뽑는 경우의 수와 4명 중에서 3명을 뽑는 경우의 수를 합한 것

이해가 잘 안간다면 다음의 예시를 보면 쉽게 이해할 수 있다.

1번학생, 2번학생, 3번학생, 4번학생, 5번학생 총 5명의 학생이 있고 이 중에서 3명을 뽑는다고 가정해보자.

`**[1, 2, 3, 4, 5]**`

이 때 5번 학생이 본인이라고 생각해보면 내가 포함되거나 포함되지 않는 경우의 수 2가지가 있다.

- **내가 포함되었을 경우**
    - 나머지 4명 중에서 2명을 더 뽑는 경우의 수가 있다. (4C2)
- **내가 포함되지 않았을 경우**
    - 나머지 4명중에서 3명을 더 뽑는 경우의 수가 있다. (4C3)

따라서 이 두가지의 케이스를 더하면 5명중에서 3명을 뽑는 경우의 수와 같다고 볼 수 있는 것이다.

이를 코드로 구현한다면,

재귀의 종료조건을 n이 r과 같아지거나, r이 0이될 때 로 잡고, 해당 경우에서 1을 return하도록 하면 된다.

이것도 왜 이렇게 코드를 짜야하는지 말로하면 간단하다. 

- **n이 r과 같다**
    - 만약 n이 2고 r이 2라면 2명중에서 2명을 뽑는 경우의 수는 1가지뿐이므로 1을 return해준다.
- **r이 0이다**
    - 아무것도 뽑지 않는 경우의 수 이므로 1가지 뿐이다. 그러므로 1을 return해준다.

n명 중에서 m명을 뽑는 조합 수(nCm)를 출력하는 프로그램 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(combination(n, m));
    }

    private static int combination(int n, int m) {
        if(n == m) return 1;
        if(m == 0) return 1;

        return combination(n-1, m-1) + combination(n-1, m);
    }
}
```

## 📌 순열

**순열이란 ?**

- 서로 다른 것들 중 몇가지를 뽑아서 한 줄로 나열하는 것
- 순서가 중요함, 순서가 바뀐다면 다른순열임.

**예제문제**

[[백준] - N과 M](https://www.acmicpc.net/problem/15649)

- 정답코드
    
    ```java
    import java.util.*;
    
    public class Main {
        private static int n;
        private static int m;
        private static boolean[] visited;
        private static int[] arr;
        private static StringBuilder sb;
    
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
    
            n = sc.nextInt();
            m = sc.nextInt();
    
            sb = new StringBuilder();
            solution(n, m);
            System.out.println(sb);
        }
    
        private static int solution(int n, int m) {
            int answer = 0;
            visited = new boolean[n+1]; //길이가 n
            arr = new int[m];
            dfs(0);
            return answer;
        }
    
        private static void dfs(int depth) {
            if(depth == m) {
                Arrays.stream(arr).forEach(x -> sb.append(x).append(" "));
                sb.append("\n");
            } else {
                for(int i=1; i<=n; i++) {
                    if (visited[i]) continue;
                    visited[i] = true;
                    arr[depth] = i;
                    dfs(depth + 1);
                    visited[i] = false;
                }
            }
        }
    
    }
    ```
위의 문제는 백트래킹을 이용하여 풀 수 있다.  
재귀를 for문으로 1부터 n까지의 자연수만큼 가지를 뻗어나가는데, visited 배열을 확인하여 사용되지 않은 숫자를 순차적으로 arr에 담아준다.  
depth가 m이 된다면 하나의 순열이 arr에 들어가있게 되므로, StringBuilder에 담아준다.

## 📌 5주차 과제


[[백준] - N-Queen](https://www.acmicpc.net/problem/9663)

[[백준] - 부분수열의 합](https://www.acmicpc.net/problem/1182)

[[백준] - 로또](https://www.acmicpc.net/problem/6603)

[[백준] - 순열](https://www.acmicpc.net/problem/9742)

[[백준] - 연구소](https://www.acmicpc.net/problem/14502)

[[백준] - N과 M](https://www.acmicpc.net/problem/15649)