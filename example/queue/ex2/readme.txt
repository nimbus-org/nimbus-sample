
�T���v���Q

���ڕW
 �L���[���g���Ĕ񓯊����������Ă݂悤�B

�����\�[�X�ꗗ
  �E�T�[�r�X��`�t�@�C��
    service-definition.xml
  �E�T���v��QueueHandler�N���X�̃\�[�X�t�@�C��
    sample\handler\SampleQueueHandler.java
  �E�T���v�����s�N���X�̃\�[�X�t�@�C��
    Main.java

���p�ӂ������
  �ENimbus��Jar
  �EJMX��Jar

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -classpath nimbus.jar Main.java sample\handler\SampleQueueHandler.java
   
  �i�Q�jMain�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar Main
