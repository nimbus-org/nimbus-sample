
�T���v���U

���ڕW
 JVM�ԂŃR���e�L�X�g�𕪎U���L���Ă݂悤�B

�����\�[�X�ꗗ
  �E�T�[�r�X��`�t�@�C��
    service-definition.xml
  �E�T���v�����s�N���X�̃\�[�X�t�@�C��
    Main.java


���p�ӂ������
  �ENimbus��Jar
  �EJMX��Jar

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -classpath nimbus.jar Main.java
   
  �i�Q�j���L�R���e�L�X�g���z�X�e�B���O����Main�N���X�P�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar -DPort=10001 -DClient=false Main
   
  �i�R�j���L�R���e�L�X�g���z�X�e�B���O����Main�N���X�Q�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar -DPort=10002 -DClient=false Main
   
  �i�S�j���L�R���e�L�X�g���Q�Ƃ���Main�N���X�R�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar -DPort=10003 -DClient=true Main
   
  �i�T�j�i�Q�j�i�R�j�i�S�j�ŋN�������R���\�[���ňȉ�����͂���B
      size
   
  �i�U�j�i�Q�j�ŋN������Main�N���X�P�̃R���\�[���ňȉ�����͂���B
      put test 1
   
  �i�V�j�i�Q�j�i�R�j�i�S�j�ŋN�������R���\�[���ňȉ�����͂���B
      size
      get test
      size
   
  �i�W�j�i�R�j�ŋN������Main�N���X�Q�̃R���\�[���ňȉ�����͂���B
      clear
   
  �i�X�j�i�Q�j�i�R�j�i�S�j�ŋN�������R���\�[���ňȉ�����͂���B
      size
