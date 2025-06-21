package online.northal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.northal.dto.ApartmentQueryDTO;
import online.northal.entity.*;
import online.northal.enums.GraphItemType;
import online.northal.mapper.ApartmentMapper;
import online.northal.service.*;
import online.northal.vo.ApartmentItemVo;
import online.northal.vo.ApartmentSubmitVo;
import online.northal.vo.GraphVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApartmentServiceImpl extends ServiceImpl<ApartmentMapper, ApartmentInfo> implements ApartmentService {

    @Autowired
    private GraphService graphService;

    @Autowired
    private ApartmentFacilityService apartmentFacilityService;

    @Autowired
    private ApartmentLabelService apartmentLabelService;

    @Autowired
    private ApartmentFeeValueService apartmentFeeValueService;

    @Autowired
    private ApartmentMapper apartmentMapper;

    @Override
    @Transactional
    public void add(ApartmentSubmitVo vo) {
        this.save(vo);
        this.insertApartmentOtherInfo(vo);
    }

    @Override
    @Transactional
    public void edit(ApartmentSubmitVo vo) {
        boolean updated = this.updateById(vo);
        if (updated) {
            this.graphService.remove(new LambdaQueryWrapper<GraphInfo>()
                    .eq(GraphInfo::getItemType, GraphItemType.APARTMENT)
                    .eq(GraphInfo::getItemId, vo.getId())
            );

            // 删除公寓配套信息
            this.apartmentFacilityService.remove(new LambdaQueryWrapper<ApartmentFacility>()
                    .eq(ApartmentFacility::getApartmentId, vo.getId())
            );

            // 删除公寓标签信息
            this.apartmentLabelService.remove(new LambdaQueryWrapper<ApartmentLabel>()
                    .eq(ApartmentLabel::getApartmentId, vo.getId())
            );

            // 删除公寓费用信息
            this.apartmentFeeValueService.remove(new LambdaQueryWrapper<ApartmentFeeValue>()
                    .eq(ApartmentFeeValue::getApartmentId, vo.getId())
            );
        }

        this.insertApartmentOtherInfo(vo);


    }

    @Override
    public IPage<ApartmentItemVo> selectPage(Page<ApartmentItemVo> voPage, ApartmentQueryDTO dto) {
        return this.apartmentMapper.selectByPage(voPage, dto);
    }

    private void insertApartmentOtherInfo(ApartmentSubmitVo vo) {
        // 添加图形信息
        List<GraphVo> graphVoList = vo.getGraphVoList();
        if (!CollectionUtils.isEmpty(graphVoList)) {

            ArrayList<GraphInfo> graphInfoList = new ArrayList<>();
            for (GraphVo graphVo : graphVoList) {
                GraphInfo graphInfo = new GraphInfo();
                graphInfo.setName(graphVo.getName());
                graphInfo.setItemType(GraphItemType.APARTMENT);
                graphInfo.setItemId(vo.getId());
                graphInfo.setUrl(graphVo.getUrl());
                graphInfoList.add(graphInfo);
            }


            this.graphService.saveBatch(graphInfoList);
        }


        // 添加公寓配套信息
        List<Long> facilityInfoIds = vo.getFacilityInfoIds();
        if (!CollectionUtils.isEmpty(facilityInfoIds)) {
            ArrayList<ApartmentFacility> apartmentFacilities = new ArrayList<>();
            for (Long facilityInfoId : facilityInfoIds) {
                ApartmentFacility apartmentFacility = new ApartmentFacility();
                apartmentFacility.setApartmentId(vo.getId());
                apartmentFacility.setFacilityId(facilityInfoId);
                apartmentFacilities.add(apartmentFacility);
            }
            this.apartmentFacilityService.saveBatch(apartmentFacilities);
        }

        // 添加公寓标签信息
        List<Long> labelInfoIds = vo.getLabelIds();
        if (!CollectionUtils.isEmpty(labelInfoIds)) {
            ArrayList<ApartmentLabel> apartmentLabels = new ArrayList<>();
            for (Long labelInfoId : labelInfoIds) {
                ApartmentLabel apartmentLabel = new ApartmentLabel();
                apartmentLabel.setApartmentId(vo.getId());
                apartmentLabel.setLabelId(labelInfoId);
                apartmentLabels.add(apartmentLabel);
            }
            this.apartmentLabelService.saveBatch(apartmentLabels);
        }

        // 添加公寓费用信息
        List<Long> feeValueIds = vo.getFeeValueIds();
        if (!CollectionUtils.isEmpty(feeValueIds)) {
            ArrayList<ApartmentFeeValue> apartmentFeeValues = new ArrayList<>();
            for (Long feeValueId : feeValueIds) {
                ApartmentFeeValue apartmentFeeValue = new ApartmentFeeValue();
                apartmentFeeValue.setApartmentId(vo.getId());
                apartmentFeeValue.setFeeValueId(feeValueId);
                apartmentFeeValues.add(apartmentFeeValue);
            }
            this.apartmentFeeValueService.saveBatch(apartmentFeeValues);
        }
    }
}
