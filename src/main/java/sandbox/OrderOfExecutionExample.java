package sandbox;

public class OrderOfExecutionExample {
	public static void main(String[] args) {
		OrderOfExecutionExample mainObj = new OrderOfExecutionExample();
		mainObj.instanceMain(args);
	}

	public void instanceMain(String[] args) {
		Runnable runnable1 = () -> System.out.println("1");

		System.out.println("2");
		runnable1.run();

		System.out.println("3");
		Runnable runnable4 = () -> System.out.println("4");
	}
}
