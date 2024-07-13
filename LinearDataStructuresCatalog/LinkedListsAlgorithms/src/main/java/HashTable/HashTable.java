package HashTable;

import common.HashNode;

import java.util.LinkedList;

public class HashTable {

    private LinkedList<HashNode>[] chainArray;
    private int numBuckets;
    private int size;

    public HashTable() {
        numBuckets = 10;
        chainArray = new LinkedList[10];
        for (int i = 0; i < numBuckets; i++) {
            chainArray[i] = new LinkedList<>();
        }
        size = 0;
    }

    int size() {
        return this.size;
    }

    boolean isEmpty() {
        return size() == 0;
    }

    private int getBucketIndex(String key) {
        return Math.abs(key.hashCode()) % numBuckets;
    }

    boolean isContainsKey(String key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<HashNode> bucket = chainArray[bucketIndex];

        for (HashNode node : bucket) {
            if (node.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    void insert(String key, int value) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<HashNode> bucket = chainArray[bucketIndex];

        for (HashNode node : bucket) {
            if (node.getKey().equals(key)) {
                node.setValue(value);
                return;
            }
        }
        size++;
        bucket.add(new HashNode(key, value));
    }

    void remove(String key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<HashNode> bucket = chainArray[bucketIndex];

        for (HashNode node : bucket) {
            if (node.getKey().equals(key)) {
                bucket.remove(node);
                size--;
                return;
            }
        }
        throw new RuntimeException("Não foi encontrado valor para: " + key);
    }

    Integer get(String key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<HashNode> bucket = chainArray[bucketIndex];

        for (HashNode node : bucket) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
        }
        throw new RuntimeException("Não foi encontrado valor para: " + key);
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.insert("key1", 1);
        hashTable.insert("key2", 2);
        try {
            hashTable.remove("key4");
        } catch (RuntimeException err) {
            System.out.println(err.getMessage());
        }

        System.out.println("Valor de \"key1\": " + hashTable.get("key1"));
        System.out.println("Valor de \"key2\": " + hashTable.get("key2"));
        try {
            hashTable.get("key3");
        } catch (RuntimeException err) {
            System.out.println(err.getMessage());
        }
    }
}