<%@page contentType="text/html" pageEncoding="UTF-8"%>
<ul>
    <li><h2>Użytkownicy</h2>
        <ul>
            <li>
                <a href="<c:url value="/admin/user/list.htm" />">Lista</a>
            </li>
            <li>
                <a href="<c:url value="/admin/user/add.htm" />">Dodaj</a>
            </li>
        </ul>
    </li>
    <li><h2>Zakres pracy</h2>
        <ul>
            <li>
                <a href="<c:url value="/admin/range/list.htm" />">List</a>
            </li>
            <li>
                <a href="<c:url value="/admin/range/add.htm" />">Dodaj</a>
            </li>
        </ul>
    </li>
    <li><h2>Grupy</h2>
        <ul>
            <li>
                <a href="<c:url value="/admin/group/list.htm" />">Lista</a>
            </li>
            <li>
                <a href="<c:url value="/admin/group/add.htm" />">Dodaj</a>
            </li>
        </ul>
    </li>
    <li>
        <ul>
            <li>
                <a href="<c:url value="/j_spring_security_logout" />">Logout</a>
            </li>
        </ul>
    </li>
</ul>