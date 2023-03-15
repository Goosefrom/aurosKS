<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Knowledge Packages For Set</title>
    <script src="https://cdn.dhtmlx.com/suite/edge/suite.js"></script>
    <link rel="stylesheet" href="https://cdn.dhtmlx.com/suite/edge/suite.css">
    <script>
        let grid;
        function init() {
            grid = new dhx.Grid("grid-container", {
                columns: [
                    { id: "id", header: "ID" },
                    { id: "title", header: "Title" },
                    { id: "description", header: "Description" }
                ],
                selection: "cell",
                autoWidth: true,
                data: ${knowledgePackageListAssignToSet}
            });
        }
        function deleteKnowledgePackageSet(id) {
            if (confirm("Sure?")) {
                var url = "/aurosks/sets/delete?id=" + id;
                $.post(url)
                    .done(function () {
                        window.location.href("/aurosks/sets");
                    });
            }
        }
    </script>
</head>
<body onload="init()">

<h1>Knowledge Packages Assigned To Set Grid</h1>

<div id="grid-container" style="width: 100%; height: 300px;"></div>
<div>
    <a href="${pageContext.request.contextPath}/sets">Back</a>
</div>
<div>
    <a href="${pageContext.request.contextPath}/kpacs">Knowledge Packages</a>
</div>
</body>
</html>