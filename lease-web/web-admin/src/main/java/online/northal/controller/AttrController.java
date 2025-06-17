package online.northal.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import online.northal.entity.AttrKey;
import online.northal.entity.AttrValue;
import online.northal.result.ActionResult;
import online.northal.service.AttrKeyService;
import online.northal.service.AttrValueService;
import online.northal.vo.AttrKeyWithValueVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attr")
@Tag(name = "公寓属性管理", description = "属性键管理")
public class AttrController {

    @Autowired
    private AttrKeyService attrKeyService;

    @Autowired
    private AttrValueService attrValueService;

    @GetMapping("/keys")
    @Operation(summary = "获取所有属性键")
    public ActionResult<List<AttrKey>> getKeyAll() {
        return ActionResult.success(attrKeyService.list());
    }

    @PostMapping("/keys")
    @Operation(summary = "新增或更新属性键")
    public ActionResult<Boolean> saveOrUpdateKey(@RequestBody AttrKey attrKey) {
        boolean isSaved = this.attrKeyService.saveOrUpdate(attrKey);
        if (isSaved) {
            return ActionResult.success(true, "保存或更新属性键成功");
        } else {
            return ActionResult.fail(false, "保存或更新属性键失败");
        }
    }

    @DeleteMapping("/keys")
    @Operation(summary = "删除属性键")
    public ActionResult<Boolean> deleteKey(@RequestParam("id") Long id) {
        boolean isDeleted = this.attrKeyService.removeById(id);
        this.attrValueService.remove(
                new com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper<AttrValue>()
                        .eq(AttrValue::getAttrKeyId, id)
        );
        if (isDeleted) {
            return ActionResult.success(true, "删除属性键成功");
        } else {
            return ActionResult.fail(false, "删除属性键失败");
        }
    }

    @PostMapping("/values")
    @Operation(summary = "新增或更新属性值")
    public ActionResult<Boolean> saveOrUpdateValue(@RequestBody AttrValue attrValue) {
        boolean isSaved = this.attrValueService.saveOrUpdate(attrValue);
        if (isSaved) {
            return ActionResult.success(true, "保存或更新属性值成功");
        } else {
            return ActionResult.fail(false, "保存或更新属性值失败");
        }
    }

    @DeleteMapping("/values")
    @Operation(summary = "删除属性值")
    @Transactional
    public ActionResult<Boolean> deleteValue(@RequestParam("id") Long id) {
        if (id == null) {
            return ActionResult.fail(false, "属性值ID不能为空");
        }

        this.attrValueService.remove(
                new com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper<AttrValue>()
                        .eq(AttrValue::getAttrKeyId, id)
        );
        boolean isDeleted = this.attrKeyService.removeById(id);
        return isDeleted
                ? ActionResult.success(true, "删除属性键成功")
                : ActionResult.fail(false, "删除属性键失败");
    }

    @GetMapping
    @Operation(summary = "获取所有属性键及其对应的属性值")
    public ActionResult<List<AttrKeyWithValueVo>> getAllKeysWithValues() {
        List<AttrKeyWithValueVo> attrKeys = attrKeyService.getAllWithValues();
        return ActionResult.success(attrKeys);
    }
}
