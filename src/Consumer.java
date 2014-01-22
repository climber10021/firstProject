

public class Consumer implements Runnable {
	
	Bucket bucket;
	boolean dataReady = true;
	
	public Consumer(Bucket bucket)
	{
		this.bucket = bucket;
	}
	
	public void run() {
		
		while (dataReady)
		{
			String record = bucket.removeRecord();
			if (record.equals("EXIT"))
			{
				bucket.addRecord("EXIT");
				dataReady = false;
			}
			System.out.println ("Consumer ( " +  Thread.currentThread().getName() + " got => " +  record);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
