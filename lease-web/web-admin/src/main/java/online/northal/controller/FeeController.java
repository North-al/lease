package online.northal.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import online.northal.entity.FeeKey;
import online.northal.entity.FeeValue;
import online.northal.mapper.FeeKeyMapper;
import online.northal.result.ActionResult;
import online.northal.service.FeeKeyService;
import online.northal.service.FeeValueService;
import online.northal.vo.FeeKeyWithValueVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/fee")
@Tag(name = "房间杂费管理")
public class FeeController {


    @Autowired
    private FeeKeyService feeKeyService;

    @Autowired
    private FeeValueService feeValueService;

    @GetMapping
    @Operation(summary = "获取房间杂费列表")
    public ActionResult<List<FeeKeyWithValueVo>> getAll() {
        List<FeeKeyWithValueVo> list = this.feeKeyService.getAllFeeKeyWithValue();
        return ActionResult.success(list);
    }

    @GetMapping("/key")
    @Operation(summary = "获取房间杂费的key")
    public ActionResult<List<FeeKey>> getAllFeeKey() {
        List<FeeKey> list = this.feeKeyService.list();
        return ActionResult.success(list);
    }

    @PostMapping("/key")
    @Operation(summary = "添加|更新房间杂费的key")
    public ActionResult<Boolean> saveOrUpdateFeeKey(FeeKey feeKey) {
        boolean isSaved = this.feeKeyService.saveOrUpdate(feeKey);
        return ActionResult.success(isSaved);
    }

    @DeleteMapping("/key/{id}")
    @Operation(summary = "删除房间杂费的key")
    public ActionResult<Boolean> deleteFeeKey(@PathVariable("id") Long id) {
        boolean isDeleted = this.feeKeyService.removeById(id);
        return ActionResult.success(isDeleted);
    }

    @DeleteMapping("/value/{id}")
    @Operation(summary = "删除房间杂费的值")
    public ActionResult<Boolean> deleteFeeValue(@PathVariable("id") Long id) {
        boolean isDeleted = this.feeKeyService.removeById(id);
        return ActionResult.success(isDeleted);
    }

    @PostMapping("/value")
    @Operation(summary = "添加|更新房间杂费的值")
    public ActionResult<Boolean> saveOrUpdateFeeValue(@RequestBody FeeValue feeValue) {
        boolean isSaved = this.feeValueService.saveOrUpdate(feeValue);
        return ActionResult.success(isSaved);
    }

}
