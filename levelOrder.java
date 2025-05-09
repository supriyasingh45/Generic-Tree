package GenericTress;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class levelOrder {
    public static class Node{
        int data;
        ArrayList<Node> children;

        Node(){
            children = new ArrayList<>();
        }

        Node(int val){
            data = val;
            children = new ArrayList<>();
        }
    }

    public static Node construct(int input[]){
        Node root = new Node(input[0]);

        Stack<Node> st = new Stack<>();
        st.push(root);

        for(int i = 1 ; i < input.length ; i++){
            if(input[i] == -1){
                st.pop();
            }else{
                Node newNode = new Node(input[i]);
                st.peek().children.add(newNode);
                st.push(newNode);
            }
        }
        return root;
    }

    public static void display(Node node){
        System.out.print(node.data + " -> ");
        for(Node child : node.children){
            System.out.print(child.data+" ");
        }
        System.out.println();

        for(Node child : node.children){
            display(child);
        }

    }

    

    public static void level(Node root){ //can use void
        Queue<Node> queuee = new ArrayDeque<>();
        queuee.add(root);

        while(queuee.size() > 0){
            Node fnode = queuee.remove();
            System.out.println(fnode.data+" ");
            for(Node child : fnode.children){
                queuee.add(child);
            }
        }

        System.out.println(".");
    }

    public static void main(String[] args){
        int[] input = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1, -1,90,-1 ,-1, 40, 100, -1, -1, -1};
        Node root = construct(input);
        //display(root);

        level(root);
    }
}
