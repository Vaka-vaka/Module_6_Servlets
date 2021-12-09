<!DOCTYPE html>
<html lang="en">
<head>
    <title>viewDevelopersJSP page</title>
    <meta charset="UTF-8">
    <jsp:include page = "headers.jsp"/></head>
</head>
<body>

<jsp:include page = "navigators.jsp"/>

<div class="container">
    <div class="row">
        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group me-2" role="group" aria-label="Second group">
                <a href = "/developersJSP" type="button" class="btn btn-success">Back to developers</a>
            </div>
        </div>
    </div>
        <div class="row">
            <div class="mb-3">
                <label for="id" class="form-label">ID</label>
                <input type="text" class="form-control" value = "{{id}}"
                       id="id" placeholder="id">
            </div>
            <div class="mb-3">
                <label for="name_" class="form-label">Name_</label>
                <input type="text" class="form-control" value = "{{name_}}"
                       id="name_" placeholder="name_">
            </div>
            <div class="mb-3">
                <label for="age" class="form-label">Age</label>
                <input type="text" class="form-control" value = "{{age}}"
                       id="age" placeholder="age">
            </div>
            <div class="mb-3">
                <label for="gender" class="form-label">Gender</label>
                <input type="text" class="form-control" value = "{{gender}}"
                       id="gender" placeholder="gender">
            </div>
            <div class="mb-3">
                <label for="salary" class="form-label">Salary</label>
                <input type="text" class="form-control" value = "{{salary}}"
                       id="salary" placeholder="salary">
            </div>
    </div>
    <div class="row">
        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group me-2" role="group" aria-label="Second group">
                <button onclick="save()" type="button" class="btn btn-primary">Save</button>
            </div>
        </div>
    </div>
</div>
<script>
    let id = document.getElementById('id');
    let name_ = document.getElementById('name_');
    let age = document.getElementById('age');
    let gender = document.getElementById('gender');
    let salary = document.getElementById('salary');

    function save() {
    let body = {
        id: id.value,
        name_: name_.value,
        age: age.value,
        gender: gender.value,
        salary: salary.value,
   }
    fetch('/developersJSP-{{action}}', {
    method: 'POST',
    body: JSON.stringify(body)
    })
    . then( _ => {
        window.location.href = '/developersJSP';
    }
    );
  };
</script>
</body>
</html>