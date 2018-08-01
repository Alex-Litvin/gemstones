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
import java.util.function.Predicate;

import static ua.training.model.Transparency.*;

public class SearcherServlet extends HttpServlet {
    private Searcher searcher;

    @Override
    public void init() {
        searcher = new SearcherService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String transparent = req.getParameter("transparent");
        String semitransparent = req.getParameter("semitransparent");
        String nontransparent = req.getParameter("non_transparent");

        List<Predicate<Transparency>> predicates = new ArrayList<>();
        if (transparent != null) {
            predicates.add(f -> f.equals(TRANSPARENT));
        }
        if (semitransparent != null) {
            predicates.add(s -> s.equals(SEMITRANSPARENT));
        }
        if (nontransparent != null) {
            predicates.add(t -> t.equals(NON_TRANSPARENT));
        }

        List<Gemstone> foundGemstone = searcher.findGemstonesByTransparency(DBNecklaceMock.getDbNecklace().getNecklaces().get(0), predicates);
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
