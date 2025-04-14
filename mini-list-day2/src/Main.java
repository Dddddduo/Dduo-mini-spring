public class Main {
    public static void main(String[] args) {

        // 头插法测试
        LinkedList list1 = new LinkedList();
        list1.insertAtHead(1);
        list1.insertAtHead(2);
        list1.insertAtHead(3);
        System.out.println(" 头插法结果：");
        list1.display();   // 输出：1 -> 2 -> 3 -> null

        // 尾插法测试
        LinkedList list2 = new LinkedList();
        list2.insertAtTail(1);
        list2.insertAtTail(2);
        list2.insertAtTail(3);
        System.out.println(" 尾插法结果：");
        list2.display();   // 输出：1 -> 2 -> 3 -> null
    }

}

// 节点定义类
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data  = data;
        this.next  = null;
    }
}

// 链表
class LinkedList {
    private Node head;  // 头节点
    private Node tail;  // 尾节点（仅尾插法需要）

    // 头插法实现
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;  // 首次插入需维护尾指针
        } else {
            newNode.next  = head;  // 新节点指向原头节点[1]()
            head = newNode;       // 更新头节点
        }
    }

    // 尾插法实现
    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next  = newNode;  // 原尾节点连接新节点[2]()
            tail = newNode;       // 更新尾指针
        }
    }

    // 打印链表
    public void display() {

        Node current = head;
        while (current != null) {
            System.out.print(current.data  + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}