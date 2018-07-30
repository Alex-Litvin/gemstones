package ua.training.servlet;

import ua.training.dao.DBNameTypeGemstoneMock;
import ua.training.model.Gemstone;
import ua.training.model.GemstoneType;
import ua.training.model.StoneName;
import ua.training.model.Transparency;
import ua.training.service.CostCalculatorService;
import ua.training.service.NecklaceServiceImpl;
import ua.training.service.interfaces.CostCalculator;
import ua.training.service.interfaces.NecklaceService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NecklaceServlet extends HttpServlet {
    private NecklaceService necklaceService;
    private CostCalculator costCalculator;

    @Override
    public void init() {
        necklaceService = new NecklaceServiceImpl();
        costCalculator = new CostCalculatorService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("necklace.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StoneName name = StoneName.valueOf(req.getParameter("stone").toUpperCase());
        BigDecimal carat = new BigDecimal(req.getParameter("carat"));
        Transparency transparency = Transparency.valueOf(req.getParameter("transparency").toUpperCase());

        Map<StoneName, GemstoneType> nameTypeMap = new HashMap<>();
        nameTypeMap.put(name, DBNameTypeGemstoneMock.getNameTypeGemstone().get(name));

        Gemstone gemstone = new Gemstone.GemstoneBuilder()
                .setNameTypeMap(nameTypeMap)
                .setCarat(carat)
                .setCaratPrice(name.getCaratPrice())
                .setTotalCost(costCalculator.calcCostOneGemstone(carat, name.getCaratPrice(), transparency.getCostFactor()))
                .setTransparency(transparency)
                .build();

        if (req.getParameter("addGemstone") != null) {
            necklaceService.addGemstoneToNecklace(gemstone);
        }
        if (req.getParameter("createNecklace") != null) {
            List<Gemstone> userGemstone = necklaceService.createNecklace();
            req.setAttribute("necklace", userGemstone);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("necklace.jsp");
        dispatcher.forward(req, resp);
    }
}
