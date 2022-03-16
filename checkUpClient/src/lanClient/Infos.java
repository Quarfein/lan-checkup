package lanClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.File;
import java.lang.management.ManagementFactory;

public class Infos {
	
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
		else if (os.equals("Windows")) {
			disk = new File("C:");
		}
		diskSize = disk.getTotalSpace();
		freeDiskSpace = disk.getFreeSpace();
		ram = ((com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getTotalPhysicalMemorySize();
		freeRam = ((com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getFreePhysicalMemorySize();
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
}
