package server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

class HttpReply implements Runnable {
    private Socket socket;
    private StringBuilder body;

    HttpReply(Socket s, StringBuilder body) {
        this.socket = s;
        this.body = body;
    }

    public void run() {
        try {
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println("HTTP/1.1 200 OK");
            ps.println("Date: Mon, 13 Aug 2024 12:28:53 GMT");
            ps.println("Server: Java");
            ps.println("Last-Modified: Wed, 13 Aug 2024 11:15:56 GMT");
            ps.println("Content-Length: " + body.length());
            ps.println("Content-Type: text/html");
            ps.println("Connection: Closed");
            ps.println();
            ps.println(body);
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}