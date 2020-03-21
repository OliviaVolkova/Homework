import java.util.Map;
import java.util.Objects;

public class MyEntry<K,V> implements Map.Entry<K, V>{

    private K key;
    private V value;

    MyEntry(K key, V value){
        this.key=key;
        this.value=value;
    }
    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        V value1=this.value;
        this.value=value;
        return value1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyEntry<?, ?> entry = (MyEntry<?, ?>) o;
        return Objects.equals(key, entry.key) &&
                Objects.equals(value, entry.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
