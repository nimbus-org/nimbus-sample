
import java.math.BigDecimal;

import jp.ossc.nimbus.util.validator.*;

/**
 * �T���v���P���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        Object target = null;
        boolean result = false;
        
        // null�ɑ΂��錟�؂��s��
        NullValidator nullValidator = new NullValidator();
        
        System.out.println("null�łȂ��������؂���");
        target = null;
        result = nullValidator.validate(target);
        System.out.println(" ���ؑΏ�=" + target);
        System.out.println(" ���،���=" + result);
        System.out.println();
        
        System.out.println("null�ł��鎖�����؂���");
        nullValidator.setNull(true);
        target = null;
        result = nullValidator.validate(target);
        System.out.println(" ���ؑΏ�=" + target);
        System.out.println(" ���،���=" + result);
        System.out.println();
        
        // ���l�ɑ΂��錟�؂��s��
        NumberValidator numberValidator = new NumberValidator();
        
        System.out.println("0 < x <= 100�����؂���");
        numberValidator.setMoreThanValue(BigDecimal.valueOf(0l));
        numberValidator.setLessEqualValue(BigDecimal.valueOf(100l));
        target = new Integer(50);
        result = numberValidator.validate(target);
        System.out.println(" ���ؑΏ�=" + target);
        System.out.println(" ���،���=" + result);
        System.out.println();
        target = new Integer(120);
        result = numberValidator.validate(target);
        System.out.println(" ���ؑΏ�=" + target);
        System.out.println(" ���،���=" + result);
        System.out.println();
        
        // ������ɑ΂��錟�؂��s��
        PatternStringValidator patternValidator = new PatternStringValidator();
        
        System.out.println("���p�p���ł��鎖�����؂���");
        patternValidator.setPatternString("[a-zA-Z]*");
        target = "abcdEFG";
        result = patternValidator.validate(target);
        System.out.println(" ���ؑΏ�=" + target);
        System.out.println(" ���،���=" + result);
        System.out.println();
        target = "abcdEFG����������";
        result = patternValidator.validate(target);
        System.out.println(" ���ؑΏ�=" + target);
        System.out.println(" ���،���=" + result);
        System.out.println();
        
        // ���[���A�h���X������ɑ΂��錟�؂��s��
        MailAddressStringValidator mailAdressValidator = new MailAddressStringValidator();
        
        System.out.println("���������[���A�h���X�ł��鎖�����؂���");
        target = "hoge@fuga.co.jp";
        result = mailAdressValidator.validate(target);
        System.out.println(" ���ؑΏ�=" + target);
        System.out.println(" ���،���=" + result);
        System.out.println();
        target = "hoge@fuga";
        result = mailAdressValidator.validate(target);
        System.out.println(" ���ؑΏ�=" + target);
        System.out.println(" ���،���=" + result);
        System.out.println();
        
        // ���؏��������w�肵�Č��؂��s��
        ConditionValidator conditionValidator = new ConditionValidator();
        
        System.out.println("null�łȂ����������T�����ȏ�ł��邱�Ƃ����؂���");
        conditionValidator.setCondition("value != null && @length@ >= 5");
        target = "12345";
        result = conditionValidator.validate(target);
        System.out.println(" ���ؑΏ�=" + target);
        System.out.println(" ���،���=" + result);
        System.out.println();
        target = "123";
        result = conditionValidator.validate(target);
        System.out.println(" ���ؑΏ�=" + target);
        System.out.println(" ���،���=" + result);
        System.out.println();
        target = null;
        result = conditionValidator.validate(target);
        System.out.println(" ���ؑΏ�=" + target);
        System.out.println(" ���،���=" + result);
        System.out.println();
        
        // ������Validator��g�ݍ��킹�Č��؂��s��
        CombinationValidator combinationValidator = new CombinationValidator();
        
        System.out.println("3���ȉ��̐��l������ŁA-10 <= x <= 999�̐����ł��邱�Ƃ����؂���");
        patternValidator.setPatternString("-?[0-9]{1,3}");
        combinationValidator.add(patternValidator);
        numberValidator.setAllowNumberString(true);
        numberValidator.setMoreEqualValue(BigDecimal.valueOf(-10l));
        numberValidator.setLessEqualValue(BigDecimal.valueOf(999l));
        combinationValidator.and(numberValidator);
        target = "123";
        result = combinationValidator.validate(target);
        System.out.println(" ���ؑΏ�=" + target);
        System.out.println(" ���،���=" + result);
        System.out.println();
        target = "-100";
        result = combinationValidator.validate(target);
        System.out.println(" ���ؑΏ�=" + target);
        System.out.println(" ���،���=" + result);
        System.out.println();
        target = "123.4";
        result = combinationValidator.validate(target);
        System.out.println(" ���ؑΏ�=" + target);
        System.out.println(" ���،���=" + result);
        System.out.println();
        
    }
}