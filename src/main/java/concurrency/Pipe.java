package concurrency;

import java.io.*;

/**
 * @author Melody
 * @date 2021/8/12 9:15
 */
public class Pipe {
    static class ReaderThread extends Thread {
        private PipedInputStream inputStream;

        public ReaderThread(PipedInputStream inputStream) {
            this.inputStream = inputStream;
        }

        @Override
        public void run() {
            System.out.println("this is reader");
            int receive = 0;
            char ch;
            try {
                while ((receive = inputStream.read()) != -1) {
                    System.out.println((char)receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class WriteThread implements Runnable {
        private PipedOutputStream outputStream;

        public WriteThread(PipedOutputStream outputStream) {
            this.outputStream = outputStream;
        }

        @Override
        public void run() {
            System.out.println("this is writer");
            int receive = 0;
            try {
                outputStream.write("Hello Word".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        PipedOutputStream outputStream = new PipedOutputStream();
        PipedInputStream inputStream = new PipedInputStream();
        outputStream.connect(inputStream);
        Thread a = new Thread(new ReaderThread(inputStream));
        a.start();
        new Thread(new WriteThread(outputStream)).start();
        System.out.println(a.getState());
    }
}
