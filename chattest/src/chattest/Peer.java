/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chattest;

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

    public void Disconnect() {
        try {
            sendMessage("Disconnected.");
            socket.close();
        } catch (Exception ex) {
            addMessageToGUI("Failed to disconnect.");
        }
        username_textfield.setEditable(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        users_online_textarea = new javax.swing.JTextArea();
        users_online_button = new javax.swing.JButton();
        disconnect_button = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(users_online_button, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(disconnect_button, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(send_textfield)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(send_button, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username_label)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(username_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(hostname_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(user_port_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(start_button, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(peer_port_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(connect_button, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(user_port_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(start_button, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(hostname_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(peer_port_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(connect_button, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(send_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(send_button, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                JOptionPane.showMessageDialog(null, "Empty Server Running");
                start_button.setEnabled(false);
//                chat_textarea.setText("Started connection \n");
            } catch (Exception ex) {
                Logger.getLogger(Peer.class.getName()).log(Level.SEVERE, null, ex);
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
                    chat_textarea.append("User alreaady eixsts enter a unique name");
                    username_textfield.setEditable(true);
                    user_port_textfield.setEditable(true);
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea chat_textarea;
    private javax.swing.JButton connect_button;
    private javax.swing.JButton disconnect_button;
    private javax.swing.JTextField hostname_textfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    protected javax.swing.JPanel jPanel1;
    protected javax.swing.JPanel jPanel2;
    protected javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField peer_port_textfield;
    private javax.swing.JButton send_button;
    private javax.swing.JTextField send_textfield;
    private javax.swing.JButton start_button;
    private javax.swing.JTextField user_port_textfield;
    private javax.swing.JLabel username_label;
    private javax.swing.JTextField username_textfield;
    private javax.swing.JButton users_online_button;
    private javax.swing.JTextArea users_online_textarea;
    // End of variables declaration//GEN-END:variables

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
            users_online_textarea.setText(name + "\n");
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

}
