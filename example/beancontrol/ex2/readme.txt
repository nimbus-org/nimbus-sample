
�T���v���Q

���ڕW
 �Ɩ��t���[�̃W���[�i�����o�͂��Ă݂悤�B
 BeanFlowInvokerFactory�T�[�r�X���g���āA�Ɩ��t���[�����s���āA�W���[�i����
 �o�͂��Ă݂悤�B
 �W���[�i���́A���s�f�B���N�g����journal.log�t�@�C���ɏo�͂���B
 
 �O������Ăяo�����t���[�i"Public-"����n�܂�t���[�j�ɂ����A�X���b�h�R��
 �e�L�X�g�������������s����悤�ɁA�C���^�[�Z�v�^�����ށB
 �X���b�h�R���e�L�X�g�̏������ł́A���N�G�X�gID���̔Ԃ��āA�X���b�h�R���e�L
 �X�g�ɏ悹��B
 BeanFlow�t�@�N�g���ɐݒ肳�ꂽ�W���[�i���́ABeanFlow�̏������̃W���[�i����
 �L�^����B���̍ہA���N�G�X�gID���X���b�h�R���e�L�X�g����擾���鎖�ŁA��A
 �̏�����R�t����B

�����\�[�X�ꗗ
  �E�T�[�r�X��`�t�@�C��
    service-definition.xml
  �E�T���v�����s�N���X�̃\�[�X�t�@�C��
    Main.java
  �E�Ɩ��t���[��`�t�@�C��
    flows\flow-definition.xml

���p�ӂ������
  �ENimbus��Jar
  �EJMX��Jar
  �EJTA��Jar
  �EJakarta Commons Jexl��Jar
  �EJakarta Commons Logging��Jar

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -classpath nimbus.jar Main.java
   
  �i�Q�jMain�N���X�����s����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar;jta.jar;commons-jexl-X.X.jar;commons-logging-X.X.X.jar Main
