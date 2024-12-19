//--------------------------------------------------------------
// Title: MyBinaryTree
// Author: Poyraz Koca
// Description: Represents a BINARY SEARCH TREE structure to store patients.
//--------------------------------------------------------------
public class MyBinaryTree {


    // Description: Defines a node in a binary search tree, holding a key-value pair consisting of a string key
    //and a Patient object value asz well as child node references.
    public class Node {
        String key;
        Patient value;
        Node left, right;

        public Node (String item, Patient patient) {
            key = item;
            value =patient;
            left = right = null;
        }}

    public interface NodeAction {
        void performAction(Node node);
    }
    Node root;

    void insert(String key,Patient value) {
        //--------------------------------------------------------------
        // Summary: Inserts a patient into the binary search tree.
        // Parameters: key -> The key (patient name) for insertion
//	    	             value -> The value (patient object) for insertion
        // Postcondition: The patient is inserted into the binary search tree.
        //--------------------------------------------------------------
        root = insertRec(root,key,value);
    }

    Node insertRec(Node root,String key, Patient value) {
        //--------------------------------------------------------------
        // Summary: Inserts a patient recursively into the binary search tree.
        // Parameters: root->  The root node of the binary search tree
//	    	             key->The key (patient name) for insertion
//	    	             value ->The value (patient object) for insertion
        if (root ==null){
            root = new Node(key,value);
            return root;
        }
        if(key.compareTo (root.key) < 0)
            root.left =insertRec(root.left, key, value);
        else if (key.compareTo( root.key) > 0)
            root.right =insertRec(root.right,key, value);

        return root;
    }

    void deleteKey (String key) {
        //--------------------------------------------------------------
        // Summary: Deletes a node with the specified key from the binary search tree.
        // Parameters: key ->The key(patient name) of the node to delete
        // Postcondition: If a node with the specified key exists, delete it  from the binary search tree.
        //--------------------------------------------------------------
        root =deleteRec(root,key);
    }

    Node deleteRec(Node root, String key) {
        //--------------------------------------------------------------
        // Summary: Deletes a node with the specified key from the binary search tree RECURSIVE MANNER
        // Parameters: root ->root node of BST
//	    	             key ->The key (patient name) of the node to delete
        // Postcondition: If a node with the specified key exists, deleted it from the binary search tree rooted at 'root'.
        //--------------------------------------------------------------

        if (root == null)
            return root;
        if(key.compareTo(root.key) <0)
            root.left = deleteRec(root.left, key);
        else if (key.compareTo(root.key) > 0)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
        }

        return root; }

    Patient search(String key ) {
        //--------------------------------------------------------------
        // Summary: Searches for a patient with the specified key in the binary search tree.
        // Parameters: key - The key (patient name) to search for
        // Returns: The patient object associated with the key if found, otherwise returns null.
        //--------------------------------------------------------------
        return searchRec(root,key);
    }

    Patient searchRec(Node root,String key){
        //--------------------------------------------------------------
        // Summary: Search forpatient with the key speciefied in the BST RECURSIVE MANNER
        // Parameters: root -> The root node of the binary search tree
//	    	             key -> The key (patient name) to search for
        // Returns: The patient object associated with the key if found, otherwise returns null.
        //--------------------------------------------------------------
        if (root == null ||root.key.equals(key) )
            return root == null ? null : root.value;

        if (root.key.compareTo(key) >0 )
            return searchRec(root.left,key) ;

        return searchRec(root.right, key);
    }
    void inOrderTraversal(Node node, String doctorName) {
        //--------------------------------------------------------------
        // Summary: Performs an inorder traversal of BST and print patients associated with their doctor
        // Parameters: node -> The root node of the binary search tree
//	    	             doctorName -: The name of the doctor to filter patients by
        // Postcondition: Patient information with his/her doctor is printed.
        //--------------------------------------------------------------
        if (node !=null){
            inOrderTraversal(node.left,doctorName);
            if(node.value.doctorName.equals(doctorName)) {
                System.out.println(node.value);}

            inOrderTraversal(node.right, doctorName);
        }	 }

    // This method calls InorderRec()
    void inOrderTraversal (String doctorName) {
        //--------------------------------------------------------------
        // Summary: Performs an in-order traversal of the binary search tree to print patients associated with a specific doctor.
        // Parameters: doctorName - The name of the doctor to filter patients by
        // Postcondition: Patient information associated with the specified doctor is printed.
        //--------------------------------------------------------------
        inOrderTraversal(root,doctorName);
    }
    void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.value);
            inOrderTraversal(node.right);
        }
    }void inOrderTraversal() {
        //--------------------------------------------------------------
        // Summary: Performs an inorder traversal of the BST
        // Parameters: node - The root node of the binary search tree
        // Postcondition: Patient information is printed in ascending order of patient names.
        //--------------------------------------------------------------
        inOrderTraversal(root);
    }  public void inOrderTraversal(NodeAction action) {
        //--------------------------------------------------------------
        // Summary: Performs an inorder traversal of BST and applies a custom action to each node.
        // Parameters: action -> The action to perform on each node during traversal
        // Postcondition: The specified action is applied to each node in the BST
        //--------------------------------------------------------------

        inOrderTraversal(root, action );
    }

    private void inOrderTraversal(Node node,NodeAction action) {
        //--------------------------------------------------------------
        // Summary:Performs an inorder traversal of the binary search tree and applies a custom action to each node recursively.
        // Parameters: node ->The root node of the binary search tree
//	    	             action-> The action to perform on each node during traversal
        // Postcondition:The specified action is applied to each node in the binary search tree.
        //--------------------------------------------------------------
        if (node != null){
            inOrderTraversal(node.left,action);
            action.performAction(node);
            inOrderTraversal(node.right, action);
        }  }
}
