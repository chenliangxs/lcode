Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

Example:

Input: 13
Output: 6 
Explanation: Digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.

===========================================
at each digit, if digit < 1 left part * order, digit = 1, count right, digit > 1.

23 1 13
22 1 00 -> 22199
21 1 00 -> 21 199
...
  0 1 00 ->   0 1 99

====================================

public int countDigitOne(int n) {
        int total = 0;
        int num = n;
        int order = 1;
        int right = 0;
        while(num > 0){
            int digit = num % 10;
            int left = num/10;
            num /= 10;
            if(digit < 1){
                total += left * order;
            }else if(digit == 1){
                total += left * order;
                total += (right + 1);
            }else{
                total += (left + 1) * order;
            }
            right = digit * order + right;
            order *= 10;
        }
        return total;
    }