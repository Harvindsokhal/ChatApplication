/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chattest;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Harvind
 */
public class Peer extends javax.swing.JFrame {

    LocalTime time = LocalTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    String username, address = "localhost";
    ArrayList<Socket> users = new ArrayList();
    int peerport;
    public int myport;
    Boolean isConnected = false;

    Socket socket;
    BufferedReader reader;
    PrintWriter writer;
    ServerThread server;

    public Peer() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Foundation_Panel = new javax.swing.JPanel();
        Userlisl_Panel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        users_online_textarea = new javax.swing.JTextArea();
        users_online_button = new javax.swing.JButton();
        disconnect_button = new javax.swing.JButton();
        MainChat_Panel = new javax.swing.JPanel();
        connect_button = new javax.swing.JButton();
        peer_port_textfield = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        chat_textarea = new javax.swing.JTextArea();
        send_textfield = new javax.swing.JTextField();
        send_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        user_port_textfield = new javax.swing.JTextField();
        hostname_textfield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        username_label = new javax.swing.JLabel();
        username_textfield = new javax.swing.JTextField();
        start_button = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel4.setText("Users Online:");

        users_online_textarea.setEditable(false);
        users_online_textarea.setColumns(20);
        users_online_textarea.setLineWrap(true);
        users_online_textarea.setRows(5);
        jScrollPane3.setViewportView(users_online_textarea);

        users_online_button.setText("Show");
        users_online_button.setMaximumSize(new java.awt.Dimension(94, 32));
        users_online_button.setMinimumSize(new java.awt.Dimension(94, 32));
        users_online_button.setPreferredSize(new java.awt.Dimension(94, 32));
        users_online_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                users_online_buttonActionPerformed(evt);
            }
        });

        disconnect_button.setText("Disconnect");

        javax.swing.GroupLayout Userlisl_PanelLayout = new javax.swing.GroupLayout(Userlisl_Panel);
        Userlisl_Panel.setLayout(Userlisl_PanelLayout);
        Userlisl_PanelLayout.setHorizontalGroup(
            Userlisl_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Userlisl_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Userlisl_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(Userlisl_PanelLayout.createSequentialGroup()
                        .addGroup(Userlisl_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(Userlisl_PanelLayout.createSequentialGroup()
                                .addComponent(users_online_button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(disconnect_button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Userlisl_PanelLayout.setVerticalGroup(
            Userlisl_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Userlisl_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Userlisl_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(users_online_button, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(disconnect_button, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        connect_button.setText("Connect");
        connect_button.setPreferredSize(new java.awt.Dimension(58, 32));
        connect_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connect_buttonActionPerformed(evt);
            }
        });

        peer_port_textfield.setText("1234");
        peer_port_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peer_port_textfieldActionPerformed(evt);
            }
        });

        chat_textarea.setEditable(false);
        chat_textarea.setColumns(20);
        chat_textarea.setRows(5);
        jScrollPane1.setViewportView(chat_textarea);

        send_button.setText("Send");
        send_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_buttonActionPerformed(evt);
            }
        });

        jLabel1.setText("Host Port:");

        user_port_textfield.setText("1234");

        hostname_textfield.setText("localhost");

        jLabel2.setText("Peer Port:");

        username_label.setText("Username:");

        start_button.setText("Start");
        start_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                start_buttonActionPerformed(evt);
            }
        });

        jLabel3.setText("IP Address:");

        javax.swing.GroupLayout MainChat_PanelLayout = new javax.swing.GroupLayout(MainChat_Panel);
        MainChat_Panel.setLayout(MainChat_PanelLayout);
        MainChat_PanelLayout.setHorizontalGroup(
            MainChat_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainChat_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainChat_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainChat_PanelLayout.createSequentialGroup()
                        .addComponent(send_textfield)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(send_button, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(MainChat_PanelLayout.createSequentialGroup()
                        .addGroup(MainChat_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username_label)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainChat_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MainChat_PanelLayout.createSequentialGroup()
                                .addComponent(username_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))
                            .addGroup(MainChat_PanelLayout.createSequentialGroup()
                                .addComponent(hostname_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainChat_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MainChat_PanelLayout.createSequentialGroup()
                                .addComponent(user_port_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(start_button, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MainChat_PanelLayout.createSequentialGroup()
                                .addComponent(peer_port_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(connect_button, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MainChat_PanelLayout.setVerticalGroup(
            MainChat_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainChat_PanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(MainChat_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(user_port_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(start_button, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainChat_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(hostname_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(peer_port_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(connect_button, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainChat_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(send_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(send_button, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Foundation_PanelLayout = new javax.swing.GroupLayout(Foundation_Panel);
        Foundation_Panel.setLayout(Foundation_PanelLayout);
        Foundation_PanelLayout.setHorizontalGroup(
            Foundation_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Foundation_PanelLayout.createSequentialGroup()
                .addComponent(Userlisl_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainChat_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Foundation_PanelLayout.setVerticalGroup(
            Foundation_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Userlisl_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MainChat_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Foundation_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Foundation_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void users_online_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_users_online_buttonActionPerformed
        showUsers();
        // TODO add your handling code here:
    }//GEN-LAST:event_users_online_buttonActionPerformed

    private void start_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_start_buttonActionPerformed
        //String Cordinator = JOptionPane.showInputDialog("Do you want to Host?");
        //if (Cordinator.equals("yes")) {
        //System.out.println("You are the Cordinator");
        //    chat_textarea.setText("You are the Cordinator");
        //}
        if (username_textfield.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter a Username");
        } else {
            username_textfield.setEditable(false);
            user_port_textfield.setEditable(false);
            myport = Integer.parseInt(user_port_textfield.getText());
            try {
                server = new ServerThread(this);
                server.start();
                users_online_textarea.append(username_textfield.getText());
                start_button.setEnabled(false);
                chat_textarea.setText("Empty Server Running \n");
            } catch (Exception ex) {
                Logger.getLogger(Peer.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("error");
            }
        }
    }//GEN-LAST:event_start_buttonActionPerformed

    private void send_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_buttonActionPerformed
        String message = send_textfield.getText();
        if (!message.isEmpty()) {
            sendMessage(username + ": " + message + " (" + formatter.format(time) + ")");
            send_textfield.setText("");
            send_textfield.requestFocus();
        }
        send_textfield.setText("");
        send_textfield.requestFocus();
    }//GEN-LAST:event_send_buttonActionPerformed

    private void connect_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connect_buttonActionPerformed
        if (isConnected == false) {
            username = username_textfield.getText();
            peerport = Integer.parseInt(peer_port_textfield.getText());
            try {
                socket = new Socket(address, peerport);
                PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                ArrayList<String> names = server.getList();
                if (names.contains(username)) {
                    JOptionPane.showMessageDialog(null, "Username Already Taken");
//                    chat_textarea.append("User alreaady eixsts enter a unique name");
                    username_textfield.setEditable(true);
//                    user_port_textfield.setEditable(true);
                    socket.close();
                } else {
                    users.add(socket);
                    out.println(username);
                    out.flush();
                    chat_textarea.append(username + ":has connected.\n");
                }

            } catch (IOException ex) {
                System.out.println(ex);
            } catch (Exception ex) {
                sendMessage("Cannot Connect! Try Again.");
            }
        } else if (isConnected == true) {
            sendMessage("You are already connected.");
        }
    }//GEN-LAST:event_connect_buttonActionPerformed

    private void peer_port_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peer_port_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_peer_port_textfieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JPanel Foundation_Panel;
    protected javax.swing.JPanel MainChat_Panel;
    protected javax.swing.JPanel Userlisl_Panel;
    protected javax.swing.JTextArea chat_textarea;
    protected javax.swing.JButton connect_button;
    protected javax.swing.JButton disconnect_button;
    protected javax.swing.JTextField hostname_textfield;
    protected javax.swing.JLabel jLabel1;
    protected javax.swing.JLabel jLabel2;
    protected javax.swing.JLabel jLabel3;
    protected javax.swing.JLabel jLabel4;
    protected javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JScrollPane jScrollPane3;
    protected javax.swing.JTextField peer_port_textfield;
    protected javax.swing.JButton send_button;
    protected javax.swing.JTextField send_textfield;
    protected javax.swing.JButton start_button;
    protected javax.swing.JTextField user_port_textfield;
    protected javax.swing.JLabel username_label;
    protected javax.swing.JTextField username_textfield;
    protected javax.swing.JButton users_online_button;
    protected javax.swing.JTextArea users_online_textarea;
    // End of variables declaration//GEN-END:variables

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Peer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Peer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Peer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Peer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Peer().setVisible(true);
            }
        });
    }

    public void Disconnect() {
        try {
            sendMessage("Disconnected.");
            socket.close();
        } catch (Exception ex) {
            addMessageToGUI("Failed to disconnect.");
        }
        username_textfield.setEditable(true);
    }

    public void addMessageToGUI(String message) {
        chat_textarea.append(message + "\n");

    }

    public void addMember(Socket s) {
        users.add(s);

    }

    public void addUsernamToGUI(String username) {
        users_online_textarea.append(username + "\n");
        users_online_textarea.revalidate();
    }

    public void showUsers() {
        ArrayList<String> names = server.getList();
        for (String name : names) {
            users_online_textarea.append(name + "\n");
            users_online_textarea.revalidate();
        }

    }

    public void sendMessage(String message) {
        chat_textarea.append(message + "\n");
        chat_textarea.revalidate();
        try {
            for (Socket s : users) {
                PrintWriter p = new PrintWriter(s.getOutputStream());
                p.println(message);
                p.flush();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void ResetStatus() {
        username_textfield.setEditable(true);
        user_port_textfield.setEditable(true);
    }

}
