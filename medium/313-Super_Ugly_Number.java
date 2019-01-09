/**

Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.

Example:

Input: n = 12, primes = [2,7,13,19]
Output: 32
Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
             super ugly numbers given primes = [2,7,13,19] of size 4.
Note:

1 is a super ugly number for any given primes.
The given numbers in primes are in ascending order.
0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
The nth super ugly number is guaranteed to fit in a 32-bit signed integer.

**/

public int nthSuperUglyNumber(int n, int[] primes) {
    int[] uglyNo=new int[n];
    uglyNo[0]=1;
    int[] index=new int[primes.length];
    for(int i=1;i<uglyNo.length;i++){
        int min=Integer.MAX_VALUE;
        for(int j=0;j<index.length;j++){
            min=Math.min(min, primes[j]*uglyNo[index[j]]);
        }
        for(int j=0;j<index.length;j++){
            if(min==primes[j]*uglyNo[index[j]]){
                uglyNo[i]=min;
                index[j]=index[j]+1;
            }
        }
        System.out.println(uglyNo[i]);
    }
    return uglyNo[n-1];
}
