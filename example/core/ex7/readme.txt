
�T���v���V

���ڕW
  �T�[�r�X��`�������ɉ����Đ؂�ւ��Ă݂悤�B

�����\�[�X�ꗗ
  �E�T�[�r�X��`�t�@�C��
    service-definition.xml
  �E�T�[�r�X�N���X�̃\�[�X�t�@�C��
    sample\service\POJOService.java
  �E�T���v�����s�N���X�̃\�[�X�t�@�C��
    Main.java

���p�ӂ������
  �ENimbus��Jar
  �EJMX��Jar

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -classpath nimbus.jar sample\service\POJOService.java Main.java
   
  �i�Q�j�V�X�e���v���p�e�B��ς��Ȃ���Main�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar -DService1=enable Main
        java -classpath .;nimbus.jar;jmx.jar -DService1=enable -DMessage=false -DInitState=Created Main
        java -classpath .;nimbus.jar;jmx.jar Main

