
�T���v���P

���ڕW
 Nimbus IOC���g���Ă݂悤�B
 �N���C�A���g�v���O�����ŁA�g�����U�N�V�����̐�����s���Ȃ���ABean�t���[�����s����B

�����\�[�X�ꗗ
  �EIOC�Ăяo���T�[�r�X��`�t�@�C��
    service-definition.xml
  �E�T���v�����s�N���X�̃\�[�X�t�@�C��
    Main.java
  �EIOC EJB Jar
    ioc-facade.jar
    
    �EEJB�z�u�L�q�q�t�@�C��
      ioc-facade.jar\META-INF\ejb-jar.xml
    �EJBoss�pEJB�z�u�L�q�q�t�@�C��
      ioc-facade.jar\META-INF\jboss.xml
  �EIOC�T�[�r�X�A�[�J�C�u
    nimbus.sar
    
    �EJBoss�p�T�[�r�X�A�[�J�C�u�z�u�L�q�q�t�@�C��
      nimbus.sar\META-INF\jboss.xml
    �EIOC�T�[�r�X��`�t�@�C��
      nimbus.sar\service-definition.xml

���p�ӂ������
  �ENimbus��Jar
  �EJMX��Jar
  �EJakarta Commons Jexl��Jar
  �EJBoss

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -classpath nimbus.jar Main.java
  
  �i�Q�jJBoss�ɕK�v��Jar�t�@�C����u���B
      ��F
        C:\JBoss-3.2.7\server\default\lib��Nimbus��Jar�t�@�C�����R�s�[����
        C:\JBoss-3.2.7\server\default\lib��Jakarta Commons Jexl��Jar�t�@�C�����R�s�[����
  
  �i�R�jJBoss�Ƀf�v���C����B
      ��F
        C:\JBoss-3.2.7\server\default\deploy��ioc-facade.jar�t�H���_���R�s�[����
        C:\JBoss-3.2.7\server\default\deploy��nimbus.sar�t�H���_���R�s�[����
  
  �i�S�jJBoss���N������B
      ��F
        C:\JBoss-3.2.7\bin\run.bat
   
  �i�T�jMain�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;C:\JBoss-3.2.7\client\jbossall-client.jar Main
