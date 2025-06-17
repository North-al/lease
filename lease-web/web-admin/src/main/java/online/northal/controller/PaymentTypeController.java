package online.northal.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import online.northal.entity.PaymentType;
import online.northal.result.ActionResult;
import online.northal.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment/type")
@Tag(name = "付款方式管理", description = "付款方式相关接口")
public class PaymentTypeController {
    @Autowired
    private PaymentTypeService paymentTypeService;

    @GetMapping
    @Operation(summary = "获取所有付款方式")
    public ActionResult<List<PaymentType>> getAll() {
        List<PaymentType> list = this.paymentTypeService.list();
        return ActionResult.success(list);
    }

    @PostMapping
    @Operation(summary = "添加或更新付款方式")
    public ActionResult<PaymentType> saveOrUpdate(@RequestBody PaymentType paymentType) {
        this.paymentTypeService.saveOrUpdate(paymentType);
        return ActionResult.success(paymentType);
    }

    @DeleteMapping
    @Operation(summary = "删除付款方式")
    public ActionResult<Void> delete(@RequestParam Long id) {
        this.paymentTypeService.removeById(id);
        return ActionResult.success();
    }
}
