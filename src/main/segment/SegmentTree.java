package main.segment;

public class SegmentTree {
    int n;
    int[] segmentTree;
    int[] arr;

    public SegmentTree(int[] arr){
        this.n=arr.length;
        this.arr=arr;
        this.segmentTree=new int[4*n];
        build(0,n-1,0);
    }

     void build(int start,int end,int node){
        if(start==end){
            this.segmentTree[node]=this.arr[start];
            return;
        }
        int mid=(start+end)/2;
        build(start,mid,2*node+1);
        build(mid+1,end,2*node+2);
        this.segmentTree[node]=this.segmentTree[2*node+1]+this.segmentTree[2*node+2];

    }
    int query(int l,int r){
        return queryUtil(0,this.n-1,l,r,0);
    }
    int queryUtil(int start,int end,int l,int r,int node){

        if (r < start || l > end) return 0;
        if (l <= start && end <= r) return this.segmentTree[node];

        int mid=(start+end)/2;
        int leftSum = queryUtil(start, mid, l, r, 2 * node + 1);
        int rightSum = queryUtil(mid + 1, end, l, r, 2 * node + 2);
        return leftSum+rightSum;

    }

    void update(int index,int data){
        updateUtil(0,this.n-1,index,data,0);
    }
    void updateUtil(int start,int end,int index,int val,int node){
        if(start==end){
            this.segmentTree[node]=val;
            return;
        }
        int mid=(start+end)/2;
        if(index<=mid)updateUtil(start,mid,index,val,2*node+1);
        else updateUtil(mid+1,end,index,val,2*node+2);

        this.segmentTree[node]=this.segmentTree[2*node+1]+this.segmentTree[2*node+2];
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree segment=new SegmentTree(arr);

        System.out.println(segment.query(1, 3)); // sum of 3+5+7 = 15

        segment.update(1, 10); // arr[1] = 10
        System.out.println(segment.query(1, 3)); // sum = 10+5+7 = 22

    }
}
