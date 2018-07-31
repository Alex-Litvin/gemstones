package ua.training.servlet;

import ua.training.dao.DBNecklaceMock;
import ua.training.model.Gemstone;
import ua.training.service.WeightCalculatorService;
import ua.training.service.interfaces.WeightCalculator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class WeightCalculatorServlet extends HttpServlet {
    private WeightCalculator weightCalculator;

    @Override
    public void init() {
        weightCalculator = new WeightCalculatorService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("calculateWeight") != null) {
            List<Gemstone> gemstoneList = weightCalculator.getGemstoneList(DBNecklaceMock.getDbNecklace().getNecklaces().get(0));
            BigDecimal totalWeight = weightCalculator.calculateWeight(DBNecklaceMock.getDbNecklace().getNecklaces().get(0));

            req.setAttribute("gemstoneList", gemstoneList);
            req.setAttribute("totalWeight", totalWeight);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("weightCalculator.jsp");
        dispatcher.forward(req, resp);
    }
}
