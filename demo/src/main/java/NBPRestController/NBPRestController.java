package NBPRestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.NBPService;

@RestController
@RequestMapping("/nbp")
public class NBPRestController {
    private final NBPService nbpService;

    public NBPRestController(NBPService nbpService) {
        this.nbpService = nbpService;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Given currency was not found"),
            @ApiResponse(code = 504, message = "Something wrong with server"),
            @ApiResponse(code = 402, message = "You dont have access")
    }
    )
    @ApiOperation(value = "Get average exchange rate of currency from desired date range", notes = "Enter date range and currency code")
    @GetMapping("/{currency}/{startDate}/{endDate}")
    public ResponseEntity<Double> getAvgCurrency(@ApiParam(value = "Currency", example = "pln") @PathVariable String currency,
                                                 @ApiParam(value = "start date", example = "2001-09-11")@PathVariable String startDate,
                                                 @ApiParam(value = "end date", example = "2001-09-12") @PathVariable String endDate) {
        return ResponseEntity.ok(nbpService.getAvgCurrency(currency, startDate, endDate));
    }
}
