import java.util.ArrayList;
import java.util.List;

import lanClient.*;
public class main {

	public static void main(String[] args) throws ClassNotFoundException {
		List<String> addr = new ArrayList<String>();
		
		addr.add("134.59.139.50");
		addr.add("127.0.0.1");
		
		addr.forEach((address)->{
			Thread th = new Thread(){
				public void run() {
					try {
						client client = new client(address, 5000);
					} catch (ClassNotFoundException e) {
						
						e.printStackTrace();
					}
				}
			};
			th.start();
		});		
		//client client = new client("127.0.0.1",5000);
	}

}
