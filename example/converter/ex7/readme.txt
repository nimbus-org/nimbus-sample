
�T���v���V

���ڕW
 XML�X�g���[����C�ӂ̃f�[�^�Z�b�g�ɕϊ����Ă݂悤�B

�����\�[�X�ꗗ
  �E�T���v�����s�N���X�̃\�[�X�t�@�C��
    Main.java
  �E�T���v��XML�t�@�C��
    sample.xml

���p�ӂ������
  �ENimbus��Jar
  �Ecommons-logging��Jar
  �Ecommons-jexl��Jar
  �Ejaxp��Jar�iJDK1.5�ȍ~�͕s�v�j
  �Exalan��Jar�ijavax.xml.xpath.XPathFactory�̎������܂܂����́BJDK1.5�ȍ~�͕s�v�j

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -classpath nimbus.jar Main.java
   
  �i�Q�jMain�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;commons-logging.jar;commons-jexl.jar;jaxp.jar;xalan.jar Main
