<%-- 
    Document   : add
    Created on : 15-sept-2017, 17:39:41
    Author     : Camilo
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="jquery-1.2.6.min.js"></script>
        <meta charset="UTF-8">
        <title>LPA TEMPLATE</title>
       <link href="<c:url value="/resources/Css/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>" rel="stylesheet"/>
    </head>
    <body>
        <div class="container">
        <h1>Administración de novedades</h1>
            <ol class="breadcrumb">
                <li><a href="admNovedades.htm">Home</a></li>
                <li class="active">Agregar</li>
            </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Agregar</div>
                <div class="panel-body">
                    <form:form method="POST" commandName="Novedad">
                        <form:errors path="*" element="div" cssClass="alert alert-danger" />
                        <table width="100%" border="0">
                          <tbody >
                            <tr>
                              <td>
                               	<p>
                            		<form:label path="Nombre">Nombre novedad:</form:label>
                        		</p>
                                <p>
                            		<form:input path="Nombre" cssClass="form-control" style="width:60%" />
                        		</p>
                                <p>
                            		<form:label path="Informacion">Cargar Imagen:</form:label>
                        		</p>
                                <p>
                                <form:form method="post" enctype="multipart/form-data"
                                modelAttribute="uploadedFile" action="fileUpload.htm">
                                    <table>
                                    <tr>
                                            <td><input type="file" name="file" />
                                            </td>
                                    </tr>
                                    </table>
                                </form:form>
                                </p>
                              </td>
                              <td>                  	
                              	<p>
                            		<form:label path="Informacion">Informacion:</form:label>
                        		</p>
                               <p>
                           <form:textarea path="Informacion" cssClass="form-control"  style="width:80%;resize:none" rows="6" />
                        </p>
                              </td>
                            </tr>
                          </tbody>
                        </table>
                        <hr />
                        <input type="submit" value="Crear Novedad" class="btn btn-danger"/>
                          <input type="button" value="Cancelar" class="btn btn-danger" onClick="document.location.href='admNovedades.htm'"/>
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
