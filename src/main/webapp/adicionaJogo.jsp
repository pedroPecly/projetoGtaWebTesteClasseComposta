<%-- Document : formulario Created on : 14 de dez. de 2023, 13:08:49 Author : Pedro --%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro</title>
    <link rel="stylesheet" href="styles/style_formulario.css">
</head>

<%
    String acao     = request.getParameter("acao");
    String id = request.getParameter("id");
    String idJogo       = request.getParameter("idJogo");
    String nomeJogo     = request.getParameter("nomeJogo");
    String nomeUsuario = request.getParameter("nomeUsuario");
    String senha = request.getParameter("senha");
    String zerado = request.getParameter("zerado");

    if (idJogo == null) {
        nomeJogo = "";
        zerado = "";
    }
%>

<body>
    <% String mensagemErro = (String) request.getAttribute("mensagemErro"); %>
    <% if (mensagemErro != null) { %>
        <script>
            alert("<%= mensagemErro %>");
        </script>
    <% } %>
    <header>
        <nav class="cabecalho">
            <div class="menu">
                <ul>
                    <li class="links"><a href="telaUsuario.jsp?nome=<%=nomeUsuario %>&senha=<%=senha %>">Voltar</a></li>
                    <li class="links"><a href="sobre.html">Sobre</a></li>
                </ul>
            </div>
            <img id="logo" src="imagens/Rockstar_London-Logo.wine.png" alt="Logo Rockstar London">
        </nav>
    </header>
    <main>
        <div id="formulario">
            <form action="JogoSrv" method="POST" autocomplete="off">
                <p>
                    <input type="hidden" name="acao" value="<%=acao %>">
                </p>
                <p>
                    <input type="hidden" name="idJogo" value="<%=idJogo %>">
                </p>
                <p>
                    <input type="hidden" name="id" value="<%=id %>">
                </p>
                <p>
                    <input type="hidden" name="nomeUsuario" value="<%=nomeUsuario %>">
                </p>
                <p>
                    <input type="hidden" name="senha" value="<%=senha %>">
                </p>
                <p>
                    <label for="nomeJogo">Nome do jogo:</label>
                    <input type="text" id="nome" name="nomeJogo" placeholder="Informe o nome do jogo" value="<%=nomeJogo %>" required>
                </p>
                <p>
                    <label for="zerado">Zerado:</label>
                    <input type="checkbox" id="zerado" name="zerado" <% if (zerado != null && zerado.equals("on")) { %> checked <% } %> >
                </p>
                
                <p>
                <div class="botoes">
                    <input type="submit" value="Enviar" id="btnEnviar">
                    <input type="reset" value="limpar" id="btnVoltar">
                </div>
            </form>
        </div>
    </main>
</body>

</html>