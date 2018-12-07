// Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
//
// You may assume that the intervals were initially sorted according to their start times.
//
// Example 1:
//
// Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
// Output: [[1,5],[6,9]]
// Example 2:
//
// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
// Output: [[1,2],[3,10],[12,16]]
// Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].


public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> res = new ArrayList<>();
    if(intervals.size() == 0){
        res.add(newInterval);
        return res;
    }
    int start = newInterval.start;
    int end = newInterval.end;
    boolean flag = false;

    for(int i=0; i<intervals.size(); i++){
        if(intervals.get(i).end < start){
            res.add(intervals.get(i));
        }else if(end < intervals.get(i).start){
            if(!flag){
                res.add(new Interval(start, end));
                flag = true;
            }
            res.add(intervals.get(i));
        }else{
            start = Math.min(start, intervals.get(i).start);
            end = Math.max(end, intervals.get(i).end);
        }
    }
    if(!flag) res.add(new Interval(start, end));
    return res;
}

public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> res = new ArrayList<>();
    if(intervals.size() == 0){
        res.add(newInterval);
        return res;
    }
    int start = newInterval.start;
    int end = newInterval.end;
    int left1 = 0;
    int right1 = intervals.size()-1;
    while(left1 <= right1){
        int mid = (left1 + right1) /2;
        if(intervals.get(mid).end < start){
            left1 = mid + 1;
        }else{
            right1 = mid-1;
        }
    }
    int left2 = 0;
    int right2 = intervals.size()-1;
    while(left2 <= right2){
        int mid = (left2 + right2)/2;
        if(intervals.get(mid).start <= end){
            left2 = mid + 1;
        }else{
            right2 = mid-1;
        }
    }

    for(int i=0; i<left1; i++){
        res.add(intervals.get(i));
    }
    int x = Math.min(start, left1<intervals.size()?intervals.get(left1).start:start);
    int y = Math.max(end, right2>=0?intervals.get(right2).end:end);
    res.add(new Interval(x,y));
    for(int i=right2+1; i<intervals.size();i++){
        res.add(intervals.get(i));
    }
    return res;
}
