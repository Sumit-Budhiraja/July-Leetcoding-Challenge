class MapSum {

    /** Initialize your data structure here. */
    private Node[] data;
    public MapSum() {
       data = new Node[25];
    }
    
    public void insert(String key, int val) {
        Node temp = data[key.charAt(0) - 'a'];
        if(temp == null) {
            temp = new Node();
            data[key.charAt(0)- 'a'] = temp;
        }
        // System.out.println(key.charAt(0) + " ** " + temp.val);
        for(int i = 1; i < key.length();  i++) {
            if(temp.child[key.charAt(i) - 'a'] == null) {
                Node newNode = new Node();
                temp.addNode(key.charAt(i), newNode);
                temp = newNode;
            } else {
                temp = temp.child[key.charAt(i) - 'a'];
            }
            // System.out.println(key.charAt(i) + " ** " + temp.val);
        }
        temp.val = val;
    }
    
    public int sum(String prefix) {
        Node temp = data[prefix.charAt(0) - 'a'];
        if(temp == null) {
            return 0;
        }
        // System.out.println(prefix.charAt(0) + " " + temp.val);
        for(int i = 1; i < prefix.length(); i++) {
            temp = temp.child[prefix.charAt(i) - 'a'];
            if(temp == null) {
                return 0;
            }
            // System.out.println(prefix.charAt(i) + " " + temp.val);
        }
        int rs = getValue(temp);
        
        return rs;
    }
    
    public int getValue(Node node) {
        if(node == null) {
            return 0;
        }
        int rs = node.val;
        for(Node iNode : node.child) {
            if(iNode != null) {
                rs += getValue(iNode);
            }
        }
        return rs;
    }
}

class Node {
    int val;
    Node[] child;
    public Node() {
        child = new Node[25];
    }
    
    public void addNode(char c, Node node) {
        child[c - 'a'] = node;
    }
    
    public void setValue(int val) {
        this.val = val;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */