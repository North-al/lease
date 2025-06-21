package online.northal.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import online.northal.dto.ApartmentQueryDTO;
import online.northal.result.ActionResult;
import online.northal.service.ApartmentService;
import online.northal.vo.ApartmentItemVo;
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
    @Operation(summary = "获取公寓信息列表")
    public ActionResult<IPage<ApartmentItemVo>> getPage(@RequestParam long page, @RequestParam long limit, ApartmentQueryDTO dto) {
        Page<ApartmentItemVo> voPage = new Page<>(page, limit);
        IPage<ApartmentItemVo> list = this.apartmentService.selectPage(voPage, dto);
        return ActionResult.success(list);
    }


    @PostMapping
    @Operation(summary = "新增公寓信息")
    public ActionResult<Long> create(@RequestBody ApartmentSubmitVo vo) {
        this.apartmentService.add(vo);
        return ActionResult.success(vo.getId(), "新增公寓信息成功");
    }

    @PutMapping
    @Operation(summary = "更新公寓信息")
    public ActionResult<Boolean> update(@RequestBody ApartmentSubmitVo vo) {
        this.apartmentService.edit(vo);
        return ActionResult.success(true, "更新公寓信息成功");
    }
}
