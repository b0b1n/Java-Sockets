import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServiceClient extends Thread{
	private int numero;
	private Socket client;
	
	public ServiceClient(Socket client, int numero ) {
		super();
		this.numero = numero;
		this.client = client;
	}

	@Override
	public void run() {
		try {
			InputStream is = client.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			OutputStream os = client.getOutputStream();
			PrintWriter pw = new PrintWriter(os,true);
			System.out.println("Connexion of client Num: "+numero);
			pw.println("You are the client Num: "+numero);
			while(true) {
				String req=br.readLine();
				pw.println("Length of what you wrote now is : "+req.length());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
