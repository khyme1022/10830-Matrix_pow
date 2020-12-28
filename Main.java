import java.util.*;
import java.io.*;

class Main {

  public static int N;
  public static int[][] arr;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    st = new StringTokenizer(br.readLine()," ");
    N = Integer.parseInt(st.nextToken());
    long B = Long.parseLong(st.nextToken());
    arr = new int[N][N];
    for(int i=0;i<N;i++){
      st = new StringTokenizer(br.readLine()," ");
      for(int j=0;j<N;j++){
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int[][] result = DNC(arr,B);
    for(int i=0;i<N;i++){
      for(int j=0;j<N;j++){
        sb.append(result[i][j]%1000+" ");
      }
      sb.append("\n");
    }
    System.out.print(sb);
  }

  public static int[][] power(int[][] a, int[][] b){
    System.out.println("power");
    int[][] tmp = new int[N][N];
    for(int i=0; i<N; i++) {
      for(int j=0; j<N; j++) {
        int sum = 0;
        for(int k=0; k<N; k++) {
          sum += a[i][k]*b[k][j];
        }
      tmp[i][j] = sum%1000;
      }
    }
    return tmp;
  }

  public static int[][] DNC(int[][] a, long num){
    System.out.println("DNC" + num);
    if(num==1)  return a;
    else if(num%2==0){
      int[][] tmp = DNC(a,num/2);
      return power(tmp,tmp);
    }else{
      return power(DNC(a,num-1),a);
    }
  }
} 