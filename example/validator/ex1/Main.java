
import java.math.BigDecimal;

import jp.ossc.nimbus.util.validator.*;

/**
 * サンプル１実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        Object target = null;
        boolean result = false;
        
        // nullに対する検証を行う
        NullValidator nullValidator = new NullValidator();
        
        System.out.println("nullでない事を検証する");
        target = null;
        result = nullValidator.validate(target);
        System.out.println(" 検証対象=" + target);
        System.out.println(" 検証結果=" + result);
        System.out.println();
        
        System.out.println("nullである事を検証する");
        nullValidator.setNull(true);
        target = null;
        result = nullValidator.validate(target);
        System.out.println(" 検証対象=" + target);
        System.out.println(" 検証結果=" + result);
        System.out.println();
        
        // 数値に対する検証を行う
        NumberValidator numberValidator = new NumberValidator();
        
        System.out.println("0 < x <= 100を検証する");
        numberValidator.setMoreThanValue(BigDecimal.valueOf(0l));
        numberValidator.setLessEqualValue(BigDecimal.valueOf(100l));
        target = new Integer(50);
        result = numberValidator.validate(target);
        System.out.println(" 検証対象=" + target);
        System.out.println(" 検証結果=" + result);
        System.out.println();
        target = new Integer(120);
        result = numberValidator.validate(target);
        System.out.println(" 検証対象=" + target);
        System.out.println(" 検証結果=" + result);
        System.out.println();
        
        // 文字列に対する検証を行う
        PatternStringValidator patternValidator = new PatternStringValidator();
        
        System.out.println("半角英字である事を検証する");
        patternValidator.setPatternString("[a-zA-Z]*");
        target = "abcdEFG";
        result = patternValidator.validate(target);
        System.out.println(" 検証対象=" + target);
        System.out.println(" 検証結果=" + result);
        System.out.println();
        target = "abcdEFGあいうえお";
        result = patternValidator.validate(target);
        System.out.println(" 検証対象=" + target);
        System.out.println(" 検証結果=" + result);
        System.out.println();
        
        // メールアドレス文字列に対する検証を行う
        MailAddressStringValidator mailAdressValidator = new MailAddressStringValidator();
        
        System.out.println("正しいメールアドレスである事を検証する");
        target = "hoge@fuga.co.jp";
        result = mailAdressValidator.validate(target);
        System.out.println(" 検証対象=" + target);
        System.out.println(" 検証結果=" + result);
        System.out.println();
        target = "hoge@fuga";
        result = mailAdressValidator.validate(target);
        System.out.println(" 検証対象=" + target);
        System.out.println(" 検証結果=" + result);
        System.out.println();
        
        // 検証条件式を指定して検証を行う
        ConditionValidator conditionValidator = new ConditionValidator();
        
        System.out.println("nullでなく且つ長さが５文字以上であることを検証する");
        conditionValidator.setCondition("value != null && @length@ >= 5");
        target = "12345";
        result = conditionValidator.validate(target);
        System.out.println(" 検証対象=" + target);
        System.out.println(" 検証結果=" + result);
        System.out.println();
        target = "123";
        result = conditionValidator.validate(target);
        System.out.println(" 検証対象=" + target);
        System.out.println(" 検証結果=" + result);
        System.out.println();
        target = null;
        result = conditionValidator.validate(target);
        System.out.println(" 検証対象=" + target);
        System.out.println(" 検証結果=" + result);
        System.out.println();
        
        // 複数のValidatorを組み合わせて検証を行う
        CombinationValidator combinationValidator = new CombinationValidator();
        
        System.out.println("3桁以下の数値文字列で、-10 <= x <= 999の整数であることを検証する");
        patternValidator.setPatternString("-?[0-9]{1,3}");
        combinationValidator.add(patternValidator);
        numberValidator.setAllowNumberString(true);
        numberValidator.setMoreEqualValue(BigDecimal.valueOf(-10l));
        numberValidator.setLessEqualValue(BigDecimal.valueOf(999l));
        combinationValidator.and(numberValidator);
        target = "123";
        result = combinationValidator.validate(target);
        System.out.println(" 検証対象=" + target);
        System.out.println(" 検証結果=" + result);
        System.out.println();
        target = "-100";
        result = combinationValidator.validate(target);
        System.out.println(" 検証対象=" + target);
        System.out.println(" 検証結果=" + result);
        System.out.println();
        target = "123.4";
        result = combinationValidator.validate(target);
        System.out.println(" 検証対象=" + target);
        System.out.println(" 検証結果=" + result);
        System.out.println();
        
    }
}