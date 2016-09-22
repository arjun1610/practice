package com.interview;

import java.util.Arrays;

/**
 * author : varsh007
 * date: 12/28/15.
 */
class Node
{
    String data;
    Node left;
    Node right;
    Node (String data)
    {
        this.data=data;
    }
    public String getData()
    {
        return data;
    }
}
public class allPossibleInterpretations
{
    private static final String[] alphabet = {"", "a", "b", "c", "d", "e",
            "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
            "s", "t", "u", "v", "w", "x", "v", "z"};

    // Driver method to test above methods
    public static void main(String args[]) {

        // aacd(1,1,3,4) amd(1,13,4) kcd(11,3,4)
        // Note : 1,1,34 is not valid as we don't have values corresponding
        // to 34 in alphabet
        int[] arr = {1, 1, 3, 4};
        printAllInterpretations(arr);

        // aaa(1,1,1) ak(1,11) ka(11,1)
        int[] arr2 = {1, 1, 1};
        printAllInterpretations(arr2);

        // bf(2,6) z(26)
        int[] arr3 = {2, 6};
        printAllInterpretations(arr3);

        // ab(1,2), l(12)
        int[] arr4 = {1, 2};
        printAllInterpretations(arr4);

        // a(1,0} j(10)
        int[] arr5 = {1, 0};
        printAllInterpretations(arr5);

        // "" empty string output as array is empty
        int[] arr6 = {};
        printAllInterpretations(arr6);

        // abba abu ava lba lu
        int[] arr7 = {1, 2, 2, 1};
        printAllInterpretations(arr7);
    }

    public static Node createTree(int dataNumber, String parentString, int[] arr)
    {
        if (dataNumber>26)
            return null;
        String dataToStr = parentString + alphabet[dataNumber];
        Node root = new Node (dataToStr);
        if (arr.length != 0)
        {
            dataNumber = arr[0];
            int[] newArr = Arrays.copyOfRange(arr,1, arr.length);
            root.left = createTree(dataNumber, dataToStr, newArr);
            if (arr.length > 1)
            {
                dataNumber = arr[0]*10 + arr[1];
                newArr = Arrays.copyOfRange(arr, 2, arr.length);
                root.right = createTree(dataNumber, dataToStr, newArr);
            }
        }
        return root;
    }
    // To print out leaf nodes
    public static void printLeaf(Node root) {
        if (root == null)
            return;

        if (root.left == null && root.right == null)
            System.out.print(root.getData() + "  ");

        printLeaf(root.left);
        printLeaf(root.right);
    }
    // The main function that prints all interpretations of array
    static void printAllInterpretations(int[] arr) {

        // Step 1: Create Tree
        Node root = createTree(0, "", arr);

        // Step 2: Print Leaf nodes
        printLeaf(root);

        System.out.println();  // Print new line
    }
}
