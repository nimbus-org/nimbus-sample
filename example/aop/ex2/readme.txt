
�T���v���Q

���ڕW
  ���I�A�X�y�N�g���g���Ă݂悤�B

�����\�[�X�ꗗ
  �E�A�X�y�N�g��`�t�@�C��
    aspect-definition.xml
  �E�T�[�r�X��`�t�@�C��
    service-definition.xml
  �E�T�[�r�X�N���X�̃\�[�X�t�@�C��
    sample\service\POJOService.java
    sample\service\Messenger.java
  �E�T���v�����s�N���X�̃\�[�X�t�@�C��
    Main.java
    MainWithAspect.java

���p�ӂ������
  �ENimbus��Jar
  �EJMX��Jar
  �EJavassist��Jar

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -classpath nimbus.jar sample\service\*.java Main.java MainWithAspect.java
   
  �i�Q�j�A�X�y�N�g��`�����[�h���Ȃ�Main�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar Main
   
  �i�R�j�A�X�y�N�g��`�����[�h����MainWithAspect�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar;javassist.jar MainWithAspect

