<!DOCTYPE html>
<html lang="en">
<head>
    <title>Developers page</title>
   <jsp:include page = "headers.jsp"/></head>
<body>

<jsp:include page = "navigators.jsp"/>

<div class="container">
    <div class="row">
        <div style="margin: 10px">
            <h2>Developers page</h2>
        </div>
        <div class="row">
            <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                <div class="btn-group me-2" role="group" aria-label="Second group">
                    <a href="/developers-create" type="button" class="btn btn-primary">New</a>
                </div>
            </div>
        </div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name_</th>
                <th scope="col">Age</th>
                <th scope="col">Gender</th>
                <th scope="col">Salary</th>
            </tr>
            </thead>
            <tbody>
            {{tableRows}}
            </tbody>
        </table>
    </div>
</div>

</body>
</html>