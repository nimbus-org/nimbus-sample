
�T���v���Q

���ڕW
 HTTP�ʐM��POST���āAXML���擾���Ă݂悤�B

�����\�[�X�ꗗ
  �E�T�[�r�X��`�t�@�C��
    service-client.xml
    service-server.xml
  �E�T���v�����s�N���X�̃\�[�X�t�@�C��
    Main.java
  �E���O�C�����N�G�X�g�̉����pXML�t�@�C��
    login_response.xml

���p�ӂ������
  �ENimbus��Jar
  �EJMX��Jar�iJDK1.5�ȍ~�͕s�v�j
  �EServlet API��Jar
  �Ecommons-httpclient��Jar
  �Ecommons-logging��Jar
  �Ecommons-codec��Jar
  �Ecommons-jexl��Jar
  �Ejaxp��Jar�iJDK1.5�ȍ~�͕s�v�j
  �Exalan��Jar�ijavax.xml.xpath.XPathFactory�̎������܂܂����́BJDK1.5�ȍ~�͕s�v�j

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -classpath nimbus.jar Main.java
   
  �i�Q�jMain�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar;servletapi.jar;commons-httpclient.jar;commons-logging.jar;commons-codec.jar;commons-jexl.jar;jaxp.jar;xalan.jar Main
