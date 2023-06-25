package Hashing;

//Creates a Hashtable object, then iterates through the table performing the three
//collision handling methods inside the HashTable class and prints the results
public class Controller {
    public static void main(String[] args) {

        System.out.println("\n ");
        HashTable hashTable = new HashTable(10);
        hashTable.insert(13, "spongebob");
        hashTable.insert(9, "Patrick");
        hashTable.insert(43, "Sandy");
        hashTable.insert(53, "Squidward");
        hashTable.insert(30, "Gary");
        hashTable.insert(95, "mermaid man");

        Entry[] table = hashTable.getTable();

        for (int i = 0; i < table.length; i++) {
            Entry entry = table[i];
            if (entry != null) {
                int key = entry.getKey();
                Object value = entry.getValue();
                int linearIndex = hashTable.getLinearProbIndex(key, i);
                int quadraticIndex = hashTable.getQuadraticProbIndex(key, i);
                int doubleHashIndex = hashTable.getDoubleHash(key, i);

                System.out.println("Value: " + value + ", key: " + key);
                System.out.println("Linear: " + linearIndex);
                System.out.println("Quadratic " + quadraticIndex);
                System.out.println("DoubleHash: " + doubleHashIndex);
                System.out.println();
            }
        }
    }//end main
}//end class
