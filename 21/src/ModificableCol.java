import java.util.*;

public class ModificableCol<T>  extends AbstractCollection<T> implements Iterable<T>{

    protected int cursor;
    protected Object[] array;

    ModificableCol(Object[] array){
        this.cursor=array.length;
        this.array=array;
    }

    ModificableCol(){
        this.cursor=0;
        array = new Object[100];
    }

    ModificableCol(ModificableCol<T> mc){
        ModificableCol mc2= new ModificableCol(mc.array);
    }

    @Override
    public boolean add(T e) {
        if(cursor == array.length){
            array = Arrays.copyOf(array,(array.length+1)*2);
        }
        array[cursor]=e;
        cursor++;
        return true;

    }
    /*
    Main body of Modificable Collection
     */


    @Override
    public Iterator<T> iterator() {
        return new MColIterator<T>(array,cursor);
    }

    public int size(){
        return cursor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModificableCol<?> that = (ModificableCol<?>) o;
        return cursor == that.cursor &&
                Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(cursor);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    public class MColIterator<T> implements Iterator<T> {
        public int cursor;
        public Object[] a;

        MColIterator(Object[] a, int size) {
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
        public boolean remove(Object e) {
            boolean fl=false;
            for(int i=0;i<cursor; i++){
                if(array[i]==e){
                    for(int j=i;j<cursor;j++){
                        array[j]=array[j+1];
                    }
                    fl=true;
                    break;
                }
            }
            return fl;
        }

        public int size(){
            return a.length;
        }
    }
    /*
    Iterator for Modificable Collection
     */
}
