package sandbox;

public class RunnableLambdaExample {
	public static void main(String[] args) {
		RunnableLambdaExample mainObj = new RunnableLambdaExample();
		mainObj.instanceMain(args);
	}

	public void instanceMain(String[] args) {
		this.traditionalInlineRunnable();
		this.lambdaInlineRunnable();
		this.lambdaMethodReferenceRunnable();

		this.traditionalRunnableAssignment();
		this.lambdaRunnableAssignment();
		this.lambdaMethodReferenceAssignment();
	}

//========================================
// INLINE
//----------------------------------------

	private void traditionalInlineRunnable() {
		System.out.println("Traditional Runnable Inline");

		this.runSomething(new Runnable() {
			@Override
			public void run() {
				System.out.println("hello from inline custom Runnable");
			}
		});
	}

	private void lambdaInlineRunnable() {
		this.runSomething(() -> {
			System.out.println("hello from inline lambda");
		});
	}

	private void lambdaMethodReferenceRunnable() {
		this.runSomething(this::lambdaMethodReferenceRunnable_X);
	}

	private void lambdaMethodReferenceRunnable_X() {
		System.out.println("hello from method accessed via lambda method reference");
	}


//========================================
// ASSIGNMENT
//----------------------------------------

	private void traditionalRunnableAssignment() {
		System.out.println("Traditional Runnable Assignment");

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("hello from inline custom Runnable");
			}
		};

		runnable.run();
	}

	private void lambdaRunnableAssignment() {
		//
		// Create a Runnable class using assigned from a Lambda.
		//
		Runnable localRunnable = () -> {
			System.out.println("hello from lambda runnable assignment");
		};

		localRunnable.run();
	}

	private void lambdaMethodReferenceAssignment() {
		//
		// Create a Runnable class using assigned from a Method Reference.
		//
		Runnable localRunnable = this::lambdaMethodReferenceAssignment_X;

		localRunnable.run();
	}

	private void lambdaMethodReferenceAssignment_X() {
		System.out.println("hello from method accessed via lambda method reference");
	}


//========================================
// Helpers
//----------------------------------------

	/**
	 * Method that operates on any Runnable.
	 *
	 * @param runnable
	 */
	private void runSomething(Runnable runnable) {
		System.out.println("--- vvv about to run something vvv");
		runnable.run();
		System.out.println("--- ^^^ done running something ^^^");
	}
}
