
�T���v���P

���ڕW
  JVM���N���X�^�����Ă݂悤�B

�����\�[�X�ꗗ
  �E�T�[�r�X��`�t�@�C��
    service-definition.xml
  �Ejp.ossc.nimbus.service.keepalive.ClusterListener�C���^�t�F�[�X�̃T���v�������N���X�̃\�[�X�t�@�C��
    ClusterListener.java
  �E�T���v�����s�N���X�̃\�[�X�t�@�C��
    Main.java

���p�ӂ������
  �ENimbus��Jar
  �EJMX��Jar

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -classpath nimbus.jar ClusterListener.java Main.java
   
  �i�Q�j�N���X�^�N���C�A���g�Ƃ���Main�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar -DisClient=true Main
   
  �i�R�j�N���X�^�T�[�o�P�Ƃ���Main�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar -DisClient=false Main
   
  �i�S�j�N���X�^�T�[�o�Q�Ƃ���Main�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar -DisClient=false Main
