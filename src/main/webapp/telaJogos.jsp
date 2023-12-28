<%-- 
    Document   : listagem
    Created on : 22 de dez. de 2023, 14:46:34
    Author     : Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="styles/style_listagem.css">
    </head>

    <%
        String listaHTML = request.getParameter("lista");
        String id = request.getParameter("id");
        String nomeUsuario = request.getParameter("nomeUsuario");
        String senha = request.getParameter("senha");
        String nomeJogo = request.getParameter("nomeJogo");
        String zerado = request.getParameter("zerado");

    %>
    <body>
        <header>
            <nav class="cabecalho">
                <div class="menu">
                    <ul>
                        <li class="links"><a href="telaUsuario.jsp?nome=<%= nomeUsuario%>&senha=<%= senha%>&id=<%=id%>">Voltar</a></li>
                        <li class="links"><a href="sobre.html">Sobre</a></li>
                    </ul>
                </div>
                <img id="logo" src="imagens/Rockstar_London-Logo.wine.png" alt="Logo Rockstar London">
            </nav>
        </header>

        <main>
            <div id="lista">
                <table>
                    <thead>
                        <tr>
                            <th>Posicao</th>
                            <th>Nome</th>
                            
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <%=listaHTML %>
                    </tbody>
                </table>
            </div>
            
            <div id="formulario"> <!-- Novo contêiner -->
                <form action="adicionaJogo.jsp" method="POST" autocomplete="off">
                    <input type="hidden" name="nomeUsuario" value="<%=nomeUsuario %>">
                    <input type="hidden" name="id" value="<%=id %>">
                    <input type="hidden" name="senha" value="<%=senha %>">
                    <input type="hidden" name="acao" id="" value="inclusao">
                    <input type="submit" name="incluir" value="incluir" class="btn">
                </form>
            </div>
        
        </main>
    </body>
</html>
