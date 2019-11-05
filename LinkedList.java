package structures;

public class LinkedList<T>
{
	/////////////////////////////
	//         Properties      //
	/////////////////////////////
	private Node myHead;
	private int mySize;

	/////////////////////////////
	//         Methods         //
	/////////////////////////////

	/**
	 *  Default constructor that creates an empty linked list
	 *
	 *  <pre>
	 *  pre:  the linked list is empty
	 *  post: the linked list is empty
	 *  </pre>
	 */
	public LinkedList()
	{
		myHead = null;
		mySize = 0; //This is to track the size
	}

	/**
	 *  Constructor that creates a new linked list with a single 
	 *  node storing the T passed in
	 *
	 *  <pre>
	 *  pre:  myHead points to null (the linked list is empty)
	 *  post: myHead points to the only node in the linked list,
	 *        that node holding the T passed in
	 *  </pre>
	 *
	 *  @param datum an T to be inserted at the head of the
	 *         linked list
	 */
	public LinkedList(T datum)
	{
		myHead = new Node (datum);
		myHead.setNext(null);
		mySize = 1; //To keep track of the size, starts at 1 because of the parameter
	}

	/**
	 *  Adds a node to the head of the linked list; the special
	 *  condition of an empty linked list is handled without
	 *  special treatment since if myHead points to null, that
	 *  simply becomes the next node in the list, immediately
	 *  following the new entered node at the head of the list
	 *
	 *  <pre>
	 *  pre:  the linked list may be empty or contain one or
	 *        more nodes
	 *  post: the linked list contains one more node that has
	 *        been added to the beginning of the list
	 *  </pre>
	 *
	 *  @param node the node to be entered
	 */
	private void addFirst(Node node)
	{
		node.setNext(myHead);
		myHead = node;
	}

	/**
	 *  Adds a node to the head of the linked list; the special
	 *  condition of an empty linked list is handled without
	 *  special treatment since if myHead points to null, that
	 *  simply becomes the next node in the list, immediately
	 *  following the new entered node at the head of the list
	 *
	 *  <pre>
	 *  pre:  the linked list may be empty or contain one or
	 *        more nodes
	 *  post: the linked list contains one more node that has
	 *        been added to the beginning of the list
	 *  </pre>
	 *
	 *  @param datum the T used to create a new node to be 
	 *         entered at the head of the list
	 */
	public void addFirst(T datum)
	{
		Node node;

		node = new Node(datum);
		this.addFirst(node);
		mySize++; //Increments the size
	}

	/**
	 *  Adds a node to the tail of the linked list; the special
	 *  condition of an empty linked list is handled separately
	 *
	 *  <pre>
	 *  pre:  the linked list may be empty or contain one or
	 *        more nodes
	 *  post: the linked list contains one more node that has
	 *        been added to the end of the list
	 *  </pre>
	 *
	 *  @param node the node to be entered
	 */
	private void addLast(Node node)
	{
		Node lastNode;

		if(myHead==null)
		{
			this.addFirst(node);
		}
		else
		{
			lastNode  = this.getPrevious(null);
			lastNode.setNext(node);
			node.setNext(null);
		}
	}

	/**
	 *  Adds a node to the tail of the linked list; the special
	 *  condition of an empty linked list is handled separately
	 *
	 *  <pre>
	 *  pre:  the linked list may be empty or contain one or
	 *        more nodes
	 *  post: the linked list contains one more node that has
	 *        been added to the end of the list
	 *  </pre>
	 *
	 *  @param datum the T used to creat a new node to be 
	 *         entered at the tail of the list
	 */
	public void addLast(T datum)
	{
		Node node;

		node = new Node(datum);
		this.addLast(node);
		mySize++; //Adds one for the size
	}

	/**
	 *  Deletes a node from the list if it is there
	 *
	 *  <pre>
	 *  pre:  the list has 0 or more nodes
	 *  post: if the node to be deleted is in the list,
	 *        the node no longer exists in the list; the
	 *        node previous to the node to be deleted now
	 *        points to the node following the deleted node
	 *  </pre>
	 *
	 *  @param node the node to be deleted from the list
	 *
	 *  @return boolean indicating whether or not the node
	 *          was deleted
	 */
	private boolean remove(Node node)
	{
		//To remove the Node as a parameter, we can only remove it if it's not null
		//If it's null, it means it doesn't exist on the list
		if(node == null)
			return false;
		else {
			//First, we get the previous
			Node previous = this.getPrevious(node);
			//If the node to remove is the first one, we just change the head
			if(node == myHead)
				myHead = myHead.getNext();
			else //If not, we set the next of the previous equal to the next of the node to remove
				previous.setNext(node.getNext());
			return true;
		}
	}

	/**
	 *  Deletes a node from the list if it is there
	 *
	 *  <pre>
	 *  pre:  the list has 0 or more nodes
	 *  post: if the node to be deleted is in the list,
	 *        the node no longer exists in the list; the
	 *        node previous to the node to be deleted now
	 *        points to the node following the deleted node
	 *  </pre>
	 *
	 *  @param datum the T to be deleted from the list
	 *
	 *  @return boolean indicating whether or not the node
	 *          was deleted
	 */
	public boolean remove(T datum)
	{
		//Here, we first need to look for the node with the data
		Node toRemove = this.findNode(datum);
		//Then, we call the remove method for the given node
		boolean removed = this.remove(toRemove);
		if(removed) //If it was removed, we decrease the size
			mySize--;
		return removed;
	}

	/**
	 *  Find a node in the list with the same data as that passed in 
	 *
	 *  <pre>
	 *  pre:  the list has 0 or more nodes
	 *  post: list is unchanged
	 *  </pre>
	 *
	 *  @param datum the T for which a node is to be found 
	 *         in the list
	 *
	 *  @return null if a node with the given T datum is not in
	 *          the list, or the node if it does
	 */
	private Node findNode(T datum)
	{
		Node currentNode;
		T currentDatum;

		currentNode = myHead;
		currentDatum = null;

		while(currentNode != null)
		{
			currentDatum = (T) currentNode.getData();
			if(currentDatum.equals(datum))
			{
				return currentNode;
			}
			currentNode = currentNode.getNext();
		}
		return null;
	}

	/**
	 *  Determine if a node exists in the list with the same 
	 *  data as that passed in 
	 *
	 *  <pre>
	 *  pre:  the list has 0 or more nodes
	 *  post: list is unchanged
	 *  </pre>
	 *
	 *  @param datum the T for which a node is to be found 
	 *         in the list
	 *
	 *  @return false if a node with the given T datum is not in
	 *          the list, or true if it does
	 */
	public boolean contains(T datum)
	{
		//First, we look for a node that contains the given data
		Node node = this.findNode(datum);
		//If the node it's null, means it doesn't exist
		if(node == null)
			return false;
		else //Else, it exists
			return true;
	}

	/**
	 *  Determines the node that resides one closer to the
	 *  head of the list than the node passed in
	 *
	 *  <pre>
	 *  pre:  the list has 0 or more nodes
	 *  post: the list is unchanged
	 *  </pre>
	 *
	 *  @param node the node whose predecessor is being looked for
	 *
	 *  @return the node that resides one closer to the head of the
	 *          list than the node passed in
	 */
	private Node getPrevious(Node node)
	{
		Node currentNode;

		currentNode = myHead;
		
		//If there are no elements, just null
		if(currentNode == null)
		{
			return null;
		}

		if(currentNode.equals(node))
		{
			return null;
		}

		while(currentNode!=null && currentNode.getNext() != node)
		{
			currentNode = currentNode.getNext();
		}

		return currentNode;
	}

	/**
	 *  A new node is entered into the list immediately before
	 *  the designated node
	 *
	 *  <pre>
	 *  pre:  the list may have 0 or more nodes in it
	 *  post: if the beforeNode is not in the list, no change
	 *        takes place to the list; otherwise, the new
	 *        node is entered in the appropriate place
	 *  </pre>
	 *
	 *  @param node the node to be entered into the list
	 *  @param beforeNode the node before which the new node
	 *         is to be entered
	 *
	 *  @return boolean designating if the node was or was not
	 *          entered into list
	 */
	private boolean insertBefore(Node node, Node beforeNode)
	{
		//First, if beforeNode is null, it means it doesn't exist on the list
		if(beforeNode == null)
			return false;
		else {
			//Now, we need the Node previous to beforeNode
			Node previous = this.getPrevious(beforeNode);
			//If beforeNode is the head, it means we just add it in the first position
			if(beforeNode == myHead)
				this.addFirst(node);
			//Else, we add it next to previous but before beforeNode
			else {
				previous.setNext(node);
				node.setNext(beforeNode);	
			}
			return true;
		}
	}

	/**
	 *  A new node with datum is entered into the list immediately
	 *  before the node with beforeDatum, the designated node
	 *
	 *  <pre>
	 *  pre:  the list may have 0 or more nodes in it
	 *  post: if the node with beforeDatum is not in the list, 
	 *        no change takes place to the list; otherwise, a new
	 *        node is entered in the appropriate place with the 
	 *        T datum
	 *  </pre>
	 *
	 *  @param datum the T used to create the new node 
	 *         to be entered into the list
	 *  @param beforeDatum the datum of the node before which the 
	 *         new node is to be entered
	 *
	 *  @return boolean designating if the node was or was not
	 *          entered
	 */
	public boolean insertBefore(T datum, T beforeDatum)
	{
		//First, we need to look for the node with beforeDatum
		Node beforeNode = this.findNode(beforeDatum);
		//Then, we create a node with datum
		Node node = new Node(datum);
		//Then, we call for the method insertBefore for the node to add and beforeNode
		boolean added = this.insertBefore(node, beforeNode);
		if(added) //If the node was added, we increase the size
			mySize++;
		return added;
	}

	/**
	 *  print the list by converting the Ts in the list
	 *  to their string representations
	 *
	 *  <pre>
	 *  pre:  the list has 0 or more elements
	 *  post: no change to the list
	 *  </pre>
	 */
	public String toString()
	{
		String string;
		Node currentNode;

		currentNode = myHead;

		string = "head -> ";

		while(currentNode!=null)
		{
			string += currentNode.getData().toString()+ " -> ";
			currentNode = currentNode.getNext();
		}
		string += "|||";
		return string;
	}

	// ALSO!  Comment and implement the following methods.
	// !!!

	public int indexOf(T datum)
	{
		//To find the index of a certain data, we first need to now if it actually exists on the list
		Node node = this.findNode(datum);
		if(node == null) //If the node is null, it doesn't exist and we return -1
			return -1;
		else //Else, it exists, then we look for the index
		{
			//To find the index, we just start looping through the list until we match the nodes
			int index = 0;
			Node actual = myHead;
			while (true) //Infinite loop that will stop once we find it and we return it
			{
				if(actual == node) //If we found it, we return the given index
					return index;
				//If not, we update both index and actual node
				else {
					index++;
					actual = actual.getNext();
				}	
			}
			//The while will stop at some point because we know the node exists on the list.
			//If it doesn't exist, the first if runs and we return -1, so we don't have the trouble
			//of an actual infinite loop or any kind of exceptions for reaching the end of the list
		}
	}

	//Method that removes the first node and returns its data
	public T removeFirst()
	{
		if(myHead != null)
		{
			Node node = myHead;
			Node second = node.getNext();
			myHead = second;
			mySize--; //We decrease the size
			return (T) node.getData(); //Instead of returning the node, we return the data of the Node, makes more sense
		}
		else
			return null;
	}

	public T removeLast()
	{
		//To remove the last, we just get the previous of the last and assign the next as null
		//If the size is just 1, we're removing the head, so we can use just removeFirst
		if(mySize == 1)
			return removeFirst();
		//If the size is more than 1, we do the next
		else if(mySize > 1) {
			Node last = this.getPrevious(null);
			Node newLast = this.getPrevious(last);
			newLast.setNext(null); //Remove the last by setting the next to null
			mySize--; //We decrease the size
			return (T) last.getData(); //Returns the data of the last node removed
		}
		else
			return null;

	}

	//Method that returns the size of the Linked list
	public int size()
	{
		//We can just return mySize because it keeps updated in all the methods that change the list
		return mySize;
	}

	//Method that returns the data of the first
	public T getFirst()
	{
		if(myHead != null)
			return (T) myHead.getData();
		else
			return null;
	}

	//Method that returns the data of the last
	public T getLast()
	{
		Node last = this.getPrevious(null); //Asks for the last node
		if(last != null)
			return (T) last.getData();
		else
			return null;
	}

	//Method that changes whatever the first node has
	public void setFirst(T o)
	{
		//As I understand it, it actually changes the first node by replacing it
		//So, the size doesn't change but we replace myHead. If not, if we add it just in the first place
		//this method would be exactly the same as the one alled 'addFirst(T)'
		//First, if myHead is null, we just set it normally
		if(myHead == null)
			this.addFirst(o);
		else //Else, we replace it
		{
			Node second = myHead.getNext();
			Node newNode = new Node(o);
			newNode.setNext(second);
			myHead = newNode;
		}

	}

	//These next two methods are actually not needed
	//On the steps that we needed to change or get the head, we just did it directly
	private void setHead(Node node)
	{
		myHead = node;
	}

	private Node getHead()
	{
		return myHead;
	}

	private class Node 
	{
		///////////////////////////////////
		//           Properties          //
		///////////////////////////////////
		private T myData;
		private Node myNext;

		///////////////////////////////////
		//             Methods           //
		///////////////////////////////////

		/**
		 *  Default constructor for a node with null
		 *  data and pointer to a next node
		 */
		public Node()
		{
			myData = null;
			myNext = null;
		}

		/**
		 *  Constructor for a node with some T for
		 *  its data and null for a pointer to a next node
		 *
		 *  <pre>
		 *  pre:  a null node
		 *  post: a node with some T for its data and
		 *        null for a pointer to a next node
		 *  </pre>
		 *
		 *  @param datum an T for the node's data
		 */
		public Node(T datum)
		{
			myData = datum;
			myNext = null;
		}

		/**
		 *  Constructor for a node with some T for 
		 *  its data and a pointer to another node
		 *
		 *  <pre>
		 *  pre:  a null node
		 *  post: a node with some T for its data and
		 *        a pointer to a next node
		 *  </pre>
		 *
		 *  @param datum an T for the node's data
		 *  @param next the node that this node points to
		 */
		public Node(T datum, Node next)
		{
			myData = datum;
			myNext = next;
		}

		// Accessor methods
		public void setData(T datum)
		{
			myData = datum;
		}

		@SuppressWarnings("unchecked")
		public T getData()
		{
			return (T) myData;
		}

		public void setNext(Node next)
		{
			myNext = next;
		}

		public Node getNext()
		{
			return myNext;
		}
	}


}



