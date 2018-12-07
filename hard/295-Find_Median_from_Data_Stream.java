
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
 

Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
 

Follow up:

If all integer numbers from the stream are between 0 and 100, how would you optimize it?
If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
=========================================================

class MedianFinder {
    
    PriorityQueue<Integer> leftHalf;
    PriorityQueue<Integer> rightHalf;

    /** initialize your data structure here. */
    public MedianFinder() {
        leftHalf = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer i, Integer j){
                return j - i;
            }
        });
        rightHalf = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(leftHalf.isEmpty() || leftHalf.peek() >= num){
            leftHalf.offer(num);
        }else{
            rightHalf.offer(num);
        }
        while(leftHalf.size() - rightHalf.size() > 1){
            rightHalf.offer(leftHalf.poll());
        }
        while(rightHalf.size() - leftHalf.size() > 1){
            leftHalf.offer(rightHalf.poll());
        }
    }
    
    public double findMedian() {
        if(leftHalf.isEmpty()) return 0.0;
        if(leftHalf.size() == rightHalf.size()){
            return (leftHalf.peek() + rightHalf.peek()) * 1.0 / 2;
        }else{
            return leftHalf.size() > rightHalf.size() ? 1.0 * leftHalf.peek() : 1.0 * rightHalf.peek();
        }
    }
}