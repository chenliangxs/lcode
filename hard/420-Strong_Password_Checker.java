/**
A password is considered strong if below conditions are all met:

It has at least 6 characters and at most 20 characters.
It must contain at least one lowercase letter, at least one uppercase letter, and at least one digit.
It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..." is strong, assuming other conditions are met).
Write a function strongPasswordChecker(s), that takes a string s as input, and return the MINIMUM change required to make s a strong password. If s is already strong, return 0.

Insertion, deletion or replace of any one character are all considered as one change.
**/

public int strongPasswordChecker(String s) {
    if(s.length() == 0) {
        return 6;
    }
    int res = 0;
    int upper = 1;
    int lower = 1;
    int digit = 1;
    char[] chs = s.toCharArray();
    int[] count = new int[chs.length];
    int left = 0;
    for(int i = 0; i < chs.length; i++) {
        if(chs[i] >= 'a' && chs[i] <= 'z') {
            lower = 0;
        } else if(chs[i] >= 'A' && chs[i] <= 'Z') {
            upper = 0;
        } else if(Character.isDigit(chs[i])) {
            digit = 0;
        }

        if(i == 0 || chs[i] == chs[i - 1]) {
            continue;
        } else {
            count[i - 1] = i - left;
            left = i;
        }
    }
    count[chs.length - 1] = chs.length - left;

    System.out.println(count[chs.length - 1]);

    int miss =  upper + lower + digit;


    if(chs.length < 6) {
        return Math.max(6 - chs.length, miss);
    }

    int over = Math.max(0, chs.length - 20);
    res += over;
    //System.out.println(over);
    for(int k = 1; k < 3; k++) {
        for(int i = 0; i < count.length && over > 0; i++) {
            if(count[i] < 3 || count[i] % 3 != (k - 1)) {
                continue;
            }
            count[i] -= Math.min(over, k);
            over -= k;
        }
    }

    int remain = 0;
    for(int i = 0; i < chs.length; i++) {
        if(over > 0 && count[i] >= 3) {
            int need = count[i] - 2;
            count[i] -= over;
            over -= need;
        }
        if(count[i] >= 3) {
            remain += count[i] / 3;
        }
        //System.out.println(remain);
    }
    return res += Math.max(remain, miss);
}
