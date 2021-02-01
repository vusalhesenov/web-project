<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 1/29/2021
  Time: 9:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <html>
<head>
    <title>Add Procuct</title>
</head>
<body>
<form method="post" action="product">

    <label for="categoryId">Category</label>
    <select id="categoryId" name="Category">
        <option value="1">Meyve</option>
        <option value="2">Terevez</option>
        <option value="3">Elektronik</option>
        <option value="4">Guvenlik</option>
    </select>
    <br>
    <label for="unitId">Unit</label>
    <select id="unitId" name="Unit">
        <option value="1">KG</option>
        <option value="2">EDED</option>
        <option value="3">PAKET</option>
    </select>
    <br>
    <label for="nameId">Name</label>
    <input type="text" name="Name" id="nameId" autocomplete="off"><br>

    <label for="priceId">Price</label>
    <input type="number" name="Price" id="priceId" autocomplete="off"><br>
    <input type="submit" value="send">
</form>

</body>
</html>
