package cpuinfo.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cpuinfo.util.CPUUtils;
import cpuinfo.util.LinuxSystemTool;

@RestController
public class CPUController {
	
	@RequestMapping("api/v1/cpu.do")
	public @ResponseBody String cpu() {
		return "{\"cpu\":\""+CPUUtils.getCpuRate()+"\"}";
	}
	
	@RequestMapping("api/v1/mem.do")
	public @ResponseBody String mem() {
		String result = "";
		int[] mem = {0};
		try {
			mem = LinuxSystemTool.getMemInfo();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		result = "{\"MemTotal\":"+mem[0]+",\"MemFree\":"+mem[1]+",\"SwapTotal\":"+mem[2]+",\"SwapFree\":"+mem[3]+"}";
		return result;
	}
}
