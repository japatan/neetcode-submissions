class MinStack {
    // Main stack holds the actual values pushed by the user
    private Deque<Integer> stack;
    // minStack holds the running minimum at each corresponding 
    //position in the main stack
    private Deque<Integer> minStack;
    
    public MinStack() {
        // ArrayDeque used as a stack (push/pop/peek), 
        // faster than the legacy Stack class
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        // Always push the new value onto the main stack
        stack.push(val);

        // Figure out what the minimum is now that val has been added:
        // if minStack is empty, val is the only element so it's the min by
        // default;
        // otherwise compare val against the current min (top of minStack)
        int currentMin = minStack.isEmpty() ? val : Math.min(val, minStack.peek());

        // Push that minimum onto minStack, 
        // keeping it in lockstep with the main stack
        minStack.push(currentMin);        
    }
    
    public void pop() {
        // Remove the top value from the main stack
        stack.pop();
        // Remove the corresponding min entry too, so minStack's top
        // automatically "reverts" to the correct historical minimum
        minStack.pop();        
    }
    
    public int top() {
        // Just look at (don't remove) the top of the main stack
        return stack.peek();        
    }
    
    public int getMin() {
        // The top of minStack is always the minimum of everything currently in the
        // main stack
        return minStack.peek();        
    }
}
