import java.util.LinkedList;

public class HashTable {

	public static Student[] hashTable = new Student[500];

	public static boolean add(String input) {
		System.out.println(hashTable.length);
		int ascii = hashCode(input);
		Student tempStudent = new Student(input,ascii);
    
		hashTable[ascii] = tempStudent;

		//First take in input, 
		//Then calculate hashcode
		//Next create a student object of that hashCode
		//Finally add it to the table
		
		return false;
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


	public static int hashCode(String input) {
		//This is a double hashing function
		//First calculate hash of first value
		//Then search the hashTable for that value, if there is a collision probe the second value
		//After finding the correct ASCII value modulus the ascii to get the remainder
		//Return the remainder
		return -1;
	}


	public static void main(String[] args) {
		System.out.println();

	}

}
