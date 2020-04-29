import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class OutputDecorator extends OutputStream {

    private BufferedWriter bw;

        public OutputDecorator(OutputStream o) {
        this.bw=new BufferedWriter(new OutputStreamWriter(o));

    }

    public void writeIni(Map<String, Map<String,String>> map) throws IOException {
            for(Map.Entry<String,Map<String,String>> i: map.entrySet()){
                bw.write("["+i.getKey()+"]");
                bw.write("\n");
                for(Map.Entry<String,String> j: i.getValue().entrySet()){
                    bw.write(j.getKey()+" = "+j.getValue());
                    bw.write("\n");
                }
            }
            bw.flush();
    }

    @Override
    public void write(int b) throws IOException {

    }

    @Override
    public void write(byte[] b) throws IOException {
        super.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        super.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        super.flush();
    }

    @Override
    public void close() throws IOException {
        super.close();
    }

}
