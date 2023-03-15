<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Knowledge Package Sets</title>
    <script src="https://cdn.dhtmlx.com/suite/edge/suite.js"></script>
    <link rel="stylesheet" href="https://cdn.dhtmlx.com/suite/edge/suite.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        let grid;
        function init() {
            const filterForm = new dhx.Form("grid-filter", {
                cols: [
                    {
                        type: "input",
                        name: "id",
                        label: "ID",
                        padding: "8px",
                        placeholder: "Type something",
                    },
                    {
                        type: "input",
                        name: "title",
                        label: "Title",
                        padding: "8px",
                        placeholder: "Type something",
                    },
                    {
                        padding: "32px 8px 0",
                        cols: [
                            {
                                name: "search-button",
                                type: "button",
                                icon: "mdi mdi-magnify",
                                text: "Search",
                                circle: true
                            },
                            {
                                name: "clear",
                                type: "button",
                                text: "clear",
                                view: "link",
                                padding: "0 16px",
                                circle: true
                            }
                        ]
                    },
                ]
            });
            filterForm.getItem("search-button").events.on("click", function () {
                const filterData = filterForm.getValue();
                grid.data.filter(function (item) {
                    let check = true;
                    for (const key in filterData) {
                        if (filterData[key] !== "" && !RegExp(filterData[key], "i").exec(item[key])) {
                            check = false;
                        }
                    }
                    return check;
                });
            });
            filterForm.getItem("clear").events.on("click", function () {
                filterForm.clear();
                grid.data.filter();
            });

            grid = new dhx.Grid("grid-container", {
                columns: [
                    { id: "id", header: "ID" },
                    { id: "title", header: "Title" },
                    { id: "actions", header: "Actions", align: "center", htmlEnable: true,
                        template: function (e, data) {
                            return "<button onclick='deleteKnowledgePackageSet(" + data.id + ")'>Delete</button>"
                        }
                    }
                ],
                autoWidth: true,
                selection: "row",
                data: ${knowledgePackageSetList},
            });
            grid.events.on("cellDblClick", function (row, column, e) {
                window.location.href = "/aurosks/set/" + row.id;
            });
        }
        function deleteKnowledgePackageSet(id) {
            if (confirm("Sure?")) {
                var url = "/aurosks/sets/delete?id=" + id;
                $.post(url)
                    .done(function () {
                        grid.data.remove(id);
                    });
            }
        }
    </script>
</head>
<body onload="init()">

<h1>Knowledge Package Set Grid</h1>

<div id="grid-filter" style="width: 100%; height: 100px;"></div>
<div id="grid-container" style="width: 100%; height: 300px;"></div>

<div>
    <h1>Add Knowledge Package Set</h1>
    <form:form method="post" action="/aurosks/sets/add" modelAttribute="addRequest">
        <div class="div">
            <label for="title">Title:</label><br>
            <form:input path="title" id="title"/>
        </div>
    <div class="div">
        <form:select path="knowledgePackageIdList">
            <form:options items="${knowledgePackageList}"
            itemLabel="title" itemValue="id" itemType="java.lang.Long"
            multiple="true"/>
        </form:select>
    </div>
    <div class="div">
        <div class="div">
            <input type="submit" title="SUBMIT">
        </div>
    </form:form>
</div>

<div>
    <a href="${pageContext.request.contextPath}/kpacs">Knowledge Packages</a>
</div>
</body>
</html>