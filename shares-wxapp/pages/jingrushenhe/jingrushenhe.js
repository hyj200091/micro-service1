// pages/jingrushenhe/jingrushenhe.js
const app = getApp();
const API = require('../../utils/request.js')
Page({
//输入框中的值获取
forName(e){
// console.log(e)
this.data.reason = e.detail.value
// console.log(e.detail.value)
},
 // 点击下拉显示框
 selectTap(){
  this.setData({
   show: !this.data.show
  });
  },
  // 点击下拉列表
  optionTap(e){
  let Index=e.currentTarget.dataset.index;//获取点击的下拉列表的下标
  this.setData({
   index:Index,
   show:!this.data.show
  });
  // 获取到下拉框中的值
  // console.log(this.data.selectData[this.data.index])
  },

  onLoad: function (options) {
   
  },


  /**
   * 页面的初始数据
   */
  data: {
    show:false,//控制下拉列表的显示隐藏，false隐藏、true显示
    selectData:['请选择审核状态','PASS','REJECT'],//下拉列表的数据
    index:0,//选择的下拉列表下标
    shares: null,
    select: true,
    reason: null,
    shareId:null
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      shares: JSON.parse(options.share),
      shareId: JSON.parse(options.share).id
    })

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },

  //进行审核的操作
  submit:function(){
    wx.request({
      url: 'http://localhost:8040/admin/shares/audit/'+this.data.shareId,
      method: "put",
      data:{
        auditStatusEnum: this.data.selectData[this.data.index],
        reason: this.data.reason
      },
      header:{
        'content-type' : 'application/json',
        'X-Token': app.globalData.token
      },
      success(res){
     if(res.statusCode == 200){
       wx.showToast({
         title: '审核通过',
         duration: 2000
       })
     }
     wx.navigateTo({
       url: '../shenghetougao/shenghetougao',
     })
      }
    })
  }
})