<%--
  Created by IntelliJ IDEA.
  User: wangxin
  Date: 2018/3/25
  Time: 下午4:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>test</title>
</head>
<body>
      <div style="padding: 20px 20px;">
          <header style="text-align: center">编号： ${userId}</header>

          <section>
              <article>
                  <p>1、霍比特人</p>
                  <p>2、${msg}</p>
                  <p>3、${random.sport}</p>
                  <p>3、${random.number}</p>
                  <p>4、${uuid}</p>
              </article>

          </section>

          <footer style="position: absolute;
    bottom: 20px;">king 第一版</footer>
      </div>
</body>
</html>