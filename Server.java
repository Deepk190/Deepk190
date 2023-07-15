import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class Server {

   ServerSocket server;
   Socket socket;
   BufferedReader br;
   PrintWriter out;


   public Server() {
    
    try {

       server = new ServerSocket(7777);
       System.out.println("Server to acept to ready connection");
       System.out.println("Server is waiting...");
       socket = server.accept();
       
       br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

       out = new PrintWriter(socket.getOutputStream());

       startReading();
       startWriting();

    }
    catch(Exception e) {

      e.printStackTrace();
        
    }
   } 
   
  public void startReading() {
      
      Runnable r1 = ()-> {
         
         System.out.println("Reader started...");

         try {
            
            while(true) {
                String msg = br.readLine();
                 
                if(msg.equals("exit")) {

                    System.out.println("Client terminated the chat");
                    socket.close();
                    break;
                }

                System.out.println("Client : "+msg);
                    
            } 
            } catch (IOException e) {
          // TODO Auto-generated catch block
          //e.printStackTrace();
          System.out.println("Connection is closed");
      }

      };

      new Thread(r1).start();

  }

  public void startWriting() {
   
    Runnable r2 = ()-> {
     System.out.println("Writing...");  
     try {
      while(true && ! socket.isClosed()){
       
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
         
        String content = br1.readLine();
        out.println(content);
        out.flush();
           
          if(content.equals("exit")) {

            socket.close();
            break;
          }

      }

    }catch(Exception e) {

      //e.printStackTrace();
      System.out.println("Connection is closed");

    }


  };

  new Thread(r2).start();
}
  
  
public static void main(String[] args) {
     
System.out.println("This is server");

     new Server();

}

}