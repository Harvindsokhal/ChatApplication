/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chattest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Harvind
 */
public class ServerThread extends Thread {

    ServerSocket server;
    Peer p;
    ArrayList<String> names = new ArrayList<>();

    public ArrayList<String> getList() {
        return names;
    }

    public void userList(String user) {
        names.add(user);
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
    public void run() {
        ExecutorService pool = Executors.newFixedThreadPool(500);
        while (true) {
            try {
                Socket connection = server.accept();
                p.addMember(connection);
                pool.execute(new ServerHandler(connection));
            } catch (IOException ex) {
                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException npe) {
                System.out.println("Hello");
                JOptionPane.showMessageDialog(null, "This port is not available, please choose something else");
                p.ResetStatus();
                p.chat_textarea.setText(null);
                p.users_online_textarea.setText(null);
                p.start_button.setEnabled(true);
                break;
            }
        }
    }

    class ServerHandler implements Runnable {

        Socket connect;

        public ServerHandler(Socket s) {
            connect = s;
        }

        @Override
        public void run() {

            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
                String username = in.readLine();
                names.add(username);
                System.out.println(names);

                if (username == null) {
                    return;
                }
                synchronized (names) {
                    if (!names.isEmpty() && !names.contains(username)) {
                        names.add(username);

                    }
                }

                while (true) {
                    String msg = in.readLine();
                    p.addMessageToGUI(msg);

                }

            } catch (IOException ex) {
                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
