
�T���v���W

���ڕW
 �����[�g�̃R���\�[���ɏo�͂��Ă݂悤�B

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
   
  �i�Q�j�T�[�o���N������B
      ��F
        java -classpath .;nimbus.jar;jmx.jar -DMode=Server jp.ossc.nimbus.core.ServiceManagerFactory -server service-definition.xml
   
  �i�R�jMain�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar -DMode=Client -DClient=Client1 Main
