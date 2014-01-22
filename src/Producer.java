

public class Producer implements Runnable {
	
	Bucket bucket;
	
	public Producer(Bucket bucket)
	{
		this.bucket = bucket;
	}
	
	public void run() {
		
		for (int i=1 ; i<20; i++)
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String record = this.getClass() + "_" + Thread.currentThread().getName() + "_" + i;
			bucket.addRecord(record);
			System.out.println ("Producer adding = " + record);
		}
		
		System.out.println ("Producer sending last record");
		bucket.addRecord("EXIT");
	
	}
}
