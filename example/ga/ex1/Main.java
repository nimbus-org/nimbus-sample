
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
 * �T���v���P���s�N���X�B
 */
public class Main extends JFrame{
    
    public Main(){
        this.setSize(900, 900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
     
    public static final void main(String[] args) throws Exception{
         
         // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            GeneticAlgorithm ga  = (GeneticAlgorithm)ServiceManagerFactory.getServiceObject("GeneticAlgorithm");
            
            final int seedNum = Integer.parseInt(args[0]);
            boolean isAsc = Boolean.valueOf(args[1]).booleanValue();
            final int pointNum = Integer.parseInt(args[2]);
            
            // �����V�[�h�𐶐�
            Random random = new Random();
            
            // �e���v���[�g�ƂȂ�Seed�𐶐�
            AreaSeed areaSeed = new AreaSeed(pointNum, 850, 10, 850, 10);
            
            // ��������𐶐�
            Generation generation = ga.createGeneration(random, areaSeed, seedNum, isAsc);
            
            Generation newGeneration = null;
            JFrame frame = new Main();
            AreaPanel areaPanel = new AreaPanel();
            frame.getContentPane().add(areaPanel);
            frame.setVisible(true);
            do{
                // ������ŋ��������āA������𐶂�
                newGeneration = ga.compete(random, generation);
                
                // �p�l���Ɉ�`�q��ݒ肵�āA�̈��`�悳����
                areaPanel.setGenom(generation.getSurvivor().getGenom());
                
                // ���㐔�ƓK���l��\������
                String out = "��" + generation.getGenerationNo() + "����" + "  " + "�K���l�F" + generation.getSurvivor().getFitness();
                frame.setTitle(out);
                System.out.println(out);
                
                Thread.sleep(1000);
                
                generation = newGeneration;
            }while(generation != null);
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
         // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
}

/**
 * �̈�V�[�h�B<p>
 * �����̍��W����Ȃ�̈�̖ʐς����߂�B<br>
 */
class AreaSeed implements Seed, Cloneable{
    
    /**
     * �̈���\��������W�W��������`���B<p>
     */
    private DefaultGenom genom;
    
    /**
     * �K���l�F�̈�̖ʐρB<p>
     */
    private Number fitness;
    
    /**
     * �R���X�g���N�^�B<p>
     *
     * @param pointNum ���W�̐�
     * @param xMax x���W�̍ő�l
     * @param xMin x���W�̍ŏ��l
     * @param yMax y���W�̍ő�l
     * @param yMin y���W�̍ŏ��l
     */
    public AreaSeed(int pointNum, int xMax, int xMin, int yMax, int yMin){
        
        // ��`���𐶐�����
        genom = new DefaultGenom();
        for(int i = 0; i < pointNum; i++){
            
            // ���W�𕡍���`�q�Ƃ��Đ�������
            ComplexGene pointGene = new ComplexGene();
            pointGene.setName("xy" + (i + 1));
            
            // X���W��int�^��`�q�Ƃ��Đ�������
            // �ˑR�ψٗ� 1%
            // ���������V�� 30%
            IntegerGene xGene = new IntegerGene();
            xGene.setName("x");
            xGene.setMutateRate(0.01f);
            xGene.setRandomRangeMargin(0.3f);
            xGene.setMaxValue(xMax);
            xGene.setMinValue(xMin);
            
            // Y���W��int�^��`�q�Ƃ��Đ�������
            // �ˑR�ψٗ� 1%
            // ���������V�� 30%
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
     * ��`�����擾����B<p>
     *
     * @return ��`���
     */
    public Genom getGenom(){
        return genom;
    }
    
    /**
     * �K���l���Z�o����B<p>
     * ��`��񂪎������̍��W����Ȃ�̈�̖ʐς��v�Z���āA�K���l�Ƃ��Ċi�[����B<br>
     * 
     * @param generation ����
     * @exception Exception �K���l�̌v�Z�Ɏ��s�����ꍇ
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
     * �K���l���擾����B<p>
     *
     * @return �K���l
     */
    public Number getFitness(){
        return fitness;
    }
    
    /**
     * ���̃V�[�h�̕������쐬����B<p>
     *
     * @return �������ꂽ�V�[�h
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
     * ���W��\��������`�q���Ax���W�̍~���Ń\�[�g����Comparator�B<p>
     */
    private static class XDescComparator implements Comparator{
        public int compare(Object o1, Object o2){
            ComplexGene cg1 = (ComplexGene)o1;
            ComplexGene cg2 = (ComplexGene)o2;
            return ((Integer)cg2.getGene("x").getValue()).intValue() - ((Integer)cg1.getGene("x").getValue()).intValue();
        }
    }
    
    /**
     * ���W��\��������`�q���A�ʐόv�Z�ɕK�v�ȕ��я��Ń\�[�g����Comparator�B<p>
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
 * �̈�p�l���B<p>
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