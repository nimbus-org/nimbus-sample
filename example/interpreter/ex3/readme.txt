
�T���v���R

���ڕW
  �R�}���h�x�[�X�ŁA��VM���Java���C���^�[�v���b�g���s���Ă݂悤�B

�����\�[�X�ꗗ
  �E�T�[�r�X��`�t�@�C��
    service-definition.xml
  �E�C���^�[�v���^���s����\�[�X�R�[�h�t�@�C��
    sample.txt
  �EJBoss�T�[�r�X�A�[�J�C�u
    sample.sar
    
    �E�T�[�r�X��`�t�@�C��
      sample.sar\service-definition.xml
    �EJBoss�T�[�r�X��`�t�@�C��
      sample.sar\META-INF\jboss-service.xml

���p�ӂ������
  �ENimbus��Jar
  �EJMX��Jar
  �EBeanShell��Jar
  �EJBoss

�����s
  
  �i�P�jJBoss��Nimbus��Jar�t�@�C����u���B
      ��F
        C:\JBoss-3.2.7\server\default\lib��Nimbus��Jar�t�@�C�����R�s�[����
  
  �i�Q�jJBoss���N������B
      ��F
        C:\JBoss-3.2.7\bin\run.bat
  
  �i�R�jJBoss�Ƀz�b�g�f�v���C����B
      ��F
        C:\JBoss-3.2.7\server\default\deploy��sample.sar�t�H���_���R�s�[����
   
  �i�S�j�R�}���h�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar;bsh.jar jp.ossc.nimbus.service.interpreter.BeanShellInterpreterService -servicepath service-definition.xml -file sample.txt
