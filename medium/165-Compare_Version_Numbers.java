/**
Compare two version numbers version1 and version2.
If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Example 1:

Input: version1 = "0.1", version2 = "1.1"
Output: -1
Example 2:

Input: version1 = "1.0.1", version2 = "1"
Output: 1
Example 3:

Input: version1 = "7.5.2.4", version2 = "7.5.3"
Output: -1

**/

public int compareVersion(String version1, String version2) {
	String[] v1 = version1.split("\\.");
	String[] v2 = version2.split("\\.");
	int i = 0;
	int j = 0;
	while(i < v1.length || j < v2.length) {
		if(i < v1.length && j < v2.length) {
			if(Integer.parseInt(v1[i]) == Integer.parseInt(v2[j])) {
				i++;
				j++;
			} else if(Integer.parseInt(v1[i]) > Integer.parseInt(v2[j])) {
				return 1;
			} else {
				return -1;
			}
		} else if(i < v1.length) {
			if(Integer.parseInt(v1[i]) > 0) {
				return 1;
			}
			i++;
		} else {
			if(Integer.parseInt(v2[j]) > 0) {
				return -1;
			}
			j++;
		}
	}
	return 0;
}
































