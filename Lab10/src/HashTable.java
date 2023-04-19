import java.util.LinkedList;

public class HashTable {

	public static Student[] hashTable = new Student[500];
	public static int size = 0;
	
	//Programmed by Thomas Powis
	public static boolean add(String input) {
		int newHash = hashCode(input);
		Student newStudent = new Student(input,newHash);
		hashTable[newStudent.getHash()] = newStudent;
		size++;
		return true;
	}

	public static boolean resize() {
		return false;
	}

  //Jonathan's Changes
	public static Student find(String input) {
		/*
		 * hash it
		 * if not there incremment by 1
		 * until you find it then return value
		 * when you find it return the string
		 * else return null
		 */

		int hash = input.charAt(0) % hashTable.length;

		for(int i = hash; i < hashTable.length; i++) {
			if(hashTable[i].equals(input)) {
				return hashTable[i];
			}
			else {
				continue;
			}
		}
		return null;
	}

	//Coded by Thomas Powis
	//Helper method for hashCode
	public static boolean isEmpty(int value) {
		if(table[value] == null)
			return true;
		return false;
	}
	
	//Coded by Thomas Powis
	//Double hashing method
	//ChatGPT was used to help build this method
	//I coded a single hashing function then use chatGPT to help make it a double hashing function
	public static int hashCode(String hashInput) {
	    int hash = hashInput.charAt(0) % hashTable.length;
	    if (isEmpty(hash) == false) {
	        int second = hashInput.charAt(1) % hashTable.length;
	        // Preventing the probing stride from being 0
	        if (second == 0) {
	            second = 1;
	        }
	        int i = 1;
	        while (isEmpty(hash) == false) {
	            hash = (hash + i * second) % hashTable.length;
	            i++;
	            if (i >= hashTable.length) {
	                resize();
	                i = 1;
	            }
	        }
	    }
	    return hash;
	}


	public static void main(String[] args) {
		System.out.println();

	}

}
