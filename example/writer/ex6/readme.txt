
�T���v���U

���ڕW
 �o�͓��e���������������ďo�͕��@��ς��Ă݂悤�B
 �o�͏����R���\�[���ɏo�͂���B
 �A���A�o�͏��ɗ�O���܂܂��ꍇ�́A�t�@�C��error.txt�ɂ��o�͂���B

�����\�[�X�ꗗ
  �E�T�[�r�X��`�t�@�C��
    service-definition.xml
  �E�T���v�����s�N���X�̃\�[�X�t�@�C��
    Main.java

���p�ӂ������
  �ENimbus��Jar
  �ELog4J��Jar
  �EJMX��Jar
  �EJakarta Commons Jexl��Jar
  �EJakarta Commons Logging��Jar

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -classpath nimbus.jar Main.java
   
  �i�Q�jMain�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;log4j-X.X.X.jar;jmx.jar;commons-jexl-X.X.jar;commons-logging-X.X.X.jar Main
