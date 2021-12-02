<!DOCTYPE html>
<html lang="en">
<head>
    <title>Developers page</title>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>

<jsp:include page = "navigator.jsp"/>

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
                <th scope="col">Action</th>
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