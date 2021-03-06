import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class launchClient {

	public static void main(String[] args) {
			File config = new File ("config.txt");
			try {
				if (config.createNewFile()) {
					System.out.println("File created: " + config.getName());
				} else {
					
					List<String> addr = new ArrayList<String>();

					Scanner reader = new Scanner(config);
					while(reader.hasNextLine()) {
						addr.add(reader.nextLine());
					}
					
					System.out.println(addr);

					Infos infos = new Infos(addr.size());

					for (int i = 0; i < addr.size(); i++) {
						final int index = i;
						Thread th = new Thread(){
							public void run() {
								try {
									client client = new client(addr.get(index), 5000, index);
								} catch (ClassNotFoundException e) {	
									e.printStackTrace();
								}	
							}
						};
						th.start();
						System.out.println("Thread started");
					}		 

				new window();
			    	}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
