
import java.io.FileInputStream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import jp.ossc.nimbus.core.MetaData;
import jp.ossc.nimbus.util.converter.DOMHTMLConverter;
import jp.ossc.nimbus.util.converter.StringStreamConverter;

/**
 * サンプル６実行クラス。
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        // DOM⇔HTMLストリーム変換コンバータを生成
        DOMHTMLConverter htmlConverter = new DOMHTMLConverter();
        htmlConverter.setCharacterEncodingToObject("MS932");
        htmlConverter.setCharacterEncodingToStream("MS932");
        
        // 文字列⇔ストリーム変換コンバータを生成
        StringStreamConverter streamConverter = new StringStreamConverter();
        
        // HTMLからDOMに変換する
        Document doc = (Document)htmlConverter.convertToObject(new FileInputStream("sample.html"));
        
        Element root = doc.getDocumentElement();
        Element head = MetaData.getUniqueChild(root, "HEAD");
        Element title = MetaData.getUniqueChild(head, "TITLE"); 
        System.out.println(MetaData.getElementContent(title));
        
        Element body = MetaData.getUniqueChild(root, "BODY");
        Element h1 = MetaData.getUniqueChild(body, "H1"); 
        System.out.println(MetaData.getElementContent(h1));
        Element p = MetaData.getUniqueChild(body, "P"); 
        System.out.println(MetaData.getElementContent(p));
        
        // DOMからHTMLに変換する
        String html = (String)streamConverter.convertToObject(htmlConverter.convertToStream(doc));
        System.out.println(html);
    }
}