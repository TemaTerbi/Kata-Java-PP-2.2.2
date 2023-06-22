package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import web.dao.CarDao;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CarController {

    private final CarDao carDao;

    public CarController(CarDao carDao) {
        this.carDao = carDao;
    }

    @GetMapping(value = "/cars")
    public String getListCar(Model model, @RequestParam Optional<Integer> count) {
        if (!count.isEmpty()) {
            if (count.orElse(0) < 5) {
                model.addAttribute("carList", carDao.anyCount(count.orElse(0)));
                return "car";
            } else {
                model.addAttribute("carList", carDao.index());
                return "car";
            }
        }
        model.addAttribute("carList", carDao.index());
        return "car";
    }
}
