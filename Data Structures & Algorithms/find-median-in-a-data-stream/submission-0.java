class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>((a,b) -> b - a);
    }
    
    public void addNum(int num) {
        if(minHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }
        if(minHeap.size() > maxHeap.size()){
                maxHeap.offer(minHeap.poll());
        }else if(maxHeap.size() > minHeap.size() + 1){
                minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }else{
            return maxHeap.peek();
        }
    }
}
