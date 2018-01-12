
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
 * サンプル２実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // JFreeChartFactoryサービスを取得する
            JFreeChartFactory chartFactory = (JFreeChartFactory)ServiceManagerFactory.getServiceObject("ChartFactory");
            
            // ImageWriterを取得する
            ImageWriter imageWriter = (ImageWriter)ServiceManagerFactory.getServiceObject("ImageWriter");
            
            FileOutputStream fos = null;
            try{
                
                // Plotの生成条件を生成する
                XYPlotConditionImpl plotCondition = new XYPlotConditionImpl();
                // 描画するPlotの名前を設定する
                plotCondition.setName("Sample1");
                
                // JFreeChartの生成条件を生成する
                ChartConditionImpl condition = new ChartConditionImpl();
                // 描画するチャートのタイトルを設定する
                condition.setTitle("サンプル１");
                // Plotの生成条件を登録する
                condition.addPlotCondition(plotCondition);
                
                // JFreeChartを生成する
                JFreeChart chart = chartFactory.createChart(condition);
                // バッファイメージにチャートを描画する
                BufferedImage buffImg = chart.createBufferedImage(1024, 512);
                
                // 出力する画像ファイルのストリームを開く
                fos = new FileOutputStream("graph.png");
                // 画像出力用のストリームでラップする
                ImageOutputStream ios = ImageIO.createImageOutputStream(fos);
                // ImageWriterに画像出力用ストリームを設定する
                imageWriter.setOutput(ios);
                // バッファイメージを画像出力用ストリームに書き込む
                imageWriter.write(buffImg);
                // フラッシュ
                ios.flush();
                // ImageWriterの書込み終了処理
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
                        // 画像ファイルのストリームを閉じる
                        fos.close();
                    }catch(IOException e){}
                }
            }
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}