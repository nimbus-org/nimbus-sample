
�T���v���T

���ڕW
  �T�[�r�X��JMX�T�[�o�ɓo�^���Ă݂悤�B

�����\�[�X�ꗗ
  �EJBoss�T�[�r�X�A�[�J�C�u
    sample.sar
    
    �E�T�[�r�X��`�t�@�C��
      sample.sar\service-definition.xml
    �EJBoss�T�[�r�X��`�t�@�C��
      sample.sar\META-INF\jboss-service.xml
    �E�T�[�r�X�N���X�̃\�[�X�t�@�C��
      sample.sar\sample\service\POJOService.java
      sample.sar\sample\service\POJOService2.java
      sample.sar\sample\service\POJOService2MBean.java

���p�ӂ������
  �ENimbus��Jar
  �EJBoss

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -classpath nimbus.jar sample\service\*.java
  
  �i�Q�jJBoss��Nimbus��Jar�t�@�C����u���B
      ��F
        C:\JBoss-3.2.7\server\default\lib��Nimbus��Jar�t�@�C�����R�s�[����
  
  �i�R�jJBoss���N������B
      ��F
        C:\JBoss-3.2.7\bin\run.bat
  
  �i�S�jJBoss�Ƀz�b�g�f�v���C����B
      ��F
        C:\JBoss-3.2.7\server\default\deploy��sample.sar�t�H���_���R�s�[����
  
  �i�T�jJBoss��JMX�R���\�[���Ŋm�F����
      ��F
        �u���E�U�ŁAhttp://localhost:8080/jmx-console/�ɃA�N�Z�X����B
        JMX�R���\�[����Nimbus�h���C���ɁAJMX�I�u�W�F�N�g��
        class=sample.service.POJOService,name=Service1
        �Ƃ��āANimbus�ɓo�^�����T�[�r�X��MBean�Ƃ��ēo�^����Ă��鎖���m�F�ł���B
  
  �i�U�jJBoss����A���f�v���C����B
      ��F
        C:\JBoss-3.2.7\server\default\deploy����sample.sar�t�H���_���폜����
  
  �i�V�jJBoss��JMX�R���\�[���Ŋm�F����
      ��F
        �u���E�U�ŁAhttp://localhost:8080/jmx-console/�ɃA�N�Z�X����B
        JMX�R���\�[����Nimbus�h���C�����Ȃ��Ȃ��Ă��鎖���m�F�ł���B
