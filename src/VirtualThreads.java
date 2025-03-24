public class VirtualThreads {
    public static void main(String[] args) throws InterruptedException {
        var executor = java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor();

        // Virtual thread for performing a task
        executor.submit(() -> {
            System.out.println("This is a virtual thread!");
        });

        // Shutting down the executor after the task completes
        executor.shutdown();
    }
}
