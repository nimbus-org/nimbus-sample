
�T���v���V

���ڕW
 �C�ӂ�Bean���t�H�[�}�b�g���āA�R���\�[���ɏo�͂��Ă݂悤�B

�����\�[�X�ꗗ
  �E�T�[�r�X��`�t�@�C��
    service-definition.xml
  �E�T���v�����s�N���X�̃\�[�X�t�@�C��
    Main.java
  �E�o�͏��N���X�̃\�[�X�t�@�C��
    sample\SampleRecord.java
    sample\User.java

���p�ӂ������
  �ENimbus��Jar
  �EJMX��Jar

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -classpath nimbus.jar Main.java sample\*.java
   
  �i�Q�jMain�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar Main
