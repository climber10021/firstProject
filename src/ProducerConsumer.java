

public class ProducerConsumer {

	public static void main(String[] args) {
		Bucket bucket = new Bucket();
		
		Producer prod = new Producer(bucket);
		Consumer cons = new Consumer(bucket);
		
		Thread t_p1 = new Thread(prod);
		Thread t_p2 = new Thread(prod);
		Thread t_p3 = new Thread(prod);
//		Thread t_p4 = new Thread(prod);
//		Thread t_p5 = new Thread(prod);
		Thread t_c1 = new Thread(cons);
		Thread t_c2 = new Thread(cons);
		Thread t_c3 = new Thread(cons);
		Thread t_c4 = new Thread(cons);
		Thread t_c5 = new Thread(cons);
		
		t_p1.start();
		t_p2.start();
		t_p3.start();
//		t_p4.start();
//		t_p5.start();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t_c1.start();
		t_c2.start();
		t_c3.start();
		t_c4.start();
		t_c5.start();

	}

}
