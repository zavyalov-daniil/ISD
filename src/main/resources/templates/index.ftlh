<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Notes</title>
  <link rel="stylesheet" type="text/css" href="/css/style.x57861.css"/>
</head>
<body>
<h1>Notes</h1>
<h3>Accounts</h3>
<form action="/add" method="post">
  <table border="1px">
    <tr>
      <td>
        <label>Login</label>
        <input type="text" name="login">
      </td>

      <td>
        <input type="submit" value="add Account">
      </td>

    </tr>

  </table>
</form>
<br>
<h2>Account list</h2>
<table border="1px">
  <tr>
    <td>Id</td>
    <td>Login</td>
    <td>Delete from list</td>
  </tr>
  <#list usersList as user>
  <tr>
    <td>${user.id}</td>
    <td>${user.login}</td>
    <td><a href="${'/delete/'+user.id}">Delete</a></td>
  </tr>
  </#list>
</table>
</body>
</html>