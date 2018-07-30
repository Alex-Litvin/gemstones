package ua.training.servlet;

import ua.training.dao.DBNecklaceMock;
import ua.training.model.Gemstone;
import ua.training.service.SorterService;
import ua.training.service.interfaces.Sorter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SorterServlet extends HttpServlet {
    private Sorter sorter;

    @Override
    public void init() throws ServletException {
        sorter = new SorterService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("sort") != null) {
            List<Gemstone> sortedGemstone = sorter.sortedGemstoneByCost(DBNecklaceMock.getDbNecklace().getNecklaces().get(0));

            req.setAttribute("sortedGemstone", sortedGemstone);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("sorter.jsp");
        dispatcher.forward(req, resp);
    }
}
