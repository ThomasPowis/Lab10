
public class Student {
 	String name;
 	int hash;
 	boolean hashash=false;
 	public Student(String n, int h)
 	{
 		name=n;
 		hash=h;
 		hashash=true;
 	}
 	private int hashcode(String n)
 	{
 		return n.charAt(0);
 	}

 	public int gethash(String n)
 	{
 		if(hashash)
 		{
 			return hash;
 		}
 		else return hashcode(n);

 	}
 }