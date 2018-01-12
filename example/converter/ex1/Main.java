
import jp.ossc.nimbus.util.converter.Converters;
import jp.ossc.nimbus.util.converter.Converter;
import jp.ossc.nimbus.util.converter.ReversibleConverter;

/**
 * サンプル１実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        final Object input = "aAａＡ1１アあｱ+＋";
        Object output = null;
        Converter converter = null;
        
        // 半角英字→全角英字コンバータを取得する
        System.out.println("半角英字→全角英字変換");
        converter = Converters.getAlphabetHankakuFromZenkakuStringConverter();
        output = converter.convert(input);
        System.out.println(" 入力=" + input);
        System.out.println(" 出力=" + output);
        System.out.println();
        
        // 全角英字→半角英字コンバータを取得する
        System.out.println("全角英字→半角英字");
        converter = Converters.getAlphabetZenkakuFromHankakuStringConverter();
        output = converter.convert(input);
        System.out.println(" 入力=" + input);
        System.out.println(" 出力=" + output);
        System.out.println();
        
        // 半角カタカナ→全角カタカナコンバータを取得する
        System.out.println("半角カタカナ→全角カタカナ");
        converter = Converters.getKatakanaHankakuFromZenkakuStringConverter();
        output = converter.convert(input);
        System.out.println(" 入力=" + input);
        System.out.println(" 出力=" + output);
        System.out.println();
        
        // 全角カタカナ→半角カタカナコンバータを取得する
        System.out.println("全角カタカナ→半角カタカナ");
        converter = Converters.getKatakanaZenkakuFromHankakuStringConverter();
        output = converter.convert(input);
        System.out.println(" 入力=" + input);
        System.out.println(" 出力=" + output);
        System.out.println();
        
        // 半角数字→全角数字コンバータを取得する
        System.out.println("半角数字→全角数字");
        converter = Converters.getNumberHankakuFromZenkakuStringConverter();
        output = converter.convert(input);
        System.out.println(" 入力=" + input);
        System.out.println(" 出力=" + output);
        System.out.println();
        
        // 全角数字→半角数字コンバータを取得する
        System.out.println("全角数字→半角数字");
        converter = Converters.getNumberZenkakuFromHankakuStringConverter();
        output = converter.convert(input);
        System.out.println(" 入力=" + input);
        System.out.println(" 出力=" + output);
        System.out.println();
        
        // 半角記号→全角記号コンバータを取得する
        System.out.println("半角記号→全角記号");
        converter = Converters.getSymbolHankakuFromZenkakuStringConverter();
        output = converter.convert(input);
        System.out.println(" 入力=" + input);
        System.out.println(" 出力=" + output);
        System.out.println();
        
        // 全角記号→半角記号コンバータを取得する
        System.out.println("全角記号→半角記号");
        converter = Converters.getSymbolZenkakuFromHankakuStringConverter();
        output = converter.convert(input);
        System.out.println(" 入力=" + input);
        System.out.println(" 出力=" + output);
        System.out.println();
        
        // 全角カタカナ→全角ひらがなコンバータを取得する
        System.out.println("全角カタカナ→全角ひらがな");
        converter = Converters.getKatakanaFromHiraganaStringConverter();
        output = converter.convert(input);
        System.out.println(" 入力=" + input);
        System.out.println(" 出力=" + output);
        System.out.println();
        
        // 全角ひらがな→全角カタカナコンバータを取得する
        System.out.println("全角ひらがな→全角カタカナ");
        converter = Converters.getHiraganaFromKatakanaStringConverter();
        output = converter.convert(input);
        System.out.println(" 入力=" + input);
        System.out.println(" 出力=" + output);
        System.out.println();
        
        // 半角→全角コンバータを取得する
        System.out.println("半角→全角");
        converter = Converters.getHankakuFromZenkakuStringConverter();
        output = converter.convert(input);
        System.out.println(" 入力=" + input);
        System.out.println(" 出力=" + output);
        System.out.println();
        
        // 全角→半角コンバータを取得する
        System.out.println("全角→半角");
        converter = Converters.getZenkakuFromHankakuStringConverter();
        output = converter.convert(input);
        System.out.println(" 入力=" + input);
        System.out.println(" 出力=" + output);
        System.out.println();
        
        // 独自コンバータを取得する
        System.out.println("ひらがな→ローマ字");
        converter = Converters.newCustomStringConverter(
            ReversibleConverter.POSITIVE_CONVERT,
            new String[]{"あ", "い", "う", "え", "お"},
            new String[]{"a", "i", "u", "e", "o"}
        );
        output = converter.convert(input);
        System.out.println(" 入力=" + input);
        System.out.println(" 出力=" + output);
        System.out.println();
        
        // 連結コンバータを取得する
        System.out.println("全角英数字→半角英数字");
        converter = Converters.newCustomConverter(
            new Converter[]{
                Converters.getNumberZenkakuFromHankakuStringConverter(),
                Converters.getAlphabetZenkakuFromHankakuStringConverter()
            }
        );
        output = converter.convert(input);
        System.out.println(" 入力=" + input);
        System.out.println(" 出力=" + output);
        System.out.println();
        
        // 正規表現コンバータを取得する
        System.out.println("正規表現\"a.*ａ\"→B");
        converter = Converters.patternStringConverter(
            0,
            new String[]{"a.*ａ",},
            new String[]{"B"}
        );
        output = converter.convert(input);
        System.out.println(" 入力=" + input);
        System.out.println(" 出力=" + output);
        System.out.println();
    }
}