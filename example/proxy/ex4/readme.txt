
�T���v���S

���ڕW
 �����[�g�̃T�[�r�X���Ăяo�����ɃW���[�i�����o�͂��Ă݂悤�B
 �N���C�A���g���ƃT�[�o���̗����ɃC���^�[�Z�v�^�����ݍ���ŁA�W���[�i�����o�͂�����B

�����\�[�X�ꗗ
  �E�T�[�r�X��`�t�@�C��
    client-service-definition.xml
    server-service-definition.xml
  �E�T���v�����s�N���X�̃\�[�X�t�@�C��
    Main.java
  �E�T�[�r�X�N���X�̃\�[�X�t�@�C��
    sample\service\Messenger.java
    sample\service\POJOService.java

���p�ӂ������
  �ENimbus��Jar
  �EJMX��Jar

�����s
  �i�P�j�R���p�C������B
      ��F
        javac sample\service\*.java
        javac -classpath .;nimbus.jar Main.java
  
  �i�Q�j�T�[�o�v���Z�X���N������B
      ��F
        java -classpath .;nimbus.jar;jmx.jar jp.ossc.nimbus.core.ServiceManagerFactory -server server-service-definition.xml
   
  �i�R�jMain�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar Main
