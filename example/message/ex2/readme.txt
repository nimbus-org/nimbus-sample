
�T���v���Q

���ڕW
 ���b�Z�[�W�����ۉ��Ή����Ă݂悤�B

�����\�[�X�ꗗ
  �E�T�[�r�X��`�t�@�C��
    service-definition.xml
  �E�T���v�����s�N���X�̃\�[�X�t�@�C��
    Main.java
  �E���O���b�Z�[�W��`�t�@�C��
    MyMessage1.def
    MyMessage1_ja.def.src
    MyMessage1_de.def

���p�ӂ������
  �ENimbus��Jar
  �EJMX��Jar

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -classpath nimbus.jar Main.java
   
  �i�Q�j���{��p�̃��b�Z�[�W��`�t�@�C�������j�R�[�h�ɕϊ�����B
      ��F
        native2ascii MyMessage1_ja.def.src MyMessage1_ja.def
   
  �i�R�jMain�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar Main
