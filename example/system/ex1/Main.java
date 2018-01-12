
import java.util.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.system.OperationSystem;
import jp.ossc.nimbus.service.system.CpuTimes;
import jp.ossc.nimbus.service.system.MemoryInfo;

/**
 * �T���v���P���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            OperationSystem os = (OperationSystem)ServiceManagerFactory
                    .getServiceObject("OperationSystem");
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            DecimalFormat numFormat = new DecimalFormat("0.0");
            System.out.println("time,user,system,idle,physical,swap");
            StringBuffer buf = new StringBuffer();
            for(int i = 0; i < 10; i++){
                Thread.sleep(1000);
                
                // CPU�g�p�ʂ̏����擾����
                CpuTimes cpu = os.getCpuTimesDelta();
                
                // �����������g�p�ʂ̏����擾����
                MemoryInfo physicalMemory = os.getPhysicalMemoryInfo();
                
                // ���z�������g�p�ʂ̏����擾����
                MemoryInfo swapMemory = os.getSwapMemoryInfo();
                
                buf.setLength(0);
                buf.append(dateFormat.format(new Date()));
                buf.append(',');
                buf.append(numFormat.format(cpu.getUserRate() * 100.0));
                buf.append(',');
                buf.append(numFormat.format(cpu.getSystemRate() * 100.0));
                buf.append(',');
                buf.append(numFormat.format(cpu.getIdleRate() * 100.0));
                buf.append(',');
                buf.append(numFormat.format((double)physicalMemory.getUsedBytes() / (double)physicalMemory.getTotalBytes() * 100.0));
                buf.append(',');
                buf.append(numFormat.format((double)swapMemory.getUsedBytes() / (double)swapMemory.getTotalBytes() * 100.0));
                
                System.out.println(buf.toString());
            }
            
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}