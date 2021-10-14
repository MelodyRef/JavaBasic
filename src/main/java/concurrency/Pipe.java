package concurrency;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author Melody
 * @date 2021/8/12 9:15
 */
public class Pipe {
    static class ReaderThread extends Thread {
        private PipedReader pipedReader;

        public ReaderThread(PipedReader pipedReader) {
            this.pipedReader = pipedReader;
        }

        @Override
        public void run() {
            System.out.println("this is reader");
            int receive = 0;
            try {
                while ((receive = pipedReader.read()) != -1) {
                    System.out.println((char) receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class WriteThread implements Runnable {
        private PipedWriter pipedWriter;

        public WriteThread(PipedWriter pipedWriter) {
            this.pipedWriter = pipedWriter;
        }

        @Override
        public void run() {
            System.out.println("this is writer");
            int receive = 0;
            try {
                pipedWriter.write("1test2###");
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    pipedWriter.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        PipedWriter pipedWriter = new PipedWriter();
        PipedReader pipedReader = new PipedReader();
        pipedWriter.connect(pipedReader);
        Thread a = new Thread(new ReaderThread(pipedReader));
        a.start();
        new Thread(new WriteThread(pipedWriter)).start();
        System.out.println(a.getState());
    }
}
