
�T���v���Q

���ڕW
 �Ɩ��t���[�Ŏ��R�ɕϊ����Ă݂悤�B

�����\�[�X�ꗗ
  �E�T�[�r�X��`�t�@�C��
    service-definition.xml
  �E�T���v�����s�N���X�̃\�[�X�t�@�C��
    Main.java
  �E�T���v��Bean�N���X�̃\�[�X�t�@�C��
    sample\Bean1.java
    sample\Bean2.java

���p�ӂ������
  �ENimbus��Jar
  �EJMX��Jar
  �Ecommons-jexl��Jar

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -classpath nimbus.jar Main.java sample\*.java
   
  �i�Q�jMain�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar;commons-jexl.jar Main
