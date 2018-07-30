package ua.training.servlet;

import ua.training.dao.DBNecklaceMock;
import ua.training.model.Gemstone;
import ua.training.model.Transparency;
import ua.training.service.SearcherService;
import ua.training.service.interfaces.Searcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearcherServlet extends HttpServlet {
    private Searcher searcher;

    @Override
    public void init() throws ServletException {
        searcher = new SearcherService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String transparent = req.getParameter("transparent");
        String semitransparent = req.getParameter("semitransparent");
        String nontransparent = req.getParameter("non_transparent");

        List<Transparency> transparencies = new ArrayList<>();
        if (transparent != null) {
            Transparency first = Transparency.fromString(transparent);
            transparencies.add(first);
        }
        if (semitransparent != null) {
            Transparency second = Transparency.fromString(semitransparent);
            transparencies.add(second);
        }
        if (nontransparent != null) {
            Transparency third = Transparency.fromString(nontransparent);
            transparencies.add(third);
        }

        List<Gemstone> foundGemstone = searcher.findGemstonesByTransparency(DBNecklaceMock.getDbNecklace().getNecklaces().get(0), transparencies);
        req.setAttribute("foundGemstone", foundGemstone);

        RequestDispatcher dispatcher = req.getRequestDispatcher("searcher.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("search") != null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("searcher.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
