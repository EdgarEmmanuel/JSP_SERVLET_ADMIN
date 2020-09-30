<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% response.setHeader("Cache-Control", "no-cache , no-store , must-revalidate"); %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="indexRespo.jsp">BANQUE PEUPLE</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="../clients/addIndependant.jsp">ADD INDEPENDANT <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="../clients/addSalarie.jsp">ADD SALARIE</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="../clients/addMoral.jsp">ADD MORAL</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="../comptes/verifyMat.jsp"
        aria-disabled="true">ADD COMPTE</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="../responsable/infoResp.jsp"
        aria-disabled="true">PROFILE</a>
      </li>
       <li class="nav-item">
       <form action="../decon.da" method="post">
       <input type="submit" class="btn btn-primary" value="DECONNEXION"/>
       </form>
        
      </li>
    </ul>
  </div>
</nav>