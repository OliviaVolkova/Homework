import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class UnmodificableCol<T>  extends AbstractCollection<T> implements Iterable<T> {

    protected int cursor;
    protected Object[] array;

    UnmodificableCol(Object[] array){
        this.cursor=0;
        this.array=array;
    }

    UnmodificableCol(UnmodificableCol<T> uc){
        UnmodificableCol uc2= new UnmodificableCol<T>(uc.array);
    }


    @Override
    public Iterator<T> iterator() {
        return new ColIterator<T>(array,cursor);
    }

    public int size(){
        return cursor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnmodificableCol<?> that = (UnmodificableCol<?>) o;
        return cursor == that.cursor &&
                Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(cursor);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }
    /*
    Main body of Unmodificable Collection
     */
    public class ColIterator<T> implements Iterator<T> {
        public int cursor;
        public Object[] a;

        ColIterator(Object[] a, int size) {
            this.a = a;
            this.cursor = 0;
        }

        public boolean hasNext() {
            return a.length > cursor;
        }

        public T next() {
            try {
                T t = (T) a[cursor];
                cursor++;
                return t;
            } catch (ArrayIndexOutOfBoundsException ex) {
                throw new java.util.NoSuchElementException();
            }
        }
        public int size(){
            return a.length;
        }
    }
    /*
     Iterator for Unmodificable Collection
     */
}
