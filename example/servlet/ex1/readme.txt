
�T���v���P

���ڕW
  �T�[�r�X���T�[�u���b�g�R���e�i�Ƀf�v���C���Ă݂悤�B

�����\�[�X�ꗗ
  �EWeb�A�v���P�[�V�����A�[�J�C�u
    sample.war
    
    �E�T�[�r�X��`�t�@�C��
      sample.war\service-definition.xml
    �EWeb�A�v���P�[�V�����z�u�L�q�q�t�@�C��
      sample.war\WEB-INF\web.xml
    �E�T�[�r�X�N���X�̃\�[�X�t�@�C��
      sample.war\WEB-INF\classes\sample\service\POJOService.java

���p�ӂ������
  �ENimbus��Jar
  �E�T�[�u���b�g�R���e�i�i���̃T���v���ł�JBoss���g�p����j

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -d sample.war\WEB-INF\classes -classpath nimbus.jar sample.war\WEB-INF\classes\sample\service\POJOService.java

  
  �i�Q�jJBoss��Nimbus��Jar�t�@�C����u���B
      ��F
        C:\JBoss-3.2.7\server\default\lib��Nimbus��Jar�t�@�C�����R�s�[����
  
  �i�R�jJBoss���N������B
      ��F
        C:\JBoss-3.2.7\bin\run.bat
  
  �i�S�jJBoss�Ƀz�b�g�f�v���C����B
      ��F
        C:\JBoss-3.2.7\server\default\deploy��sample.war�t�H���_���R�s�[����
  
  �i�T�jJBoss��JMX�R���\�[���Ŋm�F����
      ��F
        �u���E�U�ŁAhttp://localhost:8080/jmx-console/�ɃA�N�Z�X����B
        JMX�R���\�[����Nimbus�h���C���ɁAJMX�I�u�W�F�N�g��
        class=sample.service.POJOService,name=Service1
        �Ƃ��āANimbus�ɓo�^�����T�[�r�X��MBean�Ƃ��ēo�^����Ă��鎖���m�F�ł���B
  
  �i�U�jJBoss����A���f�v���C����B
      ��F
        C:\JBoss-3.2.7\server\default\deploy����sample.war�t�H���_���폜����
  
  �i�V�jJBoss��JMX�R���\�[���Ŋm�F����
      ��F
        �u���E�U�ŁAhttp://localhost:8080/jmx-console/�ɃA�N�Z�X����B
        JMX�R���\�[����Nimbus�h���C�����Ȃ��Ȃ��Ă��鎖���m�F�ł���B
