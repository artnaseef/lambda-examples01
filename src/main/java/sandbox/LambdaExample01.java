package sandbox;

public class LambdaExample01 {
	public static void main(String[] args) {
		LambdaExample01 mainObj = new LambdaExample01();
		mainObj.instanceMain(args);
	}

	public void instanceMain(String[] args) {
		//
		// Simple lambda via assignment
		//
		Runnable localRunnable = () -> {
			System.out.println("hello from lamdba");
		};

		System.out.println("about to run lambda runnable vvv");
		localRunnable.run();
		System.out.println("about to run lambda runnable ^^^");
		System.out.println();


		//
		// Simple lambda as argument
		//
		this.runSomething(() -> { System.out.println("hello from inline argument lambda"); });
		System.out.println();


		//
		// Simple method reference as lambda argument
		//
		this.runSomething(this::methodExecutedViaLambda);
		System.out.println();
	}

	private void runSomething(Runnable runnable) {
		System.out.println("about to run something vvv");
		runnable.run();
		System.out.println("done running something ^^^");
	}

	private void methodExecutedViaLambda() {
		System.out.println("Hello from method executed via lambda");
	}
}
