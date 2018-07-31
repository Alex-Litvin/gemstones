package ua.training.servlet;

import ua.training.dao.DBNecklaceMock;
import ua.training.model.Gemstone;
import ua.training.service.CostCalculatorService;
import ua.training.service.interfaces.CostCalculator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class CostCalculatorServlet extends HttpServlet {
    private CostCalculator costCalculator;

    @Override
    public void init() throws ServletException {
        costCalculator = new CostCalculatorService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("calculatePrice") != null) {
            List<Gemstone> gemstoneList = costCalculator.getGemstoneList(DBNecklaceMock.getDbNecklace().getNecklaces().get(0));
            BigDecimal totalCost = costCalculator.calcCostNecklace(DBNecklaceMock.getDbNecklace().getNecklaces().get(0));

            req.setAttribute("gemstoneList", gemstoneList);
            req.setAttribute("totalCost", totalCost);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("costCalculator.jsp");
        dispatcher.forward(req, resp);
    }
}
