<!DOCTYPE html>
<html lang="en">
      <head>
          <title>Main page</title>
          <jsp:include page = "headers.jsp"/>
     </head>
      <body>

      <jsp:include page = "navigators.jsp"/>

      <p>Today's date: <%= (new java.util.Date()). toLocaleString()

      %></p>
      </body>
</html>