
�T���v���P

���ڕW
 Tomcat��Websocket�𓮂����Ă݂悤

�����\�[�X�ꗗ
  �E�T���v��Web�A�v���P�[�V����
    websocket ��WAR(Web application ARchive)�t�@�C���ꎮ
    
    ��`�t�@�C��
     �Ewebsocket\WEB-INF\web.xml
       Web�A�v���P�[�V�����ݒ�t�@�C��
     �Ewebsocket\WEB-INF\classes\service-definition.list
       �T�[�r�X��`���X�g�t�@�C��
     �Ewebsocket\WEB-INF\classes\service_websocket.xml
       Websocket�T�[�r�X��`�t�@�C��

���p�ӂ������
  �ETomcat�T�[�o
  jar�t�@�C���iwebsocket\WEB-INF\lib�ɔz�u����j
  �Enimbus.jar
  �Enimbus-websocket.jar
  �Elog4j.jar
  �Ecommons-logging.jar
  �Ejavax.websocket-api.jar�i�R���p�C���ɕK�v�j

�����s
  �i�P�j�R���p�C������Bwebsocket\WEB-INF\classes�Ŏ��s����B
      ��F
        javac -classpath nimbus.jar;nimbus-websocket.jar;javax.websocket-api.jar; jp\ossc\nimbus\service\websocket\*.java
   
  �i�Q�jTomcat���N������B
  
  �i�R�jhttp://tomcat�T�[�oIP:�|�[�g/websocket/websocket.html�ɃA�N�Z�X����B

