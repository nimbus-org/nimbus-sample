
�T���v���P

���ڕW
  �T�[�o�[�𗧂Ăă\�P�b�g�ʐM�ŃA�v���P�[�V�������Ăяo���Ă݂悤�B

�����\�[�X�ꗗ
  �E�T�[�r�X��`�t�@�C��
    service-definition.xml
  �E�T���v�����s�N���X�̃\�[�X�t�@�C��
    Main.java
  �E�Ɩ��t���[��`�t�@�C��
    flows\flow-definition.xml

���p�ӂ������
  �ENimbus��Jar
  �EJMX��Jar
  �EJTA��Jar

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -classpath nimbus.jar Main.java
   
  �i�Q�j�T�[�o�[���N������B
      ��F
        java -classpath .;nimbus.jar;jmx.jar;jta.jar  jp.ossc.nimbus.core.ServiceManagerFactory -server service-definition.xml
   
  �i�R�jMain�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar Main
