
�T���v���P

���ڕW
  �ÓI�A�X�y�N�g���g���Ă݂悤�B

�����\�[�X�ꗗ
  �E�A�X�y�N�g��`�t�@�C��
    aspect-definition.xml
  �E�T�[�r�X��`�t�@�C��
    service-definition.xml
  �E�T�[�r�X�N���X�̃\�[�X�t�@�C��
    sample\service\POJOService.java
  �E�T���v�����s�N���X�̃\�[�X�t�@�C��
    Main.java

���p�ӂ������
  �ENimbus��Jar
  �EJMX��Jar
  �EJavassist��Jar

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -classpath nimbus.jar sample\service\POJOService.java Main.java
   
  �i�Q�jMain�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar;javassist.jar Main
   
  �i�R�j�A�X�y�N�g�R���p�C������B
      ��F
        java -classpath .;nimbus.jar;jmx.jar;javassist.jar jp.ossc.nimbus.service.aop.Compiler -servicepath aspect-definition.xml -d . sample.service.POJOService
   
  �i�S�j�A�X�y�N�g�R���p�C����̃N���X���g���āAMain�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar;javassist.jar Main

