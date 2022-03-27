import java.util.ArrayList;
import java.util.List;

import lanClient.*;
public class main {

	public static void main(String[] args) {
		List<String> addr = new ArrayList<String>();

		List<Thread> threads = new ArrayList<Thread>();

		
		addr.add("127.0.0.1");

		Infos infos = new Infos(addr.size());
		
		for (int i = 0; i < addr.size(); i++) {
			final int index = i;
			Thread th = new Thread(){
				public void run() {
					synchronized(infos) {
					try {
						client client = new client(addr.get(index), 5000, index, infos);
					} catch (ClassNotFoundException e) {	
						e.printStackTrace();
					}
				}
				}
			};
			threads.add(th);
		}		 

		threads.forEach((th)->{
			th.start();
		});

		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			infos.getInfos();
		}

	}

}
