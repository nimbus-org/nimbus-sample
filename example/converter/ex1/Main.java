
import jp.ossc.nimbus.util.converter.Converters;
import jp.ossc.nimbus.util.converter.Converter;
import jp.ossc.nimbus.util.converter.ReversibleConverter;

/**
 * �T���v���P���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        final Object input = "aA���`1�P�A���+�{";
        Object output = null;
        Converter converter = null;
        
        // ���p�p�����S�p�p���R���o�[�^���擾����
        System.out.println("���p�p�����S�p�p���ϊ�");
        converter = Converters.getAlphabetHankakuFromZenkakuStringConverter();
        output = converter.convert(input);
        System.out.println(" ����=" + input);
        System.out.println(" �o��=" + output);
        System.out.println();
        
        // �S�p�p�������p�p���R���o�[�^���擾����
        System.out.println("�S�p�p�������p�p��");
        converter = Converters.getAlphabetZenkakuFromHankakuStringConverter();
        output = converter.convert(input);
        System.out.println(" ����=" + input);
        System.out.println(" �o��=" + output);
        System.out.println();
        
        // ���p�J�^�J�i���S�p�J�^�J�i�R���o�[�^���擾����
        System.out.println("���p�J�^�J�i���S�p�J�^�J�i");
        converter = Converters.getKatakanaHankakuFromZenkakuStringConverter();
        output = converter.convert(input);
        System.out.println(" ����=" + input);
        System.out.println(" �o��=" + output);
        System.out.println();
        
        // �S�p�J�^�J�i�����p�J�^�J�i�R���o�[�^���擾����
        System.out.println("�S�p�J�^�J�i�����p�J�^�J�i");
        converter = Converters.getKatakanaZenkakuFromHankakuStringConverter();
        output = converter.convert(input);
        System.out.println(" ����=" + input);
        System.out.println(" �o��=" + output);
        System.out.println();
        
        // ���p�������S�p�����R���o�[�^���擾����
        System.out.println("���p�������S�p����");
        converter = Converters.getNumberHankakuFromZenkakuStringConverter();
        output = converter.convert(input);
        System.out.println(" ����=" + input);
        System.out.println(" �o��=" + output);
        System.out.println();
        
        // �S�p���������p�����R���o�[�^���擾����
        System.out.println("�S�p���������p����");
        converter = Converters.getNumberZenkakuFromHankakuStringConverter();
        output = converter.convert(input);
        System.out.println(" ����=" + input);
        System.out.println(" �o��=" + output);
        System.out.println();
        
        // ���p�L�����S�p�L���R���o�[�^���擾����
        System.out.println("���p�L�����S�p�L��");
        converter = Converters.getSymbolHankakuFromZenkakuStringConverter();
        output = converter.convert(input);
        System.out.println(" ����=" + input);
        System.out.println(" �o��=" + output);
        System.out.println();
        
        // �S�p�L�������p�L���R���o�[�^���擾����
        System.out.println("�S�p�L�������p�L��");
        converter = Converters.getSymbolZenkakuFromHankakuStringConverter();
        output = converter.convert(input);
        System.out.println(" ����=" + input);
        System.out.println(" �o��=" + output);
        System.out.println();
        
        // �S�p�J�^�J�i���S�p�Ђ炪�ȃR���o�[�^���擾����
        System.out.println("�S�p�J�^�J�i���S�p�Ђ炪��");
        converter = Converters.getKatakanaFromHiraganaStringConverter();
        output = converter.convert(input);
        System.out.println(" ����=" + input);
        System.out.println(" �o��=" + output);
        System.out.println();
        
        // �S�p�Ђ炪�ȁ��S�p�J�^�J�i�R���o�[�^���擾����
        System.out.println("�S�p�Ђ炪�ȁ��S�p�J�^�J�i");
        converter = Converters.getHiraganaFromKatakanaStringConverter();
        output = converter.convert(input);
        System.out.println(" ����=" + input);
        System.out.println(" �o��=" + output);
        System.out.println();
        
        // ���p���S�p�R���o�[�^���擾����
        System.out.println("���p���S�p");
        converter = Converters.getHankakuFromZenkakuStringConverter();
        output = converter.convert(input);
        System.out.println(" ����=" + input);
        System.out.println(" �o��=" + output);
        System.out.println();
        
        // �S�p�����p�R���o�[�^���擾����
        System.out.println("�S�p�����p");
        converter = Converters.getZenkakuFromHankakuStringConverter();
        output = converter.convert(input);
        System.out.println(" ����=" + input);
        System.out.println(" �o��=" + output);
        System.out.println();
        
        // �Ǝ��R���o�[�^���擾����
        System.out.println("�Ђ炪�ȁ����[�}��");
        converter = Converters.newCustomStringConverter(
            ReversibleConverter.POSITIVE_CONVERT,
            new String[]{"��", "��", "��", "��", "��"},
            new String[]{"a", "i", "u", "e", "o"}
        );
        output = converter.convert(input);
        System.out.println(" ����=" + input);
        System.out.println(" �o��=" + output);
        System.out.println();
        
        // �A���R���o�[�^���擾����
        System.out.println("�S�p�p���������p�p����");
        converter = Converters.newCustomConverter(
            new Converter[]{
                Converters.getNumberZenkakuFromHankakuStringConverter(),
                Converters.getAlphabetZenkakuFromHankakuStringConverter()
            }
        );
        output = converter.convert(input);
        System.out.println(" ����=" + input);
        System.out.println(" �o��=" + output);
        System.out.println();
        
        // ���K�\���R���o�[�^���擾����
        System.out.println("���K�\��\"a.*��\"��B");
        converter = Converters.patternStringConverter(
            0,
            new String[]{"a.*��",},
            new String[]{"B"}
        );
        output = converter.convert(input);
        System.out.println(" ����=" + input);
        System.out.println(" �o��=" + output);
        System.out.println();
    }
}