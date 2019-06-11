package com.clc.coll.impl;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;
import java.util.Vector;

public class Demo {

	/**
	 * 			List l = new Arraylist() / new Vector() // new LinkedList () -- AB
	 * 			Arraylist al = new AL()
	 * 			LInkedList ll = new LL()/ 
	 * 			Vector v = new Vector()/Stack()
	 * 
	 * 
	 * 
	 * 			<?> --  null   -------- raw type
	 * 			<X> --  we can store anything which x or it's type  - type safe
	 * 			< ? super X> --  x and it's parents --- lower bound -- 
	 * 			< ? extends X> -- x and it's childs -- upper bound
	 * 			<> -- absent  -- anything which is object -- generic type
	 * 
	 * 			Note -- x can not be primitive here
	 * 						x can be any class/aclass/interface/array
	 * 						< > -- in this we will never be having .. implements
	 * @param args
	 */
	
	public static void main(String[] args) {

		Emp e1 = new Emp(1,"AAA");
		Emp e2 = new Emp(2,"AAA");
		
		
		Set<Emp> setOfEmps = new HashSet<Emp>();
		setOfEmps.add(e1);
		setOfEmps.add(e2);	
		
		System.out.println(setOfEmps.size());

		if(true)
			return;
		
		Vector<Integer> numList = new Vector<Integer>();
		numList.add(130);numList.add(150);numList.add(103);
		numList.add(130);numList.add(510);numList.add(140);
		//fillratio -- when to grow -- 100% and in case of vetor depends on 4th constructor 2nd param
		System.out.println("Using For loop");
		System.out.println(numList);
		for(int i=0;i<numList.size();i++) {
				if(numList.get(i)==103) {
					numList.set(i,Integer.parseInt(new StringBuffer(numList.get(i)+"").reverse().toString()));
				}
		}
		
		System.out.println("using foreach");
		for (Integer integer : numList) {
				System.out.println(integer);
		}
		
		System.out.println("using iterator");
		Iterator<Integer> numItr = numList.iterator();
		while(numItr.hasNext()) {
				Integer num  = numItr.next();
				System.out.println(num);
		}
		
		
		System.out.println("using listiterator");
		ListIterator<Integer> lnumItr = numList.listIterator();
		while(lnumItr.hasNext()) {
				Integer num  = lnumItr.next();
				System.out.println(num);
		}
		
		System.out.println("Using enumration -- vector/stack/hshtbl/props/dict");
		Enumeration<Integer> emrt = numList.elements();
		while(emrt.hasMoreElements()) {
			Integer num = emrt.nextElement();
			System.out.println(num);
		}
		
		
		
		System.out.println(numList);
		
		if(true)
			return ;
		//()  (int)  (colltn)
			 // trimtosize
			// ensurecapacity -- 
		
		Vector<Integer> numbers = new Vector<Integer>();//Array -- index -- get(index)
		//AB --  m -- X -- method overring
		
		numbers.add(10);  // new Integer(10);
		numbers.add(1250);numbers.add(1240);numbers.add(1230);
		numbers.add(1250);numbers.add(1420);numbers.add(4120);
		System.out.println(numbers);
		System.out.println(numbers.get(2));
		
		//peek  first last -- retrive 
		//poll  --first last -- remove+retrive
		//offer -- first last -- isPresent
		
		
		
		
		
	}

}



/**

	
	
	Types of cursors..
		
		Iterator  -- -- collection.iterator()   -- read/remove  -- frwr direction
					hasNext/next/remove 
					all collection implemented class but not on map directly
			ListIterator  list.listIterator()  -- read/remove/update/add -- bidirection
				hasNext/next/remove
				hasPrevious/previous
				nextIndex/previousIndex
				set/add/
				only on list implemented classes
				
		Enumration  legacy.elements()  -- read only  -- frwd direction
				hasmorelements
				nextelemnt
				on only legacy classes -- 
			


*/



class Emp{
	private int empId;
	private String empName;
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", empName=" + empName + "]";
	}
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean equals(Object obj) {
		Emp em  = (Emp)obj;
		return this.empId ==em.getEmpId() ;
	}
	
	@Override
	public int hashCode() {
		return 31*this.empId;
	}
	
	
	public Emp(int empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	
	
	
	
}


/***



	Use cases of the collection framework
		Arraylist --
				if frequent operations are searching and retrival
		LinkedList -- 
				frequent operations are insertion and deletion
		Vector --
				whenever you want synchronization 
		stack - - internal implementations -- filo -- lifo
		
		
		al -- 10,20,30
		al = collections.unmodifiableList(al)
		
		
		final al =  [10,20,30,40]
		
		
		
	1.two differenet objects -- may get
		same bucket..
			if hashcode is overriden
		differenet bucket
			hashcode is based on address -- object class has hashcode
	2. if two objects are equal by content equality..make sure
	their hashcode method produces same hash ..
	
	3. within an execution of an application , make sure..hashcode of an objects shud nt be changed..
	
	4. make sure -- -the elements that we are using for 
	hashcode generation purpose -- shud be immutable..
	
	5. if two objects are pointing to same location or equal by 
	ref equalality-- they will always be equal by content equalality
	
	6. if you are overridding..equals or hashcode -- make sure
	both methods are overriden and also both methods implementations are based on same fields..
	
	
	object classs hashcode code -- returns - -integer represenation of hex..
	object class equals -- performs ref comparison
	
	
	hashcode -- always returns integer value -- make sure to prime no -- as factorials will be less and your elements will
	get uniform... buckets..
	
	equals -- method return boolean
				equals methods will be called only after hash collision..
				
		
	

	
			
			
		
		
		
		

**/