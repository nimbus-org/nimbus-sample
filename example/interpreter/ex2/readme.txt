
�T���v���Q

���ڕW
  �R�}���h�x�[�X�ŁAJava���C���^�[�v���b�g���s���Ă݂悤�B

�����\�[�X�ꗗ
  �E�T�[�r�X��`�t�@�C��
    service-definition.xml
  �E�C���^�[�v���^���s����\�[�X�R�[�h�t�@�C��
    sample.txt

���p�ӂ������
  �ENimbus��Jar
  �EJMX��Jar
  �EBeanShell��Jar

�����s
   
  �i�P�j�R�}���h�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar;bsh.jar jp.ossc.nimbus.service.interpreter.BeanShellInterpreterService -servicepath service-definition.xml -file sample.txt
