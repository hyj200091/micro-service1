// pages/shenghetougao/shenghetougao.js
const app = getApp();
const API = require('../../utils/request.js')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    tab: 0,
    shareList:null,
    shareList1:null
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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
  var that = this
  API.getmyshares({
  id: wx.getStorageSync('user').id
}).then(res =>{
  console.log(res)
    that.setData({
      shareList: res.data
    })
})

API.getShare().then(res =>{
  that.setData({
    shareList1: res.data
  })
})
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
    /**
   * 切换tab
   */
  changeTab(e){
    this.setData({
      tab:e.currentTarget.dataset.tab
    })
  },
  /**
   * 进入审核页面
   */
  jingrushenhe(e){
    console.log(e)
    var share = e.currentTarget.dataset.item
    wx.navigateTo({
      url: '../jingrushenhe/jingrushenhe?share='+JSON.stringify(share),
    })
  }
})