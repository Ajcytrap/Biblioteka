<%@include file="./includes/common.jsp"%>
<!DOCTYPE>
<html>
    <head>
        <title>Library</title>

        <link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css" />

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
 <link rel="icon" href="<c:url value="/resources/sowa.jpg" />" type="image/x-icon">
    </head>
    <body>
        <form:form modelAttribute="book">   

            <div style="background-color:#E5B27E; color:black; margin-left:20px; padding:5px;">
                <img src= 'http://i.telegraph.co.uk/multimedia/archive/01830/dublin-trinity-col_1830979b.jpg'
                     style="float:right;width:800px;height:425px;">

                <table id="tableA1">
                    <tr>
                        <th id="table1">Tytul: </th>
                        <td id="table1"><form:input path="tytul" /></td>
                    </tr>
                    <tr>
                        <td id="table1"></td>
                        <td id="table1"><form:errors path="tytul" cssStyle="color: ?#?ff0000?;"/></td> 
                    </tr>
                    <tr>
                        <th id="table1">Opis:</th> 
                        <td id="table1"><form:input path="opis" /></td></tr>
                    <tr>
                        <td id="table1"></td>
                        <td id="table1"><form:errors path="opis" cssStyle="color: ?#?ff0000?;"/></td> 
                    </tr>
                    <tr>
                        <th id="table1">Autor - Imie:</th> 
                        <td id="table1"><form:input path="autor_imie" /></td></tr>
                    <tr>
                        <td id="table1"></td>
                        <td id="table1"><form:errors path="autor_imie" cssStyle="color: ?#?ff0000?;"/></td> 
                    </tr>
                    <tr>
                        <th id="table1">Autor - Nazwisko:</th> 
                        <td id="table1"><form:input path="autor_nazwisko" /></td></tr>
                    <tr>
                        <td id="table1"></td>
                        <td id="table1"><form:errors path="autor_nazwisko" cssStyle="color: ?#?ff0000?;"/></td> 
                    </tr>
                    <tr>
                        <th id="table1">Autor - Pochodzenie:</th> 
                        <td id="table1"><form:input path="autor_pochodzenie" /></td></tr>
                    <tr>
                        <td id="table1"></td>
                        <td id="table1"><form:errors path="autor_pochodzenie" cssStyle="color: ?#?ff0000?;"/></td> 
                    </tr>
                    <tr>
                        <th id="table1">Ilo&#347&#263: </th>
                        <td id="table1"><form:input path="ilosc" required="true" type="number"/></td></tr>
                    <tr>
                       <td id="table1"></td>
                        <td id="table1"><form:errors path="ilosc" cssStyle="color: ?#?ff0000?;"/></td> 
                    </tr>
                    <tr>
                        <th id="table1">Kategoria:</th> 
                        <td id="table1"><form:input path="kategoria" /></td></tr>
                    <tr>
                        <td id="table1"></td>
                        <td id="table1"><form:errors path="kategoria" cssStyle="color: ?#?ff0000?;"/></td> 
                    </tr>

                </table>
                <input type="submit" value="Dodaj" formaction="library"
                       formmethod="post" />
            </div> 
        </form:form>
        <form action="library" method="get">
            <div style="background-color:#B89470 ; color:white; margin-left:20px; padding:20px;">
                <input type="text" value=".*" name="wyrazenie" ><br> 
                <select name="kategoria">
                    <option value="1" >Tytul</option>
                    <option value="2" >Opis</option>
                    <option value="3" >Autor - Imie</option>
                    <option value="4" >Autor - Nazwisko</option>
                    <option value="5" >Autor - Pochodzenie</option>v
                    <option value="7" >Kategoria</option>
                </select><br>
                <input type="submit" name="filter" value="Filtruj" >
            </div> 
        </form>
        <table>
            <tr>
                <td id="Id1"><a href="library?sort=0">Id</a></td>
                <td id="td2"><a href="library?sort=1">Tytul</a></td>
                <td id="td2"><a href="library?sort=1">Opis</a></td>
                <td id="td2"><a href="library?sort=3">Autor - Imie</a></td>
                <td id="td2"><a href="library?sort=4">Autor - Nazwisko</a></td>
                <td id="td2"><a href="library?sort=5">Autor - Pochodzenie</a></td>
                <td id="td2"><a href="library?sort=6">Ilo&#347&#263</a></td>
                <td id="td2"><a href="library?sort=7">Kategoria</a></td>
                <td id="UZ">Usu&#324;</td>
                <td id="UZ">Zmie&#324;</td>
            </tr>
            <c:forEach var="book" items="${library}">
                <tr>
                    <td><c:out value="${book.id+1}" /></td>
                    <td><c:out value="${book.tytul}" /></td>
                    <td><c:out value="${book.opis}" /></td>
                    <td><c:out value="${book.autor_imie}" /></td>
                    <td><c:out value="${book.autor_nazwisko}" /></td>
                    <td><c:out value="${book.autor_pochodzenie}" /></td>
                    <td><c:out value="${book.ilosc}" /></td>
                    <td><c:out value="${book.kategoria}" /></td>
                    <td><a href="library?id=${book.id}&action=delete">Usu&#324;</a></td>
                    <td><a href="libraryzmien?id=${book.id}&action=update">Zmie&#324;</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
