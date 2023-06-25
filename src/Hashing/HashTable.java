package Hashing;

//provides functionality to a/the hash table data structure
//.computeHash(), insert(), search()
//Also, collision handling: getLinearProbIndex(),
//getQuadraticProbIndex(), getDoubleHash()
public class HashTable {
    private int size;
    private Entry[] table;
    private int index;

    private int computedHash;

    //default constructor
    public HashTable() {
    }

    public HashTable(int size) {
        setSize(size);
        table = new Entry[size];
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Entry[] getTable() {
        return table;
    }

    public void setTable(Entry[] table) {
        this.table = table;
    }

    public void computeHash(int key) {
        computedHash = key % size;
    }

    //
    public void insert(int key, Object value) {
        computeHash(key);
        index = computedHash;
        while (table[index] != null) {
            index = (index + 1) % size;//linear probing
        }
        table[index] = new Entry(key, value);
    }

    public Entry search(int key) {
        computeHash(key);
        index = computedHash;
        while (table[index] != null) {
            if (table[index].getKey() == key) {
                return table[index];
            }
            index = (index + 1) % size;
        }
        return null;
    }

    //Linear probing:
    //h(k,i) = (h1(k)+ i)mod m
    //h1(k)= k mod m
    public int getLinearProbIndex(int key, int i) {
        computeHash(key);
        return (computedHash + i) % size;
    }

    //Quadratic probing
    //h(k,i) = (h1(k)+i^2) mod m
    //h1(k) = k mod m
    public int getQuadraticProbIndex(int key, int i) {
        computeHash(key);
        return (computedHash + (i * i)) % size;
    }

    //Double hashing h(k,i) = (h1(k) + i h2(k))mod m
    //h1(k) = k mod m
    //h2(k) = 1 + (k mod m-1)
    public int getDoubleHash(int key, int i) {
        computeHash(key);
        int secondaryHash = 1 + (key % (size - 1));

        return (computedHash + (i * secondaryHash)) % size;
    }
}//end class