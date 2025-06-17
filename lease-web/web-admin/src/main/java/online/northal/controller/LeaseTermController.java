package online.northal.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import online.northal.entity.LeaseTerm;
import online.northal.result.ActionResult;
import online.northal.service.LeaseTermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lease/term")
@Tag(name = "租赁期限管理", description = "租赁期限相关操作")
public class LeaseTermController {

    @Autowired
    private LeaseTermService leaseTermService;

    @GetMapping
    @Operation(summary = "获取所有租赁期限", description = "返回系统中所有的租赁期限信息")
    public ActionResult<List<LeaseTerm>> getAll() {
        List<LeaseTerm> leaseTerms = leaseTermService.list();
        return ActionResult.success(leaseTerms);
    }

    @PostMapping
    @Operation(summary = "添加或更新租赁期限", description = "添加新的租赁期限或更新现有的租赁期限信息")
    public ActionResult<Boolean> saveOrUpdate(@RequestBody LeaseTerm leaseTerm) {
        boolean isSaved = leaseTermService.saveOrUpdate(leaseTerm);
        if (isSaved) {
            return ActionResult.success(true, "保存或更新租赁期限成功");
        } else {
            return ActionResult.fail(false,"保存或更新租赁期限失败");
        }
    }

    @DeleteMapping
    @Operation(summary = "删除租赁期限", description = "根据ID删除指定的租赁期限")
    public ActionResult<Boolean> delete(@RequestParam("id") Long id) {
        boolean isDeleted = leaseTermService.removeById(id);
        if (isDeleted) {
            return ActionResult.success(true, "删除租赁期限成功");
        } else {
            return ActionResult.fail(false, "删除租赁期限失败");
        }
    }
}
