
�T���v���T

���ڕW
 �R�l�N�V�������N���X�^�����āA�P�Α��ł̃��b�Z�[�W�z�M�����Ă݂悤�B

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
   
  �i�Q�j�T�u�W�F�N�g"hoge"�ɔC�ӂ̃��b�Z�[�W�𑗐M����Main�N���X�P�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar -DMode=Server Main
   
  �i�R�j�T�u�W�F�N�g"hoge"�ɔC�ӂ̃��b�Z�[�W�𑗐M����Main�N���X�Q�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar -DMode=Server Main
   
  �i�S�j�T�u�W�F�N�g"hoge"�̃��b�Z�[�W����M����N���C�A���g���N������B
      ��F
        java -classpath .;nimbus.jar;jmx.jar -DMode=Client jp.ossc.nimbus.core.ServiceManagerFactory -server service-definition.xml
   
  �i�T�j�i�Q�j�ŋN������Main�N���X�P�̃R���\�[���ŔC�ӂ̃��b�Z�[�W����͂���B
   
  �i�U�j�i�Q�j�ŋN������Main�N���X�P�̃R���\�[�����I������B
   
  �i�V�j�i�R�j�ŋN������Main�N���X�Q�̃R���\�[���ŔC�ӂ̃��b�Z�[�W����͂���B
