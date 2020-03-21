import java.util.*;

public class Map<K,V> extends AbstractMap<K,V> {
    List<Entry<K,V>> list;

    public Map(){
        list= new ArrayList<>();
    }


    public boolean containsKey(Object key){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getKey().equals(key)) return true;
        }
        return false;
    }
    /**
     *
     * @return true if this map contains a mapping for the specified key.
     */

    public boolean containsValue(Object value){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getValue().equals(value)) return true;
        }
        return false;
    }
    /**
     *
     * @return true if this map maps one or more keys to the specified value.
     */

    @Override
    public Set<Entry<K,V>> entrySet(){
        Set <Entry<K,V>> set= new HashSet<>();
        Iterator<Entry<K, V>> iterator=list.iterator();
        while (iterator.hasNext()){
            set.add(iterator.next());
        }
        return set;
    }
    /**
     *
     * @return a Set view of the mappings contained in this map.
     */


    public V get(Object key){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getKey().equals(key)){
                return list.get(i).getValue();
            }
        }
        return null;
    }
    /**
     *
     *@return the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     */


    public boolean	isEmpty(){
        if(list.size()==0){
            return true;
        }
        return false;
    }
    /**
     *
     * @return true if this map contains no key-value mappings.
     */

    public Set<K> keySet(){
        Set <K> set= new HashSet<>();
        Iterator<Entry<K,V>> iterator=list.iterator();
        while(iterator.hasNext()){
            set.add(iterator.next().getKey());
        }
        return set;
    }
    /**
     *
     * @return a Set view of the keys contained in this map.
     */

    public V put(K key, V value){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getKey().equals(key)){
                V oldValue=list.get(i).getValue();
                list.get(i).setValue(value);
                Entry<K,V> entry=new MyEntry(key, value);
                list.add(entry);
                return oldValue;

            }
        }
        return null;
    }
    /**
     *Associates the specified value with the specified key in this map (optional operation).
     *
     */


    public V remove(Object key){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getKey().equals(key)){
                V value= list.get(i).getValue();
                list.remove(i);
                return value;
            }
        }
        return null;
    }
    /**
     *Removes the mapping for a key from this map if it is present (optional operation).
     *
     */

    public int size(){
        return list.size();
    }
    /**
     *Returns the number of key-value mappings in this map.
     *
     */


    public Collection<V> values(){
        List<V> valist= new ArrayList<>();
        for(int i=0;i<list.size();i++){
            valist.add(list.get(i).getValue());
        }
        return valist;
    }
    /**
     *a Collection view of the values contained in this map.
     *
     */
}
