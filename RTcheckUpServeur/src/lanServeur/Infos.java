package lanServeur;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.Serializable;
import java.lang.management.ManagementFactory;
import java.util.regex.*;

public class Infos implements Serializable{
	
	private String hostName;
	private String os;
	private File disk;
	private long diskSize;
	private long freeDiskSpace;
	private long ram;
	private float freeRam;
	private String cpuName;
	private String cpuFrequency;
	private double cpuLoad;
	private String cpuTemp;
	
	
	public Infos() throws UnknownHostException {
		hostName = InetAddress.getLocalHost().getHostName();
		os = System.getProperty("os.name");
		if (os.equals("Linux")) {
			disk = new File("/");
		}
		else if (Pattern.matches("Windows*", os)) {
			disk = new File("C:");
		}
		
		if (disk==null) {
			diskSize = 0;
			freeDiskSpace = 0;
		}
		else {
			diskSize = disk.getTotalSpace();
			freeDiskSpace = disk.getFreeSpace();
		}

		ram = ((com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getTotalMemorySize();
		freeRam = ((com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getFreeMemorySize();
		cpuName = "-";
		cpuFrequency = "-";
		cpuLoad = ((com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getSystemLoadAverage();
		cpuTemp = "-";

	}
	
	
	void showInfos() {
		System.out.println("Hostname : " + hostName);
		System.out.println("OS : " + os);
		System.out.println("Taille totale du disque : " + diskSize / (1024*1024*1024) + " GigaOctets");
		System.out.println("Place restante sur le disque : " + freeDiskSpace / (1024*1024*1024) + " GigaOctets");
		System.out.println("Taille totale de la RAM : " + ram / (1024*1024*1024) + "Go");
		System.out.println("RAM libre : " + freeRam / (1024*1024*1024) + "Go"); //Todo afficher 2 décimales
		System.out.println("Nom du CPU : " + cpuName);
		System.out.println("Fréquence du CPU : " + cpuFrequency);
		System.out.println("Charge du CPU : " + cpuLoad);
		System.out.println("Température : " + cpuTemp);
	}
	
	List<String> getInfos() {
		List<String> allInfos = new ArrayList<String>();
		allInfos.add(hostName);
		allInfos.add(os);
		allInfos.add(Long.toString(diskSize/ (1024*1024*1024)) + "Go");
		allInfos.add(Long.toString(freeDiskSpace/ (1024*1024*1024)) + "Go");
		allInfos.add(Long.toString(ram/ (1024*1024*1024)) + "Go");
		allInfos.add(Float.toString(freeRam/ (1024*1024*1024)) + "Go");
		allInfos.add(cpuName);
		allInfos.add(cpuFrequency);
		allInfos.add(Double.toString(cpuLoad));
		allInfos.add(cpuTemp);
		System.out.println(allInfos);
		return allInfos;
	}
}
