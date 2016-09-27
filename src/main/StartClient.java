package main;

import connection.EstablishConnection;

public class StartClient {

	public static void main(String[] args) {
		EstablishConnection establishConnection = new EstablishConnection();
		establishConnection.init();
	}

}
