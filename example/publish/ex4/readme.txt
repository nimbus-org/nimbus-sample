
�T���v���S

���ڕW
 �R�l�N�V�����𕪎U���āA�P�Α��ł̃��b�Z�[�W�z�M�����Ă݂悤�B

�����\�[�X�ꗗ
  �E�T�[�r�X��`�t�@�C��
    service-definition.xml
  �E�T���v�����s�N���X�̃\�[�X�t�@�C��
    Main.java
    SampleMessageListener.java

���p�ӂ������
  �ENimbus��Jar
  �EJMX��Jar

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -classpath nimbus.jar Main.java SampleMessageListener.java
   
  �i�Q�j�T�u�W�F�N�g"hoge"�ɔC�ӂ̃L�[�Ń��b�Z�[�W�𑗐M����Main�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar -DMode=Server Main
   
  �i�R�j�T�u�W�F�N�g"hoge"�̃��b�Z�[�W����M����N���C�A���g�P���N������B
      ��F
        java -classpath .;nimbus.jar;jmx.jar -DMode=Client jp.ossc.nimbus.core.ServiceManagerFactory -server service-definition.xml
   
  �i�S�j�T�u�W�F�N�g"hoge"�̃��b�Z�[�W����M����N���C�A���g�Q���N������B
      ��F
        java -classpath .;nimbus.jar;jmx.jar -DMode=Client jp.ossc.nimbus.core.ServiceManagerFactory -server service-definition.xml
   
  �i�T�j�i�Q�j�ŋN������Main�N���X�̃R���\�[���ŔC�ӂ̃L�[�Ń��b�Z�[�W����͂���B
