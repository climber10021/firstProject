


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public  class Bucket {
	
	private List<String> bucket = new ArrayList<String>();

	
	public synchronized void addRecord (String record)
	{
//		System.out.println ("** BEFORE IF ** Size before adding = " + bucket.size());
		while  (bucket.size() > 2)
		{
			try {
				System.out.println ("bucket is full waiting...");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		System.out.println ("Size before adding = " + bucket.size());
		bucket.add(record);
		notifyAll();
	}
	
	public synchronized String removeRecord ()
	{
		while (bucket.isEmpty() )
		{
			try {
				System.out.println ("bucket is EMPTY  waiting...");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println ("** Removing record size = " + bucket.size());
		String retVal = bucket.get(0);
				bucket.remove(0);
		notifyAll();
		return retVal;
	}
	

	
}