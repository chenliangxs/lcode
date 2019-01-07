/**
An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
     ↓
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
     ↓   ↓    ↓    ↓  ↓
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
     ↓   ↓    ↓
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example:

Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true
**/

class ValidWordAbbr {

    Map<String, Set<String>> map;

    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for(String s : dictionary) {
            if(s.length() == 0) {
                continue;
            }
            String tmp = s.charAt(0) + (s.length() > 2 ? (s.length() - 2) + "" : "") + (s.length() > 1 ? s.charAt(s.length() - 1) : "");
            if(!map.containsKey(tmp)) {
                map.put(tmp, new HashSet<String>());
            }
            map.get(tmp).add(s);
        }
    }

    public boolean isUnique(String word) {
        if(word.length() == 0) {
            return true;
        }
        String tmp = word.charAt(0) + (word.length() > 2 ? (word.length() - 2) + "" : "") + (word.length() > 1 ? word.charAt(word.length() - 1) : "");
        if(!map.containsKey(tmp)) {
            return true;
        }
        return map.get(tmp).contains(word) && map.get(tmp).size() == 1;
    }
}
