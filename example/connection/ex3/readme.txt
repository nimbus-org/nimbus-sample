
�T���v���R

���ڕW
 JDBC�R�l�N�V���������b�v���ċ@�\��t�����Ă݂悤�B
 Connection��Statement�����b�v���āA�W���[�i���ƃ��g���N�X���o�͂���悤�ɂ���B

�����\�[�X�ꗗ
  �E�T�[�r�X��`�t�@�C��
    service-definition.xml
  �E�T���v�����s�N���X�̃\�[�X�t�@�C��
    Main.java

���p�ӂ������
  �ENimbus��Jar
  �EJMX��Jar
  �ELog4J��Jar
  �EJBoss

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -classpath nimbus.jar Main.java
   
  �i�Q�jMain�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar;log4j-X.X.X.jar;C:\JBoss-3.2.7\server\default\lib\hsqldb.jar Main
   
  �i�R�j�W���o�͂Ƀ��g���N�X���o�͂���邱�ƂƁA���s�f�B���N�g����journal.txt���m�F����B
