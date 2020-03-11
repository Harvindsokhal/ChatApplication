/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chattest;

import java.net.Socket;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Family
 */
public class PeerTest {
    /**
     * Test of Disconnect method, of class Peer.
     */
    @Test
    public void testDisconnect() {
        System.out.println("Disconnect");
        Peer instance = new Peer();
        instance.Disconnect();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showUsers method, of class Peer.
     */
    @Test
    public void testShowUsers() {
        System.out.println("showUsers");
        Peer instance = new Peer();
        instance.showUsers();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Peer.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Peer.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMessageToGUI method, of class Peer.
     */
    @Test
    public void testAddMessageToGUI() {
        System.out.println("addMessageToGUI");
        String message = "";
        Peer instance = new Peer();
        instance.addMessageToGUI(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMember method, of class Peer.
     */
    @Test
    public void testAddMember() {
        System.out.println("addMember");
        Socket s = null;
        Peer instance = new Peer();
        instance.addMember(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

     

    
    /**
     * Test of sendMessage method, of class Peer.
     */
    @Test
    public void testSendMessage() {
        System.out.println("sendMessage");
        String message = "";
        Peer instance = new Peer();
        instance.sendMessage(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
