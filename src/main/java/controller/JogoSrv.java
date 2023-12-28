package controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Jogo;
import model.Perfil;
import model.dao.JogoDaoJpa;
import model.dao.PerfilDaoJpa;

public class JogoSrv extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String acao = request.getParameter("acao");
            String idJogo = request.getParameter("idJogo");
            String id = request.getParameter("id");
            String nomeJogo = request.getParameter("nomeJogo");
            String nomeUsuario = request.getParameter("nomeUsuario");
            String senha = request.getParameter("senha");
            String zerado = request.getParameter("zerado");
            boolean convZerado = zerado != null && zerado.equals("on");

            JogoDaoJpa dao = new JogoDaoJpa();
            PerfilDaoJpa daoPerfil = new PerfilDaoJpa();
            RequestDispatcher rd;
            Jogo j = null;
            switch (acao) {
                case "inclusao":
                    j = new Jogo(nomeJogo, convZerado);
                    dao.incluir(j);
                    Perfil p = daoPerfil.pesquisarPorId(Integer.parseInt(id));
                    List<Jogo> adicionarJogos = p.getJogosFavoritos();
                    adicionarJogos.add(j);
                    p.setJogosFavoritos(adicionarJogos);
                    p.setId(Integer.parseInt(id));
                    daoPerfil.editar(p);

                    rd = request.getRequestDispatcher(
                            "telaJogos.jsp?nomeUsuario=" + nomeUsuario + "&senha=" + senha + "&lista=" + listagem() + "&id=" + id);
                    rd.forward(request, response);
                    break;

                default:
                    break;
            }
        } catch (Exception e) {
        }

    }

    private String listagem() {
        JogoDaoJpa dao = new JogoDaoJpa();
        List<Jogo> lista = null;
        try {
            lista = dao.listar();
        } catch (Exception ex) {
            Logger.getLogger(PerfilSrv.class.getName()).log(Level.SEVERE, null, ex);
        }
        String listaHTML = "";
        for (int i = 0; i < lista.size(); i++) {
            Jogo jogo = null;
            jogo = lista.get(i);
            listaHTML = listaHTML
                    + "<tr>"
                    + "<td>" + (i + 1)
                    + "<td>" + jogo.getNome() + "</td>"
                    //+ "<td>" + jogo.getZerado() + "</td>"
                    + "<td><form action=JogoSrv?acao=pre-edicao method='POST'>"
                    + "<input type='hidden' name='id' value=" + jogo.getId()
                    + "><input type='submit' value=editar id='btnEditar'>" + "</form></td>"
                    + "<td><form action=JogoSrv?acao=exclusao method='POST'>"
                    + "<input type='hidden' name='id' value=" + jogo.getId()
                    + "><input type='submit' value=excluir id='btnExcluir'>" + "</form></td>"
                    + "</tr>";
        }
        return listaHTML;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
