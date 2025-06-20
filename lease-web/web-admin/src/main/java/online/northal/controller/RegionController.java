package online.northal.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import online.northal.entity.City;
import online.northal.entity.District;
import online.northal.entity.Province;
import online.northal.result.ActionResult;
import online.northal.service.CityService;
import online.northal.service.DistrictService;
import online.northal.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/region")
@Tag(name = "地区接口")
public class RegionController {
    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private CityService cityService;

    @Autowired
    private DistrictService districtService;

    // 省份相关接口
    @GetMapping("/province")
    @Operation(summary = "获取省份列表")
    public ActionResult<List<Province>> province() {
        List<Province> list = this.provinceService.list();
        return ActionResult.success(list);
    }

    // 城市相关接口
    @GetMapping("/city")
    @Operation(summary = "获取城市列表")
    public ActionResult<List<City>> city(@RequestParam(value = "provinceId") Long provinceId) {
        if (provinceId == null) {
            return  ActionResult.fail("省份ID不能为空");
        }

        LambdaQueryWrapper<City> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(City::getProvinceId, provinceId);
        return ActionResult.success(this.cityService.list(queryWrapper));
    }

    // 区县相关接口
    @GetMapping("/district")
    @Operation(summary = "获取区县列表")
    public ActionResult<List<District>> district(@RequestParam(value = "cityId") Long cityId) {
        if (cityId == null) {
            return ActionResult.fail("城市ID不能为空");
        }

        LambdaQueryWrapper<District> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(District::getCityId, cityId);
        return ActionResult.success(this.districtService.list(queryWrapper));
    }
}
