import java.util.Date;

class Shape {
    private static int nextID = 1;  // Shared variable for auto-generated IDs
    private int shapeID;
    private Date creationTime;

    public Shape() {
        this.shapeID = nextID++;
        this.creationTime = new Date();
    }

    public int getShapeID() {
        return shapeID;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    @Override
    public String toString() {
        return "Shape ID: " + shapeID + "\nCreated on: " + creationTime;
    }
}

class Node {
    private Shape data;
    private Node next;

    public Node(Shape shape) {
        this.data = shape;
        this.next = null;
    }

    public Shape getData() {
        return data;
    }

    public void setData(Shape data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void insert(Shape shape) {
        Node newNode = new Node(shape);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public void displayShapes() {
        Node current = head;
        while (current != null) {
            System.out.println(current.getData().toString());
            current = current.getNext();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList shapeList = new LinkedList();

        // Creating some shapes
        Shape square = new Shape();
        Shape rectangle = new Shape();
        Shape triangle = new Shape();

        // Inserting shapes into the linked list
        shapeList.insert(square);
        shapeList.insert(rectangle);
        shapeList.insert(triangle);

        // Displaying shape details
        shapeList.displayShapes();
    }
}
