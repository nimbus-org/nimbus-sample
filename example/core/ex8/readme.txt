
�T���v���W

���ڕW
  �T�[�r�X��`�t�@�C�����X�^���h�A���[���ɓǂݍ������B

�����\�[�X�ꗗ
  �E�T�[�r�X��`�t�@�C��
    service-definition.xml
  �E�T�[�r�X�N���X�̃\�[�X�t�@�C��
    sample\service\POJOService.java

���p�ӂ������
  �ENimbus��Jar
  �EJMX��Jar

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -classpath nimbus.jar sample\service\SampleService.java

  �i�Q�j�X�^���h�A���[���ŋN������B
      ��F
        java -classpath .;nimbus.jar;jmx.jar jp.ossc.nimbus.core.ServiceManagerFactory -server service-definition.xml

