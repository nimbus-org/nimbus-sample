
�T���v���V

���ڕW
  �����C���^�[�Z�v�^���A�X�y�N�g���Ă݂悤�B

�����\�[�X�ꗗ
  �E�A�X�y�N�g��`�t�@�C��
    aspect-definition1.xml
    aspect-definition2.xml
    aspect-definition3.xml
    aspect-definition4.xml
  �E�T�[�r�X��`�t�@�C��
    service-definition.xml
  �E�T�[�r�X�N���X�̃\�[�X�t�@�C��
    sample\service\POJOService1.java
    sample\service\POJOService2.java
    sample\service\Messenger.java
  �E�T���v�����s�N���X�̃\�[�X�t�@�C��
    Main1.java
    Main2.java
    Main3.java
    Main4.java

���p�ӂ������
  �ENimbus��Jar
  �EJMX��Jar
  �EJavassist��Jar

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -classpath nimbus.jar sample\service\*.java Main*.java
   
  �i�Q�jMain1�`Main4�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar;javassist.jar Main1

