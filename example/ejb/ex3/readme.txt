
�T���v���R

���ڕW
 �����EJB(EJB2.X)���Ăяo�������̃T�[�r�X���O���[�s���O���Ă݂悤�B

�����\�[�X�ꗗ
  �E�T�[�r�X��`�t�@�C��
    service-definition.xml
  �E�T���v�����s�N���X�̃\�[�X�t�@�C��
    Main.java
  �E�T���v�� EJB Jar
    sample.jar
    
    �EEJB�z�u�L�q�q�t�@�C��
      sample.jar\META-INF\ejb-jar.xml
    �EJBoss�pEJB�z�u�L�q�q�t�@�C��
      sample.jar\META-INF\jboss.xml
    �EEJB�N���X�̃\�[�X�t�@�C��
      sample.jar\sample\ejb\Messenger.java
      sample.jar\sample\ejb\MessengerHome.java
      sample.jar\sample\ejb\MessengerHome2.java
      sample.jar\sample\ejb\MessengerBean.java
      sample.jar\sample\ejb\MessengerBean2.java

���p�ӂ������
  �ENimbus��Jar
  �EJMX��Jar
  �EJBoss

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -classpath C:\JBoss-3.2.7\client\jboss-j2ee.jar sample\ejb\*.java
        javac -classpath C:\JBoss-3.2.7\client\jboss-j2ee.jar;nimbus.jar;sample.jar Main.java
  
  �i�Q�jJBoss��Nimbus��Jar�t�@�C����u���B
      ��F
        C:\JBoss-3.2.7\server\default\lib��Nimbus��Jar�t�@�C�����R�s�[����
  
  �i�R�jJBoss���N������B
      ��F
        C:\JBoss-3.2.7\bin\run.bat
  
  �i�S�jJBoss�Ƀz�b�g�f�v���C����B
      ��F
        C:\JBoss-3.2.7\server\default\deploy��sample.jar�t�H���_���R�s�[����
   
  �i�T�jMain�N���X�����s����B
      ��F
        java -classpath .;sample.jar;nimbus.jar;C:\JBoss-3.2.7\client\jbossall-client.jar Main
