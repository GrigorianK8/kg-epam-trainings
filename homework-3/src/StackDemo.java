public class StackDemo {
    public static void main(String[] args) {

        Stack stack = new Stack(3);

        System.out.println("Empty: " + stack.isEmpty());
        System.out.println("Size: " + stack.size());
        System.out.println("Stack: " + stack);

        System.out.println("----------------");

        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println("After push:");
        System.out.println("Stack: " + stack);
        System.out.println("Size: " + stack.size());
        System.out.println("Empty: " + stack.isEmpty());
        System.out.println("Full: " + stack.isFull());

        System.out.println("----------------");

        System.out.println("Peek: " + stack.peek());

        System.out.println("Stack after peek: " + stack);

        System.out.println("----------------");

        System.out.println("Pop: " + stack.pop());
        System.out.println("Stack after pop: " + stack);

        System.out.println("Pop: " + stack.pop());
        System.out.println("Stack after pop: " + stack);

        System.out.println("----------------");

        System.out.println("Size: " + stack.size());
        System.out.println("Full: " + stack.isFull());
    }
}
