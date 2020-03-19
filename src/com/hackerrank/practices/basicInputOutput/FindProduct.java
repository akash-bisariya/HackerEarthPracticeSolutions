import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TestClass 
{
    public static void main(String args[] ) throws Exception 
    {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int testcases = Integer.parseInt(br.readLine());
      String x[] = br.readLine().split(" ");
      long answer = 1;
      long m = 1000000007;
      for (int i=0;i < x.length;i++)
      {
          //product = ((product%m)*((Integer.parseInt(input[i]))%m))%m;
            answer = ((answer)*Integer.parseInt(x[i]))%m;
      }
      System.out.print(answer);

    }
}
