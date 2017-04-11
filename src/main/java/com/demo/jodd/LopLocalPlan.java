package com.demo.jodd;

import java.lang.String;
import java.lang.Integer;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @author chalide
 * @version 1.0 
 * @since  JDK1.6 
 */
public class LopLocalPlan {
    private String id;
    //地接编号
    private String localNo;
    //询价Id
    private String inquiryId;
    //计划人数
    private Integer num;
    //行程Id
    private String tripId;
    //行程名称
    private String tripName;
    // 行程等级
    private String tripTag;
    //
    private String areaId;
    //
    private String areaName;
    //出团日期
    private Date startDate;
    //回团日期
    private Date endDate;
    //计划Id
    private String planId;
    //团号
    private String missonNo;
    //询价组织
    private String inquiryDrpId;
    //询价组织
    private String inquiryDepId;
    //线空计调
    private String offerPriceUserId;
    //报价人组织
    private String offerDrpId;
    //报价方式 1:直营 2：外部地接报价'
    private Integer offerType;
    //根据行程计算有地接的日期的相差天数
    private Integer days;
    //10: 新建 20： 进行中 30：完成
    private String shopingStatus;
    //10:待发送邀请函 11:已发送邀请函 30:确认地接 31:已确认地接 40：待确认结算 41：已确认结算 60：完成 90：待取消 91：取消中 99：已取消
    private String lineStatus;
    //线控发送邀请函状态 10：待调整预控 20 : 任务进行中 90：已调整预控
    private String planChnStatus;
    //收款状态 10：待收款 20：收款待确认 90：已收款
    private String receivablesStatus;
    //退团状态 10：待处理退团 20：处理退团中 90：已处理退团
    private String lineTuituanStatus;
    //控房状态 10：询价中 11：已报价 20：锁房中 21：已锁房 30：索要邀请函中 31：已收到邀请函 40：待发送分房表 41：已发送分房表 50：待确认结算 51：已结算 60：完成90：待取消 91：已转移 99：已取消
    private String hotelStatus;
    //调整整房数状态 10：待调整房数 90：已调整房数
    private Integer hotelNumStatus;
    //控房取消状态 10：待取消 90：已取消 91：已转移
    private Integer hotelCancelStatus;
    //房费付款状态 10：待付款 20：付款待确认 90：已预付
    private Integer hotelPayStatus;
    //控车状态 10：询价中 11：已报价 20：预定中 21：已预订 30：待发送车单31：已发送车单 40：待确认结算 41：已结算  60：完成 90：待取消 91：取消中 99：已取消
    private String carStatus;
    //任务调整状态 10：任务待调整  90：已调整任务
    private Integer carModelStatus;
    //控车取消状态 10：待取消 90：已取消
    private Integer carCancelStatus;
    //车费付款状态 10：待付款 20：付款待确认 30：已预付 90：已付款
    private Integer carPayStatus;
    //外部地接社状态 10：询价中 11：已报价 20：预定中 21：已预订 30：索要邀请函中31：已发送邀请函 40：待发送分房表 41：发送分房表 50 待确认地接 51:已确认地接 60：待确认结算 61：已确认结算 70：完成 90：待取消 91：取消中 99：已取消
    private Integer localStatus;
    //计划状态 5 已开团 ,10：在售中 ,15：锁团中、30：出团中、40：已回团、50：已结团、55：不成团
    private String planStatus;
    //线控计调
    private String planUserId;
    //房控计调
    private String hotelUserId;
    //车控计调
    private String carUserId;
    //购物店计调
    private String shoppingUserId;
    //标间数量
    private Integer standNum;
    //单间数量
    private Integer singleNum;
    //火车票数
    private Integer trainTicketsNum;
    //轮船票数
    private Integer steamerTicketNum;
    //可报金额 在回团后生成
    private BigDecimal reimburseAmount;
    //导游姓名
    private String guideName;
    //导游联系电话
    private String mobile;
    //导游基础资料Id
    private String guideId;
    //分房表附件
    private String roomList;
    //创建用户ID 操团计调
    private String creator;
    //修改用户ID
    private String modifier;
    //创建时间 询价时间
    private Date createDate;
    //修改时间
    private Date modifyDate;
    //备注
    private String remark;
    //导游报账状态 10：未申请 20：申请中 3：已报账
    private Integer reimburseStatus;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocalNo() {
        return localNo;
    }

    public void setLocalNo(String localNo) {
        this.localNo = localNo;
    }

    public String getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(String inquiryId) {
        this.inquiryId = inquiryId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getInquiryDrpId() {
        return inquiryDrpId;
    }

    public void setInquiryDrpId(String inquiryDrpId) {
        this.inquiryDrpId = inquiryDrpId;
    }

    public String getInquiryDepId() {
        return inquiryDepId;
    }

    public void setInquiryDepId(String inquiryDepId) {
        this.inquiryDepId = inquiryDepId;
    }

    public String getOfferPriceUserId() {
        return offerPriceUserId;
    }

    public void setOfferPriceUserId(String offerPriceUserId) {
        this.offerPriceUserId = offerPriceUserId;
    }

    public String getOfferDrpId() {
        return offerDrpId;
    }

    public void setOfferDrpId(String offerDrpId) {
        this.offerDrpId = offerDrpId;
    }

    public String getShopingStatus() {
        return shopingStatus;
    }

    public void setShopingStatus(String shopingStatus) {
        this.shopingStatus = shopingStatus;
    }

    public String getLineStatus() {
        return lineStatus;
    }

    public void setLineStatus(String lineStatus) {
        this.lineStatus = lineStatus;
    }

    public String getPlanChnStatus() {
        return planChnStatus;
    }

    public void setPlanChnStatus(String planChnStatus) {
        this.planChnStatus = planChnStatus;
    }

    public String getReceivablesStatus() {
        return receivablesStatus;
    }

    public void setReceivablesStatus(String receivablesStatus) {
        this.receivablesStatus = receivablesStatus;
    }

    public String getLineTuituanStatus() {
        return lineTuituanStatus;
    }

    public void setLineTuituanStatus(String lineTuituanStatus) {
        this.lineTuituanStatus = lineTuituanStatus;
    }

    public String getHotelStatus() {
        return hotelStatus;
    }

    public void setHotelStatus(String hotelStatus) {
        this.hotelStatus = hotelStatus;
    }

    public Integer getHotelNumStatus() {
        return hotelNumStatus;
    }

    public void setHotelNumStatus(Integer hotelNumStatus) {
        this.hotelNumStatus = hotelNumStatus;
    }

    public Integer getHotelCancelStatus() {
        return hotelCancelStatus;
    }

    public void setHotelCancelStatus(Integer hotelCancelStatus) {
        this.hotelCancelStatus = hotelCancelStatus;
    }

    public Integer getHotelPayStatus() {
        return hotelPayStatus;
    }

    public void setHotelPayStatus(Integer hotelPayStatus) {
        this.hotelPayStatus = hotelPayStatus;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public Integer getCarModelStatus() {
        return carModelStatus;
    }

    public void setCarModelStatus(Integer carModelStatus) {
        this.carModelStatus = carModelStatus;
    }

    public Integer getCarCancelStatus() {
        return carCancelStatus;
    }

    public void setCarCancelStatus(Integer carCancelStatus) {
        this.carCancelStatus = carCancelStatus;
    }

    public Integer getCarPayStatus() {
        return carPayStatus;
    }

    public void setCarPayStatus(Integer carPayStatus) {
        this.carPayStatus = carPayStatus;
    }

    public String getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(String planStatus) {
        this.planStatus = planStatus;
    }

    public String getPlanUserId() {
        return planUserId;
    }

    public void setPlanUserId(String planUserId) {
        this.planUserId = planUserId;
    }

    public String getHotelUserId() {
        return hotelUserId;
    }

    public void setHotelUserId(String hotelUserId) {
        this.hotelUserId = hotelUserId;
    }

    public String getCarUserId() {
        return carUserId;
    }

    public void setCarUserId(String carUserId) {
        this.carUserId = carUserId;
    }

    public String getShoppingUserId() {
        return shoppingUserId;
    }

    public void setShoppingUserId(String shoppingUserId) {
        this.shoppingUserId = shoppingUserId;
    }

    public Integer getStandNum() {
        return standNum;
    }

    public void setStandNum(Integer standNum) {
        this.standNum = standNum;
    }

    public Integer getSingleNum() {
        return singleNum;
    }

    public void setSingleNum(Integer singleNum) {
        this.singleNum = singleNum;
    }

    public Integer getTrainTicketsNum() {
        return trainTicketsNum;
    }

    public void setTrainTicketsNum(Integer trainTicketsNum) {
        this.trainTicketsNum = trainTicketsNum;
    }

    public Integer getSteamerTicketNum() {
        return steamerTicketNum;
    }

    public void setSteamerTicketNum(Integer steamerTicketNum) {
        this.steamerTicketNum = steamerTicketNum;
    }

    public String getRoomList() {
        return roomList;
    }

    public void setRoomList(String roomList) {
        this.roomList = roomList;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getReimburseStatus() {
        return reimburseStatus;
    }

    public void setReimburseStatus(Integer reimburseStatus) {
        this.reimburseStatus = reimburseStatus;
    }

    public BigDecimal getReimburseAmount() {
        return reimburseAmount;
    }

    public void setReimburseAmount(BigDecimal reimburseAmount) {
        this.reimburseAmount = reimburseAmount;
    }

    public String getGuideName() {
        return guideName;
    }

    public void setGuideName(String guideName) {
        this.guideName = guideName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGuideId() {
        return guideId;
    }

    public void setGuideId(String guideId) {
        this.guideId = guideId;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getTripTag() {
        return tripTag;
    }

    public void setTripTag(String tripTag) {
        this.tripTag = tripTag;
    }

    public String getMissonNo() {
        return missonNo;
    }

    public void setMissonNo(String missonNo) {
        this.missonNo = missonNo;
    }

    public Integer getOfferType() {
        return offerType;
    }

    public void setOfferType(Integer offerType) {
        this.offerType = offerType;
    }

    public Integer getLocalStatus() {
        return localStatus;
    }

    public void setLocalStatus(Integer localStatus) {
        this.localStatus = localStatus;
    }
}