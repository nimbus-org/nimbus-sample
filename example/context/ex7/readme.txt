
�T���v���V

���ڕW
 JVM�ԂŃR���e�L�X�g�����L���āA�g�����U�N�V�����X�V���Ă݂悤�B

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
   
  �i�T�j�i�Q�j�ŋN������Main�N���X�R�̃R���\�[���ňȉ�����͂���B
      put 1 test 100
      put 2 test 200
   
  �i�U�j�i�R�j�i�S�j�ŋN������Main�N���X�P�A�Q�̃R���\�[���ňȉ�����͂���B
      get 1 test
      get 2 test
   
  �i�V�j�i�Q�j�ŋN������Main�N���X�R�̃R���\�[���ňȉ�����͂���B
      begin
      put 1 test 101
      put 2 test 201
   
  �i�W�j�i�R�j�i�S�j�ŋN������Main�N���X�P�A�Q�̃R���\�[���ňȉ�����͂���B
      get 1 test
      get 2 test
   
  �i�X�j�i�Q�j�ŋN������Main�N���X�R�̃R���\�[���ňȉ�����͂���B
      commit
      �܂���
      rollback
   
  �i�P�O�j�i�R�j�i�S�j�ŋN������Main�N���X�P�A�Q�̃R���\�[���ňȉ�����͂���B
      get 1 test
      get 2 test
