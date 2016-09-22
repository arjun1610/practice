package com.interview;


/**
 * Created by arjun on 3/1/16.
 */
public class CustomHashMapImpl<K,V> {
    private CustomEntry<K, V>[] table;
    private int capacity = 5;

    static class CustomEntry<K, V> {
        K key;
        V value;
        CustomEntry<K, V> next;

        public CustomEntry(K key, V value, CustomEntry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public K getKey()
        {
            return this.key;
        }
        public V getValue()
        {
            return this.value;
        }
    }
    public CustomHashMapImpl() {
        table = new CustomEntry[capacity];
    }

    public void put(K newKey, V data) {
        if (newKey == null) {
            return;
        }
        int hashCode = calcHash(newKey);
        CustomEntry<K, V> newEntry = new CustomEntry<>(newKey, data, null);
        if (table[hashCode] == null)
            table[hashCode] = newEntry;
        else
        {
            CustomEntry<K, V> prev = null;
            CustomEntry<K, V> current = table[hashCode];
            while (current != null) {
                if (current.getKey().equals(newKey)) {
                    if (prev == null) {
                        newEntry.next = current.next;
                        table[hashCode] = newEntry;
                        return;
                    } else {
                        newEntry.next = current.next;
                        prev.next = newEntry;
                        return;
                    }
                }
                //check this
                prev = current;
                current = current.next;
            }
            //check this
            prev.next = newEntry;
        }
    }
    public V get(K key)
    {
        int hash=calcHash(key);
        if(table[hash]==null)
            return null;
        else
        {
            CustomEntry<K,V> tempEntry=table[hash];
            if(tempEntry!=null)
            {
                if(tempEntry.getKey().equals(key))
                    return tempEntry.getValue();
                tempEntry=tempEntry.next;
            }
            return null;
        }
    }
    public boolean remove(K key)
    {
        int hash=calcHash(key);
        if(table[hash]==null)
            return false;
        else
        {
            CustomEntry<K, V> prev = null;
            CustomEntry<K, V> current = table[hash];
            while (current != null)
            {
                if (current.getKey().equals(key)) {
                    if (prev == null) {
                        table[hash] = table[hash].next;
                        return true;
                    } else {
                        prev.next = current.next;
                        return true;
                    }
                }
                //check this
                prev = current;
                current = current.next;
            }
            return false;
        }
    }
    private int calcHash(K key)
    {
           return Math.abs(key.hashCode())%capacity;
    }
    public void display()
    {
        for(int i=0;i<capacity;i++)
        {
            if(table[i]!=null)
            {
                CustomEntry<K,V> displayEntry=table[i];
                while(displayEntry!=null)
                {
                    System.out.println("Entry Key: " + displayEntry.getKey() + " Entry Value: " + displayEntry.getValue());
                    displayEntry=displayEntry.next;
                }
            }
        }
    }
}
