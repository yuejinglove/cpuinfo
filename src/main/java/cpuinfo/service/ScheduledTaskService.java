package cpuinfo.service;


import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cpuinfo.util.CPUUtils;

@Component   
@EnableScheduling   
@Service  
@Transactional  
public class ScheduledTaskService {
	
	/** 
     * 目标：实现定时任务；实例中是任务执行完0.300s钟执行一次 
     */  
    @Scheduled(fixedDelay = 300)  
    public void printCurrentTimeAfterSleep() throws InterruptedException {  
    	CPUUtils.setCpuRate();
    } 
}
