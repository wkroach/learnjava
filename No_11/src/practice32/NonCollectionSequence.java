/**
 * Following the example of MultiIterableClass,
 * add reversed() and randomized() methods to
 * NonCollectionSequence.java, as well as making
 * NonCollectionSequence implement Iterable, and
 * show that all the approaches work in foreach
 * statements.
 */
package practice32;
import java.util.*;

public class NonCollectionSequence extends IntSequence{
    public Iterable<Integer> iterator() {
        return new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {
                    private int cursor = 0;
                    @Override
                    public boolean hasNext() {
                        return cursor < ints.length;
                    }

                    @Override
                    public Integer next() {
                        if(cursor < 0 || cursor >= ints.length){
                            throw new UnsupportedOperationException();
                        }
                        return ints[cursor++];
                    }
                };
            }
        };
    }

        public Iterable<Integer> reverse() {
            return new Iterable<Integer>() {
                @Override
                public Iterator<Integer> iterator() {
                    return new Iterator<Integer>() {
                        private int cursor = ints.length - 1;

                        @Override
                        public boolean hasNext() {
                            return cursor >= 0;
                        }

                        @Override
                        public Integer next() {
                            return ints[cursor--];
                        }
                    };
                }
            };
        }
        public Iterable<Integer> randomized() {
            return new Iterable<Integer>() {
                @Override
                public Iterator<Integer> iterator() {
                    ArrayList<Integer> randomArr = new ArrayList<Integer>(Arrays.asList(ints));
                    Collections.shuffle(randomArr);
                    return randomArr.iterator();
                }
            };
        }

        public static void main(String[] args){
            NonCollectionSequence nonCollectionSequence = new NonCollectionSequence();
            //iterator()
            for(int i:nonCollectionSequence.iterator()){
                System.out.print(i + " ");
            }
            System.out.println();
            //reverse
            for(int i: nonCollectionSequence.reverse()){
                System.out.print(i + " ");
            }
            System.out.println();
            //randomnize
            for(int i: nonCollectionSequence.randomized()){
                System.out.print(i + " ");
            }
        }
}

class IntSequence{
    protected Integer[] ints = {1,2,3,4,5};
}


