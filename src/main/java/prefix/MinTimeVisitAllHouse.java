package main.java.prefix;
/*

Minimum all time taken to visit all houses given as per the queries statement.
Forward Array[] Gives distance of i+1 (Meter), Consider Circular Path
Backward Array[] Gives distance of i-1 (Meter), Consider Circular Path
 */
public class MinTimeVisitAllHouse {
    public static void main(String[] args) {
        int[] forward=new int[]{1,4,4};
        int[] backward=new int[]{4,1,2};
        int[] queries=new int[]{1,2,0,2};
        System.out.println(minTotalTime(forward,backward,queries));
    }
    static long minTotalTime(int[] forward, int[] backward, int[] queries) {
        int n = forward.length;
        long[] fwdPrefix = new long[n+1], bwdPrefix = new long[n+1];
        for (int i = 1; i <= n; i++) {
            fwdPrefix[i] = fwdPrefix[i-1] + forward[i-1];
            bwdPrefix[i] = bwdPrefix[i-1] + (i < n ? backward[i] : backward[0]);
        }
        long res = 0;
        int curr = 0;
        for(int targetState:queries){
            int currentState=curr;
            long clockWiseTime=(currentState<= targetState)?fwdPrefix[targetState]-fwdPrefix[currentState]:fwdPrefix[forward.length]-(fwdPrefix[currentState]-fwdPrefix[targetState]);
            long antiClockWiseTime=currentState>= targetState ?bwdPrefix[currentState]-bwdPrefix[targetState]:bwdPrefix[backward.length]-(bwdPrefix[targetState]-bwdPrefix[currentState]);
            res += Math.min(clockWiseTime, antiClockWiseTime);
            curr = targetState;
        }
        return res;
    }
}
