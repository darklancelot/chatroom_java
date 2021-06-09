package 聊天室;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

public class server {
	private HashSet<Socket> allsocket ;
	private ServerSocket serve ;
	public server() {
		try {
			serve = new ServerSocket(1100);
		} catch (IOException e) {
			e.printStackTrace();
		}
		allsocket = new HashSet<>();
}
	public void StartServe() throws IOException {
		while(true) {
		Socket socket = serve.accept();
		System.out.println("用户进入聊天室");
		allsocket.add(socket);
		Servethread t = new Servethread(socket);
		t.start();
}
}
	private class Servethread extends Thread{
		Socket socket;
		public Servethread(Socket socket) {
			this.socket = socket ;
		}
		public void run() {
			BufferedReader br = null;
			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				while(true) {
					String str  = br.readLine();

					sendMessageToAllClient(str);
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}	
		}
	}
	private void sendMessageToAllClient(String str) {
		for(Socket s : allsocket) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			bw.write(str);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		}
	}

	public static void main(String[] args) {
		server s = new server();
		try {
			s.StartServe();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
