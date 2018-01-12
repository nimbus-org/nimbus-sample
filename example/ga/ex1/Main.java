
import java.awt.*;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.*;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.ga.GeneticAlgorithm;
import jp.ossc.nimbus.service.ga.Generation;
import jp.ossc.nimbus.service.ga.Genom;
import jp.ossc.nimbus.service.ga.Gene;
import jp.ossc.nimbus.service.ga.DefaultGenom;
import jp.ossc.nimbus.service.ga.ComplexGene;
import jp.ossc.nimbus.service.ga.IntegerGene;
import jp.ossc.nimbus.service.ga.Seed;

/**
 * サンプル１実行クラス。
 */
public class Main extends JFrame{
    
    public Main(){
        this.setSize(900, 900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
     
    public static final void main(String[] args) throws Exception{
         
         // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            GeneticAlgorithm ga  = (GeneticAlgorithm)ServiceManagerFactory.getServiceObject("GeneticAlgorithm");
            
            final int seedNum = Integer.parseInt(args[0]);
            boolean isAsc = Boolean.valueOf(args[1]).booleanValue();
            final int pointNum = Integer.parseInt(args[2]);
            
            // 乱数シードを生成
            Random random = new Random();
            
            // テンプレートとなるSeedを生成
            AreaSeed areaSeed = new AreaSeed(pointNum, 850, 10, 850, 10);
            
            // 初期世代を生成
            Generation generation = ga.createGeneration(random, areaSeed, seedNum, isAsc);
            
            Generation newGeneration = null;
            JFrame frame = new Main();
            AreaPanel areaPanel = new AreaPanel();
            frame.getContentPane().add(areaPanel);
            frame.setVisible(true);
            do{
                // 世代内で競争させて、次世代を生む
                newGeneration = ga.compete(random, generation);
                
                // パネルに遺伝子を設定して、領域を描画させる
                areaPanel.setGenom(generation.getSurvivor().getGenom());
                
                // 世代数と適応値を表示する
                String out = "第" + generation.getGenerationNo() + "世代" + "  " + "適応値：" + generation.getSurvivor().getFitness();
                frame.setTitle(out);
                System.out.println(out);
                
                Thread.sleep(1000);
                
                generation = newGeneration;
            }while(generation != null);
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
         // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
}

/**
 * 領域シード。<p>
 * 複数の座標からなる領域の面積を求める。<br>
 */
class AreaSeed implements Seed, Cloneable{
    
    /**
     * 領域を構成する座標集合を持つ遺伝情報。<p>
     */
    private DefaultGenom genom;
    
    /**
     * 適応値：領域の面積。<p>
     */
    private Number fitness;
    
    /**
     * コンストラクタ。<p>
     *
     * @param pointNum 座標の数
     * @param xMax x座標の最大値
     * @param xMin x座標の最小値
     * @param yMax y座標の最大値
     * @param yMin y座標の最小値
     */
    public AreaSeed(int pointNum, int xMax, int xMin, int yMax, int yMin){
        
        // 遺伝情報を生成する
        genom = new DefaultGenom();
        for(int i = 0; i < pointNum; i++){
            
            // 座標を複合遺伝子として生成する
            ComplexGene pointGene = new ComplexGene();
            pointGene.setName("xy" + (i + 1));
            
            // X座標をint型遺伝子として生成する
            // 突然変異率 1%
            // 乱数交叉遊び 30%
            IntegerGene xGene = new IntegerGene();
            xGene.setName("x");
            xGene.setMutateRate(0.01f);
            xGene.setRandomRangeMargin(0.3f);
            xGene.setMaxValue(xMax);
            xGene.setMinValue(xMin);
            
            // Y座標をint型遺伝子として生成する
            // 突然変異率 1%
            // 乱数交叉遊び 30%
            IntegerGene yGene = new IntegerGene();
            yGene.setName("y");
            yGene.setMutateRate(0.01f);
            yGene.setRandomRangeMargin(0.3f);
            yGene.setMaxValue(yMax);
            yGene.setMinValue(yMin);
            
            pointGene.setGene("x", xGene);
            pointGene.setGene("y", yGene);
            
            genom.addGene(pointGene);
        }
    }
    
    /**
     * 遺伝情報を取得する。<p>
     *
     * @return 遺伝情報
     */
    public Genom getGenom(){
        return genom;
    }
    
    /**
     * 適応値を算出する。<p>
     * 遺伝情報が持つ複数の座標からなる領域の面積を計算して、適応値として格納する。<br>
     * 
     * @param generation 世代
     * @exception Exception 適応値の計算に失敗した場合
     */
    public void fit(Generation generation) throws Exception{
        List geneList = new ArrayList();
        geneList.addAll(genom.getGeneMap().values()); 
        Collections.sort(geneList, new XDescComparator());
        
        ComplexGene maxComplexGene = (ComplexGene)(ComplexGene)geneList.get(0);
        ComplexGene minComplexGene = (ComplexGene)(ComplexGene)geneList.get(geneList.size()-1);
        
        Collections.sort(geneList, new AreaCalculationComparator(minComplexGene, maxComplexGene));
        genom.getGeneMap().clear();
          int total=0;
        for(int i = 0; i < geneList.size(); i ++){
            ComplexGene gene1 = (ComplexGene)geneList.get(i);
            gene1.setName("xy" + (i + 1));
            genom.addGene(gene1);
            
            ComplexGene gene2 = i != geneList.size() - 1 ? (ComplexGene)geneList.get(i + 1) : (ComplexGene)geneList.get(0);
            
            total+=((((Integer)gene1.getGene("x").getValue()).intValue() - ((Integer)gene2.getGene("x").getValue()).intValue())*
                   (((Integer)gene1.getGene("y").getValue()).intValue() + ((Integer)gene2.getGene("y").getValue()).intValue()));
        }
        fitness = (Number)new Integer(Math.abs(total)/2);
    }
    
    /**
     * 適応値を取得する。<p>
     *
     * @return 適応値
     */
    public Number getFitness(){
        return fitness;
    }
    
    /**
     * このシードの複製を作成する。<p>
     *
     * @return 複製されたシード
     */
    public Seed cloneSeed(){
         AreaSeed clone = null;
         try{
             clone = (AreaSeed)super.clone();
         }catch(CloneNotSupportedException e){
             return null;
         }
         clone.genom = (DefaultGenom)genom.cloneGenom();
         clone.fitness = null;
         return clone;
    }
    
    /**
     * 座標を表す複合遺伝子を、x座標の降順でソートするComparator。<p>
     */
    private static class XDescComparator implements Comparator{
        public int compare(Object o1, Object o2){
            ComplexGene cg1 = (ComplexGene)o1;
            ComplexGene cg2 = (ComplexGene)o2;
            return ((Integer)cg2.getGene("x").getValue()).intValue() - ((Integer)cg1.getGene("x").getValue()).intValue();
        }
    }
    
    /**
     * 座標を表す複合遺伝子を、面積計算に必要な並び順でソートするComparator。<p>
     */
    private static class AreaCalculationComparator implements Comparator{
        
        private ComplexGene baseGene;
        private double baseSlope;
        
        public AreaCalculationComparator(ComplexGene minComplexGene, ComplexGene maxComplexGene){
            double basedifferntX = ((Integer)maxComplexGene.getGene("x").getValue()).intValue() - ((Integer)minComplexGene.getGene("x").getValue()).intValue();
            double basediffrentY = ((Integer)maxComplexGene.getGene("y").getValue()).intValue() - ((Integer)minComplexGene.getGene("y").getValue()).intValue();
            baseSlope = basedifferntX == 0.0d ? 0.0d : (basediffrentY / basedifferntX);
            baseGene = minComplexGene;
        }
        
        public int compare(Object o1, Object o2) {
            ComplexGene cg1 = (ComplexGene)o1;
            ComplexGene cg2 = (ComplexGene)o2;
            double differntX = ((Integer)cg1.getGene("x").getValue()).intValue() - ((Integer)baseGene.getGene("x").getValue()).intValue();
            double diffrentY = ((Integer)cg1.getGene("y").getValue()).intValue() - ((Integer)baseGene.getGene("y").getValue()).intValue();
            double slope1 = differntX == 0.0d ? 0.0d : (diffrentY / differntX);
            differntX = ((Integer)cg2.getGene("x").getValue()).intValue() - ((Integer)baseGene.getGene("x").getValue()).intValue();
            diffrentY = ((Integer)cg2.getGene("y").getValue()).intValue() - ((Integer)baseGene.getGene("y").getValue()).intValue();
            double slope2 = differntX == 0.0d ? 0.0d : (diffrentY / differntX);
            if(slope1 > baseSlope && slope2 > baseSlope){
                return ((Integer)cg1.getGene("x").getValue()).intValue() - ((Integer)cg2.getGene("x").getValue()).intValue();
            }else if(slope1 <= baseSlope && slope2 <= baseSlope){
                return ((Integer)cg2.getGene("x").getValue()).intValue() - ((Integer)cg1.getGene("x").getValue()).intValue();
            }else if(slope1 > baseSlope && slope2 <= baseSlope){
                return 1;
            }else{
                return -1;
            }
        }
    }
}

/**
 * 領域パネル。<p>
 */
class AreaPanel extends JPanel{
    
    private Genom genom;
    
    public void setGenom(Genom genom){
        this.genom = genom;
        repaint();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(genom == null){
            return;
        }
        g.setColor(Color.BLACK);
        ComplexGene[] genes = (ComplexGene[])genom.getGeneMap().values().toArray(new ComplexGene[genom.getGeneMap().size()]);
        for(int i = 0; i < genes.length; i ++){
            ComplexGene gene1 = (ComplexGene)genes[i];
            ComplexGene gene2 = i != genes.length - 1 ? genes[i + 1] : genes[0];
            g.drawString(
                gene1.getName() + "(" + ((Integer)gene1.getGene("x").getValue()).intValue() + ", " + ((Integer)gene1.getGene("y").getValue()).intValue() + ")",
                ((Integer)gene1.getGene("x").getValue()).intValue(),
                ((Integer)gene1.getGene("y").getValue()).intValue()
            );
            
            g.drawLine(
                ((Integer)gene1.getGene("x").getValue()).intValue(),
                ((Integer)gene1.getGene("y").getValue()).intValue(),
                ((Integer)gene2.getGene("x").getValue()).intValue(),
                ((Integer)gene2.getGene("y").getValue()).intValue()
            );
        }
    }
}