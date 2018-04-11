package cpuinfo.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public final class LinuxSystemTool {

/*
 	MemTotal:        8078136 kB
	MemFree:          137380 kB
	MemAvailable:     327332 kB
	Buffers:           17644 kB
	Cached:           347056 kB
	SwapCached:         3816 kB
	Active:          6407740 kB
	Inactive:        1053408 kB
	Active(anon):    6200892 kB
	Inactive(anon):   885580 kB
	Active(file):     206848 kB
	Inactive(file):   167828 kB
	Unevictable:          96 kB
	Mlocked:              96 kB
	SwapTotal:       1954308 kB
	SwapFree:        1779716 kB
	Dirty:               128 kB
	Writeback:             0 kB
	AnonPages:       7092788 kB
	Mapped:           409800 kB
	Shmem:             56592 kB
	Slab:             156836 kB
	SReclaimable:      77360 kB
	SUnreclaim:        79476 kB
	KernelStack:       14816 kB
	PageTables:        86672 kB
	NFS_Unstable:          0 kB
	Bounce:                0 kB
	WritebackTmp:          0 kB
	CommitLimit:     5993376 kB
	Committed_AS:   15543356 kB
	VmallocTotal:   34359738367 kB
	VmallocUsed:           0 kB
	VmallocChunk:          0 kB
	HardwareCorrupted:     0 kB
	AnonHugePages:         0 kB
	ShmemHugePages:        0 kB
	ShmemPmdMapped:        0 kB
	CmaTotal:              0 kB
	CmaFree:               0 kB
	HugePages_Total:       0
	HugePages_Free:        0
	HugePages_Rsvd:        0
	HugePages_Surp:        0
	Hugepagesize:       2048 kB
	DirectMap4k:      410368 kB
	DirectMap2M:     6840320 kB
	DirectMap1G:     2097152 kB
*/
	/**
	 * get memory by used info
	 * 
	 * @return int[] result
	 *         result.length==4;int[0]=MemTotal;int[1]=MemFree;int[2]=SwapTotal;int[3]=SwapFree;
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static int[] getMemInfo() throws IOException, InterruptedException {
		File file = new File("/proc/meminfo");
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		int[] result = new int[4];
		String str = null;
		StringTokenizer token = null;
		while ((str = br.readLine()) != null) {
			token = new StringTokenizer(str);
			if (!token.hasMoreTokens())
				continue;

			str = token.nextToken();
			if (!token.hasMoreTokens())
				continue;

			if (str.equalsIgnoreCase("MemTotal:"))
				result[0] = Integer.parseInt(token.nextToken());
			else if (str.equalsIgnoreCase("MemFree:"))
				result[1] = Integer.parseInt(token.nextToken());
			else if (str.equalsIgnoreCase("SwapTotal:"))
				result[2] = Integer.parseInt(token.nextToken());
			else if (str.equalsIgnoreCase("SwapFree:"))
				result[3] = Integer.parseInt(token.nextToken());
		}

		return result;
	}
/*
cpu  3460019 170 23048 365257 838 0 3422 0 0 0
cpu0 874467 169 6018 81101 606 0 621 0 0 0
cpu1 874734 0 5571 82065 60 0 642 0 0 0
cpu2 856846 0 5691 99548 76 0 1604 0 0 0
cpu3 853972 0 5768 102541 95 0 553 0 0 0
intr 13707383 50 10 0 0 5218 0 0 0 1 0 0 0 155 0 0 0 0 0 0 0 0 0 0 0 0 0 0 45851 0 88696 85458 98681 90053 148241 129362 68140 93359 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
ctxt 11247959
btime 1523404398
processes 6000
procs_running 5
procs_blocked 0
softirq 9463947 0 7763192 0 477063 0 0 1 603421 0 620270
*/
	/**
	 * get memory by used info
	 * 
	 * @return float efficiency
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static double getCpuInfo() throws IOException, InterruptedException {
		File file = new File("/proc/stat");
		BufferedReader buffRead = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		StringTokenizer token = new StringTokenizer(buffRead.readLine());
		token.nextToken();
		double user1 = Double.parseDouble(token.nextToken());
		double nice1 = Double.parseDouble(token.nextToken());
		double sys1 = Double.parseDouble(token.nextToken());
		double idle1 = Double.parseDouble(token.nextToken());
		Thread.sleep(5000);
		buffRead = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		token = new StringTokenizer(buffRead.readLine());
		token.nextToken();
		double user2 = Double.parseDouble(token.nextToken());
		double nice2 = Double.parseDouble(token.nextToken());
		double sys2 = Double.parseDouble(token.nextToken());
		double idle2 = Double.parseDouble(token.nextToken());
		return  ((user2 + sys2 + nice2) - (user1 + sys1 + nice1))/((user2 + nice2 + sys2 + idle2) - (user1 + nice1 + sys1 + idle1));
	}
	
}

