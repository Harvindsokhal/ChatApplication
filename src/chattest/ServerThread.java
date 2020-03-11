/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chattest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;





/**
 *
 * @author Harvind
 */
public class ServerThread extends Thread {
    ServerSocket server;
    Peer p;
    ExecutorService pool;
    ArrayList<String> names = new ArrayList<>();
    String username;
    Boolean serverRunning;
    
    
   public ArrayList<String> getList() {
       return names;
   } 
   
   public void updateList(String user) {
       names.remove(user);
   }
   
    public void showUsers(){
        for (String name : names) {
            p.addUsernamToGUI(name+"\n");
            System.out.println(name);
        }
      
    }
   
    public void stopServer() throws IOException {
        p.sendMessage(p.username +": has disconnected");
        System.out.println(p.username);
        
        pool.shutdown();
        server.close();
        serverRunning = false;
    }

   
    
    public ServerThread(Peer p) {
        try {
            this.p = p;
            server = new ServerSocket(p.myport);
            System.out.println("Server started on " + p.myport);
        } catch (IOException ex) {
            System.out.println("> Port not available, try another port.");
        }
    }
    
    @Override
    public void run(){
         pool = Executors.newFixedThreadPool(500);
        
        while(true) {
            try {
                Socket connection = server.accept();
                serverRunning = true;
                p.addMember(connection);
                pool.execute(new ServerHandler(connection));
            } catch (IOException ex) {
                System.out.println(ex);
                break;
            }
        }
    }
    
   
class ServerHandler implements Runnable {
    BufferedReader in;
    Socket connect;
    
    public ServerHandler(Socket s) {
        connect = s;
    }

    @Override
    public void run() {
        
        try {
            in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
            username = in.readLine();
            names.add(username);
            System.out.println(names);
            
            if (username == null) {
                names.remove(username);
                return;
            }
            synchronized (names) {
                if (!names.isEmpty() && !names.contains(username)) {
                    names.add(username);
                    
                }
            }
            if (serverRunning == false) {
                updateList(username);
                
                
            }
            String msg = in.readLine();
            p.addMessageToGUI(msg + username+("Test"));
            
            
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
                
                try { 
                    connect.close(); } catch (IOException e) {}
            }
    }
}
}
