
�T���v���T

���ڕW
 ���[�J���̃T�[�r�X���Ăяo�����ɃW���[�i�����o�͂��Ă݂悤�B
 �C���^�[�Z�v�^�����ݍ���ŁA�W���[�i�����o�͂�����B

�����\�[�X�ꗗ
  �E�T�[�r�X��`�t�@�C��
    service-definition.xml
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
        javac -classpath nimbus.jar Main.java sample\service\*.java
   
  �i�Q�jMain�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar Main
