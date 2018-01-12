
import java.util.*;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.ioc.FacadeValueAccess;
import jp.ossc.nimbus.ioc.FacadeValue;
import jp.ossc.nimbus.ioc.UnitOfWork;
import jp.ossc.nimbus.ioc.CommandBase;
import jp.ossc.nimbus.ioc.Command;
import jp.ossc.nimbus.service.ioccall.FacadeCaller;

/**
 * �T���v���P���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args) throws Throwable{
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            FacadeCaller caller = (FacadeCaller)ServiceManagerFactory
                    .getServiceObject("IOCFacadeCaller");
            try{
                // �e�[�u���쐬�y�у��R�[�h�ǉ��𓯈�g�����U�N�V������
                // ���s���邽�߂ɁA�����R�}���h���i�[����UnitOfWork�𐶐�����
                UnitOfWork createAndInsertUOW
                     = FacadeValueAccess.createUnitOfWork();
                
                // �e�[�u���쐬�R�}���h�𐶐�����
                Command createCommand
                     = FacadeValueAccess.createCommand("CreateTable", null);
                // �e�[�u���쐬�R�}���h��UnitOfWork�ɒǉ�����
                createAndInsertUOW.addCommand(createCommand);
                
                // ���͂̃��R�[�h�𐶐�
                System.out.println("���R�[�h�쐬");
                System.out.println("���O,�N��,����");
                List input = new ArrayList();
                for(int i = 0; i < 11; i++){
                    Map record = new HashMap();
                    record.put("name", "user" + i);
                    record.put("age", new Integer(i + 10));
                    record.put("sex", i % 2 == 0 ? "0" : "1");
                    input.add(record);
                    System.out.println(record.get("name")
                        + "," + record.get("age")
                        + "," + record.get("sex"));
                }
                
                // ���R�[�h�ǉ��R�}���h�𐶐�����
                Command insertCommand
                     = FacadeValueAccess.createCommand("Insert", input);
                // ���R�[�h�ǉ��R�}���h��UnitOfWork�ɒǉ�����
                createAndInsertUOW.addCommand(insertCommand);
                
                // �e�[�u���쐬�y�у��R�[�h�ǉ��𓯈�g�����U�N�V�����Ŏ��s����
                UnitOfWork resultUOW
                     = caller.syncUnitOfWorkCall(createAndInsertUOW);
                
                // ���s���ʂ��������Ă��邩�m�F����
                if(resultUOW.getStatus() != CommandBase.C_STATUS_COMPLETE){
                    System.out.println("�e�[�u���쐬�y�у��R�[�h�ǉ��g�����U�N�V�������s : " + resultUOW.getStatus());
                    
                    // ��O���������Ă��邩�m�F����
                    if(resultUOW.getExceptionCount() != 0){
                        throw resultUOW.getExceptions()[0];
                    }
                    return;
                }
                
                // ���R�[�h�����R�}���h�����s
                // �S��������
                // �A���A�t���[�ɂāA5���܂ł����������ʂ�Ԃ��Ȃ�
                
                // ���R�[�h�����R�}���h�𐶐�����
                Command searchAllCommand
                     = FacadeValueAccess.createCommand("Search", null);
                
                // ���R�[�h�����R�}���h�����s����
                Command resultCommand
                     = caller.syncCommandCall(searchAllCommand);
                
                // ���s���ʂ��������Ă��邩�m�F����
                if(resultCommand.getStatus() != CommandBase.C_STATUS_COMPLETE){
                    System.out.println("���R�[�h�����g�����U�N�V�������s : " + resultCommand.getStatus());
                    
                    // ��O���������Ă��邩�m�F����
                    if(resultCommand.getExceptionCount() != 0){
                        throw resultCommand.getExceptions()[0];
                    }
                    return;
                }
                
                // ���s���ʂ��擾����
                List output = (List)resultCommand.getOutputObject();
                System.out.println("�S�����i�ő�T���j");
                System.out.println("���O,�N��,����");
                for(int i = 0, max = output.size(); i < max; i++){
                    Map record = (Map)output.get(i);
                    System.out.println(record.get("name")
                        + "," + record.get("age")
                        + "," + record.get("sex"));
                }
                
                // �Q��̃��R�[�h�����t���[��ʃg�����U�N�V�����łP�x�Ɏ��s
                // �����P�F
                //   �����ŁA���[�U�������������Ƃ��ēn��
                //   �������ʊY������
                // �����Q�F
                //   �����ŁA���[�U�������������Ƃ��ēn��
                //   �������ʊY���Ȃ�
                
                // �����P�R�}���h�𐶐�����
                Command search1Command
                     = FacadeValueAccess.createCommand("Search", "user10");
                // �����P��Ɨ������g�����U�N�V�����Ŏ��s���邽�߂�
                // �R�}���h���i�[����UnitOfWork�𐶐�����
                UnitOfWork search1UOW = FacadeValueAccess.createUnitOfWork();
                // �����P��UnitOfWork�ɒǉ�����
                search1UOW.addCommand(search1Command);
                
                // �����Q�R�}���h�𐶐�����
                Command search2Command
                     = FacadeValueAccess.createCommand("Search", "user100");
                // �����Q��Ɨ������g�����U�N�V�����Ŏ��s���邽�߂�
                // �R�}���h���i�[����UnitOfWork�𐶐�����
                UnitOfWork search2UOW = FacadeValueAccess.createUnitOfWork();
                // �����Q��UnitOfWork�ɒǉ�����
                search2UOW.addCommand(search2Command);
                
                // �����PUnitOfWork�ƌ����QUnitOfWork�����Ɏ��s���邽�߂�
                // FacadeValue�𐶐����āA�eUnitOfWork��ǉ�����
                FacadeValue search1And2FV
                     = FacadeValueAccess.createCommandsValue();
                search1And2FV.addUnitOfWork(search1UOW);
                search1And2FV.addUnitOfWork(search2UOW);
                
                // �����P�ƌ����Q�����ꂼ��ʃg�����U�N�V�����Ŏ��s����
                FacadeValue resultFV = caller.syncFacadeCall(search1And2FV);
                
                // �����P�̌��ʂ����o��
                UnitOfWork resutl1UOW = (UnitOfWork)resultFV.getCommand(0);
                Command resutl1Command = (Command)resutl1UOW.getCommand(0);
                
                // ���s���ʂ��������Ă��邩�m�F����
                if(resutl1Command.getStatus() != CommandBase.C_STATUS_COMPLETE){
                    System.out.println("�����P�g�����U�N�V�������s : " + resutl1Command.getStatus());
                }else{
                    System.out.println("�����P : user10");
                    // ���s���ʂ��擾����
                    Map record = (Map)resutl1Command.getOutputObject();
                    System.out.println(record.get("name")
                        + "," + record.get("age")
                        + "," + record.get("sex"));
                }
                
                // �����Q�̌��ʂ����o��
                UnitOfWork resutl2UOW = (UnitOfWork)resultFV.getCommand(1);
                Command resutl2Command = (Command)resutl2UOW.getCommand(0);
                
                // ���s���ʂ��������Ă��邩�m�F����
                if(resutl2Command.getStatus() != CommandBase.C_STATUS_COMPLETE){
                    System.out.println("�����Q�g�����U�N�V�������s : " + resutl2Command.getStatus());
                }else{
                    System.out.println("�����Q : user100");
                    // ���s���ʂ��擾����
                    Map record = (Map)resutl2Command.getOutputObject();
                    System.out.println(record);
                }
            }finally{
                // �e�[�u���폜�R�}���h�𐶐�����
                Command deleteCommand
                     = FacadeValueAccess.createCommand("DropTable", null);
                
                // �e�[�u���폜�R�}���h�����s����
                Command resultCommand = caller.syncCommandCall(deleteCommand);
            }
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}