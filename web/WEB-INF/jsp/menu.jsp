<%@page contentType="text/html" pageEncoding="UTF-8"%>
<ul>
    <li><h2>Grupy</h2>
        <ul>
        <c:forEach items="${groups}" var="group" varStatus="status">
            <li>
                <a href="<c:url value="/list.htm?id=${group.id}" />">${group.name}</a>
            </li>
        </c:forEach>
        </ul>
    </li>
    <li><h2>Export danych</h2>
        <ul>
            <li><a href="<c:url value="/report.pdf" />">PDF</a></li>
            <li><a href="<c:url value="/reportxls.xls" />">Excel</a></li>
        </ul>
    </li>
</ul>