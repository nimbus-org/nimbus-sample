
�T���v���Q

���ڕW
 �X�P�W���[�����f�[�^�x�[�X�ŊǗ����Ă݂悤�B

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

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -classpath nimbus.jar Main.java
   
  �i�Q�jMain�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar;jta.jar;C:\JBoss-3.2.7\server\default\lib\hsqldb.jar Main
      �X�P�W���[�������s����A�f�[�^�x�[�X�Ɏ��s���ꂽ��Ԃ��ۑ������B
  �i�R�jSQL�Ńf�[�^�x�[�X�̏�Ԃ��m�F����B
      ��F
        java -classpath C:\JBoss-3.2.7\server\default\lib\hsqldb.jar org.hsqldb.util.SqlTool --rcfile sqltool.rc localDB
        sql> select * from schedule;
  �i�S�j�ēxMain�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar;jta.jar Main
      ��Ԃ��ۑ�����Ă��邽�߁A�����X�P�W���[���͎��s����Ȃ��B
