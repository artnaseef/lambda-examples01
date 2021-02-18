package sandbox;

import java.util.function.Function;

@SuppressWarnings("Convert2Lambda")
public class FunctionLambdaExample {
	public static void main(String[] args) {
		FunctionLambdaExample mainObj = new FunctionLambdaExample();
		mainObj.instanceMain(args);
	}

	public void instanceMain(String[] args) {
		this.traditionalInlineFunction();
		this.lambdaInlineFunction();
		this.lambdaMethodReferenceFunction();

		this.traditionalFunctionAssignment();
		this.lambdaFunctionAssignment();
		this.lambdaMethodReferenceAssignment();
	}

//========================================
// INLINE
//----------------------------------------

	private void traditionalInlineFunction() {
		System.out.println("Traditional Function Inline");

		this.callSomething("tif", new Function<String, String>() {
			@Override
			public String apply(String name) {
				return "Hello " + name + " from tif-impl";
			}
		});
	}

	private void lambdaInlineFunction() {
		this.callSomething("lif", (name) -> {
			return "hello " + name + " from lif-inline";
		});
	}

	private void lambdaMethodReferenceFunction() {
		this.callSomething("lmrf", this::lambdaMethodReferenceFunction_X);
	}

	private String lambdaMethodReferenceFunction_X(String name) {
		return "hello " + name + " from lmrf_x";
	}


//========================================
// ASSIGNMENT
//----------------------------------------

	private void traditionalFunctionAssignment() {
		System.out.println("Traditional Function Assignment");

		Function<String, String> Function = new Function<String, String>() {
			@Override
			public String apply(String name) {
				return "hello " + name + " from tfa-impl";
			}
		};

		String result = Function.apply("tfa");

		System.out.println("FUNCTION RESULT = " + result);
	}

	private void lambdaFunctionAssignment() {
		//
		// Create a Function class using assigned from a Lambda.
		//
		Function<String, String> localFunction = (name) -> {
			return "hello " + name + " from lfa-inline";
		};

		String result = localFunction.apply("lfa");

		System.out.println("FUNCTION RESULT = " + result);
	}

	private void lambdaMethodReferenceAssignment() {
		//
		// Create a Function class using assigned from a Method Reference.
		//
		Function<String, String> localFunction = this::lambdaMethodReferenceAssignment_X;

		String result = localFunction.apply("lmra");
		System.out.println("FUNCTION RESULT = " + result);
	}

	private String lambdaMethodReferenceAssignment_X(String name) {
		return "hello " + name + " from lmra_X";
	}


//========================================
// Helpers
//----------------------------------------

	/**
	 * Method that operates on any Function.
	 *
	 * @param Function
	 */
	private void callSomething(String name, Function<String, String> Function) {
		System.out.println("-- vvv about to call a function vvv");
		String result = Function.apply(name);
		System.out.println("FUNCTION RESULT = " + result);
		System.out.println("--- ^^^ done calling a function ^^^");
	}
}
