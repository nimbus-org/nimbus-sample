
import java.util.*;

import jp.ossc.nimbus.beans.dataset.*;

/**
 * �T���v���R���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        System.out.println("//////// 1�����\���݂̂̃f�[�^�Z�b�g ///////////");
        // �f�[�^�Z�b�g���Fdataset1
        // �f�[�^�\���F1�����\���łQ�̃v���p�e�B������
        //   �v���p�e�B��        �^
        //         A        java.lang.String
        //         B        int
        final DataSet dataset1 = new DataSet("dataset1");
        dataset1.setHeaderSchema(
            ":A,java.lang.String" + '\n'
            + ":B,int"
        );
        System.out.println("�E�f�[�^�Z�b�g");
        System.out.println(dataset1);
        
        // 1�����\����\������w�b�_���擾����
        final Header dataset1_header = dataset1.getHeader();
        System.out.println("�E�w�b�_�̃X�L�[�}��`");
        System.out.println(dataset1_header.getSchema());
        
        System.out.println("�E�f�[�^�̐ݒ�E�y�ю擾");
        // �v���p�e�BA�ɒl��ݒ肷��
        dataset1_header.setProperty("A", "hoge");
        
        // �v���p�e�BA����l���擾����
        System.out.println("A=" + dataset1_header.getStringProperty("A"));
        
        // �v���p�e�BB�ɒl��ݒ肷��
        dataset1_header.setProperty("B", 100);
        
        // �v���p�e�BB����l���擾����
        System.out.println("B=" + dataset1_header.getIntProperty("B"));
        
        System.out.println("�E�s���ȃf�[�^�̐ݒ�");
        // �v���p�e�BA�ɒ�`����Ă���^�Ɣ�݊��Ȍ^�̒l��ݒ肷��
        try{
            dataset1_header.setProperty("A", 100);
        }catch(PropertySetException e){
            // ��O����������
            System.out.println("�^����݊��ł��I" + e.getMessage());
        }
        
        // ���݂��Ȃ��v���p�e�BC�ɒl��ݒ肷��
        try{
            dataset1_header.setProperty("C", 100);
        }catch(PropertySetException e){
            // ��O����������
            System.out.println("���݂��Ȃ��v���p�e�B�ł��I" + e.getMessage());
        }
        
        
        
        System.out.println();
        System.out.println("//////// 2�����\���݂̂̃f�[�^�Z�b�g ///////////");
        // �f�[�^�Z�b�g���Fdataset2
        // �f�[�^�\���F2�����\���łQ�̃v���p�e�B������
        //   �v���p�e�B��        �^
        //         A        java.lang.String
        //         B        int
        final DataSet dataset2 = new DataSet("dataset2");
        dataset2.setRecordListSchema(
            ":A,java.lang.String" + '\n'
            + ":B,int"
        );
        System.out.println("�E�f�[�^�Z�b�g");
        System.out.println(dataset2);
        
        // 2�����\����\�����郌�R�[�h���X�g���擾����
        final RecordList dataset2_recordList = dataset2.getRecordList();
        System.out.println("�E���R�[�h���X�g�̃X�L�[�}��`");
        System.out.println(dataset2_recordList.getSchema());
        
        // ���R�[�h�𐶐�����
        System.out.println("�E���R�[�h1�̐���");
        final Record dataset2_recordList_record1
             = dataset2_recordList.createRecord();
        System.out.println("�E���R�[�h1�̃X�L�[�}��`");
        System.out.println(dataset2_recordList_record1.getSchema());
        System.out.println("�E�f�[�^�̐ݒ�E�y�ю擾");
        // �v���p�e�BA�ɒl��ݒ肷��
        dataset2_recordList_record1.setProperty("A", "hoge");
        // �v���p�e�BA����l���擾����
        System.out.println("A=" + dataset2_recordList_record1.getStringProperty("A"));
        // �v���p�e�BB�ɒl��ݒ肷��
        dataset2_recordList_record1.setProperty("B", 100);
        // �v���p�e�BB����l���擾����
        System.out.println("B=" + dataset2_recordList_record1.getIntProperty("B"));
        // ���R�[�h���X�g�Ƀ��R�[�h��ǉ�����
        dataset2_recordList.addRecord(dataset2_recordList_record1);
        
        System.out.println("�E���R�[�h2�̐���");
        final Record dataset2_recordList_record2
             = dataset2_recordList.createRecord();
        System.out.println("�E���R�[�h2�̃X�L�[�}��`");
        System.out.println(dataset2_recordList_record2.getSchema());
        System.out.println("�E�f�[�^�̐ݒ�E�y�ю擾");
        // �v���p�e�BA�ɒl��ݒ肷��
        dataset2_recordList_record2.setProperty("A", "fuga");
        // �v���p�e�BA����l���擾����
        System.out.println("A=" + dataset2_recordList_record2.getStringProperty("A"));
        // �v���p�e�BB�ɒl��ݒ肷��
        dataset2_recordList_record2.setProperty("B", 200);
        // �v���p�e�BB����l���擾����
        System.out.println("B=" + dataset2_recordList_record2.getIntProperty("B"));
        // ���R�[�h���X�g�Ƀ��R�[�h��ǉ�����
        dataset2_recordList.addRecord(dataset2_recordList_record2);
        
        System.out.println("�E���R�[�h���X�g���̃��R�[�h�̎擾");
        System.out.println("���R�[�h����=" + dataset2_recordList.size());
        Iterator records = dataset2_recordList.iterator();
        while(records.hasNext()){
            final Record record = (Record)records.next();
            final Iterator entries = record.entrySet().iterator();
            while(entries.hasNext()){
                final Map.Entry entry = (Map.Entry)entries.next();
                System.out.print(entry.getKey() + "=" + entry.getValue());
                if(entries.hasNext()){
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        
        
        
        System.out.println();
        System.out.println("//////// 1�����\����2�����\���𕹂����f�[�^�Z�b�g ///////////");
        // �f�[�^�Z�b�g���Fdataset3
        // �f�[�^�\���F1�����\���łQ�̃v���p�e�B������
        //   �v���p�e�B��      �^          ���͕ϊ���� �o�͕ϊ����  ����
        //         A      java.lang.String    �g����     �p�f�B���O   ��null
        //         B      int               ���������l   �J���}�ҏW   1000�ȏ�
        //             2�����\���łR�̃v���p�e�B������
        //   �v���p�e�B��      �^          ���͕ϊ���� �o�͕ϊ����  ����
        //         A      java.lang.String
        //         B      int
        //         C      java.util.Date   yyMMdd��Date
        final DataSet dataset3 = new DataSet("dataset3");
        dataset3.setSchema(
            //�w�b�_�̃X�L�[�}
            ":A,java.lang.String,\"jp.ossc.nimbus.util.converter.PaddingStringConverter{ConvertType=2;PaddingDirection=3}\",\"jp.ossc.nimbus.util.converter.PaddingStringConverter{ConvertType=1;PaddingLength=10;PaddingDirection=2}\",@value@!=null" + '\n'
            + ":B,long,\"jp.ossc.nimbus.util.converter.DecimalFormatConverter{ConvertType=2;Format=#}\",\"jp.ossc.nimbus.util.converter.DecimalFormatConverter{ConvertType=1;Format=###,###,###}\",@value@>=1000",
            //���R�[�h���X�g�̃X�L�[�}
            ":A,java.lang.String" + '\n'
            + ":B,int" + '\n'
            + ":C,java.util.Date,\"jp.ossc.nimbus.util.converter.DateFormatConverter{ConvertType=2;Format=yyMMdd}\""
        );
        System.out.println("�E�f�[�^�Z�b�g");
        System.out.println(dataset3);
        
        // 1�����\����\������w�b�_���擾����
        final Header dataset3_header = dataset3.getHeader();
        System.out.println("�E�w�b�_�̃X�L�[�}��`");
        System.out.println(dataset3_header.getSchema());
        
        System.out.println("�E�f�[�^�̐ݒ�E�y�ю擾");
        
        // �v���p�e�BA�Ƀp�[�X�����l��ݒ肷��
        dataset3_header.setParseProperty("A", "   hoge   ");
        
        // �v���p�e�BA����l���擾����
        System.out.println("A=\"" + dataset3_header.getStringProperty("A") + '"');
        
        // �v���p�e�BA����t�H�[�}�b�g�����l���擾����
        System.out.println("A(�t�H�[�}�b�g�ς�)=\"" + dataset3_header.getFormatProperty("A") + '"');
        
        // �v���p�e�BB�Ƀp�[�X�����l��ݒ肷��
        dataset3_header.setParseProperty("B", "10200");
        
        // �v���p�e�BB����l���擾����
        System.out.println("B=" + dataset3_header.getIntProperty("B"));
        
        // �v���p�e�BB����t�H�[�}�b�g�����l���擾����
        System.out.println("B(�t�H�[�}�b�g�ς�)=" + dataset3_header.getFormatProperty("B"));
        
        System.out.println("�E�s���ȃf�[�^�̐ݒ�");
        // �v���p�e�BA��null�̒l��ݒ肷��
        try{
            dataset3_header.setProperty("A", null);
        }catch(PropertySetException e){
            // ��O����������
            System.out.println("�l��null�ł��I" + e.getMessage());
        }
        
        // �v���p�e�BB��1000�ȉ��̒l��ݒ肷��
        try{
            dataset3_header.setProperty("B", 100);
        }catch(PropertySetException e){
            // ��O����������
            System.out.println("�l��1000��菬�����ł��I" + e.getMessage());
        }
        
        // 2�����\����\�����郌�R�[�h���X�g���擾����
        final RecordList dataset3_recordList = dataset3.getRecordList();
        System.out.println("�E���R�[�h���X�g�̃X�L�[�}��`");
        System.out.println(dataset3_recordList.getSchema());
        
        // ���R�[�h�𐶐�����
        System.out.println("�E���R�[�h1�̐���");
        final Record dataset3_recordList_record1
             = dataset3_recordList.createRecord();
        // �v���p�e�BA�ɒl��ݒ肷��
        dataset3_recordList_record1.setProperty("A", "hoge");
        // �v���p�e�BB�ɒl��ݒ肷��
        dataset3_recordList_record1.setProperty("B", 100);
        // �v���p�e�BC�ɒl��ݒ肷��
        dataset3_recordList_record1.setParseProperty("C", "071109");
        // ���R�[�h���X�g�Ƀ��R�[�h��ǉ�����
        dataset3_recordList.addRecord(dataset3_recordList_record1);
        System.out.println("���R�[�h1 : " + dataset3_recordList_record1);
        
        System.out.println("�E���R�[�h2�̐���");
        final Record dataset3_recordList_record2
             = dataset3_recordList.createRecord();
        // �v���p�e�BA�ɒl��ݒ肷��
        dataset3_recordList_record2.setProperty("A", "fuga");
        // �v���p�e�BB�ɒl��ݒ肷��
        dataset3_recordList_record2.setProperty("B", 200);
        // �v���p�e�BC�ɒl��ݒ肷��
        dataset3_recordList_record2.setParseProperty("C", "071110");
        // ���R�[�h���X�g�Ƀ��R�[�h��ǉ�����
        dataset3_recordList.addRecord(dataset3_recordList_record2);
        System.out.println("���R�[�h�Q : " + dataset3_recordList_record2);
        
        System.out.println("�E���R�[�h���X�g���̃��R�[�h�̎擾");
        System.out.println("���R�[�h����=" + dataset3_recordList.size());
        records = dataset3_recordList.iterator();
        while(records.hasNext()){
            final Record record = (Record)records.next();
            final Iterator entries = record.entrySet().iterator();
            while(entries.hasNext()){
                final Map.Entry entry = (Map.Entry)entries.next();
                System.out.print(entry.getKey() + "=" + entry.getValue());
                if(entries.hasNext()){
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        
        
        
        System.out.println();
        System.out.println("//////// 1�����\����2�����\�����Ԃ炳�������f�[�^�Z�b�g ///////////");
        // �f�[�^�Z�b�g���Fdataset1
        // �f�[�^�\���F1�����\���łQ�̃v���p�e�B�������A���̂����̂P��2�����\��������
        //   �v���p�e�B��        �^
        //         A        java.lang.String
        //         B        jp.ossc.nimbus.beans.dataset.RecordList
        //                  �v���p�e�B��        �^
        //                        C         java.lang.String
        //                        D         int
        final DataSet dataset4 = new DataSet("dataset4");
        dataset4.setHeaderSchema(
            ":A,java.lang.String" + '\n'
            + "LIST:B,BList"
        );
        dataset4.setNestedRecordListSchema(
            "BList",
            ":C,java.lang.String" + '\n'
            + ":D,int"
        );
        System.out.println("�E�f�[�^�Z�b�g");
        System.out.println(dataset4);
        
        // 1�����\����\������w�b�_���擾����
        final Header dataset4_header = dataset4.getHeader();
        System.out.println("�E�w�b�_�̃X�L�[�}��`");
        System.out.println(dataset4_header.getSchema());
        
        System.out.println("�E�f�[�^�̐ݒ�");
        // �v���p�e�BA�ɒl��ݒ肷��
        dataset4_header.setProperty("A", "hoge");
        
        // �v���p�e�BA����l���擾����
        System.out.println("A=" + dataset4_header.getStringProperty("A"));
        
        // �v���p�e�BB�̃��R�[�h���X�g�𐶐�����
        RecordList dataset4_header_bList = dataset4.createNestedRecordList("BList");
        System.out.println("�E���R�[�h���X�g�̃X�L�[�}��`");
        System.out.println(dataset4_header_bList.getSchema());
        
        // ���R�[�h�𐶐�����
        System.out.println("�E���R�[�h1�̐���");
        final Record dataset4_header_bList_record1
             = dataset4_header_bList.createRecord();
        // �v���p�e�BC�ɒl��ݒ肷��
        dataset4_header_bList_record1.setProperty("C", "hoge");
        // �v���p�e�BD�ɒl��ݒ肷��
        dataset4_header_bList_record1.setProperty("D", 100);
        // ���R�[�h���X�g�Ƀ��R�[�h��ǉ�����
        dataset4_header_bList.addRecord(dataset4_header_bList_record1);
        System.out.println("���R�[�h1 : " + dataset4_header_bList_record1);
        
        System.out.println("�E���R�[�h2�̐���");
        final Record dataset4_header_bList_record2
             = dataset4_header_bList.createRecord();
        // �v���p�e�BC�ɒl��ݒ肷��
        dataset4_header_bList_record2.setProperty("C", "hoge");
        // �v���p�e�BD�ɒl��ݒ肷��
        dataset4_header_bList_record2.setProperty("D", 200);
        // ���R�[�h���X�g�Ƀ��R�[�h��ǉ�����
        dataset4_header_bList.addRecord(dataset4_header_bList_record2);
        System.out.println("���R�[�h2 : " + dataset4_header_bList_record2);
        
        // �v���p�e�BB�Ƀ��R�[�h���X�g��ݒ肷��
        dataset4_header.setProperty("B", dataset4_header_bList);
        
        
        // �v���p�e�BA����l���擾����
        System.out.println("A=\"" + dataset4_header.getStringProperty("A") + '"');
        System.out.println("B=");
        System.out.println("���R�[�h����=" + dataset4_header_bList.size());
        records = dataset4_header_bList.iterator();
        while(records.hasNext()){
            final Record record = (Record)records.next();
            final Iterator entries = record.entrySet().iterator();
            while(entries.hasNext()){
                final Map.Entry entry = (Map.Entry)entries.next();
                System.out.print(entry.getKey() + "=" + entry.getValue());
                if(entries.hasNext()){
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}