
�T���v���U

���ڕW
 �����[�g�̃T�[�r�X���N���X�^�����ČĂяo���Ă݂悤�B

�����\�[�X�ꗗ
  �E�T�[�r�X��`�t�@�C��
    service-definition.xml
  �E�T���v�����s�N���X�̃\�[�X�t�@�C��
    Main.java

���p�ӂ������
  �ENimbus��Jar
  �EJMX��Jar

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -classpath nimbus.jar Main.java
   
  �i�Q�j�T�[�o�P���N������B
      ��F
        java -classpath .;nimbus.jar;jmx.jar -DMode=Server jp.ossc.nimbus.core.ServiceManagerFactory -server service-definition.xml
   
  �i�R�j�T�[�o�Q���N������B
      ��F
        java -classpath .;nimbus.jar;jmx.jar -DMode=Server jp.ossc.nimbus.core.ServiceManagerFactory -server service-definition.xml
   
  �i�S�jMain�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar -DMode=Client Main
   
  �i�T�j�T�[�o�v���Z�X�P�𗎂Ƃ��B
   
  �i�U�j�T�[�o�v���Z�X�Q�𗎂Ƃ��B
