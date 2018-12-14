/**
Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
Example 3:

Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
**/

public double myPow(double x, int n){
	if(x == 0){
                return 0.0;
        }
        if(n == 0){
                return 1.0;
        }
        double half = myPow(x, Math.abs(n / 2));;
        double res = (n % 2 == 0 ? half * half : half * half * x);
        if(n > 0){
            return res;
        }else{
            return 1.0 / res;
        }
}





















