package innerclass;

/**
 * @author Melody
 * @date 2021/8/4 9:54
 */

interface Selecotr {
    boolean end();

    Object current();

    void next();
}

public class Sequence {
    private Object items[];
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    private void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }

    public Selecotr selecotr() {
        return new SequenceSelector();
    }

    private class SequenceSelector implements Selecotr {
        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }
    }


    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(i);
        }
        Selecotr selecotr = sequence.selecotr();
        while (!selecotr.end()) {
            System.out.println(selecotr.current() + " ");
            selecotr.next();
        }
    }
}
