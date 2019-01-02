/**
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
**/

public int minMeetingRooms(Interval[] intervals) {
    Arrays.sort(intervals, new Comparator<Interval>() {
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    });
    int globalMax = 0;
    for(int i = 0; i < intervals.length; i++) {
        int count = 0;
        for(int j = 0; j <= i; j++) {
            if(intervals[j].end > intervals[i].start) {
                count++;
            }
        }
        globalMax = Math.max(globalMax, count);
    }
    return globalMax;
}
