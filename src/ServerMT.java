import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMT extends Thread{
	private int nbClients;
	@Override
	public void run() {
		try {
			ServerSocket ss = new ServerSocket(456);
			while(true) {
				Socket s = ss.accept();
				++nbClients;
				new ServiceClient(s,nbClients).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ServerMT().start();
	}
}
