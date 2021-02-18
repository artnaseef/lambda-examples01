package sandbox;

public class Main {
    public static void main(String[] args) {
        RunnableLambdaExample runnableLambdaExample = new RunnableLambdaExample();
        FunctionLambdaExample functionLambdaExample = new FunctionLambdaExample();
        LambdaExample01 lambdaExample01 = new LambdaExample01();
        LambdaWithThreadPoolExecutorExample lambdaWithThreadPoolExecutorExample = new LambdaWithThreadPoolExecutorExample();

        System.out.println("RUNNABLE EXAMPLES");
        System.out.println("=================");
        runnableLambdaExample.instanceMain(args);


        System.out.println("\n");

        System.out.println("FUNCTION EXAMPLES");
        System.out.println("=================");
        functionLambdaExample.instanceMain(args);


        System.out.println("\n");

        System.out.println("ORIGINAL EXAMPLES");
        System.out.println("=================");
        lambdaExample01.instanceMain(args);


        System.out.println("\n");

        System.out.println("THREAD POOL EXECUTOR EXAMPLE");
        System.out.println("============================");
        lambdaWithThreadPoolExecutorExample.instanceMain(args);
    }
}
