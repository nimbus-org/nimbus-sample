
import java.io.IOException;
import java.io.FileOutputStream;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import org.jfree.chart.JFreeChart;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.graph.JFreeChartFactory;
import jp.ossc.nimbus.service.graph.JFreeChartCreateException;
import jp.ossc.nimbus.service.graph.ChartConditionImpl;
import jp.ossc.nimbus.service.graph.XYPlotConditionImpl;
import jp.ossc.nimbus.service.graph.DatasetConditionImpl;

/**
 * �T���v���Q���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // JFreeChartFactory�T�[�r�X���擾����
            JFreeChartFactory chartFactory = (JFreeChartFactory)ServiceManagerFactory.getServiceObject("ChartFactory");
            
            // ImageWriter���擾����
            ImageWriter imageWriter = (ImageWriter)ServiceManagerFactory.getServiceObject("ImageWriter");
            
            FileOutputStream fos = null;
            try{
                
                // Plot�̐��������𐶐�����
                XYPlotConditionImpl plotCondition = new XYPlotConditionImpl();
                // �`�悷��Plot�̖��O��ݒ肷��
                plotCondition.setName("Sample1");
                
                // JFreeChart�̐��������𐶐�����
                ChartConditionImpl condition = new ChartConditionImpl();
                // �`�悷��`���[�g�̃^�C�g����ݒ肷��
                condition.setTitle("�T���v���P");
                // Plot�̐���������o�^����
                condition.addPlotCondition(plotCondition);
                
                // JFreeChart�𐶐�����
                JFreeChart chart = chartFactory.createChart(condition);
                // �o�b�t�@�C���[�W�Ƀ`���[�g��`�悷��
                BufferedImage buffImg = chart.createBufferedImage(1024, 512);
                
                // �o�͂���摜�t�@�C���̃X�g���[�����J��
                fos = new FileOutputStream("graph.png");
                // �摜�o�͗p�̃X�g���[���Ń��b�v����
                ImageOutputStream ios = ImageIO.createImageOutputStream(fos);
                // ImageWriter�ɉ摜�o�͗p�X�g���[����ݒ肷��
                imageWriter.setOutput(ios);
                // �o�b�t�@�C���[�W���摜�o�͗p�X�g���[���ɏ�������
                imageWriter.write(buffImg);
                // �t���b�V��
                ios.flush();
                // ImageWriter�̏����ݏI������
                imageWriter.dispose();
            }catch(IOException e){
                e.printStackTrace();
                System.exit(-1);
            }catch(JFreeChartCreateException e){
                e.printStackTrace();
                System.exit(-1);
            }finally{
                if(fos != null){
                    try{
                        // �摜�t�@�C���̃X�g���[�������
                        fos.close();
                    }catch(IOException e){}
                }
            }
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}