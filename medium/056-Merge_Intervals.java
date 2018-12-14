/**

Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

**/

public List<Interval> merge(List<Interval> intervals){
	List<Interval> res = new ArrayList<>();
	if(intervals.size() < 2){
		return intervals;
	}
	Collections.sort(intervals, new Comparator<Interval>(){
		public int compare(Interval i1, Interval i2){
			return i1.start - i2.start;
		}
	});
	int start = intervals.get(0).start;
	int end = intervals.get(0).end;
	for(int i = 1; i < intervals.size(); i++){
		Interval cur = intervals.get(i);
		if(cur.start <= end){
			end = Math.max(end, cur.end);
			continue;
		}else{
			res.add(new Interval(start, end));
			start = cur.start;
			end = cur.end;
		}
	}
	res.add(new Interval(start, end));
	return res;
}















