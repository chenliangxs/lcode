/**
Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.

Example 1:

Input: a = 2, b = [3]
Output: 8
Example 2:

Input: a = 2, b = [1,0]
Output: 1024
**/
public int superPow(int a, int[] b) {
    long val = 1;
    for(int i = 0; i < b.length; i++) {
        val = (pow(val, 10) * pow(a, b[i])) % 1337;
    }
    return (int)val;
}
public long pow(long a, int n) {
    if(n == 0) {
        return 1;
    }
    if(n == 1) {
        return a % 1337;
    }
    long tmp = pow(a, n/2);
    if(n % 2== 1) {
        return a * tmp * tmp % 1337;
    }
    return tmp * tmp % 1337;
}
