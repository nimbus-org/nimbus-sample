
�T���v���Q

���ڕW
 �����[�g�̃T�[�r�X��EJB���o�R���ČĂяo���Ă݂悤�B
 EJB���o�R���ČĂяo�����ŁAEJB�R���e�i�̎����ʐ����N���X�^�����O�̋@�\��
 ���p�ł���悤�ɂȂ�B

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
      sample.sar\sample\service\Messenger.java
      sample.sar\sample\service\POJOService.java
  �EEJB�A�[�J�C�u
    sample.jar
    
    �EEJB�z�u�L�q�q�t�@�C��
      sample.sar\META-INF\ejb-jar.xml
    �EJBoss�pEJB�z�u�L�q�q�t�@�C��
      sample.sar\META-INF\jboss.xml

���p�ӂ������
  �ENimbus��Jar
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
        C:\JBoss-3.2.7\server\default\deploy��sample.jar�t�H���_���R�s�[����
   
  �i�T�jMain�N���X�����s����B
      ��F
        java -classpath .;sample.sar;nimbus.jar;C:\JBoss-3.2.7\client\jbossall-client.jar Main
