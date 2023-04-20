import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class HashTable {

	public static Student[] hashTable = new Student[500];
	public static int size = 0;
	public static void main(String[] args) throws FileNotFoundException
	{
		//testing code written by nikki, tests the build, add and grow all at once by adding all names, then tests the search method
		HashTable test=new HashTable();
		File f=new File("StudentsNames.txt");
		Scanner scan=new Scanner(f);
		while(scan.hasNextLine())
		//for(int i=0;i<200;i++)
		test.add(scan.nextLine());
		System.out.println(test.size);
		System.out.println(test.hashTable[3].name+" hash= "+test.hashTable[3].gethash());
		
		System.out.println(" testing find for "+hashTable[3].name +" value: "+test.find(test.hashTable[3].name).name+" found at "+hashTable[3].gethash());
	}
	//Programmed by Thomas Powis
	public static boolean add(String input) {
		int newHash = hashCode(input);
		Student newStudent = new Student(input,newHash);
		newStudent.hash=hashCode(newStudent.name);
		hashTable[newStudent.gethash()] = newStudent;
		size++;
		return true;
	}
//resize method added by nikki for testinf purposes
	public static boolean resize() {
		Student[] next=new Student[hashTable.length*2];
		System.arraycopy(hashTable, 0, next, 0, hashTable.length);
		hashTable=next;
		return true;
	}

  //Jonathan's Changes
	public Student find(String input) {
		/*
		 * hash it
		 * if not there incremment by 1
		 * until you find it then return value
		 * when you find it return the string
		 * else return null
		 */
		//temporary search function added by nikki for testing,inefficient but should work,
		String[] nameArr=new String[hashTable.length];
		for(int i=0;i<hashTable.length;i++)
		{
			Student s=hashTable[i];
			if(s!=null)
			nameArr[i]=s.name;
			else
			{
				nameArr[i]="";
			}
		}
		int out=Arrays.binarySearch(nameArr, input);
		ArrayList<String> temp=new ArrayList<String>();
		for(String s:nameArr)
		temp.add(s);
		
		return hashTable[temp.indexOf(input)];
//		int hash = input.charAt(0) % hashTable.length;
//		System.out.print(hash);
//		for(int i = hash; i < hashTable.length; i++) {
//			if(hashTable[i]!=null&&hashTable[i].name.equalsIgnoreCase(input)) {
//				return hashTable[i];
//			}
//			else {
//				continue;
//			}
//		}
//		return null;
	}

	//Coded by Thomas Powis
	//Helper method for hashCode
	public static boolean isEmpty(int value) {
		if(hashTable[value] == null)
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


	

}
