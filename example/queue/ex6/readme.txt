
�T���v���U

���ڕW
 JVM�Ԃ�Queue�����L���Ă݂悤�B

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
   
  �i�Q�j���L�L���[����GET���āA100[ms]�̏������Ԃ�������v���Z�X�P�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar Main GET 100
   
  �i�R�j���L�L���[����GET���āA100[ms]�̏������Ԃ�������v���Z�X�Q�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar Main GET 100
   
  �i�S�j���L�L���[��100��PUSH����v���Z�X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar Main PUT 100
