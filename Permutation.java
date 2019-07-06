import edu.princeton.cs.algs4.StdIn;


public class Permutation {
     public static void main(String[] args) {    	 
		RandomizedQueue<String> rq = new RandomizedQueue<>();
		
		for (int i = 0; i < Integer.parseInt(args[0]); ++i)
		{
			rq.enqueue(StdIn.readString());
		}
		
		for (int i = 0; i < Integer.parseInt(args[0]); ++i)
			System.out.println(rq.dequeue());
	}

}

