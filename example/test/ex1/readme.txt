
�T���v���P

���ڕW
 �e�X�g�t���[�����[�N���g���Ă݂悤�B

�����\�[�X�ꗗ
  �E�T�[�r�X��`�t�@�C��
    service-definition.xml

���p�ӂ������
  �ENimbus��Jar
  �Ecommons-httpclient��Jar
  �Ecommons-codec��Jar
  �Ecommons-logging��Jar
  �Ecommons-lang��Jar
  �Ecommons-collections��Jar
  �Evelocity��Jar
  �Ebsh��Jar

�����s
   
  �i�P�jTestRunner�����s����B�iJDK1.5�ȏ���g�p�j
      ��F
        java -classpath nimbus.jar;commons-httpclient.jar;commons-codec.jar;commons-logging.jar;commons-lang.jar;commons-collections.jar;velocity.jar -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.port=1234 -Dcom.sun.management.jmxremote.ssl=false jp.ossc.nimbus.service.test.TestRunner runner.xml service-definition.xml

  �i�Q�jTestSwingRunner�����s����B�iJDK1.6�ȏ���g�p�j
      ��F
        java -classpath nimbus.jar;commons-httpclient.jar;commons-codec.jar;commons-logging.jar;commons-lang.jar;commons-collections.jar;velocity.jar -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.port=1234 -Dcom.sun.management.jmxremote.ssl=false jp.ossc.nimbus.service.test.TestRunner service-definition.xml
