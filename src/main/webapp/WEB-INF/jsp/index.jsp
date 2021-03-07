<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>Crypto Currency Arbitrage Potential Demo Application</title>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 5px;
  text-align: left;    
}
</style>
</head>
<body>
<table style="margin-left:auto;margin-right:auto;">
<tbody>
<tr>
<td >
  <h2 style="text-align: center;">
    <b>Trade with below Exchanges</b>
    <%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()) %>
  </h2>
  <table>
    <tr>
      <td>
        <b>Currency</b>
      </td>
      <td>
        <b>Buy from exchange with price</b>
      </td>
      <td>
        <b>Sell on exchange with price</b>
      </td>
      <td>
        <b>Profit in %</b>
      </td>
    </tr>
    ${rows}
  </table>
  </td>
</tr>
<tr>
	<td>
		<h2 style="text-align: center;">
    		<b>Current price in Exchanges</b>
    		<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()) %>
  		</h2>
  </td>
</tr>
<tr>
<td>
${values}
</td>
</tr>
</tbody>
</table>
</body>
</html>