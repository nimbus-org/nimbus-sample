
�T���v���R

���ڕW
 �����[�g��MBean���Ăяo���Ă݂悤�B

�����\�[�X�ꗗ
  �E�T�[�r�X��`�t�@�C��
    service-definition.xml
  �E�T���v�����s�N���X�̃\�[�X�t�@�C��
    Main.java
  �EJBoss�T�[�r�X�A�[�J�C�u
    sample.sar
    
    �E�T�[�r�X��`�t�@�C��
      sample.sar\service-definition.xml
    �EJBoss�T�[�r�X��`�t�@�C��
      sample.sar\META-INF\jboss-service.xml
    �E�T�[�r�X�N���X�̃\�[�X�t�@�C��
      sample.sar\sample\service\POJOService.java
      sample.sar\sample\service\POJOServiceMBean.java

���p�ӂ������
  �ENimbus��Jar
  �EJMX��Jar
  �EJBoss

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -d sample.sar sample.sar\sample\service\*.java
        javac -classpath sample.sar;nimbus.jar Main.java
  
  �i�Q�jJBoss��Nimbus��Jar�t�@�C����u���B
      ��F
        C:\JBoss-3.2.7\server\default\lib��Nimbus��Jar�t�@�C�����R�s�[����
  
  �i�R�jJBoss���N������B
      ��F
        C:\JBoss-3.2.7\bin\run.bat
  
  �i�S�jJBoss�Ƀz�b�g�f�v���C����B
      ��F
        C:\JBoss-3.2.7\server\default\deploy��sample.sar�t�H���_���R�s�[����
   
  �i�T�jMain�N���X�����s����B
      ��F
        java -classpath .;sample.sar;nimbus.jar;jmx.jar;C:\JBoss-3.2.7\client\jbossall-client.jar Main
