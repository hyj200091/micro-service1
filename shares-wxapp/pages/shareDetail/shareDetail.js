// pages/shareDetail/shareDetail.js
const app = getApp();
const API = require('../../utils/request.js')
Page({
  /**
   * 页面的初始数据
   */
  data: {
    share: null,
    userId: null,
    shareId: null
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.data.shareId = JSON.parse(options.share).id
    this.data.userId = wx.getStorageSync('user').id
    // console.log(this.data.shareId)
    // console.log(this.data.userId)
    this.setData({
      share: JSON.parse(options.share)
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
  /**
   * 兑换积分的接口
   */
  exchange(){
    API.exchange({
      userId: this.data.userId,
      shareId: this.data.shareId
    }).then(res =>{
      console.log("123456"+res)
      console.log("打印"+this.data.userId)
      let request = JSON.parse(res)
      if(request.succ === true){
        wx.showToast({
          title: '兑换成功',
          duration : 4000
        })
        // 重新请求用户数据
         wx.request({
         url: 'http://localhost:8040/user/' + wx.getStorageSync('user').id,
           success: res => {
          console.log(res)
          //移除原有的用户缓存数据 存入新的数据
          wx.removeStorageSync('user')
          wx.setStorageSync('user', res.data.data)
          //跳回首页
          wx.switchTab({
            url: '../../pages/index/index',
          })
          }
        })
      }
    })
  }
})