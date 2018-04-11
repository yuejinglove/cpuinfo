package cpuinfo.util;
import java.io.IOException;
public final class CPUUtils {
	private static double cpuRate = 0.0;
	
	public static void setCpuRate() {
		try {
			cpuRate = LinuxSystemTool.getCpuInfo();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static double getCpuRate() {
		return cpuRate;
	}
}
