import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'gemstones' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY arr as parameter.
     */

    public static int gemstones(List<String> arr) {
    // Write your code here
    int n = arr.size();
    int[][] dp = new int[n][26];
    
    for(int i=0;i<n;i++){
        String s = arr.get(i);
        for(int j=0;j<s.length();j++){
            char ch = s.charAt(j);
            int idx = ch-'a';
            
            if(dp[i][idx]==0){
                dp[i][idx]=1;
            }
        }
    }
    
    int[] count = new int[26];
    for(int i=0;i<26;i++){
        int counter=0;
        for(int j=0;j<n;j++){
            counter+=dp[j][i];
        }
        count[i]=counter;
    }
    
    int ans = 0;
    
    for(int val:count){
        if(val==n){
            ans++;
        }
    }
    
    return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> arr = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int result = Result.gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
