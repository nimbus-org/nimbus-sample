
�T���v���P

���ڕW
 �Ɩ��t���[��XML��`�Ő��䂵�Ă݂悤�B
 BeanFlowInvokerFactory�T�[�r�X���g���Ă݂悤�B

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
  �EJakarta Commons Jexl��Jar
  �EJakarta Commons Logging��Jar
  �EJBoss

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -classpath nimbus.jar Main.java
   
  �i�Q�jMain�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar;jta.jar;C:\JBoss-3.2.7\server\default\lib\hsqldb.jar;commons-jexl-X.X.jar;commons-logging-X.X.X.jar Main
