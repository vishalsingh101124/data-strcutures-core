package main.recursion;

/*
You are given a positive integer n, you can do the following operation any number of times:

Add or subtract a power of 2 from n.
Return the minimum number of operations to make n equal to 0.
A number x is power of 2 if x == 2i where i >= 0.
 */
public class MinOpsToMakeZero {
    public static void main(String[] args) {
        System.out.println("Minimum Operation to Make Number 39 to Zero is - "+recursion(39));
    }
     static int recursion(int n){
        if(n==0)return 0;

        int closestPow=1;
        while(closestPow<=n)closestPow*=2;
        closestPow/=2;
        if(n==closestPow)return 1;
        int substract=recursion(n-closestPow);
        int add=recursion(closestPow*2-n);
        return 1+ Math.min(substract,add);

    }
}
