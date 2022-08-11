import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		try {
			Socket s= new Socket("localhost",234);
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			System.out.println("Enter a number please : ");
			Scanner keyBoard = new Scanner(System.in);
			int nb = keyBoard.nextInt();
			os.write(nb);
			int resp = is.read();
			System.out.println("Response = "+resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
