package ua.training.servlet;

import ua.training.dao.DBNameTypeGemstoneMock;
import ua.training.dao.DBNecklaceMock;
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
import java.util.Map;

public class NecklaceServlet extends HttpServlet {
    private NecklaceService necklaceService;
    private CostCalculator costCalculator;
    private DBNecklaceMock dbNecklaceMock;

    @Override
    public void init() {
        necklaceService = new NecklaceServiceImpl();
        costCalculator = new CostCalculatorService();
        dbNecklaceMock = DBNecklaceMock.getDbNecklace();
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

//        System.out.println(stone +" "+carat +" "+ transparency);

        Gemstone gemstone = new Gemstone();

        Map<StoneName, GemstoneType> nameTypeMap = new HashMap<>();
        nameTypeMap.put(StoneName.fromString(stone), DBNameTypeGemstoneMock.getNameTypeGemstone().get(StoneName.fromString(stone)));

        gemstone.setNameTypeMap(nameTypeMap);
        gemstone.setCarat(new BigDecimal(carat));
        gemstone.setCaratPrice(StoneName.fromString(stone).getCaratPrice());
        gemstone.setTransparency(Transparency.fromString(transparency));

        if (req.getParameter("addGemstone") != null) {
            necklaceService.addGemstoneToNecklace(gemstone);
        }
        if (req.getParameter("createNecklace") != null) {
            necklaceService.createNecklace();
        }
        if (req.getParameter("calculatePrice") != null) {
            BigDecimal totalCost = costCalculator.calcCostNecklace(DBNecklaceMock.getDbNecklace().getNecklaces().get(0));
            req.setAttribute("totalCost", totalCost);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("necklace.jsp");
        dispatcher.forward(req, resp);
    }
}
