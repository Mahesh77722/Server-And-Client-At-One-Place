import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try {
            ServerSocket sc=new ServerSocket(2777);
            Socket s=sc.accept();
            DataInputStream dis=new DataInputStream(s.getInputStream());
            DataOutputStream dos=new DataOutputStream(s.getOutputStream());
            InputStreamReader isr=new InputStreamReader(System.in);
            BufferedReader b =new BufferedReader(isr);
            String str="";String str1="";
            while (!str.equals("Stop")){
                str=dis.readUTF();
                System.out.println("Client Request :"+str);
                str1=b.readLine();
                dos.writeUTF(str1);
                dos.flush();
            }
            dos.close();
            s.close();
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

