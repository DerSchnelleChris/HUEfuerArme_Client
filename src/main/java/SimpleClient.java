import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Random;


public class SimpleClient {

	public static Color col = Color.WHITE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleClient c = new SimpleClient();
		c.Connect("136.243.18.61", 5000);
	}
	Socket clientSocket;
	
	
	
	public void Connect(String host, int port) {
		try {
			clientSocket = new Socket(host,port);
			
			//Random rnd = new Random();

			
			while (true) {
				Thread.sleep(5000);
				var dOut = new DataOutputStream(clientSocket.getOutputStream());
				String testnachricht = "Input Html Code";
				int r, g, b;
				//r = Integer.parseInt(JOptionPane.showInputDialog("R"));
				//g = Integer.parseInt(JOptionPane.showInputDialog("G"));
				//b = Integer.parseInt(JOptionPane.showInputDialog("B"));
				Farbauswahl();
				r = col.getRed();
				g = col.getGreen();
				b = col.getBlue();

				testnachricht = JOptionPane.showInputDialog(testnachricht);



				dOut.writeUTF(testnachricht); //blocks until sent
				dOut.writeInt(r);
				dOut.writeInt(g);
				dOut.writeInt(b);

				System.out.println("client sent: " + testnachricht);
			}
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Color Farbauswahl() {
		col = JColorChooser.showDialog(null, "Farbauswahl", null);
		return col;

	}
	
}
