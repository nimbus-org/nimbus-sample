
�T���v���S

���ڕW
 �X�P�W���[���[���g���ďW�z�M���Ǘ����Ă݂悤�B

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
  �EJBoss
  �EJakarta Commons Jexl��Jar
  �EJakarta Commons Logging��Jar

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -classpath nimbus.jar Main.java
   
  �i�Q�jMain�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar;jta.jar;C:\JBoss-3.2.7\server\default\lib\hsqldb.jar Main
      �X�P�W���[�������s����A�f�[�^�x�[�X�Ɏ��s���ꂽ��Ԃ��ۑ������B
  �i�R�j�ēxMain�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar;jta.jar;commons-jexl-X.X.jar;commons-logging-X.X.X.jar Main
      ��Ԃ��ۑ�����Ă��邽�߁A�����X�P�W���[���͎��s����Ȃ��B
