package jz;

public class Fibonacci {
    public int Fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int p = 0, pp = 0;
        int ans = 1;
        for (int i = 2; i < n + 1; i++) {
            pp = p;
            p = ans;
            ans = p + pp;
        }
        return ans;
    }
}
