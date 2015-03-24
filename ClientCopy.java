import java.io.BufferedWriter;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.OutputStream;  
import java.io.OutputStreamWriter;  
import java.net.Socket;  
import java.util.Scanner;  
  
public class ClientCopy {  
    public static void main(String[] args) throws Exception {  
        
        if(args.length != 3) {
            System.out.println("Usage: java ClientCopy ($IP) ($PORT) (filename) ");
        } else {
            Scanner tc = new Scanner(System.in);  
            System.out.println("File:");  
            String fName = args[2];
              
            File f = new File("/home/ubuntu/workspace/socket-file/"+fName);  
            FileInputStream in = new FileInputStream(f);  
      
            Socket socket = new Socket(args[0], Integer.parseInt(args[1]));  
            OutputStream out = socket.getOutputStream();  
            OutputStreamWriter osw = new OutputStreamWriter(out);  
            BufferedWriter writer = new BufferedWriter(osw);  
            writer.write(f.getName()+"\n");  
            writer.flush();  
            int c;  
            while ((c = in.read()) != -1) {  
            System.out.println(c);  
            out.write(c);  
             }
         }  
    }  
}  