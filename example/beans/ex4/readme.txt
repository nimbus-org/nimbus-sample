
�T���v���S

���ڕW
  �ėp�I��Bean�i�f�[�^�Z�b�g�j���R���N���[�g�ȃN���X�ɂ����\�[�X�������������Ă݂悤�B

�����\�[�X�ꗗ
  �E�f�[�^�Z�b�g��`�t�@�C��
    dataset-definition1.xml
    dataset-definition2.xml

���p�ӂ������
  �ENimbus��Jar
  �EJMX��jar

�����s
  �i�P�j�f�[�^�Z�b�g��`�t�@�C���P����\�[�X�𐶐�����B
      ��F
        java -classpath nimbus.jar;jmx.jar -DPACKAGE=sample.beans jp.ossc.nimbus.beans.dataset.DataSetCodeGenerator -v dataset-definition1.xml
  �i�Q�j�R���p�C������B
      ��F
        javac -classpath nimbus.jar sample\beans\*.java
   
  �i�R�j�f�[�^�Z�b�g��`�t�@�C���Q����\�[�X�𐶐�����B
      ��F
        java -classpath .;nimbus.jar;jmx.jar -DPACKAGE=sample.beans jp.ossc.nimbus.beans.dataset.DataSetCodeGenerator -v dataset-definition2.xml
  �i�S�j�R���p�C������B
      ��F
        javac -classpath .;nimbus.jar sample\beans\*.java
