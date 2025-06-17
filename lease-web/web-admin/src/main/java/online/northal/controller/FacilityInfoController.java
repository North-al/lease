package online.northal.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import online.northal.entity.FacilityInfo;
import online.northal.enums.LabelType;
import online.northal.result.ActionResult;
import online.northal.service.FacilityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facilities")
@Tag(name = "配套管理", description = "配套相关操作")
public class FacilityInfoController {

    @Autowired
    private FacilityInfoService facilityInfoService;

    @GetMapping
    @Operation(summary = "获取所有配套信息", description = "返回系统中所有的配套信息")
    public ActionResult<List<FacilityInfo>> getAll(
            @RequestParam(required = false) LabelType type
    ) {
        LambdaQueryWrapper<FacilityInfo> queryWrapper = new LambdaQueryWrapper<FacilityInfo>()
                .eq(type != null, FacilityInfo::getType, type);
        List<FacilityInfo> list = this.facilityInfoService.list(queryWrapper);
        return ActionResult.success(list);
    }

    @PostMapping
    @Operation(summary = "添加或更新配套信息", description = "添加新的配套信息或更新现有的配套信息")
    public ActionResult<Boolean> saveOrUpdate(@RequestBody FacilityInfo facilityInfo) {
        boolean isSaved = this.facilityInfoService.saveOrUpdate(facilityInfo);
        if (isSaved) {
            return ActionResult.success(true, "保存或更新配套信息成功");
        } else {
            return ActionResult.fail(false, "保存或更新配套信息失败");
        }
    }

    @DeleteMapping
    @Operation(summary = "删除配套信息", description = "根据ID删除指定的配套信息")
    public ActionResult<Boolean> delete(@RequestParam("id") Long id) {
        boolean isDeleted = this.facilityInfoService.removeById(id);
        if (isDeleted) {
            return ActionResult.success(true, "删除配套信息成功");
        } else {
            return ActionResult.fail(false, "删除配套信息失败");
        }
    }
}
