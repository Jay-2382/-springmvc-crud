<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <html>

  <head>
    <title>Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css" />
  </head>

  <body>
    <h2>
      <c:choose>
        <c:when test="${user.id == 0}">Add User</c:when>
        <c:otherwise>Edit User</c:otherwise>
      </c:choose>
    </h2>
    <c:if test="${not empty errorMsg}">
      <div style="color:#e53935;text-align:center;margin-bottom:16px;font-weight:bold;">${errorMsg}</div>
    </c:if>
    <form action="${pageContext.request.contextPath}/save" method="post"
      style="max-width:400px;margin:30px auto 0 auto;padding:24px;background:#fff;border-radius:8px;box-shadow:0 2px 8px rgba(44,62,80,0.08);">
      <input type="hidden" name="id" value="${user.id}" />
      <div style="margin-bottom:16px;">
        Name: <input type="text" name="name" value="${user.name}"
          style="width:80%;padding:6px 10px;border:1px solid #b0bec5;border-radius:4px;" required /><br />
      </div>
      <div style="margin-bottom:16px;">
        Email: <input type="email" name="email" value="${user.email}"
          style="width:80%;padding:6px 10px;border:1px solid #b0bec5;border-radius:4px;" required /><br />
      </div>
      <div style="margin-bottom:16px;">
        Country: <input type="text" name="country" value="${user.country}"
          style="width:80%;padding:6px 10px;border:1px solid #b0bec5;border-radius:4px;" /><br />
      </div>
      <input type="submit" value="Save"
        style="width:100%;background:#1976d2;color:#fff;border:none;border-radius:4px;padding:10px 0;font-size:1em;cursor:pointer;transition:background 0.2s;" />
    </form>
    <div style="text-align:center;margin-top:20px;">
      <a href="${pageContext.request.contextPath}/"
        style="display:inline-block;padding:8px 18px;background:#e53935;color:#fff;border-radius:4px;text-decoration:none;">Back</a>
    </div>
  </body>

  </html>