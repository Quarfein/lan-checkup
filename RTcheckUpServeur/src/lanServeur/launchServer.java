package lanServeur;

import java.net.UnknownHostException;

public class launchServer {

	public static void main(String[] args) throws UnknownHostException {
		while (true) {
			Server server = new Server(5000);
		}
	}
}
