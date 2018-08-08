<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page pageEncoding="Shift_JIS" contentType="text/html; charset=Shift_JIS" %>
<%@ page import="java.sql.*,jp.ossc.nimbus.core.*,jp.ossc.nimbus.service.connection.*" %>
<html>
<head>
  <title>�T���v��</title>
</head>
<body>
<%
    // �T�[�r�X���擾����
    ConnectionFactory factory = (ConnectionFactory)ServiceManagerFactory
        .getServiceObject("ConnectionFactory");
    
    Connection con = null;
    Statement stmt = null;
    try{
        con = factory.getConnection();
        stmt = con.createStatement();
        out.println("�e�[�u���쐬<br>");
        stmt.executeQuery("create table myuser(name varchar(100), age integer, sex char(1))");
        out.println("���R�[�h�}��<br>");
        stmt.executeQuery("insert into myuser(name, age, sex) values('hoge', '20', '0')");
        stmt.executeQuery("insert into myuser(name, age, sex) values('fuga', '25', '1')");
        out.println("����<br>");
        ResultSet rs = stmt.executeQuery("select * from myuser");
        out.println("���O,�N��,����<br>");
        while(rs.next()){
            out.println(rs.getString("name")
                + "," + rs.getString("age")
                + "," + rs.getString("sex") + "<br>");
        }
    }catch(ConnectionFactoryException e){
        e.printStackTrace();
    }catch(SQLException e){
        e.printStackTrace();
    }finally{
        if(stmt != null){
            try{
                out.println("�e�[�u���폜<br>");
                stmt.executeQuery("drop table myuser");
            }catch(SQLException e){
            }
            try{
                stmt.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(con != null){
            try{
                con.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
%>
</body>
</html>
