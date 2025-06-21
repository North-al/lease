package online.northal.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import online.northal.entity.ApartmentInfo;
import online.northal.result.ActionResult;
import online.northal.service.ApartmentService;
import online.northal.vo.ApartmentSubmitVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apartment")
@Tag(name = "公寓信息管理")
public class ApartmentController {

    @Autowired
    private ApartmentService apartmentService;


    @GetMapping
    public ActionResult getPage() {
        return ActionResult.success();
    }


    @PostMapping
    @Operation(summary = "新增公寓信息")
    public ActionResult<Boolean> create(@RequestBody ApartmentSubmitVo vo) {
        this.apartmentService.create(vo);

        return ActionResult.success();
    }

    @PutMapping
    @Operation(summary = "更新公寓信息")
    public ActionResult<Boolean> update() {
        return ActionResult.success();
    }
}
