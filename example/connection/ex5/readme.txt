
�T���v���T

���ڕW
 POJO��SQL��O/R Mapping���Ă݂悤�B
 SQL��POJO�A�y�т��̃}�b�s���O���w�肵�āAPOJO���f�[�^�x�[�X�ɏ������񂾂�A�f�[�^�x�[�X����POJO�ɒl��ݒ肵�Ă݂悤�B

�����\�[�X�ꗗ
  �E�T�[�r�X��`�t�@�C��
    service-definition.xml
  �E�T���v�����s�N���X�̃\�[�X�t�@�C��
    Main.java

���p�ӂ������
  �ENimbus��Jar
  �EJMX��Jar
  �EJBoss

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -classpath nimbus.jar Main.java
   
  �i�Q�jMain�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar;C:\JBoss-3.2.7\server\default\lib\hsqldb.jar Main
