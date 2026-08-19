class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String c : tokens) {
            if (c.equals("+")) {
                // int a = stack.pop();
                // int b = stack.pop();
                stack.push(stack.pop() + stack.pop());  // order doesn't matter for +
            } else if (c.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (c.equals("*")) {
                // int a = stack.pop();
                // int b = stack.pop();
                stack.push(stack.pop() * stack.pop());  // order doesn't matter for *
            } else if (c.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }
}
