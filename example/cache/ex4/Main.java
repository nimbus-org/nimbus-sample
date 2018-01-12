
import java.util.*;
import java.io.*;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.cache.Cache;
import jp.ossc.nimbus.service.cache.CachedReference;

/**
 * �T���v���R���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            final Cache cache = (Cache)ServiceManagerFactory
                .getServiceObject("Cache");
            
            Runtime runtime = Runtime.getRuntime();
            
            // �L���b�V�����āA�L���b�V���Q�Ƃ����炤
            System.out.println("�L���b�V���ǉ�");
            List refs = new ArrayList();
            for(int i = 0; i < 3100; i++){
                refs.add(cache.add(new byte[10240]));
                
                // �������̎g�p�ʂ��v�Z����
                long used = runtime.totalMemory() - runtime.freeMemory();
                System.out.println("�q�[�v�������g�p�� : " + used + "(" + ((double)((double)used / (double)runtime.maxMemory()) * 100) + "%)");
            }
            
            System.out.println("���s�f�B���N�g���ɁA�L���b�V�����ꂽ�t�@�C�����쐬����Ă��鎖���m�F���āAEnter�L�[�������ĉ������B");
            try{
                new InputStreamReader(System.in).read();
            }catch(IOException e){
            }
            
            // �������̎g�p�ʂ��v�Z����
            long used = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("�q�[�v�������g�p�� : " + used + "(" + ((double)((double)used / (double)runtime.maxMemory()) * 100) + "%)");
            
            // GC���܂�
            System.out.println("GC���܂�");
            runtime.gc();
            
            // �������̎g�p�ʂ��v�Z����
            used = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("�q�[�v�������g�p�� : " + used + "(" + ((double)((double)used / (double)runtime.maxMemory()) * 100) + "%)");
            
            System.out.println("�������̎g�p�ʂ������Ă��鎖���m�F���āAEnter�L�[�������ĉ������B");
            try{
                new InputStreamReader(System.in).read();
            }catch(IOException e){
            }
            
            // ��ԌÂ��L���b�V�����擾����
            // �Â��L���b�V���́A���ӂꐧ��ɂ���ă\�t�g�Q�ƂɂȂ�
            // �t�@�C���ɉi��������Ă���B
            // ����ɁAGC�ɂ���ă\�t�g�Q�Ƃ́A�K�x�[�W����Ă���̂�
            // �i�������ꂽ�t�@�C�����畜�������
            CachedReference ref = (CachedReference)refs.get(0);
            System.out.println("��ԌÂ��L���b�V�� : " + ref.get());
            
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}