
�T���v���R

���ڕW
 �Ɩ��t���[�ŁA���R�Ɍ��؂��Ă݂悤�B
 
 �X�V�p�x�̒Ⴂ�}�X�^�̓R�[�h�}�X�^������B
 �܂��A�ǂݎ���ѐ��ۏႷ�邽�߂ɁABeanFlow�̊J�n�_��AOP���g����
 �X���b�h�R���e�L�X�g�ɏ悹�Ă����B
 �}�X�^���g�������؂ł́A���̃R�[�h�}�X�^����擾���Č��؂���悤��
 �ݒ肷��B

�����\�[�X�ꗗ
  �E�T�[�r�X��`�t�@�C��
    service-definition.xml
  �E�T���v�����s�N���X�̃\�[�X�t�@�C��
    Main.java
  �E�T���v��Bean�N���X�̃\�[�X�t�@�C��
    sample\Employee.java
    sample\Family.java

���p�ӂ������
  �ENimbus��Jar
  �EJMX��Jar
  �EJTA��Jar
  �EJMS��Jar
  �Ecommons-jexl��Jar
  �Ecommons-logging��Jar
  �EJBoss

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -classpath nimbus.jar Main.java sample\*.java
   
  �i�Q�jMain�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar;jta.jar;jms.jar;commons-jexl.jar;commons-logging.jar;C:\JBoss-3.2.7\server\default\lib\hsqldb.jar Main
