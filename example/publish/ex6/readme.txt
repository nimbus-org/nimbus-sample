
�T���v���U

���ڕW
 TCP�v���g�R����ɓƎ��ʐM�v���g�R�����쐬���āA�P�Α��ł̃��b�Z�[�W�z�M�����Ă݂悤�B

�����\�[�X�ꗗ
  �E�T�[�r�X��`�t�@�C��
    service-definition.xml
  �E�T���v�����s�N���X�̃\�[�X�t�@�C��
    Main.java
    MyExternalizer.java

���p�ӂ������
  �ENimbus��Jar
  �EJMX��Jar

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -classpath nimbus.jar Main.java MyExternalizer.java
   
  �i�Q�j�C�ӂ̃��b�Z�[�W�𑗐M����Main�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar Main server
   
  �i�R�j�C�ӂ̃��b�Z�[�W����M����N���C�A���g���N������B
      ��F
        java -classpath .;nimbus.jar;jmx.jar Main
   
  �i�S�j�i�R�j�ŋN�������N���C�A���g���̃R���\�[���ŁA��M�̓o�^�Ǝ�M�J�n���s���B
      ��F
        ADD,subject1,key1
        START
   
  �i�T�j�i�Q�j�ŋN�������T�[�o���̃R���\�[���ŔC�ӂ̃��b�Z�[�W�𑗐M����B
      ��F
        subject1,key1,hogehoge
        subject1,key1,fugafuga
