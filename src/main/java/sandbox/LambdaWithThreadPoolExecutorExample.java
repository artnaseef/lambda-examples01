package sandbox;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("Convert2Lambda")
public class LambdaWithThreadPoolExecutorExample {

	private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>());

	public static void main(String[] args) {
		LambdaWithThreadPoolExecutorExample mainObj = new LambdaWithThreadPoolExecutorExample();
		mainObj.instanceMain(args);
	}

	public void instanceMain(String[] args) {
		this.threadPoolExecutor.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("1");
			}
		});

		this.threadPoolExecutor.execute(() -> { System.out.println("2"); });

		Runnable runnable = () -> { System.out.println("3"); };

		this.threadPoolExecutor.execute(runnable);
		this.threadPoolExecutor.execute(runnable);

		this.threadPoolExecutor.shutdown();
	}
}
