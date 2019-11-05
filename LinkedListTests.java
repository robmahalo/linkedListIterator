package testcases;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import structures.LinkedList;

public class LinkedListTests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddFirstEmpty() {
		LinkedList<String> list = new LinkedList<String>();
		list.addFirst("Hello");
		assertTrue("size should be 1", list.size() == 1);
		assertTrue("Hello is first object", list.getFirst().equals("Hello"));
		
		}
	
		private static LinkedList<String> l1;
		private static LinkedList<String> l2;

		//Test: Create an empty LinkedList and tests its size
		public static void test1()
		{
			l1 = new LinkedList<String>();
			System.out.println("Empty Linked List created");
			System.out.println("Expected size: 0. Actual size: "+l1.size());
			System.out.println("TEST PASSED: "+(0==l1.size()));
			System.out.println();
		}

		//Test: Create a LinkedList with one element using the overloaded constructor
		public static void test2()
		{
			l2 = new LinkedList<String>("first");
			System.out.println("Linked List with a single element 'first' created");
			System.out.println("Expected size: 1. Actual size: "+l2.size());
			System.out.println("TEST PASSED: "+(1==l2.size()));
			System.out.println();
		}

		//Test: test the toString method
		public static void test3()
		{
			System.out.println("Actual state of the Linked List using the toString method");
			System.out.println("Expected String: head -> first -> |||. Actual String: "+l2);
			System.out.println("TEST PASSED: "+("head -> first -> |||".equals(l2.toString())));
			System.out.println();
		}

		//Test: Adds an element into l1, add it in the first position
		public static void test4()
		{
			l1.addFirst("first");
			System.out.println("Empty Linked List with a single element added after: ");
			System.out.println(l1);
			System.out.println("Expected size: 1. Actual size: "+l1.size());
			System.out.println("TEST PASSED: "+(1==l1.size()));
			System.out.println();
		}

		//Test: Adds an element into the last position
		public static void test5()
		{
			l1.addLast("second");
			System.out.println("Linked List with an element added to last position: ");
			System.out.println(l1);
			System.out.println("Expected size: 2. Actual size: "+l1.size());
			System.out.println("Expected last: second. Actual last: "+l1.getLast());
			System.out.println("TEST PASSED: "+(2==l1.size() && "second".equals(l1.getLast())));
			System.out.println();
		}

		//Test: Remove the first element by using the method remove() and giving it "first"
		public static void test6()
		{
			l1.remove("first");
			System.out.println("Linked List with first element removed: ");
			System.out.println(l1);
			System.out.println("Expected size: 1. Actual size: "+l1.size());
			System.out.println("Expected first: second. Actual first: "+l1.getFirst());
			System.out.println("TEST PASSED: "+(1==l1.size() && "second".equals(l1.getFirst())));
			System.out.println();
		}

		//Test: Trying to remove an element that doesn't exist
		public static void test7()
		{
			boolean removed = l1.remove("first");
			System.out.println("Linked List with same elements. It was tried to remove 'first' but it doesn't exist: ");
			System.out.println(l1);
			System.out.println("Expected size: 1. Actual size: "+l1.size());
			System.out.println("Expected result: false. Actual result: "+removed);
			System.out.println("Expected first: second. Actual first: "+l1.getFirst());
			System.out.println("TEST PASSED: "+(1==l1.size() && "second".equals(l1.getFirst()) && !removed));
			System.out.println();
		}

		//Test: Trying to remove a null object
		public static void test8()
		{
			boolean removed = l1.remove(null);
			System.out.println("Linked List with same elements. It was tried to remove a null object: ");
			System.out.println(l1);
			System.out.println("Expected size: 1. Actual size: "+l1.size());
			System.out.println("Expected result: false. Actual result: "+removed);
			System.out.println("Expected first: second. Actual first: "+l1.getFirst());
			System.out.println("TEST PASSED: "+(1==l1.size() && "second".equals(l1.getFirst()) && !removed));
			System.out.println();
		}

		//Test: Removing the only item and trying to remove another one after that. Then, we add again "first"
		public static void test9()
		{
			boolean removed1 = l1.remove("second");
			System.out.println("Linked List after removing 'second': ");
			System.out.println(l1);
			boolean removed2 = l1.remove("l");
			System.out.println("Linked List after trying to remove any other element: ");
			System.out.println(l1);
			System.out.println("Expected size: 0. Actual size: "+l1.size());
			System.out.println("Expected result for first remove: true. Actual result: "+removed1);
			System.out.println("Expected result for second remove: false. Actual result: "+removed2);
			System.out.println("TEST PASSED: "+(removed1 && !removed2));
			System.out.println();
		}

		//Test: using addLast for an empty LinkedList. The element should become head
		public static void test10()
		{
			l1.addLast("first");
			System.out.println("Linked List after 'first' was added again to the empty linked list using addLast: ");
			System.out.println("Expected first: first. Actual first: "+l1.getFirst());
			System.out.println("TEST PASSED: "+("first".equals(l1.getFirst()) && 1==l1.size()));
			System.out.println();
		}

		//Test: Looking for a certain element using contains()
		public static void test11()
		{
			boolean ans1 = l1.contains("second");
			boolean ans2 = l1.contains("first");
			System.out.println("Actual state of the Linked List:");
			System.out.println(l1);
			System.out.println("Looking for 'second' on the list. Expected result: false. Actual result: "+ans1);
			System.out.println("Looking for 'first' on the list. Expected result: true. Actual result: "+ans2);
			l1.addLast("second");
			System.out.println("'second' was added to the Linked List: ");
			System.out.println(l1);
			boolean ans3 = l1.contains("second");
			System.out.println("Looking for 'second' on the list. Expected result: true. Actual result: "+ans3);
			System.out.println("TEST PASSED: "+(!ans1 && ans2 && ans3));
			System.out.println();
		}

		//Test: Adding an element in the last and looking for a middle element
		public static void test12()
		{
			l1.addLast("third");
			System.out.println("Linked List after adding 'third' in the last index: ");
			System.out.println(l1);
			boolean ans = l1.contains("second");
			System.out.println("Looking for 'second' on the list (middle element). Expected result: true. Actual result: "+ans);
			System.out.println("TEST PASSED: "+(ans));
			System.out.println();
		}

		//Test: removing a middle element and removing the last element
		public static void test13()
		{
			boolean ans = l1.remove("second");
			System.out.println("Linked List after removing 'second' (middle element): ");
			System.out.println(l1);
			System.out.println("Expected result for remove: true. Actual result: "+ans);
			System.out.println("TEST PASSED: "+(ans && 2==l1.size()));
			System.out.println();
		}

		//Test: removing the last element
		public static void test14()
		{
			boolean ans = l1.remove("third");
			System.out.println("Linked List after removing 'third' (last element): ");
			System.out.println(l1);
			System.out.println("Expected result for remove: true. Actual result: "+ans);
			System.out.println("'second' and 'third' were added again to the list in that order using addLast");
			l1.addLast("second");
			l1.addLast("third");
			System.out.println("TEST PASSED: "+(ans));
			System.out.println();
		}

		//Test: Checking the index of an element that does exist
		public static void test15()
		{
			int index1 = l1.indexOf("first");
			int index2 = l1.indexOf("second");
			int index3 = l1.indexOf("third");
			System.out.println("Checking the indices of all the elements on the linked list");
			System.out.println("Expected index for 'first': 0. Actual index: "+index1);
			System.out.println("Expected index for 'second': 1. Actual index: "+index2);
			System.out.println("Expected index for 'third': 2. Actual index: "+index3);
			System.out.println("TEST PASSED: "+(index1==0 && index2==1 && index3==2));
			System.out.println();
		}

		//Test: Checking the index of an element that does not exist
		public static void test16()
		{
			int index1 = l1.indexOf("fourth");
			System.out.println("Checking the index of 'fourth'. That doesn't exist on the linked list");
			System.out.println("Expected index for 'fourth': -1. Actual index: "+index1);
			System.out.println("TEST PASSED: "+(index1==-1));
			System.out.println();
		}

		//Test: inserting an element before an element that exists using insertBefore
		public static void test17()
		{
			boolean ans = l1.insertBefore("beforeFirst", "first");
			System.out.println("Linked List after adding 'beforeFirst' before 'first' element: ");
			System.out.println(l1);
			System.out.println("TEST PASSED: "+(ans && l1.getFirst().equals("beforeFirst") && l1.size()==4));
			System.out.println();
		}

		//Test: inserting an element before an element that exists (not the head) using insertBefore 
		public static void test18()
		{
			boolean ans = l1.insertBefore("beforeSecond", "second");
			System.out.println("Linked List after adding 'beforeSecond' before 'second' element (not the head): ");
			System.out.println(l1);
			System.out.println("TEST PASSED: "+(ans && l1.indexOf("beforeSecond")==2 && l1.size()==5));
			System.out.println();
		}

		//Test: inserting an element before the last element using insertBefore 
		public static void test19()
		{
			boolean ans = l1.insertBefore("beforeThird", "third");
			System.out.println("Linked List after adding 'beforeThird' before 'third' element (last element): ");
			System.out.println(l1);
			System.out.println("TEST PASSED: "+(ans && l1.indexOf("beforeThird")==4 && l1.size()==6 && l1.getLast().equals("third")));
			System.out.println();
		}

		//Test: inserting an element before an element that does not exist using insertBefore 
		public static void test20()
		{
			boolean ans = l1.insertBefore("null", "fourth");
			System.out.println("Linked List after trying to add an element before 'fourth', which doesn't exist: ");
			System.out.println(l1);
			System.out.println("TEST PASSED: "+(!ans && l1.size()==6));
			System.out.println();
		}

		//Test: Getting the first element of a linked list with one element
		public static void test21()
		{
			String first = l2.getFirst();
			System.out.println("Initial state of a Linked List with only one element:");
			System.out.println(l2);
			System.out.println("Getting the first element. Expected: first. Actual: "+first);
			System.out.println("TEST PASSED: "+(first.equals("first")));
			System.out.println();
		}

		//Test: Getting the last element of a linked list with one element
		public static void test22()
		{
			String last = l2.getLast();
			System.out.println("Initial state of a Linked List with only one element:");
			System.out.println(l2);
			System.out.println("Getting the last element. Expected: first. Actual: "+last);
			System.out.println("TEST PASSED: "+(last.equals("first")));
			System.out.println();
		}

		//Test: Removing the first element from l2 (list with only one element)
		public static void test23()
		{
			System.out.println("Initial state of a Linked List with only one element:");
			System.out.println(l2);
			String removed = l2.removeFirst();
			System.out.println("Linked List after removing the first using removeFirst:");
			System.out.println(l2);
			System.out.println("TEST PASSED: "+(removed.equals("first") && l2.size()==0 && l2.getFirst()==null));
			System.out.println();
		}

		//Test: Removing the first element from an empty linked list
		public static void test24()
		{
			System.out.println("Initial state of an empty Linked List:");
			System.out.println(l2);
			String removed = l2.removeFirst();
			System.out.println("Trying to remove first on an empty linked list. Expect result: null. Actual result: "+removed);
			System.out.println("'first' was added again to this empty linked list after the test");
			l2.addFirst("first");
			System.out.println("TEST PASSED: "+(removed == null));
			System.out.println();
		}

		//Test: Removing the last element from l2 (list with only one element)
		public static void test25()
		{
			System.out.println("Initial state of a Linked List with only one element:");
			System.out.println(l2);
			String removed = l2.removeLast();
			System.out.println("Linked List after removing the last using removeLast:");
			System.out.println(l2);
			System.out.println("TEST PASSED: "+(removed.equals("first") && l2.size()==0 && l2.getLast()==null));
			System.out.println();
		}

		//Test: Removing the last element from an empty linked list
		public static void test26()
		{
			System.out.println("Initial state of an empty Linked List:");
			System.out.println(l2);
			String removed = l2.removeLast();
			System.out.println("Trying to remove last on an empty linked list. Expect result: null. Actual result: "+removed);
			System.out.println("TEST PASSED: "+(removed == null && l2.size()==0 && l2.getLast()==null));
			System.out.println();
		}
		
		//Test: Removing first from l1, the list with 6 elements
		public static void test27()
		{
			System.out.println("Initial state of a Linked List with six elements:");
			System.out.println(l1);
			String removed = l1.removeFirst();
			System.out.println("Linked List after removing the first using removeFirst:");
			System.out.println(l1);
			System.out.println("TEST PASSED: "+(removed.equals("first") && l1.size()==6 && l1.removeFirst()==null));
			System.out.println();
		}

		//Test: Removing last from l1, the list with 6 elements
		public static void test28()
		{
			System.out.println("Initial state of a Linked List with only one element:");
			System.out.println(l1);
			String removed = l1.removeLast();
			System.out.println("Linked List after removing the last using removeLast:");
			System.out.println(l1);
			System.out.println("TEST PASSED: "+(removed.equals("last") && l1.size()==6 && l1.removeLast()==null));
			System.out.println();
		}

		//Test: Removing first from l1, the list with 12 elements
		public static void test29()
		{
			System.out.println("Initial state of a Linked List with twelve elements:");
			System.out.println(l1);
			String removed = l1.removeFirst();
			System.out.println("Linked List after removing the first using removeFirst:");
			System.out.println(l1);
			System.out.println("TEST PASSED: "+(removed.equals("first") && l1.size()==12 && l1.removeFirst()==null));
			System.out.println();
		}

		//Test: Removing last from l1, the list with 12 elements
		public static void test30()
		{
			System.out.println("Initial state of a Linked List with only twelve elements:");
			System.out.println(l1);
			String removed = l1.removeLast();
			System.out.println("Linked List after removing the last using removeLast:");
			System.out.println(l1);
			System.out.println("TEST PASSED: "+(removed.equals("last") && l1.size()==12 && l1.removeLast()==null));
			System.out.println();
		}


		public static void main(String[] args)
		{
			//Method that runs all tests
			System.out.println("---- RUNNING ALL TESTS ----\n");
			test1();
			test2();
			test3();
			test4();
			test5();
			test6();
			test7();
			test8();
			test9();
			test10();
			test11();
			test12();
			test13();
			test14();
			test15();
			test16();
			test17();
			test18();
			test19();
			test20();
			test21();
			test22();
			test23();
			test24();
			test25();
			test26();
			test27();
			test28();
			test29();
			test30();
			
		}
}
