import java.io.*;
import java.net.Socket;

public class ClientChatBox{
    public static void main(String[] args) {
        try {
            Socket s=new Socket("localhost",2777);
            DataInputStream dis=new DataInputStream(s.getInputStream());
            DataOutputStream dos= new DataOutputStream(s.getOutputStream());
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String mess="";
            String mes="";
            while (!mes.equalsIgnoreCase("Stop")){
             mes= br.readLine();
             dos.writeUTF(mes);
             dos.flush();
             mess=dis.readUTF();
                System.out.println("Server Send : " +mess);
            }
            dis.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
