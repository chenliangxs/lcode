/**
Given a nested list of integers represented as a string, implement a parser to deserialize it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Note: You may assume that the string is well-formed:

String is non-empty.
String does not contain white spaces.
String contains only digits 0-9, [, - ,, ].
Example 1:

Given s = "324",

You should return a NestedInteger object which contains a single integer 324.
Example 2:

Given s = "[123,[456,[789]]]",

Return a NestedInteger object containing a nested list with 2 elements:

1. An integer containing value 123.
2. A nested list containing two elements:
    i.  An integer containing value 456.
    ii. A nested list with one element:
         a. An integer containing value 789.
**/
public NestedInteger deserialize(String s) {
    Deque<NestedInteger> stack = new ArrayDeque<>();
    char[] chs = s.toCharArray();
    //stack.offerFirst(new NestedInteger());
    String val = "";
    for(int i = 0; i < chs.length; i++) {
        if(chs[i] == '[') {
            NestedInteger tmp = new NestedInteger();
            stack.offerFirst(tmp);
            val = "";
        } else if(chs[i] >= '0' && chs[i] <= '9') {
            val = val + chs[i];
        } else if(chs[i] == ',' || chs[i] == ']') {
            if(val.length() > 0) {
                stack.peekFirst().add(new NestedInteger(Integer.parseInt(val)));
            }
            if(chs[i] == ']'){
                if(stack.size() > 1) {
                    NestedInteger tmp = stack.pollFirst();
                    stack.peekFirst().add(tmp);
                }
            }
            val = "";

        } else {
            val = val + chs[i];
        }
    }

    return val.length() == 0 ? stack.peekFirst() : new NestedInteger(Integer.parseInt(val));
}
