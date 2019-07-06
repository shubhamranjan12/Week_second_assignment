import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int sz = 0;
    private Item[] s = (Item[]) new Object[1];
	private int number = 0;
	private int j = 0;
	
	public RandomizedQueue()
	{
		
	}
	
	public Iterator<Item> iterator()
	{ return new ReverseArrayIterator(); }
	
	private class ReverseArrayIterator implements Iterator<Item>
	{
	

	@Override
	public boolean hasNext() {
		 return j < number;
	}

	@Override
	public Item next() {
		if (j >= number)
			throw new NoSuchElementException();
		return s[j++];
	}
	
	
	}
	
	
	
	public boolean isEmpty()
	{
		return this.sz == 0;
		
	}
	
	public int size() {
		return sz;
		
	}
	
	public void enqueue(Item item)
	{
		if (item == null)
			throw new IllegalArgumentException();
	if (number == s.length) 
		resize(2 * s.length);
	this.sz += 1;
	s[number++] = item;
	}
	
	
	private void resize(int capacity)
	{
	Item[] copy = (Item[]) new Object[capacity];
	for (int k = 0; k < number; k++)
	copy[k] = s[k];
	s = copy;
	}
	
	 public Item dequeue()
	{
		int random;
		
		if (this.sz == 0)
			throw new NoSuchElementException();
		
		this.sz -= 1;
		
		random = StdRandom.uniform(0, number);
		
		Item item = s[random];

		s[random] = s[--number];
		
		s[number] = null;
		
		if (number > 0 && number == s.length/4) resize(s.length/2);
		return item;
		
		
	}
	
	public Item sample()
	{
		if (this.sz == 0)
			throw new NoSuchElementException();

		int random;
		random = StdRandom.uniform(0, number);
		
		
		return s[random];
		
	}
	
	public static void main(String[] args) {
		
		RandomizedQueue<String> rq = new RandomizedQueue<>();
		
		rq.enqueue("first");
		rq.enqueue("second");
		rq.enqueue("third");
		rq.enqueue("fourth");
		rq.enqueue("fifth");
		rq.enqueue("sixth");
		rq.enqueue("seventh");
		rq.enqueue("eighth");
		
		System.out.println(rq.size());
//		
//		for(String s:rq)
//			System.out.println(s);
		
		
//		System.out.println(rq.dequeue());
//		System.out.println("------------------------------------");
//		System.out.println(rq.dequeue());
//		System.out.println("------------------------------------");
//		System.out.println(rq.dequeue());
//		System.out.println("------------------------------------");
//		System.out.println(rq.dequeue());
//		System.out.println("------------------------------------");
//		System.out.println(rq.dequeue());
//		System.out.println("------------------------------------");
//		System.out.println(rq.dequeue());
//		System.out.println("------------------------------------");
//		System.out.println(rq.dequeue());
//		System.out.println("------------------------------------");
//		System.out.println(rq.dequeue());
//		System.out.println("------------------------------------");
//		System.out.println("extra");
//		System.out.println(rq.dequeue());
//		
//		for(int i=0;i<1000000000;++i)
//		System.out.println(rq.sample());
		

	}


}

