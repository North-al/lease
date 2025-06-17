package online.northal.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import online.northal.entity.LabelInfo;
import online.northal.enums.LabelType;
import online.northal.result.ActionResult;
import online.northal.service.LabelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/tags")
@Tag(name = "标签管理", description = "标签相关操作")
public class LabelInfoController {
    @Autowired
    private LabelInfoService labelInfoService;

    @GetMapping
    @Operation(summary = "获取所有标签", description = "返回系统中所有的标签信息")
    public ActionResult<List<LabelInfo>> getAll(@RequestParam(required = false) LabelType type) {
        LambdaQueryWrapper<LabelInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(type != null, LabelInfo::getType, type);
        List<LabelInfo> list = this.labelInfoService.list(queryWrapper);
        return ActionResult.success(list, "获取标签列表成功");
    }

    @PostMapping
    @Operation(summary = "添加或更新标签", description = "添加新的标签或更新现有的标签信息")
    public ActionResult<Boolean> saveOrUpdate(@RequestBody LabelInfo labelInfo) {
        boolean isSaved = this.labelInfoService.saveOrUpdate(labelInfo);
        if (isSaved) {
            return ActionResult.success(true, "保存或更新标签成功");
        } else {
            return ActionResult.fail(false, "保存或更新标签失败");
        }
    }

    @DeleteMapping
    @Operation(summary = "删除标签", description = "根据ID删除指定的标签")
    public ActionResult<Boolean> delete(@RequestParam("id") Long id) {
        boolean isDeleted = this.labelInfoService.removeById(id);
        if (isDeleted) {
            return ActionResult.success(true, "删除标签成功");
        } else {
            return ActionResult.fail(false, "删除标签失败");
        }
    }
}
