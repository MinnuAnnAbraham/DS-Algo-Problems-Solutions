class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> dequeue = new ArrayDeque<>();
        for(int  i = 0 ; i < deck.length; i++){
            dequeue.add(i);
        }
        int [] result = new int[deck.length];
        int i = 0;
        while(!dequeue.isEmpty()){
            int m = dequeue.poll();
            result[m] = deck[i++];
            if(!dequeue.isEmpty()){
                dequeue.add(dequeue.poll());
            }
        }
        return result;
    }
}