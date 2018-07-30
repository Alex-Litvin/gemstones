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
        String stone = req.getParameter("stone");
        String carat = req.getParameter("carat");
        String transparency = req.getParameter("transparency");

        Map<StoneName, GemstoneType> nameTypeMap = new HashMap<>();
        nameTypeMap.put(StoneName.fromString(stone), DBNameTypeGemstoneMock.getNameTypeGemstone().get(StoneName.fromString(stone)));

        Gemstone gemstone = new Gemstone.GemstoneBuilder()
                .setNameTypeMap(nameTypeMap)
                .setCarat(new BigDecimal(carat))
                .setCaratPrice(StoneName.fromString(stone).getCaratPrice())
                .setTotalCost(costCalculator.calcCostOneGemstone(new BigDecimal(carat), StoneName.fromString(stone).getCaratPrice(), Transparency.fromString(transparency).getCostFactor()))
                .setTransparency(Transparency.fromString(transparency))
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
