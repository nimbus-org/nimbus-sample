
�T���v���P

���ڕW
 JMX��JVM�̃q�[�v���Ď����Ă݂悤�B

�����\�[�X�ꗗ
  �E�T�[�r�X��`�t�@�C��
    service-definition.xml

���p�ӂ������
  �ENimbus��Jar

�����s
  �i�P�j���s����B�iJDK1.5�ȏ���g�p�j
      ��F
        java -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.port=1234 -Dcom.sun.management.jmxremote.ssl=false -classpath nimbus.jar jp.ossc.nimbus.core.ServiceManagerFactory -server service-definition.xml
