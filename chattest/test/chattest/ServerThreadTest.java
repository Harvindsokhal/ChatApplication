/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chattest;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Family
 */
public class ServerThreadTest {
    
    /**
     * Test of run method, of class ServerThread.
     */    
    @Test(expected = ConnectException.class)
    public void SamePortEntered() throws IOException {
        System.out.println("run");
        Peer p = null;
        Socket socket = new Socket("localhost", 123);
        p.addMember(socket);
        p.addMember(socket);
        fail("Exception has not been caught");
    }
    
}
