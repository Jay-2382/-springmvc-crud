<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <html>

    <head>
        <title>Users</title>
    </head>

    <body>
        <h2>User List</h2>
        <a href="${pageContext.request.contextPath}/new"
            style="display:inline-block;padding:8px 18px;background:#1976d2;color:#fff;border-radius:4px;text-decoration:none;margin-right:10px;margin-bottom:10px;">Add
            New</a>
        <a href="${pageContext.request.contextPath}/sort/name"
            style="display:inline-block;padding:8px 18px;background:#1976d2;color:#fff;border-radius:4px;text-decoration:none;margin-right:10px;margin-bottom:10px;">Sort
            by Name</a>
        <a href="${pageContext.request.contextPath}/sort/country"
            style="display:inline-block;padding:8px 18px;background:#1976d2;color:#fff;border-radius:4px;text-decoration:none;margin-right:10px;margin-bottom:10px;">Sort
            by Country</a>
        <form action="${pageContext.request.contextPath}/search/name" method="get" style="display:inline;">
            <input type="text" name="q" placeholder="Search by Name" />
            <input type="submit" value="Search" />
        </form>
        <form action="${pageContext.request.contextPath}/search/country" method="get" style="display:inline;">
            <input type="text" name="q" placeholder="Search by Country" />
            <input type="submit" value="Search" />
        </form>
       
   		 <c:if test="${searching}">
        	<a href="${pageContext.request.contextPath}/" style="display:inline-block;padding:8px 18px;background:#e53935;color:#fff;border-radius:4px;text-decoration:none;margin:10px 0;">Back to All Users</a>
    	</c:if>

        <table
            style="margin: 30px auto; width: 90%; background: #fff; box-shadow: 0 2px 8px rgba(44,62,80,0.08); border-radius: 8px; overflow: hidden; border: none;">
            <tr style="background: #1976d2; color: #fff; border: none;">
                <th style="border: none; text-align: center;">S.No.</th>
                <th style="border: none; text-align: center;">ID</th>
                <th style="border: none; text-align: center;">Name</th>
                <th style="border: none; text-align: center;">Email</th>
                <th style="border: none; text-align: center;">Country</th>
                <th style="border: none; text-align: center;">Actions</th>
            </tr>
            <c:forEach var="u" items="${list}" varStatus="status">
                <tr style="text-align: center; border: none;">
                    <td style="border: none; text-align: center;">${status.index + 1}</td>
                    <td style="border: none; text-align: center;">${u.id}</td>
                    <td style="border: none; text-align: center;">${u.name}</td>
                    <td style="border: none; text-align: center;">${u.email}</td>
                    <td style="border: none; text-align: center;">${u.country}</td>
                    <td style="border: none; text-align: center;">
                        <a href="${pageContext.request.contextPath}/edit/${u.id}"
                            style="display:inline-block;padding:6px 14px;background:#43a047;color:#fff;border-radius:4px;text-decoration:none;margin-right:8px;margin-bottom:4px;">Edit</a>
                        <a href="${pageContext.request.contextPath}/delete/${u.id}"
                            style="display:inline-block;padding:6px 14px;background:#e53935;color:#fff;border-radius:4px;text-decoration:none;margin-bottom:4px;">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>

    </html>