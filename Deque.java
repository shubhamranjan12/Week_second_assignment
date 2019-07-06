import java.util.Iterator;

import java.util.NoSuchElementException;

// generic iterator
public class Deque<Item> implements Iterable<Item>
{
    private Node first;
    private Node last;
    private int s = 0;
    
    // Constructor
    public Deque()
    {
     
	}
	
	// to declare a node
    private class Node
	{
	Node prev = null;
	Item item;
	Node next = null;
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new CustomIterator();
	}
	
	// Iterator definition
	private class CustomIterator implements Iterator<Item> {

		private Node current = first;
		
		public CustomIterator() {
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public boolean hasNext() {
			
			return current != null;
		}
		
		@Override
		public void remove()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			
			final Item item = current.item;
			current = current.next;
			
			return item;		
		}
	}
	
	
	// to check whether empty
	public boolean isEmpty()
	{
		return first == null && last == null;
		
	}
	
	// get size
	public int size()
	{
		
		return s;
		
	}
	
	// dd an item at first
	public void addFirst(final Item item)
	{
		if (item == null) {
			throw new IllegalArgumentException();
		}
		this.s += 1;
		
		if (isEmpty())
		{
		first = new Node();
		first.item = item;
		first.prev = null;
		first.next =  null;
		
		last = first;
		
		}
		else
		{
			Node old = first;
			
			first = new Node();
			
			first.item = item;
			old.prev = first;
			first.next = old;
			first.prev = null;
			
		}
		
	}
	
	public void addLast(final Item item)
	{
		if (item == null) {
			throw new IllegalArgumentException();
		}
		
		this.s += 1;
		
		if (isEmpty())
		{
			
			first = new Node();
			first.item = item;
			first.prev = null;
			first.next =  null;
			
			last = first;
		}
		
		else
		{
			final Node old = last;
			
			last = new Node();
			
			last.item = item;
			old.next = last;
			last.prev = old;
			last.next = null;
		}
		
	}

    // remove and return the item from the front
    public Item removeFirst()
    {
    	if (first == null)
    	{
    		throw new NoSuchElementException();
    	}
    	
    	final Item item = first.item;
    	
    	if (this.s == 1)
    	{
    		
    		first = null;
    		last = null;
    	}
        
    	else
    	{
    	first = first.next;
    	}
    	
    	this.s -= 1;
    	
    	return item;
		
    	
    }

    // remove and return the item from the back
    public Item removeLast()
    {
    	if (first == null)
    	{
    		throw new NoSuchElementException();
    	}
    	
    	this.s -= 1;
    	final Item item = last.item;
    	
    	
    	if (first.next == null)
    	{
    		first = null;
    		last=null;
    	}
    	else
    	{
    	last = last.prev;
    	last.next = null;
    	}
    	
		return item;
    	
    }

  

    // unit testing (required)
    public static void main(String[] args)
    {
    	
//    	 Deque<Integer> deque = new Deque<Integer>();
//    	         deque.addLast(1);
//    	         deque.addLast(2);
//    	         System.out.println(deque.size());
//    	         deque.removeLast();     
//    	         deque.removeLast();     
//    	        
//    	         System.out.println(deque.isEmpty());        
////    	Deque<Integer> deque = new Deque<Integer>();
//    	         deque.addLast(1);
//    	         deque.addLast(2);
//    	         deque.addLast(3);
//    	         deque.addLast(4);
//    	         deque.addLast(5);
//    	         deque.addLast(6);
//    	         deque.addLast(7);
//    	         deque.addLast(8);
//    	         deque.addLast(9);
////    	         
//    	         System.out.println(deque.size());
//    	
//    	Deque<Integer> deque1 = new Deque<Integer>();
//    	         deque1.addFirst(1);
//    	         deque1.removeFirst();    
//    	         System.out.println(deque1.isEmpty()); 
//    	
//    	
    	
    	
    	
//    	Deque<String> dq = new Deque<>();
//    	//dq.iterator().remove();
//    	
//    	dq.addFirst("first");
//    	dq.addFirst("second");
//    	dq.addFirst("third");
//    	dq.addFirst("fourth");
//    	dq.addFirst("fifth");
//    	dq.addFirst("sixth");
//////    	
////    	
//    	dq.addLast("minus 1");
//    	dq.addLast("minus 2");
//    	dq.addLast("minus 3");
////    	
////    	
//    	System.out.println("****************");
//    	for(String str : dq) {
//			System.out.println(str);
//		}
////    	
////    	System.out.println("**********************");
////    	
////    	
//    	dq.removeLast();
//    	dq.removeLast();
//    	dq.removeLast();
//    	dq.removeLast();
//    	dq.removeLast();
//    	dq.removeLast();
//    	dq.removeLast();
//    	dq.removeLast();
//    	dq.removeLast();
//    	dq.removeLast();
//    	dq.removeLast();
//    	dq.removeLast();
////    	
////    	
////    	
////    	System.out.println();
////    	System.out.println();
////    	System.out.println();
////    	
////    	System.out.println("after removing");
////    	
////    	for(String str : dq) {
////			System.out.println(str);
////		}
////    	
////    	
////    	
//////    	dq.removeFirst();
//////    	dq.removeFirst();
////////    	dq.removeFirst();
//////    	dq.removeFirst();
//////    	dq.removeFirst();
//////    	dq.removeFirst();
//////    	dq.removeFirst();
////    	
////    	
////		}    	
////    	
    }
}

	
	



