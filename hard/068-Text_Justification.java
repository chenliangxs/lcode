Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
Example 1:

Input:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Example 2:

Input:
words = ["What","must","be","acknowledgment","shall","be"]
maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be",
             because the last line must be left-justified instead of fully-justified.
             Note that the second line is also left-justified becase it contains only one word.
Example 3:

Input:
words = ["Science","is","what","we","understand","well","enough","to","explain",
         "to","a","computer.","Art","is","everything","else","we","do"]
maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]



stringbuilder: sb

sb.size + nextwordsize <= maxwidth: add
sb.size + nextwordsize >maxwidth: 1. process string, 2. add to res, 3. sb empty(). 4. add new word.
 
end, if sb not empty, add


public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if(words.length == 0) return res;
        sb.append(words[0]);
        for(int k=1; k<words.length; k++){
            String s = words[k];
            if(sb.length() + s.length() + 1 <= maxWidth){              
                sb.append(" ");
                sb.append(s);
            }else{
                int emptySpace = maxWidth - sb.length();
                String[] currentWords = sb.toString().trim().split(" ");
                emptySpace += currentWords.length - 1;
                String temp = "";
                if(currentWords.length == 1){
                    temp += currentWords[0];
                    for(int i = 0; i < emptySpace; i++){
                        temp += " ";
                    }
                }else{
                    int count = emptySpace/(currentWords.length-1);
                    int extra = emptySpace % (currentWords.length-1);
                    for(int i = 0; i<currentWords.length; i++){
                        temp += currentWords[i];
                        if(i==currentWords.length - 1) continue;
                        for(int j=0; j<count; j++){
                            temp += " ";
                        }
                        if(i<extra){
                            temp += " ";
                        }
                    }
                }   
                res.add(temp);
                sb.setLength(0);
                sb.append(s);
            }
        }
        if(sb.length()>0){
            int extra = maxWidth - sb.length();
            for(int i=0; i<extra; i++) sb.append(" ");
            res.add(sb.toString());
        }
        return res;
    }


