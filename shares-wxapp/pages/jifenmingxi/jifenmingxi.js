// pages/jifenmingxi/jifenmingxi.js
const app = getApp();
const API = require('../../utils/request.js')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    bonusList: null,
    id: wx.getStorageSync('user').id
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
    // console.log(this.data.id)
    var that = this
  API.getBonusList({
    id: that.data.id
  }).then(res => {
    console.log(res)
    that.setData({
      bonusList: res
    })
    console.log("12345678"+that.data.bonusList)
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

  }
})