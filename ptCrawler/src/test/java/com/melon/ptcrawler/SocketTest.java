/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.melon.ptcrawler;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author 彭涛
 */
public class SocketTest {
    @Test
    public void df() throws IOException{
        Socket s=new Socket("www.baidu.com",980);
        Assert.assertNull(s.getRemoteSocketAddress());
    }
}
