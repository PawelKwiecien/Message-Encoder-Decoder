<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Encoding / Decoding Service</title>
</head>
<body>
<p align="center">
<table cellspacing="10" cellpadding="10">
    <form:form action="/encode" modelAttribute="message">
    <tr>
        <th width="300">A simple encoder/decoder</th>
        <th width="300">Input</th>
        <th width="300">Output</th>
    </tr>
    <tr>
        <td valign="top">* Write a message You want to encode or decode in the "Input" window.<br/><br/>
            * Write a key number You want to use for encoding or decoding Your message.<br/><br/>
            * Select a proper method.<br/><br/>
            * Click "Submit" to get Your result.<br/><br/>
            * Don't forget Your key for future decoding Your encoded message. :)
        </td>
        <td valign="top"><form:textarea path="inputMessage" cssStyle="height: 200px; width: 300px; vert-align: top"/></td>
        <td width="300" valign="top">${message.outputMessage}</td>
    </tr>
    <tr>
        <td></td>
        <td align="center">Key value: <form:input path="codingKey" size="5"/>&nbsp;&nbsp;&nbsp;&nbsp;Encode <form:radiobutton path="mode" value="E"/> Decode<form:radiobutton path="mode" value="D"/>
            <br/><br/><input type="submit" value="Submit"></td>
        <td></td>
    </tr>
</table>
</form:form>
</p>
</body>
</html>
