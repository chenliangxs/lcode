/**
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

Example 1:

Input: 123
Output: "One Hundred Twenty Three"
Example 2:

Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
Example 4:

Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"

===================================
**/
public String numberToWords(int num) {
    if(num == 0) return "Zero";
    String[] digits = {"", "One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten", "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] tens = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    String[] level = {"","Thousand","Million","Billion"};
    String res = "";
    int lvl = 0;
    while(num > 0){
        int tmp = num % 1000;
        String part = translate(tmp, digits, tens);
        res = (part.equals("")) ? "" + res : (part + " " + level[lvl] + " ") + res;
        num /= 1000;
        lvl++;
    }
    return res.trim();
}
public String translate(int num, String[] digits, String[] tens){
    String res = "";
    int hundred = num / 100;
    res += ((hundred == 0) ? "" : digits[hundred] + " Hundred ");
    int ten = num % 100;
    if(ten < 20){
        res = res + digits[ten] + " ";
    }else{
        res = res + tens[ten/10] + " " + digits[ten % 10];
    }
    return res.trim();
}
