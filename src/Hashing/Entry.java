package Hashing;

//Entry class encapsulates(key value pairs) and provides methods
//for setting and retrieving those pairs.
//Also, it abstracts internal structure, so Hashtable class can
//can concentrate on managing hash table itself.
public class Entry {
    private int key;
    private Object value;

    //default constructor
    public Entry() {
    }

    public Entry(int key, Object value) {
        setKey(key);
        setValue(value);
    }


    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}//end class
