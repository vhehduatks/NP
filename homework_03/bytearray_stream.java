package homework_03;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class bytearray_stream {
    static void func1() throws Exception{
        Double val1= Math.random();
        Double val2= Math.random();
        System.out.println("val1 :"+val1+'\n'+"val2 :"+val2);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        dos.writeDouble(val1);
        dos.writeDouble(val2);
        dos.flush();

        byte[] byte_vals = bos.toByteArray();
        ByteArrayInputStream bis = new ByteArrayInputStream(byte_vals);
        DataInputStream dis = new DataInputStream(bis);

        for (int i=0;i<byte_vals.length;i++){
            System.out.print(byte_vals[i]+" ");
        }

        while(true){
            try {
                System.out.println("after convert :"+dis.readDouble());
            } catch (Exception e) {
                //TODO: handle exception
                break;
            }
        }


    }
}
