package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.net.ServerSocketFactory;

public class main {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = ServerSocketFactory.getDefault().createServerSocket(8080, 10);
			StringBuilder body = new StringBuilder();
			body.append("<html><body><h1>Hello Lucas</h1></body></html>");
			while(true) {
				Socket socket = serverSocket.accept();
				Thread thread = new Thread(new HttpReply(socket, body));
				thread.start();
			}
			
		}catch(IOException error) {
			error.printStackTrace();
		}
	}
}
