
�T���v���P�O

���ڕW
  ���g���C�C���^�[�Z�v�^���A�X�y�N�g���Ă݂悤�B

�����\�[�X�ꗗ
  �E�A�X�y�N�g��`�t�@�C��
    aspect-definition.xml
  �E�T�[�r�X��`�t�@�C��
    service-definition.xml
  �E�T�[�r�X�N���X�̃\�[�X�t�@�C��
    sample\service\Caller.java
    sample\service\POJOService.java
  �E�T���v�����s�N���X�̃\�[�X�t�@�C��
    Main.java

���p�ӂ������
  �ENimbus��Jar
  �EJMX��Jar
  �EJavassist��Jar
  �EJakarta Commons Jexl��Jar
  �EJakarta Commons Logging��Jar

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -classpath nimbus.jar sample\service\*.java Main.java
   
  �i�Q�jMain�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar;javassist.jar;commons-jexl-X.X.jar;commons-logging-X.X.X.jar Main

