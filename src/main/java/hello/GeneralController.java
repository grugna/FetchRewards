package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralController {

    @Autowired
    private GeneralService generalService;

    @RequestMapping("/pyramid")
    public Boolean isPyramid(@RequestParam(value="name", defaultValue="World") String name) {
        return generalService.isPyramid(name);
    }
}
