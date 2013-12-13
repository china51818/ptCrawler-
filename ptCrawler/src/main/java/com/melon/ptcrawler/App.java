package com.melon.ptcrawler;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000),0);
        server.createContext("/", new MyHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }
}
   class MyHandler implements HttpHandler {
       public void handle(HttpExchange t) throws IOException {
           InputStream is = t.getRequestBody();
           read(is); // .. read the request body
           String response = "This is the response";
           t.sendResponseHeaders(200, response.length());
           OutputStream os = t.getResponseBody();
//           String d=""+45;
           
           os.write(response.getBytes());
           os.close();
       }

    private void read(InputStream is) {
        System.out.println("+++++++++++++++++++++++++++");
    }
   }