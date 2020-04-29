import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class InputDecorator extends InputStream {

    private BufferedReader br;

    public InputDecorator(InputStream o) {
        this.br=new BufferedReader(new InputStreamReader(o));
    }


    public Map<String, Map<String, String>> readIni() throws IOException {


        Map<String, Map<String,String>> map = new LinkedHashMap<>();
        Map<String,String> map2 = new LinkedHashMap<>();

        String s=null;
        String str=null;
        String[] str2=null;
        Map <String,String> mapclone;

        while((s=br.readLine())!=null){
            if(s.charAt(0)=='['){
                if(str!=null){
                    mapclone = new LinkedHashMap<>();
                    mapclone.putAll(map2);
                    map.put(str,mapclone);
                    map2.clear();
                }
               str=s.trim().substring(1,s.length()-1);

            }
            else{
                str2=s.split(" = ");
                map2.put(str2[0],str2[1]);
            }
        }
        map.put(str,map2);
        return map;
    }

    @Override
    public int read() throws IOException {
        return 0;
    }

    @Override
    public int read(byte[] b) throws IOException {
        return super.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return super.read(b, off, len);
    }

    @Override
    public long skip(long n) throws IOException {
        return super.skip(n);
    }

    @Override
    public int available() throws IOException {
        return super.available();
    }

    @Override
    public void close() throws IOException {
        super.close();
    }

    @Override
    public synchronized void mark(int readlimit) {
        super.mark(readlimit);
    }

    @Override
    public synchronized void reset() throws IOException {
        super.reset();
    }

    @Override
    public boolean markSupported() {
        return super.markSupported();
    }
}
