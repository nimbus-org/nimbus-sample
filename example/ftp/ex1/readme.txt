
�T���v���P

���ڕW
 FTP�ʐM�����Ă݂悤�B

�����\�[�X�ꗗ
  �E�T�[�r�X��`�t�@�C��
    service-definition.xml
  �E�T���v�����s�N���X�̃\�[�X�t�@�C��
    Main.java

���p�ӂ������
  �ENimbus��Jar
  �EJMX��Jar
  �Ecommons-net��Jar

�����s
  �i�P�j�R���p�C������B
      ��F
        javac -classpath nimbus.jar Main.java
   
  �i�Q�jMain�N���X�����s����B�i�e�p�����[�^�͊��ɍ��킹�Ďw��j
      ��F
        java -classpath .;nimbus.jar;jmx.jar;commons-net.jar -DHOST=hostname -DPORT=port -DUSER=user -DPASSWORD=pass Main
