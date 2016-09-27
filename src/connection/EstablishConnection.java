package connection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EstablishConnection {

	static final String HOST = "127.0.0.1";
	static final int PORT = 5000;
	
	private Socket socket;
	private InputStreamReader input;
	private OutputStreamWriter output;
	private BufferedReader in;
	private BufferedWriter out;
	
	public EstablishConnection() {
		
	}
	
	public void init() {
		try {
			socket = new Socket(HOST, PORT);
			System.out.println("Client connected to host : " + HOST + " - " + PORT);
			input = new InputStreamReader(socket.getInputStream());
			output = new OutputStreamWriter(socket.getOutputStream());
			in = new BufferedReader(input);
			out = new BufferedWriter(output);
			
			InputThread inputThread = new InputThread(socket, in);
			inputThread.start();
			OutputThread outputThread = new OutputThread(socket, out);
			outputThread.start();
		} catch (UnknownHostException e) {
			System.out.println("Client can't connect to host : " + HOST);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Impossible to instantiate socket on port : " + PORT);
			e.printStackTrace();
		}
	}
	
}
